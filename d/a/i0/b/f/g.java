package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f47994c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f47995a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f47996b;

    public g() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f47995a = arrayList;
        arrayList.add("12_2_frs_default_tab_a");
        this.f47995a.add("12_2_frs_default_tab_b");
        this.f47995a.add("12_2_frs_default_tab_c");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f47995a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f47996b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f47994c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f47996b = eVar;
    }
}
