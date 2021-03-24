package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49713c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49714a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49715b;

    public h() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f49714a = arrayList;
        arrayList.add("11_7_index_a");
        this.f49714a.add("11_7_index_b");
        this.f49714a.add("11_7_index_c");
        this.f49714a.add("11_7_index_d");
        this.f49714a.add("11_7_index_e");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49714a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49715b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49713c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49715b = eVar;
    }
}
