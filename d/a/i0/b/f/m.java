package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48009c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48010a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f48011b;

    public m() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48010a = arrayList;
        arrayList.add("12_3_pb_outer_item");
        this.f48010a.add("12_3_pb_outer_item_a");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f48010a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f48011b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f48009c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f48011b = eVar;
    }
}
