package com.repackage;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
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
/* loaded from: classes7.dex */
public class z28 extends tw5<l28> {
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
    public View r;
    public View s;
    public l28 t;
    public n28 u;
    public UserData v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z28(TbPageContext<?> tbPageContext) {
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
        View k = k();
        this.j = k.findViewById(R.id.obfuscated_res_0x7f090f5d);
        this.r = k.findViewById(R.id.obfuscated_res_0x7f090c38);
        this.s = k.findViewById(R.id.obfuscated_res_0x7f090c39);
        this.k = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f090c37);
        this.o = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f090c3c);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090c3d);
        this.m = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f090c3b);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090c35);
        this.p = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091aa8);
        this.q = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090c3e);
        this.p.setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    public final void A(n28 n28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, n28Var) == null) {
            if (n28Var != null) {
                if (n28Var.a) {
                    this.m.setVisibility(0);
                } else {
                    this.m.setVisibility(8);
                }
                if (!StringUtils.isNull(n28Var.b)) {
                    this.n.setVisibility(0);
                    this.n.setText(n28Var.b);
                } else {
                    this.n.setVisibility(8);
                }
                if (n28Var.h) {
                    this.q.setVisibility(0);
                } else {
                    this.q.setVisibility(8);
                }
                if (!TextUtils.isEmpty(n28Var.c)) {
                    this.p.setVisibility(0);
                    this.p.setText(n28Var.c);
                    TextView textView = this.p;
                    Drawable drawable = n28Var.e;
                    Drawable drawable2 = n28Var.f;
                    Drawable drawable3 = n28Var.g;
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

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d06af : invokeV.intValue;
    }

    @Override // com.repackage.tw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) || this.i == i) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        TBSelector.setViewBackgroundColorWithPressedState(this.j, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setImageResource(this.m, R.drawable.person_center_red_tip_shape);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
        this.i = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        tx5<T> tx5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || view2 == null) {
            return;
        }
        if (view2 == this.j) {
            l28 l28Var = this.t;
            if (l28Var.a == 36 && "游戏".equals(l28Var.e) && (tx5Var = this.e) != 0) {
                tx5Var.a(view2, this.t);
                return;
            } else {
                s();
                return;
            }
        }
        t(view2);
    }

    public final void s() {
        l28 l28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (l28Var = this.t) == null) {
            return;
        }
        switch (l28Var.a) {
            case 10:
                PersonRedTipManager.getInstance().updateRedTipState(1, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 13));
                if (this.v == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.b.getPageActivity(), this.v.getUserId(), this.v.getUserName(), this.v.getName_show(), this.v.getSex(), "iowner_gift")));
                return;
            case 11:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 16));
                if (StringUtils.isNull(this.t.g)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.t.g});
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
                if (this.v == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.b.getPageActivity(), this.v.getSex(), 0, 1)));
                return;
            case 25:
                if (this.v == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 18));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.b.getPageActivity(), this.v.getUserId(), this.v.getUserName(), this.v.getPortrait(), this.v.getSex(), true)));
                return;
            case 30:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 17));
                if (hc5.b(this.b)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(j().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all")));
                return;
            case 31:
                PersonRedTipManager.getInstance().updateRedTipState(10, false, true);
                vt4.k().u("key_feedback_tip_show", false);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 19));
                StringBuilder sb = new StringBuilder();
                sb.append("http://tieba.baidu.com/mo/q/hybrid-main-service/uegServiceCenter?is_yy_user=");
                sb.append(TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
                ul4.m(this.b.getPageActivity(), sb.toString());
                return;
            case 33:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.b.getPageActivity(), this.t.j)));
                return;
            case 36:
                TiebaStatic.log(new StatisticItem("c12524").param("obj_locate", this.t.k));
                u(this.t.g);
                return;
            case 37:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 24));
                vt4.k().u("key_has_borrow_cash_clicked", true);
                n28 n28Var = this.t.i;
                if (n28Var != null) {
                    n28Var.a = false;
                }
                this.m.setVisibility(8);
                String q = vt4.k().q("cash_pay", "");
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
                    UrlManager.getInstance().dealOneLink(j(), new String[]{h5Url}, true);
                    return;
                }
                return;
            case 39:
                ul4.x(true, this.b.getPageActivity(), this.b.getResources().getString(R.string.obfuscated_res_0x7f0f02c6), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 41:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 25));
                vt4.k().u("key_baidu_financial_has_clicked", true);
                n28 n28Var2 = this.t.i;
                if (n28Var2 != null) {
                    n28Var2.a = false;
                }
                this.m.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                return;
            case 43:
                v();
                ul4.m(this.b.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                return;
            case 44:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 26));
                if (!TextUtils.isEmpty(this.t.g)) {
                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.t.g});
                }
                if (!ni.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) && !"f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", getContext().getString(R.string.obfuscated_res_0x7f0f1394)).param("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).param("obj_source", "smallgame_center").param("obj_param1", 0));
                    return;
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", getContext().getString(R.string.obfuscated_res_0x7f0f02c4)).param("obj_id", "11811875").param("obj_source", "smallgame_center").param("obj_param1", 0));
                    return;
                }
            case 45:
                if (!TextUtils.isEmpty(l28Var.g)) {
                    ul4.m(this.c, this.t.g);
                }
                StatisticItem.make("c13548").eventStat();
                return;
            case 46:
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.t.g}, true);
                return;
        }
    }

    public final void t(View view2) {
        l28 l28Var;
        n28 n28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && (l28Var = this.t) != null && view2 == this.p) {
            int i = l28Var.a;
            if (i == 10) {
                CurrencyJumpHelper.personGotoBuyBean(this.b.getPageActivity());
            } else if (i != 45 || (n28Var = this.u) == null || TextUtils.isEmpty(n28Var.d)) {
            } else {
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.u.d});
            }
        }
    }

    public final void u(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            x(str);
        } else if (str.startsWith("nohead:url")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, ""));
            sb.append(str.contains("?") ? "&" : "?");
            sb.append("jump=open_full_screen_web_page&nonavigationbar=1");
            UrlManager.getInstance().dealOneLink(this.b, new String[]{sb.toString()});
        } else {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str});
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 5);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: w */
    public void l(l28 l28Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, l28Var) == null) || l28Var == null) {
            return;
        }
        this.t = l28Var;
        this.v = l28Var.h;
        this.u = l28Var.i;
        this.l.setText(l28Var.e);
        y();
        z(l28Var);
        A(this.u);
        m(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                oi.M(this.b.getPageActivity(), R.string.obfuscated_res_0x7f0f044f);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str.substring(6)});
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
        } else {
            ul4.v(this.b.getPageActivity(), true, str);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.t.b > 0) {
                this.k.setVisibility(0);
                l28 l28Var = this.t;
                if (l28Var.c) {
                    if (l28Var.d) {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, this.t.b, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    } else {
                        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, this.t.b, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    }
                }
                SkinManager.setImageResource(this.k, l28Var.b);
                return;
            }
            this.k.setVisibility(8);
        }
    }

    public final void z(l28 l28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, l28Var) == null) {
            if (l28Var.f) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
        }
    }
}
