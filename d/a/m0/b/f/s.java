package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class s extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52551c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52552a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52553b;

    public s() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f52552a = arrayList;
        arrayList.add("12_3_staticopt_a");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52552a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52553b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52551c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52553b = eVar;
    }
}
