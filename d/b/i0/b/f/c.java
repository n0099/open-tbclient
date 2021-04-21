package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50428c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50429a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50430b;

    public c() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f50429a = arrayList;
        arrayList.add("11_10_user_like_tab");
        this.f50429a.add("11_10_user_like_tab_a");
        this.f50429a.add("11_10_user_like_tab_b");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50429a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50430b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50428c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50430b = eVar;
    }
}
