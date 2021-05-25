package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class i extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48850c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48851a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48852b;

    public i() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48851a = arrayList;
        arrayList.add("11_7_index_a");
        this.f48851a.add("11_7_index_b");
        this.f48851a.add("11_7_index_c");
        this.f48851a.add("11_7_index_d");
        this.f48851a.add("11_7_index_e");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48851a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48852b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48850c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48852b = eVar;
    }
}
