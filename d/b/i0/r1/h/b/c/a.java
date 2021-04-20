package d.b.i0.r1.h.b.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f61203e;

    /* renamed from: f  reason: collision with root package name */
    public c f61204f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f61205g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f61206h;

    public a(TbPageContext<?> tbPageContext, c cVar, View.OnClickListener onClickListener) {
        this.f61203e = tbPageContext;
        this.f61206h = new ArrayList();
        this.f61204f = cVar;
        this.f61206h = cVar.a();
        this.f61205g = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        return this.f61206h.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f61206h.size();
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
            view2 = bVar.a(this.f61203e.getPageActivity());
            bVar.e(this.f61205g);
            bVar.c(this.f61203e);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        String str = this.f61206h.get(i);
        bVar.d(str);
        bVar.f(this.f61204f.b().equals(str));
        return view2;
    }
}
