package d.a.h0.a.p.b;

import android.util.SparseArray;
import com.baidu.searchbox.live.interfaces.DI;
import d.a.h0.a.i2.k0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class m implements d.a.h0.i.b {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<String> f43502a;

    public m() {
        SparseArray<String> sparseArray = new SparseArray<>();
        this.f43502a = sparseArray;
        sparseArray.put(38, DI.BD.FAVOR);
    }

    @Override // d.a.h0.i.b
    public void a(int i2, List<d.a.h0.i.o> list) {
    }

    @Override // d.a.h0.i.b
    public void b(int i2, List<d.a.h0.i.o> list) {
    }

    @Override // d.a.h0.i.b
    public void c(int i2, List<d.a.h0.i.o> list) {
        e(i2, list);
    }

    @Override // d.a.h0.i.b
    public boolean d(d.a.h0.i.o oVar) {
        return false;
    }

    public final void e(int i2, List<d.a.h0.i.o> list) {
        if (k0.D() || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.h0.i.o oVar : list) {
            if (this.f43502a.get(oVar.c()) != null) {
                arrayList.add(oVar);
            }
        }
        if (arrayList.size() > 0) {
            list.removeAll(arrayList);
        }
    }
}
