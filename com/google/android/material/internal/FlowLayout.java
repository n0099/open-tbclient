package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class FlowLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int itemSpacing;
    public int lineSpacing;
    public int rowCount;
    public boolean singleLine;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlowLayout(@NonNull Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    public static int getMeasuredDimension(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2, i3)) == null) {
            if (i2 != Integer.MIN_VALUE) {
                if (i2 != 1073741824) {
                    return i3;
                }
                return i;
            }
            return Math.min(i3, i);
        }
        return invokeIII.intValue;
    }

    private void loadFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
            this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public int getItemSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.itemSpacing;
        }
        return invokeV.intValue;
    }

    public int getLineSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.lineSpacing;
        }
        return invokeV.intValue;
    }

    public int getRowCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.rowCount;
        }
        return invokeV.intValue;
    }

    public boolean isSingleLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.singleLine;
        }
        return invokeV.booleanValue;
    }

    public int getRowIndex(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            Object tag = view2.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091d51);
            if (!(tag instanceof Integer)) {
                return -1;
            }
            return ((Integer) tag).intValue();
        }
        return invokeL.intValue;
    }

    public void setItemSpacing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.itemSpacing = i;
        }
    }

    public void setLineSpacing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.lineSpacing = i;
        }
    }

    public void setSingleLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.singleLine = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int paddingLeft;
        int paddingRight;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (getChildCount() == 0) {
                this.rowCount = 0;
                return;
            }
            this.rowCount = 1;
            if (ViewCompat.getLayoutDirection(this) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                paddingLeft = getPaddingRight();
            } else {
                paddingLeft = getPaddingLeft();
            }
            if (z2) {
                paddingRight = getPaddingLeft();
            } else {
                paddingRight = getPaddingRight();
            }
            int paddingTop = getPaddingTop();
            int i7 = (i3 - i) - paddingRight;
            int i8 = paddingLeft;
            int i9 = paddingTop;
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    childAt.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091d51, -1);
                } else {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i6 = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                        i5 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                    } else {
                        i5 = 0;
                        i6 = 0;
                    }
                    int measuredWidth = i8 + i6 + childAt.getMeasuredWidth();
                    if (!this.singleLine && measuredWidth > i7) {
                        i9 = this.lineSpacing + paddingTop;
                        this.rowCount++;
                        i8 = paddingLeft;
                    }
                    childAt.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091d51, Integer.valueOf(this.rowCount - 1));
                    int i11 = i8 + i6;
                    int measuredWidth2 = childAt.getMeasuredWidth() + i11;
                    int measuredHeight = childAt.getMeasuredHeight() + i9;
                    if (z2) {
                        childAt.layout(i7 - measuredWidth2, i9, (i7 - i8) - i6, measuredHeight);
                    } else {
                        childAt.layout(i11, i9, measuredWidth2, measuredHeight);
                    }
                    i8 += i6 + i5 + childAt.getMeasuredWidth() + this.itemSpacing;
                    paddingTop = measuredHeight;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode != Integer.MIN_VALUE && mode != 1073741824) {
                i3 = Integer.MAX_VALUE;
            } else {
                i3 = size;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = i3 - getPaddingRight();
            int i7 = paddingTop;
            int i8 = 0;
            for (int i9 = 0; i9 < getChildCount(); i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    measureChild(childAt, i, i2);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i4 = marginLayoutParams.leftMargin + 0;
                        i5 = marginLayoutParams.rightMargin + 0;
                    } else {
                        i4 = 0;
                        i5 = 0;
                    }
                    int i10 = paddingLeft;
                    if (paddingLeft + i4 + childAt.getMeasuredWidth() > paddingRight && !isSingleLine()) {
                        i6 = getPaddingLeft();
                        i7 = this.lineSpacing + paddingTop;
                    } else {
                        i6 = i10;
                    }
                    int measuredWidth = i6 + i4 + childAt.getMeasuredWidth();
                    int measuredHeight = i7 + childAt.getMeasuredHeight();
                    if (measuredWidth > i8) {
                        i8 = measuredWidth;
                    }
                    paddingLeft = i6 + i4 + i5 + childAt.getMeasuredWidth() + this.itemSpacing;
                    if (i9 == getChildCount() - 1) {
                        i8 += i5;
                    }
                    paddingTop = measuredHeight;
                }
            }
            setMeasuredDimension(getMeasuredDimension(size, mode, i8 + getPaddingRight()), getMeasuredDimension(size2, mode2, paddingTop + getPaddingBottom()));
        }
    }
}
