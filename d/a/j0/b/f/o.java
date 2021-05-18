package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48843c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48844a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48845b;

    public o() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48844a = arrayList;
        arrayList.add("12_4_profile");
        this.f48844a.add("12_4_profile_a");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48844a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48845b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48843c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48845b = eVar;
    }
}
