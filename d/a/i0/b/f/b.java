package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f47979c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f47980a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f47981b;

    public b() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f47980a = arrayList;
        arrayList.add("11_9_backuser_a");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f47980a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f47981b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f47979c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f47981b = eVar;
    }
}
