package com.kwad.sdk.crash.utils;

import android.os.Build;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
/* loaded from: classes5.dex */
public final class e {

    /* loaded from: classes5.dex */
    public static abstract class a {
        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public abstract Object a();

        public abstract void a(Object obj);
    }

    /* loaded from: classes5.dex */
    public static class b extends a {
        public final PrintWriter a;

        public b(PrintWriter printWriter) {
            super((byte) 0);
            this.a = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.e.a
        public final Object a() {
            return this.a;
        }

        @Override // com.kwad.sdk.crash.utils.e.a
        public final void a(Object obj) {
            this.a.println(obj);
        }
    }

    public static void a(Throwable th, a aVar) {
        StackTraceElement[] stackTrace;
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        synchronized (aVar.a()) {
            aVar.a(th);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                aVar.a("\tat " + stackTraceElement);
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
            aVar.a(str2 + str + th);
            for (StackTraceElement stackTraceElement : stackTrace) {
                aVar.a(str2 + "\tat " + stackTraceElement);
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
        aVar.a("\t[CIRCULAR REFERENCE:" + th + PreferencesUtil.RIGHT_MOUNT);
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a(th, new b(printWriter));
    }
}
