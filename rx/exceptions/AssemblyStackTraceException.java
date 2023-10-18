package rx.exceptions;

import com.baidu.tieba.xac;
import java.util.HashSet;
/* loaded from: classes2.dex */
public final class AssemblyStackTraceException extends RuntimeException {
    public static final long serialVersionUID = 2038859767182585852L;

    public AssemblyStackTraceException(String str) {
        super(str);
    }

    public static AssemblyStackTraceException find(Throwable th) {
        HashSet hashSet = new HashSet();
        while (!(th instanceof AssemblyStackTraceException)) {
            if (th == null || th.getCause() == null) {
                return null;
            }
            th = th.getCause();
            if (!hashSet.add(th)) {
                return null;
            }
        }
        return (AssemblyStackTraceException) th;
    }

    public void attachTo(Throwable th) {
        HashSet hashSet = new HashSet();
        while (th.getCause() != null) {
            th = th.getCause();
            if (!hashSet.add(th)) {
                xac.j(this);
                return;
            }
        }
        try {
            th.initCause(this);
        } catch (IllegalStateException unused) {
            xac.j(new RuntimeException("Received an exception with a cause set to null, instead of being unset. To fix this, look down the chain of causes. The last exception had a cause explicitly set to null. It should be unset instead.", th));
        }
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
