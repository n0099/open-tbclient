package d.a.o0.c1.b;

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
    public LayoutInflater f56134e;

    /* renamed from: f  reason: collision with root package name */
    public int f56135f;

    /* renamed from: g  reason: collision with root package name */
    public ItemViewHolder f56136g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f56137h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f56138i = new ArrayList<>();
    public View.OnClickListener j;

    public b(Context context, int i2, ItemViewHolder itemViewHolder) {
        this.f56134e = LayoutInflater.from(context);
        this.f56135f = i2;
        this.f56136g = itemViewHolder;
    }

    public final void a(ItemViewHolder itemViewHolder, c cVar) {
        if (cVar == null || itemViewHolder == null) {
            return;
        }
        itemViewHolder.b(cVar);
    }

    public void b(int i2) {
        if (ListUtils.getCount(this.f56138i) > 0) {
            Iterator<ItemViewHolder> it = this.f56138i.iterator();
            while (it.hasNext()) {
                it.next().d(i2);
            }
        }
    }

    public void c(List<c> list) {
        this.f56137h = list;
    }

    public void d(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f56137h);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return ListUtils.getItem(this.f56137h, i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        if (ListUtils.getItem(this.f56137h, i2) == null) {
            return -1L;
        }
        return ((c) ListUtils.getItem(this.f56137h, i2)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f56134e.inflate(this.f56135f, viewGroup, false);
            ItemViewHolder c2 = this.f56136g.c(view);
            c2.e(this.j);
            view.setTag(c2);
            this.f56138i.add(c2);
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        if (ListUtils.getItem(this.f56137h, i2) != null) {
            a(itemViewHolder, this.f56137h.get(i2));
        }
        return itemViewHolder.a();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
