package d.a.n0.p0.a;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class b implements i {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BawuRoleInfoPub> f61628a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f61629b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61630c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f61631d;

    @Override // d.a.n0.p0.a.i
    public int a() {
        return 1;
    }

    public boolean b() {
        return this.f61630c;
    }

    public ArrayList<BawuRoleInfoPub> c() {
        return this.f61628a;
    }

    public String d() {
        return this.f61631d;
    }

    public boolean e() {
        return this.f61629b;
    }

    public void f(boolean z) {
        this.f61630c = z;
    }

    public void g(boolean z) {
        this.f61629b = z;
    }

    public void h(ArrayList<BawuRoleInfoPub> arrayList) {
        this.f61628a = arrayList;
    }

    public void i(String str) {
        this.f61631d = str;
    }
}
