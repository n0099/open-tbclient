package d.a.o0.u1;
/* loaded from: classes4.dex */
public class a {
    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(th.toString());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (int i2 = 0; i2 < stackTrace.length; i2++) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (stackTraceElement != null && i2 < 7) {
                    sb.append(" ----> ");
                    sb.append(stackTraceElement.getClassName());
                    sb.append(".");
                    sb.append(stackTraceElement.getMethodName());
                    sb.append("()");
                }
            }
        }
        return sb.toString();
    }
}
