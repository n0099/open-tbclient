package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class j extends a {
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48853c;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48854a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48855b;

    static {
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "BdUniqueId.gen()");
        f48853c = gen;
    }

    public j() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48854a = arrayList;
        arrayList.add("12_4_promote_login");
        this.f48854a.add("12_4_promote_login_a");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48854a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48855b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48853c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48855b = eVar;
    }
}
