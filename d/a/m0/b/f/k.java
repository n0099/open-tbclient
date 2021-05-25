package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class k extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48856c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48857a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48858b;

    public k() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48857a = arrayList;
        arrayList.add("11_8_hot_a");
        this.f48857a.add("11_8_hot_b");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48857a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48858b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48856c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48858b = eVar;
    }
}
