package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48822c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48823a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48824b;

    public g() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f48823a = arrayList;
        arrayList.add("12_2_frs_default_tab_a");
        this.f48823a.add("12_2_frs_default_tab_b");
        this.f48823a.add("12_2_frs_default_tab_c");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48823a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48824b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48822c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48824b = eVar;
    }
}
