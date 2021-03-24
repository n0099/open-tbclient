package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49707c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49708a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49709b;

    public f() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f49708a = arrayList;
        arrayList.add("12_2_frs_default_sort_a");
        this.f49708a.add("12_2_frs_default_sort_b");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49708a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49709b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49707c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49709b = eVar;
    }
}
