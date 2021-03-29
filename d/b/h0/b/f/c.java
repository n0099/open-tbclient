package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49699c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49700a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49701b;

    public c() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.f49700a = arrayList;
        arrayList.add("11_10_user_like_tab");
        this.f49700a.add("11_10_user_like_tab_a");
        this.f49700a.add("11_10_user_like_tab_b");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49700a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49701b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49699c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49701b = eVar;
    }
}
