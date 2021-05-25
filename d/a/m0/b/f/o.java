package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48865c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48866a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48867b;

    public o() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48866a = arrayList;
        arrayList.add("12_4_pb_a");
        this.f48866a.add("12_4_pb_b");
        this.f48866a.add("12_4_pb_c");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48866a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48867b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48865c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48867b = eVar;
    }
}
