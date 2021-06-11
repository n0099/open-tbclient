package d.a.n0.f1.f.j;

import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RequiresApi;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import d.a.n0.f1.l.c.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<OfficialBarFeedActivity> f58117e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.n0.f1.l.c.b> f58118f = null;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<d.a.n0.f1.i.a.b.b> f58119g = null;

    /* renamed from: h  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f58120h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f58121i;
    public boolean j;

    /* loaded from: classes4.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<b> {
        public a(f fVar, View view, b bVar) {
            super(view, bVar);
        }
    }

    public f(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, OfficialBarFeedMsglistAdapter.c cVar) {
        this.f58117e = tbPageContext;
        this.f58120h = cVar;
        this.f58121i = bdTypeListView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.n0.f1.l.c.b getItem(int i2) {
        List<d.a.n0.f1.l.c.b> list = this.f58118f;
        if (list == null || list.size() == 0 || i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f58118f.get(i2);
    }

    public final View b(int i2, View view, ViewGroup viewGroup, d.a.n0.f1.l.c.b bVar, MsgCommonItemAdapter.MsgViewHolder<b> msgViewHolder) {
        b b2 = msgViewHolder.b();
        a.C1374a d2 = bVar.d();
        d2.m = bVar.b();
        LongSparseArray<d.a.n0.f1.i.a.b.b> longSparseArray = this.f58119g;
        b2.k(this.f58117e.getPageActivity().getBaseContext(), d2, bVar.c(), longSparseArray == null ? null : longSparseArray.get(d2.f58303h), bVar.f(), bVar.g(), i2);
        StatisticItem statisticItem = new StatisticItem(this.j ? "c13865" : "c13863");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        String str = d2.n;
        if (str == null) {
            str = "";
        }
        statisticItem.param("tid", str);
        statisticItem.param("fid", d2.f58300e);
        TiebaStatic.log(statisticItem);
        return view;
    }

    public void c(List<d.a.n0.f1.l.c.b> list) {
        if (this.f58118f == null) {
            this.f58118f = new LinkedList();
        }
        this.f58118f.clear();
        this.f58118f.addAll(list);
        notifyDataSetChanged();
    }

    public void d(boolean z) {
        this.j = z;
    }

    @RequiresApi(api = 16)
    public void e(LongSparseArray<d.a.n0.f1.i.a.b.b> longSparseArray) {
        if (this.f58119g == null) {
            this.f58119g = new LongSparseArray<>();
        }
        this.f58119g.clear();
        for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
            this.f58119g.put(longSparseArray.keyAt(i2), longSparseArray.valueAt(i2));
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.n0.f1.l.c.b> list = this.f58118f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = view != null ? (a) view.getTag() : null;
        if (aVar2 == null) {
            b bVar = new b(this.f58117e, this.j);
            bVar.l(this.f58120h);
            View e2 = bVar.e();
            a aVar3 = new a(this, bVar.e(), bVar);
            e2.setTag(aVar3);
            view = e2;
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        b(i2, view, viewGroup, getItem(i2), aVar);
        return view;
    }
}
