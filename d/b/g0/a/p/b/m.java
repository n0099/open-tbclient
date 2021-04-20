package d.b.g0.a.p.b;

import android.util.SparseArray;
import com.baidu.searchbox.live.interfaces.DI;
import d.b.g0.a.i2.k0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class m implements d.b.g0.i.b {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<String> f45826a;

    public m() {
        SparseArray<String> sparseArray = new SparseArray<>();
        this.f45826a = sparseArray;
        sparseArray.put(38, DI.BD.FAVOR);
    }

    @Override // d.b.g0.i.b
    public void a(int i, List<d.b.g0.i.o> list) {
    }

    @Override // d.b.g0.i.b
    public boolean b(d.b.g0.i.o oVar) {
        return false;
    }

    @Override // d.b.g0.i.b
    public void c(int i, List<d.b.g0.i.o> list) {
    }

    @Override // d.b.g0.i.b
    public void d(int i, List<d.b.g0.i.o> list) {
        e(i, list);
    }

    public final void e(int i, List<d.b.g0.i.o> list) {
        if (k0.D() || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.b.g0.i.o oVar : list) {
            if (this.f45826a.get(oVar.c()) != null) {
                arrayList.add(oVar);
            }
        }
        if (arrayList.size() > 0) {
            list.removeAll(arrayList);
        }
    }
}
