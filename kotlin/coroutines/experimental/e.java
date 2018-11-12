package kotlin.coroutines.experimental;

import com.baidu.fsg.base.armor.RimArmor;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class e implements d {
    public static final e iqT = new e();

    private e() {
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.h((Object) cVar, RimArmor.KEY);
        return null;
    }

    @Override // kotlin.coroutines.experimental.d
    public <R> R a(R r, kotlin.jvm.a.c<? super R, ? super d.b, ? extends R> cVar) {
        p.h((Object) cVar, "operation");
        return r;
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.h((Object) cVar, RimArmor.KEY);
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
