package d.a.k0.e.b;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import d.a.c.j.e.n;
import d.a.j0.r.q.m0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements n, d.a.k0.e.c, m0 {

    /* renamed from: g  reason: collision with root package name */
    public static SparseArray<BdUniqueId> f54042g = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public Object f54043e;

    /* renamed from: f  reason: collision with root package name */
    public int f54044f;

    public static void e(List<Integer> list) {
        if (f54042g.size() <= 0 && list != null) {
            for (Integer num : list) {
                f54042g.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> f() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < f54042g.size(); i2++) {
            arrayList.add(f54042g.valueAt(i2));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (f54042g.size() == 0 || (indexOfValue = f54042g.indexOfValue(bdUniqueId)) == -1 || f54042g.size() <= indexOfValue) {
            return -1;
        }
        return f54042g.keyAt(indexOfValue);
    }

    @Override // d.a.j0.r.q.m0
    public boolean b() {
        return false;
    }

    @Override // d.a.k0.e.c
    public Object c() {
        return this.f54043e;
    }

    @Override // d.a.j0.r.q.m0
    public int d() {
        if (c() instanceof AdvertAppInfo) {
            return ((m0) c()).d();
        }
        return -1;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f54042g.get(this.f54044f);
    }

    public int h() {
        return this.f54044f;
    }

    @Override // d.a.j0.r.q.m0
    public AdvertAppInfo j() {
        if (c() instanceof m0) {
            return (AdvertAppInfo) c();
        }
        return null;
    }

    public void k(Object obj) {
        this.f54043e = obj;
    }

    public void l(int i2) {
        this.f54044f = i2;
    }

    @Override // d.a.j0.r.q.m0
    public void setPosition(int i2) {
        if (c() instanceof m0) {
            ((m0) c()).setPosition(i2);
        }
    }
}
