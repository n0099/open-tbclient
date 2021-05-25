package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48847c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48848a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48849b;

    public h() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f48848a = arrayList;
        arrayList.add("12_2_frs_default_tab_a");
        this.f48848a.add("12_2_frs_default_tab_b");
        this.f48848a.add("12_2_frs_default_tab_c");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48848a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48849b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48847c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48849b = eVar;
    }
}
