package io.reactivex.exceptions;

import io.reactivex.internal.util.ExceptionHelper;
/* loaded from: classes5.dex */
public final class a {
    public static RuntimeException u(Throwable th) {
        throw ExceptionHelper.K(th);
    }

    public static void I(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
