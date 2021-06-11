package d.a.n0.r0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f62268a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.m0.e0.b> f62269b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f62270c;

    /* renamed from: d  reason: collision with root package name */
    public String f62271d;

    /* renamed from: e  reason: collision with root package name */
    public String f62272e;

    /* renamed from: f  reason: collision with root package name */
    public String f62273f;

    public g(Context context, List<FrsTabInfo> list) {
        this.f62268a = list;
        this.f62270c = context;
    }

    public void a(d.a.m0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.m0.e0.b bVar2 : this.f62269b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f53012e == bVar.getFragmentTabStructure().f53012e) {
                return;
            }
        }
        this.f62269b.add(bVar);
    }

    public String b() {
        return this.f62271d;
    }

    public String c() {
        return this.f62273f;
    }

    public String d() {
        return this.f62272e;
    }

    public List<FrsTabInfo> e() {
        return this.f62268a;
    }

    public List<d.a.m0.e0.b> f() {
        return this.f62269b;
    }

    public void g(String str) {
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f62271d = str;
    }

    public void j(String str) {
        this.f62273f = str;
    }

    public void k(String str) {
        this.f62272e = str;
    }

    public void l(String str) {
    }
}
