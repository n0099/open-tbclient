package d.a.k0.i0.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f55830e;

    /* renamed from: f  reason: collision with root package name */
    public int f55831f;

    /* renamed from: g  reason: collision with root package name */
    public int f55832g = 0;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f55833h;

    /* renamed from: i  reason: collision with root package name */
    public List<c> f55834i;

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
        return this.f55833h;
    }

    public final b m() {
        b bVar;
        if (this.f55832g < l().size()) {
            bVar = l().get(this.f55832g);
        } else if (this.f55831f >= l().size()) {
            return null;
        } else {
            this.f55832g = 0;
            bVar = l().get(this.f55832g);
        }
        this.f55832g++;
        return bVar;
    }

    public int p() {
        return this.f55831f;
    }

    public List<c> s() {
        return this.f55834i;
    }

    public List<c> t() {
        if (l().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f55831f == 2) {
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
        return this.f55830e;
    }

    public void v(List<b> list) {
        this.f55833h = list;
    }

    public void w(int i2) {
        this.f55831f = i2;
    }

    public final void x(List<c> list) {
        this.f55834i = list;
    }

    public void y(String str) {
        this.f55830e = str;
    }
}
