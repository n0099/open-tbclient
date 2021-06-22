package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52613c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52614a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52615b;

    public c() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f52614a = arrayList;
        arrayList.add("11_10_user_like_tab");
        this.f52614a.add("11_10_user_like_tab_a");
        this.f52614a.add("11_10_user_like_tab_b");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52614a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52615b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52613c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52615b = eVar;
    }
}
