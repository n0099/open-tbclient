package d.a.o0.p0.a;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class b implements i {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BawuRoleInfoPub> f61753a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f61754b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61755c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f61756d;

    @Override // d.a.o0.p0.a.i
    public int a() {
        return 1;
    }

    public boolean b() {
        return this.f61755c;
    }

    public ArrayList<BawuRoleInfoPub> c() {
        return this.f61753a;
    }

    public String d() {
        return this.f61756d;
    }

    public boolean e() {
        return this.f61754b;
    }

    public void f(boolean z) {
        this.f61755c = z;
    }

    public void g(boolean z) {
        this.f61754b = z;
    }

    public void h(ArrayList<BawuRoleInfoPub> arrayList) {
        this.f61753a = arrayList;
    }

    public void i(String str) {
        this.f61756d = str;
    }
}
