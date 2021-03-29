package d.b.i0.p0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.b.h0.e0.b> f57718a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public Context f57719b;

    /* renamed from: c  reason: collision with root package name */
    public String f57720c;

    /* renamed from: d  reason: collision with root package name */
    public String f57721d;

    /* renamed from: e  reason: collision with root package name */
    public String f57722e;

    public k0(Context context) {
        this.f57719b = context;
    }

    public void a(d.b.h0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.b.h0.e0.b bVar2 : this.f57718a) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f50159e == bVar.getFragmentTabStructure().f50159e) {
                return;
            }
        }
        this.f57718a.add(bVar);
    }

    public String b() {
        return this.f57722e;
    }

    public String c() {
        return this.f57720c;
    }

    public String d() {
        return this.f57721d;
    }

    public List<d.b.h0.e0.b> e() {
        return this.f57718a;
    }

    public void f(String str) {
        this.f57722e = str;
    }

    public void g(String str) {
        this.f57720c = str;
    }

    public void h(String str) {
        this.f57721d = str;
    }
}
