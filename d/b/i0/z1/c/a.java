package d.b.i0.z1.c;

import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63429a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.b.j.e.a> f63430b;

    /* renamed from: c  reason: collision with root package name */
    public s f63431c;

    public a(TbPageContext tbPageContext, s sVar) {
        this.f63429a = tbPageContext;
        this.f63431c = sVar;
        a();
        this.f63431c.a(this.f63430b);
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        this.f63430b = arrayList;
        arrayList.add(new b(this.f63429a));
    }

    public void b() {
        s sVar = this.f63431c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f63431c.setData(list);
    }
}
