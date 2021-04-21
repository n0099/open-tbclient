package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50461c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50462a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50463b;

    public o() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f50462a = arrayList;
        arrayList.add("12_4_profile");
        this.f50462a.add("12_4_profile_a");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50462a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50463b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50461c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50463b = eVar;
    }
}
