package d.a.n0.e.b;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import d.a.c.k.e.n;
import d.a.m0.r.q.m0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements n, d.a.n0.e.c, m0 {

    /* renamed from: g  reason: collision with root package name */
    public static SparseArray<BdUniqueId> f56426g = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public Object f56427e;

    /* renamed from: f  reason: collision with root package name */
    public int f56428f;

    public static void c(List<Integer> list) {
        if (f56426g.size() <= 0 && list != null) {
            for (Integer num : list) {
                f56426g.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> e() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < f56426g.size(); i2++) {
            arrayList.add(f56426g.valueAt(i2));
        }
        return arrayList;
    }

    public static int h(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (f56426g.size() == 0 || (indexOfValue = f56426g.indexOfValue(bdUniqueId)) == -1 || f56426g.size() <= indexOfValue) {
            return -1;
        }
        return f56426g.keyAt(indexOfValue);
    }

    @Override // d.a.n0.e.c
    public Object b() {
        return this.f56427e;
    }

    @Override // d.a.m0.r.q.m0
    public boolean d() {
        return false;
    }

    @Override // d.a.m0.r.q.m0
    public int f() {
        if (b() instanceof AdvertAppInfo) {
            return ((m0) b()).f();
        }
        return -1;
    }

    public int g() {
        return this.f56428f;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56426g.get(this.f56428f);
    }

    public void i(Object obj) {
        this.f56427e = obj;
    }

    public void k(int i2) {
        this.f56428f = i2;
    }

    @Override // d.a.m0.r.q.m0
    public AdvertAppInfo m() {
        if (b() instanceof m0) {
            return (AdvertAppInfo) b();
        }
        return null;
    }

    @Override // d.a.m0.r.q.m0
    public void setPosition(int i2) {
        if (b() instanceof m0) {
            ((m0) b()).setPosition(i2);
        }
    }
}
