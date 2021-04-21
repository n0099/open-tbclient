package d.b.j0.e.b;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import d.b.c.j.e.n;
import d.b.i0.r.q.m0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements n, d.b.j0.e.c, m0 {

    /* renamed from: g  reason: collision with root package name */
    public static SparseArray<BdUniqueId> f55489g = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public Object f55490e;

    /* renamed from: f  reason: collision with root package name */
    public int f55491f;

    public static void e(List<Integer> list) {
        if (f55489g.size() <= 0 && list != null) {
            for (Integer num : list) {
                f55489g.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> f() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < f55489g.size(); i++) {
            arrayList.add(f55489g.valueAt(i));
        }
        return arrayList;
    }

    public static int j(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (f55489g.size() == 0 || (indexOfValue = f55489g.indexOfValue(bdUniqueId)) == -1 || f55489g.size() <= indexOfValue) {
            return -1;
        }
        return f55489g.keyAt(indexOfValue);
    }

    @Override // d.b.j0.e.c
    public Object a() {
        return this.f55490e;
    }

    @Override // d.b.i0.r.q.m0
    public boolean c() {
        return false;
    }

    @Override // d.b.i0.r.q.m0
    public AdvertAppInfo d() {
        if (a() instanceof m0) {
            return (AdvertAppInfo) a();
        }
        return null;
    }

    public int g() {
        return this.f55491f;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f55489g.get(this.f55491f);
    }

    @Override // d.b.i0.r.q.m0
    public int i() {
        if (a() instanceof AdvertAppInfo) {
            return ((m0) a()).i();
        }
        return -1;
    }

    public void k(Object obj) {
        this.f55490e = obj;
    }

    public void l(int i) {
        this.f55491f = i;
    }

    @Override // d.b.i0.r.q.m0
    public void setPosition(int i) {
        if (a() instanceof m0) {
            ((m0) a()).setPosition(i);
        }
    }
}
