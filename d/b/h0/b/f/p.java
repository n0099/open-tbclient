package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class p extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49734c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49735a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49736b;

    public p() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f49735a = arrayList;
        arrayList.add("11_9_discover_hot_card");
        this.f49735a.add("11_9_discover_hot_card_slogan");
        this.f49735a.add("11_9_discover_hot_card_hot_text");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49735a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49736b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49734c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49736b = eVar;
    }
}
