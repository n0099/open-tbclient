package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class j extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49719c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49720a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49721b;

    public j() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f49720a = arrayList;
        arrayList.add("11_8_hot_a");
        this.f49720a.add("11_8_hot_b");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49720a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49721b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49719c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49721b = eVar;
    }
}
