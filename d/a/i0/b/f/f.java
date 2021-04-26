package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f47991c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f47992a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f47993b;

    public f() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f47992a = arrayList;
        arrayList.add("12_2_frs_default_sort_a");
        this.f47992a.add("12_2_frs_default_sort_b");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f47992a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f47993b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f47991c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f47993b = eVar;
    }
}
