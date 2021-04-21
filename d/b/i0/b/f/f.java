package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50437c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50438a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50439b;

    public f() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f50438a = arrayList;
        arrayList.add("12_2_frs_default_sort_a");
        this.f50438a.add("12_2_frs_default_sort_b");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50438a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50439b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50437c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50439b = eVar;
    }
}
