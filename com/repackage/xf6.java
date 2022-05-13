package com.repackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pv5;
/* loaded from: classes7.dex */
public class xf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public rv5 b;
    public rv5 c;
    public rv5 d;
    public ValueAnimator e;

    /* loaded from: classes7.dex */
    public class a implements pv5.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;

        public a(xf6 xf6Var, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBLottieAnimationView;
        }

        @Override // com.repackage.pv5.j
        public void a(pv5 pv5Var, boolean z, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{pv5Var, Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.a.playAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf6 a;

        public b(xf6 xf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf6Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.e.start();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf6 a;

        public c(xf6 xf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf6Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.a.a == null) {
                return;
            }
            this.a.a.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf6 a;

        public d(xf6 xf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf6Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.d.h();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements pv5.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;

        public e(xf6 xf6Var, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBLottieAnimationView;
        }

        @Override // com.repackage.pv5.j
        @SuppressLint({"WrongConstant"})
        public void a(pv5 pv5Var, boolean z, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{pv5Var, Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.a.setRepeatCount(-1);
                this.a.setRepeatMode(2);
                this.a.playAnimation();
            }
        }
    }

    public xf6(View view2, TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tBLottieAnimationView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        this.b = d(view2, pv5.n, 170.0f, 0.5f, 1.0f);
        this.c = d(view2, pv5.o, 170.0f, 0.5f, 1.0f);
        this.e = e(view2, 0.0f, 6.0f, 100L);
        this.d = d(view2, pv5.p, 200.0f, 0.4f, 0.0f);
        f(tBLottieAnimationView);
    }

    public final rv5 d(View view2, qv5<View> qv5Var, float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, qv5Var, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            sv5 sv5Var = new sv5(f3);
            sv5Var.f(f);
            sv5Var.d(f2);
            rv5 rv5Var = new rv5(view2, qv5Var);
            rv5Var.m(sv5Var);
            return rv5Var;
        }
        return (rv5) invokeCommon.objValue;
    }

    public final ValueAnimator e(View view2, float f, float f2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Long.valueOf(j)})) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
            ofFloat.setTarget(view2);
            ofFloat.setDuration(j);
            return ofFloat;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }

    public final void f(TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tBLottieAnimationView) == null) || tBLottieAnimationView == null) {
            return;
        }
        this.b.b(new a(this, tBLottieAnimationView));
        tBLottieAnimationView.addAnimatorListener(new b(this));
        this.e.addUpdateListener(new c(this));
        this.e.addListener(new d(this));
        this.d.b(new e(this, tBLottieAnimationView));
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.h();
            this.c.h();
        }
    }
}
