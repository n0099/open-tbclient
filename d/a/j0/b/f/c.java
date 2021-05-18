package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48810c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48811a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48812b;

    public c() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f48811a = arrayList;
        arrayList.add("11_10_user_like_tab");
        this.f48811a.add("11_10_user_like_tab_a");
        this.f48811a.add("11_10_user_like_tab_b");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48811a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48812b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48810c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48812b = eVar;
    }
}
