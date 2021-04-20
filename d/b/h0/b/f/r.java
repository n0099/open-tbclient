package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50134c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50135a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f50136b;

    public r() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f50135a = arrayList;
        arrayList.add("12_3_staticopt_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f50135a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f50136b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f50134c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f50136b = eVar;
    }
}
