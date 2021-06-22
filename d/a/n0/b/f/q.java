package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class q extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52652c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52653a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52654b;

    public q() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f52653a = arrayList;
        arrayList.add("11_9_discover_hot_card");
        this.f52653a.add("11_9_discover_hot_card_slogan");
        this.f52653a.add("11_9_discover_hot_card_hot_text");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52653a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52654b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52652c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52654b = eVar;
    }
}
