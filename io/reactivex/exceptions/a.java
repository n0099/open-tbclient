package io.reactivex.exceptions;

import io.reactivex.internal.util.ExceptionHelper;
/* loaded from: classes7.dex */
public final class a {
    public static RuntimeException v(Throwable th) {
        throw ExceptionHelper.L(th);
    }

    public static void J(Throwable th) {
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
