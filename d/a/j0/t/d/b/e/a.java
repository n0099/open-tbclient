package d.a.j0.t.d.b.e;

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
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import d.a.i0.r.q.a2;
import d.a.j0.t.d.b.a.b;
import d.a.j0.t.d.g.b.c;
import d.a.j0.t.d.g.d.f;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60464a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60465b;

    /* renamed from: c  reason: collision with root package name */
    public g f60466c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f60467d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f60468e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f60469f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f60470g;

    /* renamed from: h  reason: collision with root package name */
    public b f60471h;

    /* renamed from: i  reason: collision with root package name */
    public int f60472i;
    public f j = new C1558a();

    /* renamed from: d.a.j0.t.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1558a implements f {
        public C1558a() {
        }

        @Override // d.a.j0.t.d.g.d.f
        public void a(int i2, String str, a2 a2Var) {
            TiebaStatic.log(d.a.j0.t.d.d.a.c().e(a.this.f60472i, "c12118", i2, str, a2Var));
            a aVar = a.this;
            aVar.h(aVar.f60464a, a2Var, str);
        }

        @Override // d.a.j0.t.d.g.d.f
        public void b(c cVar) {
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i2) {
        this.f60464a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f60468e = linearLayout;
        linearLayout.setOrientation(1);
        this.f60469f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f60469f.setVisibility(8);
        }
        this.f60468e.addView(this.f60469f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f60467d = frameLayout;
        this.f60468e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f60468e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f60464a.getPageActivity());
        this.f60465b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f60467d.addView(this.f60465b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f60464a);
        this.f60466c = gVar;
        gVar.Z(bdUniqueId);
        this.f60465b.setPullRefresh(this.f60466c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f60470g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f60465b);
        this.f60471h = bVar;
        bVar.c(this.j);
    }

    public void d() {
        this.f60465b.z();
    }

    public FrameLayout e() {
        return this.f60467d;
    }

    public BdTypeListView f() {
        return this.f60465b;
    }

    public View g() {
        return this.f60468e;
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

    public void i(int i2) {
        this.f60470g.o(R.color.CAM_X0204);
        this.f60470g.d(i2);
        this.f60466c.I(i2);
        this.f60471h.b();
        SkinManager.setBackgroundColor(this.f60468e, R.color.CAM_X0201);
        this.f60469f.c(this.f60464a, i2);
    }

    public void j(List<n> list, boolean z, int i2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.f60472i = i2;
        this.f60471h.d(list);
        this.f60471h.e(i2);
        if (z) {
            p();
        } else {
            q();
        }
    }

    public void k(f.g gVar) {
        this.f60466c.a(gVar);
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        this.f60465b.setOnScrollListener(onScrollListener);
    }

    public void m(BdListView.o oVar, int i2) {
        this.f60465b.setOnScrollStopDelayedListener(oVar, i2);
    }

    public void n(BdListView.p pVar) {
        this.f60465b.setOnSrollToBottomListener(pVar);
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        this.f60471h.f(iAlaSquareTabController);
    }

    public void p() {
        PbListView pbListView = this.f60470g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f60465b.setNextPage(this.f60470g);
            }
            this.f60470g.M();
            this.f60470g.O();
        }
    }

    public void q() {
        PbListView pbListView = this.f60470g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f60465b.setNextPage(this.f60470g);
            }
            this.f60470g.A(this.f60464a.getResources().getString(R.string.list_no_more));
            this.f60470g.f();
        }
    }
}
