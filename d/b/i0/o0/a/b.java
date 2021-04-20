package d.b.i0.o0.a;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class b implements i {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BawuRoleInfoPub> f58677a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f58678b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58679c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f58680d;

    @Override // d.b.i0.o0.a.i
    public int a() {
        return 1;
    }

    public boolean b() {
        return this.f58679c;
    }

    public ArrayList<BawuRoleInfoPub> c() {
        return this.f58677a;
    }

    public String d() {
        return this.f58680d;
    }

    public boolean e() {
        return this.f58678b;
    }

    public void f(boolean z) {
        this.f58679c = z;
    }

    public void g(boolean z) {
        this.f58678b = z;
    }

    public void h(ArrayList<BawuRoleInfoPub> arrayList) {
        this.f58677a = arrayList;
    }

    public void i(String str) {
        this.f58680d = str;
    }
}
