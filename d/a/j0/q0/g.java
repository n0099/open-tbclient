package d.a.j0.q0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f57694a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.i0.e0.b> f57695b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f57696c;

    /* renamed from: d  reason: collision with root package name */
    public String f57697d;

    /* renamed from: e  reason: collision with root package name */
    public String f57698e;

    /* renamed from: f  reason: collision with root package name */
    public String f57699f;

    public g(Context context, List<FrsTabInfo> list) {
        this.f57694a = list;
        this.f57696c = context;
    }

    public void a(d.a.i0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.i0.e0.b bVar2 : this.f57695b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f48466e == bVar.getFragmentTabStructure().f48466e) {
                return;
            }
        }
        this.f57695b.add(bVar);
    }

    public String b() {
        return this.f57697d;
    }

    public String c() {
        return this.f57699f;
    }

    public String d() {
        return this.f57698e;
    }

    public List<FrsTabInfo> e() {
        return this.f57694a;
    }

    public List<d.a.i0.e0.b> f() {
        return this.f57695b;
    }

    public void g(String str) {
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f57697d = str;
    }

    public void j(String str) {
        this.f57699f = str;
    }

    public void k(String str) {
        this.f57698e = str;
    }

    public void l(String str) {
    }
}
