package d.b.i0.e1.f.j;

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
import d.b.i0.e1.l.c.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<OfficialBarFeedActivity> f55257e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.e1.l.c.b> f55258f = null;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<d.b.i0.e1.i.a.b.b> f55259g = null;

    /* renamed from: h  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f55260h;
    public BdTypeListView i;
    public boolean j;

    /* loaded from: classes4.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<b> {
        public a(f fVar, View view, b bVar) {
            super(view, bVar);
        }
    }

    public f(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, OfficialBarFeedMsglistAdapter.c cVar) {
        this.f55257e = tbPageContext;
        this.f55260h = cVar;
        this.i = bdTypeListView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.i0.e1.l.c.b getItem(int i) {
        List<d.b.i0.e1.l.c.b> list = this.f55258f;
        if (list == null || list.size() == 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.f55258f.get(i);
    }

    public final View b(int i, View view, ViewGroup viewGroup, d.b.i0.e1.l.c.b bVar, MsgCommonItemAdapter.MsgViewHolder<b> msgViewHolder) {
        b b2 = msgViewHolder.b();
        a.C1266a f2 = bVar.f();
        f2.m = bVar.c();
        LongSparseArray<d.b.i0.e1.i.a.b.b> longSparseArray = this.f55259g;
        b2.k(this.f55257e.getPageActivity().getBaseContext(), f2, bVar.d(), longSparseArray == null ? null : longSparseArray.get(f2.f55436h), bVar.g(), bVar.h(), i);
        StatisticItem statisticItem = new StatisticItem(this.j ? "c13865" : "c13863");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        String str = f2.n;
        if (str == null) {
            str = "";
        }
        statisticItem.param("tid", str);
        statisticItem.param("fid", f2.f55433e);
        TiebaStatic.log(statisticItem);
        return view;
    }

    public void c(List<d.b.i0.e1.l.c.b> list) {
        if (this.f55258f == null) {
            this.f55258f = new LinkedList();
        }
        this.f55258f.clear();
        this.f55258f.addAll(list);
        notifyDataSetChanged();
    }

    public void d(boolean z) {
        this.j = z;
    }

    @RequiresApi(api = 16)
    public void e(LongSparseArray<d.b.i0.e1.i.a.b.b> longSparseArray) {
        if (this.f55259g == null) {
            this.f55259g = new LongSparseArray<>();
        }
        this.f55259g.clear();
        for (int i = 0; i < longSparseArray.size(); i++) {
            this.f55259g.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.e1.l.c.b> list = this.f55258f;
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
            b bVar = new b(this.f55257e, this.j);
            bVar.l(this.f55260h);
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
