package d.b.i0.t.d.e.c;

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
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import d.b.i0.t.d.e.a.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AlaRecentHistoryActivity f60514a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f60515b;

    /* renamed from: c  reason: collision with root package name */
    public View f60516c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f60517d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f60518e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f60519f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f60520g;

    /* renamed from: h  reason: collision with root package name */
    public g f60521h;
    public d.b.i0.t.d.e.a.a i;
    public int j;
    public d.b.i0.t.d.e.b.b k;
    public CustomMessageListener l;

    /* renamed from: d.b.i0.t.d.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1550a implements c.InterfaceC1549c {
        public C1550a() {
        }

        @Override // d.b.i0.t.d.e.a.c.InterfaceC1549c
        public void a(d.b.i0.t.d.e.b.b bVar) {
            a.this.k = bVar;
            a.this.m(bVar.f60508a.T(), bVar.f60509b);
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
                d.b.i0.t.d.d.a.c().g();
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
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f13694c) || a.this.k == null) {
                return;
            }
            if (updateAttentionMessage.getData().f13694c.equals(String.valueOf((a.this.k.f60508a == null || a.this.k.f60508a.T() == null) ? -100L : a.this.k.f60508a.T().getUserIdLong()))) {
                if (updateAttentionMessage.getData().f13692a) {
                    a.this.k.f60509b = true;
                    if (a.this.i instanceof d.b.i0.t.d.e.a.c) {
                        a.this.i.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                a.this.k.f60509b = false;
            }
        }
    }

    public a(TbPageContext tbPageContext, int i) {
        this.f60515b = tbPageContext;
        this.f60514a = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.j = i;
        j();
    }

    public void e() {
        this.f60518e.z();
    }

    public final void f() {
        int i = this.j;
        if (i == 0) {
            this.i = new d.b.i0.t.d.e.a.b(this.f60515b);
        } else if (1 == i) {
            this.i = new d.b.i0.t.d.e.a.c(this.f60515b);
            n();
            ((d.b.i0.t.d.e.a.c) this.i).i(new C1550a());
        }
        this.f60518e.setAdapter((ListAdapter) this.i);
        this.f60518e.setOnScrollListener(new b(this));
    }

    public ViewGroup g() {
        return this.f60517d;
    }

    public View h() {
        return this.f60516c;
    }

    public final void i() {
        f();
    }

    public void j() {
        ColorDrawable colorDrawable;
        View inflate = LayoutInflater.from(this.f60514a).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.f60516c = inflate;
        inflate.setPadding(0, (int) this.f60514a.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.f60517d = (FrameLayout) this.f60516c.findViewById(R.id.square_recent_history_container);
        this.f60518e = (BdListView) this.f60516c.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.f60514a.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
        } else {
            colorDrawable = new ColorDrawable(this.f60514a.getPageContext().getResources().getColor(R.color.CAM_X0204));
        }
        this.f60518e.setDivider(colorDrawable);
        this.f60518e.setDividerHeight(this.f60514a.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.f60519f = (NoNetworkView) this.f60516c.findViewById(R.id.square_recent_history_network);
        g gVar = new g(this.f60515b);
        this.f60521h = gVar;
        gVar.Z(this.f60514a.getUniqueId());
        this.f60518e.setPullRefresh(this.f60521h);
        PbListView pbListView = new PbListView(this.f60514a);
        this.f60520g = pbListView;
        pbListView.a();
        i();
    }

    public void k(int i) {
        NoNetworkView noNetworkView = this.f60519f;
        if (noNetworkView != null) {
            noNetworkView.c(this.f60515b, i);
        }
    }

    public void l() {
        if (this.l != null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void m(MetaData metaData, boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.f60515b.getPageActivity());
            return;
        }
        String valueOf = String.valueOf(metaData.getUserId());
        AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
    }

    public final void n() {
        this.l = new c(2001115);
        MessageManager.getInstance().registerListener(this.l);
    }

    public void o(List<d.b.i0.t.d.e.b.b> list, boolean z) {
        d.b.i0.t.d.e.a.a aVar = this.i;
        if (aVar instanceof d.b.i0.t.d.e.a.b) {
            aVar.c(list);
        } else if (aVar instanceof d.b.i0.t.d.e.a.c) {
            aVar.c(list);
        }
        if (z) {
            s();
        } else {
            t();
        }
    }

    public void p(f.g gVar) {
        this.f60521h.b(gVar);
    }

    public void q() {
        this.f60518e.setNextPage(null);
    }

    public void r(BdListView.p pVar) {
        this.f60518e.setOnSrollToBottomListener(pVar);
    }

    public final void s() {
        PbListView pbListView = this.f60520g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f60518e.setNextPage(this.f60520g);
            }
            this.f60520g.M();
            this.f60520g.O();
        }
    }

    public final void t() {
        PbListView pbListView = this.f60520g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f60518e.setNextPage(this.f60520g);
            }
            this.f60520g.A(this.f60514a.getPageContext().getResources().getString(R.string.list_no_more));
            this.f60520g.f();
        }
    }
}
