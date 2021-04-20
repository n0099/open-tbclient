package d.b.i0.b1.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f53296e;

    /* renamed from: f  reason: collision with root package name */
    public int f53297f;

    /* renamed from: g  reason: collision with root package name */
    public ItemViewHolder f53298g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f53299h;
    public final ArrayList<ItemViewHolder> i = new ArrayList<>();
    public View.OnClickListener j;

    public b(Context context, int i, ItemViewHolder itemViewHolder) {
        this.f53296e = LayoutInflater.from(context);
        this.f53297f = i;
        this.f53298g = itemViewHolder;
    }

    public final void a(ItemViewHolder itemViewHolder, c cVar) {
        if (cVar == null || itemViewHolder == null) {
            return;
        }
        itemViewHolder.b(cVar);
    }

    public void b(int i) {
        if (ListUtils.getCount(this.i) > 0) {
            Iterator<ItemViewHolder> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().d(i);
            }
        }
    }

    public void c(List<c> list) {
        this.f53299h = list;
    }

    public void d(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f53299h);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return ListUtils.getItem(this.f53299h, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (ListUtils.getItem(this.f53299h, i) == null) {
            return -1L;
        }
        return ((c) ListUtils.getItem(this.f53299h, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f53296e.inflate(this.f53297f, viewGroup, false);
            ItemViewHolder c2 = this.f53298g.c(view);
            c2.e(this.j);
            view.setTag(c2);
            this.i.add(c2);
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        if (ListUtils.getItem(this.f53299h, i) != null) {
            a(itemViewHolder, this.f53299h.get(i));
        }
        return itemViewHolder.a();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
