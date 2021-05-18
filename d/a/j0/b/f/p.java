package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class p extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48846c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48847a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48848b;

    public p() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f48847a = arrayList;
        arrayList.add("11_9_discover_hot_card");
        this.f48847a.add("11_9_discover_hot_card_slogan");
        this.f48847a.add("11_9_discover_hot_card_hot_text");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48847a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48848b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48846c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48848b = eVar;
    }
}
