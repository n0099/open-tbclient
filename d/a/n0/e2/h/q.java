package d.a.n0.e2.h;

import com.baidu.adp.BdUniqueId;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class q implements d.a.c.j.e.n {
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final BdUniqueId f52965e;

    static {
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "BdUniqueId.gen()");
        f52965e = gen;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52965e;
    }
}
