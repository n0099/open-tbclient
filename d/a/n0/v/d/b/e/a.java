package d.a.n0.v.d.b.e;

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
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import d.a.m0.r.q.a2;
import d.a.n0.v.d.b.a.b;
import d.a.n0.v.d.g.b.c;
import d.a.n0.v.d.g.d.f;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61476a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61477b;

    /* renamed from: c  reason: collision with root package name */
    public g f61478c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f61479d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f61480e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f61481f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f61482g;

    /* renamed from: h  reason: collision with root package name */
    public b f61483h;

    /* renamed from: i  reason: collision with root package name */
    public int f61484i;
    public f j = new C1643a();

    /* renamed from: d.a.n0.v.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1643a implements f {
        public C1643a() {
        }

        @Override // d.a.n0.v.d.g.d.f
        public void a(int i2, String str, a2 a2Var) {
            TiebaStatic.log(d.a.n0.v.d.d.a.c().e(a.this.f61484i, "c12118", i2, str, a2Var));
            a aVar = a.this;
            aVar.h(aVar.f61476a, a2Var, str);
        }

        @Override // d.a.n0.v.d.g.d.f
        public void b(c cVar) {
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i2) {
        this.f61476a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f61480e = linearLayout;
        linearLayout.setOrientation(1);
        this.f61481f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f61481f.setVisibility(8);
        }
        this.f61480e.addView(this.f61481f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f61479d = frameLayout;
        this.f61480e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f61480e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f61476a.getPageActivity());
        this.f61477b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f61479d.addView(this.f61477b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f61476a);
        this.f61478c = gVar;
        gVar.Z(bdUniqueId);
        this.f61477b.setPullRefresh(this.f61478c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f61482g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f61477b);
        this.f61483h = bVar;
        bVar.c(this.j);
    }

    public void d() {
        this.f61477b.z();
    }

    public FrameLayout e() {
        return this.f61479d;
    }

    public BdTypeListView f() {
        return this.f61477b;
    }

    public View g() {
        return this.f61480e;
    }

    public final void h(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.r1() == null) {
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
        alaLiveInfoCoreData.fillWithInfoData(a2Var.r1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_LIVE, str2, z, str, null)));
    }

    public void i(int i2) {
        this.f61482g.o(R.color.CAM_X0204);
        this.f61482g.d(i2);
        this.f61478c.I(i2);
        this.f61483h.b();
        SkinManager.setBackgroundColor(this.f61480e, R.color.CAM_X0201);
        this.f61481f.c(this.f61476a, i2);
    }

    public void j(List<n> list, boolean z, int i2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.f61484i = i2;
        this.f61483h.d(list);
        this.f61483h.e(i2);
        if (z) {
            p();
        } else {
            q();
        }
    }

    public void k(f.g gVar) {
        this.f61478c.a(gVar);
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        this.f61477b.setOnScrollListener(onScrollListener);
    }

    public void m(BdListView.o oVar, int i2) {
        this.f61477b.setOnScrollStopDelayedListener(oVar, i2);
    }

    public void n(BdListView.p pVar) {
        this.f61477b.setOnSrollToBottomListener(pVar);
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        this.f61483h.f(iAlaSquareTabController);
    }

    public void p() {
        PbListView pbListView = this.f61482g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61477b.setNextPage(this.f61482g);
            }
            this.f61482g.M();
            this.f61482g.O();
        }
    }

    public void q() {
        PbListView pbListView = this.f61482g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61477b.setNextPage(this.f61482g);
            }
            this.f61482g.A(this.f61476a.getResources().getString(R.string.list_no_more));
            this.f61482g.f();
        }
    }
}
