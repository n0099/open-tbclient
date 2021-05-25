package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class s extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48877c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48878a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48879b;

    public s() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48878a = arrayList;
        arrayList.add("12_3_staticopt_a");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48878a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48879b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48877c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48879b = eVar;
    }
}
