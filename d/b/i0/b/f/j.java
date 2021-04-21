package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class j extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50449c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50450a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50451b;

    public j() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f50450a = arrayList;
        arrayList.add("11_8_hot_a");
        this.f50450a.add("11_8_hot_b");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50450a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50451b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50449c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50451b = eVar;
    }
}
