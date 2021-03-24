package d.b.i0.n0.a;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class b implements i {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BawuRoleInfoPub> f56977a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f56978b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56979c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f56980d;

    @Override // d.b.i0.n0.a.i
    public int a() {
        return 1;
    }

    public boolean b() {
        return this.f56979c;
    }

    public ArrayList<BawuRoleInfoPub> c() {
        return this.f56977a;
    }

    public String d() {
        return this.f56980d;
    }

    public boolean e() {
        return this.f56978b;
    }

    public void f(boolean z) {
        this.f56979c = z;
    }

    public void g(boolean z) {
        this.f56978b = z;
    }

    public void h(ArrayList<BawuRoleInfoPub> arrayList) {
        this.f56977a = arrayList;
    }

    public void i(String str) {
        this.f56980d = str;
    }
}
