package d.b.i0.q0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f59213a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.h0.e0.b> f59214b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f59215c;

    /* renamed from: d  reason: collision with root package name */
    public String f59216d;

    /* renamed from: e  reason: collision with root package name */
    public String f59217e;

    /* renamed from: f  reason: collision with root package name */
    public String f59218f;

    public g(Context context, List<FrsTabInfo> list) {
        this.f59213a = list;
        this.f59215c = context;
    }

    public void a(d.b.h0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.b.h0.e0.b bVar2 : this.f59214b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f50552e == bVar.getFragmentTabStructure().f50552e) {
                return;
            }
        }
        this.f59214b.add(bVar);
    }

    public String b() {
        return this.f59216d;
    }

    public String c() {
        return this.f59218f;
    }

    public String d() {
        return this.f59217e;
    }

    public List<FrsTabInfo> e() {
        return this.f59213a;
    }

    public List<d.b.h0.e0.b> f() {
        return this.f59214b;
    }

    public void g(String str) {
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f59216d = str;
    }

    public void j(String str) {
        this.f59218f = str;
    }

    public void k(String str) {
        this.f59217e = str;
    }

    public void l(String str) {
    }
}
