package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52625c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52626a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52627b;

    public g() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f52626a = arrayList;
        arrayList.add("12_2_frs_default_sort_a");
        this.f52626a.add("12_2_frs_default_sort_b");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52626a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52627b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52625c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52627b = eVar;
    }
}
