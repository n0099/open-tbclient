package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ChipGroup extends FlowLayout {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: DEF_STYLE_RES */
    public static final int obfuscated_res_0x7f10035c = 2131755868;
    public transient /* synthetic */ FieldHolder $fh;
    @IdRes
    public int checkedId;
    public final CheckedStateTracker checkedStateTracker;
    @Dimension
    public int chipSpacingHorizontal;
    @Dimension
    public int chipSpacingVertical;
    @Nullable
    public OnCheckedChangeListener onCheckedChangeListener;
    @NonNull
    public PassThroughHierarchyChangeListener passThroughListener;
    public boolean protectFromCheckedChange;
    public boolean selectionRequired;
    public boolean singleSelection;

    /* renamed from: com.google.android.material.chip.ChipGroup$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChipGroup this$0;

        public CheckedStateTracker(ChipGroup chipGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chipGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = chipGroup;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) || this.this$0.protectFromCheckedChange) {
                return;
            }
            if (this.this$0.getCheckedChipIds().isEmpty() && this.this$0.selectionRequired) {
                this.this$0.setCheckedStateForView(compoundButton.getId(), true);
                this.this$0.setCheckedId(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (z) {
                if (this.this$0.checkedId != -1 && this.this$0.checkedId != id && this.this$0.singleSelection) {
                    ChipGroup chipGroup = this.this$0;
                    chipGroup.setCheckedStateForView(chipGroup.checkedId, false);
                }
                this.this$0.setCheckedId(id);
            } else if (this.this$0.checkedId == id) {
                this.this$0.setCheckedId(-1);
            }
        }

        public /* synthetic */ CheckedStateTracker(ChipGroup chipGroup, AnonymousClass1 anonymousClass1) {
            this(chipGroup);
        }
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
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
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(ChipGroup chipGroup, @IdRes int i);
    }

    /* loaded from: classes4.dex */
    public class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
        public final /* synthetic */ ChipGroup this$0;

        public PassThroughHierarchyChangeListener(ChipGroup chipGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chipGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = chipGroup;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
                if (view2 == this.this$0 && (view3 instanceof Chip)) {
                    if (view3.getId() == -1) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            hashCode = View.generateViewId();
                        } else {
                            hashCode = view3.hashCode();
                        }
                        view3.setId(hashCode);
                    }
                    ((Chip) view3).setOnCheckedChangeListenerInternal(this.this$0.checkedStateTracker);
                }
                ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
                if (onHierarchyChangeListener != null) {
                    onHierarchyChangeListener.onChildViewAdded(view2, view3);
                }
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) {
                if (view2 == this.this$0 && (view3 instanceof Chip)) {
                    ((Chip) view3).setOnCheckedChangeListenerInternal(null);
                }
                ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
                if (onHierarchyChangeListener != null) {
                    onHierarchyChangeListener.onChildViewRemoved(view2, view3);
                }
            }
        }

        public /* synthetic */ PassThroughHierarchyChangeListener(ChipGroup chipGroup, AnonymousClass1 anonymousClass1) {
            this(chipGroup);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-180384705, "Lcom/google/android/material/chip/ChipGroup;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-180384705, "Lcom/google/android/material/chip/ChipGroup;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChipGroup(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private int getChipCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (getChildAt(i2) instanceof Chip) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i) == null) {
            setCheckedId(i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedStateForView(@IdRes int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            View findViewById = findViewById(i);
            if (findViewById instanceof Chip) {
                this.protectFromCheckedChange = true;
                ((Chip) findViewById).setChecked(z);
                this.protectFromCheckedChange = false;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, layoutParams) == null) {
            if (view2 instanceof Chip) {
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    int i2 = this.checkedId;
                    if (i2 != -1 && this.singleSelection) {
                        setCheckedStateForView(i2, false);
                    }
                    setCheckedId(chip.getId());
                }
            }
            super.addView(view2, i, layoutParams);
        }
    }

    public void check(@IdRes int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || i == (i2 = this.checkedId)) {
            return;
        }
        if (i2 != -1 && this.singleSelection) {
            setCheckedStateForView(i2, false);
        }
        if (i != -1) {
            setCheckedStateForView(i, true);
        }
        setCheckedId(i);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) ? super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams) : invokeL.booleanValue;
    }

    public void clearCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.protectFromCheckedChange = true;
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof Chip) {
                    ((Chip) childAt).setChecked(false);
                }
            }
            this.protectFromCheckedChange = false;
            setCheckedId(-1);
        }
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new LayoutParams(-2, -2) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @IdRes
    public int getCheckedChipId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.singleSelection) {
                return this.checkedId;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                    arrayList.add(Integer.valueOf(childAt.getId()));
                    if (this.singleSelection) {
                        return arrayList;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.chipSpacingHorizontal : invokeV.intValue;
    }

    @Dimension
    public int getChipSpacingVertical() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.chipSpacingVertical : invokeV.intValue;
    }

    public int getIndexOfChip(@Nullable View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, view2)) == null) {
            if (view2 instanceof Chip) {
                int i = 0;
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    if (getChildAt(i2) instanceof Chip) {
                        if (((Chip) getChildAt(i2)) == view2) {
                            return i;
                        }
                        i++;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean isSelectionRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.selectionRequired : invokeV.booleanValue;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean isSingleLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? super.isSingleLine() : invokeV.booleanValue;
    }

    public boolean isSingleSelection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.singleSelection : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onFinishInflate();
            int i = this.checkedId;
            if (i != -1) {
                setCheckedStateForView(i, true);
                setCheckedId(this.checkedId);
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCount(), isSingleLine() ? getChipCount() : -1, false, isSingleSelection() ? 1 : 2));
        }
    }

    public void setChipSpacing(@Dimension int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            setChipSpacingHorizontal(i);
            setChipSpacingVertical(i);
        }
    }

    public void setChipSpacingHorizontal(@Dimension int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || this.chipSpacingHorizontal == i) {
            return;
        }
        this.chipSpacingHorizontal = i;
        setItemSpacing(i);
        requestLayout();
    }

    public void setChipSpacingHorizontalResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
        }
    }

    public void setChipSpacingResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            setChipSpacing(getResources().getDimensionPixelOffset(i));
        }
    }

    public void setChipSpacingVertical(@Dimension int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || this.chipSpacingVertical == i) {
            return;
        }
        this.chipSpacingVertical = i;
        setLineSpacing(i);
        requestLayout();
    }

    public void setChipSpacingVerticalResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
        }
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, drawable) == null) {
            throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
        }
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, drawable) == null) {
            throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
        }
    }

    @Deprecated
    public void setFlexWrap(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onCheckedChangeListener) == null) {
            this.onCheckedChangeListener = onCheckedChangeListener;
        }
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onHierarchyChangeListener) == null) {
            this.passThroughListener.onHierarchyChangeListener = onHierarchyChangeListener;
        }
    }

    public void setSelectionRequired(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.selectionRequired = z;
        }
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
        }
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
        }
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            super.setSingleLine(z);
        }
    }

    public void setSingleSelection(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || this.singleSelection == z) {
            return;
        }
        this.singleSelection = z;
        clearCheck();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040133);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.checkedId = i;
            OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
            if (onCheckedChangeListener != null && this.singleSelection && z) {
                onCheckedChangeListener.onCheckedChanged(this, i);
            }
        }
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public void setSingleLine(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            setSingleLine(getResources().getBoolean(i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipGroup(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, obfuscated_res_0x7f10035c), attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.checkedStateTracker = new CheckedStateTracker(this, null);
        this.passThroughListener = new PassThroughHierarchyChangeListener(this, null);
        this.checkedId = -1;
        this.protectFromCheckedChange = false;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, new int[]{R.attr.obfuscated_res_0x7f04012a, R.attr.obfuscated_res_0x7f04013b, R.attr.obfuscated_res_0x7f04013c, R.attr.obfuscated_res_0x7f04013d, R.attr.obfuscated_res_0x7f040587, R.attr.obfuscated_res_0x7f0405a6, R.attr.obfuscated_res_0x7f0405a7}, i, obfuscated_res_0x7f10035c, new int[0]);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        setChipSpacingHorizontal(obtainStyledAttributes.getDimensionPixelOffset(2, dimensionPixelOffset));
        setChipSpacingVertical(obtainStyledAttributes.getDimensionPixelOffset(3, dimensionPixelOffset));
        setSingleLine(obtainStyledAttributes.getBoolean(5, false));
        setSingleSelection(obtainStyledAttributes.getBoolean(6, false));
        setSelectionRequired(obtainStyledAttributes.getBoolean(4, false));
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (resourceId != -1) {
            this.checkedId = resourceId;
        }
        obtainStyledAttributes.recycle();
        super.setOnHierarchyChangeListener(this.passThroughListener);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public void setSingleSelection(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            setSingleSelection(getResources().getBoolean(i));
        }
    }
}
