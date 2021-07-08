package d.a.p0.l0.m;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.GuidePopupWindow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.g.d;
import d.a.c.k.e.c;
import d.a.o0.r.f0.f;
import d.a.o0.r.q.p1;
import d.a.o0.r.q.q1;
import d.a.o0.r.q.x;
import d.a.p0.l0.m.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements EnterForumAdView.c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean M;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public int B;
    public int C;
    public CustomMessageListener D;
    public boolean E;
    public boolean F;
    public Runnable G;
    public View H;
    public float I;
    public ImageView J;
    public boolean K;
    public boolean L;

    /* renamed from: a  reason: collision with root package name */
    public Context f59832a;

    /* renamed from: b  reason: collision with root package name */
    public final EnterForumFragment f59833b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.r.f0.g f59834c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f59835d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.l0.c.a f59836e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.p0.l0.d.f> f59837f;

    /* renamed from: g  reason: collision with root package name */
    public p1 f59838g;

    /* renamed from: h  reason: collision with root package name */
    public ViewEventCenter f59839h;

    /* renamed from: i  reason: collision with root package name */
    public CommonTipView f59840i;
    public View j;
    public d.a.o0.d0.h k;
    public View l;
    public EnterForumAdView m;
    public View n;
    public GuidePopupWindow o;
    public d.a.c.e.g.c p;
    public int q;
    public d.a.p0.l0.m.e r;
    public d.a.p0.l0.d.c s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public f.g x;
    public f.g y;
    public AbsListView.OnScrollListener z;

    /* loaded from: classes8.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59841e;

        /* renamed from: d.a.p0.l0.m.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1530a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f59842e;

            public RunnableC1530a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59842e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f59842e.f59841e.f59835d.setSelection(0);
                }
            }
        }

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
            this.f59841e = bVar;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f59841e.K) {
                return;
            }
            d.a.p0.g3.c.g().j(this.f59841e.f59833b.getUniqueId());
            if (this.f59841e.x != null) {
                this.f59841e.x.onListPullRefresh(z);
            }
            if (z) {
                b bVar = this.f59841e;
                if (bVar.E || bVar.s == null || !this.f59841e.s.f59543a) {
                    return;
                }
                if (this.f59841e.s.f59545c > 0) {
                    this.f59841e.f59835d.E(0, 0, 0);
                    this.f59841e.i0();
                    return;
                }
                d.a.c.e.m.e.a().post(new RunnableC1530a(this));
            }
        }
    }

    /* renamed from: d.a.p0.l0.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1531b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1531b(b bVar) {
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
                }
            }
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59843e;

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
            this.f59843e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59843e.p == null) {
                return;
            }
            this.f59843e.p.d();
            this.f59843e.p = null;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59844e;

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
            this.f59844e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                EnterForumAdView.c(this.f59844e.f59833b.getPageContext().getUniqueId(), this.f59844e.f59832a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f59845e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f59846f;

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
            this.f59846f = bVar;
            this.f59845e = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f59846f.I = motionEvent.getRawY();
                } else if (action == 1) {
                    if (this.f59846f.I <= (this.f59846f.f59832a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.f59846f.I) {
                        this.f59846f.h0();
                        if (this.f59845e < 50.0f) {
                            this.f59846f.H.performClick();
                        }
                    } else {
                        this.f59846f.c0();
                    }
                    this.f59846f.I = 0.0f;
                    this.f59845e = 0.0f;
                } else if (action != 2) {
                    if (this.f59846f.I <= (this.f59846f.f59832a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.f59846f.I) {
                        this.f59846f.h0();
                    } else {
                        this.f59846f.c0();
                    }
                    this.f59846f.I = 0.0f;
                    this.f59845e = 0.0f;
                } else {
                    if (motionEvent.getRawY() < this.f59846f.I) {
                        this.f59846f.l0(motionEvent.getRawY() - this.f59846f.I);
                        if (this.f59846f.J != null) {
                            this.f59846f.J.setVisibility(8);
                        }
                    }
                    if (Math.abs(motionEvent.getRawY() - this.f59846f.I) > this.f59845e) {
                        this.f59845e = Math.abs(motionEvent.getRawY() - this.f59846f.I);
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59847e;

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
            this.f59847e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59847e.c0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59848e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f59849f;

        public g(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59849f = bVar;
            this.f59848e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup viewGroup;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (this.f59849f.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.f59849f.m.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        this.f59849f.I();
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMargins(0, intValue, 0, 0);
                        this.f59849f.m.setLayoutParams(marginLayoutParams);
                        if (intValue / this.f59848e < 0.2d) {
                            if (this.f59849f.m.getParent() != this.f59849f.m.getRootView() && (viewGroup = (ViewGroup) this.f59849f.m.getRootView()) != null) {
                                ((ViewGroup) this.f59849f.m.getParent()).removeView(this.f59849f.m);
                                if (this.f59849f.m.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                    viewGroup.addView(this.f59849f.m, marginLayoutParams2);
                                }
                                viewGroup.bringChildToFront(this.f59849f.H);
                                viewGroup.bringChildToFront(this.f59849f.J);
                            }
                        } else if (this.f59849f.m.getParent() == this.f59849f.m.getRootView()) {
                            if (this.f59849f.m.getParent() != null) {
                                ViewGroup viewGroup2 = (ViewGroup) this.f59849f.m.getRootView();
                                ((ViewGroup) this.f59849f.m.getParent()).removeView(this.f59849f.m);
                            }
                            if (this.f59849f.m.getParent() == null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                this.f59849f.f59833b.J0().addView(this.f59849f.m, 0, marginLayoutParams3);
                            }
                        }
                    }
                }
                this.f59849f.K = false;
                this.f59849f.p0(((intValue - this.f59848e) * 2) + 0);
                this.f59849f.K = true;
                float abs = Math.abs(intValue / this.f59848e);
                this.f59849f.f59835d.setAlpha(abs);
                View w = this.f59849f.f59833b.L0().w();
                if (w != null) {
                    w.setAlpha(abs);
                }
                View findViewById = this.f59849f.f59833b.J0().getRootView().findViewById(R.id.tabcontainer_wrapper);
                if (findViewById != null) {
                    findViewById.setAlpha(abs);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59850e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f59851f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f59852g;

        public h(b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59852g = bVar;
            this.f59850e = i2;
            this.f59851f = view;
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
                if (this.f59852g.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.f59852g.m.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        this.f59852g.I();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams2.setMargins(0, 0, 0, 0);
                        this.f59852g.m.setLayoutParams(layoutParams2);
                    }
                }
                this.f59852g.f59834c.A();
                this.f59852g.f59835d.z();
                this.f59852g.f59834c.D(0, -this.f59852g.f59834c.q(), 0, 0);
                this.f59852g.K = false;
                this.f59852g.p0(0 - (this.f59850e * 2));
                this.f59852g.K = true;
                this.f59852g.f59835d.setVisibility(8);
                this.f59852g.H.setEnabled(true);
                FrameLayout frameLayout = (FrameLayout) this.f59851f;
                if (this.f59852g.H.getParent() == null) {
                    frameLayout.addView(this.f59852g.H, new FrameLayout.LayoutParams(-1, -1));
                }
                if (this.f59852g.J.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.bottomMargin = this.f59852g.f59832a.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                    layoutParams3.gravity = 81;
                    frameLayout.addView(this.f59852g.J, layoutParams3);
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
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59853e;

        public i(b bVar) {
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
            this.f59853e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f59853e.l0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59854e;

        public j(b bVar) {
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
            this.f59854e = bVar;
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
                this.f59854e.l0(0.0f);
                this.f59854e.f59834c.A();
                this.f59854e.f59835d.z();
                this.f59854e.f59834c.D(0, -this.f59854e.f59834c.q(), 0, 0);
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
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59855e;

        public k(b bVar) {
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
            this.f59855e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f59855e.l0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59856e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f59857e;

            /* renamed from: d.a.p0.l0.m.b$l$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC1532a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f59858e;

                public RunnableC1532a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59858e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f59858e.f59857e.f59856e.K = false;
                    }
                }
            }

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59857e = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ViewGroup viewGroup = (ViewGroup) this.f59857e.f59856e.H.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f59857e.f59856e.H);
                        viewGroup.removeView(this.f59857e.f59856e.J);
                    }
                    this.f59857e.f59856e.J.setVisibility(0);
                    this.f59857e.f59856e.K = false;
                    this.f59857e.f59856e.k0();
                    this.f59857e.f59856e.C = 0;
                    this.f59857e.f59856e.p0(0);
                    this.f59857e.f59856e.K = true;
                    this.f59857e.f59856e.f59834c.A();
                    this.f59857e.f59856e.f59835d.z();
                    this.f59857e.f59856e.f59834c.D(0, -this.f59857e.f59856e.f59834c.q(), 0, 0);
                    d.a.c.e.m.e.a().postDelayed(new RunnableC1532a(this), 0L);
                    this.f59857e.f59856e.f59835d.setVisibility(0);
                }
            }
        }

        public l(b bVar) {
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
            this.f59856e = bVar;
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
                d.a.c.e.m.e.a().post(new a(this));
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
    public class m implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f59859e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f59860f;

        public m(b bVar) {
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
            this.f59860f = bVar;
            this.f59859e = -1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                if (this.f59860f.f59833b.isPrimary() && this.f59859e != 1 && i2 == 0) {
                    for (int i5 = i2; i5 < i2 + i3; i5++) {
                        Object itemAtPosition = this.f59860f.f59835d.getItemAtPosition(i5);
                        if (itemAtPosition != null && (itemAtPosition instanceof x)) {
                            x xVar = (x) itemAtPosition;
                            if (xVar.c() == 1 && this.f59860f.f59835d.getItemAtPosition(i5) == ListUtils.getItem(this.f59860f.f59837f, 0)) {
                                this.f59860f.v0(xVar, this.f59860f.f59835d.getChildAt(i5).findViewById(R.id.forum_intro));
                            }
                        }
                    }
                }
                this.f59860f.r.onScroll(absListView, i2, i3, i4);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                this.f59860f.r.onScrollStateChanged(absListView, i2);
                if (this.f59859e != i2) {
                    this.f59859e = i2;
                    if (i2 == 1) {
                        if (this.f59860f.s == null || !this.f59860f.s.f59543a) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
                        }
                        this.f59860f.N();
                        return;
                    }
                    this.f59860f.E();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59861e;

        public n(b bVar) {
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
            this.f59861e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f59861e.s != null && this.f59861e.s.f59543a) {
                b bVar = this.f59861e;
                if (bVar.E) {
                    EnterForumAdView unused = bVar.m;
                    EnterForumAdView.c(this.f59861e.f59833b.getUniqueId(), this.f59861e.f59833b.getContext());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59862a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59862a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f59862a.u0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59863a;

        public p(b bVar) {
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
            this.f59863a = bVar;
        }

        @Override // d.a.p0.l0.m.e.c
        public void a(AbsListView absListView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048576, this, absListView, i2, i3) == null) || this.f59863a.K) {
                return;
            }
            this.f59863a.B = -i2;
            b bVar = this.f59863a;
            if (bVar.E) {
                bVar.d0();
            } else if (bVar.s == null || !this.f59863a.s.f59543a) {
            } else {
                this.f59863a.k0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59864a;

        public q(b bVar) {
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
            this.f59864a = bVar;
        }

        @Override // d.a.c.k.e.c.a
        public void a(d.a.c.k.e.c cVar, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f59864a.C = i4;
                b bVar = this.f59864a;
                if (bVar.E || bVar.s == null || !this.f59864a.s.f59543a || this.f59864a.K) {
                    return;
                }
                this.f59864a.k0();
                if (i4 > this.f59864a.w) {
                    this.f59864a.C = 0;
                    b bVar2 = this.f59864a;
                    bVar2.t0(bVar2.f59833b.L0().u());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59865e;

        public r(b bVar) {
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
            this.f59865e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59865e.d0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59866e;

        public s(b bVar) {
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
            this.f59866e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59866e.O();
                this.f59866e.x0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements d.a.c.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59867a;

        public t(b bVar) {
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
            this.f59867a = bVar;
        }

        @Override // d.a.c.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tips)).setText(this.f59867a.q);
                this.f59867a.f59833b.getPageContext().getLayoutMode().j(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1463859996, "Ld/a/p0/l0/m/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1463859996, "Ld/a/p0/l0/m/b;");
        }
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumFragment, view, viewEventCenter, recentlyVisitedForumModel, enterForumModel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = true;
        this.y = new a(this);
        this.z = new m(this);
        this.A = new n(this);
        this.B = 0;
        this.C = 0;
        this.D = new o(this, 2921474);
        this.E = false;
        this.F = false;
        this.G = new r(this);
        this.K = false;
        this.f59833b = enterForumFragment;
        this.u = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + d.a.c.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.v = d.a.c.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.w = d.a.c.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.f59839h = viewEventCenter;
        R(view);
        d.a.p0.l0.c.a aVar = new d.a.p0.l0.c.a(this.f59833b.getPageContext(), this.f59839h, recentlyVisitedForumModel, enterForumModel, this);
        this.f59836e = aVar;
        this.f59835d.setAdapter((ListAdapter) aVar);
        W(TbadkCoreApplication.getInst().getSkinType());
        f0();
        this.o = new GuidePopupWindow(this.f59833b.getFragmentActivity());
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (U()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
                return;
            }
            d.a.p0.l0.d.c cVar = this.s;
            if (cVar != null && cVar.f59543a) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
            }
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.p0.l0.c.a aVar = this.f59836e;
            if (aVar == null) {
                return false;
            }
            return aVar.f();
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.E) {
                this.F = true;
                return;
            }
            this.F = false;
            this.f59835d.A(0L);
        }
    }

    public final int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.E ? -this.f59832a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I();
        }
        return invokeV.intValue;
    }

    public final int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59832a.getResources().getDimensionPixelOffset(R.dimen.tbds934) : invokeV.intValue;
    }

    public final int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdListView K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59835d : (BdListView) invokeV.objValue;
    }

    public final int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (this.u - this.v) - (EnterForumDelegateStatic.f14669c.B() != null ? this.f59832a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        }
        return invokeV.intValue;
    }

    public d.a.o0.d0.h M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (d.a.o0.d0.h) invokeV.objValue;
    }

    public void N() {
        d.a.c.e.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.d();
        this.p = null;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            d.a.o0.d0.h hVar = this.k;
            if (hVar != null) {
                hVar.dettachView(this.l);
                this.k = null;
                this.l = null;
            }
            this.f59835d.setVisibility(0);
            if (this.f59833b.L0() != null) {
                this.f59833b.L0().K();
                this.f59833b.L0().O();
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.c.e.p.l.g(this.f59832a, R.dimen.tbds240);
            View view = new View(this.f59832a);
            this.H = view;
            view.setOnClickListener(new d(this));
            this.H.setOnTouchListener(new e(this));
            ImageView imageView = new ImageView(this.f59832a);
            this.J = imageView;
            imageView.setOnClickListener(new f(this));
        }
    }

    public void Q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            EnterForumAdView enterForumAdView = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
            this.m = enterForumAdView;
            if (enterForumAdView != null) {
                k0();
                this.m.setTag(this.f59833b.getUniqueId());
                this.m.setAdData();
                this.m.setEventCenter(this.f59839h);
                this.m.setOnBackPressedListener(this);
            }
        }
    }

    public final void R(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            this.f59832a = view.getContext();
            d.a.p0.l0.m.e eVar = new d.a.p0.l0.m.e();
            this.r = eVar;
            eVar.a(new p(this));
            this.f59835d = (BdListView) view.findViewById(R.id.listview);
            p0(0);
            this.f59835d.setBackgroundColor(0);
            this.f59835d.setVerticalScrollBarEnabled(false);
            this.f59835d.setOnScrollListener(this.z);
            this.f59835d.setFastScrollEnabled(false);
            this.f59835d.setMaxHeight(this.f59832a.getResources().getDisplayMetrics().heightPixels);
            BdListView.D(1.0f);
            if (this.f59833b.L0() != null) {
                this.f59833b.L0().R(this);
            }
            d.a.o0.r.f0.g gVar = new d.a.o0.r.f0.g(this.f59833b.getPageContext());
            this.f59834c = gVar;
            gVar.C(new q(this));
            this.f59834c.Z(true);
            this.f59834c.a(this.y);
            d.a.o0.r.f0.g gVar2 = this.f59834c;
            if (gVar2 != null) {
                gVar2.a0(this.f59833b.getUniqueId());
            }
            this.f59835d.setPullRefresh(this.f59834c);
            FrameLayout frameLayout = new FrameLayout(this.f59833b.getPageContext().getPageActivity());
            View view2 = new View(this.f59833b.getPageContext().getPageActivity());
            this.n = view2;
            frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, this.v));
            this.f59835d.getAdapter2().g(frameLayout, 0);
            this.j = new View(this.f59833b.getActivity());
            this.j.setLayoutParams(new AbsListView.LayoutParams(-1, d.a.c.e.p.l.g(this.f59833b.getActivity(), R.dimen.ds50)));
            this.j.setBackgroundResource(R.color.CAM_X0201);
            this.f59834c.S(this.A);
            this.f59834c.getView().setOnClickListener(this.A);
            this.n.setOnClickListener(this.A);
            P();
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? ListUtils.isEmpty(this.f59837f) : invokeV.booleanValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TbadkCoreApplication.isLogin() && !d.a.o0.r.d0.b.j().g("has_guide_popup_window_been_shown", false) : invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            BdListView bdListView = this.f59835d;
            return bdListView == null || bdListView.getChildCount() == 0 || this.f59835d.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f59836e.notifyDataSetChanged();
            View view = this.j;
            if (view == null || view.getLayoutParams() == null) {
                return;
            }
            if (z) {
                this.j.getLayoutParams().height = d.a.c.e.p.l.g(this.f59832a, R.dimen.ds50);
                return;
            }
            this.j.getLayoutParams().height = d.a.c.e.p.l.g(this.f59832a, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
                this.f59835d.removeFooterView(this.j);
                this.f59835d.addFooterView(this.j);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                this.f59835d.removeFooterView(this.j);
            }
            d.a.o0.r.f0.g gVar = this.f59834c;
            if (gVar != null) {
                gVar.I(i2);
            }
            d.a.o0.d0.h hVar = this.k;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            GuidePopupWindow guidePopupWindow = this.o;
            if (guidePopupWindow != null) {
                guidePopupWindow.j();
            }
            SkinManager.setBackgroundResource(this.j, R.color.CAM_X0201);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            CommonTipView commonTipView = this.f59840i;
            if (commonTipView != null) {
                commonTipView.i();
            }
            d.a.p0.l0.c.a aVar = this.f59836e;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            N();
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f59833b.isAdded() && this.f59833b.isPrimary()) {
                M = false;
                d.a.p0.l0.c.a aVar = this.f59836e;
                if (aVar != null) {
                    aVar.h();
                    BdListView bdListView = this.f59835d;
                    if (bdListView != null) {
                        Object itemAtPosition = this.f59835d.getItemAtPosition(bdListView.getLastVisiblePosition());
                        if (itemAtPosition != null && (itemAtPosition instanceof x) && ((x) itemAtPosition).c() == 5) {
                            this.f59836e.m();
                        }
                    }
                }
                if (this.K) {
                    this.m.requestFocus();
                    this.m.requestFocusFromTouch();
                    return;
                }
                return;
            }
            N();
        }
    }

    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f59836e.i(i2);
        }
    }

    public void b0() {
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || TbadkCoreApplication.getCurrentAccount() != null || !d.a.o0.r.d0.b.j().g("enter_forum_login_tip", true) || (enterForumFragment = this.f59833b) == null || enterForumFragment.getActivity() == null || this.f59833b.K0() == null) {
            return;
        }
        if (this.f59840i == null) {
            this.f59840i = new CommonTipView(this.f59833b.getActivity());
        }
        this.f59840i.setText(R.string.enter_forum_login_tip);
        this.f59840i.k(this.f59833b.K0(), TbadkCoreApplication.getInst().getSkinType());
        d.a.o0.r.d0.b.j().t("enter_forum_login_tip", false);
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.H.setEnabled(false);
            int H = H();
            Math.abs(H / (L() - H));
            this.J.setVisibility(8);
            int i2 = ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).topMargin;
            ValueAnimator ofInt = ValueAnimator.ofInt(J(), H);
            ofInt.addUpdateListener(new k(this));
            ofInt.addListener(new l(this));
            ofInt.setDuration(300L);
            ofInt.start();
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.E = false;
            k0();
            p0(0);
            if (this.F) {
                this.f59835d.A(0L);
            }
            this.F = false;
        }
    }

    public void e0(List<d.a.p0.l0.d.f> list, p1 p1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048602, this, list, p1Var, z) == null) {
            this.m.setAdData();
            EnterForumDelegateStatic.f14669c.D(this.f59832a);
            this.f59837f = list;
            this.f59838g = p1Var;
            ArrayList arrayList = new ArrayList();
            boolean z2 = !ListUtils.isEmpty(list);
            boolean z3 = !ListUtils.isEmpty(list);
            x xVar = new x();
            xVar.d(4);
            arrayList.add(xVar);
            if (z3) {
                arrayList.add(new d.a.p0.l0.d.a(true));
                arrayList.add(new d.a.p0.l0.d.e(this.f59832a.getResources().getString(R.string.my_attention_bar), z2));
                arrayList.addAll(list);
                arrayList.add(p1Var);
            } else {
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.add(new d.a.p0.l0.d.e(this.f59832a.getResources().getString(R.string.my_attention_bar), z2));
                }
                if (TbadkCoreApplication.isLogin()) {
                    x xVar2 = new x();
                    xVar2.d(11);
                    arrayList.add(xVar2);
                } else {
                    x xVar3 = new x();
                    xVar3.d(3);
                    arrayList.add(xVar3);
                }
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.add(new q1(this.f59832a.getResources().getString(R.string.recommend_forum_title_vertical), true));
                }
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.addAll(p1Var.e());
                }
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.add(new d.a.p0.l0.d.a(false));
                }
            }
            if (z) {
                x xVar4 = new x();
                xVar4.d(5);
                arrayList.add(xVar4);
            }
            O();
            this.f59836e.k(arrayList, z);
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f59833b.registerListener(this.D);
        }
    }

    public void g0(d.a.p0.l0.d.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, fVar, z) == null) {
            this.f59837f.remove(fVar);
            e0(this.f59837f, this.f59838g, z);
            V(z);
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ImageView imageView = this.J;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(J(), 0);
            ofInt.addUpdateListener(new i(this));
            ofInt.addListener(new j(this));
            ofInt.setDuration(300L);
            ofInt.start();
        }
    }

    public void i0() {
        int dimensionPixelSize;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.K) {
            return;
        }
        this.E = true;
        k0();
        int dimensionPixelOffset = this.f59832a.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.f59834c.q();
        EnterForumAdView enterForumAdView = this.m;
        if (enterForumAdView != null) {
            if (!enterForumAdView.f()) {
                dimensionPixelSize = this.f59832a.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.f59832a.getResources().getDimensionPixelSize(R.dimen.tbds134);
            } else if (!this.m.e()) {
                dimensionPixelSize = this.f59832a.getResources().getDimensionPixelSize(R.dimen.tbds370);
            }
            dimensionPixelOffset += dimensionPixelSize;
        }
        p0(dimensionPixelOffset);
        d.a.c.e.m.e.a().removeCallbacks(this.G);
        d.a.c.e.m.e.a().postDelayed(this.G, 3000L);
    }

    public void j0(d.a.p0.l0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, cVar) == null) {
            this.s = cVar;
            d.a.p0.l0.c.a aVar = this.f59836e;
            if (aVar != null) {
                aVar.j(cVar);
            }
            if (cVar != null && cVar.f59543a) {
                if (this.f59834c.getView() != null) {
                    this.f59834c.getView().setScaleX(0.5f);
                    this.f59834c.getView().setScaleY(0.5f);
                }
                this.f59834c.Q(R.raw.ad_refresh_load);
                return;
            }
            if (this.f59834c.getView() != null) {
                this.f59834c.getView().setScaleX(1.0f);
                this.f59834c.getView().setScaleY(1.0f);
            }
            this.f59834c.Q(R.raw.lottie_common_pull_refresh);
        }
    }

    public final void k0() {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.K || (enterForumAdView = this.m) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            int I = I();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(0, this.E ? -this.f59832a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I, 0, 0);
            this.m.setLayoutParams(layoutParams2);
            this.m.setAdViewHeight(layoutParams2.height - I);
        }
    }

    public final void l0(float f2) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048609, this, f2) == null) {
            int H = H();
            int L = L() - H;
            float f3 = H;
            float abs = Math.abs(f3 / L);
            int i2 = (int) f2;
            EnterForumAdView enterForumAdView = this.m;
            if (enterForumAdView != null) {
                ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    I();
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(0, i2, 0, 0);
                    this.m.setLayoutParams(marginLayoutParams);
                    if (Math.abs(marginLayoutParams.topMargin) < marginLayoutParams.height * 0.2d) {
                        if (this.m.getParent() != this.m.getRootView() && (viewGroup = (ViewGroup) this.m.getRootView()) != null) {
                            ((ViewGroup) this.m.getParent()).removeView(this.m);
                            if (this.m.getParent() == null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                viewGroup.addView(this.m, marginLayoutParams2);
                            }
                            viewGroup.bringChildToFront(this.H);
                            viewGroup.bringChildToFront(this.J);
                        }
                    } else if (this.m.getParent() == this.m.getRootView()) {
                        if (this.m.getParent() != null) {
                            ViewGroup viewGroup2 = (ViewGroup) this.m.getRootView();
                            ((ViewGroup) this.m.getParent()).removeView(this.m);
                        }
                        if (this.m.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                            this.f59833b.J0().addView(this.m, 0, marginLayoutParams3);
                        }
                    }
                }
            }
            this.f59835d.setVisibility(0);
            this.K = false;
            float f4 = i2;
            p0(((int) ((f4 * abs) - (abs * f3))) * 2);
            this.K = true;
            float abs2 = Math.abs(f4 / f3);
            this.f59835d.setAlpha(abs2);
            View w = this.f59833b.L0().w();
            if (w != null) {
                w.setAlpha(abs2);
            }
            View findViewById = this.f59833b.J0().getRootView().findViewById(R.id.tabcontainer_wrapper);
            if (findViewById != null) {
                findViewById.setAlpha(abs2);
            }
        }
    }

    public void m0(d.a.p0.l0.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, aVar) == null) || aVar == null) {
            return;
        }
        if (StringUtils.isNull(aVar.d())) {
            this.L = false;
        } else {
            this.L = true;
        }
        this.o.o(aVar.c());
        this.o.p(aVar.b(), aVar.e());
        this.o.l(aVar.a());
        this.o.u(aVar.d());
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || this.t == z) {
            return;
        }
        this.t = z;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f59835d.getLayoutParams();
        if (!z) {
            marginLayoutParams.topMargin += this.f59835d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
        } else {
            marginLayoutParams.topMargin -= this.f59835d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
        }
        this.f59835d.setLayoutParams(marginLayoutParams);
    }

    public void o0(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, gVar) == null) {
            this.x = gVar;
        }
    }

    @Override // com.baidu.tieba.enterForum.view.EnterForumAdView.c
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.K) {
            c0();
        }
    }

    public final void p0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048614, this, i2) == null) || this.K) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f59835d.getLayoutParams();
        marginLayoutParams.topMargin = ((i2 + this.u) - this.v) - (EnterForumDelegateStatic.f14669c.B() != null ? this.f59832a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        this.f59835d.setLayoutParams(marginLayoutParams);
    }

    public void q0(BdUniqueId bdUniqueId) {
        d.a.p0.l0.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, bdUniqueId) == null) || (aVar = this.f59836e) == null) {
            return;
        }
        aVar.l(bdUniqueId);
    }

    public void r0(boolean z) {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048616, this, z) == null) || (enterForumAdView = this.m) == null) {
            return;
        }
        enterForumAdView.setRecentlyIsExtend(z);
    }

    public void s0(boolean z) {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048617, this, z) == null) || (enterForumAdView = this.m) == null) {
            return;
        }
        enterForumAdView.setRecentlyIsShow(z);
    }

    public void t0(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, view) == null) && (view instanceof FrameLayout) && !this.K) {
            this.f59834c.w();
            this.K = true;
            this.m.getAdImageView().getLocationInWindow(new int[2]);
            SkinManager.setImageResource(this.J, R.drawable.icon_jinba_retract_n);
            int J = J();
            ValueAnimator ofInt = ValueAnimator.ofInt(J, 0);
            ofInt.addUpdateListener(new g(this, J));
            ofInt.addListener(new h(this, J, view));
            ofInt.setDuration(300L);
            ofInt.start();
            this.m.requestFocus();
            this.m.requestFocusFromTouch();
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && T() && this.L) {
            this.o.q();
            this.o.t();
            this.o.setCancelable(false);
            d.a.o0.r.d0.b.j().t("has_guide_popup_window_been_shown", true);
            d.a.c.e.m.g.i(this.o, this.f59833b.getFragmentActivity());
        }
    }

    public void v0(x xVar, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, xVar, view) == null) || !TbadkCoreApplication.isLogin() || M || this.f59833b.getActivity() == null || this.f59833b.getPageContext() == null || !(xVar instanceof d.a.p0.l0.d.f)) {
            return;
        }
        d.a.p0.l0.d.f fVar = (d.a.p0.l0.d.f) xVar;
        if (fVar.D() != 0 && fVar.C() != 0 && !d.a.o0.r.d0.b.j().p("enter_forum_new_forum_long_press_guide", "").equals(fVar.j())) {
            this.q = R.string.create_forum_guide_tip;
        } else if (d.a.o0.r.d0.b.j().l("enter_forum_long_press_guide", 0L) != 0) {
            return;
        } else {
            this.q = R.string.forum_item_guide_tip;
        }
        if (view != null) {
            M = true;
            d.a.c.e.g.d dVar = new d.a.c.e.g.d();
            dVar.j(view);
            dVar.c(0);
            dVar.i(true);
            dVar.h(false);
            dVar.d(true);
            dVar.a(new t(this));
            dVar.g(new C1531b(this));
            d.a.c.e.g.c b2 = dVar.b();
            this.p = b2;
            b2.k(false);
            this.p.l(true);
            this.p.m(this.f59833b.getActivity());
            int i2 = this.q;
            if (i2 == R.string.create_forum_guide_tip) {
                d.a.o0.r.d0.b.j().x("enter_forum_new_forum_long_press_guide", fVar.j());
            } else if (i2 == R.string.forum_item_guide_tip) {
                d.a.o0.r.d0.b.j().w("enter_forum_long_press_guide", 1L);
            }
            d.a.c.e.m.e.a().postDelayed(new c(this), 5000L);
        }
    }

    public void w0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, view) == null) {
            if (this.k == null) {
                this.k = new d.a.o0.d0.h(this.f59833b.getPageContext().getContext(), new s(this));
            }
            this.l = view;
            this.k.j(this.f59833b.getResources().getDimensionPixelSize(R.dimen.ds364));
            this.k.attachView(view, false);
            this.k.o();
            this.f59835d.setVisibility(8);
            if (this.f59833b.L0() != null) {
                this.f59833b.L0().K();
                this.f59833b.L0().O();
            }
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.f59835d.F();
        }
    }
}
