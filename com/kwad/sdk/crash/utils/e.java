package com.kwad.sdk.crash.utils;

import android.os.Build;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
/* loaded from: classes9.dex */
public final class e {

    /* loaded from: classes9.dex */
    public static abstract class a {
        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public abstract void println(Object obj);

        public abstract Object wY();
    }

    /* loaded from: classes9.dex */
    public static class b extends a {
        public final PrintWriter aij;

        public b(PrintWriter printWriter) {
            super((byte) 0);
            this.aij = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.e.a
        public final void println(Object obj) {
            this.aij.println(obj);
        }

        @Override // com.kwad.sdk.crash.utils.e.a
        public final Object wY() {
            return this.aij;
        }
    }

    public static void a(Throwable th, a aVar) {
        StackTraceElement[] stackTrace;
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        synchronized (aVar.wY()) {
            aVar.println(th);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                aVar.println("\tat " + stackTraceElement);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : th.getSuppressed()) {
                    a(th2, aVar, "Suppressed: ", "\t", newSetFromMap);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, aVar, "Caused by: ", "", newSetFromMap);
            }
        }
    }

    public static void a(Throwable th, a aVar, String str, String str2, Set<Throwable> set) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            aVar.println(str2 + str + th);
            for (StackTraceElement stackTraceElement : stackTrace) {
                aVar.println(str2 + "\tat " + stackTraceElement);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : th.getSuppressed()) {
                    a(th2, aVar, "Suppressed: ", str2 + "\t", set);
                }
            }
            th = th.getCause();
            if (th == null) {
                return;
            }
            str = "Caused by: ";
        }
        aVar.println("\t[CIRCULAR REFERENCE:" + th + PreferencesUtil.RIGHT_MOUNT);
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a(th, new b(printWriter));
    }
}
