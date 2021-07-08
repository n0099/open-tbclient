package d.a.p0.h2.k.e.c1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f57177a;

    /* renamed from: b  reason: collision with root package name */
    public Animator f57178b;

    /* renamed from: c  reason: collision with root package name */
    public Animator f57179c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f57180d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f57181e;

    /* renamed from: f  reason: collision with root package name */
    public AnimatorSet f57182f;

    /* renamed from: g  reason: collision with root package name */
    public AnimatorSet f57183g;

    /* renamed from: h  reason: collision with root package name */
    public View f57184h;

    /* renamed from: i  reason: collision with root package name */
    public View f57185i;
    public View j;
    public View k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public final Handler.Callback v;
    public final Handler w;

    /* loaded from: classes8.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57186e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57186e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if ((i2 == 1 || i2 == 2) && this.f57186e.o()) {
                    this.f57186e.w.sendEmptyMessageDelayed(message.what, 100L);
                    return true;
                }
                int i3 = message.what;
                if (i3 == 1) {
                    this.f57186e.D();
                    return true;
                } else if (i3 == 2) {
                    this.f57186e.C();
                    return true;
                } else if (i3 != 3) {
                    return false;
                } else {
                    this.f57186e.B();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: d.a.p0.h2.k.e.c1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1417b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57187e;

        public C1417b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57187e = bVar;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f57187e.f57184h == null) {
                return;
            }
            this.f57187e.f57184h.clearAnimation();
            if (this.f57187e.s) {
                this.f57187e.v(false);
            } else {
                this.f57187e.v(true);
            }
            if (this.f57187e.f57177a != null) {
                this.f57187e.f57177a.a(false);
            }
            this.f57187e.j.clearAnimation();
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

    /* loaded from: classes8.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57188e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57188e = bVar;
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
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                ViewGroup.LayoutParams layoutParams = this.f57188e.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.f57188e.l;
                    this.f57188e.k.setLayoutParams(layoutParams);
                }
                this.f57188e.k.setVisibility(0);
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
                ViewGroup.LayoutParams layoutParams = this.f57188e.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    this.f57188e.k.setLayoutParams(layoutParams);
                }
                this.f57188e.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57189e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57189e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = this.f57189e.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = num.intValue();
                    this.f57189e.k.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57190e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57190e = bVar;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f57190e.f57184h == null) {
                return;
            }
            this.f57190e.f57184h.clearAnimation();
            this.f57190e.f57184h.setVisibility(0);
            this.f57190e.v(false);
            if (this.f57190e.f57177a != null) {
                this.f57190e.f57177a.a(true);
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

    /* loaded from: classes8.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57191e;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57191e = bVar;
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
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f57191e.k.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.f57191e.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    this.f57191e.k.setLayoutParams(layoutParams);
                }
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
                this.f57191e.k.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.f57191e.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.f57191e.l;
                    this.f57191e.k.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57192e;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57192e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = this.f57192e.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = num.intValue();
                    this.f57192e.k.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface h {
        void a(boolean z);
    }

    public b(Context context, View view, View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, view2, view3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = UtilHelper.getLightStatusBarHeight();
        this.m = false;
        this.o = false;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = true;
        this.v = new a(this);
        this.w = new Handler(this.v);
        this.f57184h = view;
        this.f57185i = view2;
        this.j = view3;
        this.k = view3.findViewById(R.id.sticky_view);
        this.n = UtilHelper.canUseStyleImmersiveSticky();
        j();
        v(false);
    }

    public void A(boolean z, boolean z2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (view = this.f57184h) == null || view.getY() != 0.0f || o()) {
            return;
        }
        if (z2) {
            this.f57184h.setVisibility(8);
            if (this.s) {
                v(false);
                return;
            } else {
                v(true);
                return;
            }
        }
        this.f57184h.setVisibility(0);
        if (this.f57183g == null) {
            m();
        }
        AnimatorSet animatorSet = this.f57183g;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f57183g.setDuration(300L).start();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            A(false, true);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            A(false, false);
        }
    }

    public void D() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (view = this.f57184h) == null || view.getY() >= 0.0f || o()) {
            return;
        }
        this.f57184h.setVisibility(0);
        if (this.f57182f == null) {
            n();
        }
        AnimatorSet animatorSet = this.f57182f;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f57182f.setDuration(300L).start();
        }
    }

    public boolean i(AbsListView absListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, absListView)) == null) {
            if (absListView != null) {
                return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (view = this.f57185i) == null) {
            return;
        }
        if (this.n && view.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.f57185i.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.f57185i.setLayoutParams(layoutParams);
            v(true);
            return;
        }
        v(false);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.w.removeCallbacksAndMessages(null);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.u) {
            if (this.o) {
                v(true);
            } else if (this.f57184h == null || this.q || this.r || !p()) {
            } else {
                Log.i("PbView", "hideFloatingView: startDragDown");
                y();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View view = this.f57184h;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", (-view.getMeasuredHeight()) + this.j.getMeasuredHeight());
            this.f57178b = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.f57178b.addListener(new C1417b(this));
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.l);
            this.f57181e = ofInt;
            ofInt.setInterpolator(new LinearInterpolator());
            this.f57181e.addListener(new c(this));
            this.f57181e.addUpdateListener(new d(this));
            AnimatorSet animatorSet = new AnimatorSet();
            this.f57183g = animatorSet;
            animatorSet.play(this.f57178b).with(this.f57181e);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f57184h, "translationY", 0.0f);
            this.f57179c = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.f57179c.addListener(new e(this));
            ValueAnimator ofInt = ValueAnimator.ofInt(this.l, 0);
            this.f57180d = ofInt;
            ofInt.setInterpolator(new LinearInterpolator());
            this.f57180d.addListener(new f(this));
            this.f57180d.addUpdateListener(new g(this));
            AnimatorSet animatorSet = new AnimatorSet();
            this.f57182f = animatorSet;
            animatorSet.play(this.f57179c).with(this.f57180d);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        AnimatorSet animatorSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            AnimatorSet animatorSet2 = this.f57182f;
            return (animatorSet2 != null && animatorSet2.isRunning()) || ((animatorSet = this.f57183g) != null && animatorSet.isRunning());
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f57184h.getVisibility() == 0 && this.f57184h.getY() >= 0.0f : invokeV.booleanValue;
    }

    public void q(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048588, this, absListView, i2, i3, i4) == null) || !this.u || this.f57184h == null || this.q || this.r || !this.m) {
            return;
        }
        if (i2 > this.p && p()) {
            Log.i("PbView", "onScroll hideFloatingView");
            l();
        } else if (i2 < this.p && !p()) {
            Log.i("PbView", "onScroll showFloatingView");
            x();
        }
        this.p = i2;
    }

    public void r(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, absListView, i2) == null) {
            if (i2 == 1) {
                this.m = true;
            } else if (i2 == 0) {
                this.m = false;
            }
            if (!this.u || this.q || this.r) {
                return;
            }
            if (this.o) {
                v(true);
            } else if (absListView == null || i2 != 0) {
            } else {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                int i3 = this.p;
                if (firstVisiblePosition > i3) {
                    y();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < i3) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    z();
                } else if (firstVisiblePosition == i3) {
                    if (firstVisiblePosition != 0 && this.t && !i(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragDown:");
                        y();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                    z();
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.r = z;
        }
    }

    public void t(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hVar) == null) {
            this.f57177a = hVar;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.t = z;
        }
    }

    public final void v(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (view = this.f57185i) == null) {
            return;
        }
        if (this.n && z && view.getVisibility() != 0) {
            this.f57185i.setVisibility(0);
        } else if (z || this.f57185i.getVisibility() == 8) {
        } else {
            this.f57185i.setVisibility(8);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.q = z;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.u) {
            if (this.o) {
                v(true);
            } else if (this.f57184h == null || p()) {
            } else {
                Log.i("PbView", "showFloatingView: startDragUp");
                z();
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.w.removeMessages(1);
            if (this.w.hasMessages(2)) {
                return;
            }
            this.w.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.w.removeMessages(2);
            if (this.w.hasMessages(1)) {
                return;
            }
            this.w.sendEmptyMessageDelayed(1, 60L);
        }
    }
}
