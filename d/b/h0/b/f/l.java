package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class l extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50116c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50117a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f50118b;

    public l() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f50117a = arrayList;
        arrayList.add("12_2_pb_picpage");
        this.f50117a.add("12_2_pb_picpage_a");
        this.f50117a.add("12_2_pb_picpage_b");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f50117a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f50118b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f50116c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f50118b = eVar;
    }
}
