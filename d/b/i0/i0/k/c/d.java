package d.b.i0.i0.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f55649e;

    /* renamed from: f  reason: collision with root package name */
    public int f55650f;

    /* renamed from: g  reason: collision with root package name */
    public int f55651g = 0;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f55652h;
    public List<c> i;

    public final c g() {
        if (j().size() <= 0) {
            return null;
        }
        b n = n();
        b n2 = n();
        if (n == null && n2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.g(n);
        cVar.j(n2);
        return cVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public List<b> j() {
        return this.f55652h;
    }

    public final b n() {
        b bVar;
        if (this.f55651g < j().size()) {
            bVar = j().get(this.f55651g);
        } else if (this.f55650f >= j().size()) {
            return null;
        } else {
            this.f55651g = 0;
            bVar = j().get(this.f55651g);
        }
        this.f55651g++;
        return bVar;
    }

    public int o() {
        return this.f55650f;
    }

    public List<c> s() {
        return this.i;
    }

    public List<c> t() {
        if (j().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f55650f == 2) {
            if (g() != null) {
                arrayList.add(g());
            }
        } else {
            c g2 = g();
            c g3 = g();
            if (g2 != null) {
                arrayList.add(g2);
            }
            if (g3 != null) {
                arrayList.add(g3);
            }
        }
        x(arrayList);
        return arrayList;
    }

    public String u() {
        return this.f55649e;
    }

    public void v(List<b> list) {
        this.f55652h = list;
    }

    public void w(int i) {
        this.f55650f = i;
    }

    public final void x(List<c> list) {
        this.i = list;
    }

    public void y(String str) {
        this.f55649e = str;
    }
}
