package d.b.i0.z1.c;

import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63430a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.b.j.e.a> f63431b;

    /* renamed from: c  reason: collision with root package name */
    public s f63432c;

    public a(TbPageContext tbPageContext, s sVar) {
        this.f63430a = tbPageContext;
        this.f63432c = sVar;
        a();
        this.f63432c.a(this.f63431b);
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        this.f63431b = arrayList;
        arrayList.add(new b(this.f63430a));
    }

    public void b() {
        s sVar = this.f63432c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f63432c.setData(list);
    }
}
