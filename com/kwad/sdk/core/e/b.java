package com.kwad.sdk.core.e;

import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class b {
    public static boolean XL = true;
    public static boolean XM;
    public static final com.kwad.sdk.core.e.kwai.a XN = new com.kwad.sdk.core.e.a();
    public static final List<com.kwad.sdk.core.e.kwai.a> XO = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void b(com.kwad.sdk.core.e.kwai.a aVar);
    }

    public static void A(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.e.b.1
            @Override // com.kwad.sdk.core.e.b.a
            public final void b(com.kwad.sdk.core.e.kwai.a aVar) {
                aVar.d(str, str2);
            }
        });
    }

    public static void B(String str, String str2) {
        if (str2.length() <= 4000) {
            A(str, str2);
            return;
        }
        A(str, str2.substring(0, 4000));
        B(str, str2.substring(4000));
    }

    public static void C(String str, String str2) {
        final String z = z(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.e.b.6
            @Override // com.kwad.sdk.core.e.b.a
            public final void b(com.kwad.sdk.core.e.kwai.a aVar) {
                aVar.v(b.kx(), z, true);
            }
        });
    }

    public static void a(a aVar) {
        for (com.kwad.sdk.core.e.kwai.a aVar2 : XO) {
            if (aVar2 != null) {
                try {
                    aVar.b(aVar2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void a(com.kwad.sdk.core.e.kwai.a aVar) {
        if (XO.contains(aVar)) {
            return;
        }
        XO.add(aVar);
    }

    public static void bT(final String str) {
        a(new a() { // from class: com.kwad.sdk.core.e.b.5
            @Override // com.kwad.sdk.core.e.b.a
            public final void b(com.kwad.sdk.core.e.kwai.a aVar) {
                aVar.v(b.kx(), str, true);
            }
        });
    }

    public static void d(String str, String str2) {
        B(tv(), z(str, str2));
    }

    public static void e(String str, String str2) {
        final String z = z(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.e.b.10
            @Override // com.kwad.sdk.core.e.b.a
            public final void b(com.kwad.sdk.core.e.kwai.a aVar) {
                aVar.e(b.kx(), z);
            }
        });
    }

    public static void e(String str, String str2, Throwable th) {
        final String z = z(str, str2 + '\n' + Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.e.b.11
            @Override // com.kwad.sdk.core.e.b.a
            public final void b(com.kwad.sdk.core.e.kwai.a aVar) {
                aVar.e(b.kx(), z);
            }
        });
    }

    public static void i(String str, String str2) {
        final String z = z(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.e.b.7
            @Override // com.kwad.sdk.core.e.b.a
            public final void b(com.kwad.sdk.core.e.kwai.a aVar) {
                aVar.i(b.kx(), z);
            }
        });
    }

    public static void init(boolean z) {
        XL = z;
        XO.clear();
        XO.add(XN);
    }

    public static /* synthetic */ String kx() {
        return tv();
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.e.b.2
                @Override // com.kwad.sdk.core.e.b.a
                public final void b(com.kwad.sdk.core.e.kwai.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
        if (com.kwad.kwai.kwai.a.aw.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.e.b.3
                @Override // com.kwad.sdk.core.e.b.a
                public final void b(com.kwad.sdk.core.e.kwai.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
    }

    public static String tv() {
        return "KSAdSDK";
    }

    public static String tw() {
        String str;
        int i;
        if (XM) {
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

    public static void v(String str, String str2) {
        final String z = z(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.e.b.4
            @Override // com.kwad.sdk.core.e.b.a
            public final void b(com.kwad.sdk.core.e.kwai.a aVar) {
                aVar.v(b.kx(), z);
            }
        });
    }

    public static void w(String str, String str2) {
        final String z = z(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.e.b.8
            @Override // com.kwad.sdk.core.e.b.a
            public final void b(com.kwad.sdk.core.e.kwai.a aVar) {
                aVar.w(b.kx(), z);
            }
        });
    }

    public static void w(String str, Throwable th) {
        final String z = z(str, Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.e.b.9
            @Override // com.kwad.sdk.core.e.b.a
            public final void b(com.kwad.sdk.core.e.kwai.a aVar) {
                aVar.w(b.kx(), z, com.kwad.kwai.kwai.a.aw.booleanValue());
            }
        });
    }

    public static String z(String str, String str2) {
        return PreferencesUtil.LEFT_MOUNT + str + "]: " + str2 + " " + tw();
    }
}
