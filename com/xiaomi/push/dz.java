package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
public class dz extends dx {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;

    public dz(Context context, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(context, i);
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
    }

    private String b() {
        if (this.a) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) this.f249a.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels + Constants.ACCEPT_TIME_SEPARATOR_SP + displayMetrics.widthPixels;
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String c() {
        if (this.b) {
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
                return Settings.Secure.getString(this.f249a.getContentResolver(), "android_id");
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String f() {
        if (this.e) {
            try {
                return ((TelephonyManager) this.f249a.getSystemService("phone")).getSimOperator();
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo152a() {
        return 3;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public hi mo152a() {
        return hi.DeviceInfoV2;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo152a() {
        return b() + "|" + c() + "|" + d() + "|" + e() + "|" + f();
    }
}
