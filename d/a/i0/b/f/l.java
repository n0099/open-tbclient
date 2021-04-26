package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class l extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48006c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48007a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f48008b;

    public l() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f48007a = arrayList;
        arrayList.add("12_2_pb_picpage");
        this.f48007a.add("12_2_pb_picpage_a");
        this.f48007a.add("12_2_pb_picpage_b");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f48007a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f48008b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f48006c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f48008b = eVar;
    }
}
