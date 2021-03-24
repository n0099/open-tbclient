package d.b.i0.a1.b;

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
    public LayoutInflater f51875e;

    /* renamed from: f  reason: collision with root package name */
    public int f51876f;

    /* renamed from: g  reason: collision with root package name */
    public ItemViewHolder f51877g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f51878h;
    public final ArrayList<ItemViewHolder> i = new ArrayList<>();
    public View.OnClickListener j;

    public b(Context context, int i, ItemViewHolder itemViewHolder) {
        this.f51875e = LayoutInflater.from(context);
        this.f51876f = i;
        this.f51877g = itemViewHolder;
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
        this.f51878h = list;
    }

    public void d(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f51878h);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return ListUtils.getItem(this.f51878h, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (ListUtils.getItem(this.f51878h, i) == null) {
            return -1L;
        }
        return ((c) ListUtils.getItem(this.f51878h, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f51875e.inflate(this.f51876f, viewGroup, false);
            ItemViewHolder c2 = this.f51877g.c(view);
            c2.e(this.j);
            view.setTag(c2);
            this.i.add(c2);
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        if (ListUtils.getItem(this.f51878h, i) != null) {
            a(itemViewHolder, this.f51878h.get(i));
        }
        return itemViewHolder.a();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
