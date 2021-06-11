package d.a.n0.s1.h.b.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f64338e;

    /* renamed from: f  reason: collision with root package name */
    public c f64339f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f64340g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f64341h;

    public a(TbPageContext<?> tbPageContext, c cVar, View.OnClickListener onClickListener) {
        this.f64338e = tbPageContext;
        this.f64341h = new ArrayList();
        this.f64339f = cVar;
        this.f64341h = cVar.a();
        this.f64340g = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        return this.f64341h.get(i2);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f64341h.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b();
            view2 = bVar.a(this.f64338e.getPageActivity());
            bVar.e(this.f64340g);
            bVar.c(this.f64338e);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        String str = this.f64341h.get(i2);
        bVar.d(str);
        bVar.f(this.f64339f.b().equals(str));
        return view2;
    }
}
