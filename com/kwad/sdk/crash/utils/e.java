package com.kwad.sdk.crash.utils;

import android.os.Build;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
/* loaded from: classes5.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class a {
        private a() {
        }

        abstract Object a();

        abstract void a(Object obj);
    }

    /* loaded from: classes5.dex */
    private static class b extends a {

        /* renamed from: a  reason: collision with root package name */
        private final PrintWriter f9958a;

        b(PrintWriter printWriter) {
            super();
            this.f9958a = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.e.a
        Object a() {
            return this.f9958a;
        }

        @Override // com.kwad.sdk.crash.utils.e.a
        void a(Object obj) {
            this.f9958a.println(obj);
        }
    }

    private static void a(Throwable th, a aVar) {
        StackTraceElement[] stackTrace;
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        synchronized (aVar.a()) {
            aVar.a(th);
            int length = th.getStackTrace().length;
            for (int i = 0; i < length; i++) {
                aVar.a("\tat " + stackTrace[i]);
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

    private static void a(Throwable th, a aVar, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            aVar.a("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        aVar.a(str2 + str + th);
        int length = stackTrace.length;
        for (int i = 0; i < length; i++) {
            aVar.a(str2 + "\tat " + stackTrace[i]);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, "Suppressed: ", str2 + "\t", set);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, aVar, "Caused by: ", str2, set);
        }
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a(th, new b(printWriter));
    }
}
