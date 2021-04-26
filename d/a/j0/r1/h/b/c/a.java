package d.a.j0.r1.h.b.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f59779e;

    /* renamed from: f  reason: collision with root package name */
    public c f59780f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f59781g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f59782h;

    public a(TbPageContext<?> tbPageContext, c cVar, View.OnClickListener onClickListener) {
        this.f59779e = tbPageContext;
        this.f59782h = new ArrayList();
        this.f59780f = cVar;
        this.f59782h = cVar.a();
        this.f59781g = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        return this.f59782h.get(i2);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f59782h.size();
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
            view2 = bVar.a(this.f59779e.getPageActivity());
            bVar.e(this.f59781g);
            bVar.c(this.f59779e);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        String str = this.f59782h.get(i2);
        bVar.d(str);
        bVar.f(this.f59780f.b().equals(str));
        return view2;
    }
}
