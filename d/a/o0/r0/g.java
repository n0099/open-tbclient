package d.a.o0.r0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f62393a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.n0.e0.b> f62394b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f62395c;

    /* renamed from: d  reason: collision with root package name */
    public String f62396d;

    /* renamed from: e  reason: collision with root package name */
    public String f62397e;

    /* renamed from: f  reason: collision with root package name */
    public String f62398f;

    public g(Context context, List<FrsTabInfo> list) {
        this.f62393a = list;
        this.f62395c = context;
    }

    public void a(d.a.n0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.n0.e0.b bVar2 : this.f62394b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f53119e == bVar.getFragmentTabStructure().f53119e) {
                return;
            }
        }
        this.f62394b.add(bVar);
    }

    public String b() {
        return this.f62396d;
    }

    public String c() {
        return this.f62398f;
    }

    public String d() {
        return this.f62397e;
    }

    public List<FrsTabInfo> e() {
        return this.f62393a;
    }

    public List<d.a.n0.e0.b> f() {
        return this.f62394b;
    }

    public void g(String str) {
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f62396d = str;
    }

    public void j(String str) {
        this.f62398f = str;
    }

    public void k(String str) {
        this.f62397e = str;
    }

    public void l(String str) {
    }
}
