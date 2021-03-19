package com.leonfriedrichsen.tasks.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TasksDao_Impl implements TasksDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TasksEntity> __insertionAdapterOfTasksEntity;

  private final EntityDeletionOrUpdateAdapter<TasksEntity> __updateAdapterOfTasksEntity;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public TasksDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTasksEntity = new EntityInsertionAdapter<TasksEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tasks` (`id`,`task`,`date`,`isDone`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TasksEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getTask() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTask());
        }
        stmt.bindLong(3, value.getDate());
        final int _tmp;
        _tmp = value.isDone() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__updateAdapterOfTasksEntity = new EntityDeletionOrUpdateAdapter<TasksEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tasks` SET `id` = ?,`task` = ?,`date` = ?,`isDone` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TasksEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getTask() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTask());
        }
        stmt.bindLong(3, value.getDate());
        final int _tmp;
        _tmp = value.isDone() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tasks WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final TasksEntity tasksEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTasksEntity.insert(tasksEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final TasksEntity tasksEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTasksEntity.handle(tasksEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public LiveData<List<TasksEntity>> tasks() {
    final String _sql = "SELECT * FROM tasks ORDER BY date";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tasks"}, false, new Callable<List<TasksEntity>>() {
      @Override
      public List<TasksEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTask = CursorUtil.getColumnIndexOrThrow(_cursor, "task");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "isDone");
          final List<TasksEntity> _result = new ArrayList<TasksEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TasksEntity _item;
            final String _tmpTask;
            _tmpTask = _cursor.getString(_cursorIndexOfTask);
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            _item = new TasksEntity(_tmpTask,_tmpDate,_tmpIsDone);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
