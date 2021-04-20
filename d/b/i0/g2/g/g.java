package d.b.i0.g2.g;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.g2.e.j;
import d.b.i0.x.b0;
/* loaded from: classes3.dex */
public class g extends d.b.i0.x.b<d.b.i0.g2.e.h> {
    public int m;
    public View n;
    public ImageView o;
    public TextView p;
    public ImageView q;
    public TextView r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public View v;
    public View w;
    public d.b.i0.g2.e.h x;
    public j y;
    public UserData z;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
        View m = m();
        this.n = m.findViewById(R.id.item_content);
        this.v = m.findViewById(R.id.function_item_bottom_divider);
        this.w = m.findViewById(R.id.function_item_bottom_divider_line);
        this.o = (ImageView) m.findViewById(R.id.function_icon);
        this.s = (ImageView) m.findViewById(R.id.function_right_arrow);
        this.p = (TextView) m.findViewById(R.id.function_title);
        this.q = (ImageView) m.findViewById(R.id.function_red_tip);
        this.r = (TextView) m.findViewById(R.id.function_desc);
        this.t = (TextView) m.findViewById(R.id.right_text);
        this.u = (TextView) m.findViewById(R.id.function_title_mark);
        this.t.setOnClickListener(this);
        this.n.setOnClickListener(this);
    }

    public final void A() {
        if (this.x.f56254f > 0) {
            this.o.setVisibility(0);
            d.b.i0.g2.e.h hVar = this.x;
            if (hVar.f56255g) {
                if (hVar.f56256h) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, this.x.f56254f, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                } else {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.o, this.x.f56254f, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                }
            }
            SkinManager.setImageResource(this.o, hVar.f56254f);
            return;
        }
        this.o.setVisibility(8);
    }

    public final void B(d.b.i0.g2.e.h hVar) {
        if (hVar.j) {
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(8);
        }
    }

    public final void E(j jVar) {
        if (jVar != null) {
            if (jVar.f56259a) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            if (!StringUtils.isNull(jVar.f56260b)) {
                this.r.setVisibility(0);
                this.r.setText(jVar.f56260b);
            } else {
                this.r.setVisibility(8);
            }
            if (jVar.f56266h) {
                this.u.setVisibility(0);
            } else {
                this.u.setVisibility(8);
            }
            if (!TextUtils.isEmpty(jVar.f56261c)) {
                this.t.setVisibility(0);
                this.t.setText(jVar.f56261c);
                TextView textView = this.t;
                Drawable drawable = jVar.f56263e;
                Drawable drawable2 = jVar.f56264f;
                Drawable drawable3 = jVar.f56265g;
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable3);
                return;
            }
            this.t.setVisibility(8);
            return;
        }
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.person_center_function_item_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.m != i) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(this.n, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setImageResource(this.q, R.drawable.person_center_red_tip_shape);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0105);
            this.m = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b0<T> b0Var;
        if (view == null) {
            return;
        }
        if (view == this.n) {
            d.b.i0.g2.e.h hVar = this.x;
            if (hVar.f56253e == 36 && "游戏".equals(hVar.i) && (b0Var = this.i) != 0) {
                b0Var.a(view, this.x);
                return;
            } else {
                u();
                return;
            }
        }
        v(view);
    }

    public final void u() {
        d.b.i0.g2.e.h hVar = this.x;
        if (hVar == null) {
            return;
        }
        switch (hVar.f56253e) {
            case 10:
                d.b.i0.t2.a.v().L(1, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 13));
                if (this.z == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.f63756f.getPageActivity(), this.z.getUserId(), this.z.getUserName(), this.z.getName_show(), this.z.getSex(), "iowner_gift")));
                return;
            case 11:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 16));
                if (StringUtils.isNull(this.x.k)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f63756f, new String[]{this.x.k});
                return;
            case 12:
                d.b.i0.t2.a.v().L(7, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 12));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(this.f63756f.getPageActivity())));
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
                d.b.i0.t2.a.v().L(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.f63756f.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.f63756f.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 15));
                UrlManager.getInstance().dealOneLink(this.f63756f, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 11));
                if (this.z == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.f63756f.getPageActivity(), this.z.getSex(), 0, 1)));
                return;
            case 25:
                if (this.z == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 18));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.f63756f.getPageActivity(), this.z.getUserId(), this.z.getUserName(), this.z.getPortrait(), this.z.getSex(), true)));
                return;
            case 30:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 17));
                if (d.b.h0.p0.b.b(this.f63756f)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(l().getPageActivity()).createNormalConfig("hottopic", "all")));
                return;
            case 31:
                d.b.i0.t2.a.v().L(10, false, true);
                d.b.h0.r.d0.b.j().t("key_feedback_tip_show", false);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 19));
                d.b.h0.l.a.l(this.f63756f.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.f63756f.getPageActivity(), this.x.n)));
                return;
            case 36:
                TiebaStatic.log(new StatisticItem("c12524").param("obj_locate", this.x.o));
                w(this.x.k);
                return;
            case 37:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 24));
                d.b.h0.r.d0.b.j().t("key_has_borrow_cash_clicked", true);
                j jVar = this.x.m;
                if (jVar != null) {
                    jVar.f56259a = false;
                }
                this.q.setVisibility(8);
                String p = d.b.h0.r.d0.b.j().p("cash_pay", "");
                if (StringUtils.isNull(p)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001447, p));
                return;
            case 38:
                d.b.h0.s.c.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.f()) {
                    String c2 = activityPrizeData.c();
                    if (StringUtils.isNull(c2)) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c12598"));
                    d.b.i0.t2.a.v().L(9, false, true);
                    UrlManager.getInstance().dealOneLink(l(), new String[]{c2}, true);
                    return;
                }
                return;
            case 39:
                d.b.h0.l.a.u(true, this.f63756f.getPageActivity(), this.f63756f.getResources().getString(R.string.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 41:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 25));
                d.b.h0.r.d0.b.j().t("key_baidu_financial_has_clicked", true);
                j jVar2 = this.x.m;
                if (jVar2 != null) {
                    jVar2.f56259a = false;
                }
                this.q.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                return;
            case 43:
                x();
                d.b.h0.l.a.l(this.f63756f.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                return;
            case 44:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 26));
                if (!TextUtils.isEmpty(this.x.k)) {
                    UrlManager.getInstance().dealOneLink(this.f63756f, new String[]{this.x.k});
                }
                if (!k.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) && !"f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", b().getString(R.string.third_lite_game_center)).param("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).param("obj_source", "smallgame_center").param("obj_param1", 0));
                    return;
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", b().getString(R.string.baidu_lite_game_center)).param("obj_id", "11811875").param("obj_source", "smallgame_center").param("obj_param1", 0));
                    return;
                }
            case 45:
                if (!TextUtils.isEmpty(hVar.k)) {
                    d.b.h0.l.a.l(this.f63757g, this.x.k);
                }
                StatisticItem.make("c13548").eventStat();
                return;
            case 46:
                UrlManager.getInstance().dealOneLink(this.f63756f, new String[]{this.x.k}, true);
                return;
        }
    }

    public final void v(View view) {
        j jVar;
        d.b.i0.g2.e.h hVar = this.x;
        if (hVar != null && view == this.t) {
            int i = hVar.f56253e;
            if (i == 10) {
                BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.f63756f.getPageActivity(), 0L);
                buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
            } else if (i != 45 || (jVar = this.y) == null || TextUtils.isEmpty(jVar.f56262d)) {
            } else {
                UrlManager.getInstance().dealOneLink(this.f63756f, new String[]{this.y.f56262d});
            }
        }
    }

    public final void w(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            z(str);
        } else if (str.startsWith("nohead:url")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, ""));
            sb.append(str.contains("?") ? "&" : "?");
            sb.append("jump=open_full_screen_web_page&nonavigationbar=1");
            UrlManager.getInstance().dealOneLink(this.f63756f, new String[]{sb.toString()});
        } else {
            UrlManager.getInstance().dealOneLink(this.f63756f, new String[]{str});
        }
    }

    public final void x() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 5);
        TiebaStatic.log(statisticItem);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: y */
    public void n(d.b.i0.g2.e.h hVar) {
        if (hVar == null) {
            return;
        }
        this.x = hVar;
        this.z = hVar.l;
        this.y = hVar.m;
        this.p.setText(hVar.i);
        A();
        B(hVar);
        E(this.y);
        o(this.f63756f, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void z(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                l.K(this.f63756f.getPageActivity(), R.string.cosume_record_plugin_not_install_tip);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f63756f, new String[]{str.substring(6)});
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
        } else {
            d.b.h0.l.a.s(this.f63756f.getPageActivity(), true, str);
        }
    }
}
