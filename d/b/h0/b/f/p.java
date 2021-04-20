package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class p extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50128c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50129a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f50130b;

    public p() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f50129a = arrayList;
        arrayList.add("11_9_discover_hot_card");
        this.f50129a.add("11_9_discover_hot_card_slogan");
        this.f50129a.add("11_9_discover_hot_card_hot_text");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f50129a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f50130b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f50128c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f50130b = eVar;
    }
}
