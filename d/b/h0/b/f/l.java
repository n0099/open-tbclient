package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class l extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49722c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49723a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49724b;

    public l() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f49723a = arrayList;
        arrayList.add("12_2_pb_picpage");
        this.f49723a.add("12_2_pb_picpage_a");
        this.f49723a.add("12_2_pb_picpage_b");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49723a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49724b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49722c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49724b = eVar;
    }
}
