package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52610c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52611a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52612b;

    public b() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f52611a = arrayList;
        arrayList.add("11_9_backuser_a");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52611a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52612b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52610c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52612b = eVar;
    }
}
