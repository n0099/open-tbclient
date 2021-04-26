package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class p extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48018c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48019a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f48020b;

    public p() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f48019a = arrayList;
        arrayList.add("11_9_discover_hot_card");
        this.f48019a.add("11_9_discover_hot_card_slogan");
        this.f48019a.add("11_9_discover_hot_card_hot_text");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f48019a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f48020b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f48018c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f48020b = eVar;
    }
}
