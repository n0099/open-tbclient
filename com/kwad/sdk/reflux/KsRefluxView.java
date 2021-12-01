package com.kwad.sdk.reflux;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.reflux.KsRefluxContentView;
/* loaded from: classes2.dex */
public class KsRefluxView extends FrameLayout implements View.OnClickListener, KsRefluxContentView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdWebView a;

    /* renamed from: b  reason: collision with root package name */
    public KsRefluxNativeView f58827b;

    /* renamed from: c  reason: collision with root package name */
    public View f58828c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f58829d;

    /* renamed from: e  reason: collision with root package name */
    public View f58830e;

    /* renamed from: f  reason: collision with root package name */
    public a f58831f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f58832g;

    /* loaded from: classes2.dex */
    public interface a {
        void d();

        void e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRefluxView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58832g = false;
        a(context, null, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.f58832g = false;
        a(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f58832g = false;
        a(context, attributeSet, i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
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
        this.f58832g = false;
        a(context, attributeSet, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view)) == null) {
            int measuredHeight = view.getMeasuredHeight();
            if (measuredHeight == 0) {
                return null;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(measuredHeight, getContext().getResources().getDimensionPixelOffset(R.dimen.ksad_reflux_back_height));
            ofInt.setDuration(300L);
            ofInt.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, view) { // from class: com.kwad.sdk.reflux.KsRefluxView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsRefluxView f58833b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58833b = this;
                    this.a = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = intValue;
                            this.a.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
            return ofInt;
        }
        return (Animator) invokeL.objValue;
    }

    @Nullable
    private Animator a(View view, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, view, view2)) == null) {
            if (view == null || view2 == null || view.getMeasuredHeight() <= 0) {
                return null;
            }
            Drawable background = view2.getBackground();
            if (background instanceof GradientDrawable) {
                ValueAnimator ofInt = ValueAnimator.ofInt(view.getMeasuredHeight(), 0);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, view) { // from class: com.kwad.sdk.reflux.KsRefluxView.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ View a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ KsRefluxView f58834b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, view};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f58834b = this;
                        this.a = view;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams.height = intValue;
                                this.a.setLayoutParams(layoutParams);
                            }
                        }
                    }
                });
                ValueAnimator ofFloat = ValueAnimator.ofFloat(getResources().getDimension(R.dimen.ksad_reflux_title_bar_corner), 0.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, (GradientDrawable) background, view2) { // from class: com.kwad.sdk.reflux.KsRefluxView.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GradientDrawable a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ View f58835b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ KsRefluxView f58836c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, view2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f58836c = this;
                        this.a = r7;
                        this.f58835b = view2;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            com.kwad.sdk.core.d.a.a("KsRefluxView", "actionBar radii value: " + floatValue);
                            this.a.setCornerRadii(new float[]{floatValue, floatValue, floatValue, floatValue, 0.0f, 0.0f, 0.0f, 0.0f});
                            this.f58835b.setBackground(this.a);
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(300L);
                animatorSet.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
                animatorSet.playTogether(ofInt, ofFloat);
                return animatorSet;
            }
            return null;
        }
        return (Animator) invokeLL.objValue;
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65544, this, context, attributeSet, i2) == null) {
            FrameLayout.inflate(context, R.layout.ksad_reflux, this);
            this.f58828c = findViewById(R.id.ksad_reflux_title_bar);
            this.f58829d = (ImageView) findViewById(R.id.ksad_reflux_back);
            this.a = (KsAdWebView) findViewById(R.id.ksad_reflux_webview);
            this.f58827b = (KsRefluxNativeView) findViewById(R.id.ksad_reflux_native);
            View findViewById = findViewById(R.id.ksad_reflux_close);
            this.f58830e = findViewById;
            findViewById.setOnClickListener(this);
            this.f58829d.setOnClickListener(this);
            ((KsRefluxContentView) findViewById(R.id.ksad_reflux_content)).setContentViewListener(this);
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            ImageView imageView = this.f58829d;
            return imageView != null && imageView.getMeasuredHeight() == 0;
        }
        return invokeV.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.a.setVisibility(z ? 0 : 4);
            this.f58827b.setVisibility(z ? 8 : 0);
        }
    }

    @Override // com.kwad.sdk.reflux.KsRefluxContentView.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? e() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.reflux.KsRefluxContentView.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (e()) {
                return false;
            }
            d();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(0);
            this.f58829d.post(new Runnable(this) { // from class: com.kwad.sdk.reflux.KsRefluxView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsRefluxView a;

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
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        KsRefluxView ksRefluxView = this.a;
                        Animator a2 = ksRefluxView.a(ksRefluxView.f58829d);
                        if (a2 != null) {
                            a2.start();
                        }
                        if (this.a.f58831f != null) {
                            this.a.f58831f.e();
                        }
                    }
                }
            });
        }
    }

    @MainThread
    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || e() || this.f58832g) {
            return;
        }
        Animator a2 = a(this.f58829d, this.f58828c);
        a2.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reflux.KsRefluxView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsRefluxView a;

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
                this.a = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.a.f58832g = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    super.onAnimationStart(animator);
                    this.a.f58832g = true;
                }
            }
        });
        a2.start();
    }

    public KsRefluxNativeView getNativeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58827b : (KsRefluxNativeView) invokeV.objValue;
    }

    public KsAdWebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (KsAdWebView) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || this.f58831f == null) {
            return;
        }
        if (view.equals(this.f58830e)) {
            this.f58831f.d();
        } else if (view.equals(this.f58829d)) {
            d();
        }
    }

    public void setViewListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f58831f = aVar;
        }
    }
}
