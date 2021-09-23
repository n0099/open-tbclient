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
/* loaded from: classes9.dex */
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

    public static void updateTopBottomPadding(@NonNull View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, view, i2, i3) == null) {
            if (ViewCompat.isPaddingRelative(view)) {
                ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i2, ViewCompat.getPaddingEnd(view), i3);
            } else {
                view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
            }
        }
    }

    private boolean updateViewsWithinLayout(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65539, this, i2, i3, i4)) == null) {
            if (i2 != getOrientation()) {
                setOrientation(i2);
                z = true;
            } else {
                z = false;
            }
            if (this.messageView.getPaddingTop() == i3 && this.messageView.getPaddingBottom() == i4) {
                return z;
            }
            updateTopBottomPadding(this.messageView, i3, i4);
            return true;
        }
        return invokeIII.booleanValue;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            this.messageView.setAlpha(0.0f);
            long j2 = i3;
            long j3 = i2;
            this.messageView.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
            if (this.actionView.getVisibility() == 0) {
                this.actionView.setAlpha(0.0f);
                this.actionView.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
            }
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.messageView.setAlpha(1.0f);
            long j2 = i3;
            long j3 = i2;
            this.messageView.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
            if (this.actionView.getVisibility() == 0) {
                this.actionView.setAlpha(1.0f);
                this.actionView.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
            }
        }
    }

    public Button getActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.actionView : (Button) invokeV.objValue;
    }

    public TextView getMessageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.messageView : (TextView) invokeV.objValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onFinishInflate();
            this.messageView = (TextView) findViewById(R.id.snackbar_text);
            this.actionView = (Button) findViewById(R.id.snackbar_action);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        if (updateViewsWithinLayout(1, r0, r0 - r1) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
        if (updateViewsWithinLayout(0, r0, r0) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
        r3 = true;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.maxWidth > 0) {
                int measuredWidth = getMeasuredWidth();
                int i4 = this.maxWidth;
                if (measuredWidth > i4) {
                    i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                    super.onMeasure(i2, i3);
                }
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
            boolean z = false;
            boolean z2 = this.messageView.getLayout().getLineCount() > 1;
            if (!z2 || this.maxInlineActionWidth <= 0 || this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) {
                if (!z2) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
            }
            if (z) {
                super.onMeasure(i2, i3);
            }
        }
    }

    public void setMaxInlineActionWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.maxInlineActionWidth = i2;
        }
    }

    public void updateActionTextColorAlphaIfNeeded(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048583, this, f2) == null) || f2 == 1.0f) {
            return;
        }
        this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), this.actionView.getCurrentTextColor(), f2));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.maxInlineActionWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }
}
