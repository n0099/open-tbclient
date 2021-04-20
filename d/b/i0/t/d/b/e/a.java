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
import d.b.c.e.p.j;
import d.b.c.j.e.n;
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
    public TbPageContext f61861a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61862b;

    /* renamed from: c  reason: collision with root package name */
    public g f61863c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f61864d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f61865e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f61866f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f61867g;

    /* renamed from: h  reason: collision with root package name */
    public b f61868h;
    public int i;
    public d.b.i0.t.d.g.d.g j = new C1595a();

    /* renamed from: d.b.i0.t.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1595a implements d.b.i0.t.d.g.d.g {
        public C1595a() {
        }

        @Override // d.b.i0.t.d.g.d.g
        public void a(int i, String str, a2 a2Var) {
            TiebaStatic.log(d.b.i0.t.d.d.a.c().e(a.this.i, "c12118", i, str, a2Var));
            a aVar = a.this;
            aVar.h(aVar.f61861a, a2Var, str);
        }

        @Override // d.b.i0.t.d.g.d.g
        public void b(c cVar) {
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        this.f61861a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f61865e = linearLayout;
        linearLayout.setOrientation(1);
        this.f61866f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f61866f.setVisibility(8);
        }
        this.f61865e.addView(this.f61866f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f61864d = frameLayout;
        this.f61865e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f61865e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f61861a.getPageActivity());
        this.f61862b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f61864d.addView(this.f61862b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f61861a);
        this.f61863c = gVar;
        gVar.Z(bdUniqueId);
        this.f61862b.setPullRefresh(this.f61863c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f61867g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f61862b);
        this.f61868h = bVar;
        bVar.c(this.j);
    }

    public void d() {
        this.f61862b.z();
    }

    public FrameLayout e() {
        return this.f61864d;
    }

    public BdTypeListView f() {
        return this.f61862b;
    }

    public View g() {
        return this.f61865e;
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
        this.f61867g.o(R.color.CAM_X0204);
        this.f61867g.d(i);
        this.f61863c.I(i);
        this.f61868h.b();
        SkinManager.setBackgroundColor(this.f61865e, R.color.CAM_X0201);
        this.f61866f.c(this.f61861a, i);
    }

    public void j(List<n> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.i = i;
        this.f61868h.d(list);
        this.f61868h.e(i);
        if (z) {
            p();
        } else {
            q();
        }
    }

    public void k(f.g gVar) {
        this.f61863c.b(gVar);
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        this.f61862b.setOnScrollListener(onScrollListener);
    }

    public void m(BdListView.o oVar, int i) {
        this.f61862b.setOnScrollStopDelayedListener(oVar, i);
    }

    public void n(BdListView.p pVar) {
        this.f61862b.setOnSrollToBottomListener(pVar);
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        this.f61868h.f(iAlaSquareTabController);
    }

    public void p() {
        PbListView pbListView = this.f61867g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61862b.setNextPage(this.f61867g);
            }
            this.f61867g.M();
            this.f61867g.O();
        }
    }

    public void q() {
        PbListView pbListView = this.f61867g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61862b.setNextPage(this.f61867g);
            }
            this.f61867g.A(this.f61861a.getResources().getString(R.string.list_no_more));
            this.f61867g.f();
        }
    }
}
