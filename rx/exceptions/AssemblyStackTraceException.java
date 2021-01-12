package rx.exceptions;

import java.util.HashSet;
import rx.c.c;
/* loaded from: classes14.dex */
public final class AssemblyStackTraceException extends RuntimeException {
    private static final long serialVersionUID = 2038859767182585852L;

    public AssemblyStackTraceException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public void attachTo(Throwable th) {
        HashSet hashSet = new HashSet();
        while (th.getCause() != null) {
            th = th.getCause();
            if (!hashSet.add(th)) {
                c.onError(this);
                return;
            }
        }
        try {
            th.initCause(this);
        } catch (IllegalStateException e) {
            c.onError(new RuntimeException("Received an exception with a cause set to null, instead of being unset. To fix this, look down the chain of causes. The last exception had a cause explicitly set to null. It should be unset instead.", th));
        }
    }

    public static AssemblyStackTraceException find(Throwable th) {
        HashSet hashSet = new HashSet();
        Throwable th2 = th;
        while (!(th2 instanceof AssemblyStackTraceException)) {
            if (th2 == null || th2.getCause() == null) {
                return null;
            }
            th2 = th2.getCause();
            if (!hashSet.add(th2)) {
                return null;
            }
        }
        return (AssemblyStackTraceException) th2;
    }
}
