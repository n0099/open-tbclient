package d.a.j0.q0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.i0.e0.b> f57909a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public Context f57910b;

    /* renamed from: c  reason: collision with root package name */
    public String f57911c;

    /* renamed from: d  reason: collision with root package name */
    public String f57912d;

    /* renamed from: e  reason: collision with root package name */
    public String f57913e;

    public k0(Context context) {
        this.f57910b = context;
    }

    public void a(d.a.i0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.i0.e0.b bVar2 : this.f57909a) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f48466e == bVar.getFragmentTabStructure().f48466e) {
                return;
            }
        }
        this.f57909a.add(bVar);
    }

    public String b() {
        return this.f57913e;
    }

    public String c() {
        return this.f57911c;
    }

    public String d() {
        return this.f57912d;
    }

    public List<d.a.i0.e0.b> e() {
        return this.f57909a;
    }

    public void f(String str) {
        this.f57913e = str;
    }

    public void g(String str) {
        this.f57911c = str;
    }

    public void h(String str) {
        this.f57912d = str;
    }
}
