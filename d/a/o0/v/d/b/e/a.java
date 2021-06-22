package d.a.o0.v.d.b.e;

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
import d.a.c.k.e.n;
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import d.a.n0.r.q.a2;
import d.a.o0.v.d.b.a.b;
import d.a.o0.v.d.g.b.c;
import d.a.o0.v.d.g.d.f;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65314a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f65315b;

    /* renamed from: c  reason: collision with root package name */
    public g f65316c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f65317d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f65318e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f65319f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f65320g;

    /* renamed from: h  reason: collision with root package name */
    public b f65321h;

    /* renamed from: i  reason: collision with root package name */
    public int f65322i;
    public f j = new C1704a();

    /* renamed from: d.a.o0.v.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1704a implements f {
        public C1704a() {
        }

        @Override // d.a.o0.v.d.g.d.f
        public void a(int i2, String str, a2 a2Var) {
            TiebaStatic.log(d.a.o0.v.d.d.a.c().e(a.this.f65322i, "c12118", i2, str, a2Var));
            a aVar = a.this;
            aVar.h(aVar.f65314a, a2Var, str);
        }

        @Override // d.a.o0.v.d.g.d.f
        public void b(c cVar) {
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i2) {
        this.f65314a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f65318e = linearLayout;
        linearLayout.setOrientation(1);
        this.f65319f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f65319f.setVisibility(8);
        }
        this.f65318e.addView(this.f65319f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f65317d = frameLayout;
        this.f65318e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f65318e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f65314a.getPageActivity());
        this.f65315b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f65317d.addView(this.f65315b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f65314a);
        this.f65316c = gVar;
        gVar.Z(bdUniqueId);
        this.f65315b.setPullRefresh(this.f65316c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f65320g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f65315b);
        this.f65321h = bVar;
        bVar.c(this.j);
    }

    public void d() {
        this.f65315b.z();
    }

    public FrameLayout e() {
        return this.f65317d;
    }

    public BdTypeListView f() {
        return this.f65315b;
    }

    public View g() {
        return this.f65318e;
    }

    public final void h(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.s1() == null) {
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
        alaLiveInfoCoreData.fillWithInfoData(a2Var.s1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_LIVE, str2, z, str, null)));
    }

    public void i(int i2) {
        this.f65320g.o(R.color.CAM_X0204);
        this.f65320g.d(i2);
        this.f65316c.I(i2);
        this.f65321h.b();
        SkinManager.setBackgroundColor(this.f65318e, R.color.CAM_X0201);
        this.f65319f.c(this.f65314a, i2);
    }

    public void j(List<n> list, boolean z, int i2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.f65322i = i2;
        this.f65321h.d(list);
        this.f65321h.e(i2);
        if (z) {
            p();
        } else {
            q();
        }
    }

    public void k(f.g gVar) {
        this.f65316c.a(gVar);
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        this.f65315b.setOnScrollListener(onScrollListener);
    }

    public void m(BdListView.o oVar, int i2) {
        this.f65315b.setOnScrollStopDelayedListener(oVar, i2);
    }

    public void n(BdListView.p pVar) {
        this.f65315b.setOnSrollToBottomListener(pVar);
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        this.f65321h.f(iAlaSquareTabController);
    }

    public void p() {
        PbListView pbListView = this.f65320g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f65315b.setNextPage(this.f65320g);
            }
            this.f65320g.M();
            this.f65320g.O();
        }
    }

    public void q() {
        PbListView pbListView = this.f65320g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f65315b.setNextPage(this.f65320g);
            }
            this.f65320g.A(this.f65314a.getResources().getString(R.string.list_no_more));
            this.f65320g.f();
        }
    }
}
