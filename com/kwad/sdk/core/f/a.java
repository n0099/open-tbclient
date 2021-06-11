package com.kwad.sdk.core.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.f.a.b;
import com.kwad.sdk.core.f.a.c;
import com.kwad.sdk.core.f.a.d;
import com.kwad.sdk.core.f.a.e;
import com.kwad.sdk.core.f.a.g;
import com.kwad.sdk.core.f.a.h;
import com.kwad.sdk.core.f.a.i;
import com.kwad.sdk.core.f.a.j;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.f;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f34216a = "";

    /* renamed from: b  reason: collision with root package name */
    public static InterfaceC0381a f34217b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f34218c = false;

    /* renamed from: com.kwad.sdk.core.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0381a {
        @WorkerThread
        void a(String str);
    }

    public static String a() {
        if (TextUtils.isEmpty(f34216a)) {
            a(KsAdSDKImpl.get().getContext());
        }
        return f34216a;
    }

    public static void a(@Nullable Context context) {
        if (f34218c) {
            return;
        }
        f34218c = true;
        if (TextUtils.isEmpty(f34216a)) {
            if (context == null) {
                context = KsAdSDKImpl.get().getContext();
            }
            if (context == null) {
                return;
            }
            String h2 = ae.h(context);
            f34216a = h2;
            if (TextUtils.isEmpty(h2)) {
                final Context applicationContext = context.getApplicationContext();
                f.a(new Runnable() { // from class: com.kwad.sdk.core.f.a.1
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
                                if (upperCase.equals("SAMSUNG")) {
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
                                a2 = new b(applicationContext).a();
                                String unused = a.f34216a = a2;
                                break;
                            case 1:
                            case 2:
                                a2 = new i(applicationContext).a();
                                String unused2 = a.f34216a = a2;
                                break;
                            case 3:
                            case 4:
                                a2 = new com.kwad.sdk.core.f.a.f(applicationContext).a();
                                String unused22 = a.f34216a = a2;
                                break;
                            case 5:
                                a2 = new h(applicationContext).a();
                                String unused222 = a.f34216a = a2;
                                break;
                            case 6:
                            case 7:
                                a2 = new c(applicationContext).a();
                                String unused2222 = a.f34216a = a2;
                                break;
                            case '\b':
                                a2 = new d(applicationContext).a();
                                String unused22222 = a.f34216a = a2;
                                break;
                            case '\t':
                                a2 = new e(applicationContext).a();
                                String unused222222 = a.f34216a = a2;
                                break;
                            case '\n':
                                a2 = new g(applicationContext).a();
                                String unused2222222 = a.f34216a = a2;
                                break;
                            case 11:
                                a2 = new com.kwad.sdk.core.f.a.a(applicationContext).a();
                                String unused22222222 = a.f34216a = a2;
                                break;
                            case '\f':
                            case '\r':
                            case 14:
                                jVar = new j(applicationContext);
                                a2 = jVar.a();
                                String unused222222222 = a.f34216a = a2;
                                break;
                            default:
                                if (a.f() || a.g()) {
                                    jVar = new j(applicationContext);
                                    a2 = jVar.a();
                                    String unused2222222222 = a.f34216a = a2;
                                    break;
                                }
                                break;
                        }
                        com.kwad.sdk.core.d.a.b("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + a.f34216a);
                        if (!TextUtils.isEmpty(a.f34216a)) {
                            ae.g(applicationContext, a.f34216a);
                        }
                        a.h();
                        boolean unused3 = a.f34218c = false;
                    }
                });
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    public static String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return null;
        }
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
        InterfaceC0381a interfaceC0381a = f34217b;
        if (interfaceC0381a != null) {
            interfaceC0381a.a(f34216a);
        }
    }
}
