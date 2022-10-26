package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MarginLayoutParamsCompat;
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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int DEF_STYLE_RES;
    public static final String LOG_TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public int checkedId;
    public final CheckedStateTracker checkedStateTracker;
    public Integer[] childOrder;
    public final Comparator childOrderComparator;
    public final LinkedHashSet onButtonCheckedListeners;
    public final List originalCornerData;
    public final PressedStateTracker pressedStateTracker;
    public boolean selectionRequired;
    public boolean singleSelection;
    public boolean skipCheckedStateTracker;

    /* loaded from: classes7.dex */
    public interface OnButtonCheckedListener {
        void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z);
    }

    /* loaded from: classes7.dex */
    public class CheckedStateTracker implements MaterialButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MaterialButtonToggleGroup this$0;

        public CheckedStateTracker(MaterialButtonToggleGroup materialButtonToggleGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {materialButtonToggleGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = materialButtonToggleGroup;
        }

        @Override // com.google.android.material.button.MaterialButton.OnCheckedChangeListener
        public void onCheckedChanged(MaterialButton materialButton, boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, materialButton, z) != null) || this.this$0.skipCheckedStateTracker) {
                return;
            }
            if (this.this$0.singleSelection) {
                MaterialButtonToggleGroup materialButtonToggleGroup = this.this$0;
                if (z) {
                    i = materialButton.getId();
                } else {
                    i = -1;
                }
                materialButtonToggleGroup.checkedId = i;
            }
            if (this.this$0.updateCheckedStates(materialButton.getId(), z)) {
                this.this$0.dispatchOnButtonChecked(materialButton.getId(), materialButton.isChecked());
            }
            this.this$0.invalidate();
        }
    }

    /* loaded from: classes7.dex */
    public class CornerData {
        public static /* synthetic */ Interceptable $ic;
        public static final CornerSize noCorner;
        public transient /* synthetic */ FieldHolder $fh;
        public CornerSize bottomLeft;
        public CornerSize bottomRight;
        public CornerSize topLeft;
        public CornerSize topRight;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1232733977, "Lcom/google/android/material/button/MaterialButtonToggleGroup$CornerData;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1232733977, "Lcom/google/android/material/button/MaterialButtonToggleGroup$CornerData;");
                    return;
                }
            }
            noCorner = new AbsoluteCornerSize(0.0f);
        }

        public CornerData(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cornerSize, cornerSize2, cornerSize3, cornerSize4};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.topLeft = cornerSize;
            this.topRight = cornerSize3;
            this.bottomRight = cornerSize4;
            this.bottomLeft = cornerSize2;
        }

        public static CornerData bottom(CornerData cornerData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cornerData)) == null) {
                CornerSize cornerSize = noCorner;
                return new CornerData(cornerSize, cornerData.bottomLeft, cornerSize, cornerData.bottomRight);
            }
            return (CornerData) invokeL.objValue;
        }

        public static CornerData left(CornerData cornerData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cornerData)) == null) {
                CornerSize cornerSize = cornerData.topLeft;
                CornerSize cornerSize2 = cornerData.bottomLeft;
                CornerSize cornerSize3 = noCorner;
                return new CornerData(cornerSize, cornerSize2, cornerSize3, cornerSize3);
            }
            return (CornerData) invokeL.objValue;
        }

        public static CornerData right(CornerData cornerData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cornerData)) == null) {
                CornerSize cornerSize = noCorner;
                return new CornerData(cornerSize, cornerSize, cornerData.topRight, cornerData.bottomRight);
            }
            return (CornerData) invokeL.objValue;
        }

        public static CornerData top(CornerData cornerData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cornerData)) == null) {
                CornerSize cornerSize = cornerData.topLeft;
                CornerSize cornerSize2 = noCorner;
                return new CornerData(cornerSize, cornerSize2, cornerData.topRight, cornerSize2);
            }
            return (CornerData) invokeL.objValue;
        }

        public static CornerData end(CornerData cornerData, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cornerData, view2)) == null) {
                if (ViewUtils.isLayoutRtl(view2)) {
                    return left(cornerData);
                }
                return right(cornerData);
            }
            return (CornerData) invokeLL.objValue;
        }

        public static CornerData start(CornerData cornerData, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, cornerData, view2)) == null) {
                if (ViewUtils.isLayoutRtl(view2)) {
                    return right(cornerData);
                }
                return left(cornerData);
            }
            return (CornerData) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MaterialButtonToggleGroup this$0;

        public PressedStateTracker(MaterialButtonToggleGroup materialButtonToggleGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {materialButtonToggleGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = materialButtonToggleGroup;
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void onPressedChanged(MaterialButton materialButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, materialButton, z) == null) {
                this.this$0.invalidate();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1612924282, "Lcom/google/android/material/button/MaterialButtonToggleGroup;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1612924282, "Lcom/google/android/material/button/MaterialButtonToggleGroup;");
                return;
            }
        }
        LOG_TAG = MaterialButtonToggleGroup.class.getSimpleName();
        DEF_STYLE_RES = R.style.obfuscated_res_0x7f100369;
    }

    private int getFirstVisibleChildIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (isChildVisible(i)) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    private int getLastVisibleChildIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (isChildVisible(childCount)) {
                    return childCount;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    private int getVisibleButtonCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if ((getChildAt(i2) instanceof MaterialButton) && isChildVisible(i2)) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void clearChecked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.skipCheckedStateTracker = true;
            for (int i = 0; i < getChildCount(); i++) {
                MaterialButton childButton = getChildButton(i);
                childButton.setChecked(false);
                dispatchOnButtonChecked(childButton.getId(), false);
            }
            this.skipCheckedStateTracker = false;
            setCheckedId(-1);
        }
    }

    public void clearOnButtonCheckedListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.onButtonCheckedListeners.clear();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return MaterialButtonToggleGroup.class.getName();
        }
        return (CharSequence) invokeV.objValue;
    }

    public int getCheckedButtonId() {
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

    public boolean isSelectionRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.selectionRequired;
        }
        return invokeV.booleanValue;
    }

    public boolean isSingleSelection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.singleSelection;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onFinishInflate();
            int i = this.checkedId;
            if (i != -1) {
                checkForced(i);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialButtonToggleGroup(Context context) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public int getIndexWithinVisibleButtons(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, view2)) == null) {
            if (!(view2 instanceof MaterialButton)) {
                return -1;
            }
            int i = 0;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (getChildAt(i2) == view2) {
                    return i;
                }
                if ((getChildAt(i2) instanceof MaterialButton) && isChildVisible(i2)) {
                    i++;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    private void resetChildMargins(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65557, this, i) == null) && getChildCount() != 0 && i != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildButton(i).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
            MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            super.onViewRemoved(view2);
            if (view2 instanceof MaterialButton) {
                MaterialButton materialButton = (MaterialButton) view2;
                materialButton.removeOnCheckedChangeListener(this.checkedStateTracker);
                materialButton.setOnPressedChangeListenerInternal(null);
            }
            int indexOfChild = indexOfChild(view2);
            if (indexOfChild >= 0) {
                this.originalCornerData.remove(indexOfChild);
            }
            updateChildShapes();
            adjustChildMarginsAndUpdateLayout();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f0404ac);
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
    public boolean updateCheckedStates(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            List<Integer> checkedButtonIds = getCheckedButtonIds();
            if (this.selectionRequired && checkedButtonIds.isEmpty()) {
                setCheckedStateForView(i, true);
                this.checkedId = i;
                return false;
            }
            if (z && this.singleSelection) {
                checkedButtonIds.remove(Integer.valueOf(i));
                for (Integer num : checkedButtonIds) {
                    int intValue = num.intValue();
                    setCheckedStateForView(intValue, false);
                    dispatchOnButtonChecked(intValue, false);
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
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
        this.originalCornerData = new ArrayList();
        this.checkedStateTracker = new CheckedStateTracker();
        this.pressedStateTracker = new PressedStateTracker();
        this.onButtonCheckedListeners = new LinkedHashSet();
        this.childOrderComparator = new Comparator(this) { // from class: com.google.android.material.button.MaterialButtonToggleGroup.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MaterialButtonToggleGroup this$0;

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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, materialButton, materialButton2)) == null) {
                    int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
                    if (compareTo != 0) {
                        return compareTo;
                    }
                    int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    return Integer.valueOf(this.this$0.indexOfChild(materialButton)).compareTo(Integer.valueOf(this.this$0.indexOfChild(materialButton2)));
                }
                return invokeLL.intValue;
            }
        };
        this.skipCheckedStateTracker = false;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R.styleable.MaterialButtonToggleGroup, i, DEF_STYLE_RES, new int[0]);
        setSingleSelection(obtainStyledAttributes.getBoolean(2, false));
        this.checkedId = obtainStyledAttributes.getResourceId(0, -1);
        this.selectionRequired = obtainStyledAttributes.getBoolean(1, false);
        setChildrenDrawingOrderEnabled(true);
        obtainStyledAttributes.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public static void updateBuilderWithCornerData(ShapeAppearanceModel.Builder builder, CornerData cornerData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, builder, cornerData) == null) {
            if (cornerData == null) {
                builder.setAllCornerSizes(0.0f);
            } else {
                builder.setTopLeftCornerSize(cornerData.topLeft).setBottomLeftCornerSize(cornerData.bottomLeft).setTopRightCornerSize(cornerData.topRight).setBottomRightCornerSize(cornerData.bottomRight);
            }
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) {
            Integer[] numArr = this.childOrder;
            if (numArr != null && i2 < numArr.length) {
                return numArr[i2].intValue();
            }
            Log.w(LOG_TAG, "Child order wasn't updated");
            return i2;
        }
        return invokeII.intValue;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            updateChildShapes();
            adjustChildMarginsAndUpdateLayout();
            super.onMeasure(i, i2);
        }
    }

    private LinearLayout.LayoutParams buildLayoutParams(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, view2)) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                return (LinearLayout.LayoutParams) layoutParams;
            }
            return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
        }
        return (LinearLayout.LayoutParams) invokeL.objValue;
    }

    private void checkForced(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i) == null) {
            setCheckedStateForView(i, true);
            updateCheckedStates(i, true);
            setCheckedId(i);
        }
    }

    private MaterialButton getChildButton(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, this, i)) == null) {
            return (MaterialButton) getChildAt(i);
        }
        return (MaterialButton) invokeI.objValue;
    }

    private boolean isChildVisible(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, this, i)) == null) {
            if (getChildAt(i).getVisibility() != 8) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private void setCheckedId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, this, i) == null) {
            this.checkedId = i;
            dispatchOnButtonChecked(i, true);
        }
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65560, this, materialButton) == null) && materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, materialButton) == null) {
            materialButton.setMaxLines(1);
            materialButton.setEllipsize(TextUtils.TruncateAt.END);
            materialButton.setCheckable(true);
            materialButton.addOnCheckedChangeListener(this.checkedStateTracker);
            materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
            materialButton.setShouldDrawSurfaceColorStroke(true);
        }
    }

    public void addOnButtonCheckedListener(OnButtonCheckedListener onButtonCheckedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onButtonCheckedListener) == null) {
            this.onButtonCheckedListeners.add(onButtonCheckedListener);
        }
    }

    public void check(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || i == this.checkedId) {
            return;
        }
        checkForced(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            updateChildOrder();
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            int visibleButtonCount = getVisibleButtonCount();
            if (isSingleSelection()) {
                i = 1;
            } else {
                i = 2;
            }
            wrap.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, visibleButtonCount, false, i));
        }
    }

    public void removeOnButtonCheckedListener(OnButtonCheckedListener onButtonCheckedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onButtonCheckedListener) == null) {
            this.onButtonCheckedListeners.remove(onButtonCheckedListener);
        }
    }

    public void setSelectionRequired(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.selectionRequired = z;
        }
    }

    public void setSingleSelection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            setSingleSelection(getResources().getBoolean(i));
        }
    }

    public void uncheck(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            setCheckedStateForView(i, false);
            updateCheckedStates(i, false);
            this.checkedId = -1;
            dispatchOnButtonChecked(i, false);
        }
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int firstVisibleChildIndex;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65546, this) != null) || (firstVisibleChildIndex = getFirstVisibleChildIndex()) == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton childButton = getChildButton(i);
            int min = Math.min(childButton.getStrokeWidth(), getChildButton(i - 1).getStrokeWidth());
            LinearLayout.LayoutParams buildLayoutParams = buildLayoutParams(childButton);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(buildLayoutParams, 0);
                MarginLayoutParamsCompat.setMarginStart(buildLayoutParams, -min);
            } else {
                buildLayoutParams.bottomMargin = 0;
                buildLayoutParams.topMargin = -min;
            }
            childButton.setLayoutParams(buildLayoutParams);
        }
        resetChildMargins(firstVisibleChildIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnButtonChecked(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Iterator it = this.onButtonCheckedListeners.iterator();
            while (it.hasNext()) {
                ((OnButtonCheckedListener) it.next()).onButtonChecked(this, i, z);
            }
        }
    }

    private void setCheckedStateForView(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            View findViewById = findViewById(i);
            if (findViewById instanceof MaterialButton) {
                this.skipCheckedStateTracker = true;
                ((MaterialButton) findViewById).setChecked(z);
                this.skipCheckedStateTracker = false;
            }
        }
    }

    private CornerData getNewCornerData(int i, int i2, int i3) {
        InterceptResult invokeIII;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65554, this, i, i2, i3)) == null) {
            CornerData cornerData = (CornerData) this.originalCornerData.get(i);
            if (i2 == i3) {
                return cornerData;
            }
            if (getOrientation() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (i == i2) {
                if (z) {
                    return CornerData.start(cornerData, this);
                }
                return CornerData.top(cornerData);
            } else if (i == i3) {
                if (z) {
                    return CornerData.end(cornerData, this);
                }
                return CornerData.bottom(cornerData);
            } else {
                return null;
            }
        }
        return (CornerData) invokeIII.objValue;
    }

    private void updateChildOrder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            TreeMap treeMap = new TreeMap(this.childOrderComparator);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                treeMap.put(getChildButton(i), Integer.valueOf(i));
            }
            this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
        }
    }

    public List getCheckedButtonIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                MaterialButton childButton = getChildButton(i);
                if (childButton.isChecked()) {
                    arrayList.add(Integer.valueOf(childButton.getId()));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void updateChildShapes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            for (int i = 0; i < childCount; i++) {
                MaterialButton childButton = getChildButton(i);
                if (childButton.getVisibility() != 8) {
                    ShapeAppearanceModel.Builder builder = childButton.getShapeAppearanceModel().toBuilder();
                    updateBuilderWithCornerData(builder, getNewCornerData(i, firstVisibleChildIndex, lastVisibleChildIndex));
                    childButton.setShapeAppearanceModel(builder.build());
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, layoutParams) == null) {
            if (!(view2 instanceof MaterialButton)) {
                Log.e(LOG_TAG, "Child views must be of type MaterialButton.");
                return;
            }
            super.addView(view2, i, layoutParams);
            MaterialButton materialButton = (MaterialButton) view2;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            if (materialButton.isChecked()) {
                updateCheckedStates(materialButton.getId(), true);
                setCheckedId(materialButton.getId());
            }
            ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.originalCornerData.add(new CornerData(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel.getBottomRightCornerSize()));
            ViewCompat.setAccessibilityDelegate(materialButton, new AccessibilityDelegateCompat(this) { // from class: com.google.android.material.button.MaterialButtonToggleGroup.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialButtonToggleGroup this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View view3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view3, accessibilityNodeInfoCompat) == null) {
                        super.onInitializeAccessibilityNodeInfo(view3, accessibilityNodeInfoCompat);
                        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.this$0.getIndexWithinVisibleButtons(view3), 1, false, ((MaterialButton) view3).isChecked()));
                    }
                }
            });
        }
    }

    public void setSingleSelection(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && this.singleSelection != z) {
            this.singleSelection = z;
            clearChecked();
        }
    }
}
