package d.b.i0.t1;
/* loaded from: classes3.dex */
public class a {
    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(th.toString());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (int i = 0; i < stackTrace.length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if (stackTraceElement != null && i < 7) {
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
