package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48837c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48838a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48839b;

    public m() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48838a = arrayList;
        arrayList.add("12_3_pb_outer_item");
        this.f48838a.add("12_3_pb_outer_item_a");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48838a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48839b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48837c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48839b = eVar;
    }
}
