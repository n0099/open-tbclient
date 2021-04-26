package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f47997c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f47998a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f47999b;

    public h() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f47998a = arrayList;
        arrayList.add("11_7_index_a");
        this.f47998a.add("11_7_index_b");
        this.f47998a.add("11_7_index_c");
        this.f47998a.add("11_7_index_d");
        this.f47998a.add("11_7_index_e");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f47998a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f47999b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f47997c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f47999b = eVar;
    }
}
