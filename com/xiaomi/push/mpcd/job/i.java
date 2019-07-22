package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class i extends g {
    private boolean a;
    private boolean b;
    private boolean e;
    private boolean f;
    private boolean g;

    public i(Context context, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(context, i);
        this.a = z;
        this.b = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
    }

    private String f() {
        if (this.a) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) this.d.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels + Constants.ACCEPT_TIME_SEPARATOR_SP + displayMetrics.widthPixels;
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String g() {
        if (this.b) {
            try {
                return Build.VERSION.RELEASE;
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String h() {
        if (this.e) {
            try {
                return String.valueOf(Build.VERSION.SDK_INT);
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String i() {
        if (this.f) {
            try {
                return Settings.Secure.getString(this.d.getContentResolver(), "android_id");
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String j() {
        if (this.g) {
            try {
                return ((TelephonyManager) this.d.getSystemService("phone")).getSimOperator();
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 3;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        return f() + "|" + g() + "|" + h() + "|" + i() + "|" + j();
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.DeviceInfoV2;
    }
}
