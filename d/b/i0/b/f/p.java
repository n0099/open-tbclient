package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class p extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50464c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50465a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50466b;

    public p() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f50465a = arrayList;
        arrayList.add("11_9_discover_hot_card");
        this.f50465a.add("11_9_discover_hot_card_slogan");
        this.f50465a.add("11_9_discover_hot_card_hot_text");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50465a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50466b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50464c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50466b = eVar;
    }
}
