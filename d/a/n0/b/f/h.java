package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52628c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52629a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52630b;

    public h() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f52629a = arrayList;
        arrayList.add("12_2_frs_default_tab_a");
        this.f52629a.add("12_2_frs_default_tab_b");
        this.f52629a.add("12_2_frs_default_tab_c");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52629a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52630b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52628c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52630b = eVar;
    }
}
