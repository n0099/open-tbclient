package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48838c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48839a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48840b;

    public e() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48839a = arrayList;
        arrayList.add("12_4_launch_login_a");
        this.f48839a.add("12_4_launch_login_b");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48839a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48840b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48838c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48840b = eVar;
    }
}
