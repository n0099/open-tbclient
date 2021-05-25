package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class q extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48871c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48872a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48873b;

    public q() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f48872a = arrayList;
        arrayList.add("11_9_discover_hot_card");
        this.f48872a.add("11_9_discover_hot_card_slogan");
        this.f48872a.add("11_9_discover_hot_card_hot_text");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48872a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48873b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48871c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48873b = eVar;
    }
}
