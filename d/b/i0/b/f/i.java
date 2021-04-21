package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class i extends a {
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50446c;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50447a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50448b;

    static {
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "BdUniqueId.gen()");
        f50446c = gen;
    }

    public i() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f50447a = arrayList;
        arrayList.add("12_4_promote_login");
        this.f50447a.add("12_4_promote_login_a");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50447a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50448b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50446c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50448b = eVar;
    }
}
