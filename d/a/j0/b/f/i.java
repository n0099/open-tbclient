package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class i extends a {
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48828c;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48829a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48830b;

    static {
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "BdUniqueId.gen()");
        f48828c = gen;
    }

    public i() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48829a = arrayList;
        arrayList.add("12_4_promote_login");
        this.f48829a.add("12_4_promote_login_a");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48829a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48830b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48828c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48830b = eVar;
    }
}
