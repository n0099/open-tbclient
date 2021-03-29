package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class l extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49723c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49724a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49725b;

    public l() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f49724a = arrayList;
        arrayList.add("12_2_pb_picpage");
        this.f49724a.add("12_2_pb_picpage_a");
        this.f49724a.add("12_2_pb_picpage_b");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49724a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49725b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49723c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49725b = eVar;
    }
}
