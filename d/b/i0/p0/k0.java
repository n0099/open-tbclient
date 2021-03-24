package d.b.i0.p0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.b.h0.e0.b> f57717a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public Context f57718b;

    /* renamed from: c  reason: collision with root package name */
    public String f57719c;

    /* renamed from: d  reason: collision with root package name */
    public String f57720d;

    /* renamed from: e  reason: collision with root package name */
    public String f57721e;

    public k0(Context context) {
        this.f57718b = context;
    }

    public void a(d.b.h0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.b.h0.e0.b bVar2 : this.f57717a) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f50158e == bVar.getFragmentTabStructure().f50158e) {
                return;
            }
        }
        this.f57717a.add(bVar);
    }

    public String b() {
        return this.f57721e;
    }

    public String c() {
        return this.f57719c;
    }

    public String d() {
        return this.f57720d;
    }

    public List<d.b.h0.e0.b> e() {
        return this.f57717a;
    }

    public void f(String str) {
        this.f57721e = str;
    }

    public void g(String str) {
        this.f57719c = str;
    }

    public void h(String str) {
        this.f57720d = str;
    }
}
