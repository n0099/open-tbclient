package d.a.s0.a4;

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
import d.a.s0.a4.a;
import d.a.s0.a4.g;
/* loaded from: classes9.dex */
public class d extends d.a.s0.a4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f57359h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f57360i;
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
    public a.c u;
    public d.a.s0.w.d v;

    /* loaded from: classes9.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57361e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57361e = dVar;
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
                d.a.s0.w.e eVar = new d.a.s0.w.e(this.f57361e.s);
                eVar.d(0.5f);
                eVar.f(800.0f);
                d dVar = this.f57361e;
                d.a.s0.w.d dVar2 = new d.a.s0.w.d(this.f57361e.u.C, d.a.s0.w.b.m);
                dVar2.l(eVar);
                dVar.v = dVar2;
                this.f57361e.v.g();
                this.f57361e.u.C.setTranslationY(0.0f);
                d dVar3 = this.f57361e;
                dVar3.f57398e = 2;
                g.a aVar = dVar3.f57397d;
                if (aVar != null) {
                    aVar.a(2);
                }
                this.f57361e.u.q.setClickable(true);
                this.f57361e.u.n.setClickable(true);
                this.f57361e.u.k.setClickable(true);
                this.f57361e.u.f57333h.setClickable(true);
                this.f57361e.u.s.setClickable(true);
                this.f57361e.u.v.setClickable(true);
                this.f57361e.u.y.setClickable(true);
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
                this.f57361e.u.q.setClickable(false);
                this.f57361e.u.n.setClickable(false);
                this.f57361e.u.k.setClickable(false);
                this.f57361e.u.f57333h.setClickable(false);
                this.f57361e.u.s.setClickable(false);
                this.f57361e.u.v.setClickable(false);
                this.f57361e.u.y.setClickable(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57362e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57362e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f57362e.u.C.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f57362e.u.C.setTranslationY(this.f57362e.r * valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57363e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57363e = dVar;
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
                this.f57363e.u.C.setAlpha(0.0f);
                this.f57363e.u.C.setTranslationY(this.f57363e.r);
                this.f57363e.y();
                this.f57363e.u.q.setClickable(true);
                this.f57363e.u.n.setClickable(true);
                this.f57363e.u.k.setClickable(true);
                this.f57363e.u.f57333h.setClickable(true);
                this.f57363e.u.s.setClickable(true);
                this.f57363e.u.v.setClickable(true);
                this.f57363e.u.y.setClickable(true);
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
                this.f57363e.u.q.setClickable(false);
                this.f57363e.u.n.setClickable(false);
                this.f57363e.u.k.setClickable(false);
                this.f57363e.u.f57333h.setClickable(false);
                this.f57363e.u.s.setClickable(false);
                this.f57363e.u.v.setClickable(false);
                this.f57363e.u.y.setClickable(false);
            }
        }
    }

    /* renamed from: d.a.s0.a4.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1309d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57364e;

        public RunnableC1309d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57364e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f57364e;
                if (dVar.f57399f != null && dVar.j == 0.0f && this.f57364e.k == 0.0f) {
                    this.f57364e.u.B.getGlobalVisibleRect(this.f57364e.f57400g);
                    d dVar2 = this.f57364e;
                    dVar2.j = dVar2.f57399f.centerX() - this.f57364e.f57400g.centerX();
                    d dVar3 = this.f57364e;
                    dVar3.k = dVar3.f57399f.centerY() - this.f57364e.f57400g.centerY();
                }
                this.f57364e.u.B.setVisibility(0);
                this.f57364e.u.B.setTranslationX(this.f57364e.j);
                this.f57364e.u.B.setTranslationY(this.f57364e.k);
                d dVar4 = this.f57364e;
                View view = dVar4.f57396c;
                if (view instanceof OvalActionButton) {
                    ((OvalActionButton) view).b(dVar4.u.B);
                }
                this.f57364e.f57359h.start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57365e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57365e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (!(this.f57365e.j == 0.0f && this.f57365e.k == 0.0f) && valueAnimator.isRunning()) {
                    this.f57365e.u.B.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    this.f57365e.u.B.setTranslationX(this.f57365e.j - (this.f57365e.j * valueAnimator.getAnimatedFraction()));
                    this.f57365e.u.B.setTranslationY(this.f57365e.k - (this.f57365e.k * valueAnimator.getAnimatedFraction()));
                    this.f57365e.u.B.setRotation(valueAnimator.getAnimatedFraction() * (-90.0f));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57366e;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57366e = dVar;
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
                this.f57366e.u.B.setTranslationX(0.0f);
                this.f57366e.u.B.setTranslationY(0.0f);
                this.f57366e.u.B.setRotation(-90.0f);
                this.f57366e.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, this.f57366e.t, "webp");
                this.f57366e.u.B.setCrossFade(1.0f, false);
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
                View view = this.f57366e.f57396c;
                if (view != null) {
                    view.setVisibility(4);
                    this.f57366e.f57396c.setAlpha(0.0f);
                }
                this.f57366e.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, this.f57366e.t, "webp");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57367e;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57367e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (!(this.f57367e.j == 0.0f && this.f57367e.k == 0.0f) && valueAnimator.isRunning()) {
                    this.f57367e.u.B.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    this.f57367e.u.B.setTranslationX(this.f57367e.j * valueAnimator.getAnimatedFraction());
                    this.f57367e.u.B.setTranslationY(this.f57367e.k * valueAnimator.getAnimatedFraction());
                    this.f57367e.u.B.setRotation((valueAnimator.getAnimatedFraction() * 90.0f) - 90.0f);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57368e;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57368e = dVar;
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
                this.f57368e.u.B.setTranslationX(this.f57368e.j);
                this.f57368e.u.B.setTranslationY(this.f57368e.k);
                this.f57368e.u.B.setRotation(0.0f);
                this.f57368e.u.B.setEndIcon(0, 0, "");
                this.f57368e.u.B.setCrossFade(1.0f, true);
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
                this.f57368e.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, this.f57368e.t, "webp");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57369e;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57369e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f57369e.u.C.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f57369e.u.f57330e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f57369e.u.f57331f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57370e;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57370e = dVar;
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
                this.f57370e.u.C.setAlpha(1.0f);
                this.f57370e.u.f57330e.setAlpha(1.0f);
                this.f57370e.u.f57331f.setAlpha(1.0f);
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

    /* loaded from: classes9.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57371e;

        public k(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57371e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f57371e.u.f57330e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f57371e.u.f57331f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57372e;

        public l(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57372e = dVar;
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
                this.f57372e.u.f57330e.setAlpha(0.0f);
                this.f57372e.u.f57331f.setAlpha(0.0f);
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

    /* loaded from: classes9.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57373e;

        public m(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57373e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f57373e.u.C.setTranslationY(this.f57373e.q - (this.f57373e.q * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, a.c cVar) {
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
                super((Context) objArr2[0], (d.a.s0.a4.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.u = cVar;
        this.t = d.a.c.e.p.l.g(this.f57394a, R.dimen.tbds0);
        x();
    }

    @Override // d.a.s0.a4.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            y();
        }
    }

    @Override // d.a.s0.a4.g
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v();
        }
    }

    @Override // d.a.s0.a4.g
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f57398e == 4) {
            this.f57398e = 1;
            g.a aVar = this.f57397d;
            if (aVar != null) {
                aVar.a(1);
            }
            v();
            z(0);
            this.l.start();
            this.n.start();
            w();
        }
    }

    @Override // d.a.s0.a4.g
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f57398e == 2) {
            this.f57398e = 3;
            g.a aVar = this.f57397d;
            if (aVar != null) {
                aVar.a(3);
            }
            v();
            this.m.start();
            this.f57360i.start();
            this.p.start();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f57359h.cancel();
            this.f57360i.cancel();
            this.m.cancel();
            this.l.cancel();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.u.B.post(new RunnableC1309d(this));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.n = new AnimatorSet();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f57359h = ofFloat;
            ofFloat.setDuration(450L);
            this.f57359h.setInterpolator(new OvershootInterpolator());
            this.f57359h.addUpdateListener(new e(this));
            this.f57359h.addListener(new f(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f57360i = ofFloat2;
            ofFloat2.setDuration(450L);
            this.f57360i.setInterpolator(new AccelerateInterpolator());
            this.f57360i.addUpdateListener(new g(this));
            this.f57360i.addListener(new h(this));
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
            this.u.f57332g.setVisibility(0);
            this.u.m.setVisibility(0);
            this.u.p.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.u.s.setVisibility(0);
            if (this.u.v.getVisibility() != 8) {
                this.u.v.setVisibility(0);
            }
            this.q = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds360);
            this.s = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds25);
            this.r = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds177);
            this.n.play(this.o);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View view = this.f57396c;
            if (view != null) {
                view.setVisibility(0);
            }
            this.f57398e = 4;
            v();
            z(8);
            this.u.B.setVisibility(4);
            View view2 = this.f57396c;
            if (view2 != null) {
                view2.setVisibility(0);
                this.f57396c.setAlpha(1.0f);
            }
            g.a aVar = this.f57397d;
            if (aVar != null) {
                aVar.a(this.f57398e);
            }
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.u.f57331f.setVisibility(i2);
            this.u.f57330e.setVisibility(i2);
            this.u.C.setVisibility(i2);
        }
    }
}
