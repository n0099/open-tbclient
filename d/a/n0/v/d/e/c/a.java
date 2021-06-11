package d.a.n0.v.d.e.c;

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
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import d.a.n0.v.d.e.a.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AlaRecentHistoryActivity f65413a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f65414b;

    /* renamed from: c  reason: collision with root package name */
    public View f65415c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f65416d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f65417e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f65418f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f65419g;

    /* renamed from: h  reason: collision with root package name */
    public g f65420h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.v.d.e.a.a f65421i;
    public int j;
    public d.a.n0.v.d.e.b.b k;
    public CustomMessageListener l;

    /* renamed from: d.a.n0.v.d.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1710a implements c.InterfaceC1709c {
        public C1710a() {
        }

        @Override // d.a.n0.v.d.e.a.c.InterfaceC1709c
        public void a(d.a.n0.v.d.e.b.b bVar) {
            a.this.k = bVar;
            a.this.m(bVar.f65407a.T(), bVar.f65408b);
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
                d.a.n0.v.d.d.a.c().g();
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
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12638c) || a.this.k == null) {
                return;
            }
            if (updateAttentionMessage.getData().f12638c.equals(String.valueOf((a.this.k.f65407a == null || a.this.k.f65407a.T() == null) ? -100L : a.this.k.f65407a.T().getUserIdLong()))) {
                if (updateAttentionMessage.getData().f12636a) {
                    a.this.k.f65408b = true;
                    if (a.this.f65421i instanceof d.a.n0.v.d.e.a.c) {
                        a.this.f65421i.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                a.this.k.f65408b = false;
            }
        }
    }

    public a(TbPageContext tbPageContext, int i2) {
        this.f65414b = tbPageContext;
        this.f65413a = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.j = i2;
        j();
    }

    public void e() {
        this.f65417e.z();
    }

    public final void f() {
        int i2 = this.j;
        if (i2 == 0) {
            this.f65421i = new d.a.n0.v.d.e.a.b(this.f65414b);
        } else if (1 == i2) {
            this.f65421i = new d.a.n0.v.d.e.a.c(this.f65414b);
            n();
            ((d.a.n0.v.d.e.a.c) this.f65421i).i(new C1710a());
        }
        this.f65417e.setAdapter((ListAdapter) this.f65421i);
        this.f65417e.setOnScrollListener(new b(this));
    }

    public ViewGroup g() {
        return this.f65416d;
    }

    public View h() {
        return this.f65415c;
    }

    public final void i() {
        f();
    }

    public void j() {
        ColorDrawable colorDrawable;
        View inflate = LayoutInflater.from(this.f65413a).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.f65415c = inflate;
        inflate.setPadding(0, (int) this.f65413a.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.f65416d = (FrameLayout) this.f65415c.findViewById(R.id.square_recent_history_container);
        this.f65417e = (BdListView) this.f65415c.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.f65413a.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
        } else {
            colorDrawable = new ColorDrawable(this.f65413a.getPageContext().getResources().getColor(R.color.CAM_X0204));
        }
        this.f65417e.setDivider(colorDrawable);
        this.f65417e.setDividerHeight(this.f65413a.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.f65418f = (NoNetworkView) this.f65415c.findViewById(R.id.square_recent_history_network);
        g gVar = new g(this.f65414b);
        this.f65420h = gVar;
        gVar.Z(this.f65413a.getUniqueId());
        this.f65417e.setPullRefresh(this.f65420h);
        PbListView pbListView = new PbListView(this.f65413a);
        this.f65419g = pbListView;
        pbListView.a();
        i();
    }

    public void k(int i2) {
        NoNetworkView noNetworkView = this.f65418f;
        if (noNetworkView != null) {
            noNetworkView.c(this.f65414b, i2);
        }
    }

    public void l() {
        if (this.l != null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void m(MetaData metaData, boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.f65414b.getPageActivity());
            return;
        }
        String valueOf = String.valueOf(metaData.getUserId());
        AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
    }

    public final void n() {
        this.l = new c(2001115);
        MessageManager.getInstance().registerListener(this.l);
    }

    public void o(List<d.a.n0.v.d.e.b.b> list, boolean z) {
        d.a.n0.v.d.e.a.a aVar = this.f65421i;
        if (aVar instanceof d.a.n0.v.d.e.a.b) {
            aVar.c(list);
        } else if (aVar instanceof d.a.n0.v.d.e.a.c) {
            aVar.c(list);
        }
        if (z) {
            s();
        } else {
            t();
        }
    }

    public void p(f.g gVar) {
        this.f65420h.a(gVar);
    }

    public void q() {
        this.f65417e.setNextPage(null);
    }

    public void r(BdListView.p pVar) {
        this.f65417e.setOnSrollToBottomListener(pVar);
    }

    public final void s() {
        PbListView pbListView = this.f65419g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f65417e.setNextPage(this.f65419g);
            }
            this.f65419g.M();
            this.f65419g.O();
        }
    }

    public final void t() {
        PbListView pbListView = this.f65419g;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f65417e.setNextPage(this.f65419g);
            }
            this.f65419g.A(this.f65413a.getPageContext().getResources().getString(R.string.list_no_more));
            this.f65419g.f();
        }
    }
}
