package d.b.j0.q0.q1.f;

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
import d.b.c.a.d;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i0.d0.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<ForumRulesShowActivity> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ForumRulesShowActivity f60487e;

    /* renamed from: f  reason: collision with root package name */
    public int f60488f;

    /* renamed from: g  reason: collision with root package name */
    public String f60489g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f60490h;
    public NavigationBar i;
    public View j;
    public ImageView k;
    public View l;
    public ImageView m;
    public d.b.j0.q0.q1.a.a n;
    public d.b.j0.q0.q1.d.b o;
    public d.b.j0.q0.q1.d.a p;
    public BdTypeRecyclerView q;
    public List<n> r;
    public View s;
    public h t;
    public int u;
    public int v;
    public d.b.j0.q0.q1.c.b w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f60491e;

        public a(ShareItem shareItem) {
            this.f60491e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.c.e.p.a.a(this.f60491e.t);
            l.L(c.this.f60487e, c.this.f60487e.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    public c(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        this.f60488f = 3;
        this.r = new ArrayList();
        this.u = 0;
        this.v = 0;
        this.f60487e = forumRulesShowActivity;
        this.f60489g = str;
        forumRulesShowActivity.setContentView(R.layout.activity_forum_rules_show);
        this.o = new d.b.j0.q0.q1.d.b(forumRulesShowActivity);
        this.p = new d.b.j0.q0.q1.d.a(forumRulesShowActivity);
        this.u = l.g(TbadkCoreApplication.getInst(), R.dimen.ds88);
        this.v = l.g(TbadkCoreApplication.getInst(), R.dimen.ds14);
        s(forumRulesShowActivity);
    }

    public void A(String str) {
        if (this.o == null || StringUtils.isNull(str)) {
            return;
        }
        this.o.a(this.q);
        this.o.e(str);
    }

    public void B(String str) {
        d.b.j0.q0.q1.d.a aVar = this.p;
        if (aVar != null) {
            aVar.a(this.q);
            this.p.e(str);
        }
    }

    public void e(d.b.j0.q0.q1.c.b bVar) {
        this.w = bVar;
        this.r.add(bVar);
    }

    public void f(d.b.j0.q0.q1.c.a aVar) {
        this.r.add(aVar);
    }

    public void g(List<d.b.j0.q0.q1.c.c> list) {
        this.r.addAll(list);
    }

    public void h(String str) {
        A(str);
    }

    public void i() {
        this.f60487e = null;
    }

    public View k() {
        return this.s;
    }

    public ViewGroup l() {
        return this.f60490h;
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
        d.b.j0.q0.q1.d.b bVar = this.o;
        if (bVar != null) {
            bVar.d(this.q);
        }
    }

    public void onChangeSkinType(int i) {
        this.i.onChangeSkinType(this.f60487e.getPageContext(), i);
        if (this.f60488f == i) {
            this.i.getCenterText().setTextSize(R.dimen.L_X06);
            TextView centerText = this.i.getCenterText();
            int i2 = R.color.CAM_X0611;
            SkinManager.setNavbarTitleColor(centerText, i2, i2);
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.m, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.o.c(i);
            this.p.c(i);
            this.n.b(i);
            this.f60488f = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.f60487e != null) {
            if (view.getId() == R.id.root_pb_more) {
                int i = -1;
                d.b.j0.q0.q1.c.b bVar = this.w;
                if (bVar == null || bVar.j() == null) {
                    str = "";
                } else {
                    i = this.w.j().forum_id.intValue();
                    str = this.w.j().forum_name;
                }
                d.b.j0.q0.q1.c.b bVar2 = this.w;
                String p = bVar2 != null ? bVar2.p() : "";
                String str2 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
                ShareItem shareItem = new ShareItem();
                shareItem.r = p;
                shareItem.s = String.format(this.f60487e.getResources().getString(R.string.forum_rules_share_text), str);
                shareItem.t = str2;
                shareItem.Z = false;
                d.b.j0.q0.q1.c.b bVar3 = this.w;
                if (bVar3 != null && !StringUtils.isNull(bVar3.j().avatar)) {
                    shareItem.v = Uri.parse(this.w.j().avatar);
                    shareItem.f();
                }
                shareItem.O = p;
                shareItem.P = str2;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f60487e, shareItem, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new a(shareItem));
                this.f60487e.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            } else if (view.getId() == R.id.navigationBarGoBack) {
                this.f60487e.finish();
            } else if (this.t == null || view.getId() != this.t.c().getId()) {
            } else {
                this.f60487e.requestNet();
            }
        }
    }

    public void q() {
        d.b.j0.q0.q1.d.a aVar = this.p;
        if (aVar != null) {
            aVar.d(this.q);
        }
    }

    public final void r(NavigationBar navigationBar) {
        View addSystemImageButton = this.i.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.j = addSystemImageButton;
        this.k = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.i.setCenterTextTitle(this.f60487e.getResources().getString(R.string.forum_rules_local));
        View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
        this.l = addCustomView;
        this.m = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
        int i = this.u;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.rightMargin = this.v;
        this.l.setLayoutParams(layoutParams);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        x();
    }

    public final void s(ForumRulesShowActivity forumRulesShowActivity) {
        this.f60490h = (ViewGroup) forumRulesShowActivity.findViewById(R.id.forum_rule_rootview);
        NavigationBar navigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.navigationbar);
        this.i = navigationBar;
        r(navigationBar);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.forum_rules_list_info);
        this.q = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
        this.n = new d.b.j0.q0.q1.a.a(forumRulesShowActivity, this.q);
        this.s = forumRulesShowActivity.findViewById(R.id.forum_rules_net_refresh_layout);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFrom(String str) {
        this.f60489g = str;
        d.b.j0.q0.q1.a.a aVar = this.n;
        if (aVar != null) {
            aVar.d(str);
        }
    }

    public void u() {
        q();
        o();
    }

    public void v() {
        d.b.j0.q0.q1.a.a aVar = this.n;
        if (aVar != null) {
            aVar.c(this.r);
        }
    }

    public void w(h hVar) {
        this.t = hVar;
        hVar.c().setOnClickListener(this);
    }

    public final void x() {
        HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
        if (((baseSwitchs == null || !baseSwitchs.containsKey("is_disable_forumrule_share")) ? -1 : baseSwitchs.get("is_disable_forumrule_share").intValue()) == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f60489g)) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    public void y() {
        BdTypeRecyclerView bdTypeRecyclerView = this.q;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
    }

    public void z() {
        View view = this.s;
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
