package d.a.q0.l0.m;

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
import d.a.d.e.g.d;
import d.a.d.k.e.c;
import d.a.p0.s.f0.f;
import d.a.p0.s.q.p1;
import d.a.p0.s.q.q1;
import d.a.p0.s.q.x;
import d.a.q0.l0.m.e;
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
    public Context f60446a;

    /* renamed from: b  reason: collision with root package name */
    public final EnterForumFragment f60447b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.s.f0.g f60448c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f60449d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.l0.c.a f60450e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.q0.l0.d.f> f60451f;

    /* renamed from: g  reason: collision with root package name */
    public p1 f60452g;

    /* renamed from: h  reason: collision with root package name */
    public ViewEventCenter f60453h;

    /* renamed from: i  reason: collision with root package name */
    public CommonTipView f60454i;
    public View j;
    public d.a.p0.f0.h k;
    public View l;
    public EnterForumAdView m;
    public View n;
    public GuidePopupWindow o;
    public d.a.d.e.g.c p;
    public int q;
    public d.a.q0.l0.m.e r;
    public d.a.q0.l0.d.c s;
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
        public final /* synthetic */ b f60455e;

        /* renamed from: d.a.q0.l0.m.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1535a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f60456e;

            public RunnableC1535a(a aVar) {
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
                this.f60456e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f60456e.f60455e.f60449d.setSelection(0);
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
            this.f60455e = bVar;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f60455e.K) {
                return;
            }
            d.a.q0.g3.c.g().j(this.f60455e.f60447b.getUniqueId());
            if (this.f60455e.x != null) {
                this.f60455e.x.onListPullRefresh(z);
            }
            if (z) {
                b bVar = this.f60455e;
                if (bVar.E || bVar.s == null || !this.f60455e.s.f60157a) {
                    return;
                }
                if (this.f60455e.s.f60159c > 0) {
                    this.f60455e.f60449d.E(0, 0, 0);
                    this.f60455e.i0();
                    return;
                }
                d.a.d.e.m.e.a().post(new RunnableC1535a(this));
            }
        }
    }

    /* renamed from: d.a.q0.l0.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1536b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1536b(b bVar) {
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

        @Override // d.a.d.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.d.e.g.d.a
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
        public final /* synthetic */ b f60457e;

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
            this.f60457e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60457e.p == null) {
                return;
            }
            this.f60457e.p.d();
            this.f60457e.p = null;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60458e;

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
            this.f60458e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                EnterForumAdView.c(this.f60458e.f60447b.getPageContext().getUniqueId(), this.f60458e.f60446a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f60459e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f60460f;

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
            this.f60460f = bVar;
            this.f60459e = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f60460f.I = motionEvent.getRawY();
                } else if (action == 1) {
                    if (this.f60460f.I <= (this.f60460f.f60446a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.f60460f.I) {
                        this.f60460f.h0();
                        if (this.f60459e < 50.0f) {
                            this.f60460f.H.performClick();
                        }
                    } else {
                        this.f60460f.c0();
                    }
                    this.f60460f.I = 0.0f;
                    this.f60459e = 0.0f;
                } else if (action != 2) {
                    if (this.f60460f.I <= (this.f60460f.f60446a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.f60460f.I) {
                        this.f60460f.h0();
                    } else {
                        this.f60460f.c0();
                    }
                    this.f60460f.I = 0.0f;
                    this.f60459e = 0.0f;
                } else {
                    if (motionEvent.getRawY() < this.f60460f.I) {
                        this.f60460f.l0(motionEvent.getRawY() - this.f60460f.I);
                        if (this.f60460f.J != null) {
                            this.f60460f.J.setVisibility(8);
                        }
                    }
                    if (Math.abs(motionEvent.getRawY() - this.f60460f.I) > this.f60459e) {
                        this.f60459e = Math.abs(motionEvent.getRawY() - this.f60460f.I);
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
        public final /* synthetic */ b f60461e;

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
            this.f60461e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60461e.c0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f60463f;

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
            this.f60463f = bVar;
            this.f60462e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup viewGroup;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (this.f60463f.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.f60463f.m.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        this.f60463f.I();
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMargins(0, intValue, 0, 0);
                        this.f60463f.m.setLayoutParams(marginLayoutParams);
                        if (intValue / this.f60462e < 0.2d) {
                            if (this.f60463f.m.getParent() != this.f60463f.m.getRootView() && (viewGroup = (ViewGroup) this.f60463f.m.getRootView()) != null) {
                                ((ViewGroup) this.f60463f.m.getParent()).removeView(this.f60463f.m);
                                if (this.f60463f.m.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                    viewGroup.addView(this.f60463f.m, marginLayoutParams2);
                                }
                                viewGroup.bringChildToFront(this.f60463f.H);
                                viewGroup.bringChildToFront(this.f60463f.J);
                            }
                        } else if (this.f60463f.m.getParent() == this.f60463f.m.getRootView()) {
                            if (this.f60463f.m.getParent() != null) {
                                ViewGroup viewGroup2 = (ViewGroup) this.f60463f.m.getRootView();
                                ((ViewGroup) this.f60463f.m.getParent()).removeView(this.f60463f.m);
                            }
                            if (this.f60463f.m.getParent() == null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                this.f60463f.f60447b.O0().addView(this.f60463f.m, 0, marginLayoutParams3);
                            }
                        }
                    }
                }
                this.f60463f.K = false;
                this.f60463f.p0(((intValue - this.f60462e) * 2) + 0);
                this.f60463f.K = true;
                float abs = Math.abs(intValue / this.f60462e);
                this.f60463f.f60449d.setAlpha(abs);
                View w = this.f60463f.f60447b.Q0().w();
                if (w != null) {
                    w.setAlpha(abs);
                }
                View findViewById = this.f60463f.f60447b.O0().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
        public final /* synthetic */ int f60464e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f60465f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f60466g;

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
            this.f60466g = bVar;
            this.f60464e = i2;
            this.f60465f = view;
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
                if (this.f60466g.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.f60466g.m.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        this.f60466g.I();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams2.setMargins(0, 0, 0, 0);
                        this.f60466g.m.setLayoutParams(layoutParams2);
                    }
                }
                this.f60466g.f60448c.A();
                this.f60466g.f60449d.z();
                this.f60466g.f60448c.D(0, -this.f60466g.f60448c.q(), 0, 0);
                this.f60466g.K = false;
                this.f60466g.p0(0 - (this.f60464e * 2));
                this.f60466g.K = true;
                this.f60466g.f60449d.setVisibility(8);
                this.f60466g.H.setEnabled(true);
                FrameLayout frameLayout = (FrameLayout) this.f60465f;
                if (this.f60466g.H.getParent() == null) {
                    frameLayout.addView(this.f60466g.H, new FrameLayout.LayoutParams(-1, -1));
                }
                if (this.f60466g.J.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.bottomMargin = this.f60466g.f60446a.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                    layoutParams3.gravity = 81;
                    frameLayout.addView(this.f60466g.J, layoutParams3);
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
        public final /* synthetic */ b f60467e;

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
            this.f60467e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f60467e.l0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60468e;

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
            this.f60468e = bVar;
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
                this.f60468e.l0(0.0f);
                this.f60468e.f60448c.A();
                this.f60468e.f60449d.z();
                this.f60468e.f60448c.D(0, -this.f60468e.f60448c.q(), 0, 0);
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
        public final /* synthetic */ b f60469e;

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
            this.f60469e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f60469e.l0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60470e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f60471e;

            /* renamed from: d.a.q0.l0.m.b$l$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC1537a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f60472e;

                public RunnableC1537a(a aVar) {
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
                    this.f60472e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f60472e.f60471e.f60470e.K = false;
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
                this.f60471e = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ViewGroup viewGroup = (ViewGroup) this.f60471e.f60470e.H.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f60471e.f60470e.H);
                        viewGroup.removeView(this.f60471e.f60470e.J);
                    }
                    this.f60471e.f60470e.J.setVisibility(0);
                    this.f60471e.f60470e.K = false;
                    this.f60471e.f60470e.k0();
                    this.f60471e.f60470e.C = 0;
                    this.f60471e.f60470e.p0(0);
                    this.f60471e.f60470e.K = true;
                    this.f60471e.f60470e.f60448c.A();
                    this.f60471e.f60470e.f60449d.z();
                    this.f60471e.f60470e.f60448c.D(0, -this.f60471e.f60470e.f60448c.q(), 0, 0);
                    d.a.d.e.m.e.a().postDelayed(new RunnableC1537a(this), 0L);
                    this.f60471e.f60470e.f60449d.setVisibility(0);
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
            this.f60470e = bVar;
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
                d.a.d.e.m.e.a().post(new a(this));
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
        public int f60473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f60474f;

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
            this.f60474f = bVar;
            this.f60473e = -1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                if (this.f60474f.f60447b.isPrimary() && this.f60473e != 1 && i2 == 0) {
                    for (int i5 = i2; i5 < i2 + i3; i5++) {
                        Object itemAtPosition = this.f60474f.f60449d.getItemAtPosition(i5);
                        if (itemAtPosition != null && (itemAtPosition instanceof x)) {
                            x xVar = (x) itemAtPosition;
                            if (xVar.c() == 1 && this.f60474f.f60449d.getItemAtPosition(i5) == ListUtils.getItem(this.f60474f.f60451f, 0)) {
                                this.f60474f.v0(xVar, this.f60474f.f60449d.getChildAt(i5).findViewById(R.id.forum_intro));
                            }
                        }
                    }
                }
                this.f60474f.r.onScroll(absListView, i2, i3, i4);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                this.f60474f.r.onScrollStateChanged(absListView, i2);
                if (this.f60473e != i2) {
                    this.f60473e = i2;
                    if (i2 == 1) {
                        if (this.f60474f.s == null || !this.f60474f.s.f60157a) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
                        }
                        this.f60474f.N();
                        return;
                    }
                    this.f60474f.E();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60475e;

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
            this.f60475e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f60475e.s != null && this.f60475e.s.f60157a) {
                b bVar = this.f60475e;
                if (bVar.E) {
                    EnterForumAdView unused = bVar.m;
                    EnterForumAdView.c(this.f60475e.f60447b.getUniqueId(), this.f60475e.f60447b.getContext());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60476a;

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
            this.f60476a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f60476a.u0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60477a;

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
            this.f60477a = bVar;
        }

        @Override // d.a.q0.l0.m.e.c
        public void a(AbsListView absListView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048576, this, absListView, i2, i3) == null) || this.f60477a.K) {
                return;
            }
            this.f60477a.B = -i2;
            b bVar = this.f60477a;
            if (bVar.E) {
                bVar.d0();
            } else if (bVar.s == null || !this.f60477a.s.f60157a) {
            } else {
                this.f60477a.k0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60478a;

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
            this.f60478a = bVar;
        }

        @Override // d.a.d.k.e.c.a
        public void a(d.a.d.k.e.c cVar, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f60478a.C = i4;
                b bVar = this.f60478a;
                if (bVar.E || bVar.s == null || !this.f60478a.s.f60157a || this.f60478a.K) {
                    return;
                }
                this.f60478a.k0();
                if (i4 > this.f60478a.w) {
                    this.f60478a.C = 0;
                    b bVar2 = this.f60478a;
                    bVar2.t0(bVar2.f60447b.Q0().u());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60479e;

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
            this.f60479e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60479e.d0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60480e;

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
            this.f60480e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60480e.O();
                this.f60480e.x0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements d.a.d.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60481a;

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
            this.f60481a = bVar;
        }

        @Override // d.a.d.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tips)).setText(this.f60481a.q);
                this.f60481a.f60447b.getPageContext().getLayoutMode().j(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // d.a.d.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1267346491, "Ld/a/q0/l0/m/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1267346491, "Ld/a/q0/l0/m/b;");
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
        this.f60447b = enterForumFragment;
        this.u = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + d.a.d.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.v = d.a.d.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.w = d.a.d.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.f60453h = viewEventCenter;
        R(view);
        d.a.q0.l0.c.a aVar = new d.a.q0.l0.c.a(this.f60447b.getPageContext(), this.f60453h, recentlyVisitedForumModel, enterForumModel, this);
        this.f60450e = aVar;
        this.f60449d.setAdapter((ListAdapter) aVar);
        W(TbadkCoreApplication.getInst().getSkinType());
        f0();
        this.o = new GuidePopupWindow(this.f60447b.getFragmentActivity());
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (U()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
                return;
            }
            d.a.q0.l0.d.c cVar = this.s;
            if (cVar != null && cVar.f60157a) {
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
            d.a.q0.l0.c.a aVar = this.f60450e;
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
            this.f60449d.A(0L);
        }
    }

    public final int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.E ? -this.f60446a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I();
        }
        return invokeV.intValue;
    }

    public final int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60446a.getResources().getDimensionPixelOffset(R.dimen.tbds934) : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f60449d : (BdListView) invokeV.objValue;
    }

    public final int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (this.u - this.v) - (EnterForumDelegateStatic.f14717c.B() != null ? this.f60446a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        }
        return invokeV.intValue;
    }

    public d.a.p0.f0.h M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (d.a.p0.f0.h) invokeV.objValue;
    }

    public void N() {
        d.a.d.e.g.c cVar;
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
            d.a.p0.f0.h hVar = this.k;
            if (hVar != null) {
                hVar.dettachView(this.l);
                this.k = null;
                this.l = null;
            }
            this.f60449d.setVisibility(0);
            if (this.f60447b.Q0() != null) {
                this.f60447b.Q0().K();
                this.f60447b.Q0().O();
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.d.e.p.l.g(this.f60446a, R.dimen.tbds240);
            View view = new View(this.f60446a);
            this.H = view;
            view.setOnClickListener(new d(this));
            this.H.setOnTouchListener(new e(this));
            ImageView imageView = new ImageView(this.f60446a);
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
                this.m.setTag(this.f60447b.getUniqueId());
                this.m.setAdData();
                this.m.setEventCenter(this.f60453h);
                this.m.setOnBackPressedListener(this);
            }
        }
    }

    public final void R(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            this.f60446a = view.getContext();
            d.a.q0.l0.m.e eVar = new d.a.q0.l0.m.e();
            this.r = eVar;
            eVar.a(new p(this));
            this.f60449d = (BdListView) view.findViewById(R.id.listview);
            p0(0);
            this.f60449d.setBackgroundColor(0);
            this.f60449d.setVerticalScrollBarEnabled(false);
            this.f60449d.setOnScrollListener(this.z);
            this.f60449d.setFastScrollEnabled(false);
            this.f60449d.setMaxHeight(this.f60446a.getResources().getDisplayMetrics().heightPixels);
            BdListView.D(1.0f);
            if (this.f60447b.Q0() != null) {
                this.f60447b.Q0().R(this);
            }
            d.a.p0.s.f0.g gVar = new d.a.p0.s.f0.g(this.f60447b.getPageContext());
            this.f60448c = gVar;
            gVar.C(new q(this));
            this.f60448c.Z(true);
            this.f60448c.a(this.y);
            d.a.p0.s.f0.g gVar2 = this.f60448c;
            if (gVar2 != null) {
                gVar2.a0(this.f60447b.getUniqueId());
            }
            this.f60449d.setPullRefresh(this.f60448c);
            FrameLayout frameLayout = new FrameLayout(this.f60447b.getPageContext().getPageActivity());
            View view2 = new View(this.f60447b.getPageContext().getPageActivity());
            this.n = view2;
            frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, this.v));
            this.f60449d.getAdapter2().g(frameLayout, 0);
            this.j = new View(this.f60447b.getActivity());
            this.j.setLayoutParams(new AbsListView.LayoutParams(-1, d.a.d.e.p.l.g(this.f60447b.getActivity(), R.dimen.ds50)));
            this.j.setBackgroundResource(R.color.CAM_X0201);
            this.f60448c.S(this.A);
            this.f60448c.getView().setOnClickListener(this.A);
            this.n.setOnClickListener(this.A);
            P();
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? ListUtils.isEmpty(this.f60451f) : invokeV.booleanValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TbadkCoreApplication.isLogin() && !d.a.p0.s.d0.b.j().g("has_guide_popup_window_been_shown", false) : invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            BdListView bdListView = this.f60449d;
            return bdListView == null || bdListView.getChildCount() == 0 || this.f60449d.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f60450e.notifyDataSetChanged();
            View view = this.j;
            if (view == null || view.getLayoutParams() == null) {
                return;
            }
            if (z) {
                this.j.getLayoutParams().height = d.a.d.e.p.l.g(this.f60446a, R.dimen.ds50);
                return;
            }
            this.j.getLayoutParams().height = d.a.d.e.p.l.g(this.f60446a, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
                this.f60449d.removeFooterView(this.j);
                this.f60449d.addFooterView(this.j);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                this.f60449d.removeFooterView(this.j);
            }
            d.a.p0.s.f0.g gVar = this.f60448c;
            if (gVar != null) {
                gVar.I(i2);
            }
            d.a.p0.f0.h hVar = this.k;
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
            CommonTipView commonTipView = this.f60454i;
            if (commonTipView != null) {
                commonTipView.i();
            }
            d.a.q0.l0.c.a aVar = this.f60450e;
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
            if (this.f60447b.isAdded() && this.f60447b.isPrimary()) {
                M = false;
                d.a.q0.l0.c.a aVar = this.f60450e;
                if (aVar != null) {
                    aVar.h();
                    BdListView bdListView = this.f60449d;
                    if (bdListView != null) {
                        Object itemAtPosition = this.f60449d.getItemAtPosition(bdListView.getLastVisiblePosition());
                        if (itemAtPosition != null && (itemAtPosition instanceof x) && ((x) itemAtPosition).c() == 5) {
                            this.f60450e.m();
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
            this.f60450e.i(i2);
        }
    }

    public void b0() {
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || TbadkCoreApplication.getCurrentAccount() != null || !d.a.p0.s.d0.b.j().g("enter_forum_login_tip", true) || (enterForumFragment = this.f60447b) == null || enterForumFragment.getActivity() == null || this.f60447b.P0() == null) {
            return;
        }
        if (this.f60454i == null) {
            this.f60454i = new CommonTipView(this.f60447b.getActivity());
        }
        this.f60454i.setText(R.string.enter_forum_login_tip);
        this.f60454i.k(this.f60447b.P0(), TbadkCoreApplication.getInst().getSkinType());
        d.a.p0.s.d0.b.j().t("enter_forum_login_tip", false);
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
                this.f60449d.A(0L);
            }
            this.F = false;
        }
    }

    public void e0(List<d.a.q0.l0.d.f> list, p1 p1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048602, this, list, p1Var, z) == null) {
            this.m.setAdData();
            EnterForumDelegateStatic.f14717c.D(this.f60446a);
            this.f60451f = list;
            this.f60452g = p1Var;
            ArrayList arrayList = new ArrayList();
            boolean z2 = !ListUtils.isEmpty(list);
            boolean z3 = !ListUtils.isEmpty(list);
            x xVar = new x();
            xVar.d(4);
            arrayList.add(xVar);
            if (z3) {
                arrayList.add(new d.a.q0.l0.d.a(true));
                arrayList.add(new d.a.q0.l0.d.e(this.f60446a.getResources().getString(R.string.my_attention_bar), z2));
                arrayList.addAll(list);
                arrayList.add(p1Var);
            } else {
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.add(new d.a.q0.l0.d.e(this.f60446a.getResources().getString(R.string.my_attention_bar), z2));
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
                    arrayList.add(new q1(this.f60446a.getResources().getString(R.string.recommend_forum_title_vertical), true));
                }
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.addAll(p1Var.e());
                }
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.add(new d.a.q0.l0.d.a(false));
                }
            }
            if (z) {
                x xVar4 = new x();
                xVar4.d(5);
                arrayList.add(xVar4);
            }
            O();
            this.f60450e.k(arrayList, z);
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f60447b.registerListener(this.D);
        }
    }

    public void g0(d.a.q0.l0.d.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, fVar, z) == null) {
            this.f60451f.remove(fVar);
            e0(this.f60451f, this.f60452g, z);
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
        int dimensionPixelOffset = this.f60446a.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.f60448c.q();
        EnterForumAdView enterForumAdView = this.m;
        if (enterForumAdView != null) {
            if (!enterForumAdView.f()) {
                dimensionPixelSize = this.f60446a.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.f60446a.getResources().getDimensionPixelSize(R.dimen.tbds134);
            } else if (!this.m.e()) {
                dimensionPixelSize = this.f60446a.getResources().getDimensionPixelSize(R.dimen.tbds370);
            }
            dimensionPixelOffset += dimensionPixelSize;
        }
        p0(dimensionPixelOffset);
        d.a.d.e.m.e.a().removeCallbacks(this.G);
        d.a.d.e.m.e.a().postDelayed(this.G, 3000L);
    }

    public void j0(d.a.q0.l0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, cVar) == null) {
            this.s = cVar;
            d.a.q0.l0.c.a aVar = this.f60450e;
            if (aVar != null) {
                aVar.j(cVar);
            }
            if (cVar != null && cVar.f60157a) {
                if (this.f60448c.getView() != null) {
                    this.f60448c.getView().setScaleX(0.5f);
                    this.f60448c.getView().setScaleY(0.5f);
                }
                this.f60448c.Q(R.raw.ad_refresh_load);
                return;
            }
            if (this.f60448c.getView() != null) {
                this.f60448c.getView().setScaleX(1.0f);
                this.f60448c.getView().setScaleY(1.0f);
            }
            this.f60448c.Q(R.raw.lottie_common_pull_refresh);
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
            layoutParams2.setMargins(0, this.E ? -this.f60446a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I, 0, 0);
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
                            this.f60447b.O0().addView(this.m, 0, marginLayoutParams3);
                        }
                    }
                }
            }
            this.f60449d.setVisibility(0);
            this.K = false;
            float f4 = i2;
            p0(((int) ((f4 * abs) - (abs * f3))) * 2);
            this.K = true;
            float abs2 = Math.abs(f4 / f3);
            this.f60449d.setAlpha(abs2);
            View w = this.f60447b.Q0().w();
            if (w != null) {
                w.setAlpha(abs2);
            }
            View findViewById = this.f60447b.O0().getRootView().findViewById(R.id.tabcontainer_wrapper);
            if (findViewById != null) {
                findViewById.setAlpha(abs2);
            }
        }
    }

    public void m0(d.a.q0.l0.f.a.a aVar) {
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
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f60449d.getLayoutParams();
        if (!z) {
            marginLayoutParams.topMargin += this.f60449d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
        } else {
            marginLayoutParams.topMargin -= this.f60449d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
        }
        this.f60449d.setLayoutParams(marginLayoutParams);
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
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f60449d.getLayoutParams();
        marginLayoutParams.topMargin = ((i2 + this.u) - this.v) - (EnterForumDelegateStatic.f14717c.B() != null ? this.f60446a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        this.f60449d.setLayoutParams(marginLayoutParams);
    }

    public void q0(BdUniqueId bdUniqueId) {
        d.a.q0.l0.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, bdUniqueId) == null) || (aVar = this.f60450e) == null) {
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
            this.f60448c.w();
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
            d.a.p0.s.d0.b.j().t("has_guide_popup_window_been_shown", true);
            d.a.d.e.m.g.i(this.o, this.f60447b.getFragmentActivity());
        }
    }

    public void v0(x xVar, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, xVar, view) == null) || !TbadkCoreApplication.isLogin() || M || this.f60447b.getActivity() == null || this.f60447b.getPageContext() == null || !(xVar instanceof d.a.q0.l0.d.f)) {
            return;
        }
        d.a.q0.l0.d.f fVar = (d.a.q0.l0.d.f) xVar;
        if (fVar.D() != 0 && fVar.C() != 0 && !d.a.p0.s.d0.b.j().p("enter_forum_new_forum_long_press_guide", "").equals(fVar.j())) {
            this.q = R.string.create_forum_guide_tip;
        } else if (d.a.p0.s.d0.b.j().l("enter_forum_long_press_guide", 0L) != 0) {
            return;
        } else {
            this.q = R.string.forum_item_guide_tip;
        }
        if (view != null) {
            M = true;
            d.a.d.e.g.d dVar = new d.a.d.e.g.d();
            dVar.j(view);
            dVar.c(0);
            dVar.i(true);
            dVar.h(false);
            dVar.d(true);
            dVar.a(new t(this));
            dVar.g(new C1536b(this));
            d.a.d.e.g.c b2 = dVar.b();
            this.p = b2;
            b2.k(false);
            this.p.l(true);
            this.p.m(this.f60447b.getActivity());
            int i2 = this.q;
            if (i2 == R.string.create_forum_guide_tip) {
                d.a.p0.s.d0.b.j().x("enter_forum_new_forum_long_press_guide", fVar.j());
            } else if (i2 == R.string.forum_item_guide_tip) {
                d.a.p0.s.d0.b.j().w("enter_forum_long_press_guide", 1L);
            }
            d.a.d.e.m.e.a().postDelayed(new c(this), 5000L);
        }
    }

    public void w0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, view) == null) {
            if (this.k == null) {
                this.k = new d.a.p0.f0.h(this.f60447b.getPageContext().getContext(), new s(this));
            }
            this.l = view;
            this.k.j(this.f60447b.getResources().getDimensionPixelSize(R.dimen.ds364));
            this.k.attachView(view, false);
            this.k.o();
            this.f60449d.setVisibility(8);
            if (this.f60447b.Q0() != null) {
                this.f60447b.Q0().K();
                this.f60447b.Q0().O();
            }
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.f60449d.F();
        }
    }
}
