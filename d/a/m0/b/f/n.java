package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class n extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52536c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52537a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52538b;

    public n() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f52537a = arrayList;
        arrayList.add("12_3_pb_outer_item");
        this.f52537a.add("12_3_pb_outer_item_a");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52537a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52538b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52536c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52538b = eVar;
    }
}
