package com.facebook.common.internal;

import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public final class k {
    public static <X extends Throwable> void a(@Nullable Throwable th, Class<X> cls) throws Throwable {
        if (th != null && cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void q(@Nullable Throwable th) {
        a(th, Error.class);
        a(th, RuntimeException.class);
    }

    public static RuntimeException r(Throwable th) {
        q((Throwable) g.checkNotNull(th));
        throw new RuntimeException(th);
    }
}
