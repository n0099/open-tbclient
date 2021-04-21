package d.b.j0.f1.b.q;

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
    public ViewGroup f56370a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f56371b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.g0.g.a f56372c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f56373d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f56374e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f56375f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f56376g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialNotificationFragment f56377h;
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
                    b.this.f56374e.c();
                }
            } else if (recyclerView.canScrollVertically(-1)) {
                b.this.f56374e.c();
            } else {
                b.this.f56374e.a();
            }
        }
    }

    /* renamed from: d.b.j0.f1.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1323b implements BdListView.p {
        public C1323b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            b.this.f56372c.d();
            if (!b.this.f56377h.H0() || b.this.m) {
                b.this.f56372c.g(R.string.no_more_msg);
                return;
            }
            b.this.f56372c.f(R.string.loading);
            if (b.this.f56377h != null) {
                b.this.f56377h.L0();
                b.this.m = true;
            }
        }
    }

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext == null) {
            return;
        }
        this.f56375f = tbPageContext;
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) tbPageContext.getPageActivity();
        this.f56376g = baseFragmentActivity;
        this.f56377h = officialNotificationFragment;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.fragment_official_notification, viewGroup, false);
        this.f56370a = viewGroup2;
        this.f56374e = (NavigationBarShadowView) viewGroup2.findViewById(R.id.navi_shadow_view_official_notification);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f56370a.findViewById(R.id.rv_official_notification);
        this.f56371b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f56376g));
        this.f56371b.setFadingEdgeLength(0);
        this.f56371b.setOverScrollMode(2);
        this.f56371b.addOnScrollListener(this.n);
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = new OfficialNotificationTextItemAdapter(this.f56375f, ChatMessage.TYPE_MSG_LEFT);
        this.k = officialNotificationTextItemAdapter;
        officialNotificationTextItemAdapter.s0(officialNotificationFragment);
        this.j.add(this.k);
        this.f56371b.a(this.j);
        d.b.i0.g0.g.a aVar = new d.b.i0.g0.g.a(this.f56376g, this.f56371b);
        this.f56372c = aVar;
        aVar.h(l.g(this.f56376g, R.dimen.tbds182));
        this.f56372c.a();
        this.f56371b.setNextPage(this.f56372c);
        this.f56371b.setOnSrollToBottomListener(new C1323b());
        j();
    }

    public void f(MsgPageData msgPageData) {
        if (this.f56371b == null || msgPageData == null) {
            return;
        }
        p(msgPageData.getChatMessages());
        this.f56371b.getAdapter().notifyDataSetChanged();
    }

    public final boolean g(int i) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f56371b;
        return (bdTypeRecyclerView == null || this.i == null || bdTypeRecyclerView.getFirstVisiblePosition() != 0) ? false : true;
    }

    public final void h(MsgPageData msgPageData, int i) {
        if (this.f56371b == null) {
            return;
        }
        this.m = false;
        if (msgPageData == null) {
            return;
        }
        try {
            p(msgPageData.getChatMessages());
            this.f56371b.getAdapter().notifyDataSetChanged();
            if (i >= 0) {
                this.f56371b.setSelection(i);
            }
        } catch (Exception unused) {
        }
    }

    public View i() {
        return this.f56370a;
    }

    public void j() {
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = this.k;
        if (officialNotificationTextItemAdapter != null) {
            officialNotificationTextItemAdapter.L();
        }
        SkinManager.setBackgroundColor(this.f56371b, R.color.CAM_X0201);
        NoDataView noDataView = this.f56373d;
        if (noDataView != null) {
            noDataView.f(this.f56375f, TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.f56373d, R.color.CAM_X0201);
        }
        d.b.i0.g0.g.a aVar = this.f56372c;
        if (aVar != null) {
            aVar.onChangeSkinType(this.f56375f, TbadkCoreApplication.getInst().getSkinType());
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
        if (this.f56371b == null) {
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
            if (this.f56373d == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f56376g, null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f56376g.getResources().getString(R.string.official_notification_no_data)), null);
                this.f56373d = a2;
                a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f56373d, R.color.CAM_X0201);
                this.f56370a.addView(this.f56373d);
            }
            if (this.l) {
                return;
            }
            this.l = true;
            this.f56371b.setVisibility(8);
            this.f56373d.setVisibility(0);
            this.f56373d.f(this.f56375f, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        NoDataView noDataView = this.f56373d;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.l = false;
        this.f56371b.setData(arrayList2);
        this.f56371b.setVisibility(0);
    }
}
