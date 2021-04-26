package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f47982c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f47983a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f47984b;

    public c() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f47983a = arrayList;
        arrayList.add("11_10_user_like_tab");
        this.f47983a.add("11_10_user_like_tab_a");
        this.f47983a.add("11_10_user_like_tab_b");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f47983a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f47984b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f47982c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f47984b = eVar;
    }
}
