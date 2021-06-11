package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52509c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52510a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52511b;

    public d() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f52510a = arrayList;
        arrayList.add("12_5_emoji_a");
        this.f52510a.add("12_5_emoji_b");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52510a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52511b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52509c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52511b = eVar;
    }
}
