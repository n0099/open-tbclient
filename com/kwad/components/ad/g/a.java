package com.kwad.components.ad.g;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.tailframe.appbar.b;
import com.kwad.sdk.utils.az;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public Button c;
    public Button d;
    @Nullable
    public Animator e;
    public boolean f;

    public a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.a = view2;
        e();
    }

    public static Animator a(View view2, float f, float f2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Long.valueOf(j)})) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f2);
            ofFloat.setDuration(j);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(f / f2, f2, view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a3), view2) { // from class: com.kwad.components.ad.g.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ float a;
                public final /* synthetic */ float b;
                public final /* synthetic */ float c;
                public final /* synthetic */ View d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Float.valueOf(r6), Float.valueOf(f2), Float.valueOf(r8), view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = r6;
                    this.b = f2;
                    this.c = r8;
                    this.d = view2;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float f3 = this.a * floatValue;
                        float f4 = this.b;
                        if (f4 != 0.0f) {
                            float f5 = (floatValue / f4) * this.c;
                            View view3 = this.d;
                            if (view3 instanceof TextView) {
                                ((TextView) view3).setTextSize(0, f5);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = (int) floatValue;
                            layoutParams.width = (int) f3;
                            this.d.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
            return ofFloat;
        }
        return (Animator) invokeCommon.objValue;
    }

    public static Animator a(View view2, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, view2, j)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(j);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
            return ofFloat;
        }
        return (Animator) invokeLJ.objValue;
    }

    public static Animator a(View view2, View view3, int i, int i2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{view2, view3, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Animator a = a(view2, 200L);
            float f = i;
            float f2 = i2;
            Animator a2 = a(view3, f, f2, 200L);
            a2.addListener(new b(view2) { // from class: com.kwad.components.ad.g.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = view2;
                }

                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.setAlpha(1.0f);
                        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = 0;
                            layoutParams.height = 0;
                            this.a.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3, "scaleX", 1.0f, 1.0f);
            ofFloat.setDuration(1600L);
            Animator a3 = a(view3, 200L);
            Animator a4 = a(view2, f, f2, 200L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(a, a2, ofFloat, a3, a4);
            return animatorSet;
        }
        return (Animator) invokeCommon.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.c = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f0910ed);
            this.d = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f0910ef);
            this.b = this.a.findViewById(R.id.obfuscated_res_0x7f0910ee);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.d.b.a("ApkInstallAnimHelper", "startAnimation");
            int height = this.b.getHeight();
            int width = this.b.getWidth();
            if (height == 0 || width == 0) {
                return;
            }
            if (this.e == null) {
                Animator a = a(this.d, this.c, width, height, 1600L, 200L);
                this.e = a;
                a.addListener(new b(this) { // from class: com.kwad.components.ad.g.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) || this.a.f) {
                            return;
                        }
                        az.a(new Runnable(this, animator) { // from class: com.kwad.components.ad.g.a.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Animator a;
                            public final /* synthetic */ AnonymousClass1 b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, animator};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.b = this;
                                this.a = animator;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.start();
                                }
                            }
                        }, null, 1600L);
                    }
                });
            }
            com.kwad.sdk.core.d.b.a("ApkInstallAnimHelper", "mAnimator isStarted: " + this.e.isStarted());
            if (!this.e.isStarted()) {
                com.kwad.sdk.core.d.b.a("ApkInstallAnimHelper", "mAnimator.start()");
                this.e.start();
            }
            this.f = false;
        }
    }

    public final void b() {
        Animator animator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (animator = this.e) == null) {
            return;
        }
        animator.cancel();
        this.f = true;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = true;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b();
        }
    }
}
