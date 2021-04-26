package d.a.j0.a1.f.g;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import d.a.j0.a1.f.b;
import d.a.j0.a1.f.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public c f50763a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.a1.f.a f50764b = new d.a.j0.a1.f.f.a(this);

    public a(c cVar) {
        this.f50763a = cVar;
    }

    @Override // d.a.j0.a1.f.b
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        d.a.j0.a1.f.a aVar = this.f50764b;
        if (aVar != null) {
            return aVar.a(bdUniqueId, str, str2, str3);
        }
        return false;
    }

    @Override // d.a.j0.a1.f.b
    public boolean b(int i2, d.a.j0.a1.f.e.a aVar) {
        c cVar;
        if (aVar == null || (cVar = this.f50763a) == null) {
            return false;
        }
        cVar.setData(aVar.getDataList());
        return true;
    }

    @Override // d.a.j0.a1.f.b
    public boolean c(int i2) {
        c cVar = this.f50763a;
        if (cVar != null) {
            cVar.b(i2);
            return true;
        }
        return false;
    }

    @Override // d.a.j0.a1.f.b
    public void setData(List<n> list) {
        c cVar = this.f50763a;
        if (cVar != null) {
            cVar.setData(list);
        }
    }
}
