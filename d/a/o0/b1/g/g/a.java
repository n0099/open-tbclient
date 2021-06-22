package d.a.o0.b1.g.g;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import d.a.o0.b1.g.b;
import d.a.o0.b1.g.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public c f55433a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.b1.g.a f55434b = new d.a.o0.b1.g.f.a(this);

    public a(c cVar) {
        this.f55433a = cVar;
    }

    @Override // d.a.o0.b1.g.b
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        d.a.o0.b1.g.a aVar = this.f55434b;
        if (aVar != null) {
            return aVar.a(bdUniqueId, str, str2, str3);
        }
        return false;
    }

    @Override // d.a.o0.b1.g.b
    public boolean b(int i2, d.a.o0.b1.g.e.a aVar) {
        c cVar;
        if (aVar == null || (cVar = this.f55433a) == null) {
            return false;
        }
        cVar.setData(aVar.getDataList());
        return true;
    }

    @Override // d.a.o0.b1.g.b
    public boolean c(int i2) {
        c cVar = this.f55433a;
        if (cVar != null) {
            cVar.b(i2);
            return true;
        }
        return false;
    }

    @Override // d.a.o0.b1.g.b
    public void setData(List<n> list) {
        c cVar = this.f55433a;
        if (cVar != null) {
            cVar.setData(list);
        }
    }
}
