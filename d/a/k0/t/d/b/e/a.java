package d.a.k0.t.d.b.e;

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
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import d.a.j0.r.q.a2;
import d.a.k0.t.d.b.a.b;
import d.a.k0.t.d.g.b.c;
import d.a.k0.t.d.g.d.f;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61188a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61189b;

    /* renamed from: c  reason: collision with root package name */
    public g f61190c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f61191d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f61192e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f61193f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f61194g;

    /* renamed from: h  reason: collision with root package name */
    public b f61195h;

    /* renamed from: i  reason: collision with root package name */
    public int f61196i;
    public f j = new C1623a();

    /* renamed from: d.a.k0.t.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1623a implements f {
        public C1623a() {
        }

        @Override // d.a.k0.t.d.g.d.f
        public void a(int i2, String str, a2 a2Var) {
            TiebaStatic.log(d.a.k0.t.d.d.a.c().e(a.this.f61196i, "c12118", i2, str, a2Var));
            a aVar = a.this;
            aVar.h(aVar.f61188a, a2Var, str);
        }

        @Override // d.a.k0.t.d.g.d.f
        public void b(c cVar) {
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i2) {
        this.f61188a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f61192e = linearLayout;
        linearLayout.setOrientation(1);
        this.f61193f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f61193f.setVisibility(8);
        }
        this.f61192e.addView(this.f61193f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f61191d = frameLayout;
        this.f61192e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f61192e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f61188a.getPageActivity());
        this.f61189b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f61191d.addView(this.f61189b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f61188a);
        this.f61190c = gVar;
        gVar.Z(bdUniqueId);
        this.f61189b.setPullRefresh(this.f61190c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f61194g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f61189b);
        this.f61195h = bVar;
        bVar.c(this.j);
    }

    public void d() {
        this.f61189b.z();
    }

    public FrameLayout e() {
        return this.f61191d;
    }

    public BdTypeListView f() {
        return this.f61189b;
    }

    public View g() {
        return this.f61192e;
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
        this.f61194g.o(R.color.CAM_X0204);
        this.f61194g.d(i2);
        this.f61190c.I(i2);
        this.f61195h.b();
        SkinManager.setBackgroundColor(this.f61192e, R.color.CAM_X0201);
        this.f61193f.c(this.f61188a, i2);
    }

    public void j(List<n> list, boolean z, int i2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.f61196i = i2;
        this.f61195h.d(list);
        this.f61195h.e(i2);
        if (z) {
            p();
        } else {
            q();
        }
    }

    public void k(f.g gVar) {
        this.f61190c.a(gVar);
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        this.f61189b.setOnScrollListener(onScrollListener);
    }

    public void m(BdListView.o oVar, int i2) {
        this.f61189b.setOnScrollStopDelayedListener(oVar, i2);
    }

    public void n(BdListView.p pVar) {
        this.f61189b.setOnSrollToBottomListener(pVar);
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        this.f61195h.f(iAlaSquareTabController);
    }

    public void p() {
        PbListView pbListView = this.f61194g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61189b.setNextPage(this.f61194g);
            }
            this.f61194g.M();
            this.f61194g.O();
        }
    }

    public void q() {
        PbListView pbListView = this.f61194g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61189b.setNextPage(this.f61194g);
            }
            this.f61194g.A(this.f61188a.getResources().getString(R.string.list_no_more));
            this.f61194g.f();
        }
    }
}
