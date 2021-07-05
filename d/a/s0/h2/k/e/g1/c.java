package d.a.s0.h2.k.e.g1;

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
import d.a.r0.r.k;
import d.a.s0.h2.k.e.f0;
import d.a.s0.h2.k.e.g0;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f60557a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60558b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60559c;

    /* renamed from: d  reason: collision with root package name */
    public View f60560d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f60561e;

    /* renamed from: f  reason: collision with root package name */
    public final View f60562f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f60563g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f60564h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f60565i;
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

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60566e;

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
            this.f60566e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60566e.p.Z4();
            }
        }
    }

    /* loaded from: classes9.dex */
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

    /* renamed from: d.a.s0.h2.k.e.g1.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1468c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60567e;

        public RunnableC1468c(c cVar) {
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
            this.f60567e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60567e.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.a(this.f60567e.m, this.f60567e.p.getPageContext().getPageActivity()))));
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60568e;

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
            this.f60568e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60568e.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60569e;

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
            this.f60569e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60569e.j();
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
        this.f60558b = false;
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
        this.f60557a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.f60557a.hideBottomLine();
        this.f60562f = this.f60557a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.W1);
        this.f60559c = this.f60557a.setCenterTextTitle("");
        this.f60563g = (ImageView) this.f60557a.getCenterImgBox();
        this.f60564h = (LinearLayout) this.f60557a.getCenterImgBoxLayout();
        int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.f60564h.setPadding(g4, 0, g4, 0);
        ImageView imageView = this.f60563g;
        int i4 = R.drawable.icon_pb_play_small;
        SkinManager.setNavbarIconSrc(imageView, i4, i4);
        this.f60563g.setVisibility(8);
        this.f60559c.setOnClickListener(pbFragment.W1);
        this.f60563g.setOnClickListener(pbFragment.W1);
        this.r = (ImageView) this.f60562f.findViewById(R.id.widget_navi_back_button);
        if (this.f60565i == null) {
            LinearLayout linearLayout = (LinearLayout) this.f60557a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.f60565i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.pb_nav_title_forum_image);
            this.j = barImageView;
            barImageView.setShowOval(true);
            this.j.setShowOuterBorder(false);
            this.j.setShowInnerBorder(true);
            this.j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.j.setStrokeColorResId(R.color.CAM_X0401);
            this.j.setOnClickListener(pbFragment.W1);
            TextView textView = (TextView) this.f60565i.findViewById(R.id.pb_nav_title_forum_name);
            this.k = textView;
            textView.setOnClickListener(pbFragment.W1);
            if (this.f60565i.getLayoutParams() != null && (this.f60565i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f60565i.getLayoutParams();
                int i5 = this.w;
                marginLayoutParams.leftMargin = i5;
                marginLayoutParams.rightMargin = i5;
                this.f60565i.setLayoutParams(marginLayoutParams);
            }
            if (this.f60565i.getVisibility() == 8) {
                this.f60565i.setVisibility(0);
            }
            if (this.f60565i.getAlpha() != 1.0f) {
                this.f60565i.setAlpha(1.0f);
            }
        }
    }

    public void A() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (view = this.f60560d) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.p == null || this.f60565i == null) {
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
        f0Var.v();
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
                this.q = new RunnableC1468c(this);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60563g : (View) invokeV.objValue;
    }

    public NavigationBar i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f60557a : (NavigationBar) invokeV.objValue;
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
            View view = this.f60560d;
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
            NavigationBar navigationBar = this.f60557a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.p.getPageContext(), i2);
                SkinManager.setBackgroundResource(this.f60557a.getBarBgView(), R.color.CAM_X0207);
            }
            BarImageView barImageView = this.j;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.f60561e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.f60559c, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            q();
            C();
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f60557a.onChangeSkinType(this.p.getPageContext(), i2);
            this.f60557a.getBackground().mutate().setAlpha(0);
            this.f60557a.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
            this.f60557a.getTopCoverBgView().setVisibility(0);
            this.f60557a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
            this.f60559c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
            WebPManager.setPureDrawable(this.f60561e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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
                f0Var.u();
            }
            this.m = null;
            this.n = null;
            d.a.c.e.m.e.a().removeCallbacks(this.q);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f60565i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.f60565i);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            return;
        }
        this.f60565i.setBackgroundResource(0);
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (!this.f60558b && z && !"".equals(this.f60559c.getText().toString())) {
                this.f60559c.setVisibility(0);
            } else {
                this.f60559c.setVisibility(8);
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
                this.f60562f.setVisibility(0);
            } else {
                this.f60562f.setVisibility(8);
            }
            r(z);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if ((!this.s || TbadkCoreApplication.isLogin()) && !d.a.r0.r.d0.b.j().g("show_share", false)) {
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
                View view = this.f60560d;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            View view2 = this.f60560d;
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
        window.setContentView(this.n.s());
        window.setDimAmount(this.o);
        this.n.J(g0Var == null ? false : g0Var.f60530a);
        this.n.x(g0Var == null ? false : g0Var.f60534e);
        this.n.B(g0Var == null ? false : g0Var.f60538i);
        this.n.y(g0Var == null ? false : g0Var.f60535f);
        this.n.L(g0Var != null ? g0Var.f60532c : true);
        this.n.I(g0Var == null ? false : g0Var.k);
        if (g0Var == null) {
            this.n.G(false, false);
            this.n.F(false, false);
        } else {
            this.n.G(g0Var.f60536g, g0Var.q);
            this.n.F(g0Var.f60537h, g0Var.p);
        }
        boolean z = g0Var == null ? false : g0Var.o;
        boolean z2 = g0Var == null ? false : g0Var.m;
        boolean z3 = g0Var == null ? false : g0Var.f60533d;
        boolean z4 = g0Var == null ? false : g0Var.f60531b;
        boolean z5 = g0Var == null ? false : g0Var.n;
        boolean z6 = g0Var == null ? false : g0Var.j;
        boolean z7 = g0Var == null ? false : g0Var.l;
        this.n.z(z3, z2);
        this.n.K(z4, z);
        this.n.H(z6, z5);
        this.n.O(z7);
        if (g0Var != null) {
            f0 f0Var = this.n;
            boolean z8 = g0Var.r;
            f0Var.u = z8;
            if (z8) {
                f0Var.f().setText(R.string.report_text);
                this.n.y(false);
            }
        }
        this.n.w(g0Var == null ? false : g0Var.s);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.y() != null && this.p.y().D0() != null && this.p.y().D0().P() != null && this.p.y().D0().P().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.d().setText(R.string.have_called_fans_short);
        }
        C();
        this.n.P(g0Var != null ? g0Var.t : false);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.f60558b) {
                this.f60559c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
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
            this.f60558b = z;
            if (this.f60560d == null && this.f60561e == null) {
                View addCustomView = this.f60557a.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.p.W1);
                this.f60560d = addCustomView;
                this.f60561e = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
                int i2 = this.u;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                layoutParams.rightMargin = this.v;
                this.f60560d.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60561e, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f60560d.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            }
        }
    }

    public void z(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (view = this.f60560d) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }
}
