package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48825c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48826a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48827b;

    public h() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48826a = arrayList;
        arrayList.add("11_7_index_a");
        this.f48826a.add("11_7_index_b");
        this.f48826a.add("11_7_index_c");
        this.f48826a.add("11_7_index_d");
        this.f48826a.add("11_7_index_e");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48826a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48827b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48825c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48827b = eVar;
    }
}
