package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52655c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52656a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52657b;

    public r() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f52656a = arrayList;
        arrayList.add("12_3_search_login");
        this.f52656a.add("12_3_search_login_a");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52656a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52657b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52655c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52657b = eVar;
    }
}
