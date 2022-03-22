package com.kwad.sdk.core.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.kuaishou.weapon.un.g;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.core.f.kwai.c;
import com.kwad.sdk.core.f.kwai.d;
import com.kwad.sdk.core.f.kwai.e;
import com.kwad.sdk.core.f.kwai.f;
import com.kwad.sdk.core.f.kwai.h;
import com.kwad.sdk.core.f.kwai.j;
import com.kwad.sdk.g.a;
import com.kwad.sdk.g.b;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.i;
/* loaded from: classes7.dex */
public class a {
    public static String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static InterfaceC1958a f39512b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f39513c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f39514d;

    /* renamed from: com.kwad.sdk.core.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1958a {
        @WorkerThread
        void a(String str);
    }

    public static String a() {
        Context context = KsAdSDKImpl.get().getContext();
        String a2 = a(context);
        return (TextUtils.isEmpty(a2) && TextUtils.isEmpty(av.e(context))) ? b.ac() : a2;
    }

    public static String a(Context context) {
        if (!ao.i() || TextUtils.isEmpty(ao.j())) {
            if (TextUtils.isEmpty(a)) {
                String e2 = as.e(context);
                a = e2;
                if (TextUtils.isEmpty(e2)) {
                    if (ao.i() || b.a(2048L)) {
                        return a;
                    }
                    b(context);
                    return a;
                }
                return a;
            }
            return a;
        }
        return ao.j();
    }

    @SuppressLint({"PrivateApi"})
    public static String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return null;
        }
    }

    public static void b(final Context context) {
        if (!TextUtils.isEmpty(a) || context == null) {
            return;
        }
        c(context);
        if (com.kwad.sdk.g.a.a()) {
            com.kwad.sdk.g.a.a(context, new a.InterfaceC1984a() { // from class: com.kwad.sdk.core.f.a.1
            });
        } else if (com.kwad.sdk.g.b.a()) {
            com.kwad.sdk.g.b.a(context, new b.a() { // from class: com.kwad.sdk.core.f.a.2
            });
        }
    }

    public static void c(Context context) {
        if (!TextUtils.isEmpty(a) || context == null || f39513c) {
            return;
        }
        f39513c = true;
        if (context == null || f39514d) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        i.a(new Runnable() { // from class: com.kwad.sdk.core.f.a.3
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // java.lang.Runnable
            public void run() {
                char c2;
                String a2;
                j jVar;
                String upperCase = Build.MANUFACTURER.toUpperCase();
                switch (upperCase.hashCode()) {
                    case -2053026509:
                        if (upperCase.equals("LENOVO")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1712043046:
                        if (upperCase.equals(g.j)) {
                            c2 = '\n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1706170181:
                        if (upperCase.equals("XIAOMI")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1134767290:
                        if (upperCase.equals("BLACKSHARK")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -602397472:
                        if (upperCase.equals(RomTypeUtil.ROM_ONEPLUS)) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 89163:
                        if (upperCase.equals("ZTE")) {
                            c2 = '\f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2018896:
                        if (upperCase.equals("ASUS")) {
                            c2 = 11;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2432928:
                        if (upperCase.equals("OPPO")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2555124:
                        if (upperCase.equals("SSUI")) {
                            c2 = 14;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2634924:
                        if (upperCase.equals("VIVO")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 73239724:
                        if (upperCase.equals("MEIZU")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 74632627:
                        if (upperCase.equals(RomUtils.ROM_NUBIA)) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 630905871:
                        if (upperCase.equals("MOTOLORA")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 976565563:
                        if (upperCase.equals("FERRMEOS")) {
                            c2 = '\r';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2141820391:
                        if (upperCase.equals("HUAWEI")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        a2 = new com.kwad.sdk.core.f.kwai.b(applicationContext).a();
                        String unused = a.a = a2;
                        break;
                    case 1:
                    case 2:
                        a2 = new com.kwad.sdk.core.f.kwai.i(applicationContext).a();
                        String unused2 = a.a = a2;
                        break;
                    case 3:
                    case 4:
                        a2 = new f(applicationContext).a();
                        String unused22 = a.a = a2;
                        break;
                    case 5:
                        a2 = new h(applicationContext).a();
                        String unused222 = a.a = a2;
                        break;
                    case 6:
                    case 7:
                        a2 = new c(applicationContext).a();
                        String unused2222 = a.a = a2;
                        break;
                    case '\b':
                        a2 = new d(applicationContext).a();
                        String unused22222 = a.a = a2;
                        break;
                    case '\t':
                        a2 = new e(applicationContext).a();
                        String unused222222 = a.a = a2;
                        break;
                    case '\n':
                        a2 = new com.kwad.sdk.core.f.kwai.g(applicationContext).a();
                        String unused2222222 = a.a = a2;
                        break;
                    case 11:
                        a2 = new com.kwad.sdk.core.f.kwai.a(applicationContext).a();
                        String unused22222222 = a.a = a2;
                        break;
                    case '\f':
                    case '\r':
                    case 14:
                        jVar = new j(applicationContext);
                        a2 = jVar.a();
                        String unused222222222 = a.a = a2;
                        break;
                    default:
                        if (a.f() || a.g()) {
                            jVar = new j(applicationContext);
                            a2 = jVar.a();
                            String unused2222222222 = a.a = a2;
                            break;
                        }
                        break;
                }
                com.kwad.sdk.core.d.a.c("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + a.a);
                if (TextUtils.isEmpty(a.a)) {
                    boolean unused3 = a.f39514d = true;
                } else {
                    as.i(applicationContext, a.a);
                }
                a.h();
                boolean unused4 = a.f39513c = false;
            }
        });
    }

    public static boolean f() {
        String b2 = b("ro.build.freeme.label");
        return !TextUtils.isEmpty(b2) && b2.equalsIgnoreCase("FREEMEOS");
    }

    public static boolean g() {
        String b2 = b("ro.ssui.product");
        return (TextUtils.isEmpty(b2) || b2.equalsIgnoreCase("unknown")) ? false : true;
    }

    public static void h() {
        InterfaceC1958a interfaceC1958a = f39512b;
        if (interfaceC1958a != null) {
            interfaceC1958a.a(a);
        }
    }
}
