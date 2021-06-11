package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52548c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52549a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52550b;

    public r() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f52549a = arrayList;
        arrayList.add("12_3_search_login");
        this.f52549a.add("12_3_search_login_a");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52549a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52550b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52548c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52550b = eVar;
    }
}
