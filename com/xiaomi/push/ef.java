package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
/* loaded from: classes6.dex */
public class ef extends ed {

    /* renamed from: a  reason: collision with root package name */
    private boolean f13967a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13968b;
    private boolean c;
    private boolean d;
    private boolean e;

    public ef(Context context, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(context, i);
        this.f13967a = z;
        this.f13968b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
    }

    private String b() {
        if (this.f13967a) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) this.f310a.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels + "," + displayMetrics.widthPixels;
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String c() {
        if (this.f13968b) {
            try {
                return Build.VERSION.RELEASE;
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String d() {
        if (this.c) {
            try {
                return String.valueOf(Build.VERSION.SDK_INT);
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String e() {
        if (this.d) {
            try {
                return Settings.Secure.getString(this.f310a.getContentResolver(), "android_id");
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String f() {
        if (this.e) {
            try {
                return ((TelephonyManager) this.f310a.getSystemService("phone")).getSimOperator();
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo191a() {
        return 3;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo191a() {
        return ho.DeviceInfoV2;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo191a() {
        return b() + "|" + c() + "|" + d() + "|" + e() + "|" + f();
    }
}
