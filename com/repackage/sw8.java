package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public NavigationBar b;
    public RelativeLayout c;
    public ImageView d;
    public ImageView e;
    public RelativeLayout f;
    public ImageView g;
    public ImageView h;
    public PermissionJudgePolicy i;
    public View j;
    public ImageView k;
    public PopupWindow l;
    public boolean m;
    public Handler n;
    public int o;
    public Runnable p;
    public Runnable q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw8 a;

        public a(sw8 sw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sw8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o == 1) {
                    TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 22));
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "1"));
                }
                this.a.p(6, false);
                PersonRedTipManager.getInstance().updateRedTipState(6, false, true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(this.a.a)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw8 a;

        public b(sw8 sw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sw8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o == 1) {
                    TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 23));
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "2"));
                }
                this.a.p(5, false);
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "2"));
                this.a.p(5, false);
                PersonRedTipManager.getInstance().updateRedTipState(5, false, true);
                if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                    BdToast.d(this.a.a, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e80), 0).q();
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view2.getContext())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw8 a;

        /* loaded from: classes7.dex */
        public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public void onPermissionsGranted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TiebaStatic.log(new StatisticItem("c12706"));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(this.a.a.a)));
                }
            }
        }

        public c(sw8 sw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sw8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.a instanceof Activity)) {
                Activity activity = (Activity) this.a.a;
                if (this.a.i == null) {
                    this.a.i = new PermissionJudgePolicy();
                }
                this.a.i.clearRequestPermissionList();
                this.a.i.appendRequestPermission(activity, "android.permission.CAMERA");
                this.a.i.setOnPermissionsGrantedListener(new a(this));
                this.a.i.startRequestPermission(activity);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw8 a;

        public d(sw8 sw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sw8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (imageView = this.a.g) == null) {
                return;
            }
            rg.k(this.a.l, imageView);
            vt4.k().u("show_person_tab_feedback_tips", true);
            this.a.m = true;
            this.a.n.postDelayed(this.a.q, 3000L);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw8 a;

        public e(sw8 sw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sw8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
            }
        }
    }

    public sw8(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9);
        this.n = new Handler();
        this.p = new d(this);
        this.q = new e(this);
        this.o = i;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            if (this.o == 1) {
                RelativeLayout relativeLayout = this.c;
                if (relativeLayout != null && relativeLayout.getParent() == null) {
                    this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c, (View.OnClickListener) null);
                }
                RelativeLayout relativeLayout2 = this.f;
                if (relativeLayout2 != null && relativeLayout2.getParent() == null) {
                    this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f, (View.OnClickListener) null);
                }
                View view2 = this.j;
                if (view2 == null || view2.getParent() != null) {
                    return;
                }
                this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.j, (View.OnClickListener) null);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            rg.c(this.l);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.d != null) {
                if (2 == i) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else if (this.b.getBarBgView().getAlpha() < 0.5f) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                ImageView imageView = this.e;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.drawable.icon_news_down_bar_one);
                }
            }
            if (this.g != null) {
                if (2 == i) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else if (this.b.getBarBgView().getAlpha() < 0.5f) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                ImageView imageView2 = this.h;
                if (imageView2 != null) {
                    SkinManager.setImageResource(imageView2, R.drawable.icon_news_down_bar_one);
                }
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_scan44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void n(Context context, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, navigationBar) == null) {
            this.a = context;
            this.b = navigationBar;
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d040c, (ViewGroup) null);
            this.c = relativeLayout;
            this.d = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0917f1);
            this.e = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0917f2);
            RelativeLayout relativeLayout2 = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d040e, (ViewGroup) null);
            this.f = relativeLayout2;
            this.g = (ImageView) relativeLayout2.findViewById(R.id.obfuscated_res_0x7f0917f4);
            this.h = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0917f5);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d040d, (ViewGroup) null);
            this.j = inflate;
            this.k = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0917f3);
        }
    }

    public void o(uw8 uw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uw8Var) == null) {
            RelativeLayout relativeLayout = this.c;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new a(this));
            }
            RelativeLayout relativeLayout2 = this.f;
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(new b(this));
            }
            View view2 = this.j;
            if (view2 != null) {
                view2.setOnClickListener(new c(this));
            }
        }
    }

    public void p(int i, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 5 && (imageView2 = this.h) != null) {
                imageView2.setVisibility(z ? 0 : 8);
            } else if (i != 6 || (imageView = this.e) == null) {
            } else {
                imageView.setVisibility(z ? 0 : 8);
            }
        }
    }
}
