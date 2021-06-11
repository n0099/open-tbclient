package d.a.n0.j0.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f59703e;

    /* renamed from: f  reason: collision with root package name */
    public int f59704f;

    /* renamed from: g  reason: collision with root package name */
    public int f59705g = 0;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f59706h;

    /* renamed from: i  reason: collision with root package name */
    public List<c> f59707i;

    public final c c() {
        if (g().size() <= 0) {
            return null;
        }
        b i2 = i();
        b i3 = i();
        if (i2 == null && i3 == null) {
            return null;
        }
        c cVar = new c();
        cVar.c(i2);
        cVar.g(i3);
        return cVar;
    }

    public List<b> g() {
        return this.f59706h;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return j;
    }

    public final b i() {
        b bVar;
        if (this.f59705g < g().size()) {
            bVar = g().get(this.f59705g);
        } else if (this.f59704f >= g().size()) {
            return null;
        } else {
            this.f59705g = 0;
            bVar = g().get(this.f59705g);
        }
        this.f59705g++;
        return bVar;
    }

    public int k() {
        return this.f59704f;
    }

    public List<c> o() {
        return this.f59707i;
    }

    public List<c> p() {
        if (g().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f59704f == 2) {
            if (c() != null) {
                arrayList.add(c());
            }
        } else {
            c c2 = c();
            c c3 = c();
            if (c2 != null) {
                arrayList.add(c2);
            }
            if (c3 != null) {
                arrayList.add(c3);
            }
        }
        x(arrayList);
        return arrayList;
    }

    public String q() {
        return this.f59703e;
    }

    public void t(List<b> list) {
        this.f59706h = list;
    }

    public void w(int i2) {
        this.f59704f = i2;
    }

    public final void x(List<c> list) {
        this.f59707i = list;
    }

    public void y(String str) {
        this.f59703e = str;
    }
}
