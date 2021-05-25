package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class p extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48868c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48869a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48870b;

    public p() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48869a = arrayList;
        arrayList.add("12_4_profile");
        this.f48869a.add("12_4_profile_a");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48869a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48870b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48868c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48870b = eVar;
    }
}
