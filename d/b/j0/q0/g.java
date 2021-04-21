package d.b.j0.q0;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f59634a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.i0.e0.b> f59635b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f59636c;

    /* renamed from: d  reason: collision with root package name */
    public String f59637d;

    /* renamed from: e  reason: collision with root package name */
    public String f59638e;

    /* renamed from: f  reason: collision with root package name */
    public String f59639f;

    public g(Context context, List<FrsTabInfo> list) {
        this.f59634a = list;
        this.f59636c = context;
    }

    public void a(d.b.i0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.b.i0.e0.b bVar2 : this.f59635b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f50888e == bVar.getFragmentTabStructure().f50888e) {
                return;
            }
        }
        this.f59635b.add(bVar);
    }

    public String b() {
        return this.f59637d;
    }

    public String c() {
        return this.f59639f;
    }

    public String d() {
        return this.f59638e;
    }

    public List<FrsTabInfo> e() {
        return this.f59634a;
    }

    public List<d.b.i0.e0.b> f() {
        return this.f59635b;
    }

    public void g(String str) {
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f59637d = str;
    }

    public void j(String str) {
        this.f59639f = str;
    }

    public void k(String str) {
        this.f59638e = str;
    }

    public void l(String str) {
    }
}
