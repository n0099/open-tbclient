package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50431c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50432a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50433b;

    public d() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f50432a = arrayList;
        arrayList.add("12_4_launch_login_a");
        this.f50432a.add("12_4_launch_login_b");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50432a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50433b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50431c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50433b = eVar;
    }
}
