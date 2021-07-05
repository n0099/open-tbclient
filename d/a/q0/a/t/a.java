package d.a.q0.a.t;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdShimmerView;
import com.baidu.swan.apps.view.SwanAppLaunchCircleAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.r1.h;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<AnimatorSet> f50630a;

    /* renamed from: b  reason: collision with root package name */
    public BdShimmerView f50631b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppLaunchCircleAnimationView f50632c;

    /* renamed from: d.a.q0.a.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0939a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f50633e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50634f;

        public RunnableC0939a(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50634f = aVar;
            this.f50633e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50633e.isFinishing()) {
                return;
            }
            if (this.f50634f.f50630a != null) {
                for (AnimatorSet animatorSet : this.f50634f.f50630a) {
                    animatorSet.cancel();
                }
            }
            this.f50633e.getFloatLayer().g();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f50635e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50636f;

        public b(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50636f = aVar;
            this.f50635e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f50636f.f50632c != null) {
                    this.f50636f.f50632c.setVisibility(4);
                    this.f50636f.f50632c.i();
                }
                if (this.f50636f.f50631b != null) {
                    this.f50636f.f50631b.u();
                }
                this.f50636f.k(this.f50635e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f50637a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f50638b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Runnable f50639c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f50640d;

        public c(a aVar, SwanAppActivity swanAppActivity, Handler handler, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity, handler, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50640d = aVar;
            this.f50637a = swanAppActivity;
            this.f50638b = handler;
            this.f50639c = runnable;
        }

        @Override // d.a.q0.a.t.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f50640d.f50632c != null) {
                    this.f50640d.f50632c.setVisibility(4);
                    this.f50640d.f50632c.i();
                }
                if (this.f50640d.f50631b != null) {
                    this.f50640d.f50631b.u();
                }
                this.f50640d.k(this.f50637a);
                this.f50638b.removeCallbacks(this.f50639c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f50641e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50642f;

        /* renamed from: d.a.q0.a.t.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0940a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f50643e;

            public C0940a(d dVar) {
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
                this.f50643e = dVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f50643e.f50641e.isFinishing()) {
                    return;
                }
                this.f50643e.f50641e.getLoadingView().f51595a.setVisibility(8);
                this.f50643e.f50641e.getLoadingView().J();
                this.f50643e.f50641e.getFloatLayer().g();
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
                if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f50643e.f50641e.isFinishing()) {
                    return;
                }
                this.f50643e.f50641e.getLoadingView().w();
            }
        }

        public d(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50642f = aVar;
            this.f50641e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(this.f50642f.f(this.f50641e, 150L));
                animatorSet.addListener(new C0940a(this));
                animatorSet.start();
                this.f50642f.f50630a.add(animatorSet);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f50644e;

        public e(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50644e = swanAppActivity;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f50644e.isFinishing()) {
                return;
            }
            this.f50644e.getLoadingView().f51595a.setVisibility(8);
            this.f50644e.getLoadingView().J();
            this.f50644e.getFloatLayer().g();
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f50644e.isFinishing()) {
                return;
            }
            this.f50644e.getLoadingView().w();
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50630a = new CopyOnWriteArrayList();
    }

    public final ObjectAnimator f(SwanAppActivity swanAppActivity, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, swanAppActivity, j)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f51595a, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(j);
            return ofFloat;
        }
        return (ObjectAnimator) invokeLJ.objValue;
    }

    public final AnimatorSet g(SwanAppActivity swanAppActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f51598d, "translationX", -n0.f(AppRuntime.getAppContext(), 9.5f), n0.f(AppRuntime.getAppContext(), 9.5f));
            ofFloat.setDuration(380L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f51599e, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 19.0f));
            ofFloat2.setDuration(380L);
            ofFloat2.setRepeatMode(2);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).with(ofFloat2);
            return animatorSet;
        }
        return (AnimatorSet) invokeL.objValue;
    }

    public final AnimatorSet h(SwanAppActivity swanAppActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanAppActivity)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f51598d, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 9.5f));
            ofFloat.setDuration(240L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f51599e, "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(240L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).with(ofFloat2);
            return animatorSet;
        }
        return (AnimatorSet) invokeL.objValue;
    }

    public final void i(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, swanAppActivity) == null) {
            Handler i2 = d.a.q0.a.a2.d.i();
            b bVar = new b(this, swanAppActivity);
            i2.postDelayed(bVar, d.a.q0.a.r1.l.b.c());
            SwanAppSlaveManager.m1(new c(this, swanAppActivity, i2, bVar));
        }
    }

    public final void j(SwanAppActivity swanAppActivity) {
        d.a.q0.a.w2.e loadingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, swanAppActivity) == null) || swanAppActivity.isFinishing() || (loadingView = swanAppActivity.getLoadingView()) == null) {
            return;
        }
        if (d.a.q0.a.r1.l.b.d() != 1 && d.a.q0.a.r1.l.b.d() != 3) {
            loadingView.f51595a.setVisibility(8);
            if (!d.a.q0.a.c1.a.Z().G()) {
                List<AnimatorSet> list = this.f50630a;
                if (list != null) {
                    for (AnimatorSet animatorSet : list) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.getFloatLayer().g();
                return;
            }
            q0.X(new RunnableC0939a(this, swanAppActivity));
            return;
        }
        i(swanAppActivity);
    }

    public final void k(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, swanAppActivity) == null) {
            q0.X(new d(this, swanAppActivity));
        }
    }

    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppActivity) == null) {
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) swanAppActivity.findViewById(d.a.q0.a.f.App_Launch_Circle_Animation_View);
            this.f50632c = swanAppLaunchCircleAnimationView;
            swanAppLaunchCircleAnimationView.h();
            h.o().C(new UbcFlowEvent("first_anim_start"));
            d.a.q0.a.i2.a.d().i("first_anim_start");
        }
    }

    public final void m(SwanAppActivity swanAppActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, swanAppActivity, z) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            int i2 = z ? 100 : 0;
            animatorSet.play(f(swanAppActivity, 150L));
            animatorSet.addListener(new e(this, swanAppActivity));
            animatorSet.setStartDelay(i2);
            animatorSet.start();
            this.f50630a.add(animatorSet);
        }
    }

    public void n(SwanAppActivity swanAppActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, swanAppActivity, i2) == null) {
            if (i2 == 1) {
                j(swanAppActivity);
            } else if (i2 == 2) {
                m(swanAppActivity, false);
            } else if (i2 != 3) {
                j(swanAppActivity);
            } else {
                m(swanAppActivity, true);
            }
        }
    }

    public void o(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, swanAppActivity) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(h(swanAppActivity)).before(g(swanAppActivity));
            animatorSet.start();
            h.o().C(new UbcFlowEvent("first_anim_start"));
            d.a.q0.a.i2.a.d().i("first_anim_start");
            this.f50630a.add(animatorSet);
        }
    }

    public void p(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, swanAppActivity) == null) {
            BdShimmerView bdShimmerView = (BdShimmerView) swanAppActivity.findViewById(d.a.q0.a.f.App_Launch_Shimmer_Animation_View);
            this.f50631b = bdShimmerView;
            if (bdShimmerView == null) {
                return;
            }
            bdShimmerView.setType(1);
            this.f50631b.o();
            h.o().C(new UbcFlowEvent("first_anim_start"));
            d.a.q0.a.i2.a.d().i("first_anim_start");
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            for (AnimatorSet animatorSet : this.f50630a) {
                animatorSet.removeAllListeners();
                animatorSet.cancel();
            }
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = this.f50632c;
            if (swanAppLaunchCircleAnimationView != null) {
                swanAppLaunchCircleAnimationView.i();
            }
            BdShimmerView bdShimmerView = this.f50631b;
            if (bdShimmerView != null) {
                bdShimmerView.u();
            }
            this.f50630a.clear();
        }
    }
}
