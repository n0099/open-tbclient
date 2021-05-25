package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48835c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48836a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48837b;

    public d() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48836a = arrayList;
        arrayList.add("12_5_emoji_a");
        this.f48836a.add("12_5_emoji_b");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48836a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48837b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48835c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48837b = eVar;
    }
}
