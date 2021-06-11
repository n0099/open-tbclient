package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class i extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52524c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52525a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52526b;

    public i() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f52525a = arrayList;
        arrayList.add("11_7_index_a");
        this.f52525a.add("11_7_index_b");
        this.f52525a.add("11_7_index_c");
        this.f52525a.add("11_7_index_d");
        this.f52525a.add("11_7_index_e");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52525a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52526b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52524c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52526b = eVar;
    }
}
