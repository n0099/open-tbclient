package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class n extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48012c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48013a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f48014b;

    public n() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48013a = arrayList;
        arrayList.add("12_4_pb_a");
        this.f48013a.add("12_4_pb_b");
        this.f48013a.add("12_4_pb_c");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f48013a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f48014b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f48012c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f48014b = eVar;
    }
}
