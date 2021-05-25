package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48829c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48830a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48831b;

    public b() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48830a = arrayList;
        arrayList.add("11_9_backuser_a");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48830a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48831b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48829c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48831b = eVar;
    }
}
