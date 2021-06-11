package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52518c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52519a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52520b;

    public g() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f52519a = arrayList;
        arrayList.add("12_2_frs_default_sort_a");
        this.f52519a.add("12_2_frs_default_sort_b");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52519a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52520b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52518c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52520b = eVar;
    }
}
