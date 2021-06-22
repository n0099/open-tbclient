package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52640c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52641a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52642b;

    public m() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f52641a = arrayList;
        arrayList.add("12_2_pb_picpage");
        this.f52641a.add("12_2_pb_picpage_a");
        this.f52641a.add("12_2_pb_picpage_b");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52641a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52642b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52640c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52642b = eVar;
    }
}
