package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50101c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50102a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f50103b;

    public f() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f50102a = arrayList;
        arrayList.add("12_2_frs_default_sort_a");
        this.f50102a.add("12_2_frs_default_sort_b");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f50102a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f50103b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f50101c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f50103b = eVar;
    }
}
