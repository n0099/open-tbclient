package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class i extends a {
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48000c;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48001a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f48002b;

    static {
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "BdUniqueId.gen()");
        f48000c = gen;
    }

    public i() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f48001a = arrayList;
        arrayList.add("12_4_promote_login");
        this.f48001a.add("12_4_promote_login_a");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f48001a;
    }

    @Override // d.a.i0.b.f.a
    public d.a.i0.b.e b() {
        return this.f48002b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f48000c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f48002b = eVar;
    }
}
