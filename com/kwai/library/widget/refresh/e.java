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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
/* loaded from: classes3.dex */
public class e extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public AnimationDrawable f58361b;
    @DrawableRes

    /* renamed from: c  reason: collision with root package name */
    public int f58362c;

    /* renamed from: d  reason: collision with root package name */
    public View f58363d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58364e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58365f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58362c = R.drawable.ksad_kwai_loading_view_gradient;
        a(context, attributeSet, 0);
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            a(i2 == 0);
        }
    }

    private void a(Context context, AttributeSet attributeSet, @StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, context, attributeSet, i2) == null) {
            LayoutInflater.from(context).inflate(R.layout.ksad_kwai_default_loading_view, this);
            this.f58363d = findViewById(R.id.kwai_default_loading_view);
            this.f58364e = (TextView) findViewById(R.id.kwai_default_loading_text_view);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KwaiLoadingView, 0, i2);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.KwaiLoadingView_loading_anim, 0);
            CharSequence text = obtainStyledAttributes.getText(R.styleable.KwaiLoadingView_loading_text);
            float dimension = obtainStyledAttributes.getDimension(R.styleable.KwaiLoadingView_loading_width, 0.0f);
            float dimension2 = obtainStyledAttributes.getDimension(R.styleable.KwaiLoadingView_loading_hight, 0.0f);
            obtainStyledAttributes.recycle();
            setLoadingText(text);
            if (resourceId != 0) {
                this.f58362c = resourceId;
            }
            if (dimension <= 0.0f || dimension2 <= 0.0f) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f58363d.getLayoutParams();
            layoutParams.width = (int) dimension;
            layoutParams.height = (int) dimension2;
            this.f58363d.setLayoutParams(layoutParams);
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
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.f58363d.getBackground() == null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) getContext().getResources().getDrawable(this.f58362c);
            this.f58361b = animationDrawable;
            this.f58363d.setBackground(animationDrawable);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
            AnimationDrawable animationDrawable = this.f58361b;
            if (animationDrawable != null) {
                animationDrawable.start();
            }
        }
    }

    public void a(boolean z, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, charSequence) == null) || this.f58363d == null) {
            return;
        }
        if (z || charSequence != null) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
        this.f58363d.setVisibility(z ? 0 : 8);
        try {
            this.f58364e.setText(charSequence);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f58364e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if (TextUtils.isEmpty(charSequence)) {
            this.f58364e.setVisibility(8);
        } else {
            this.f58364e.setVisibility(0);
        }
    }

    public void b() {
        AnimationDrawable animationDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (animationDrawable = this.f58361b) == null) {
            return;
        }
        animationDrawable.stop();
    }

    public TextView getTitleDetailView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f58365f == null) {
                TextView textView = new TextView(getContext(), null, R.style.Theme_Widget_Text);
                this.f58365f = textView;
                textView.setGravity(17);
                this.f58365f.setTextColor(getResources().getColor(R.color.loading_title_color));
                this.f58365f.setTextSize(0, getContext().getResources().getDimension(R.dimen.text_size_12));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = g.a(getContext(), 5.0f);
                layoutParams.gravity = 1;
                ((LinearLayout) this.f58363d.getParent()).addView(this.f58365f, layoutParams);
            }
            return this.f58365f;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58364e : (TextView) invokeV.objValue;
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
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            a(i2);
        }
    }

    public void setAnimRes(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f58362c = i2;
        }
    }

    public void setLoadingText(CharSequence charSequence) {
        TextView textView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, charSequence) == null) {
            this.f58364e.setText(charSequence);
            if (TextUtils.isEmpty(charSequence)) {
                textView = this.f58364e;
                i2 = 8;
            } else {
                textView = this.f58364e;
                i2 = 0;
            }
            textView.setVisibility(i2);
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
            TextView textView = this.f58365f;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            int visibility = getVisibility();
            super.setVisibility(i2);
            if (visibility != i2) {
                a(i2);
            }
        }
    }
}
