package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class k extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52637c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52638a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52639b;

    public k() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f52638a = arrayList;
        arrayList.add("11_8_hot_a");
        this.f52638a.add("11_8_hot_b");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52638a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52639b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52637c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52639b = eVar;
    }
}
