package d.b.i0.p0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f57514a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.h0.e0.b> f57515b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f57516c;

    /* renamed from: d  reason: collision with root package name */
    public String f57517d;

    /* renamed from: e  reason: collision with root package name */
    public String f57518e;

    /* renamed from: f  reason: collision with root package name */
    public String f57519f;

    public g(Context context, List<FrsTabInfo> list) {
        this.f57514a = list;
        this.f57516c = context;
    }

    public void a(d.b.h0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.b.h0.e0.b bVar2 : this.f57515b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f50159e == bVar.getFragmentTabStructure().f50159e) {
                return;
            }
        }
        this.f57515b.add(bVar);
    }

    public String b() {
        return this.f57517d;
    }

    public String c() {
        return this.f57519f;
    }

    public String d() {
        return this.f57518e;
    }

    public List<FrsTabInfo> e() {
        return this.f57514a;
    }

    public List<d.b.h0.e0.b> f() {
        return this.f57515b;
    }

    public void g(String str) {
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f57517d = str;
    }

    public void j(String str) {
        this.f57519f = str;
    }

    public void k(String str) {
        this.f57518e = str;
    }

    public void l(String str) {
    }
}
