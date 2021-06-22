package d.a.o0.g1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationTextItemAdapter;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f58965a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58966b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.g0.g.a f58967c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f58968d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f58969e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f58970f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f58971g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialNotificationFragment f58972h;
    public OfficialNotificationTextItemAdapter k;
    public boolean l;
    public boolean m;

    /* renamed from: i  reason: collision with root package name */
    public List<ChatMessage> f58973i = null;
    public List<d.a.c.k.e.a> j = new ArrayList();
    public RecyclerView.OnScrollListener n = new a();

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2) {
                    b.this.f58969e.c();
                }
            } else if (recyclerView.canScrollVertically(-1)) {
                b.this.f58969e.c();
            } else {
                b.this.f58969e.a();
            }
        }
    }

    /* renamed from: d.a.o0.g1.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1412b implements BdListView.p {
        public C1412b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            b.this.f58967c.d();
            if (!b.this.f58972h.J0() || b.this.m) {
                b.this.f58967c.g(R.string.no_more_msg);
                return;
            }
            b.this.f58967c.f(R.string.loading);
            if (b.this.f58972h != null) {
                b.this.f58972h.N0();
                b.this.m = true;
            }
        }
    }

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext == null) {
            return;
        }
        this.f58970f = tbPageContext;
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) tbPageContext.getPageActivity();
        this.f58971g = baseFragmentActivity;
        this.f58972h = officialNotificationFragment;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.fragment_official_notification, viewGroup, false);
        this.f58965a = viewGroup2;
        this.f58969e = (NavigationBarShadowView) viewGroup2.findViewById(R.id.navi_shadow_view_official_notification);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f58965a.findViewById(R.id.rv_official_notification);
        this.f58966b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f58971g));
        this.f58966b.setFadingEdgeLength(0);
        this.f58966b.setOverScrollMode(2);
        this.f58966b.addOnScrollListener(this.n);
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = new OfficialNotificationTextItemAdapter(this.f58970f, ChatMessage.TYPE_MSG_LEFT);
        this.k = officialNotificationTextItemAdapter;
        officialNotificationTextItemAdapter.s0(officialNotificationFragment);
        this.j.add(this.k);
        this.f58966b.a(this.j);
        d.a.n0.g0.g.a aVar = new d.a.n0.g0.g.a(this.f58971g, this.f58966b);
        this.f58967c = aVar;
        aVar.h(l.g(this.f58971g, R.dimen.tbds182));
        this.f58967c.a();
        this.f58966b.setNextPage(this.f58967c);
        this.f58966b.setOnSrollToBottomListener(new C1412b());
        j();
    }

    public void f(MsgPageData msgPageData) {
        if (this.f58966b == null || msgPageData == null) {
            return;
        }
        p(msgPageData.getChatMessages());
        this.f58966b.getAdapter().notifyDataSetChanged();
    }

    public final boolean g(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58966b;
        return (bdTypeRecyclerView == null || this.f58973i == null || bdTypeRecyclerView.getFirstVisiblePosition() != 0) ? false : true;
    }

    public final void h(MsgPageData msgPageData, int i2) {
        if (this.f58966b == null) {
            return;
        }
        this.m = false;
        if (msgPageData == null) {
            return;
        }
        try {
            p(msgPageData.getChatMessages());
            this.f58966b.getAdapter().notifyDataSetChanged();
            if (i2 >= 0) {
                this.f58966b.setSelection(i2);
            }
        } catch (Exception unused) {
        }
    }

    public View i() {
        return this.f58965a;
    }

    public void j() {
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = this.k;
        if (officialNotificationTextItemAdapter != null) {
            officialNotificationTextItemAdapter.L();
        }
        SkinManager.setBackgroundColor(this.f58966b, R.color.CAM_X0201);
        NoDataView noDataView = this.f58968d;
        if (noDataView != null) {
            noDataView.f(this.f58970f, TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.f58968d, R.color.CAM_X0201);
        }
        d.a.n0.g0.g.a aVar = this.f58967c;
        if (aVar != null) {
            aVar.onChangeSkinType(this.f58970f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void k(MsgPageData msgPageData) {
        if (msgPageData == null) {
            return;
        }
        try {
            if (msgPageData.getIsNewAdd() ? g(msgPageData.getNewAddNum()) : false) {
                l(msgPageData);
            } else {
                m(msgPageData);
            }
        } catch (Exception unused) {
            h(msgPageData, -1);
        }
    }

    public void l(MsgPageData msgPageData) {
        if (msgPageData == null) {
            return;
        }
        try {
            o(msgPageData);
            h(msgPageData, 0);
        } catch (Exception unused) {
            h(msgPageData, -1);
        }
    }

    public void m(MsgPageData msgPageData) {
        h(msgPageData, -1);
    }

    public void n(MsgPageData msgPageData) {
        try {
            h(msgPageData, -1);
        } catch (Exception unused) {
            h(msgPageData, -1);
        }
    }

    public final void o(MsgPageData msgPageData) {
        int size;
        if (msgPageData == null || msgPageData.getChatMessages() == null || msgPageData.getChatMessages().size() == 0 || (size = msgPageData.getChatMessages().size()) <= 100) {
            return;
        }
        int i2 = size - 100;
        for (int i3 = 0; i3 < i2; i3++) {
            msgPageData.getChatMessages().remove(0);
        }
    }

    public void p(List<ChatMessage> list) {
        if (this.f58966b == null) {
            return;
        }
        this.f58973i = list;
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            arrayList.add(list.get(size));
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 > 0) {
                if (list.get(i2).getCacheData() == null) {
                    list.get(i2).setCacheData(new MsgCacheData());
                }
                list.get(i2).getCacheData().setLastMsgTime(list.get(i2 - 1).getTime());
            }
        }
        arrayList2.addAll(arrayList);
        if (arrayList2.isEmpty()) {
            if (this.f58968d == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f58971g, null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f58971g.getResources().getString(R.string.official_notification_no_data)), null);
                this.f58968d = a2;
                a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f58968d, R.color.CAM_X0201);
                this.f58965a.addView(this.f58968d);
            }
            if (this.l) {
                return;
            }
            this.l = true;
            this.f58966b.setVisibility(8);
            this.f58968d.setVisibility(0);
            this.f58968d.f(this.f58970f, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        NoDataView noDataView = this.f58968d;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.l = false;
        this.f58966b.setData(arrayList2);
        this.f58966b.setVisibility(0);
    }
}
