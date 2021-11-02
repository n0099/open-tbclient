package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b\u0005\u0010\t\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0087\b¢\u0006\u0004\b\u0005\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\"#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\u00020\u00008F@\u0006¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016*\u00020\u00008F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"", "exception", "", "addSuppressed", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "printStackTrace", "(Ljava/lang/Throwable;)V", "Ljava/io/PrintStream;", "stream", "(Ljava/lang/Throwable;Ljava/io/PrintStream;)V", "Ljava/io/PrintWriter;", "writer", "(Ljava/lang/Throwable;Ljava/io/PrintWriter;)V", "", "stackTraceToString", "(Ljava/lang/Throwable;)Ljava/lang/String;", "", "Ljava/lang/StackTraceElement;", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "getStackTrace$annotations", "stackTrace", "", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "getSuppressedExceptions$annotations", "suppressedExceptions", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/ExceptionsKt")
/* loaded from: classes3.dex */
public class ExceptionsKt__ExceptionsKt {
    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static final void addSuppressed(Throwable addSuppressed, Throwable exception) {
        Intrinsics.checkNotNullParameter(addSuppressed, "$this$addSuppressed");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (addSuppressed != exception) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(addSuppressed, exception);
        }
    }

    public static final StackTraceElement[] getStackTrace(Throwable stackTrace) {
        Intrinsics.checkNotNullParameter(stackTrace, "$this$stackTrace");
        StackTraceElement[] stackTrace2 = stackTrace.getStackTrace();
        Intrinsics.checkNotNull(stackTrace2);
        return stackTrace2;
    }

    public static /* synthetic */ void getStackTrace$annotations(Throwable th) {
    }

    public static final List<Throwable> getSuppressedExceptions(Throwable suppressedExceptions) {
        Intrinsics.checkNotNullParameter(suppressedExceptions, "$this$suppressedExceptions");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(suppressedExceptions);
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable th) {
    }

    @InlineOnly
    public static final void printStackTrace(Throwable th) {
        if (th == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace();
    }

    @SinceKotlin(version = "1.4")
    public static final String stackTraceToString(Throwable stackTraceToString) {
        Intrinsics.checkNotNullParameter(stackTraceToString, "$this$stackTraceToString");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        stackTraceToString.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "sw.toString()");
        return stringWriter2;
    }

    @InlineOnly
    public static final void printStackTrace(Throwable th, PrintWriter printWriter) {
        if (th == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace(printWriter);
    }

    @InlineOnly
    public static final void printStackTrace(Throwable th, PrintStream printStream) {
        if (th == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace(printStream);
    }
}
