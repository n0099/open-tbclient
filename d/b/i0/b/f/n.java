package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class n extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50458c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50459a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50460b;

    public n() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f50459a = arrayList;
        arrayList.add("12_4_pb_a");
        this.f50459a.add("12_4_pb_b");
        this.f50459a.add("12_4_pb_c");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50459a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50460b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50458c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50460b = eVar;
    }
}
