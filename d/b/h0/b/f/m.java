package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49725c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49726a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49727b;

    public m() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f49726a = arrayList;
        arrayList.add("12_3_pb_outer_item");
        this.f49726a.add("12_3_pb_outer_item_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49726a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49727b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49725c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49727b = eVar;
    }
}
