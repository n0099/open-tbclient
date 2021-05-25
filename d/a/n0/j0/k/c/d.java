package d.a.n0.j0.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56014e;

    /* renamed from: f  reason: collision with root package name */
    public int f56015f;

    /* renamed from: g  reason: collision with root package name */
    public int f56016g = 0;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f56017h;

    /* renamed from: i  reason: collision with root package name */
    public List<c> f56018i;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public final c h() {
        if (l().size() <= 0) {
            return null;
        }
        b m = m();
        b m2 = m();
        if (m == null && m2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.h(m);
        cVar.l(m2);
        return cVar;
    }

    public List<b> l() {
        return this.f56017h;
    }

    public final b m() {
        b bVar;
        if (this.f56016g < l().size()) {
            bVar = l().get(this.f56016g);
        } else if (this.f56015f >= l().size()) {
            return null;
        } else {
            this.f56016g = 0;
            bVar = l().get(this.f56016g);
        }
        this.f56016g++;
        return bVar;
    }

    public int p() {
        return this.f56015f;
    }

    public List<c> s() {
        return this.f56018i;
    }

    public List<c> t() {
        if (l().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f56015f == 2) {
            if (h() != null) {
                arrayList.add(h());
            }
        } else {
            c h2 = h();
            c h3 = h();
            if (h2 != null) {
                arrayList.add(h2);
            }
            if (h3 != null) {
                arrayList.add(h3);
            }
        }
        x(arrayList);
        return arrayList;
    }

    public String u() {
        return this.f56014e;
    }

    public void v(List<b> list) {
        this.f56017h = list;
    }

    public void w(int i2) {
        this.f56015f = i2;
    }

    public final void x(List<c> list) {
        this.f56018i = list;
    }

    public void y(String str) {
        this.f56014e = str;
    }
}
