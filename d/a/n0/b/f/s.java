package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class s extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52658c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52659a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52660b;

    public s() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f52659a = arrayList;
        arrayList.add("12_3_staticopt_a");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52659a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52660b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52658c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52660b = eVar;
    }
}
