package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48852c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48853a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48854b;

    public r() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48853a = arrayList;
        arrayList.add("12_3_staticopt_a");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48853a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48854b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48852c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48854b = eVar;
    }
}
