package com.bytedance.tea.crash;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Map;
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5184a;
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;

    public static synchronized void a(@NonNull Context context, @NonNull d dVar, boolean z, boolean z2) {
        synchronized (g.class) {
            a(context, dVar, z, false, z2);
        }
    }

    public static synchronized void a(@NonNull Context context, @NonNull d dVar, boolean z, boolean z2, boolean z3) {
        synchronized (g.class) {
            a(context, dVar, z, z, z2, z3);
        }
    }

    public static synchronized void a(@NonNull final Context context, @NonNull d dVar, boolean z, boolean z2, boolean z3, final boolean z4) {
        synchronized (g.class) {
            if (!f5184a) {
                if (context == null) {
                    throw new IllegalArgumentException("context must be not null.");
                }
                if (dVar == null) {
                    throw new IllegalArgumentException("params must be not null.");
                }
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                if (!com.bytedance.tea.crash.g.a.c(context)) {
                    h.a(context, dVar);
                    com.bytedance.tea.crash.e.a.e.a(context);
                    if (z || z2) {
                        com.bytedance.tea.crash.d.a ern = com.bytedance.tea.crash.d.a.ern();
                        if (z) {
                            ern.a(new com.bytedance.tea.crash.d.c(context));
                        }
                        b = true;
                    }
                    d = z3;
                    f5184a = true;
                    c = z4;
                    com.bytedance.tea.crash.e.h.b().post(new Runnable() { // from class: com.bytedance.tea.crash.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.tea.crash.b.a.erm().a(context);
                            com.bytedance.tea.crash.upload.d.a(context);
                            if (z4) {
                                com.bytedance.tea.crash.a.f.hY(context).a();
                            }
                        }
                    });
                }
            }
        }
    }

    public static void a(f fVar) {
        h.erw().a(fVar);
    }

    public static void a(Map<? extends String, ? extends String> map) {
        if (map != null && !map.isEmpty()) {
            h.erw().a(map);
        }
    }
}
