package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f47985c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f47986a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f47987b;

    public d() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f47986a = arrayList;
        arrayList.add("12_4_launch_login_a");
        this.f47986a.add("12_4_launch_login_b");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f47986a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f47987b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f47985c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f47987b = eVar;
    }
}
