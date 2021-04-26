package d.a.j0.t.d.e.c;

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
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import d.a.j0.t.d.e.a.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AlaRecentHistoryActivity f60687a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f60688b;

    /* renamed from: c  reason: collision with root package name */
    public View f60689c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f60690d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f60691e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f60692f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f60693g;

    /* renamed from: h  reason: collision with root package name */
    public g f60694h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.t.d.e.a.a f60695i;
    public int j;
    public d.a.j0.t.d.e.b.b k;
    public CustomMessageListener l;

    /* renamed from: d.a.j0.t.d.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1568a implements c.InterfaceC1567c {
        public C1568a() {
        }

        @Override // d.a.j0.t.d.e.a.c.InterfaceC1567c
        public void a(d.a.j0.t.d.e.b.b bVar) {
            a.this.k = bVar;
            a.this.m(bVar.f60681a.T(), bVar.f60682b);
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
                d.a.j0.t.d.d.a.c().g();
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
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f13332c) || a.this.k == null) {
                return;
            }
            if (updateAttentionMessage.getData().f13332c.equals(String.valueOf((a.this.k.f60681a == null || a.this.k.f60681a.T() == null) ? -100L : a.this.k.f60681a.T().getUserIdLong()))) {
                if (updateAttentionMessage.getData().f13330a) {
                    a.this.k.f60682b = true;
                    if (a.this.f60695i instanceof d.a.j0.t.d.e.a.c) {
                        a.this.f60695i.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                a.this.k.f60682b = false;
            }
        }
    }

    public a(TbPageContext tbPageContext, int i2) {
        this.f60688b = tbPageContext;
        this.f60687a = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.j = i2;
        j();
    }

    public void e() {
        this.f60691e.z();
    }

    public final void f() {
        int i2 = this.j;
        if (i2 == 0) {
            this.f60695i = new d.a.j0.t.d.e.a.b(this.f60688b);
        } else if (1 == i2) {
            this.f60695i = new d.a.j0.t.d.e.a.c(this.f60688b);
            n();
            ((d.a.j0.t.d.e.a.c) this.f60695i).i(new C1568a());
        }
        this.f60691e.setAdapter((ListAdapter) this.f60695i);
        this.f60691e.setOnScrollListener(new b(this));
    }

    public ViewGroup g() {
        return this.f60690d;
    }

    public View h() {
        return this.f60689c;
    }

    public final void i() {
        f();
    }

    public void j() {
        ColorDrawable colorDrawable;
        View inflate = LayoutInflater.from(this.f60687a).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.f60689c = inflate;
        inflate.setPadding(0, (int) this.f60687a.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.f60690d = (FrameLayout) this.f60689c.findViewById(R.id.square_recent_history_container);
        this.f60691e = (BdListView) this.f60689c.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.f60687a.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
        } else {
            colorDrawable = new ColorDrawable(this.f60687a.getPageContext().getResources().getColor(R.color.CAM_X0204));
        }
        this.f60691e.setDivider(colorDrawable);
        this.f60691e.setDividerHeight(this.f60687a.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.f60692f = (NoNetworkView) this.f60689c.findViewById(R.id.square_recent_history_network);
        g gVar = new g(this.f60688b);
        this.f60694h = gVar;
        gVar.Z(this.f60687a.getUniqueId());
        this.f60691e.setPullRefresh(this.f60694h);
        PbListView pbListView = new PbListView(this.f60687a);
        this.f60693g = pbListView;
        pbListView.a();
        i();
    }

    public void k(int i2) {
        NoNetworkView noNetworkView = this.f60692f;
        if (noNetworkView != null) {
            noNetworkView.c(this.f60688b, i2);
        }
    }

    public void l() {
        if (this.l != null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void m(MetaData metaData, boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.f60688b.getPageActivity());
            return;
        }
        String valueOf = String.valueOf(metaData.getUserId());
        AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
    }

    public final void n() {
        this.l = new c(2001115);
        MessageManager.getInstance().registerListener(this.l);
    }

    public void o(List<d.a.j0.t.d.e.b.b> list, boolean z) {
        d.a.j0.t.d.e.a.a aVar = this.f60695i;
        if (aVar instanceof d.a.j0.t.d.e.a.b) {
            aVar.c(list);
        } else if (aVar instanceof d.a.j0.t.d.e.a.c) {
            aVar.c(list);
        }
        if (z) {
            s();
        } else {
            t();
        }
    }

    public void p(f.g gVar) {
        this.f60694h.a(gVar);
    }

    public void q() {
        this.f60691e.setNextPage(null);
    }

    public void r(BdListView.p pVar) {
        this.f60691e.setOnSrollToBottomListener(pVar);
    }

    public final void s() {
        PbListView pbListView = this.f60693g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f60691e.setNextPage(this.f60693g);
            }
            this.f60693g.M();
            this.f60693g.O();
        }
    }

    public final void t() {
        PbListView pbListView = this.f60693g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f60691e.setNextPage(this.f60693g);
            }
            this.f60693g.A(this.f60687a.getPageContext().getResources().getString(R.string.list_no_more));
            this.f60693g.f();
        }
    }
}
