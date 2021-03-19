package com.leonfriedrichsen.tasks.databinding;
import com.leonfriedrichsen.tasks.R;
import com.leonfriedrichsen.tasks.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BottomSheetAddTaskBindingImpl extends BottomSheetAddTaskBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.bottomSheetSliderView, 3);
        sViewsWithIds.put(R.id.titleTextView, 4);
        sViewsWithIds.put(R.id.deleteTaskButton, 5);
        sViewsWithIds.put(R.id.taskTextInputLayout, 6);
        sViewsWithIds.put(R.id.requiredTextView, 7);
        sViewsWithIds.put(R.id.datePicker, 8);
        sViewsWithIds.put(R.id.addTextView, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener taskTextInputEditTextandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.baseObservable.task
            //         is viewModel.baseObservable.setTask((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(taskTextInputEditText);
            // localize variables for thread safety
            // viewModel.baseObservable
            com.leonfriedrichsen.tasks.viewModel.baseObservable.TasksBaseObservable viewModelBaseObservable = null;
            // viewModel
            com.leonfriedrichsen.tasks.viewModel.TasksViewModel viewModel = mViewModel;
            // viewModel.baseObservable.task
            java.lang.String viewModelBaseObservableTask = null;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.baseObservable != null
            boolean viewModelBaseObservableJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelBaseObservable = viewModel.getBaseObservable();

                viewModelBaseObservableJavaLangObjectNull = (viewModelBaseObservable) != (null);
                if (viewModelBaseObservableJavaLangObjectNull) {




                    viewModelBaseObservable.setTask(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public BottomSheetAddTaskBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private BottomSheetAddTaskBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.card.MaterialCardView) bindings[2]
            , (android.widget.TextView) bindings[9]
            , (android.view.View) bindings[3]
            , (android.widget.DatePicker) bindings[8]
            , (android.widget.ImageButton) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            , (com.google.android.material.textfield.TextInputLayout) bindings[6]
            , (android.widget.TextView) bindings[4]
            );
        this.addCardView.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.taskTextInputEditText.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.leonfriedrichsen.tasks.viewModel.TasksViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.leonfriedrichsen.tasks.viewModel.TasksViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelBaseObservable((com.leonfriedrichsen.tasks.viewModel.baseObservable.TasksBaseObservable) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelBaseObservable(com.leonfriedrichsen.tasks.viewModel.baseObservable.TasksBaseObservable ViewModelBaseObservable, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.task) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        boolean viewModelBaseObservableTaskJavaLangObjectNull = false;
        com.leonfriedrichsen.tasks.viewModel.baseObservable.TasksBaseObservable viewModelBaseObservable = null;
        boolean viewModelBaseObservableTaskEmpty = false;
        float viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNullFloat075fFloat1f = 0f;
        boolean viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNullBooleanFalseBooleanTrue = false;
        java.lang.String viewModelBaseObservableTask = null;
        boolean viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNull = false;
        com.leonfriedrichsen.tasks.viewModel.TasksViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {



                if (viewModel != null) {
                    // read viewModel.baseObservable
                    viewModelBaseObservable = viewModel.getBaseObservable();
                }
                updateRegistration(0, viewModelBaseObservable);


                if (viewModelBaseObservable != null) {
                    // read viewModel.baseObservable.task
                    viewModelBaseObservableTask = viewModelBaseObservable.getTask();
                }


                if (viewModelBaseObservableTask != null) {
                    // read viewModel.baseObservable.task.empty
                    viewModelBaseObservableTaskEmpty = viewModelBaseObservableTask.isEmpty();
                }
            if((dirtyFlags & 0xfL) != 0) {
                if(viewModelBaseObservableTaskEmpty) {
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x100L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x100L) != 0) {

                // read viewModel.baseObservable.task == null
                viewModelBaseObservableTaskJavaLangObjectNull = (viewModelBaseObservableTask) == (null);
        }

        if ((dirtyFlags & 0xfL) != 0) {

                // read viewModel.baseObservable.task.empty ? true : viewModel.baseObservable.task == null
                viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNull = ((viewModelBaseObservableTaskEmpty) ? (true) : (viewModelBaseObservableTaskJavaLangObjectNull));
            if((dirtyFlags & 0xfL) != 0) {
                if(viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNull) {
                        dirtyFlags |= 0x20L;
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x10L;
                        dirtyFlags |= 0x40L;
                }
            }


                // read viewModel.baseObservable.task.empty ? true : viewModel.baseObservable.task == null ? 0.75f : 1f
                viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNullFloat075fFloat1f = ((viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNull) ? (0.75f) : (1f));
                // read viewModel.baseObservable.task.empty ? true : viewModel.baseObservable.task == null ? false : true
                viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNullBooleanFalseBooleanTrue = ((viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNull) ? (false) : (true));
        }
        // batch finished
        if ((dirtyFlags & 0xfL) != 0) {
            // api target 1

            this.addCardView.setClickable(viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNullBooleanFalseBooleanTrue);
            this.addCardView.setFocusable(viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNullBooleanFalseBooleanTrue);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.taskTextInputEditText, viewModelBaseObservableTask);
            // api target 11
            if(getBuildSdkInt() >= 11) {

                this.addCardView.setAlpha(viewModelBaseObservableTaskEmptyBooleanTrueViewModelBaseObservableTaskJavaLangObjectNullFloat075fFloat1f);
            }
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.taskTextInputEditText, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, taskTextInputEditTextandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.baseObservable
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): viewModel.baseObservable.task
        flag 3 (0x4L): null
        flag 4 (0x5L): viewModel.baseObservable.task.empty ? true : viewModel.baseObservable.task == null ? 0.75f : 1f
        flag 5 (0x6L): viewModel.baseObservable.task.empty ? true : viewModel.baseObservable.task == null ? 0.75f : 1f
        flag 6 (0x7L): viewModel.baseObservable.task.empty ? true : viewModel.baseObservable.task == null ? false : true
        flag 7 (0x8L): viewModel.baseObservable.task.empty ? true : viewModel.baseObservable.task == null ? false : true
        flag 8 (0x9L): viewModel.baseObservable.task.empty ? true : viewModel.baseObservable.task == null
        flag 9 (0xaL): viewModel.baseObservable.task.empty ? true : viewModel.baseObservable.task == null
    flag mapping end*/
    //end
}