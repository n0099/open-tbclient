package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class i extends a {
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49716c;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49717a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49718b;

    static {
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "BdUniqueId.gen()");
        f49716c = gen;
    }

    public i() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f49717a = arrayList;
        arrayList.add("12_4_promote_login");
        this.f49717a.add("12_4_promote_login_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49717a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49718b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49716c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49718b = eVar;
    }
}
