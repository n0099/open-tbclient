package d.a.o0.r0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.n0.e0.b> f62608a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public Context f62609b;

    /* renamed from: c  reason: collision with root package name */
    public String f62610c;

    /* renamed from: d  reason: collision with root package name */
    public String f62611d;

    /* renamed from: e  reason: collision with root package name */
    public String f62612e;

    public k0(Context context) {
        this.f62609b = context;
    }

    public void a(d.a.n0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.n0.e0.b bVar2 : this.f62608a) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f53119e == bVar.getFragmentTabStructure().f53119e) {
                return;
            }
        }
        this.f62608a.add(bVar);
    }

    public String b() {
        return this.f62612e;
    }

    public String c() {
        return this.f62610c;
    }

    public String d() {
        return this.f62611d;
    }

    public List<d.a.n0.e0.b> e() {
        return this.f62608a;
    }

    public void f(String str) {
        this.f62612e = str;
    }

    public void g(String str) {
        this.f62610c = str;
    }

    public void h(String str) {
        this.f62611d = str;
    }
}
