package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49740c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49741a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49742b;

    public r() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f49741a = arrayList;
        arrayList.add("12_3_staticopt_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49741a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49742b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49740c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49742b = eVar;
    }
}
