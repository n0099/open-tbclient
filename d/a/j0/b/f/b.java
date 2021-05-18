package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48807c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48808a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48809b;

    public b() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48808a = arrayList;
        arrayList.add("11_9_backuser_a");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48808a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48809b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48807c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48809b = eVar;
    }
}
