package com.repackage;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.model.PersonCreatorModel;
import com.baidu.tieba.personCenter.view.PersonCreatorCenterDataView;
import com.baidu.tieba.personCenter.view.PersonCreatorCenterFunView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CreationData;
/* loaded from: classes7.dex */
public class x28 extends uw5<h28> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonCreatorCenterDataView A;
    public LinearLayout B;
    public LinearLayout C;
    public LinearLayout D;
    public LinearLayout E;
    public FrameLayout F;
    public TextView G;
    public TextView H;
    public View I;
    public View J;
    public View K;
    public PersonCreatorCenterFunView L;
    public PersonCreatorCenterFunView M;
    public PersonCreatorCenterFunView N;
    public PersonCreatorCenterFunView O;
    public PersonCreatorModel i;
    public TbPageContext j;
    public LinearLayout k;
    public LinearLayout l;
    public LinearLayout m;
    public TBSpecificationBtn n;
    public TBSpecificationBtn o;
    public PersonCreatorCenterFunView p;
    public PersonCreatorCenterFunView q;
    public PersonCreatorCenterFunView r;
    public PersonCreatorCenterDataView s;
    public PersonCreatorCenterDataView t;
    public PersonCreatorCenterDataView u;
    public ImageView v;
    public PersonCreatorCenterFunView w;
    public PersonCreatorCenterFunView x;
    public PersonCreatorCenterDataView y;
    public PersonCreatorCenterDataView z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x28(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = tbPageContext;
        this.i = new PersonCreatorModel(tbPageContext);
        View k = k();
        LinearLayout linearLayout = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0917da);
        this.B = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0917d8);
        this.C = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0917db);
        this.D = linearLayout3;
        linearLayout3.setOnClickListener(this);
        FrameLayout frameLayout = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f09100a);
        this.F = frameLayout;
        frameLayout.setOnClickListener(this);
        this.G = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0917d9);
        this.H = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0917d7);
        this.I = k.findViewById(R.id.obfuscated_res_0x7f09038b);
        this.J = k.findViewById(R.id.obfuscated_res_0x7f09038d);
        this.K = k.findViewById(R.id.obfuscated_res_0x7f09038c);
        this.l = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091802);
        this.m = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091801);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) k.findViewById(R.id.obfuscated_res_0x7f0906f5);
        this.n = tBSpecificationBtn;
        tBSpecificationBtn.setText("投稿");
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) k.findViewById(R.id.obfuscated_res_0x7f09124c);
        this.o = tBSpecificationBtn2;
        tBSpecificationBtn2.setText("立即开通");
        PersonCreatorCenterFunView personCreatorCenterFunView = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f0917fa);
        this.p = personCreatorCenterFunView;
        personCreatorCenterFunView.a(R.drawable.obfuscated_res_0x7f080826, "创作首页");
        PersonCreatorCenterFunView personCreatorCenterFunView2 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f0917fb);
        this.q = personCreatorCenterFunView2;
        personCreatorCenterFunView2.a(R.drawable.obfuscated_res_0x7f08081f, "视频管理");
        PersonCreatorCenterFunView personCreatorCenterFunView3 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f0917f9);
        this.r = personCreatorCenterFunView3;
        personCreatorCenterFunView3.a(R.drawable.obfuscated_res_0x7f080822, "视频数据");
        this.s = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0924eb);
        this.t = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0924ea);
        this.u = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0924e8);
        this.k = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0917ff);
        this.v = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f0917d6);
        PersonCreatorCenterFunView personCreatorCenterFunView4 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f0917f8);
        this.w = personCreatorCenterFunView4;
        personCreatorCenterFunView4.a(R.drawable.obfuscated_res_0x7f0807fe, "大神认证");
        PersonCreatorCenterFunView personCreatorCenterFunView5 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f0917fc);
        this.x = personCreatorCenterFunView5;
        personCreatorCenterFunView5.a(R.drawable.obfuscated_res_0x7f080822, "贴子数据");
        this.y = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0924ed);
        this.z = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0924ec);
        this.A = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0924e9);
        PersonCreatorCenterFunView personCreatorCenterFunView6 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f091800);
        this.L = personCreatorCenterFunView6;
        personCreatorCenterFunView6.a(R.drawable.obfuscated_res_0x7f080853, "全新发布体验");
        PersonCreatorCenterFunView personCreatorCenterFunView7 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f0917fe);
        this.M = personCreatorCenterFunView7;
        personCreatorCenterFunView7.a(R.drawable.obfuscated_res_0x7f080aea, "个人主页升级");
        PersonCreatorCenterFunView personCreatorCenterFunView8 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f0917f7);
        this.N = personCreatorCenterFunView8;
        personCreatorCenterFunView8.a(R.drawable.obfuscated_res_0x7f0808de, "专属流量扶持");
        PersonCreatorCenterFunView personCreatorCenterFunView9 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f0917fd);
        this.O = personCreatorCenterFunView9;
        personCreatorCenterFunView9.a(R.drawable.obfuscated_res_0x7f080769, "百万现金激励");
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && Util.b(str, "7.0.0") == Util.VersionCompare.LESS) {
            LinearLayout linearLayout4 = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091855);
            this.E = linearLayout4;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout4.getLayoutParams();
            layoutParams.bottomMargin = mi.f(this.c, R.dimen.tbds48);
            this.E.setLayoutParams(layoutParams);
        }
        m(tbPageContext, this.a);
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06b2 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.I, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.J, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.K, R.color.CAM_X0204);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.v, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            gs4 d = gs4.d(this.l);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            gs4 d2 = gs4.d(this.k);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            gs4 d3 = gs4.d(this.m);
            d3.n(R.string.J_X06);
            d3.f(R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.w.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.x.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.t.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.t.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.y.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.y.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.z.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.z.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.A.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.A.h, (int) R.color.CAM_X0105);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (R.id.obfuscated_res_0x7f0917da == view2.getId()) {
                ey8 ey8Var = new ey8(j(), (ViewGroup) k(), "person", 3, null);
                ey8Var.H("5");
                ey8Var.w(WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_PERSON);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", "9"));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            } else if (R.id.obfuscated_res_0x7f0917d8 == view2.getId()) {
                t(TbConfig.URL_CREATE_CENTER);
                TiebaStatic.log(new StatisticItem("c14149").param("obj_locate", "2"));
                TiebaStatic.log(new StatisticItem("c14149").param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            } else if (R.id.obfuscated_res_0x7f0917db == view2.getId()) {
                this.i.z(true);
            } else if (R.id.obfuscated_res_0x7f09100a == view2.getId()) {
                WorkPublishGuideActivityConfig workPublishGuideActivityConfig = new WorkPublishGuideActivityConfig(getContext());
                workPublishGuideActivityConfig.setRequestCode(25064);
                workPublishGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishGuideActivityConfig));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: s */
    public void l(h28 h28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h28Var) == null) {
            if (h28Var == null) {
                q(8);
                return;
            }
            CreationData g = h28Var.g();
            if (g == null) {
                this.l.setVisibility(8);
                this.m.setVisibility(0);
            } else {
                this.l.setVisibility(0);
                this.m.setVisibility(8);
                this.s.a(g.view_count.intValue(), "昨日播放", g.view_count_trend.intValue());
                this.t.a(g.valid_play_count.intValue(), "昨日有效播放", g.valid_play_count_trend.intValue());
                this.u.a(g.agree_count.intValue(), "昨日视频点赞", g.agree_count_trend.intValue());
            }
            if (TbSingleton.getInstance().getNewGodData() != null) {
                NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                if (!StringUtils.isNull(newGodData.getFieldName()) && newGodData.getStatus() == 3) {
                    this.x.a(R.drawable.obfuscated_res_0x7f080822, "创作数据");
                    this.w.a(R.drawable.obfuscated_res_0x7f0807fe, "大神考核");
                }
            }
            CreationData e = h28Var.e();
            this.y.a(e.view_count.intValue(), "昨日新增浏览", e.view_count_trend.intValue());
            this.z.a(e.agree_count.intValue(), "昨日新增点赞", e.agree_count_trend.intValue());
            this.A.a(e.comment_count.intValue(), "昨日新增评论", e.comment_trend.intValue());
            m(this.j, this.a);
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }
}
