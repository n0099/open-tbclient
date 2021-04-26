package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48015c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48016a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f48017b;

    public o() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48016a = arrayList;
        arrayList.add("12_4_profile");
        this.f48016a.add("12_4_profile_a");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f48016a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f48017b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f48015c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f48017b = eVar;
    }
}
