package com.kwai.library.widget.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public AnimationDrawable b;
    @DrawableRes
    public int c;
    public View d;
    public TextView e;
    public TextView f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = R.drawable.obfuscated_res_0x7f080bdd;
        a(context, attributeSet, 0);
    }

    private void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            a(i == 0);
        }
    }

    private void a(Context context, AttributeSet attributeSet, @StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, context, attributeSet, i) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d042b, this);
            this.d = findViewById(R.id.obfuscated_res_0x7f091154);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091153);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040436, R.attr.obfuscated_res_0x7f040437, R.attr.obfuscated_res_0x7f040438, R.attr.obfuscated_res_0x7f040439}, 0, i);
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            CharSequence text = obtainStyledAttributes.getText(2);
            float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
            float dimension2 = obtainStyledAttributes.getDimension(1, 0.0f);
            obtainStyledAttributes.recycle();
            setLoadingText(text);
            if (resourceId != 0) {
                this.c = resourceId;
            }
            if (dimension <= 0.0f || dimension2 <= 0.0f) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            layoutParams.width = (int) dimension;
            layoutParams.height = (int) dimension2;
            this.d.setLayoutParams(layoutParams);
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            if (z) {
                a();
            } else {
                b();
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.d.getBackground() == null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) getContext().getResources().getDrawable(this.c);
            this.b = animationDrawable;
            this.d.setBackground(animationDrawable);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
            AnimationDrawable animationDrawable = this.b;
            if (animationDrawable != null) {
                animationDrawable.start();
            }
        }
    }

    public void a(boolean z, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, charSequence) == null) || this.d == null) {
            return;
        }
        if (z || charSequence != null) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
        this.d.setVisibility(z ? 0 : 8);
        try {
            this.e.setText(charSequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if (TextUtils.isEmpty(charSequence)) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
    }

    public void b() {
        AnimationDrawable animationDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (animationDrawable = this.b) == null) {
            return;
        }
        animationDrawable.stop();
    }

    public TextView getTitleDetailView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f == null) {
                TextView textView = new TextView(getContext(), null, R.style.obfuscated_res_0x7f100262);
                this.f = textView;
                textView.setGravity(17);
                this.f.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060781));
                this.f.setTextSize(0, getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070941));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = g.a(getContext(), 5.0f);
                layoutParams.gravity = 1;
                ((LinearLayout) this.d.getParent()).addView(this.f, layoutParams);
            }
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (TextView) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            super.onVisibilityAggregated(z);
            if (z != this.a) {
                this.a = z;
                a(z);
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            a(i);
        }
    }

    public void setAnimRes(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.c = i;
        }
    }

    public void setLoadingText(CharSequence charSequence) {
        TextView textView;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, charSequence) == null) {
            this.e.setText(charSequence);
            if (TextUtils.isEmpty(charSequence)) {
                textView = this.e;
                i = 8;
            } else {
                textView = this.e;
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    public void setTitleDetailText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, charSequence) == null) {
            if (!TextUtils.isEmpty(charSequence)) {
                getTitleDetailView().setVisibility(0);
                getTitleDetailView().setText(charSequence);
                return;
            }
            TextView textView = this.f;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            int visibility = getVisibility();
            super.setVisibility(i);
            if (visibility != i) {
                a(i);
            }
        }
    }
}
