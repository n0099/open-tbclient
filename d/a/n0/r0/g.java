package d.a.n0.r0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f58577a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.m0.e0.b> f58578b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f58579c;

    /* renamed from: d  reason: collision with root package name */
    public String f58580d;

    /* renamed from: e  reason: collision with root package name */
    public String f58581e;

    /* renamed from: f  reason: collision with root package name */
    public String f58582f;

    public g(Context context, List<FrsTabInfo> list) {
        this.f58577a = list;
        this.f58579c = context;
    }

    public void a(d.a.m0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.m0.e0.b bVar2 : this.f58578b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f49338e == bVar.getFragmentTabStructure().f49338e) {
                return;
            }
        }
        this.f58578b.add(bVar);
    }

    public String b() {
        return this.f58580d;
    }

    public String c() {
        return this.f58582f;
    }

    public String d() {
        return this.f58581e;
    }

    public List<FrsTabInfo> e() {
        return this.f58577a;
    }

    public List<d.a.m0.e0.b> f() {
        return this.f58578b;
    }

    public void g(String str) {
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f58580d = str;
    }

    public void j(String str) {
        this.f58582f = str;
    }

    public void k(String str) {
        this.f58581e = str;
    }

    public void l(String str) {
    }
}
