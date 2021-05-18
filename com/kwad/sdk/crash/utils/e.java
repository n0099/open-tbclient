package com.kwad.sdk.crash.utils;

import android.os.Build;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
/* loaded from: classes6.dex */
public class e {

    /* loaded from: classes6.dex */
    public static abstract class a {
        public a() {
        }

        public abstract Object a();

        public abstract void a(Object obj);
    }

    /* loaded from: classes6.dex */
    public static class b extends a {

        /* renamed from: a  reason: collision with root package name */
        public final PrintWriter f33087a;

        public b(PrintWriter printWriter) {
            super();
            this.f33087a = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.e.a
        public Object a() {
            return this.f33087a;
        }

        @Override // com.kwad.sdk.crash.utils.e.a
        public void a(Object obj) {
            this.f33087a.println(obj);
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
                    a(th2, aVar, "Suppressed: ", TrackUI.SEPERATOR, newSetFromMap);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, aVar, "Caused by: ", "", newSetFromMap);
            }
        }
    }

    public static void a(Throwable th, a aVar, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            aVar.a("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        aVar.a(str2 + str + th);
        for (StackTraceElement stackTraceElement : stackTrace) {
            aVar.a(str2 + "\tat " + stackTraceElement);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, "Suppressed: ", str2 + TrackUI.SEPERATOR, set);
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
