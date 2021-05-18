package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48813c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48814a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48815b;

    public d() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48814a = arrayList;
        arrayList.add("12_4_launch_login_a");
        this.f48814a.add("12_4_launch_login_b");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48814a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48815b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48813c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48815b = eVar;
    }
}
