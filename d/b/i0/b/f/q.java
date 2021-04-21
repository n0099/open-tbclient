package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class q extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50467c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50468a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50469b;

    public q() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f50468a = arrayList;
        arrayList.add("12_3_search_login");
        this.f50468a.add("12_3_search_login_a");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50468a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50469b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50467c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50469b = eVar;
    }
}
