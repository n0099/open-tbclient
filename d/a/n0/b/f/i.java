package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class i extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52631c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52632a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52633b;

    public i() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f52632a = arrayList;
        arrayList.add("11_7_index_a");
        this.f52632a.add("11_7_index_b");
        this.f52632a.add("11_7_index_c");
        this.f52632a.add("11_7_index_d");
        this.f52632a.add("11_7_index_e");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52632a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52633b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52631c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52633b = eVar;
    }
}
