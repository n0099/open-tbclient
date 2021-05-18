package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class n extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48840c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48841a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48842b;

    public n() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48841a = arrayList;
        arrayList.add("12_4_pb_a");
        this.f48841a.add("12_4_pb_b");
        this.f48841a.add("12_4_pb_c");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48841a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48842b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48840c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48842b = eVar;
    }
}
