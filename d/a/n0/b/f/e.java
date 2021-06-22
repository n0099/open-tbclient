package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52619c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52620a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52621b;

    public e() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f52620a = arrayList;
        arrayList.add("12_4_launch_login_a");
        this.f52620a.add("12_4_launch_login_b");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52620a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52621b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52619c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52621b = eVar;
    }
}
