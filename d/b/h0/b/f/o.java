package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49732c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49733a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49734b;

    public o() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f49733a = arrayList;
        arrayList.add("12_4_profile");
        this.f49733a.add("12_4_profile_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49733a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49734b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49732c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49734b = eVar;
    }
}
