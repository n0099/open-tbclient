package kotlin.io;

import java.io.Closeable;
@kotlin.h
/* loaded from: classes9.dex */
public final class a {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th != null) {
                try {
                    closeable.close();
                    return;
                } catch (Throwable th2) {
                    kotlin.a.addSuppressed(th, th2);
                    return;
                }
            }
            closeable.close();
        }
    }
}
