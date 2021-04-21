package d.b.j0.t.d.e.c;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import d.b.j0.t.d.e.a.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AlaRecentHistoryActivity f62500a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f62501b;

    /* renamed from: c  reason: collision with root package name */
    public View f62502c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f62503d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f62504e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f62505f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f62506g;

    /* renamed from: h  reason: collision with root package name */
    public g f62507h;
    public d.b.j0.t.d.e.a.a i;
    public int j;
    public d.b.j0.t.d.e.b.b k;
    public CustomMessageListener l;

    /* renamed from: d.b.j0.t.d.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1627a implements c.InterfaceC1626c {
        public C1627a() {
        }

        @Override // d.b.j0.t.d.e.a.c.InterfaceC1626c
        public void a(d.b.j0.t.d.e.b.b bVar) {
            a.this.k = bVar;
            a.this.m(bVar.f62494a.T(), bVar.f62495b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public b(a aVar) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                d.b.j0.t.d.d.a.c().g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f13364c) || a.this.k == null) {
                return;
            }
            if (updateAttentionMessage.getData().f13364c.equals(String.valueOf((a.this.k.f62494a == null || a.this.k.f62494a.T() == null) ? -100L : a.this.k.f62494a.T().getUserIdLong()))) {
                if (updateAttentionMessage.getData().f13362a) {
                    a.this.k.f62495b = true;
                    if (a.this.i instanceof d.b.j0.t.d.e.a.c) {
                        a.this.i.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                a.this.k.f62495b = false;
            }
        }
    }

    public a(TbPageContext tbPageContext, int i) {
        this.f62501b = tbPageContext;
        this.f62500a = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.j = i;
        j();
    }

    public void e() {
        this.f62504e.z();
    }

    public final void f() {
        int i = this.j;
        if (i == 0) {
            this.i = new d.b.j0.t.d.e.a.b(this.f62501b);
        } else if (1 == i) {
            this.i = new d.b.j0.t.d.e.a.c(this.f62501b);
            n();
            ((d.b.j0.t.d.e.a.c) this.i).i(new C1627a());
        }
        this.f62504e.setAdapter((ListAdapter) this.i);
        this.f62504e.setOnScrollListener(new b(this));
    }

    public ViewGroup g() {
        return this.f62503d;
    }

    public View h() {
        return this.f62502c;
    }

    public final void i() {
        f();
    }

    public void j() {
        ColorDrawable colorDrawable;
        View inflate = LayoutInflater.from(this.f62500a).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.f62502c = inflate;
        inflate.setPadding(0, (int) this.f62500a.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.f62503d = (FrameLayout) this.f62502c.findViewById(R.id.square_recent_history_container);
        this.f62504e = (BdListView) this.f62502c.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.f62500a.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
        } else {
            colorDrawable = new ColorDrawable(this.f62500a.getPageContext().getResources().getColor(R.color.CAM_X0204));
        }
        this.f62504e.setDivider(colorDrawable);
        this.f62504e.setDividerHeight(this.f62500a.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.f62505f = (NoNetworkView) this.f62502c.findViewById(R.id.square_recent_history_network);
        g gVar = new g(this.f62501b);
        this.f62507h = gVar;
        gVar.Z(this.f62500a.getUniqueId());
        this.f62504e.setPullRefresh(this.f62507h);
        PbListView pbListView = new PbListView(this.f62500a);
        this.f62506g = pbListView;
        pbListView.a();
        i();
    }

    public void k(int i) {
        NoNetworkView noNetworkView = this.f62505f;
        if (noNetworkView != null) {
            noNetworkView.c(this.f62501b, i);
        }
    }

    public void l() {
        if (this.l != null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void m(MetaData metaData, boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.f62501b.getPageActivity());
            return;
        }
        String valueOf = String.valueOf(metaData.getUserId());
        AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
    }

    public final void n() {
        this.l = new c(2001115);
        MessageManager.getInstance().registerListener(this.l);
    }

    public void o(List<d.b.j0.t.d.e.b.b> list, boolean z) {
        d.b.j0.t.d.e.a.a aVar = this.i;
        if (aVar instanceof d.b.j0.t.d.e.a.b) {
            aVar.c(list);
        } else if (aVar instanceof d.b.j0.t.d.e.a.c) {
            aVar.c(list);
        }
        if (z) {
            s();
        } else {
            t();
        }
    }

    public void p(f.g gVar) {
        this.f62507h.b(gVar);
    }

    public void q() {
        this.f62504e.setNextPage(null);
    }

    public void r(BdListView.p pVar) {
        this.f62504e.setOnSrollToBottomListener(pVar);
    }

    public final void s() {
        PbListView pbListView = this.f62506g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f62504e.setNextPage(this.f62506g);
            }
            this.f62506g.M();
            this.f62506g.O();
        }
    }

    public final void t() {
        PbListView pbListView = this.f62506g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f62504e.setNextPage(this.f62506g);
            }
            this.f62506g.A(this.f62500a.getPageContext().getResources().getString(R.string.list_no_more));
            this.f62506g.f();
        }
    }
}
