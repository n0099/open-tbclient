package d.a.n0.b1.f.g;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import d.a.n0.b1.f.b;
import d.a.n0.b1.f.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public c f51625a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b1.f.a f51626b = new d.a.n0.b1.f.f.a(this);

    public a(c cVar) {
        this.f51625a = cVar;
    }

    @Override // d.a.n0.b1.f.b
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        d.a.n0.b1.f.a aVar = this.f51626b;
        if (aVar != null) {
            return aVar.a(bdUniqueId, str, str2, str3);
        }
        return false;
    }

    @Override // d.a.n0.b1.f.b
    public boolean b(int i2, d.a.n0.b1.f.e.a aVar) {
        c cVar;
        if (aVar == null || (cVar = this.f51625a) == null) {
            return false;
        }
        cVar.setData(aVar.getDataList());
        return true;
    }

    @Override // d.a.n0.b1.f.b
    public boolean c(int i2) {
        c cVar = this.f51625a;
        if (cVar != null) {
            cVar.b(i2);
            return true;
        }
        return false;
    }

    @Override // d.a.n0.b1.f.b
    public void setData(List<n> list) {
        c cVar = this.f51625a;
        if (cVar != null) {
            cVar.setData(list);
        }
    }
}
