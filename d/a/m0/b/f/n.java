package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class n extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48862c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48863a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48864b;

    public n() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48863a = arrayList;
        arrayList.add("12_3_pb_outer_item");
        this.f48863a.add("12_3_pb_outer_item_a");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48863a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48864b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48862c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48864b = eVar;
    }
}
