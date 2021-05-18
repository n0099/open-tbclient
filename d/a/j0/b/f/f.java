package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48819c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48820a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48821b;

    public f() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48820a = arrayList;
        arrayList.add("12_2_frs_default_sort_a");
        this.f48820a.add("12_2_frs_default_sort_b");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48820a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48821b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48819c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48821b = eVar;
    }
}
