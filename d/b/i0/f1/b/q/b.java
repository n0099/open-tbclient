package d.b.i0.f1.b.q;

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
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f55949a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55950b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.g0.g.a f55951c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f55952d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f55953e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f55954f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f55955g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialNotificationFragment f55956h;
    public OfficialNotificationTextItemAdapter k;
    public boolean l;
    public boolean m;
    public List<ChatMessage> i = null;
    public List<d.b.c.j.e.a> j = new ArrayList();
    public RecyclerView.OnScrollListener n = new a();

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i != 0) {
                if (i == 1 || i == 2) {
                    b.this.f55953e.c();
                }
            } else if (recyclerView.canScrollVertically(-1)) {
                b.this.f55953e.c();
            } else {
                b.this.f55953e.a();
            }
        }
    }

    /* renamed from: d.b.i0.f1.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1300b implements BdListView.p {
        public C1300b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            b.this.f55951c.d();
            if (!b.this.f55956h.H0() || b.this.m) {
                b.this.f55951c.g(R.string.no_more_msg);
                return;
            }
            b.this.f55951c.f(R.string.loading);
            if (b.this.f55956h != null) {
                b.this.f55956h.L0();
                b.this.m = true;
            }
        }
    }

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext == null) {
            return;
        }
        this.f55954f = tbPageContext;
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) tbPageContext.getPageActivity();
        this.f55955g = baseFragmentActivity;
        this.f55956h = officialNotificationFragment;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.fragment_official_notification, viewGroup, false);
        this.f55949a = viewGroup2;
        this.f55953e = (NavigationBarShadowView) viewGroup2.findViewById(R.id.navi_shadow_view_official_notification);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f55949a.findViewById(R.id.rv_official_notification);
        this.f55950b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f55955g));
        this.f55950b.setFadingEdgeLength(0);
        this.f55950b.setOverScrollMode(2);
        this.f55950b.addOnScrollListener(this.n);
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = new OfficialNotificationTextItemAdapter(this.f55954f, ChatMessage.TYPE_MSG_LEFT);
        this.k = officialNotificationTextItemAdapter;
        officialNotificationTextItemAdapter.s0(officialNotificationFragment);
        this.j.add(this.k);
        this.f55950b.a(this.j);
        d.b.h0.g0.g.a aVar = new d.b.h0.g0.g.a(this.f55955g, this.f55950b);
        this.f55951c = aVar;
        aVar.h(l.g(this.f55955g, R.dimen.tbds182));
        this.f55951c.a();
        this.f55950b.setNextPage(this.f55951c);
        this.f55950b.setOnSrollToBottomListener(new C1300b());
        j();
    }

    public void f(MsgPageData msgPageData) {
        if (this.f55950b == null || msgPageData == null) {
            return;
        }
        p(msgPageData.getChatMessages());
        this.f55950b.getAdapter().notifyDataSetChanged();
    }

    public final boolean g(int i) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55950b;
        return (bdTypeRecyclerView == null || this.i == null || bdTypeRecyclerView.getFirstVisiblePosition() != 0) ? false : true;
    }

    public final void h(MsgPageData msgPageData, int i) {
        if (this.f55950b == null) {
            return;
        }
        this.m = false;
        if (msgPageData == null) {
            return;
        }
        try {
            p(msgPageData.getChatMessages());
            this.f55950b.getAdapter().notifyDataSetChanged();
            if (i >= 0) {
                this.f55950b.setSelection(i);
            }
        } catch (Exception unused) {
        }
    }

    public View i() {
        return this.f55949a;
    }

    public void j() {
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = this.k;
        if (officialNotificationTextItemAdapter != null) {
            officialNotificationTextItemAdapter.L();
        }
        SkinManager.setBackgroundColor(this.f55950b, R.color.CAM_X0201);
        NoDataView noDataView = this.f55952d;
        if (noDataView != null) {
            noDataView.f(this.f55954f, TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.f55952d, R.color.CAM_X0201);
        }
        d.b.h0.g0.g.a aVar = this.f55951c;
        if (aVar != null) {
            aVar.onChangeSkinType(this.f55954f, TbadkCoreApplication.getInst().getSkinType());
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
        int i = size - 100;
        for (int i2 = 0; i2 < i; i2++) {
            msgPageData.getChatMessages().remove(0);
        }
    }

    public void p(List<ChatMessage> list) {
        if (this.f55950b == null) {
            return;
        }
        this.i = list;
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            arrayList.add(list.get(size));
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        for (int i = 0; i < size2; i++) {
            if (i > 0) {
                if (list.get(i).getCacheData() == null) {
                    list.get(i).setCacheData(new MsgCacheData());
                }
                list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
            }
        }
        arrayList2.addAll(arrayList);
        if (arrayList2.isEmpty()) {
            if (this.f55952d == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f55955g, null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f55955g.getResources().getString(R.string.official_notification_no_data)), null);
                this.f55952d = a2;
                a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f55952d, R.color.CAM_X0201);
                this.f55949a.addView(this.f55952d);
            }
            if (this.l) {
                return;
            }
            this.l = true;
            this.f55950b.setVisibility(8);
            this.f55952d.setVisibility(0);
            this.f55952d.f(this.f55954f, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        NoDataView noDataView = this.f55952d;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.l = false;
        this.f55950b.setData(arrayList2);
        this.f55950b.setVisibility(0);
    }
}
