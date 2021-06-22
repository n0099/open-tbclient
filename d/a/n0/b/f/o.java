package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52646c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52647a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52648b;

    public o() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f52647a = arrayList;
        arrayList.add("12_4_pb_a");
        this.f52647a.add("12_4_pb_b");
        this.f52647a.add("12_4_pb_c");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52647a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52648b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52646c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52648b = eVar;
    }
}
