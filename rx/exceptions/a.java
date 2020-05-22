package rx.exceptions;

import java.util.HashSet;
import java.util.List;
import rx.e;
import rx.i;
/* loaded from: classes6.dex */
public final class a {
    public static RuntimeException y(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new RuntimeException(th);
    }

    public static void L(Throwable th) {
        if (th instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) th);
        }
        if (th instanceof OnErrorFailedException) {
            throw ((OnErrorFailedException) th);
        }
        if (th instanceof OnCompletedFailedException) {
            throw ((OnCompletedFailedException) th);
        }
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

    public static void a(Throwable th, Throwable th2) {
        HashSet hashSet = new HashSet();
        int i = 0;
        while (th.getCause() != null) {
            int i2 = i + 1;
            if (i < 25) {
                th = th.getCause();
                if (!hashSet.contains(th.getCause())) {
                    hashSet.add(th.getCause());
                    i = i2;
                }
            } else {
                return;
            }
        }
        try {
            th.initCause(th2);
        } catch (Throwable th3) {
        }
    }

    public static Throwable V(Throwable th) {
        int i = 0;
        while (th.getCause() != null) {
            int i2 = i + 1;
            if (i >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th = th.getCause();
            i = i2;
        }
        return th;
    }

    public static void fv(List<? extends Throwable> list) {
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                Throwable th = list.get(0);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                throw new RuntimeException(th);
            }
            throw new CompositeException(list);
        }
    }

    public static void a(Throwable th, e<?> eVar, Object obj) {
        L(th);
        eVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
    }

    public static void a(Throwable th, i<?> iVar, Object obj) {
        L(th);
        iVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
    }

    public static void a(Throwable th, e<?> eVar) {
        L(th);
        eVar.onError(th);
    }

    public static void a(Throwable th, i<?> iVar) {
        L(th);
        iVar.onError(th);
    }
}
