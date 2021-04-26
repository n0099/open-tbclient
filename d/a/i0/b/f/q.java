package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class q extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48021c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48022a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f48023b;

    public q() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48022a = arrayList;
        arrayList.add("12_3_search_login");
        this.f48022a.add("12_3_search_login_a");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f48022a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f48023b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f48021c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f48023b = eVar;
    }
}
