package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class j extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48831c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48832a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48833b;

    public j() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48832a = arrayList;
        arrayList.add("11_8_hot_a");
        this.f48832a.add("11_8_hot_b");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48832a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48833b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48831c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48833b = eVar;
    }
}
