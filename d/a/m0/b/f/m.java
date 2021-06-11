package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52533c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52534a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52535b;

    public m() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f52534a = arrayList;
        arrayList.add("12_2_pb_picpage");
        this.f52534a.add("12_2_pb_picpage_a");
        this.f52534a.add("12_2_pb_picpage_b");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52534a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52535b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52533c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52535b = eVar;
    }
}
