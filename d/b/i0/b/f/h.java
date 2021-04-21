package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50443c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50444a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50445b;

    public h() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f50444a = arrayList;
        arrayList.add("11_7_index_a");
        this.f50444a.add("11_7_index_b");
        this.f50444a.add("11_7_index_c");
        this.f50444a.add("11_7_index_d");
        this.f50444a.add("11_7_index_e");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50444a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50445b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50443c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50445b = eVar;
    }
}
