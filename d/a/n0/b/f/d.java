package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52616c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52617a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52618b;

    public d() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f52617a = arrayList;
        arrayList.add("12_5_emoji_a");
        this.f52617a.add("12_5_emoji_b");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52617a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52618b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52616c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52618b = eVar;
    }
}
