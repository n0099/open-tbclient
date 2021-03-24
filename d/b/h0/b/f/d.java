package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49701c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49702a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49703b;

    public d() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f49702a = arrayList;
        arrayList.add("12_4_launch_login_a");
        this.f49702a.add("12_4_launch_login_b");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49702a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49703b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49701c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49703b = eVar;
    }
}
