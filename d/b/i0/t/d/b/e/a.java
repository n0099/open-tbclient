package d.b.i0.t.d.b.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import d.b.b.e.p.j;
import d.b.b.j.e.n;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import d.b.h0.r.q.a2;
import d.b.i0.t.d.b.a.b;
import d.b.i0.t.d.g.b.c;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60296a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60297b;

    /* renamed from: c  reason: collision with root package name */
    public g f60298c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f60299d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f60300e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f60301f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f60302g;

    /* renamed from: h  reason: collision with root package name */
    public b f60303h;
    public int i;
    public d.b.i0.t.d.g.d.g j = new C1541a();

    /* renamed from: d.b.i0.t.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1541a implements d.b.i0.t.d.g.d.g {
        public C1541a() {
        }

        @Override // d.b.i0.t.d.g.d.g
        public void a(int i, String str, a2 a2Var) {
            TiebaStatic.log(d.b.i0.t.d.d.a.c().e(a.this.i, "c12118", i, str, a2Var));
            a aVar = a.this;
            aVar.h(aVar.f60296a, a2Var, str);
        }

        @Override // d.b.i0.t.d.g.d.g
        public void b(c cVar) {
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        this.f60296a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f60300e = linearLayout;
        linearLayout.setOrientation(1);
        this.f60301f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f60301f.setVisibility(8);
        }
        this.f60300e.addView(this.f60301f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f60299d = frameLayout;
        this.f60300e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f60300e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f60296a.getPageActivity());
        this.f60297b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f60299d.addView(this.f60297b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f60296a);
        this.f60298c = gVar;
        gVar.Z(bdUniqueId);
        this.f60297b.setPullRefresh(this.f60298c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f60302g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f60297b);
        this.f60303h = bVar;
        bVar.c(this.j);
    }

    public void d() {
        this.f60297b.z();
    }

    public FrameLayout e() {
        return this.f60299d;
    }

    public BdTypeListView f() {
        return this.f60297b;
    }

    public View g() {
        return this.f60300e;
    }

    public final void h(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = a2Var.T().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_LIVE, str2, z, str, null)));
    }

    public void i(int i) {
        this.f60302g.o(R.color.CAM_X0204);
        this.f60302g.d(i);
        this.f60298c.I(i);
        this.f60303h.b();
        SkinManager.setBackgroundColor(this.f60300e, R.color.CAM_X0201);
        this.f60301f.c(this.f60296a, i);
    }

    public void j(List<n> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.i = i;
        this.f60303h.d(list);
        this.f60303h.e(i);
        if (z) {
            p();
        } else {
            q();
        }
    }

    public void k(f.g gVar) {
        this.f60298c.b(gVar);
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        this.f60297b.setOnScrollListener(onScrollListener);
    }

    public void m(BdListView.o oVar, int i) {
        this.f60297b.setOnScrollStopDelayedListener(oVar, i);
    }

    public void n(BdListView.p pVar) {
        this.f60297b.setOnSrollToBottomListener(pVar);
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        this.f60303h.f(iAlaSquareTabController);
    }

    public void p() {
        PbListView pbListView = this.f60302g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f60297b.setNextPage(this.f60302g);
            }
            this.f60302g.M();
            this.f60302g.O();
        }
    }

    public void q() {
        PbListView pbListView = this.f60302g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f60297b.setNextPage(this.f60302g);
            }
            this.f60302g.A(this.f60296a.getResources().getString(R.string.list_no_more));
            this.f60302g.f();
        }
    }
}
