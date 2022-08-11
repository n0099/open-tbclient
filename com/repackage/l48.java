package com.repackage;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes6.dex */
public class l48 extends bz5<v38> {
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
    public l48(TbPageContext<?> tbPageContext) {
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
        View h = h();
        LinearLayout linearLayout = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f0918d6);
        this.B = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f0918d1);
        this.C = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f0918d7);
        this.D = linearLayout3;
        linearLayout3.setOnClickListener(this);
        FrameLayout frameLayout = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f09101a);
        this.F = frameLayout;
        frameLayout.setOnClickListener(this);
        this.G = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0918d5);
        this.H = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0918d0);
        this.I = h.findViewById(R.id.obfuscated_res_0x7f0903a0);
        this.J = h.findViewById(R.id.obfuscated_res_0x7f0903a2);
        this.K = h.findViewById(R.id.obfuscated_res_0x7f0903a1);
        this.l = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f0918fe);
        this.m = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f0918fd);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) h.findViewById(R.id.obfuscated_res_0x7f0906e5);
        this.n = tBSpecificationBtn;
        tBSpecificationBtn.setText("投稿");
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) h.findViewById(R.id.obfuscated_res_0x7f0912da);
        this.o = tBSpecificationBtn2;
        tBSpecificationBtn2.setText("立即开通");
        PersonCreatorCenterFunView personCreatorCenterFunView = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f0918f6);
        this.p = personCreatorCenterFunView;
        personCreatorCenterFunView.a(R.drawable.obfuscated_res_0x7f08082d, "创作首页");
        PersonCreatorCenterFunView personCreatorCenterFunView2 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f0918f7);
        this.q = personCreatorCenterFunView2;
        personCreatorCenterFunView2.a(R.drawable.obfuscated_res_0x7f080826, "视频管理");
        PersonCreatorCenterFunView personCreatorCenterFunView3 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f0918f5);
        this.r = personCreatorCenterFunView3;
        personCreatorCenterFunView3.a(R.drawable.obfuscated_res_0x7f080829, "视频数据");
        this.s = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f092675);
        this.t = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f092674);
        this.u = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f092672);
        this.k = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f0918fb);
        this.v = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f0918cf);
        PersonCreatorCenterFunView personCreatorCenterFunView4 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f0918f4);
        this.w = personCreatorCenterFunView4;
        personCreatorCenterFunView4.a(R.drawable.obfuscated_res_0x7f0807fd, "大神认证");
        PersonCreatorCenterFunView personCreatorCenterFunView5 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f0918f8);
        this.x = personCreatorCenterFunView5;
        personCreatorCenterFunView5.a(R.drawable.obfuscated_res_0x7f080829, "贴子数据");
        this.y = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f092677);
        this.z = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f092676);
        this.A = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f092673);
        PersonCreatorCenterFunView personCreatorCenterFunView6 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f0918fc);
        this.L = personCreatorCenterFunView6;
        personCreatorCenterFunView6.a(R.drawable.obfuscated_res_0x7f080860, "全新发布体验");
        PersonCreatorCenterFunView personCreatorCenterFunView7 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f0918fa);
        this.M = personCreatorCenterFunView7;
        personCreatorCenterFunView7.a(R.drawable.obfuscated_res_0x7f080b11, "个人主页升级");
        PersonCreatorCenterFunView personCreatorCenterFunView8 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f0918f3);
        this.N = personCreatorCenterFunView8;
        personCreatorCenterFunView8.a(R.drawable.obfuscated_res_0x7f0808f1, "专属流量扶持");
        PersonCreatorCenterFunView personCreatorCenterFunView9 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f0918f9);
        this.O = personCreatorCenterFunView9;
        personCreatorCenterFunView9.a(R.drawable.obfuscated_res_0x7f08076f, "百万现金激励");
        if (Build.VERSION.SDK_INT < 24) {
            LinearLayout linearLayout4 = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f091955);
            this.E = linearLayout4;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout4.getLayoutParams();
            layoutParams.bottomMargin = qi.f(this.c, R.dimen.tbds37);
            this.E.setLayoutParams(layoutParams);
        }
        j(tbPageContext, this.a);
    }

    @Override // com.repackage.bz5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06f2 : invokeV.intValue;
    }

    @Override // com.repackage.bz5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.I, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.J, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.K, R.color.CAM_X0204);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.v, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            ms4 d = ms4.d(this.l);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            ms4 d2 = ms4.d(this.k);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            ms4 d3 = ms4.d(this.m);
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
            if (R.id.obfuscated_res_0x7f0918d6 == view2.getId()) {
                fz8 fz8Var = new fz8(g(), (ViewGroup) h(), "person", 3, null);
                fz8Var.E("5");
                fz8Var.v(WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_PERSON);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", "9"));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            } else if (R.id.obfuscated_res_0x7f0918d1 == view2.getId()) {
                s(TbConfig.URL_CREATE_CENTER);
                TiebaStatic.log(new StatisticItem("c14149").param("obj_locate", "2"));
                TiebaStatic.log(new StatisticItem("c14149").param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            } else if (R.id.obfuscated_res_0x7f0918d7 == view2.getId()) {
                this.i.A(true);
            } else if (R.id.obfuscated_res_0x7f09101a == view2.getId()) {
                WorkPublishGuideActivityConfig workPublishGuideActivityConfig = new WorkPublishGuideActivityConfig(getContext());
                workPublishGuideActivityConfig.setRequestCode(25064);
                workPublishGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishGuideActivityConfig));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bz5
    /* renamed from: r */
    public void i(v38 v38Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v38Var) == null) {
            if (v38Var == null) {
                q(8);
                return;
            }
            CreationData f = v38Var.f();
            if (f == null) {
                this.l.setVisibility(8);
                this.m.setVisibility(0);
            } else {
                this.l.setVisibility(0);
                this.m.setVisibility(8);
                this.s.a(f.view_count.intValue(), "昨日播放", f.view_count_trend.intValue());
                this.t.a(f.valid_play_count.intValue(), "昨日有效播放", f.valid_play_count_trend.intValue());
                this.u.a(f.agree_count.intValue(), "昨日视频点赞", f.agree_count_trend.intValue());
            }
            if (TbSingleton.getInstance().getNewGodData() != null) {
                NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                if (!StringUtils.isNull(newGodData.getFieldName()) && newGodData.getStatus() == 3) {
                    this.x.a(R.drawable.obfuscated_res_0x7f080829, "创作数据");
                    this.w.a(R.drawable.obfuscated_res_0x7f0807fd, "大神考核");
                }
            }
            CreationData c = v38Var.c();
            this.y.a(c.view_count.intValue(), "昨日新增浏览", c.view_count_trend.intValue());
            this.z.a(c.agree_count.intValue(), "昨日新增点赞", c.agree_count_trend.intValue());
            this.A.a(c.comment_count.intValue(), "昨日新增评论", c.comment_trend.intValue());
            j(this.j, this.a);
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }
}
