package d.a.k0.e1.f.j;

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
import d.a.k0.e1.l.c.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<OfficialBarFeedActivity> f54238e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.k0.e1.l.c.b> f54239f = null;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<d.a.k0.e1.i.a.b.b> f54240g = null;

    /* renamed from: h  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f54241h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f54242i;
    public boolean j;

    /* loaded from: classes4.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<b> {
        public a(f fVar, View view, b bVar) {
            super(view, bVar);
        }
    }

    public f(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, OfficialBarFeedMsglistAdapter.c cVar) {
        this.f54238e = tbPageContext;
        this.f54241h = cVar;
        this.f54242i = bdTypeListView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.k0.e1.l.c.b getItem(int i2) {
        List<d.a.k0.e1.l.c.b> list = this.f54239f;
        if (list == null || list.size() == 0 || i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f54239f.get(i2);
    }

    public final View b(int i2, View view, ViewGroup viewGroup, d.a.k0.e1.l.c.b bVar, MsgCommonItemAdapter.MsgViewHolder<b> msgViewHolder) {
        b b2 = msgViewHolder.b();
        a.C1300a e2 = bVar.e();
        e2.m = bVar.b();
        LongSparseArray<d.a.k0.e1.i.a.b.b> longSparseArray = this.f54240g;
        b2.k(this.f54238e.getPageActivity().getBaseContext(), e2, bVar.d(), longSparseArray == null ? null : longSparseArray.get(e2.f54424h), bVar.g(), bVar.h(), i2);
        StatisticItem statisticItem = new StatisticItem(this.j ? "c13865" : "c13863");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        String str = e2.n;
        if (str == null) {
            str = "";
        }
        statisticItem.param("tid", str);
        statisticItem.param("fid", e2.f54421e);
        TiebaStatic.log(statisticItem);
        return view;
    }

    public void c(List<d.a.k0.e1.l.c.b> list) {
        if (this.f54239f == null) {
            this.f54239f = new LinkedList();
        }
        this.f54239f.clear();
        this.f54239f.addAll(list);
        notifyDataSetChanged();
    }

    public void d(boolean z) {
        this.j = z;
    }

    @RequiresApi(api = 16)
    public void e(LongSparseArray<d.a.k0.e1.i.a.b.b> longSparseArray) {
        if (this.f54240g == null) {
            this.f54240g = new LongSparseArray<>();
        }
        this.f54240g.clear();
        for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
            this.f54240g.put(longSparseArray.keyAt(i2), longSparseArray.valueAt(i2));
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.k0.e1.l.c.b> list = this.f54239f;
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
            b bVar = new b(this.f54238e, this.j);
            bVar.l(this.f54241h);
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
