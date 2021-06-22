package d.a.o0.e2.h;

import com.baidu.adp.BdUniqueId;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class q implements d.a.c.k.e.n {
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final BdUniqueId f56779e;

    static {
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "BdUniqueId.gen()");
        f56779e = gen;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56779e;
    }
}
