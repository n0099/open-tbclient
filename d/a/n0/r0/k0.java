package d.a.n0.r0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.m0.e0.b> f58792a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public Context f58793b;

    /* renamed from: c  reason: collision with root package name */
    public String f58794c;

    /* renamed from: d  reason: collision with root package name */
    public String f58795d;

    /* renamed from: e  reason: collision with root package name */
    public String f58796e;

    public k0(Context context) {
        this.f58793b = context;
    }

    public void a(d.a.m0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.m0.e0.b bVar2 : this.f58792a) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f49338e == bVar.getFragmentTabStructure().f49338e) {
                return;
            }
        }
        this.f58792a.add(bVar);
    }

    public String b() {
        return this.f58796e;
    }

    public String c() {
        return this.f58794c;
    }

    public String d() {
        return this.f58795d;
    }

    public List<d.a.m0.e0.b> e() {
        return this.f58792a;
    }

    public void f(String str) {
        this.f58796e = str;
    }

    public void g(String str) {
        this.f58794c = str;
    }

    public void h(String str) {
        this.f58795d = str;
    }
}
