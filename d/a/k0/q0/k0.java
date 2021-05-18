package d.a.k0.q0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.j0.e0.b> f58651a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public Context f58652b;

    /* renamed from: c  reason: collision with root package name */
    public String f58653c;

    /* renamed from: d  reason: collision with root package name */
    public String f58654d;

    /* renamed from: e  reason: collision with root package name */
    public String f58655e;

    public k0(Context context) {
        this.f58652b = context;
    }

    public void a(d.a.j0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.j0.e0.b bVar2 : this.f58651a) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f49294e == bVar.getFragmentTabStructure().f49294e) {
                return;
            }
        }
        this.f58651a.add(bVar);
    }

    public String b() {
        return this.f58655e;
    }

    public String c() {
        return this.f58653c;
    }

    public String d() {
        return this.f58654d;
    }

    public List<d.a.j0.e0.b> e() {
        return this.f58651a;
    }

    public void f(String str) {
        this.f58655e = str;
    }

    public void g(String str) {
        this.f58653c = str;
    }

    public void h(String str) {
        this.f58654d = str;
    }
}
