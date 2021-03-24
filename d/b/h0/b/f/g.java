package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49710c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49711a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49712b;

    public g() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f49711a = arrayList;
        arrayList.add("12_2_frs_default_tab_a");
        this.f49711a.add("12_2_frs_default_tab_b");
        this.f49711a.add("12_2_frs_default_tab_c");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49711a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49712b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49710c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49712b = eVar;
    }
}
