package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50455c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50456a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50457b;

    public m() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f50456a = arrayList;
        arrayList.add("12_3_pb_outer_item");
        this.f50456a.add("12_3_pb_outer_item_a");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50456a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50457b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50455c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50457b = eVar;
    }
}
