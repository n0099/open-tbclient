package d.a.p0.h2.k.e.g1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import d.a.o0.r.k;
import d.a.p0.h2.k.e.f0;
import d.a.p0.h2.k.e.g0;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f57313a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57314b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57315c;

    /* renamed from: d  reason: collision with root package name */
    public View f57316d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f57317e;

    /* renamed from: f  reason: collision with root package name */
    public final View f57318f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f57319g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f57320h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f57321i;
    public BarImageView j;
    public TextView k;
    public String l;
    public AlertDialog m;
    public f0 n;
    public float o;
    public PbFragment p;
    public Runnable q;
    public ImageView r;
    public boolean s;
    public PopupWindow t;
    public int u;
    public int v;
    public int w;
    public int x;
    public Runnable y;
    public View.OnClickListener z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57322e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57322e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57322e.p.a5();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* renamed from: d.a.p0.h2.k.e.g1.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1423c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57323e;

        public RunnableC1423c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57323e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57323e.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.a(this.f57323e.m, this.f57323e.p.getPageContext().getPageActivity()))));
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57324e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57324e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57324e.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57325e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57325e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57325e.j();
            }
        }
    }

    public c(PbFragment pbFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57314b = false;
        this.m = null;
        this.n = null;
        this.o = 0.33f;
        this.s = false;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = new d(this);
        this.z = new e(this);
        this.p = pbFragment;
        this.u = l.g(pbFragment.getContext(), R.dimen.ds88);
        this.v = l.g(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int k = l.k(TbadkCoreApplication.getInst());
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds102) + ((int) (k * 0.07d));
        this.w = g3;
        if (g3 - g2 > 0) {
            this.w = g3 - g2;
        }
        this.x = (k - (this.w * 2)) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.f57313a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.f57313a.hideBottomLine();
        this.f57318f = this.f57313a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.W1);
        this.f57315c = this.f57313a.setCenterTextTitle("");
        this.f57319g = (ImageView) this.f57313a.getCenterImgBox();
        this.f57320h = (LinearLayout) this.f57313a.getCenterImgBoxLayout();
        int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.f57320h.setPadding(g4, 0, g4, 0);
        ImageView imageView = this.f57319g;
        int i4 = R.drawable.icon_pb_play_small;
        SkinManager.setNavbarIconSrc(imageView, i4, i4);
        this.f57319g.setVisibility(8);
        this.f57315c.setOnClickListener(pbFragment.W1);
        this.f57319g.setOnClickListener(pbFragment.W1);
        this.r = (ImageView) this.f57318f.findViewById(R.id.widget_navi_back_button);
        if (this.f57321i == null) {
            LinearLayout linearLayout = (LinearLayout) this.f57313a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.f57321i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.pb_nav_title_forum_image);
            this.j = barImageView;
            barImageView.setShowOval(true);
            this.j.setShowOuterBorder(false);
            this.j.setShowInnerBorder(true);
            this.j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.j.setStrokeColorResId(R.color.CAM_X0401);
            this.j.setOnClickListener(pbFragment.W1);
            TextView textView = (TextView) this.f57321i.findViewById(R.id.pb_nav_title_forum_name);
            this.k = textView;
            textView.setOnClickListener(pbFragment.W1);
            if (this.f57321i.getLayoutParams() != null && (this.f57321i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f57321i.getLayoutParams();
                int i5 = this.w;
                marginLayoutParams.leftMargin = i5;
                marginLayoutParams.rightMargin = i5;
                this.f57321i.setLayoutParams(marginLayoutParams);
            }
            if (this.f57321i.getVisibility() == 8) {
                this.f57321i.setVisibility(0);
            }
            if (this.f57321i.getAlpha() != 1.0f) {
                this.f57321i.setAlpha(1.0f);
            }
        }
    }

    public void A() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (view = this.f57316d) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.p == null || this.f57321i == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.j.setVisibility(8);
            this.k.setText("贴吧动态");
            this.l = null;
        } else {
            this.j.setVisibility(0);
            this.l = str;
            ThreadCardUtils.cutAndSetTextByMaxLine(this.k, str, R.string.forum, R.dimen.tbds0, 1, this.x, false);
            k.c().h(str);
            this.j.M(str2, 10, false);
        }
        q();
    }

    public final void C() {
        f0 f0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (f0Var = this.n) == null) {
            return;
        }
        f0Var.u();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g.c(this.t);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.q == null) {
                this.q = new RunnableC1423c(this);
            }
            d.a.c.e.m.e.a().postDelayed(this.q, 100L);
        }
    }

    public void f() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alertDialog = this.m) == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.a(alertDialog, this.p.getPageContext().getPageActivity()))));
    }

    public f0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (f0) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f57319g : (View) invokeV.objValue;
    }

    public NavigationBar i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f57313a : (NavigationBar) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.y != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.y);
            }
            d();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.r.setVisibility(0);
            r(false);
            View view = this.f57316d;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            AlertDialog alertDialog = this.m;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            NavigationBar navigationBar = this.f57313a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.p.getPageContext(), i2);
                SkinManager.setBackgroundResource(this.f57313a.getBarBgView(), R.color.CAM_X0207);
            }
            BarImageView barImageView = this.j;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.f57317e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.f57315c, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            q();
            C();
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f57313a.onChangeSkinType(this.p.getPageContext(), i2);
            this.f57313a.getBackground().mutate().setAlpha(0);
            this.f57313a.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
            this.f57313a.getTopCoverBgView().setVisibility(0);
            this.f57313a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
            this.f57315c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
            WebPManager.setPureDrawable(this.f57317e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void o(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            f0 f0Var = this.n;
            if (f0Var != null) {
                f0Var.t();
            }
            this.m = null;
            this.n = null;
            d.a.c.e.m.e.a().removeCallbacks(this.q);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f57321i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.f57321i);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            return;
        }
        this.f57321i.setBackgroundResource(0);
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (!this.f57314b && z && !"".equals(this.f57315c.getText().toString())) {
                this.f57315c.setVisibility(0);
            } else {
                this.f57315c.setVisibility(8);
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.s = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.f57318f.setVisibility(0);
            } else {
                this.f57318f.setVisibility(8);
            }
            r(z);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if ((!this.s || TbadkCoreApplication.isLogin()) && !d.a.o0.r.d0.b.j().g("show_share", false)) {
                View inflate = LayoutInflater.from(this.p.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.arrow_up);
                TextView textView = (TextView) inflate.findViewById(R.id.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.g(this.p.getContext(), R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.g(this.p.getContext(), R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.z);
                this.t = new PopupWindow(inflate, -2, -2);
            }
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.r.setVisibility(0);
            r(z);
            if (TbadkCoreApplication.isLogin()) {
                View view = this.f57316d;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            View view2 = this.f57316d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void w(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, g0Var) == null) || this.p.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.p;
        this.n = new f0(pbFragment, pbFragment.W1);
        AlertDialog create = new AlertDialog.Builder(this.p.getContext(), R.style.DialogTheme).create();
        this.m = create;
        create.setCanceledOnTouchOutside(true);
        this.m.setOnDismissListener(new b(this));
        g.i(this.m, this.p.getFragmentActivity());
        Window window = this.m.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.n.r());
        window.setDimAmount(this.o);
        this.n.I(g0Var == null ? false : g0Var.f57286a);
        this.n.w(g0Var == null ? false : g0Var.f57290e);
        this.n.A(g0Var == null ? false : g0Var.f57294i);
        this.n.x(g0Var == null ? false : g0Var.f57291f);
        this.n.K(g0Var != null ? g0Var.f57288c : true);
        this.n.H(g0Var == null ? false : g0Var.k);
        if (g0Var == null) {
            this.n.F(false, false);
            this.n.B(false, false);
        } else {
            this.n.F(g0Var.f57292g, g0Var.q);
            this.n.B(g0Var.f57293h, g0Var.p);
        }
        boolean z = g0Var == null ? false : g0Var.o;
        boolean z2 = g0Var == null ? false : g0Var.m;
        boolean z3 = g0Var == null ? false : g0Var.f57289d;
        boolean z4 = g0Var == null ? false : g0Var.f57287b;
        boolean z5 = g0Var == null ? false : g0Var.n;
        boolean z6 = g0Var == null ? false : g0Var.j;
        boolean z7 = g0Var == null ? false : g0Var.l;
        this.n.y(z3, z2);
        this.n.J(z4, z);
        this.n.G(z6, z5);
        this.n.N(z7);
        if (g0Var != null) {
            f0 f0Var = this.n;
            boolean z8 = g0Var.r;
            f0Var.u = z8;
            if (z8) {
                f0Var.f().setText(R.string.report_text);
                this.n.x(false);
            }
        }
        this.n.v(g0Var == null ? false : g0Var.s);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.y() != null && this.p.y().D0() != null && this.p.y().D0().P() != null && this.p.y().D0().P().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.d().setText(R.string.have_called_fans_short);
        }
        C();
        this.n.O(g0Var != null ? g0Var.t : false);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.f57314b) {
                this.f57315c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
                r(true);
                k.c().h(str);
                return;
            }
            r(false);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            this.f57314b = z;
            if (this.f57316d == null && this.f57317e == null) {
                View addCustomView = this.f57313a.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.p.W1);
                this.f57316d = addCustomView;
                this.f57317e = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
                int i2 = this.u;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                layoutParams.rightMargin = this.v;
                this.f57316d.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57317e, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f57316d.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            }
        }
    }

    public void z(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (view = this.f57316d) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }
}
