package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class d {
    public static final StackTraceElement a(BaseContinuationImpl baseContinuationImpl) {
        q.j(baseContinuationImpl, "receiver$0");
        c b = b(baseContinuationImpl);
        if (b == null) {
            return null;
        }
        en(1, b.v());
        int c = c(baseContinuationImpl);
        int i = c < 0 ? -1 : b.dJh()[c];
        String d = f.nBw.d(baseContinuationImpl);
        return new StackTraceElement(d == null ? b.c() : d + '/' + b.c(), b.m(), b.f(), i);
    }

    private static final c b(BaseContinuationImpl baseContinuationImpl) {
        return (c) baseContinuationImpl.getClass().getAnnotation(c.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            q.i(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception e) {
            return -1;
        }
    }

    private static final void en(int i, int i2) {
        if (i2 > i) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
        }
    }
}
