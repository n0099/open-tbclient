package d.a.j0.a2.c;

import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51199a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51200b;

    /* renamed from: c  reason: collision with root package name */
    public s f51201c;

    public a(TbPageContext tbPageContext, s sVar) {
        this.f51199a = tbPageContext;
        this.f51201c = sVar;
        a();
        this.f51201c.a(this.f51200b);
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        this.f51200b = arrayList;
        arrayList.add(new b(this.f51199a));
    }

    public void b() {
        s sVar = this.f51201c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f51201c.setData(list);
    }
}
