package d.b.i0.q1.h.b.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f59508e;

    /* renamed from: f  reason: collision with root package name */
    public c f59509f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f59510g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f59511h;

    public a(TbPageContext<?> tbPageContext, c cVar, View.OnClickListener onClickListener) {
        this.f59508e = tbPageContext;
        this.f59511h = new ArrayList();
        this.f59509f = cVar;
        this.f59511h = cVar.a();
        this.f59510g = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        return this.f59511h.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f59511h.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b();
            view2 = bVar.a(this.f59508e.getPageActivity());
            bVar.e(this.f59510g);
            bVar.c(this.f59508e);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        String str = this.f59511h.get(i);
        bVar.d(str);
        bVar.f(this.f59509f.b().equals(str));
        return view2;
    }
}
