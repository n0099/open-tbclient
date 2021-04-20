package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class i extends a {
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50110c;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50111a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f50112b;

    static {
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "BdUniqueId.gen()");
        f50110c = gen;
    }

    public i() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f50111a = arrayList;
        arrayList.add("12_4_promote_login");
        this.f50111a.add("12_4_promote_login_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f50111a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f50112b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f50110c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f50112b = eVar;
    }
}
