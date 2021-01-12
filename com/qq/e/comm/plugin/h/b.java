package com.qq.e.comm.plugin.h;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.h.a.c;
import com.qq.e.comm.plugin.h.a.f;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public enum b {
    IMEI("m1", new f()),
    IMEI1("m5", new f() { // from class: com.qq.e.comm.plugin.h.a.e
        private String a(TelephonyManager telephonyManager) {
            String str;
            try {
                Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getImei", Integer.TYPE);
                declaredMethod.setAccessible(true);
                String str2 = (String) declaredMethod.invoke(telephonyManager, 0);
                try {
                    return !TextUtils.isEmpty(str2) ? str2 : (String) declaredMethod.invoke(telephonyManager, 1);
                } catch (Exception e) {
                    return str;
                }
            } catch (Exception e2) {
                return null;
            }
        }

        @Override // com.qq.e.comm.plugin.h.a.f, com.qq.e.comm.plugin.h.a.b
        protected String c(Context context) {
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                return null;
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                return telephonyManager == null ? null : Build.VERSION.SDK_INT >= 21 ? a(telephonyManager) : telephonyManager.getDeviceId();
            } catch (Exception e) {
                return null;
            }
        }
    }),
    ANDROIDID("m3", new com.qq.e.comm.plugin.h.a.b() { // from class: com.qq.e.comm.plugin.h.a.d
        @Override // com.qq.e.comm.plugin.h.a
        public String a(Context context) {
            String b2 = b(context);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            return Md5Util.encode(b2);
        }

        @Override // com.qq.e.comm.plugin.h.a.b
        protected boolean a() {
            return GDTADManager.getInstance().getSM().getInteger("adidon", 1) == 1;
        }

        @Override // com.qq.e.comm.plugin.h.a.b
        protected String c(Context context) {
            try {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable th) {
                GDTLogger.d("AndroidIDReader Exception:" + th.getMessage());
                return null;
            }
        }
    }),
    AAID("m4", new com.qq.e.comm.plugin.h.a.a()),
    ALLID("device_ext", new c());
    
    private final String f;
    private final a g;

    b(String str, a aVar) {
        this.f = str;
        this.g = aVar;
    }

    public a a() {
        return this.g;
    }

    public String a(Context context) {
        return a().a(context);
    }

    public String b() {
        return this.f;
    }
}
