package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class j extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48003c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48004a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f48005b;

    public j() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48004a = arrayList;
        arrayList.add("11_8_hot_a");
        this.f48004a.add("11_8_hot_b");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f48004a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f48005b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f48003c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f48005b = eVar;
    }
}
