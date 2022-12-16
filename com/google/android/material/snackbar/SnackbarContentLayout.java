package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Button actionView;
    public int maxInlineActionWidth;
    public int maxWidth;
    public TextView messageView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SnackbarContentLayout(@NonNull Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.maxInlineActionWidth = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        obtainStyledAttributes.recycle();
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            this.messageView.setAlpha(0.0f);
            long j = i2;
            long j2 = i;
            this.messageView.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
            if (this.actionView.getVisibility() == 0) {
                this.actionView.setAlpha(0.0f);
                this.actionView.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
            }
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            this.messageView.setAlpha(1.0f);
            long j = i2;
            long j2 = i;
            this.messageView.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
            if (this.actionView.getVisibility() == 0) {
                this.actionView.setAlpha(1.0f);
                this.actionView.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
            }
        }
    }

    public static void updateTopBottomPadding(@NonNull View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, view2, i, i2) == null) {
            if (ViewCompat.isPaddingRelative(view2)) {
                ViewCompat.setPaddingRelative(view2, ViewCompat.getPaddingStart(view2), i, ViewCompat.getPaddingEnd(view2), i2);
            } else {
                view2.setPadding(view2.getPaddingLeft(), i, view2.getPaddingRight(), i2);
            }
        }
    }

    private boolean updateViewsWithinLayout(int i, int i2, int i3) {
        InterceptResult invokeIII;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65539, this, i, i2, i3)) == null) {
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            } else {
                z = false;
            }
            if (this.messageView.getPaddingTop() == i2 && this.messageView.getPaddingBottom() == i3) {
                return z;
            }
            updateTopBottomPadding(this.messageView, i2, i3);
            return true;
        }
        return invokeIII.booleanValue;
    }

    public Button getActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.actionView;
        }
        return (Button) invokeV.objValue;
    }

    public TextView getMessageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.messageView;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onFinishInflate();
            this.messageView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091fd6);
            this.actionView = (Button) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091fd5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (updateViewsWithinLayout(1, r0, r0 - r1) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
        if (updateViewsWithinLayout(0, r0, r0) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        r3 = true;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (this.maxWidth > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = this.maxWidth;
                if (measuredWidth > i3) {
                    i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                    super.onMeasure(i, i2);
                }
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f07021e);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f07021c);
            boolean z2 = false;
            if (this.messageView.getLayout().getLineCount() > 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z || this.maxInlineActionWidth <= 0 || this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) {
                if (!z) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
            }
            if (z2) {
                super.onMeasure(i, i2);
            }
        }
    }

    public void setMaxInlineActionWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.maxInlineActionWidth = i;
        }
    }

    public void updateActionTextColorAlphaIfNeeded(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048583, this, f) == null) && f != 1.0f) {
            this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, com.baidu.tieba.R.attr.obfuscated_res_0x7f04017e), this.actionView.getCurrentTextColor(), f));
        }
    }
}
