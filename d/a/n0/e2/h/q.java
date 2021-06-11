package d.a.n0.e2.h;

import com.baidu.adp.BdUniqueId;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class q implements d.a.c.k.e.n {
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final BdUniqueId f56654e;

    static {
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "BdUniqueId.gen()");
        f56654e = gen;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56654e;
    }
}
