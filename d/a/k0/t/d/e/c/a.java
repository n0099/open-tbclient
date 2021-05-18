package d.a.k0.t.d.e.c;

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
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import d.a.k0.t.d.e.a.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AlaRecentHistoryActivity f61411a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f61412b;

    /* renamed from: c  reason: collision with root package name */
    public View f61413c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f61414d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f61415e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f61416f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f61417g;

    /* renamed from: h  reason: collision with root package name */
    public g f61418h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.t.d.e.a.a f61419i;
    public int j;
    public d.a.k0.t.d.e.b.b k;
    public CustomMessageListener l;

    /* renamed from: d.a.k0.t.d.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1633a implements c.InterfaceC1632c {
        public C1633a() {
        }

        @Override // d.a.k0.t.d.e.a.c.InterfaceC1632c
        public void a(d.a.k0.t.d.e.b.b bVar) {
            a.this.k = bVar;
            a.this.m(bVar.f61405a.T(), bVar.f61406b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public b(a aVar) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 0) {
                d.a.k0.t.d.d.a.c().g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12668c) || a.this.k == null) {
                return;
            }
            if (updateAttentionMessage.getData().f12668c.equals(String.valueOf((a.this.k.f61405a == null || a.this.k.f61405a.T() == null) ? -100L : a.this.k.f61405a.T().getUserIdLong()))) {
                if (updateAttentionMessage.getData().f12666a) {
                    a.this.k.f61406b = true;
                    if (a.this.f61419i instanceof d.a.k0.t.d.e.a.c) {
                        a.this.f61419i.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                a.this.k.f61406b = false;
            }
        }
    }

    public a(TbPageContext tbPageContext, int i2) {
        this.f61412b = tbPageContext;
        this.f61411a = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.j = i2;
        j();
    }

    public void e() {
        this.f61415e.z();
    }

    public final void f() {
        int i2 = this.j;
        if (i2 == 0) {
            this.f61419i = new d.a.k0.t.d.e.a.b(this.f61412b);
        } else if (1 == i2) {
            this.f61419i = new d.a.k0.t.d.e.a.c(this.f61412b);
            n();
            ((d.a.k0.t.d.e.a.c) this.f61419i).i(new C1633a());
        }
        this.f61415e.setAdapter((ListAdapter) this.f61419i);
        this.f61415e.setOnScrollListener(new b(this));
    }

    public ViewGroup g() {
        return this.f61414d;
    }

    public View h() {
        return this.f61413c;
    }

    public final void i() {
        f();
    }

    public void j() {
        ColorDrawable colorDrawable;
        View inflate = LayoutInflater.from(this.f61411a).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.f61413c = inflate;
        inflate.setPadding(0, (int) this.f61411a.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.f61414d = (FrameLayout) this.f61413c.findViewById(R.id.square_recent_history_container);
        this.f61415e = (BdListView) this.f61413c.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.f61411a.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
        } else {
            colorDrawable = new ColorDrawable(this.f61411a.getPageContext().getResources().getColor(R.color.CAM_X0204));
        }
        this.f61415e.setDivider(colorDrawable);
        this.f61415e.setDividerHeight(this.f61411a.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.f61416f = (NoNetworkView) this.f61413c.findViewById(R.id.square_recent_history_network);
        g gVar = new g(this.f61412b);
        this.f61418h = gVar;
        gVar.Z(this.f61411a.getUniqueId());
        this.f61415e.setPullRefresh(this.f61418h);
        PbListView pbListView = new PbListView(this.f61411a);
        this.f61417g = pbListView;
        pbListView.a();
        i();
    }

    public void k(int i2) {
        NoNetworkView noNetworkView = this.f61416f;
        if (noNetworkView != null) {
            noNetworkView.c(this.f61412b, i2);
        }
    }

    public void l() {
        if (this.l != null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void m(MetaData metaData, boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.f61412b.getPageActivity());
            return;
        }
        String valueOf = String.valueOf(metaData.getUserId());
        AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
    }

    public final void n() {
        this.l = new c(2001115);
        MessageManager.getInstance().registerListener(this.l);
    }

    public void o(List<d.a.k0.t.d.e.b.b> list, boolean z) {
        d.a.k0.t.d.e.a.a aVar = this.f61419i;
        if (aVar instanceof d.a.k0.t.d.e.a.b) {
            aVar.c(list);
        } else if (aVar instanceof d.a.k0.t.d.e.a.c) {
            aVar.c(list);
        }
        if (z) {
            s();
        } else {
            t();
        }
    }

    public void p(f.g gVar) {
        this.f61418h.a(gVar);
    }

    public void q() {
        this.f61415e.setNextPage(null);
    }

    public void r(BdListView.p pVar) {
        this.f61415e.setOnSrollToBottomListener(pVar);
    }

    public final void s() {
        PbListView pbListView = this.f61417g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61415e.setNextPage(this.f61417g);
            }
            this.f61417g.M();
            this.f61417g.O();
        }
    }

    public final void t() {
        PbListView pbListView = this.f61417g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61415e.setNextPage(this.f61417g);
            }
            this.f61417g.A(this.f61411a.getPageContext().getResources().getString(R.string.list_no_more));
            this.f61417g.f();
        }
    }
}
