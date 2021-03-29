package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49741c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49742a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49743b;

    public r() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f49742a = arrayList;
        arrayList.add("12_3_staticopt_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49742a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49743b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49741c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49743b = eVar;
    }
}
