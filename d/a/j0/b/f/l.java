package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class l extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48834c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48835a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48836b;

    public l() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f48835a = arrayList;
        arrayList.add("12_2_pb_picpage");
        this.f48835a.add("12_2_pb_picpage_a");
        this.f48835a.add("12_2_pb_picpage_b");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48835a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48836b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48834c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48836b = eVar;
    }
}
