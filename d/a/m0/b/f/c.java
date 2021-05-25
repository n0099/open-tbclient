package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48832c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48833a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48834b;

    public c() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f48833a = arrayList;
        arrayList.add("11_10_user_like_tab");
        this.f48833a.add("11_10_user_like_tab_a");
        this.f48833a.add("11_10_user_like_tab_b");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48833a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48834b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48832c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48834b = eVar;
    }
}
