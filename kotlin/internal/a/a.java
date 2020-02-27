package kotlin.internal.a;

import com.baidu.fsg.base.statistics.b;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public class a extends kotlin.internal.a {
    @Override // kotlin.internal.a
    public void addSuppressed(Throwable th, Throwable th2) {
        q.j(th, "cause");
        q.j(th2, b.k);
        th.addSuppressed(th2);
    }
}
