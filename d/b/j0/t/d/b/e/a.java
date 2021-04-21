package d.b.j0.t.d.b.e;

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
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import d.b.i0.r.q.a2;
import d.b.j0.t.d.b.a.b;
import d.b.j0.t.d.g.b.c;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62282a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f62283b;

    /* renamed from: c  reason: collision with root package name */
    public g f62284c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f62285d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f62286e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f62287f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f62288g;

    /* renamed from: h  reason: collision with root package name */
    public b f62289h;
    public int i;
    public d.b.j0.t.d.g.d.g j = new C1618a();

    /* renamed from: d.b.j0.t.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1618a implements d.b.j0.t.d.g.d.g {
        public C1618a() {
        }

        @Override // d.b.j0.t.d.g.d.g
        public void a(int i, String str, a2 a2Var) {
            TiebaStatic.log(d.b.j0.t.d.d.a.c().e(a.this.i, "c12118", i, str, a2Var));
            a aVar = a.this;
            aVar.h(aVar.f62282a, a2Var, str);
        }

        @Override // d.b.j0.t.d.g.d.g
        public void b(c cVar) {
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        this.f62282a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f62286e = linearLayout;
        linearLayout.setOrientation(1);
        this.f62287f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f62287f.setVisibility(8);
        }
        this.f62286e.addView(this.f62287f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f62285d = frameLayout;
        this.f62286e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f62286e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f62282a.getPageActivity());
        this.f62283b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f62285d.addView(this.f62283b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f62282a);
        this.f62284c = gVar;
        gVar.Z(bdUniqueId);
        this.f62283b.setPullRefresh(this.f62284c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f62288g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f62283b);
        this.f62289h = bVar;
        bVar.c(this.j);
    }

    public void d() {
        this.f62283b.z();
    }

    public FrameLayout e() {
        return this.f62285d;
    }

    public BdTypeListView f() {
        return this.f62283b;
    }

    public View g() {
        return this.f62286e;
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
        this.f62288g.o(R.color.CAM_X0204);
        this.f62288g.d(i);
        this.f62284c.I(i);
        this.f62289h.b();
        SkinManager.setBackgroundColor(this.f62286e, R.color.CAM_X0201);
        this.f62287f.c(this.f62282a, i);
    }

    public void j(List<n> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.i = i;
        this.f62289h.d(list);
        this.f62289h.e(i);
        if (z) {
            p();
        } else {
            q();
        }
    }

    public void k(f.g gVar) {
        this.f62284c.b(gVar);
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        this.f62283b.setOnScrollListener(onScrollListener);
    }

    public void m(BdListView.o oVar, int i) {
        this.f62283b.setOnScrollStopDelayedListener(oVar, i);
    }

    public void n(BdListView.p pVar) {
        this.f62283b.setOnSrollToBottomListener(pVar);
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        this.f62289h.f(iAlaSquareTabController);
    }

    public void p() {
        PbListView pbListView = this.f62288g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f62283b.setNextPage(this.f62288g);
            }
            this.f62288g.M();
            this.f62288g.O();
        }
    }

    public void q() {
        PbListView pbListView = this.f62288g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f62283b.setNextPage(this.f62288g);
            }
            this.f62288g.A(this.f62282a.getResources().getString(R.string.list_no_more));
            this.f62288g.f();
        }
    }
}
