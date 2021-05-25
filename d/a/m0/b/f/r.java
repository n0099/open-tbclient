package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48874c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48875a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48876b;

    public r() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48875a = arrayList;
        arrayList.add("12_3_search_login");
        this.f48875a.add("12_3_search_login_a");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48875a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48876b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48874c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48876b = eVar;
    }
}
