package d.b.i0.q0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.b.h0.e0.b> f59417a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public Context f59418b;

    /* renamed from: c  reason: collision with root package name */
    public String f59419c;

    /* renamed from: d  reason: collision with root package name */
    public String f59420d;

    /* renamed from: e  reason: collision with root package name */
    public String f59421e;

    public k0(Context context) {
        this.f59418b = context;
    }

    public void a(d.b.h0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.b.h0.e0.b bVar2 : this.f59417a) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f50552e == bVar.getFragmentTabStructure().f50552e) {
                return;
            }
        }
        this.f59417a.add(bVar);
    }

    public String b() {
        return this.f59421e;
    }

    public String c() {
        return this.f59419c;
    }

    public String d() {
        return this.f59420d;
    }

    public List<d.b.h0.e0.b> e() {
        return this.f59417a;
    }

    public void f(String str) {
        this.f59421e = str;
    }

    public void g(String str) {
        this.f59419c = str;
    }

    public void h(String str) {
        this.f59420d = str;
    }
}
