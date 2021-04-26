package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48024c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48025a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f48026b;

    public r() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48025a = arrayList;
        arrayList.add("12_3_staticopt_a");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f48025a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f48026b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f48024c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f48026b = eVar;
    }
}
