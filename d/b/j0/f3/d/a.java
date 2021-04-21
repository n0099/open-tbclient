package d.b.j0.f3.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.j0.f3.e.b;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f56450e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<b> f56451f = new LinkedList<>();

    /* renamed from: g  reason: collision with root package name */
    public int f56452g;

    public a(TbPageContext tbPageContext) {
        this.f56450e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public b getItem(int i) {
        return (b) ListUtils.getItem(this.f56451f, i);
    }

    public void b(int i) {
        this.f56452g = i;
    }

    public void c(List<b> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f56451f.clear();
        this.f56451f.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f56451f);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        d.b.j0.f3.g.a aVar;
        if (view == null) {
            aVar = new d.b.j0.f3.g.a(this.f56450e, this.f56452g);
            view2 = aVar.b();
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (d.b.j0.f3.g.a) view.getTag();
        }
        aVar.d(getItem(i));
        return view2;
    }
}
