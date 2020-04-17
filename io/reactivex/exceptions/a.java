package io.reactivex.exceptions;

import io.reactivex.internal.util.ExceptionHelper;
/* loaded from: classes7.dex */
public final class a {
    public static RuntimeException y(Throwable th) {
        throw ExceptionHelper.N(th);
    }

    public static void L(Throwable th) {
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
