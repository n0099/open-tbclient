package d.b.i0.d1.f.j;

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
import d.b.i0.d1.l.c.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<OfficialBarFeedActivity> f53734e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.d1.l.c.b> f53735f = null;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<d.b.i0.d1.i.a.b.b> f53736g = null;

    /* renamed from: h  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f53737h;
    public BdTypeListView i;
    public boolean j;

    /* loaded from: classes4.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<b> {
        public a(f fVar, View view, b bVar) {
            super(view, bVar);
        }
    }

    public f(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, OfficialBarFeedMsglistAdapter.c cVar) {
        this.f53734e = tbPageContext;
        this.f53737h = cVar;
        this.i = bdTypeListView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.i0.d1.l.c.b getItem(int i) {
        List<d.b.i0.d1.l.c.b> list = this.f53735f;
        if (list == null || list.size() == 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.f53735f.get(i);
    }

    public final View b(int i, View view, ViewGroup viewGroup, d.b.i0.d1.l.c.b bVar, MsgCommonItemAdapter.MsgViewHolder<b> msgViewHolder) {
        b b2 = msgViewHolder.b();
        a.C1202a f2 = bVar.f();
        f2.m = bVar.c();
        LongSparseArray<d.b.i0.d1.i.a.b.b> longSparseArray = this.f53736g;
        b2.k(this.f53734e.getPageActivity().getBaseContext(), f2, bVar.d(), longSparseArray == null ? null : longSparseArray.get(f2.f53913h), bVar.g(), bVar.h(), i);
        StatisticItem statisticItem = new StatisticItem(this.j ? "c13865" : "c13863");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        String str = f2.n;
        if (str == null) {
            str = "";
        }
        statisticItem.param("tid", str);
        statisticItem.param("fid", f2.f53910e);
        TiebaStatic.log(statisticItem);
        return view;
    }

    public void c(List<d.b.i0.d1.l.c.b> list) {
        if (this.f53735f == null) {
            this.f53735f = new LinkedList();
        }
        this.f53735f.clear();
        this.f53735f.addAll(list);
        notifyDataSetChanged();
    }

    public void d(boolean z) {
        this.j = z;
    }

    @RequiresApi(api = 16)
    public void e(LongSparseArray<d.b.i0.d1.i.a.b.b> longSparseArray) {
        if (this.f53736g == null) {
            this.f53736g = new LongSparseArray<>();
        }
        this.f53736g.clear();
        for (int i = 0; i < longSparseArray.size(); i++) {
            this.f53736g.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.d1.l.c.b> list = this.f53735f;
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
            b bVar = new b(this.f53734e, this.j);
            bVar.l(this.f53737h);
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
