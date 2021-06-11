package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class j extends a {
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52527c;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52528a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52529b;

    static {
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "BdUniqueId.gen()");
        f52527c = gen;
    }

    public j() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f52528a = arrayList;
        arrayList.add("12_4_promote_login");
        this.f52528a.add("12_4_promote_login_a");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52528a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52529b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52527c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52529b = eVar;
    }
}
