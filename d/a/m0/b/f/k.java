package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class k extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52530c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52531a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52532b;

    public k() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f52531a = arrayList;
        arrayList.add("11_8_hot_a");
        this.f52531a.add("11_8_hot_b");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52531a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52532b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52530c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52532b = eVar;
    }
}
