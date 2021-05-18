package d.a.k0.q0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f58436a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.j0.e0.b> f58437b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f58438c;

    /* renamed from: d  reason: collision with root package name */
    public String f58439d;

    /* renamed from: e  reason: collision with root package name */
    public String f58440e;

    /* renamed from: f  reason: collision with root package name */
    public String f58441f;

    public g(Context context, List<FrsTabInfo> list) {
        this.f58436a = list;
        this.f58438c = context;
    }

    public void a(d.a.j0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.j0.e0.b bVar2 : this.f58437b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f49294e == bVar.getFragmentTabStructure().f49294e) {
                return;
            }
        }
        this.f58437b.add(bVar);
    }

    public String b() {
        return this.f58439d;
    }

    public String c() {
        return this.f58441f;
    }

    public String d() {
        return this.f58440e;
    }

    public List<FrsTabInfo> e() {
        return this.f58436a;
    }

    public List<d.a.j0.e0.b> f() {
        return this.f58437b;
    }

    public void g(String str) {
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f58439d = str;
    }

    public void j(String str) {
        this.f58441f = str;
    }

    public void k(String str) {
        this.f58440e = str;
    }

    public void l(String str) {
    }
}
