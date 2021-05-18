package d.a.k0.f3.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.k0.f3.e.b;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f55046e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<b> f55047f = new LinkedList<>();

    /* renamed from: g  reason: collision with root package name */
    public int f55048g;

    public a(TbPageContext tbPageContext) {
        this.f55046e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public b getItem(int i2) {
        return (b) ListUtils.getItem(this.f55047f, i2);
    }

    public void b(int i2) {
        this.f55048g = i2;
    }

    public void c(List<b> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f55047f.clear();
        this.f55047f.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f55047f);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        d.a.k0.f3.g.a aVar;
        if (view == null) {
            aVar = new d.a.k0.f3.g.a(this.f55046e, this.f55048g);
            view2 = aVar.b();
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (d.a.k0.f3.g.a) view.getTag();
        }
        aVar.d(getItem(i2));
        return view2;
    }
}
