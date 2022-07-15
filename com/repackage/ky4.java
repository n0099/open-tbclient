package com.repackage;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gf;
import java.util.Map;
/* loaded from: classes6.dex */
public class ky4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBLottieAnimationView A;
    public int B;
    public int C;
    public int D;
    public h E;
    public YyExtData F;
    public String G;
    public ff a;
    public final Activity b;
    public final TbPageContext c;
    public ViewGroup d;
    public ef e;
    public final Handler f;
    public Runnable g;
    public int h;
    public String i;
    public String j;
    public TextView k;
    public TextView l;
    public HeadImageView m;
    public View n;
    public TBSpecificationBtn o;
    public String p;
    public String q;
    public View r;
    public View s;
    public ViewGroup t;
    public boolean u;
    public float v;
    public float w;
    public Long x;
    public String y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky4 a;

        public a(ky4 ky4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null) {
                return;
            }
            this.a.a.e(this.a.d);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements gf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky4 a;

        public b(ky4 ky4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky4Var;
        }

        @Override // com.repackage.gf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a = null;
                this.a.f.removeCallbacks(this.a.g);
            }
        }

        @Override // com.repackage.gf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ef {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky4 a;

        public c(ky4 ky4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky4Var;
        }

        @Override // com.repackage.ef
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ef
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ef
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) ? this.a.r == null ? this.a.s(layoutInflater) : this.a.r : (View) invokeL.objValue;
        }

        @Override // com.repackage.ef
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ef
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky4 a;

        public d(ky4 ky4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!oi.isEmpty(this.a.p)) {
                    UrlManager.getInstance().dealOneLink(this.a.c, new String[]{this.a.p});
                } else if (this.a.F != null) {
                    YYLiveUtil.jumpToYYLiveRoom(this.a.c, this.a.F, "rec_fuceng");
                }
                this.a.q();
                this.a.t();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky4 a;

        public e(ky4 ky4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!oi.isEmpty(this.a.p)) {
                    UrlManager.getInstance().dealOneLink(this.a.c, new String[]{this.a.p});
                } else if (this.a.F != null) {
                    YYLiveUtil.jumpToYYLiveRoom(this.a.c, this.a.F, "rec_fuceng");
                }
                this.a.q();
                this.a.t();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky4 a;

        public f(ky4 ky4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky4Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a.v = motionEvent.getY();
                    this.a.u = false;
                } else if (action != 1) {
                    if (action == 2) {
                        if (this.a.v == 0.0f) {
                            this.a.v = motionEvent.getY();
                        }
                        this.a.w = motionEvent.getY() - this.a.v;
                        if (this.a.w < 0.0f) {
                            this.a.u = true;
                        } else {
                            this.a.u = false;
                        }
                    }
                } else if (this.a.u) {
                    this.a.w();
                    this.a.t();
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky4 a;

        public g(ky4 ky4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A.playAnimation();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface h {
        void dismiss();
    }

    public ky4(TbPageContext<?> tbPageContext, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new Handler();
        this.u = false;
        this.w = 0.0f;
        this.B = UtilHelper.getDimenPixelSize(R.dimen.M_H_X013);
        this.C = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        this.D = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.F = null;
        this.c = tbPageContext;
        this.b = tbPageContext.getPageActivity();
        if (map != null) {
            this.i = (String) map.get("view_top_params_key_title");
            this.j = (String) map.get("view_top_params_key_desc");
            this.h = ((Integer) map.get("view_top_params_key_type")).intValue();
            this.p = (String) map.get("view_top_params_key_schema");
            this.q = (String) map.get("view_top_params_key_image_url");
            this.F = (YyExtData) map.get("view_top_params_key_yyext");
            String str = (String) map.get("view_top_params_user_name");
            this.x = (Long) map.get("view_top_params_room_id");
            this.y = (String) map.get("view_top_params_btn_text");
            this.z = ((Boolean) map.get("view_top_params_is_breathe")).booleanValue();
            this.G = (String) map.get("view_top_params_key_nid");
        }
        this.d = u(this.b);
    }

    public void A() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (viewGroup = this.d) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        ff ffVar = this.a;
        if (ffVar != null) {
            ffVar.e(this.d);
        }
        this.g = new a(this);
        gf gfVar = new gf();
        gfVar.d(true);
        gfVar.g(new b(this));
        if (this.e == null) {
            this.e = r();
        }
        gfVar.a(this.e);
        gfVar.e(R.anim.obfuscated_res_0x7f0100fc);
        gfVar.f(R.anim.obfuscated_res_0x7f0100fd);
        ff b2 = gfVar.b();
        this.a = b2;
        b2.q(this.b, this.d, false);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.F == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_LIVE_REMIND_FLOAT_VIEW_CLICK);
        statisticItem.param("obj_type", this.h);
        statisticItem.param("liveid", this.x.longValue());
        statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
        statisticItem.param(TiebaStatic.YYParams.YYSID, this.F.mSid);
        statisticItem.param(TiebaStatic.YYParams.YYSSID, this.F.mSsid);
        statisticItem.param(TiebaStatic.YYParams.YYUID, this.F.mYyUid);
        statisticItem.param("template_id", this.F.mTemplateId);
        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
        statisticItem.param(TiebaStatic.Params.VID, this.G);
        TiebaStatic.log(statisticItem);
    }

    public final ef r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new c(this) : (ef) invokeV.objValue;
    }

    @NonNull
    public final View s(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutInflater)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0844, (ViewGroup) null);
            this.s = inflate;
            this.n = inflate.findViewById(R.id.obfuscated_res_0x7f090af3);
            this.k = (TextView) this.s.findViewById(R.id.obfuscated_res_0x7f090afa);
            this.l = (TextView) this.s.findViewById(R.id.obfuscated_res_0x7f090afc);
            this.m = (HeadImageView) this.s.findViewById(R.id.obfuscated_res_0x7f090af2);
            this.A = (TBLottieAnimationView) this.s.findViewById(R.id.obfuscated_res_0x7f09232b);
            this.o = (TBSpecificationBtn) this.s.findViewById(R.id.obfuscated_res_0x7f090af5);
            this.l.setText(this.i);
            this.k.setText(this.j);
            if (oi.isEmpty(this.y)) {
                this.o.setVisibility(8);
            } else {
                this.o.setText(this.y);
            }
            this.o.setOnClickListener(new d(this));
            this.n.setOnClickListener(new e(this));
            this.n.setOnTouchListener(new f(this));
            this.m.J(this.q, 10, false);
            this.m.setDefaultResource(17170445);
            this.m.setPlaceHolder(1);
            this.m.setIsRound(true);
            this.m.setBorderWidth(R.dimen.L_X02);
            this.m.setBorderColor(R.color.CAM_X0622);
            this.m.setDrawBorder(true);
            if (this.z) {
                SkinManager.setLottieAnimation(this.A, R.raw.card_live_header_bg);
            }
            this.A.setVisibility(0);
            if (!this.A.isAnimating()) {
                this.A.setSpeed(0.8f);
                this.A.setRepeatCount(-1);
                this.A.post(new g(this));
            }
            z();
            v();
            return this.s;
        }
        return (View) invokeL.objValue;
    }

    public void t() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ff ffVar = this.a;
            if (ffVar != null && (viewGroup = this.d) != null) {
                ffVar.e(viewGroup);
                this.d.setVisibility(8);
            }
            h hVar = this.E;
            if (hVar != null) {
                hVar.dismiss();
            }
        }
    }

    public final ViewGroup u(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            layoutParams.topMargin = this.B;
            layoutParams.leftMargin = this.C;
            layoutParams.rightMargin = this.D;
            FrameLayout frameLayout = new FrameLayout(activity);
            this.t = frameLayout;
            ((FrameLayout) activity.findViewById(16908290)).addView(frameLayout, layoutParams);
            return this.t;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(pi.f(this.b, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(pi.f(this.b, R.dimen.tbds16)).setOffsetX(0).setOffsetY(0).into(this.n);
            tu4 tu4Var = new tu4();
            tu4Var.p(R.color.CAM_X0302);
            this.o.setConfig(tu4Var);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.F == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_LIVE_REMIND_FLOAT_VIEW_HIDE);
        statisticItem.param("obj_type", this.h);
        statisticItem.param("liveid", this.x.longValue());
        statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
        statisticItem.param(TiebaStatic.YYParams.YYSID, this.F.mSid);
        statisticItem.param(TiebaStatic.YYParams.YYSSID, this.F.mSsid);
        statisticItem.param(TiebaStatic.YYParams.YYUID, this.F.mYyUid);
        statisticItem.param("template_id", this.F.mTemplateId);
        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
        statisticItem.param(TiebaStatic.Params.VID, this.G);
        TiebaStatic.log(statisticItem);
    }

    public void x(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
            this.E = hVar;
        }
    }

    public void y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            this.r = view2;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.F == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_LIVE_REMIND_FLOAT_VIEW_SHOW);
        statisticItem.param("obj_type", this.h);
        statisticItem.param("liveid", this.x.longValue());
        statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
        statisticItem.param(TiebaStatic.YYParams.YYSID, this.F.mSid);
        statisticItem.param(TiebaStatic.YYParams.YYSSID, this.F.mSsid);
        statisticItem.param(TiebaStatic.YYParams.YYUID, this.F.mYyUid);
        statisticItem.param("template_id", this.F.mTemplateId);
        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
        statisticItem.param(TiebaStatic.Params.VID, this.G);
        TiebaStatic.log(statisticItem);
    }
}
