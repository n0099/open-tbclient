package d.a.j0.f1.b.q;

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
    public ViewGroup f54256a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f54257b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.g0.g.a f54258c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f54259d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f54260e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f54261f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f54262g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialNotificationFragment f54263h;
    public OfficialNotificationTextItemAdapter k;
    public boolean l;
    public boolean m;

    /* renamed from: i  reason: collision with root package name */
    public List<ChatMessage> f54264i = null;
    public List<d.a.c.j.e.a> j = new ArrayList();
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
                    b.this.f54260e.c();
                }
            } else if (recyclerView.canScrollVertically(-1)) {
                b.this.f54260e.c();
            } else {
                b.this.f54260e.a();
            }
        }
    }

    /* renamed from: d.a.j0.f1.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1262b implements BdListView.p {
        public C1262b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            b.this.f54258c.d();
            if (!b.this.f54263h.H0() || b.this.m) {
                b.this.f54258c.g(R.string.no_more_msg);
                return;
            }
            b.this.f54258c.f(R.string.loading);
            if (b.this.f54263h != null) {
                b.this.f54263h.L0();
                b.this.m = true;
            }
        }
    }

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext == null) {
            return;
        }
        this.f54261f = tbPageContext;
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) tbPageContext.getPageActivity();
        this.f54262g = baseFragmentActivity;
        this.f54263h = officialNotificationFragment;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.fragment_official_notification, viewGroup, false);
        this.f54256a = viewGroup2;
        this.f54260e = (NavigationBarShadowView) viewGroup2.findViewById(R.id.navi_shadow_view_official_notification);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f54256a.findViewById(R.id.rv_official_notification);
        this.f54257b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f54262g));
        this.f54257b.setFadingEdgeLength(0);
        this.f54257b.setOverScrollMode(2);
        this.f54257b.addOnScrollListener(this.n);
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = new OfficialNotificationTextItemAdapter(this.f54261f, ChatMessage.TYPE_MSG_LEFT);
        this.k = officialNotificationTextItemAdapter;
        officialNotificationTextItemAdapter.r0(officialNotificationFragment);
        this.j.add(this.k);
        this.f54257b.a(this.j);
        d.a.i0.g0.g.a aVar = new d.a.i0.g0.g.a(this.f54262g, this.f54257b);
        this.f54258c = aVar;
        aVar.h(l.g(this.f54262g, R.dimen.tbds182));
        this.f54258c.a();
        this.f54257b.setNextPage(this.f54258c);
        this.f54257b.setOnSrollToBottomListener(new C1262b());
        j();
    }

    public void f(MsgPageData msgPageData) {
        if (this.f54257b == null || msgPageData == null) {
            return;
        }
        p(msgPageData.getChatMessages());
        this.f54257b.getAdapter().notifyDataSetChanged();
    }

    public final boolean g(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f54257b;
        return (bdTypeRecyclerView == null || this.f54264i == null || bdTypeRecyclerView.getFirstVisiblePosition() != 0) ? false : true;
    }

    public final void h(MsgPageData msgPageData, int i2) {
        if (this.f54257b == null) {
            return;
        }
        this.m = false;
        if (msgPageData == null) {
            return;
        }
        try {
            p(msgPageData.getChatMessages());
            this.f54257b.getAdapter().notifyDataSetChanged();
            if (i2 >= 0) {
                this.f54257b.setSelection(i2);
            }
        } catch (Exception unused) {
        }
    }

    public View i() {
        return this.f54256a;
    }

    public void j() {
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = this.k;
        if (officialNotificationTextItemAdapter != null) {
            officialNotificationTextItemAdapter.K();
        }
        SkinManager.setBackgroundColor(this.f54257b, R.color.CAM_X0201);
        NoDataView noDataView = this.f54259d;
        if (noDataView != null) {
            noDataView.f(this.f54261f, TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.f54259d, R.color.CAM_X0201);
        }
        d.a.i0.g0.g.a aVar = this.f54258c;
        if (aVar != null) {
            aVar.onChangeSkinType(this.f54261f, TbadkCoreApplication.getInst().getSkinType());
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
        if (this.f54257b == null) {
            return;
        }
        this.f54264i = list;
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
            if (this.f54259d == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f54262g, null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f54262g.getResources().getString(R.string.official_notification_no_data)), null);
                this.f54259d = a2;
                a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f54259d, R.color.CAM_X0201);
                this.f54256a.addView(this.f54259d);
            }
            if (this.l) {
                return;
            }
            this.l = true;
            this.f54257b.setVisibility(8);
            this.f54259d.setVisibility(0);
            this.f54259d.f(this.f54261f, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        NoDataView noDataView = this.f54259d;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.l = false;
        this.f54257b.setData(arrayList2);
        this.f54257b.setVisibility(0);
    }
}
