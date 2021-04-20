package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50104c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50105a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f50106b;

    public g() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f50105a = arrayList;
        arrayList.add("12_2_frs_default_tab_a");
        this.f50105a.add("12_2_frs_default_tab_b");
        this.f50105a.add("12_2_frs_default_tab_c");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f50105a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f50106b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f50104c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f50106b = eVar;
    }
}
