package d.a.i0.a.p.c;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.baidu.searchbox.live.interfaces.DI;
import d.a.i0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class v implements d.a.i0.k.b {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<String> f43803a;

    public v() {
        SparseArray<String> sparseArray = new SparseArray<>();
        this.f43803a = sparseArray;
        sparseArray.put(38, DI.BD.FAVOR);
    }

    @Override // d.a.i0.k.b
    public void a(Activity activity, d.a.i0.k.o oVar) {
    }

    @Override // d.a.i0.k.b
    public void b(int i2, List<d.a.i0.k.o> list) {
    }

    @Override // d.a.i0.k.b
    public void c(int i2, List<d.a.i0.k.o> list) {
    }

    @Override // d.a.i0.k.b
    public void d(int i2, List<d.a.i0.k.o> list) {
        j(i2, list);
    }

    @Override // d.a.i0.k.b
    public void e(Activity activity, d.a.i0.k.o oVar) {
    }

    @Override // d.a.i0.k.b
    public void f(Context context, JSONObject jSONObject) {
    }

    @Override // d.a.i0.k.b
    public boolean h(d.a.i0.k.o oVar) {
        return false;
    }

    public final void j(int i2, List<d.a.i0.k.o> list) {
        if (q0.G() || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.i0.k.o oVar : list) {
            if (this.f43803a.get(oVar.c()) != null) {
                arrayList.add(oVar);
            }
        }
        if (arrayList.size() > 0) {
            list.removeAll(arrayList);
        }
    }
}
