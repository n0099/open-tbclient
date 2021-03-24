package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49695c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49696a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49697b;

    public b() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f49696a = arrayList;
        arrayList.add("11_9_backuser_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49696a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49697b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49695c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49697b = eVar;
    }
}
