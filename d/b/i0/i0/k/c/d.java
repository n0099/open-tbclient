package d.b.i0.i0.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56772e;

    /* renamed from: f  reason: collision with root package name */
    public int f56773f;

    /* renamed from: g  reason: collision with root package name */
    public int f56774g = 0;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f56775h;
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

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public List<b> j() {
        return this.f56775h;
    }

    public final b n() {
        b bVar;
        if (this.f56774g < j().size()) {
            bVar = j().get(this.f56774g);
        } else if (this.f56773f >= j().size()) {
            return null;
        } else {
            this.f56774g = 0;
            bVar = j().get(this.f56774g);
        }
        this.f56774g++;
        return bVar;
    }

    public int o() {
        return this.f56773f;
    }

    public List<c> s() {
        return this.i;
    }

    public List<c> t() {
        if (j().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f56773f == 2) {
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
        return this.f56772e;
    }

    public void v(List<b> list) {
        this.f56775h = list;
    }

    public void w(int i) {
        this.f56773f = i;
    }

    public final void x(List<c> list) {
        this.i = list;
    }

    public void y(String str) {
        this.f56772e = str;
    }
}
