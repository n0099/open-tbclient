package com.kwad.sdk.core.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.util.devices.RomUtils;
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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static InterfaceC1090a f9124b;

    /* renamed from: a  reason: collision with root package name */
    private static String f9123a = "";
    private static boolean c = false;

    /* renamed from: com.kwad.sdk.core.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1090a {
        @WorkerThread
        void a(String str);
    }

    public static String a() {
        if (TextUtils.isEmpty(f9123a)) {
            a(KsAdSDKImpl.get().getContext());
        }
        return f9123a;
    }

    public static void a(@Nullable Context context) {
        if (c) {
            return;
        }
        c = true;
        if (TextUtils.isEmpty(f9123a)) {
            if (context == null) {
                context = KsAdSDKImpl.get().getContext();
            }
            if (context != null) {
                f9123a = ae.h(context);
                if (TextUtils.isEmpty(f9123a)) {
                    final Context applicationContext = context.getApplicationContext();
                    f.a(new Runnable() { // from class: com.kwad.sdk.core.f.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String upperCase = Build.MANUFACTURER.toUpperCase();
                            char c2 = 65535;
                            switch (upperCase.hashCode()) {
                                case -2053026509:
                                    if (upperCase.equals("LENOVO")) {
                                        c2 = 6;
                                        break;
                                    }
                                    break;
                                case -1712043046:
                                    if (upperCase.equals("SAMSUNG")) {
                                        c2 = '\n';
                                        break;
                                    }
                                    break;
                                case -1706170181:
                                    if (upperCase.equals("XIAOMI")) {
                                        c2 = 1;
                                        break;
                                    }
                                    break;
                                case -1134767290:
                                    if (upperCase.equals("BLACKSHARK")) {
                                        c2 = 2;
                                        break;
                                    }
                                    break;
                                case -602397472:
                                    if (upperCase.equals("ONEPLUS")) {
                                        c2 = 4;
                                        break;
                                    }
                                    break;
                                case 89163:
                                    if (upperCase.equals("ZTE")) {
                                        c2 = '\f';
                                        break;
                                    }
                                    break;
                                case 2018896:
                                    if (upperCase.equals("ASUS")) {
                                        c2 = 11;
                                        break;
                                    }
                                    break;
                                case 2432928:
                                    if (upperCase.equals(RomUtils.ROM_OPPO)) {
                                        c2 = 3;
                                        break;
                                    }
                                    break;
                                case 2555124:
                                    if (upperCase.equals("SSUI")) {
                                        c2 = 14;
                                        break;
                                    }
                                    break;
                                case 2634924:
                                    if (upperCase.equals(RomUtils.ROM_VIVO)) {
                                        c2 = 5;
                                        break;
                                    }
                                    break;
                                case 73239724:
                                    if (upperCase.equals("MEIZU")) {
                                        c2 = '\b';
                                        break;
                                    }
                                    break;
                                case 74632627:
                                    if (upperCase.equals(RomUtils.ROM_NUBIA)) {
                                        c2 = '\t';
                                        break;
                                    }
                                    break;
                                case 630905871:
                                    if (upperCase.equals("MOTOLORA")) {
                                        c2 = 7;
                                        break;
                                    }
                                    break;
                                case 976565563:
                                    if (upperCase.equals("FERRMEOS")) {
                                        c2 = '\r';
                                        break;
                                    }
                                    break;
                                case 2141820391:
                                    if (upperCase.equals("HUAWEI")) {
                                        c2 = 0;
                                        break;
                                    }
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    String unused = a.f9123a = new b(applicationContext).a();
                                    break;
                                case 1:
                                case 2:
                                    String unused2 = a.f9123a = new i(applicationContext).a();
                                    break;
                                case 3:
                                case 4:
                                    String unused3 = a.f9123a = new com.kwad.sdk.core.f.a.f(applicationContext).a();
                                    break;
                                case 5:
                                    String unused4 = a.f9123a = new h(applicationContext).a();
                                    break;
                                case 6:
                                case 7:
                                    String unused5 = a.f9123a = new c(applicationContext).a();
                                    break;
                                case '\b':
                                    String unused6 = a.f9123a = new d(applicationContext).a();
                                    break;
                                case '\t':
                                    String unused7 = a.f9123a = new e(applicationContext).a();
                                    break;
                                case '\n':
                                    String unused8 = a.f9123a = new g(applicationContext).a();
                                    break;
                                case 11:
                                    String unused9 = a.f9123a = new com.kwad.sdk.core.f.a.a(applicationContext).a();
                                    break;
                                case '\f':
                                case '\r':
                                case 14:
                                    String unused10 = a.f9123a = new j(applicationContext).a();
                                    break;
                                default:
                                    if (a.f() || a.g()) {
                                        String unused11 = a.f9123a = new j(applicationContext).a();
                                        break;
                                    }
                                    break;
                            }
                            com.kwad.sdk.core.d.a.b("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + a.f9123a);
                            if (!TextUtils.isEmpty(a.f9123a)) {
                                ae.g(applicationContext, a.f9123a);
                            }
                            a.h();
                            boolean unused12 = a.c = false;
                        }
                    });
                }
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    private static String b(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            str2 = null;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f() {
        String b2 = b("ro.build.freeme.label");
        return !TextUtils.isEmpty(b2) && b2.equalsIgnoreCase("FREEMEOS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g() {
        String b2 = b("ro.ssui.product");
        return (TextUtils.isEmpty(b2) || b2.equalsIgnoreCase("unknown")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        if (f9124b != null) {
            f9124b.a(f9123a);
        }
    }
}
