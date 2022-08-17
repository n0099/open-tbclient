package com.repackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gz8;
import com.repackage.zy8;
/* loaded from: classes6.dex */
public class cz8 extends gz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueAnimator h;
    public ValueAnimator i;
    public float j;
    public float k;
    public ValueAnimator l;
    public ValueAnimator m;
    public AnimatorSet n;
    public ValueAnimator o;
    public ValueAnimator p;
    public float q;
    public float r;
    public float s;
    public int t;
    public zy8.c u;
    public yx5 v;
    public yx5 w;

    /* loaded from: classes6.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public a(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                zx5 zx5Var = new zx5(this.a.s);
                zx5Var.d(0.5f);
                zx5Var.f(800.0f);
                cz8 cz8Var = this.a;
                yx5 yx5Var = new yx5(this.a.u.H, wx5.m);
                yx5Var.m(zx5Var);
                cz8Var.v = yx5Var;
                this.a.v.h();
                cz8 cz8Var2 = this.a;
                yx5 yx5Var2 = new yx5(this.a.u.s, wx5.m);
                yx5Var2.m(zx5Var);
                cz8Var2.w = yx5Var2;
                this.a.w.h();
                this.a.u.H.setTranslationY(0.0f);
                this.a.u.s.setTranslationY(0.0f);
                cz8 cz8Var3 = this.a;
                cz8Var3.e = 2;
                gz8.a aVar = cz8Var3.d;
                if (aVar != null) {
                    aVar.a(2);
                }
                this.a.u.q.setClickable(true);
                this.a.u.n.setClickable(true);
                this.a.u.k.setClickable(true);
                this.a.u.h.setClickable(true);
                this.a.u.x.setClickable(true);
                this.a.u.A.setClickable(true);
                this.a.u.D.setClickable(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.u.q.setClickable(false);
                this.a.u.n.setClickable(false);
                this.a.u.k.setClickable(false);
                this.a.u.h.setClickable(false);
                this.a.u.x.setClickable(false);
                this.a.u.A.setClickable(false);
                this.a.u.D.setClickable(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public b(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.a.u.H.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.H.setTranslationY(this.a.r * valueAnimator.getAnimatedFraction());
                this.a.u.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.s.setTranslationY(this.a.r * valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public c(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.u.H.setAlpha(0.0f);
                this.a.u.H.setTranslationY(this.a.r);
                this.a.u.s.setAlpha(0);
                this.a.u.s.setTranslationY(this.a.r);
                this.a.A();
                this.a.u.q.setClickable(true);
                this.a.u.n.setClickable(true);
                this.a.u.k.setClickable(true);
                this.a.u.h.setClickable(true);
                this.a.u.x.setClickable(true);
                this.a.u.A.setClickable(true);
                this.a.u.D.setClickable(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.u.q.setClickable(false);
                this.a.u.n.setClickable(false);
                this.a.u.k.setClickable(false);
                this.a.u.h.setClickable(false);
                this.a.u.x.setClickable(false);
                this.a.u.A.setClickable(false);
                this.a.u.D.setClickable(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public d(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                cz8 cz8Var = this.a;
                if (cz8Var.f != null && cz8Var.j == 0.0f && this.a.k == 0.0f) {
                    this.a.u.G.getGlobalVisibleRect(this.a.g);
                    cz8 cz8Var2 = this.a;
                    cz8Var2.j = cz8Var2.f.centerX() - this.a.g.centerX();
                    cz8 cz8Var3 = this.a;
                    cz8Var3.k = cz8Var3.f.centerY() - this.a.g.centerY();
                }
                this.a.u.G.setVisibility(0);
                this.a.u.G.setTranslationX(this.a.j);
                this.a.u.G.setTranslationY(this.a.k);
                cz8 cz8Var4 = this.a;
                View view2 = cz8Var4.c;
                if (view2 instanceof OvalActionButton) {
                    ((OvalActionButton) view2).b(cz8Var4.u.G);
                }
                this.a.h.start();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public e(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (!(this.a.j == 0.0f && this.a.k == 0.0f) && valueAnimator.isRunning()) {
                    this.a.u.G.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    this.a.u.G.setTranslationX(this.a.j - (this.a.j * valueAnimator.getAnimatedFraction()));
                    this.a.u.G.setTranslationY(this.a.k - (this.a.k * valueAnimator.getAnimatedFraction()));
                    this.a.u.G.setRotation(valueAnimator.getAnimatedFraction() * (-90.0f));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public f(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.u.G.setTranslationX(0.0f);
                this.a.u.G.setTranslationY(0.0f);
                this.a.u.G.setRotation(-90.0f);
                this.a.u.G.setEndIcon(R.drawable.obfuscated_res_0x7f080936, this.a.t, "webp");
                this.a.u.G.setCrossFade(1.0f, false);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                View view2 = this.a.c;
                if (view2 != null) {
                    view2.setVisibility(4);
                    this.a.c.setAlpha(0.0f);
                }
                this.a.u.G.setEndIcon(R.drawable.obfuscated_res_0x7f080936, this.a.t, "webp");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public g(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (!(this.a.j == 0.0f && this.a.k == 0.0f) && valueAnimator.isRunning()) {
                    this.a.u.G.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    this.a.u.G.setTranslationX(this.a.j * valueAnimator.getAnimatedFraction());
                    this.a.u.G.setTranslationY(this.a.k * valueAnimator.getAnimatedFraction());
                    this.a.u.G.setRotation((valueAnimator.getAnimatedFraction() * 90.0f) - 90.0f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public h(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.u.G.setTranslationX(this.a.j);
                this.a.u.G.setTranslationY(this.a.k);
                this.a.u.G.setRotation(0.0f);
                this.a.u.G.setEndIcon(0, 0, "");
                this.a.u.G.setCrossFade(1.0f, true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.u.G.setEndIcon(R.drawable.obfuscated_res_0x7f080936, this.a.t, "webp");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public i(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.a.u.H.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public j(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.u.H.setAlpha(1.0f);
                this.a.u.s.setAlpha(1);
                this.a.u.e.setAlpha(1.0f);
                this.a.u.f.setAlpha(1.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public k(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.a.u.e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public l(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.u.e.setAlpha(0.0f);
                this.a.u.f.setAlpha(0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;

        public m(cz8 cz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.a.u.H.setTranslationY(this.a.q - (this.a.q * valueAnimator.getAnimatedFraction()));
                this.a.u.s.setTranslationY(this.a.q - (this.a.q * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cz8(Context context, zy8.c cVar) {
        super(context, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (zy8) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.u = cVar;
        this.t = qi.f(this.a, R.dimen.tbds0);
        z();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View view2 = this.c;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            this.e = 4;
            x();
            B(8);
            this.u.G.setVisibility(4);
            View view3 = this.c;
            if (view3 != null) {
                view3.setVisibility(0);
                this.c.setAlpha(1.0f);
            }
            gz8.a aVar = this.d;
            if (aVar != null) {
                aVar.a(this.e);
            }
        }
    }

    public final void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.u.f.setVisibility(i2);
            this.u.e.setVisibility(i2);
            this.u.H.setVisibility(i2);
            this.u.s.setVisibility(i2);
        }
    }

    @Override // com.repackage.gz8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            A();
        }
    }

    @Override // com.repackage.gz8
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            x();
        }
    }

    @Override // com.repackage.gz8
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.e == 4) {
            this.e = 1;
            gz8.a aVar = this.d;
            if (aVar != null) {
                aVar.a(1);
            }
            x();
            B(0);
            this.l.start();
            this.n.start();
            y();
        }
    }

    @Override // com.repackage.gz8
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.e == 2) {
            this.e = 3;
            gz8.a aVar = this.d;
            if (aVar != null) {
                aVar.a(3);
            }
            x();
            this.m.start();
            this.i.start();
            this.p.start();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h.cancel();
            this.i.cancel();
            this.m.cancel();
            this.l.cancel();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.u.G.post(new d(this));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.n = new AnimatorSet();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.h = ofFloat;
            ofFloat.setDuration(450L);
            this.h.setInterpolator(new OvershootInterpolator());
            this.h.addUpdateListener(new e(this));
            this.h.addListener(new f(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.i = ofFloat2;
            ofFloat2.setDuration(450L);
            this.i.setInterpolator(new AccelerateInterpolator());
            this.i.addUpdateListener(new g(this));
            this.i.addListener(new h(this));
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.l = ofFloat3;
            ofFloat3.setDuration(416L);
            this.l.addUpdateListener(new i(this));
            this.l.addListener(new j(this));
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.m = ofFloat4;
            ofFloat4.setDuration(200L);
            this.m.addUpdateListener(new k(this));
            this.m.addListener(new l(this));
            ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.o = ofFloat5;
            ofFloat5.setDuration(240L);
            this.o.addUpdateListener(new m(this));
            this.n.addListener(new a(this));
            ValueAnimator ofFloat6 = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.p = ofFloat6;
            ofFloat6.setDuration(200L);
            this.p.addUpdateListener(new b(this));
            this.p.addListener(new c(this));
            this.u.j.setVisibility(0);
            this.u.g.setVisibility(0);
            this.u.m.setVisibility(0);
            this.u.p.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.u.x.setVisibility(0);
            if (this.u.A.getVisibility() != 8) {
                this.u.A.setVisibility(0);
            }
            this.q = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds360);
            this.s = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds25);
            this.r = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds177);
            this.n.play(this.o);
        }
    }
}
