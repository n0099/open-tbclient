package d.a.q0.h2.k.e.h1;

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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.h2.k.e.f0;
import d.a.q0.h2.k.e.g0;
import d.a.q0.h3.q0.k;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn A;
    public boolean B;
    public d.a.q0.h2.h.e C;
    public String D;
    public CustomMessageListener E;
    public CustomMessageListener F;
    public Runnable G;
    public View.OnClickListener H;

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f57901a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57902b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57903c;

    /* renamed from: d  reason: collision with root package name */
    public View f57904d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f57905e;

    /* renamed from: f  reason: collision with root package name */
    public final View f57906f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f57907g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f57908h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f57909i;
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
    public int y;
    public View z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57910e;

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
            this.f57910e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57910e.p.g5();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f57911a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f57911a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && ((k) customResponsedMessage.getData()).f58819b) {
                this.f57911a.B = true;
                c cVar = this.f57911a;
                cVar.K(cVar.B);
            }
        }
    }

    /* renamed from: d.a.q0.h2.k.e.h1.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1434c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f57912a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1434c(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f57912a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.f57912a.z != null) {
                    if (!booleanValue || this.f57912a.B) {
                        this.f57912a.z.setVisibility(4);
                    } else {
                        this.f57912a.z.setVisibility(0);
                        TbPageTag l = d.a.p0.l0.c.l(this.f57912a.p.getContext());
                        if (this.f57912a.C != null && l != null) {
                            d.a.q0.h2.k.e.g1.c.a("c14277", this.f57912a.D, this.f57912a.C.P(), TbadkCoreApplication.getCurrentAccount(), l.locatePage);
                        }
                    }
                    c cVar = this.f57912a;
                    cVar.K(cVar.B);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57913e;

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
            this.f57913e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57913e.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!d.a.d.e.m.g.a(this.f57913e.m, this.f57913e.p.getPageContext().getPageActivity()))));
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57914e;

        public f(c cVar) {
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
            this.f57914e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57914e.j();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57915e;

        public g(c cVar) {
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
            this.f57915e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57915e.q();
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
        this.f57902b = false;
        this.m = null;
        this.n = null;
        this.o = 0.33f;
        this.s = false;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.B = false;
        this.E = new b(this, 2001437);
        this.F = new C1434c(this, 2921599);
        this.G = new f(this);
        this.H = new g(this);
        this.p = pbFragment;
        this.u = l.g(pbFragment.getContext(), R.dimen.ds88);
        this.v = l.g(TbadkCoreApplication.getInst(), R.dimen.ds14);
        this.y = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds_6);
        int k = l.k(TbadkCoreApplication.getInst());
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds102) + ((int) (k * 0.07d));
        this.w = g3;
        if (g3 - g2 > 0) {
            this.w = g3 - g2;
        }
        this.x = (k - (this.w * 2)) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.f57901a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.f57901a.hideBottomLine();
        this.f57906f = this.f57901a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.W1);
        this.f57903c = this.f57901a.setCenterTextTitle("");
        this.f57907g = (ImageView) this.f57901a.getCenterImgBox();
        this.f57908h = (LinearLayout) this.f57901a.getCenterImgBoxLayout();
        int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.f57908h.setPadding(g4, 0, g4, 0);
        ImageView imageView = this.f57907g;
        int i4 = R.drawable.icon_pb_play_small;
        SkinManager.setNavbarIconSrc(imageView, i4, i4);
        this.f57907g.setVisibility(8);
        this.f57903c.setOnClickListener(pbFragment.W1);
        this.f57907g.setOnClickListener(pbFragment.W1);
        this.r = (ImageView) this.f57906f.findViewById(R.id.widget_navi_back_button);
        if (this.f57909i == null) {
            if (!d.a.p0.b.d.M() && !d.a.p0.b.d.O()) {
                s();
            } else {
                t();
            }
        }
        pbFragment.registerListener(this.E);
        pbFragment.registerListener(this.F);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (!this.f57902b && z && !"".equals(this.f57903c.getText().toString())) {
                this.f57903c.setVisibility(0);
            } else {
                this.f57903c.setVisibility(8);
            }
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.s = z;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f57906f.setVisibility(0);
            } else {
                this.f57906f.setVisibility(8);
            }
            A(z);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((!this.s || TbadkCoreApplication.isLogin()) && !d.a.p0.s.d0.b.j().g("show_share", false)) {
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
                textView.setOnClickListener(this.H);
                this.t = new PopupWindow(inflate, -2, -2);
            }
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.r.setVisibility(0);
            A(z);
            if (TbadkCoreApplication.isLogin()) {
                View view = this.f57904d;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            View view2 = this.f57904d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void F(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, g0Var) == null) || this.p.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.p;
        this.n = new f0(pbFragment, pbFragment.W1);
        AlertDialog create = new AlertDialog.Builder(this.p.getContext(), R.style.DialogTheme).create();
        this.m = create;
        create.setCanceledOnTouchOutside(true);
        this.m.setOnDismissListener(new d(this));
        d.a.d.e.m.g.i(this.m, this.p.getFragmentActivity());
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
        this.n.K(g0Var == null ? false : g0Var.f57852a);
        this.n.x(g0Var == null ? false : g0Var.f57856e);
        this.n.F(g0Var == null ? false : g0Var.f57860i);
        this.n.y(g0Var == null ? false : g0Var.f57857f);
        this.n.M(g0Var != null ? g0Var.f57854c : true);
        this.n.J(g0Var == null ? false : g0Var.k);
        this.n.z(g0Var == null ? false : g0Var.l, g0Var.s);
        if (g0Var == null) {
            this.n.H(false, false);
            this.n.G(false, false);
        } else {
            this.n.H(g0Var.f57858g, g0Var.r);
            this.n.G(g0Var.f57859h, g0Var.q);
        }
        boolean z = g0Var == null ? false : g0Var.p;
        boolean z2 = g0Var == null ? false : g0Var.n;
        boolean z3 = g0Var == null ? false : g0Var.f57855d;
        boolean z4 = g0Var == null ? false : g0Var.f57853b;
        boolean z5 = g0Var == null ? false : g0Var.o;
        boolean z6 = g0Var == null ? false : g0Var.j;
        boolean z7 = g0Var == null ? false : g0Var.m;
        this.n.A(z3, z2);
        this.n.L(z4, z);
        this.n.I(z6, z5);
        this.n.P(z7);
        if (g0Var != null) {
            f0 f0Var = this.n;
            boolean z8 = g0Var.t;
            f0Var.v = z8;
            if (z8) {
                f0Var.f().setText(R.string.report_text);
                this.n.y(false);
            }
        }
        this.n.w(g0Var == null ? false : g0Var.u);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.y() != null && this.p.y().L0() != null && this.p.y().L0().P() != null && this.p.y().L0().P().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.d().setText(R.string.have_called_fans_short);
        }
        M();
        this.n.Q(g0Var != null ? g0Var.v : false);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.f57902b) {
                this.f57903c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
                A(true);
                d.a.p0.s.k.c().h(str);
                return;
            }
            A(false);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            this.f57902b = z;
            if (this.f57904d == null && this.f57905e == null) {
                if (d.a.p0.b.d.O() || d.a.p0.b.d.M()) {
                    View addCustomView = this.f57901a.addCustomView(controlAlign, R.layout.navigation_right_attention_btn, this.p.W1);
                    this.z = addCustomView;
                    addCustomView.setVisibility(4);
                    TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.z.findViewById(R.id.navigation_attention);
                    this.A = tBSpecificationBtn;
                    tBSpecificationBtn.setTextSize(R.dimen.T_X08);
                }
                View addCustomView2 = this.f57901a.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.p.W1);
                this.f57904d = addCustomView2;
                this.f57905e = (ImageView) addCustomView2.findViewById(R.id.navigationBarBtnMore);
                int i2 = this.u;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                layoutParams.rightMargin = this.v;
                this.f57904d.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57905e, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f57904d.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            }
        }
    }

    public void I(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (view = this.f57904d) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void J() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (view = this.f57904d) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void K(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (tBSpecificationBtn = this.A) == null) {
            return;
        }
        if (z) {
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.followed));
            ((d.a.p0.s.f0.n.b) this.A.getStyleConfig()).r(R.color.CAM_X0109);
            return;
        }
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.attention));
    }

    public void L(d.a.q0.h2.h.e eVar, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{eVar, str, str2, str3, Boolean.valueOf(z)}) == null) || this.p == null || this.f57909i == null) {
            return;
        }
        this.C = eVar;
        this.D = str2;
        if (StringUtils.isNull(str)) {
            this.j.setVisibility(8);
            this.k.setText("贴吧动态");
            this.l = null;
        } else {
            this.j.setVisibility(0);
            this.l = str;
            ThreadCardUtils.cutAndSetTextByMaxLine(this.k, str, R.string.forum, R.dimen.tbds0, 1, this.x, false);
            d.a.p0.s.k.c().h(str);
            this.j.M(str3, 10, false);
        }
        View view = this.z;
        if (view != null && this.C != null) {
            view.setTag(R.id.forum_name, str);
            this.z.setTag(R.id.forum_id, str2);
            this.z.setTag(R.id.thread_id, this.C.P());
            this.B = z;
        }
        z();
    }

    public final void M() {
        f0 f0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (f0Var = this.n) == null) {
            return;
        }
        f0Var.v();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.d.e.m.g.c(this.t);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.q == null) {
                this.q = new e(this);
            }
            d.a.d.e.m.e.a().postDelayed(this.q, 100L);
        }
    }

    public void l() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (alertDialog = this.m) == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!d.a.d.e.m.g.a(alertDialog, this.p.getPageContext().getPageActivity()))));
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.z : (View) invokeV.objValue;
    }

    public f0 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.n : (f0) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f57907g : (View) invokeV.objValue;
    }

    public NavigationBar p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f57901a : (NavigationBar) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.G != null) {
                d.a.d.e.m.e.a().removeCallbacks(this.G);
            }
            j();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.r.setVisibility(0);
            A(false);
            View view = this.f57904d;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f57901a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.f57909i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.pb_nav_title_forum_image);
            this.j = barImageView;
            barImageView.setShowOval(true);
            this.j.setShowOuterBorder(false);
            this.j.setShowInnerBorder(true);
            this.j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.j.setStrokeColorResId(R.color.CAM_X0401);
            this.j.setOnClickListener(this.p.W1);
            TextView textView = (TextView) this.f57909i.findViewById(R.id.pb_nav_title_forum_name);
            this.k = textView;
            textView.setOnClickListener(this.p.W1);
            if (this.f57909i.getLayoutParams() != null && (this.f57909i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f57909i.getLayoutParams();
                int i2 = this.w;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
                this.f57909i.setLayoutParams(marginLayoutParams);
            }
            if (this.f57909i.getVisibility() == 8) {
                this.f57909i.setVisibility(0);
            }
            if (this.f57909i.getAlpha() != 1.0f) {
                this.f57909i.setAlpha(1.0f);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f57901a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.f57909i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.pb_nav_title_forum_image);
            this.j = barImageView;
            ViewGroup.LayoutParams layoutParams = barImageView.getLayoutParams();
            layoutParams.width = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds62);
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds62);
            this.j.setLayoutParams(layoutParams);
            this.j.setShowOval(true);
            this.j.setShowOuterBorder(false);
            this.j.setShowInnerBorder(true);
            this.j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.j.setStrokeColorResId(R.color.CAM_X0401);
            this.j.setOnClickListener(this.p.W1);
            TextView textView = (TextView) this.f57909i.findViewById(R.id.pb_nav_title_forum_name);
            this.k = textView;
            d.a.p0.s.u.c.d(textView).x(R.dimen.T_X05);
            this.k.setOnClickListener(this.p.W1);
            if (this.f57909i.getLayoutParams() != null && (this.f57909i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f57909i.getLayoutParams();
                marginLayoutParams.leftMargin = this.y;
                this.f57909i.setLayoutParams(marginLayoutParams);
            }
            if (this.f57909i.getVisibility() == 8) {
                this.f57909i.setVisibility(0);
            }
            if (this.f57909i.getAlpha() != 1.0f) {
                this.f57909i.setAlpha(1.0f);
            }
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            AlertDialog alertDialog = this.m;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            NavigationBar navigationBar = this.f57901a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.p.getPageContext(), i2);
                SkinManager.setBackgroundResource(this.f57901a.getBarBgView(), R.color.CAM_X0207);
            }
            BarImageView barImageView = this.j;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.f57905e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.f57903c, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            z();
            M();
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.f57901a.onChangeSkinType(this.p.getPageContext(), i2);
            this.f57901a.getBackground().mutate().setAlpha(0);
            this.f57901a.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
            this.f57901a.getTopCoverBgView().setVisibility(0);
            this.f57901a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
            this.f57903c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
            WebPManager.setPureDrawable(this.f57905e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void x(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view) == null) {
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            f0 f0Var = this.n;
            if (f0Var != null) {
                f0Var.u();
            }
            this.m = null;
            this.n = null;
            d.a.d.e.m.e.a().removeCallbacks(this.q);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.f57909i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            if (!d.a.p0.b.d.M() && !d.a.p0.b.d.O()) {
                d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.f57909i);
                d2.n(R.string.J_X07);
                d2.f(R.color.CAM_X0209);
                return;
            }
            this.f57909i.setBackgroundResource(0);
            return;
        }
        this.f57909i.setBackgroundResource(0);
    }
}
