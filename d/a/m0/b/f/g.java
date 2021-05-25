package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48844c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48845a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48846b;

    public g() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48845a = arrayList;
        arrayList.add("12_2_frs_default_sort_a");
        this.f48845a.add("12_2_frs_default_sort_b");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48845a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48846b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48844c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48846b = eVar;
    }
}
