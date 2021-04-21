package d.b.j0.o0.a;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class b implements i {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BawuRoleInfoPub> f59098a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f59099b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59100c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f59101d;

    @Override // d.b.j0.o0.a.i
    public int a() {
        return 1;
    }

    public boolean b() {
        return this.f59100c;
    }

    public ArrayList<BawuRoleInfoPub> c() {
        return this.f59098a;
    }

    public String d() {
        return this.f59101d;
    }

    public boolean e() {
        return this.f59099b;
    }

    public void f(boolean z) {
        this.f59100c = z;
    }

    public void g(boolean z) {
        this.f59099b = z;
    }

    public void h(ArrayList<BawuRoleInfoPub> arrayList) {
        this.f59098a = arrayList;
    }

    public void i(String str) {
        this.f59101d = str;
    }
}
