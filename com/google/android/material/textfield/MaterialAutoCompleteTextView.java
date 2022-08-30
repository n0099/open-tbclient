package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes7.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_ITEMS_MEASURED = 15;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final AccessibilityManager accessibilityManager;
    @NonNull
    public final ListPopupWindow modalListPopup;
    @NonNull
    public final Rect tempRect;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialAutoCompleteTextView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    private TextInputLayout findTextInputLayoutAncestor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof TextInputLayout) {
                    return (TextInputLayout) parent;
                }
            }
            return null;
        }
        return (TextInputLayout) invokeV.objValue;
    }

    private int measureContentWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            ListAdapter adapter = getAdapter();
            TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
            int i = 0;
            if (adapter == null || findTextInputLayoutAncestor == null) {
                return 0;
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
            int min = Math.min(adapter.getCount(), Math.max(0, this.modalListPopup.getSelectedItemPosition()) + 15);
            View view2 = null;
            int i2 = 0;
            for (int max = Math.max(0, min - 15); max < min; max++) {
                int itemViewType = adapter.getItemViewType(max);
                if (itemViewType != i) {
                    view2 = null;
                    i = itemViewType;
                }
                view2 = adapter.getView(max, view2, findTextInputLayoutAncestor);
                if (view2.getLayoutParams() == null) {
                    view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                }
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view2.getMeasuredWidth());
            }
            Drawable background = this.modalListPopup.getBackground();
            if (background != null) {
                background.getPadding(this.tempRect);
                Rect rect = this.tempRect;
                i2 += rect.left + rect.right;
            }
            return i2 + findTextInputLayoutAncestor.getEndIconView().getMeasuredWidth();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.material.textfield.MaterialAutoCompleteTextView */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ListAdapter & Filterable> void updateText(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, obj) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                setText(convertSelectionToString(obj), false);
                return;
            }
            ListAdapter adapter = getAdapter();
            setAdapter(null);
            setText(convertSelectionToString(obj));
            setAdapter(adapter);
        }
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
            if (findTextInputLayoutAncestor != null && findTextInputLayoutAncestor.isProvidingHint()) {
                return findTextInputLayoutAncestor.getHint();
            }
            return super.getHint();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
            if (findTextInputLayoutAncestor != null && findTextInputLayoutAncestor.isProvidingHint() && super.getHint() == null && ManufacturerUtils.isMeizuDevice()) {
                setHint("");
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
                setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth()), View.MeasureSpec.getSize(i)), getMeasuredHeight());
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            super.setAdapter(t);
            this.modalListPopup.setAdapter(getAdapter());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (getInputType() == 0 && (accessibilityManager = this.accessibilityManager) != null && accessibilityManager.isTouchExplorationEnabled()) {
                this.modalListPopup.show();
            } else {
                super.showDropDown();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f0400a5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, 0), attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.tempRect = new Rect();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, new int[]{16843296}, i, R.style.obfuscated_res_0x7f1002c8, new int[0]);
        if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.modalListPopup = listPopupWindow;
        listPopupWindow.setModal(true);
        this.modalListPopup.setAnchorView(this);
        this.modalListPopup.setInputMethodMode(2);
        this.modalListPopup.setAdapter(getAdapter());
        this.modalListPopup.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.google.android.material.textfield.MaterialAutoCompleteTextView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MaterialAutoCompleteTextView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i4, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i4), Long.valueOf(j)}) == null) {
                    this.this$0.updateText(i4 < 0 ? this.this$0.modalListPopup.getSelectedItem() : this.this$0.getAdapter().getItem(i4));
                    AdapterView.OnItemClickListener onItemClickListener = this.this$0.getOnItemClickListener();
                    if (onItemClickListener != null) {
                        if (view2 == null || i4 < 0) {
                            view2 = this.this$0.modalListPopup.getSelectedView();
                            i4 = this.this$0.modalListPopup.getSelectedItemPosition();
                            j = this.this$0.modalListPopup.getSelectedItemId();
                        }
                        onItemClickListener.onItemClick(this.this$0.modalListPopup.getListView(), view2, i4, j);
                    }
                    this.this$0.modalListPopup.dismiss();
                }
            }
        });
        obtainStyledAttributes.recycle();
    }
}
