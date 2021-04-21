package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50425c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50426a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50427b;

    public b() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f50426a = arrayList;
        arrayList.add("11_9_backuser_a");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50426a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50427b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50425c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50427b = eVar;
    }
}
