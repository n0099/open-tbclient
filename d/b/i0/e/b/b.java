package d.b.i0.e.b;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import d.b.c.j.e.n;
import d.b.h0.r.q.m0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements n, d.b.i0.e.c, m0 {

    /* renamed from: g  reason: collision with root package name */
    public static SparseArray<BdUniqueId> f55068g = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public Object f55069e;

    /* renamed from: f  reason: collision with root package name */
    public int f55070f;

    public static void e(List<Integer> list) {
        if (f55068g.size() <= 0 && list != null) {
            for (Integer num : list) {
                f55068g.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> f() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < f55068g.size(); i++) {
            arrayList.add(f55068g.valueAt(i));
        }
        return arrayList;
    }

    public static int j(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (f55068g.size() == 0 || (indexOfValue = f55068g.indexOfValue(bdUniqueId)) == -1 || f55068g.size() <= indexOfValue) {
            return -1;
        }
        return f55068g.keyAt(indexOfValue);
    }

    @Override // d.b.i0.e.c
    public Object a() {
        return this.f55069e;
    }

    @Override // d.b.h0.r.q.m0
    public boolean c() {
        return false;
    }

    @Override // d.b.h0.r.q.m0
    public AdvertAppInfo d() {
        if (a() instanceof m0) {
            return (AdvertAppInfo) a();
        }
        return null;
    }

    public int g() {
        return this.f55070f;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f55068g.get(this.f55070f);
    }

    @Override // d.b.h0.r.q.m0
    public int i() {
        if (a() instanceof AdvertAppInfo) {
            return ((m0) a()).i();
        }
        return -1;
    }

    public void k(Object obj) {
        this.f55069e = obj;
    }

    public void l(int i) {
        this.f55070f = i;
    }

    @Override // d.b.h0.r.q.m0
    public void setPosition(int i) {
        if (a() instanceof m0) {
            ((m0) a()).setPosition(i);
        }
    }
}
