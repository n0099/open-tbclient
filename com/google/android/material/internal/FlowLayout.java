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
/* loaded from: classes2.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static int getMeasuredDimension(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3, i4)) == null) {
            if (i3 != Integer.MIN_VALUE) {
                return i3 != 1073741824 ? i4 : i2;
            }
            return Math.min(i4, i2);
        }
        return invokeIII.intValue;
    }

    private void loadFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
            this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
            this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public int getItemSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.itemSpacing : invokeV.intValue;
    }

    public int getLineSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.lineSpacing : invokeV.intValue;
    }

    public int getRowCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.rowCount : invokeV.intValue;
    }

    public int getRowIndex(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            Object tag = view.getTag(R.id.row_index_key);
            if (tag instanceof Integer) {
                return ((Integer) tag).intValue();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean isSingleLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.singleLine : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (getChildCount() == 0) {
                this.rowCount = 0;
                return;
            }
            this.rowCount = 1;
            boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
            int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
            int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
            int paddingTop = getPaddingTop();
            int i8 = (i4 - i2) - paddingLeft;
            int i9 = paddingRight;
            int i10 = paddingTop;
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() == 8) {
                    childAt.setTag(R.id.row_index_key, -1);
                } else {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i7 = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                        i6 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                    } else {
                        i6 = 0;
                        i7 = 0;
                    }
                    int measuredWidth = i9 + i7 + childAt.getMeasuredWidth();
                    if (!this.singleLine && measuredWidth > i8) {
                        i10 = this.lineSpacing + paddingTop;
                        this.rowCount++;
                        i9 = paddingRight;
                    }
                    childAt.setTag(R.id.row_index_key, Integer.valueOf(this.rowCount - 1));
                    int i12 = i9 + i7;
                    int measuredWidth2 = childAt.getMeasuredWidth() + i12;
                    int measuredHeight = childAt.getMeasuredHeight() + i10;
                    if (z2) {
                        childAt.layout(i8 - measuredWidth2, i10, (i8 - i9) - i7, measuredHeight);
                    } else {
                        childAt.layout(i12, i10, measuredWidth2, measuredHeight);
                    }
                    i9 += i7 + i6 + childAt.getMeasuredWidth() + this.itemSpacing;
                    paddingTop = measuredHeight;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            int i7 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = i7 - getPaddingRight();
            int i8 = paddingTop;
            int i9 = 0;
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8) {
                    measureChild(childAt, i2, i3);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i4 = marginLayoutParams.leftMargin + 0;
                        i5 = marginLayoutParams.rightMargin + 0;
                    } else {
                        i4 = 0;
                        i5 = 0;
                    }
                    int i11 = paddingLeft;
                    if (paddingLeft + i4 + childAt.getMeasuredWidth() <= paddingRight || isSingleLine()) {
                        i6 = i11;
                    } else {
                        i6 = getPaddingLeft();
                        i8 = this.lineSpacing + paddingTop;
                    }
                    int measuredWidth = i6 + i4 + childAt.getMeasuredWidth();
                    int measuredHeight = i8 + childAt.getMeasuredHeight();
                    if (measuredWidth > i9) {
                        i9 = measuredWidth;
                    }
                    paddingLeft = i6 + i4 + i5 + childAt.getMeasuredWidth() + this.itemSpacing;
                    if (i10 == getChildCount() - 1) {
                        i9 += i5;
                    }
                    paddingTop = measuredHeight;
                }
            }
            setMeasuredDimension(getMeasuredDimension(size, mode, i9 + getPaddingRight()), getMeasuredDimension(size2, mode2, paddingTop + getPaddingBottom()));
        }
    }

    public void setItemSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.itemSpacing = i2;
        }
    }

    public void setLineSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.lineSpacing = i2;
        }
    }

    public void setSingleLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.singleLine = z;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
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
}
