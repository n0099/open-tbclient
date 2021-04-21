package d.b.j0.e1.f.j;

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
import d.b.j0.e1.l.c.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<OfficialBarFeedActivity> f55678e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.j0.e1.l.c.b> f55679f = null;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<d.b.j0.e1.i.a.b.b> f55680g = null;

    /* renamed from: h  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f55681h;
    public BdTypeListView i;
    public boolean j;

    /* loaded from: classes4.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<b> {
        public a(f fVar, View view, b bVar) {
            super(view, bVar);
        }
    }

    public f(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, OfficialBarFeedMsglistAdapter.c cVar) {
        this.f55678e = tbPageContext;
        this.f55681h = cVar;
        this.i = bdTypeListView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.j0.e1.l.c.b getItem(int i) {
        List<d.b.j0.e1.l.c.b> list = this.f55679f;
        if (list == null || list.size() == 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.f55679f.get(i);
    }

    public final View b(int i, View view, ViewGroup viewGroup, d.b.j0.e1.l.c.b bVar, MsgCommonItemAdapter.MsgViewHolder<b> msgViewHolder) {
        b b2 = msgViewHolder.b();
        a.C1289a f2 = bVar.f();
        f2.m = bVar.c();
        LongSparseArray<d.b.j0.e1.i.a.b.b> longSparseArray = this.f55680g;
        b2.k(this.f55678e.getPageActivity().getBaseContext(), f2, bVar.d(), longSparseArray == null ? null : longSparseArray.get(f2.f55857h), bVar.g(), bVar.h(), i);
        StatisticItem statisticItem = new StatisticItem(this.j ? "c13865" : "c13863");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        String str = f2.n;
        if (str == null) {
            str = "";
        }
        statisticItem.param("tid", str);
        statisticItem.param("fid", f2.f55854e);
        TiebaStatic.log(statisticItem);
        return view;
    }

    public void c(List<d.b.j0.e1.l.c.b> list) {
        if (this.f55679f == null) {
            this.f55679f = new LinkedList();
        }
        this.f55679f.clear();
        this.f55679f.addAll(list);
        notifyDataSetChanged();
    }

    public void d(boolean z) {
        this.j = z;
    }

    @RequiresApi(api = 16)
    public void e(LongSparseArray<d.b.j0.e1.i.a.b.b> longSparseArray) {
        if (this.f55680g == null) {
            this.f55680g = new LongSparseArray<>();
        }
        this.f55680g.clear();
        for (int i = 0; i < longSparseArray.size(); i++) {
            this.f55680g.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.j0.e1.l.c.b> list = this.f55679f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = view != null ? (a) view.getTag() : null;
        if (aVar2 == null) {
            b bVar = new b(this.f55678e, this.j);
            bVar.l(this.f55681h);
            View e2 = bVar.e();
            a aVar3 = new a(this, bVar.e(), bVar);
            e2.setTag(aVar3);
            view = e2;
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        b(i, view, viewGroup, getItem(i), aVar);
        return view;
    }
}
