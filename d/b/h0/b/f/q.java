package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class q extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49737c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49738a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49739b;

    public q() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f49738a = arrayList;
        arrayList.add("12_3_search_login");
        this.f49738a.add("12_3_search_login_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49738a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49739b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49737c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49739b = eVar;
    }
}
