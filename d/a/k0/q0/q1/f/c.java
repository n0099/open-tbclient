package d.a.k0.q0.q1.f;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import d.a.c.a.d;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.j0.d0.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<ForumRulesShowActivity> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ForumRulesShowActivity f59326e;

    /* renamed from: f  reason: collision with root package name */
    public int f59327f;

    /* renamed from: g  reason: collision with root package name */
    public String f59328g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f59329h;

    /* renamed from: i  reason: collision with root package name */
    public NavigationBar f59330i;
    public View j;
    public ImageView k;
    public View l;
    public ImageView m;
    public d.a.k0.q0.q1.a.a n;
    public d.a.k0.q0.q1.d.b o;
    public d.a.k0.q0.q1.d.a p;
    public BdTypeRecyclerView q;
    public List<n> r;
    public View s;
    public h t;
    public int u;
    public int v;
    public d.a.k0.q0.q1.c.b w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f59331e;

        public a(ShareItem shareItem) {
            this.f59331e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f59331e.t);
            l.M(c.this.f59326e, c.this.f59326e.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    public c(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        this.f59327f = 3;
        this.r = new ArrayList();
        this.u = 0;
        this.v = 0;
        this.f59326e = forumRulesShowActivity;
        this.f59328g = str;
        forumRulesShowActivity.setContentView(R.layout.activity_forum_rules_show);
        this.o = new d.a.k0.q0.q1.d.b(forumRulesShowActivity);
        this.p = new d.a.k0.q0.q1.d.a(forumRulesShowActivity);
        this.u = l.g(TbadkCoreApplication.getInst(), R.dimen.ds88);
        this.v = l.g(TbadkCoreApplication.getInst(), R.dimen.ds14);
        r(forumRulesShowActivity);
    }

    public void e(d.a.k0.q0.q1.c.b bVar) {
        this.w = bVar;
        this.r.add(bVar);
    }

    public void f(d.a.k0.q0.q1.c.a aVar) {
        this.r.add(aVar);
    }

    public void g(List<d.a.k0.q0.q1.c.c> list) {
        this.r.addAll(list);
    }

    public void h(String str) {
        y(str);
    }

    public void j() {
        this.f59326e = null;
    }

    public View k() {
        return this.s;
    }

    public ViewGroup l() {
        return this.f59329h;
    }

    public void m() {
        BdTypeRecyclerView bdTypeRecyclerView = this.q;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(8);
        }
    }

    public void n() {
        View view = this.s;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void o() {
        d.a.k0.q0.q1.d.b bVar = this.o;
        if (bVar != null) {
            bVar.d(this.q);
        }
    }

    public void onChangeSkinType(int i2) {
        this.f59330i.onChangeSkinType(this.f59326e.getPageContext(), i2);
        if (this.f59327f == i2) {
            this.f59330i.getCenterText().setTextSize(R.dimen.L_X06);
            TextView centerText = this.f59330i.getCenterText();
            int i3 = R.color.CAM_X0611;
            SkinManager.setNavbarTitleColor(centerText, i3, i3);
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.m, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.o.c(i2);
            this.p.c(i2);
            this.n.b(i2);
            this.f59327f = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.f59326e != null) {
            if (view.getId() == R.id.root_pb_more) {
                int i2 = -1;
                d.a.k0.q0.q1.c.b bVar = this.w;
                if (bVar == null || bVar.i() == null) {
                    str = "";
                } else {
                    i2 = this.w.i().forum_id.intValue();
                    str = this.w.i().forum_name;
                }
                d.a.k0.q0.q1.c.b bVar2 = this.w;
                String p = bVar2 != null ? bVar2.p() : "";
                String str2 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i2;
                ShareItem shareItem = new ShareItem();
                shareItem.r = p;
                shareItem.s = String.format(this.f59326e.getResources().getString(R.string.forum_rules_share_text), str);
                shareItem.t = str2;
                shareItem.b0 = false;
                d.a.k0.q0.q1.c.b bVar3 = this.w;
                if (bVar3 != null && !StringUtils.isNull(bVar3.i().avatar)) {
                    shareItem.v = Uri.parse(this.w.i().avatar);
                    shareItem.g();
                }
                shareItem.P = p;
                shareItem.Q = str2;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f59326e, shareItem, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new a(shareItem));
                this.f59326e.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            } else if (view.getId() == R.id.navigationBarGoBack) {
                this.f59326e.finish();
            } else if (this.t == null || view.getId() != this.t.c().getId()) {
            } else {
                this.f59326e.requestNet();
            }
        }
    }

    public void p() {
        d.a.k0.q0.q1.d.a aVar = this.p;
        if (aVar != null) {
            aVar.d(this.q);
        }
    }

    public final void q(NavigationBar navigationBar) {
        View addSystemImageButton = this.f59330i.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.j = addSystemImageButton;
        this.k = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.f59330i.setCenterTextTitle(this.f59326e.getResources().getString(R.string.forum_rules_local));
        View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
        this.l = addCustomView;
        this.m = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
        int i2 = this.u;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.rightMargin = this.v;
        this.l.setLayoutParams(layoutParams);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        v();
    }

    public final void r(ForumRulesShowActivity forumRulesShowActivity) {
        this.f59329h = (ViewGroup) forumRulesShowActivity.findViewById(R.id.forum_rule_rootview);
        NavigationBar navigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.navigationbar);
        this.f59330i = navigationBar;
        q(navigationBar);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.forum_rules_list_info);
        this.q = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
        this.n = new d.a.k0.q0.q1.a.a(forumRulesShowActivity, this.q);
        this.s = forumRulesShowActivity.findViewById(R.id.forum_rules_net_refresh_layout);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void s() {
        p();
        o();
    }

    public void setFrom(String str) {
        this.f59328g = str;
        d.a.k0.q0.q1.a.a aVar = this.n;
        if (aVar != null) {
            aVar.d(str);
        }
    }

    public void t() {
        d.a.k0.q0.q1.a.a aVar = this.n;
        if (aVar != null) {
            aVar.c(this.r);
        }
    }

    public void u(h hVar) {
        this.t = hVar;
        hVar.c().setOnClickListener(this);
    }

    public final void v() {
        HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
        if (((baseSwitchs == null || !baseSwitchs.containsKey("is_disable_forumrule_share")) ? -1 : baseSwitchs.get("is_disable_forumrule_share").intValue()) == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f59328g)) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView = this.q;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
    }

    public void x() {
        View view = this.s;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void y(String str) {
        if (this.o == null || StringUtils.isNull(str)) {
            return;
        }
        this.o.a(this.q);
        this.o.e(str);
    }

    public void z(String str) {
        d.a.k0.q0.q1.d.a aVar = this.p;
        if (aVar != null) {
            aVar.a(this.q);
            this.p.e(str);
        }
    }
}
