package d.b.j0.r1.h.b.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f61624e;

    /* renamed from: f  reason: collision with root package name */
    public c f61625f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f61626g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f61627h;

    public a(TbPageContext<?> tbPageContext, c cVar, View.OnClickListener onClickListener) {
        this.f61624e = tbPageContext;
        this.f61627h = new ArrayList();
        this.f61625f = cVar;
        this.f61627h = cVar.a();
        this.f61626g = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        return this.f61627h.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f61627h.size();
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
            view2 = bVar.a(this.f61624e.getPageActivity());
            bVar.e(this.f61626g);
            bVar.c(this.f61624e);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        String str = this.f61627h.get(i);
        bVar.d(str);
        bVar.f(this.f61625f.b().equals(str));
        return view2;
    }
}
