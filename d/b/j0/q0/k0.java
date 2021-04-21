package d.b.j0.q0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.b.i0.e0.b> f59838a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public Context f59839b;

    /* renamed from: c  reason: collision with root package name */
    public String f59840c;

    /* renamed from: d  reason: collision with root package name */
    public String f59841d;

    /* renamed from: e  reason: collision with root package name */
    public String f59842e;

    public k0(Context context) {
        this.f59839b = context;
    }

    public void a(d.b.i0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.b.i0.e0.b bVar2 : this.f59838a) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f50888e == bVar.getFragmentTabStructure().f50888e) {
                return;
            }
        }
        this.f59838a.add(bVar);
    }

    public String b() {
        return this.f59842e;
    }

    public String c() {
        return this.f59840c;
    }

    public String d() {
        return this.f59841d;
    }

    public List<d.b.i0.e0.b> e() {
        return this.f59838a;
    }

    public void f(String str) {
        this.f59842e = str;
    }

    public void g(String str) {
        this.f59840c = str;
    }

    public void h(String str) {
        this.f59841d = str;
    }
}
