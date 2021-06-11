package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52539c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52540a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52541b;

    public o() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f52540a = arrayList;
        arrayList.add("12_4_pb_a");
        this.f52540a.add("12_4_pb_b");
        this.f52540a.add("12_4_pb_c");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52540a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52541b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52539c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52541b = eVar;
    }
}
