package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50125c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50126a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f50127b;

    public o() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f50126a = arrayList;
        arrayList.add("12_4_profile");
        this.f50126a.add("12_4_profile_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f50126a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f50127b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f50125c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f50127b = eVar;
    }
}
