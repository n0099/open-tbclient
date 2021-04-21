package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50470c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50471a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50472b;

    public r() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f50471a = arrayList;
        arrayList.add("12_3_staticopt_a");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50471a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50472b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50470c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50472b = eVar;
    }
}
