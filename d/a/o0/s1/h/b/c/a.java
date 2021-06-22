package d.a.o0.s1.h.b.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f64463e;

    /* renamed from: f  reason: collision with root package name */
    public c f64464f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f64465g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f64466h;

    public a(TbPageContext<?> tbPageContext, c cVar, View.OnClickListener onClickListener) {
        this.f64463e = tbPageContext;
        this.f64466h = new ArrayList();
        this.f64464f = cVar;
        this.f64466h = cVar.a();
        this.f64465g = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        return this.f64466h.get(i2);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f64466h.size();
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
            view2 = bVar.a(this.f64463e.getPageActivity());
            bVar.e(this.f64465g);
            bVar.c(this.f64463e);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        String str = this.f64466h.get(i2);
        bVar.d(str);
        bVar.f(this.f64464f.b().equals(str));
        return view2;
    }
}
