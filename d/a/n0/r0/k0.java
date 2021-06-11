package d.a.n0.r0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.m0.e0.b> f62483a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public Context f62484b;

    /* renamed from: c  reason: collision with root package name */
    public String f62485c;

    /* renamed from: d  reason: collision with root package name */
    public String f62486d;

    /* renamed from: e  reason: collision with root package name */
    public String f62487e;

    public k0(Context context) {
        this.f62484b = context;
    }

    public void a(d.a.m0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.m0.e0.b bVar2 : this.f62483a) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f53012e == bVar.getFragmentTabStructure().f53012e) {
                return;
            }
        }
        this.f62483a.add(bVar);
    }

    public String b() {
        return this.f62487e;
    }

    public String c() {
        return this.f62485c;
    }

    public String d() {
        return this.f62486d;
    }

    public List<d.a.m0.e0.b> e() {
        return this.f62483a;
    }

    public void f(String str) {
        this.f62487e = str;
    }

    public void g(String str) {
        this.f62485c = str;
    }

    public void h(String str) {
        this.f62486d = str;
    }
}
