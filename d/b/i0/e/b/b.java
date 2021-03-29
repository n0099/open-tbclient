package d.b.i0.e.b;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import d.b.b.j.e.n;
import d.b.h0.r.q.m0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements n, d.b.i0.e.c, m0 {

    /* renamed from: g  reason: collision with root package name */
    public static SparseArray<BdUniqueId> f54185g = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public Object f54186e;

    /* renamed from: f  reason: collision with root package name */
    public int f54187f;

    public static void e(List<Integer> list) {
        if (f54185g.size() <= 0 && list != null) {
            for (Integer num : list) {
                f54185g.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> f() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < f54185g.size(); i++) {
            arrayList.add(f54185g.valueAt(i));
        }
        return arrayList;
    }

    public static int j(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (f54185g.size() == 0 || (indexOfValue = f54185g.indexOfValue(bdUniqueId)) == -1 || f54185g.size() <= indexOfValue) {
            return -1;
        }
        return f54185g.keyAt(indexOfValue);
    }

    @Override // d.b.i0.e.c
    public Object a() {
        return this.f54186e;
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
        return this.f54187f;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f54185g.get(this.f54187f);
    }

    @Override // d.b.h0.r.q.m0
    public int i() {
        if (a() instanceof AdvertAppInfo) {
            return ((m0) a()).i();
        }
        return -1;
    }

    public void k(Object obj) {
        this.f54186e = obj;
    }

    public void l(int i) {
        this.f54187f = i;
    }

    @Override // d.b.h0.r.q.m0
    public void setPosition(int i) {
        if (a() instanceof m0) {
            ((m0) a()).setPosition(i);
        }
    }
}
