package d.a.o0.b2.c;

import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55879a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55880b;

    /* renamed from: c  reason: collision with root package name */
    public s f55881c;

    public a(TbPageContext tbPageContext, s sVar) {
        this.f55879a = tbPageContext;
        this.f55881c = sVar;
        a();
        this.f55881c.a(this.f55880b);
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        this.f55880b = arrayList;
        arrayList.add(new b(this.f55879a));
    }

    public void b() {
        s sVar = this.f55881c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f55881c.setData(list);
    }
}
