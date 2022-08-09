package com.repackage;

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
import com.baidu.tbadk.core.view.PbListView;
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
import com.repackage.a96;
import com.repackage.av4;
import com.repackage.dn;
import com.repackage.hf;
import com.repackage.z76;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class v86 implements EnterForumAdView.c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean R;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public av4.g B;
    public av4.g C;
    public AbsListView.OnScrollListener D;
    public View.OnClickListener E;
    public int F;
    public int G;
    public CustomMessageListener H;
    public z76.b I;
    public boolean J;
    public boolean K;
    public Runnable L;
    public View M;
    public float N;
    public ImageView O;
    public boolean P;
    public boolean Q;
    public Context a;
    public final EnterForumFragment b;
    public bv4 c;
    public BdListView d;
    public l66 e;
    public List<u66> f;
    public vq4 g;
    public ViewEventCenter h;
    public CommonTipView i;
    public View j;
    public h65 k;
    public View l;
    public EnterForumAdView m;
    public View n;
    public GuidePopupWindow o;
    public gf p;
    public int q;
    public a96 r;
    public r66 s;
    public boolean t;
    public z76 u;
    public PbListView v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements av4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        /* renamed from: com.repackage.v86$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0598a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0598a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.d.setSelection(0);
                }
            }
        }

        public a(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // com.repackage.av4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.P) {
                return;
            }
            dj8.g().j(this.a.b.getUniqueId());
            if (this.a.B != null) {
                this.a.A = false;
                this.a.B.e(z);
            }
            if (z) {
                v86 v86Var = this.a;
                if (v86Var.J || v86Var.s == null || !this.a.s.a) {
                    return;
                }
                if (this.a.s.b > 0) {
                    this.a.d.E(0, 0, 0);
                    this.a.p0();
                    return;
                }
                rg.a().post(new RunnableC0598a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public b(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.V();
                this.a.G0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ff {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public c(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // com.repackage.ff
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ff
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ff
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0873, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921b7)).setText(this.a.q);
                this.a.b.getPageContext().getLayoutMode().k(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.repackage.ff
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ff
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements hf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.hf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.hf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public e(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.p == null) {
                return;
            }
            this.a.p.d();
            this.a.p = null;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public f(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                EnterForumAdView.c(this.a.b.getPageContext().getUniqueId(), this.a.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public final /* synthetic */ v86 b;

        public g(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v86Var;
            this.a = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.b.N = motionEvent.getRawY();
                } else if (action == 1) {
                    if (this.b.N <= (this.b.a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.b.N) {
                        this.b.o0();
                        if (this.a < 50.0f) {
                            this.b.M.performClick();
                        }
                    } else {
                        this.b.j0();
                    }
                    this.b.N = 0.0f;
                    this.a = 0.0f;
                } else if (action != 2) {
                    if (this.b.N <= (this.b.a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.b.N) {
                        this.b.o0();
                    } else {
                        this.b.j0();
                    }
                    this.b.N = 0.0f;
                    this.a = 0.0f;
                } else {
                    if (motionEvent.getRawY() < this.b.N) {
                        this.b.s0(motionEvent.getRawY() - this.b.N);
                        if (this.b.O != null) {
                            this.b.O.setVisibility(8);
                        }
                    }
                    if (Math.abs(motionEvent.getRawY() - this.b.N) > this.a) {
                        this.a = Math.abs(motionEvent.getRawY() - this.b.N);
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public h(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ v86 b;

        public i(v86 v86Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v86Var;
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup viewGroup;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (this.b.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.b.m.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        this.b.O();
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMargins(0, intValue, 0, 0);
                        this.b.m.setLayoutParams(marginLayoutParams);
                        if (intValue / this.a < 0.2d) {
                            if (this.b.m.getParent() != this.b.m.getRootView() && (viewGroup = (ViewGroup) this.b.m.getRootView()) != null) {
                                ((ViewGroup) this.b.m.getParent()).removeView(this.b.m);
                                if (this.b.m.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                    viewGroup.addView(this.b.m, marginLayoutParams2);
                                }
                                viewGroup.bringChildToFront(this.b.M);
                                viewGroup.bringChildToFront(this.b.O);
                            }
                        } else if (this.b.m.getParent() == this.b.m.getRootView()) {
                            if (this.b.m.getParent() != null) {
                                ViewGroup viewGroup2 = (ViewGroup) this.b.m.getRootView();
                                ((ViewGroup) this.b.m.getParent()).removeView(this.b.m);
                            }
                            if (this.b.m.getParent() == null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                this.b.b.t1().addView(this.b.m, 0, marginLayoutParams3);
                            }
                        }
                    }
                }
                this.b.P = false;
                this.b.w0(((intValue - this.a) * 2) + 0);
                this.b.P = true;
                float abs = Math.abs(intValue / this.a);
                this.b.d.setAlpha(abs);
                View B = this.b.b.v1().B();
                if (B != null) {
                    B.setAlpha(abs);
                }
                View findViewById = this.b.b.t1().getRootView().findViewById(R.id.obfuscated_res_0x7f091fd7);
                if (findViewById != null) {
                    findViewById.setAlpha(abs);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ View b;
        public final /* synthetic */ v86 c;

        public j(v86 v86Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var, Integer.valueOf(i), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v86Var;
            this.a = i;
            this.b = view2;
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
                if (this.c.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.c.m.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        this.c.O();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams2.setMargins(0, 0, 0, 0);
                        this.c.m.setLayoutParams(layoutParams2);
                    }
                }
                this.c.c.z();
                this.c.d.z();
                this.c.c.C(0, -this.c.c.p(), 0, 0);
                this.c.P = false;
                this.c.w0(0 - (this.a * 2));
                this.c.P = true;
                this.c.d.setVisibility(8);
                this.c.M.setEnabled(true);
                FrameLayout frameLayout = (FrameLayout) this.b;
                if (this.c.M.getParent() == null) {
                    frameLayout.addView(this.c.M, new FrameLayout.LayoutParams(-1, -1));
                }
                if (this.c.O.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.bottomMargin = this.c.a.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                    layoutParams3.gravity = 81;
                    frameLayout.addView(this.c.O, layoutParams3);
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

    /* loaded from: classes7.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public k(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.s0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public l(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
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
                this.a.s0(0.0f);
                this.a.c.z();
                this.a.d.z();
                this.a.c.C(0, -this.a.c.p(), 0, 0);
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

    /* loaded from: classes7.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public m(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.s0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            /* renamed from: com.repackage.v86$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0599a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0599a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.a.a.a.P = false;
                    }
                }
            }

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ViewGroup viewGroup = (ViewGroup) this.a.a.M.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.a.a.M);
                        viewGroup.removeView(this.a.a.O);
                    }
                    this.a.a.O.setVisibility(0);
                    this.a.a.P = false;
                    this.a.a.r0();
                    this.a.a.G = 0;
                    this.a.a.w0(0);
                    this.a.a.P = true;
                    this.a.a.c.z();
                    this.a.a.d.z();
                    this.a.a.c.C(0, -this.a.a.c.p(), 0, 0);
                    rg.a().postDelayed(new RunnableC0599a(this), 0L);
                    this.a.a.d.setVisibility(0);
                }
            }
        }

        public n(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
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
                rg.a().post(new a(this));
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

    /* loaded from: classes7.dex */
    public class o implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ v86 b;

        public o(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v86Var;
            this.a = -1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                if (this.b.b.isPrimary() && this.a != 1 && i == 0) {
                    for (int i4 = i; i4 < i + i2; i4++) {
                        Object itemAtPosition = this.b.d.getItemAtPosition(i4);
                        if (itemAtPosition != null && (itemAtPosition instanceof dp4)) {
                            dp4 dp4Var = (dp4) itemAtPosition;
                            if (dp4Var.c() == 1 && this.b.d.getItemAtPosition(i4) == ListUtils.getItem(this.b.f, 0)) {
                                this.b.D0(dp4Var, this.b.d.getChildAt(i4).findViewById(R.id.obfuscated_res_0x7f090a62));
                            }
                        }
                    }
                }
                this.b.r.onScroll(absListView, i, i2, i3);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                this.b.r.onScrollStateChanged(absListView, i);
                if (this.a != i) {
                    this.a = i;
                    if (i == 1) {
                        if (this.b.s == null || !this.b.s.a) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
                        }
                        this.b.U();
                        return;
                    }
                    this.b.K();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public p(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.s != null && this.a.s.a) {
                v86 v86Var = this.a;
                if (v86Var.J) {
                    EnterForumAdView unused = v86Var.m;
                    EnterForumAdView.c(this.a.b.getUniqueId(), this.a.b.getContext());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(v86 v86Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.C0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements z76.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public r(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // com.repackage.z76.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                v86 v86Var = this.a;
                if (!v86Var.z || v86Var.A) {
                    if (z || this.a.e == null || ListUtils.isEmpty(this.a.e.g())) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList(this.a.e.g());
                    arrayList.addAll(this.a.u.e().a());
                    this.a.e.m(arrayList, false);
                    this.a.d.setNextPage(null);
                } else if (this.a.e == null || ListUtils.isEmpty(this.a.e.g()) || this.a.u.e() == null || ListUtils.isEmpty(this.a.u.e().a())) {
                } else {
                    ArrayList arrayList2 = new ArrayList(this.a.e.g());
                    arrayList2.add(this.a.R());
                    arrayList2.addAll(this.a.u.e().a());
                    this.a.e.m(arrayList2, false);
                    this.a.A = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements a96.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public s(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // com.repackage.a96.c
        public void a(AbsListView absListView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048576, this, absListView, i, i2) == null) || this.a.P) {
                return;
            }
            this.a.F = -i;
            v86 v86Var = this.a;
            if (v86Var.J) {
                v86Var.k0();
            } else if (v86Var.s == null || !this.a.s.a) {
            } else {
                this.a.r0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public t(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void u(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.a.E0();
                if (this.a.u != null) {
                    this.a.u.i();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements dn.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public u(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // com.repackage.dn.a
        public void a(dn dnVar, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dnVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                this.a.G = i3;
                v86 v86Var = this.a;
                if (v86Var.J || v86Var.s == null || !this.a.s.a || this.a.P) {
                    return;
                }
                this.a.r0();
                if (i3 > this.a.y) {
                    this.a.G = 0;
                    v86 v86Var2 = this.a;
                    v86Var2.B0(v86Var2.b.v1().z());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        public v(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v86Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755277251, "Lcom/repackage/v86;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755277251, "Lcom/repackage/v86;");
        }
    }

    public v86(EnterForumFragment enterForumFragment, View view2, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumFragment, view2, viewEventCenter, recentlyVisitedForumModel, enterForumModel};
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
        this.z = false;
        this.A = false;
        this.C = new a(this);
        this.D = new o(this);
        this.E = new p(this);
        this.F = 0;
        this.G = 0;
        this.H = new q(this, 2921474);
        this.I = new r(this);
        this.J = false;
        this.K = false;
        this.L = new v(this);
        this.P = false;
        this.b = enterForumFragment;
        this.w = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + qi.f(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.x = qi.f(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.y = qi.f(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.h = viewEventCenter;
        Y(view2);
        l66 l66Var = new l66(this.b.getPageContext(), this.h, recentlyVisitedForumModel, enterForumModel, this);
        this.e = l66Var;
        this.d.setAdapter((ListAdapter) l66Var);
        if (enterForumFragment != null) {
            PbListView pbListView = new PbListView(enterForumFragment.getContext());
            this.v = pbListView;
            pbListView.a();
            this.v.t(qi.f(this.a, R.dimen.tbds589));
        }
        d0(TbadkCoreApplication.getInst().getSkinType());
        m0();
        this.o = new GuidePopupWindow(this.b.getFragmentActivity());
    }

    public void A0(z76 z76Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z76Var) == null) {
            this.u = z76Var;
            z76Var.l(this.I);
        }
    }

    public void B0(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (view2 instanceof FrameLayout) && !this.P) {
            this.c.v();
            this.P = true;
            this.m.getAdImageView().getLocationInWindow(new int[2]);
            SkinManager.setImageResource(this.O, R.drawable.icon_jinba_retract_n);
            int P = P();
            ValueAnimator ofInt = ValueAnimator.ofInt(P, 0);
            ofInt.addUpdateListener(new i(this, P));
            ofInt.addListener(new j(this, P, view2));
            ofInt.setDuration(300L);
            ofInt.start();
            this.m.requestFocus();
            this.m.requestFocusFromTouch();
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && a0() && this.Q) {
            this.o.q();
            this.o.t();
            this.o.setCancelable(false);
            ru4.k().u("has_guide_popup_window_been_shown", true);
            tg.i(this.o, this.b.getFragmentActivity());
        }
    }

    public void D0(dp4 dp4Var, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, dp4Var, view2) == null) || !TbadkCoreApplication.isLogin() || R || this.b.getActivity() == null || this.b.getPageContext() == null || !(dp4Var instanceof u66)) {
            return;
        }
        u66 u66Var = (u66) dp4Var;
        if (u66Var.F() != 0 && u66Var.E() != 0 && !ru4.k().q("enter_forum_new_forum_long_press_guide", "").equals(u66Var.getId())) {
            this.q = R.string.obfuscated_res_0x7f0f0474;
        } else if (ru4.k().m("enter_forum_long_press_guide", 0L) != 0) {
            return;
        } else {
            this.q = R.string.obfuscated_res_0x7f0f0683;
        }
        if (view2 != null) {
            R = true;
            hf hfVar = new hf();
            hfVar.k(view2);
            hfVar.c(0);
            hfVar.j(true);
            hfVar.i(false);
            hfVar.d(true);
            hfVar.a(new c(this));
            hfVar.h(new d(this));
            gf b2 = hfVar.b();
            this.p = b2;
            b2.k(false);
            this.p.l(true);
            this.p.m(this.b.getActivity());
            int i2 = this.q;
            if (i2 == R.string.obfuscated_res_0x7f0f0474) {
                ru4.k().y("enter_forum_new_forum_long_press_guide", u66Var.getId());
            } else if (i2 == R.string.obfuscated_res_0x7f0f0683) {
                ru4.k().x("enter_forum_long_press_guide", 1L);
            }
            rg.a().postDelayed(new e(this), 5000L);
        }
    }

    public final void E0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pbListView = this.v) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.d.setNextPage(this.v);
        }
        this.v.t(qi.f(this.a, R.dimen.tbds400));
        this.v.Q();
    }

    public void F0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (this.k == null) {
                this.k = new h65(this.b.getPageContext().getContext(), new b(this));
            }
            this.l = view2;
            this.k.k(this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ab));
            this.k.attachView(view2, false);
            this.k.p();
            this.d.setVisibility(8);
            if (this.b.v1() != null) {
                this.b.v1().N();
                this.b.v1().Q();
            }
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d.F();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (b0()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
                return;
            }
            r66 r66Var = this.s;
            if (r66Var != null && r66Var.a) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
            }
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            l66 l66Var = this.e;
            if (l66Var == null) {
                return false;
            }
            return l66Var.f();
        }
        return invokeV.booleanValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.J) {
                this.K = true;
                return;
            }
            this.K = false;
            this.d.A(0L);
        }
    }

    public final int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.J ? -this.a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.F + this.G) - O();
        }
        return invokeV.intValue;
    }

    public final int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.getResources().getDimensionPixelOffset(R.dimen.tbds934) : invokeV.intValue;
    }

    public final int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdListView Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.d : (BdListView) invokeV.objValue;
    }

    public final t66 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            t66 t66Var = new t66(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fa6), false, true);
            t66Var.g = R.dimen.M_W_X004;
            t66Var.h = R.dimen.tbds112;
            t66Var.j = R.dimen.M_W_X005;
            t66Var.i = R.dimen.T_X07;
            return t66Var;
        }
        return (t66) invokeV.objValue;
    }

    public final int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (this.w - this.x) - (EnterForumDelegateStatic.e.E() != null ? this.a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        }
        return invokeV.intValue;
    }

    public h65 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.k : (h65) invokeV.objValue;
    }

    public void U() {
        gf gfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (gfVar = this.p) == null) {
            return;
        }
        gfVar.d();
        this.p = null;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            h65 h65Var = this.k;
            if (h65Var != null) {
                h65Var.dettachView(this.l);
                this.k = null;
                this.l = null;
            }
            this.d.setVisibility(0);
            if (this.b.v1() != null) {
                this.b.v1().N();
                this.b.v1().Q();
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            View view2 = new View(this.a);
            this.M = view2;
            view2.setOnClickListener(new f(this));
            this.M.setOnTouchListener(new g(this));
            ImageView imageView = new ImageView(this.a);
            this.O = imageView;
            imageView.setOnClickListener(new h(this));
        }
    }

    public void X(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            EnterForumAdView enterForumAdView = (EnterForumAdView) view2.getRootView().findViewById(R.id.obfuscated_res_0x7f0908e9);
            this.m = enterForumAdView;
            if (enterForumAdView != null) {
                r0();
                this.m.setTag(this.b.getUniqueId());
                this.m.setAdData();
                this.m.setEventCenter(this.h);
                this.m.setOnBackPressedListener(this);
            }
        }
    }

    public final void Y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            this.a = view2.getContext();
            a96 a96Var = new a96();
            this.r = a96Var;
            a96Var.a(new s(this));
            this.d = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f091313);
            w0(0);
            this.d.setBackgroundColor(0);
            this.d.setVerticalScrollBarEnabled(false);
            this.d.setOnScrollListener(this.D);
            this.d.setExOnSrollToBottomListener(new t(this));
            this.d.setFastScrollEnabled(false);
            this.d.setMaxHeight(this.a.getResources().getDisplayMetrics().heightPixels);
            BdListView.D(1.0f);
            if (this.b.v1() != null) {
                this.b.v1().T(this);
            }
            bv4 bv4Var = new bv4(this.b.getPageContext());
            this.c = bv4Var;
            bv4Var.B(new u(this));
            this.c.a0(true);
            this.c.f(this.C);
            bv4 bv4Var2 = this.c;
            if (bv4Var2 != null) {
                bv4Var2.b0(this.b.getUniqueId());
            }
            this.d.setPullRefresh(this.c);
            FrameLayout frameLayout = new FrameLayout(this.b.getPageContext().getPageActivity());
            View view3 = new View(this.b.getPageContext().getPageActivity());
            this.n = view3;
            frameLayout.addView(view3, new FrameLayout.LayoutParams(-1, this.x));
            this.d.getAdapter2().g(frameLayout, 0);
            this.j = new View(this.b.getActivity());
            this.j.setLayoutParams(new AbsListView.LayoutParams(-1, qi.f(this.b.getActivity(), R.dimen.obfuscated_res_0x7f0702d2)));
            this.j.setBackgroundResource(R.color.CAM_X0201);
            this.c.T(this.E);
            this.c.getView().setOnClickListener(this.E);
            this.n.setOnClickListener(this.E);
            W();
        }
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? ListUtils.isEmpty(this.f) : invokeV.booleanValue;
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? TbadkCoreApplication.isLogin() && !ru4.k().h("has_guide_popup_window_been_shown", false) : invokeV.booleanValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            BdListView bdListView = this.d;
            return bdListView == null || bdListView.getChildCount() == 0 || this.d.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.e.notifyDataSetChanged();
            View view2 = this.j;
            if (view2 == null || view2.getLayoutParams() == null) {
                return;
            }
            if (z) {
                this.j.getLayoutParams().height = qi.f(this.a, R.dimen.obfuscated_res_0x7f0702d2);
                return;
            }
            this.j.getLayoutParams().height = qi.f(this.a, R.dimen.obfuscated_res_0x7f0702d2) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void d0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
                this.d.removeFooterView(this.j);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                this.d.removeFooterView(this.j);
            }
            l66 l66Var = this.e;
            if (l66Var != null) {
                l66Var.h(i2);
            }
            bv4 bv4Var = this.c;
            if (bv4Var != null) {
                bv4Var.H(i2);
            }
            h65 h65Var = this.k;
            if (h65Var != null) {
                h65Var.onChangeSkinType();
            }
            GuidePopupWindow guidePopupWindow = this.o;
            if (guidePopupWindow != null) {
                guidePopupWindow.j();
            }
            SkinManager.setBackgroundResource(this.j, R.color.CAM_X0201);
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            CommonTipView commonTipView = this.i;
            if (commonTipView != null) {
                commonTipView.i();
            }
            l66 l66Var = this.e;
            if (l66Var != null) {
                l66Var.i();
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            U();
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.b.isAdded() && this.b.isPrimary()) {
                R = false;
                l66 l66Var = this.e;
                if (l66Var != null) {
                    l66Var.j();
                    BdListView bdListView = this.d;
                    if (bdListView != null) {
                        Object itemAtPosition = this.d.getItemAtPosition(bdListView.getLastVisiblePosition());
                        if (itemAtPosition != null && (itemAtPosition instanceof dp4) && ((dp4) itemAtPosition).c() == 5) {
                            this.e.o();
                        }
                    }
                }
                if (this.P) {
                    this.m.requestFocus();
                    this.m.requestFocusFromTouch();
                    return;
                }
                return;
            }
            U();
        }
    }

    public void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.e.k(i2);
        }
    }

    public void i0() {
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || TbadkCoreApplication.getCurrentAccount() != null || !ru4.k().h("enter_forum_login_tip", true) || (enterForumFragment = this.b) == null || enterForumFragment.getActivity() == null || this.b.u1() == null) {
            return;
        }
        if (this.i == null) {
            this.i = new CommonTipView(this.b.getActivity());
        }
        this.i.setText(R.string.obfuscated_res_0x7f0f057a);
        this.i.k(this.b.u1(), TbadkCoreApplication.getInst().getSkinType());
        ru4.k().u("enter_forum_login_tip", false);
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.M.setEnabled(false);
            int N = N();
            Math.abs(N / (S() - N));
            this.O.setVisibility(8);
            int i2 = ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).topMargin;
            ValueAnimator ofInt = ValueAnimator.ofInt(P(), N);
            ofInt.addUpdateListener(new m(this));
            ofInt.addListener(new n(this));
            ofInt.setDuration(300L);
            ofInt.start();
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.J = false;
            r0();
            w0(0);
            if (this.K) {
                this.d.A(0L);
            }
            this.K = false;
        }
    }

    public void l0(List<u66> list, vq4 vq4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048610, this, list, vq4Var, z) == null) {
            this.m.setAdData();
            EnterForumDelegateStatic.e.G(this.a);
            this.f = list;
            this.g = vq4Var;
            ArrayList arrayList = new ArrayList();
            boolean z2 = !ListUtils.isEmpty(list);
            boolean z3 = !ListUtils.isEmpty(list);
            if (!TbadkCoreApplication.isLogin()) {
                p66 p66Var = new p66();
                p66Var.setTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b43));
                p66Var.h();
                arrayList.add(p66Var);
            } else {
                dp4 dp4Var = new dp4();
                dp4Var.f(4);
                arrayList.add(dp4Var);
                if (z3) {
                    t66 t66Var = new t66(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b4d), z2, false);
                    v66 v66Var = new v66();
                    v66Var.d = t66Var;
                    v66Var.e = list;
                    arrayList.add(v66Var);
                }
            }
            z76 z76Var = this.u;
            if (z76Var != null && z76Var.g() && this.u.e() != null) {
                this.A = true;
                arrayList.add(R());
                arrayList.addAll(this.u.e().a());
            }
            V();
            this.e.m(arrayList, z);
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.b.registerListener(this.H);
        }
    }

    public void n0(u66 u66Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048612, this, u66Var, z) == null) {
            this.f.remove(u66Var);
            l0(this.f, this.g, z);
            c0(z);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            ImageView imageView = this.O;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(P(), 0);
            ofInt.addUpdateListener(new k(this));
            ofInt.addListener(new l(this));
            ofInt.setDuration(300L);
            ofInt.start();
        }
    }

    @Override // com.baidu.tieba.enterForum.view.EnterForumAdView.c
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.P) {
            j0();
        }
    }

    public void p0() {
        int dimensionPixelSize;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.P) {
            return;
        }
        this.J = true;
        r0();
        int dimensionPixelOffset = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.c.p();
        EnterForumAdView enterForumAdView = this.m;
        if (enterForumAdView != null) {
            if (!enterForumAdView.f()) {
                dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.a.getResources().getDimensionPixelSize(R.dimen.tbds134);
            } else if (!this.m.e()) {
                dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds370);
            }
            dimensionPixelOffset += dimensionPixelSize;
        }
        w0(dimensionPixelOffset);
        rg.a().removeCallbacks(this.L);
        rg.a().postDelayed(this.L, 3000L);
    }

    public void q0(r66 r66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, r66Var) == null) {
            this.s = r66Var;
            l66 l66Var = this.e;
            if (l66Var != null) {
                l66Var.l(r66Var);
            }
            if (r66Var != null && r66Var.a) {
                if (this.c.getView() != null) {
                    this.c.getView().setScaleX(0.5f);
                    this.c.getView().setScaleY(0.5f);
                }
                this.c.R(R.raw.ad_refresh_load);
                return;
            }
            if (this.c.getView() != null) {
                this.c.getView().setScaleX(1.0f);
                this.c.getView().setScaleY(1.0f);
            }
            this.c.R(R.raw.lottie_common_pull_refresh);
        }
    }

    public final void r0() {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.P || (enterForumAdView = this.m) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            int O = O();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(0, this.J ? -this.a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.F + this.G) - O, 0, 0);
            this.m.setLayoutParams(layoutParams2);
            this.m.setAdViewHeight(layoutParams2.height - O);
        }
    }

    public final void s0(float f2) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048618, this, f2) == null) {
            int N = N();
            int S = S() - N;
            float f3 = N;
            float abs = Math.abs(f3 / S);
            int i2 = (int) f2;
            EnterForumAdView enterForumAdView = this.m;
            if (enterForumAdView != null) {
                ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    O();
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
                            viewGroup.bringChildToFront(this.M);
                            viewGroup.bringChildToFront(this.O);
                        }
                    } else if (this.m.getParent() == this.m.getRootView()) {
                        if (this.m.getParent() != null) {
                            ViewGroup viewGroup2 = (ViewGroup) this.m.getRootView();
                            ((ViewGroup) this.m.getParent()).removeView(this.m);
                        }
                        if (this.m.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                            this.b.t1().addView(this.m, 0, marginLayoutParams3);
                        }
                    }
                }
            }
            this.d.setVisibility(0);
            this.P = false;
            float f4 = i2;
            w0(((int) ((f4 * abs) - (abs * f3))) * 2);
            this.P = true;
            float abs2 = Math.abs(f4 / f3);
            this.d.setAlpha(abs2);
            View B = this.b.v1().B();
            if (B != null) {
                B.setAlpha(abs2);
            }
            View findViewById = this.b.t1().getRootView().findViewById(R.id.obfuscated_res_0x7f091fd7);
            if (findViewById != null) {
                findViewById.setAlpha(abs2);
            }
        }
    }

    public void t0(b76 b76Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, b76Var) == null) || b76Var == null) {
            return;
        }
        if (StringUtils.isNull(b76Var.d())) {
            this.Q = false;
        } else {
            this.Q = true;
        }
        this.o.o(b76Var.c());
        this.o.p(b76Var.b(), b76Var.e());
        this.o.l(b76Var.a());
        this.o.u(b76Var.d());
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048620, this, z) == null) || this.t == z) {
            return;
        }
        this.t = z;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        if (!z) {
            marginLayoutParams.topMargin += this.d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
        } else {
            marginLayoutParams.topMargin -= this.d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
        }
        this.d.setLayoutParams(marginLayoutParams);
    }

    public void v0(av4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, gVar) == null) {
            this.B = gVar;
        }
    }

    public final void w0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048622, this, i2) == null) || this.P) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        marginLayoutParams.topMargin = ((i2 + this.w) - this.x) - (EnterForumDelegateStatic.e.E() != null ? this.a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        this.d.setLayoutParams(marginLayoutParams);
    }

    public void x0(BdUniqueId bdUniqueId) {
        l66 l66Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, bdUniqueId) == null) || (l66Var = this.e) == null) {
            return;
        }
        l66Var.n(bdUniqueId);
    }

    public void y0(boolean z) {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048624, this, z) == null) || (enterForumAdView = this.m) == null) {
            return;
        }
        enterForumAdView.setRecentlyIsExtend(z);
    }

    public void z0(boolean z) {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048625, this, z) == null) || (enterForumAdView = this.m) == null) {
            return;
        }
        enterForumAdView.setRecentlyIsShow(z);
    }
}
