package com.kwad.sdk.core.d;

import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class b {
    public static boolean a = true;
    public static boolean b;
    public static final com.kwad.sdk.core.d.kwai.a c = new com.kwad.sdk.core.d.a();
    public static final List<com.kwad.sdk.core.d.kwai.a> d = new CopyOnWriteArrayList();

    /* loaded from: classes5.dex */
    public interface a {
        void a(com.kwad.sdk.core.d.kwai.a aVar);
    }

    public static void a(a aVar) {
        for (com.kwad.sdk.core.d.kwai.a aVar2 : d) {
            if (aVar2 != null) {
                try {
                    aVar.a(aVar2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void a(com.kwad.sdk.core.d.kwai.a aVar) {
        if (d.contains(aVar)) {
            return;
        }
        d.add(aVar);
    }

    public static void a(final String str) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.4
            @Override // com.kwad.sdk.core.d.b.a
            public final void a(com.kwad.sdk.core.d.kwai.a aVar) {
                aVar.a(b.b(), str, true);
            }
        });
    }

    public static void a(String str, String str2) {
        h(b(), f(str, str2));
    }

    public static void a(String str, String str2, Throwable th) {
        final String f = f(str, str2 + '\n' + Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.b.9
            @Override // com.kwad.sdk.core.d.b.a
            public final void a(com.kwad.sdk.core.d.kwai.a aVar) {
                aVar.e(b.b(), f);
            }
        });
    }

    public static void a(String str, Throwable th) {
        final String f = f(str, Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.b.7
            @Override // com.kwad.sdk.core.d.b.a
            public final void a(com.kwad.sdk.core.d.kwai.a aVar) {
                aVar.b(b.b(), f, com.kwad.kwai.kwai.a.a.booleanValue());
            }
        });
    }

    public static void a(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.b.10
                @Override // com.kwad.sdk.core.d.b.a
                public final void a(com.kwad.sdk.core.d.kwai.a aVar) {
                    aVar.a(th);
                }
            });
        }
        if (com.kwad.kwai.kwai.a.a.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void a(boolean z) {
        a = z;
        d.clear();
        d.add(c);
    }

    public static String b() {
        return "KSAdSDK";
    }

    public static void b(String str, String str2) {
        final String f = f(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.3
            @Override // com.kwad.sdk.core.d.b.a
            public final void a(com.kwad.sdk.core.d.kwai.a aVar) {
                aVar.a(b.b(), f);
            }
        });
    }

    public static void b(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.b.2
                @Override // com.kwad.sdk.core.d.b.a
                public final void a(com.kwad.sdk.core.d.kwai.a aVar) {
                    aVar.a(th);
                }
            });
        }
    }

    public static String c() {
        String str;
        int i;
        if (b) {
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
        return "";
    }

    public static void c(String str, String str2) {
        final String f = f(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.5
            @Override // com.kwad.sdk.core.d.b.a
            public final void a(com.kwad.sdk.core.d.kwai.a aVar) {
                aVar.c(b.b(), f);
            }
        });
    }

    public static void d(String str, String str2) {
        final String f = f(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.6
            @Override // com.kwad.sdk.core.d.b.a
            public final void a(com.kwad.sdk.core.d.kwai.a aVar) {
                aVar.d(b.b(), f);
            }
        });
    }

    public static void e(String str, String str2) {
        final String f = f(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.8
            @Override // com.kwad.sdk.core.d.b.a
            public final void a(com.kwad.sdk.core.d.kwai.a aVar) {
                aVar.e(b.b(), f);
            }
        });
    }

    public static String f(String str, String str2) {
        return PreferencesUtil.LEFT_MOUNT + str + "]: " + str2 + " " + c();
    }

    public static void g(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.1
            @Override // com.kwad.sdk.core.d.b.a
            public final void a(com.kwad.sdk.core.d.kwai.a aVar) {
                aVar.b(str, str2);
            }
        });
    }

    public static void h(String str, String str2) {
        if (str2.length() <= 4000) {
            g(str, str2);
            return;
        }
        g(str, str2.substring(0, 4000));
        h(str, str2.substring(4000));
    }
}
