package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class q extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52545c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52546a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52547b;

    public q() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f52546a = arrayList;
        arrayList.add("11_9_discover_hot_card");
        this.f52546a.add("11_9_discover_hot_card_slogan");
        this.f52546a.add("11_9_discover_hot_card_hot_text");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52546a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52547b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52545c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52547b = eVar;
    }
}
