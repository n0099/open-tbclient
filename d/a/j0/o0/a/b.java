package d.a.j0.o0.a;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class b implements i {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BawuRoleInfoPub> f57121a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f57122b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57123c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f57124d;

    @Override // d.a.j0.o0.a.i
    public int a() {
        return 1;
    }

    public boolean b() {
        return this.f57123c;
    }

    public ArrayList<BawuRoleInfoPub> c() {
        return this.f57121a;
    }

    public String d() {
        return this.f57124d;
    }

    public boolean e() {
        return this.f57122b;
    }

    public void f(boolean z) {
        this.f57123c = z;
    }

    public void g(boolean z) {
        this.f57122b = z;
    }

    public void h(ArrayList<BawuRoleInfoPub> arrayList) {
        this.f57121a = arrayList;
    }

    public void i(String str) {
        this.f57124d = str;
    }
}
