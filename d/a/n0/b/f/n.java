package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class n extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52643c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52644a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52645b;

    public n() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f52644a = arrayList;
        arrayList.add("12_3_pb_outer_item");
        this.f52644a.add("12_3_pb_outer_item_a");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52644a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52645b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52643c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52645b = eVar;
    }
}
