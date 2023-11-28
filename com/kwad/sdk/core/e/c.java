package com.kwad.sdk.core.e;

import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class c {
    public static boolean atd = true;
    public static boolean ate = com.kwad.sdk.core.e.a.mc.booleanValue();
    public static final com.kwad.sdk.core.e.a.a atf = new b();
    public static final List<com.kwad.sdk.core.e.a.a> atg = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void b(com.kwad.sdk.core.e.a.a aVar);
    }

    public static String CA() {
        return "KSAdSDK";
    }

    public static /* synthetic */ String access$000() {
        return CA();
    }

    public static void P(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.e.c.1
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.d(str, str2);
            }
        });
    }

    public static void Q(String str, String str2) {
        if (str2.length() > 4000) {
            P(str, str2.substring(0, 4000));
            Q(str, str2.substring(4000));
            return;
        }
        P(str, str2);
    }

    public static void R(String str, String str2) {
        final String z = z(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.7
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.v(c.access$000(), z, true);
            }
        });
    }

    public static void d(String str, String str2) {
        Q(CA(), z(str, str2));
    }

    public static void e(String str, String str2) {
        final String z = z(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.11
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.e(c.access$000(), z);
            }
        });
    }

    public static void i(String str, String str2) {
        final String z = z(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.8
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.i(c.access$000(), z);
            }
        });
    }

    public static void v(String str, String str2) {
        final String z = z(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.5
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.v(c.access$000(), z);
            }
        });
    }

    public static void w(String str, String str2) {
        final String z = z(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.9
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.w(c.access$000(), z);
            }
        });
    }

    public static String z(String str, String str2) {
        return PreferencesUtil.LEFT_MOUNT + str + "]: " + str2 + " " + wL();
    }

    public static void a(com.kwad.sdk.core.e.a.a aVar) {
        if (!atg.contains(aVar)) {
            atg.add(aVar);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static void m181do(final String str) {
        a(new a() { // from class: com.kwad.sdk.core.e.c.6
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.v(c.access$000(), str, true);
            }
        });
    }

    public static void init(boolean z) {
        atd = z;
        atg.clear();
        atg.add(atf);
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.e.c.3
                @Override // com.kwad.sdk.core.e.c.a
                public final void b(com.kwad.sdk.core.e.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
        if (!com.kwad.sdk.core.e.a.mc.booleanValue()) {
            return;
        }
        throw new RuntimeException(th);
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.e.c.4
                @Override // com.kwad.sdk.core.e.c.a
                public final void b(com.kwad.sdk.core.e.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
    }

    public static void a(a aVar) {
        for (com.kwad.sdk.core.e.a.a aVar2 : atg) {
            if (aVar2 != null) {
                try {
                    aVar.b(aVar2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void e(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        final String z = z(str, str2 + '\n' + stackTraceString);
        a(new a() { // from class: com.kwad.sdk.core.e.c.2
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.e(c.access$000(), z);
            }
        });
    }

    public static void w(String str, Throwable th) {
        final String z = z(str, Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.e.c.10
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.w(c.access$000(), z, com.kwad.sdk.core.e.a.mc.booleanValue());
            }
        });
    }

    public static String wL() {
        String str;
        int i;
        if (!ate) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            str = stackTrace[3].getFileName();
            i = stackTrace[3].getLineNumber();
        } else {
            str = "unknown";
            i = -1;
        }
        return "(" + str + ':' + i + ')';
    }
}
