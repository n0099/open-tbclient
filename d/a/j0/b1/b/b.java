package d.a.j0.b1.b;

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
    public LayoutInflater f51463e;

    /* renamed from: f  reason: collision with root package name */
    public int f51464f;

    /* renamed from: g  reason: collision with root package name */
    public ItemViewHolder f51465g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f51466h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f51467i = new ArrayList<>();
    public View.OnClickListener j;

    public b(Context context, int i2, ItemViewHolder itemViewHolder) {
        this.f51463e = LayoutInflater.from(context);
        this.f51464f = i2;
        this.f51465g = itemViewHolder;
    }

    public final void a(ItemViewHolder itemViewHolder, c cVar) {
        if (cVar == null || itemViewHolder == null) {
            return;
        }
        itemViewHolder.b(cVar);
    }

    public void b(int i2) {
        if (ListUtils.getCount(this.f51467i) > 0) {
            Iterator<ItemViewHolder> it = this.f51467i.iterator();
            while (it.hasNext()) {
                it.next().d(i2);
            }
        }
    }

    public void c(List<c> list) {
        this.f51466h = list;
    }

    public void d(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f51466h);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return ListUtils.getItem(this.f51466h, i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        if (ListUtils.getItem(this.f51466h, i2) == null) {
            return -1L;
        }
        return ((c) ListUtils.getItem(this.f51466h, i2)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f51463e.inflate(this.f51464f, viewGroup, false);
            ItemViewHolder c2 = this.f51465g.c(view);
            c2.e(this.j);
            view.setTag(c2);
            this.f51467i.add(c2);
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        if (ListUtils.getItem(this.f51466h, i2) != null) {
            a(itemViewHolder, this.f51466h.get(i2));
        }
        return itemViewHolder.a();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
