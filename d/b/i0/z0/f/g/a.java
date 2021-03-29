package d.b.i0.z0.f.g;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import d.b.i0.z0.f.b;
import d.b.i0.z0.f.c;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public c f63018a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.z0.f.a f63019b = new d.b.i0.z0.f.f.a(this);

    public a(c cVar) {
        this.f63018a = cVar;
    }

    @Override // d.b.i0.z0.f.b
    public boolean a(int i, d.b.i0.z0.f.e.a aVar) {
        c cVar;
        if (aVar == null || (cVar = this.f63018a) == null) {
            return false;
        }
        cVar.setData(aVar.getDataList());
        return true;
    }

    @Override // d.b.i0.z0.f.b
    public boolean b(int i) {
        c cVar = this.f63018a;
        if (cVar != null) {
            cVar.b(i);
            return true;
        }
        return false;
    }

    @Override // d.b.i0.z0.f.b
    public boolean c(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        d.b.i0.z0.f.a aVar = this.f63019b;
        if (aVar != null) {
            return aVar.a(bdUniqueId, str, str2, str3);
        }
        return false;
    }

    @Override // d.b.i0.z0.f.b
    public void setData(List<n> list) {
        c cVar = this.f63018a;
        if (cVar != null) {
            cVar.setData(list);
        }
    }
}
