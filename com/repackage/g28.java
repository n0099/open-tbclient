package com.repackage;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.data.ActivityPrizeData;
import com.baidu.tieba.R;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g28 extends jx5<r18> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public View j;
    public ImageView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public r18 s;
    public t18 t;
    public UserData u;
    public LinearLayout v;
    public LinearLayout w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g28(TbPageContext<?> tbPageContext) {
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
        this.i = 3;
        View h = h();
        this.v = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f091801);
        this.j = h.findViewById(R.id.obfuscated_res_0x7f090f2f);
        this.k = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090c01);
        this.o = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090c04);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090c05);
        this.m = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090c03);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090bff);
        this.p = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091b3c);
        this.q = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090c06);
        this.r = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090557);
        this.w = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f090558);
        this.p.setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    @Override // com.repackage.jx5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06b0 : invokeV.intValue;
    }

    @Override // com.repackage.jx5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.i == i) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        TBSelector.setViewBackgroundColorWithPressedState(this.j, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setImageResource(this.m, R.drawable.person_center_red_tip_shape);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
        ur4 d = ur4.d(this.w);
        d.n(R.string.J_X06);
        d.f(R.color.CAM_X0205);
        ur4 d2 = ur4.d(this.v);
        d2.n(R.string.J_X06);
        d2.f(R.color.CAM_X0205);
        if (this.s.e.equals("更多")) {
            ur4 d3 = ur4.d(this.j);
            d3.m(2);
            d3.n(R.string.J_X06);
            d3.f(R.color.CAM_X0205);
        }
        this.i = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        jy5<T> jy5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || view2 == null) {
            return;
        }
        if (view2 == this.j) {
            r18 r18Var = this.s;
            if (r18Var.a == 36 && "游戏".equals(r18Var.e) && (jy5Var = this.e) != 0) {
                jy5Var.a(view2, this.s);
                return;
            } else {
                r();
                return;
            }
        }
        s(view2);
    }

    public final void r() {
        r18 r18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (r18Var = this.s) == null) {
            return;
        }
        switch (r18Var.a) {
            case 10:
                PersonRedTipManager.getInstance().updateRedTipState(1, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 13));
                if (this.u == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.b.getPageActivity(), this.u.getUserId(), this.u.getUserName(), this.u.getName_show(), this.u.getSex(), "iowner_gift")));
                return;
            case 11:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 16));
                if (StringUtils.isNull(this.s.g)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g});
                return;
            case 12:
                PersonRedTipManager.getInstance().updateRedTipState(7, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 12));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(this.b.getPageActivity())));
                return;
            case 13:
            case 14:
            case 15:
            case 19:
            case 20:
            case 21:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 32:
            case 34:
            case 35:
            case 40:
            case 42:
            default:
                return;
            case 16:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 9));
                PersonRedTipManager.getInstance().updateRedTipState(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.b.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.b.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 15));
                UrlManager.getInstance().dealOneLink(this.b, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 11));
                if (this.u == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.b.getPageActivity(), this.u.getSex(), 0, 1)));
                return;
            case 25:
                if (this.u == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 18));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.b.getPageActivity(), this.u.getUserId(), this.u.getUserName(), this.u.getPortrait(), this.u.getSex(), true)));
                return;
            case 30:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 17));
                if (id5.b(this.b)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(g().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all")));
                return;
            case 31:
                PersonRedTipManager.getInstance().updateRedTipState(10, false, true);
                xt4.k().u("key_feedback_tip_show", false);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 19));
                StringBuilder sb = new StringBuilder();
                sb.append("https://tieba.baidu.com/mo/q/hybrid-main-service/uegServiceCenter?is_yy_user=");
                sb.append(TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
                rl4.o(this.b.getPageActivity(), sb.toString());
                return;
            case 33:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.b.getPageActivity(), this.s.j)));
                return;
            case 36:
                TiebaStatic.log(new StatisticItem("c12524").param("obj_locate", this.s.k));
                t(this.s.g);
                return;
            case 37:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 24));
                xt4.k().u("key_has_borrow_cash_clicked", true);
                t18 t18Var = this.s.i;
                if (t18Var != null) {
                    t18Var.a = false;
                }
                this.m.setVisibility(8);
                String q = xt4.k().q("cash_pay", "");
                if (StringUtils.isNull(q)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001447, q));
                return;
            case 38:
                ActivityPrizeData activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.isPersonItemSwitch()) {
                    String h5Url = activityPrizeData.getH5Url();
                    if (StringUtils.isNull(h5Url)) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c12598"));
                    PersonRedTipManager.getInstance().updateRedTipState(9, false, true);
                    UrlManager.getInstance().dealOneLink(g(), new String[]{h5Url}, true);
                    return;
                }
                return;
            case 39:
                rl4.z(true, this.b.getPageActivity(), this.b.getResources().getString(R.string.obfuscated_res_0x7f0f02d1), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 41:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 25));
                xt4.k().u("key_baidu_financial_has_clicked", true);
                t18 t18Var2 = this.s.i;
                if (t18Var2 != null) {
                    t18Var2.a = false;
                }
                this.m.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                return;
            case 43:
                u();
                rl4.o(this.b.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                return;
            case 44:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 26));
                if (!TextUtils.isEmpty(this.s.g)) {
                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g});
                }
                if (!oi.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) && !"f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", getContext().getString(R.string.obfuscated_res_0x7f0f13d0)).param("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).param("obj_source", "smallgame_center").param("obj_param1", 0));
                    return;
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", getContext().getString(R.string.obfuscated_res_0x7f0f02cf)).param("obj_id", "11811875").param("obj_source", "smallgame_center").param("obj_param1", 0));
                    return;
                }
            case 45:
                if (!TextUtils.isEmpty(r18Var.g)) {
                    rl4.o(this.c, this.s.g);
                }
                StatisticItem.make("c13548").eventStat();
                return;
            case 46:
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g}, true);
                return;
            case 47:
                if (TextUtils.isEmpty(r18Var.g)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g});
                return;
            case 48:
                if (TextUtils.isEmpty(r18Var.g)) {
                    return;
                }
                rl4.o(this.c, this.s.g);
                return;
            case 49:
                if (TextUtils.isEmpty(r18Var.g)) {
                    return;
                }
                rl4.o(this.c, this.s.g);
                return;
        }
    }

    public final void s(View view2) {
        r18 r18Var;
        t18 t18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && (r18Var = this.s) != null && view2 == this.p) {
            int i = r18Var.a;
            if (i == 10) {
                CurrencyJumpHelper.personGotoBuyBean(this.b.getPageActivity());
            } else if (i != 45 || (t18Var = this.t) == null || TextUtils.isEmpty(t18Var.d)) {
            } else {
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.t.d});
            }
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            w(str);
        } else if (str.startsWith("nohead:url")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.replaceFirst("nohead:url=", ""));
            sb.append(str.contains("?") ? "&" : "?");
            sb.append("jump=open_full_screen_web_page&nonavigationbar=1");
            UrlManager.getInstance().dealOneLink(this.b, new String[]{sb.toString()});
        } else {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str});
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 5);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jx5
    /* renamed from: v */
    public void i(r18 r18Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, r18Var) == null) || r18Var == null) {
            return;
        }
        this.s = r18Var;
        this.u = r18Var.h;
        this.t = r18Var.i;
        this.l.setText(r18Var.e);
        if (this.s.e.equals("服务中心")) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(8);
        }
        x();
        y(this.t);
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                pi.N(this.b.getPageActivity(), R.string.obfuscated_res_0x7f0f0456);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str.substring(6)});
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
        } else {
            rl4.x(this.b.getPageActivity(), true, str);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.s.b > 0) {
                this.k.setVisibility(0);
                r18 r18Var = this.s;
                if (r18Var.c) {
                    if (r18Var.d) {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, this.s.b, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    } else {
                        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, this.s.b, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    }
                }
                SkinManager.setImageResource(this.k, r18Var.b);
                return;
            }
            this.k.setVisibility(8);
        }
    }

    public final void y(t18 t18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t18Var) == null) {
            if (t18Var != null) {
                if (t18Var.a) {
                    this.m.setVisibility(0);
                } else {
                    this.m.setVisibility(8);
                }
                if (!StringUtils.isNull(t18Var.b)) {
                    this.n.setVisibility(0);
                    this.n.setText(t18Var.b);
                } else {
                    this.n.setVisibility(8);
                }
                if (t18Var.h) {
                    this.q.setVisibility(0);
                } else {
                    this.q.setVisibility(8);
                }
                if (!TextUtils.isEmpty(t18Var.c)) {
                    this.p.setVisibility(0);
                    this.p.setText(t18Var.c);
                    TextView textView = this.p;
                    Drawable drawable = t18Var.e;
                    Drawable drawable2 = t18Var.f;
                    Drawable drawable3 = t18Var.g;
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable3);
                    return;
                }
                this.p.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        }
    }
}
