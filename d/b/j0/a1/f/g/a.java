package d.b.j0.a1.f.g;

import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import d.b.j0.a1.f.b;
import d.b.j0.a1.f.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public c f53058a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.a1.f.a f53059b = new d.b.j0.a1.f.f.a(this);

    public a(c cVar) {
        this.f53058a = cVar;
    }

    @Override // d.b.j0.a1.f.b
    public boolean a(int i, d.b.j0.a1.f.e.a aVar) {
        c cVar;
        if (aVar == null || (cVar = this.f53058a) == null) {
            return false;
        }
        cVar.setData(aVar.getDataList());
        return true;
    }

    @Override // d.b.j0.a1.f.b
    public boolean b(int i) {
        c cVar = this.f53058a;
        if (cVar != null) {
            cVar.b(i);
            return true;
        }
        return false;
    }

    @Override // d.b.j0.a1.f.b
    public boolean c(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        d.b.j0.a1.f.a aVar = this.f53059b;
        if (aVar != null) {
            return aVar.a(bdUniqueId, str, str2, str3);
        }
        return false;
    }

    @Override // d.b.j0.a1.f.b
    public void setData(List<n> list) {
        c cVar = this.f53058a;
        if (cVar != null) {
            cVar.setData(list);
        }
    }
}
