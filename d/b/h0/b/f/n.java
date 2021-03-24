package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class n extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49728c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49729a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49730b;

    public n() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f49729a = arrayList;
        arrayList.add("12_4_pb_a");
        this.f49729a.add("12_4_pb_b");
        this.f49729a.add("12_4_pb_c");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49729a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49730b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49728c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49730b = eVar;
    }
}
