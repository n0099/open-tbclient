package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50092c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50093a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f50094b;

    public c() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f50093a = arrayList;
        arrayList.add("11_10_user_like_tab");
        this.f50093a.add("11_10_user_like_tab_a");
        this.f50093a.add("11_10_user_like_tab_b");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f50093a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f50094b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f50092c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f50094b = eVar;
    }
}
