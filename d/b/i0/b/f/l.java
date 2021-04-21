package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class l extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50452c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50453a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50454b;

    public l() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f50453a = arrayList;
        arrayList.add("12_2_pb_picpage");
        this.f50453a.add("12_2_pb_picpage_a");
        this.f50453a.add("12_2_pb_picpage_b");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50453a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50454b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50452c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50454b = eVar;
    }
}
