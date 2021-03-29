package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class j extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49720c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49721a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49722b;

    public j() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f49721a = arrayList;
        arrayList.add("11_8_hot_a");
        this.f49721a.add("11_8_hot_b");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49721a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49722b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49720c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49722b = eVar;
    }
}
