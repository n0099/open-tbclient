package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class q extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50131c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50132a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f50133b;

    public q() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f50132a = arrayList;
        arrayList.add("12_3_search_login");
        this.f50132a.add("12_3_search_login_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f50132a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f50133b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f50131c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f50133b = eVar;
    }
}
