package d.a.n0.b2.c;

import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55754a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55755b;

    /* renamed from: c  reason: collision with root package name */
    public s f55756c;

    public a(TbPageContext tbPageContext, s sVar) {
        this.f55754a = tbPageContext;
        this.f55756c = sVar;
        a();
        this.f55756c.a(this.f55755b);
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        this.f55755b = arrayList;
        arrayList.add(new b(this.f55754a));
    }

    public void b() {
        s sVar = this.f55756c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f55756c.setData(list);
    }
}
