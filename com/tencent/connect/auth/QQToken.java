package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.open.a.f;
import com.tencent.open.utils.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.j;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: f  reason: collision with root package name */
    public static SharedPreferences f39339f;

    /* renamed from: a  reason: collision with root package name */
    public String f39340a;

    /* renamed from: b  reason: collision with root package name */
    public String f39341b;

    /* renamed from: c  reason: collision with root package name */
    public String f39342c;

    /* renamed from: d  reason: collision with root package name */
    public int f39343d = 1;

    /* renamed from: e  reason: collision with root package name */
    public long f39344e = -1;

    public QQToken(String str) {
        this.f39340a = str;
    }

    @TargetApi(11)
    public static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (f39339f == null) {
                f39339f = e.a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = f39339f;
        }
        return sharedPreferences;
    }

    public String getAccessToken() {
        return this.f39341b;
    }

    public String getAppId() {
        return this.f39340a;
    }

    public int getAuthSource() {
        return this.f39343d;
    }

    public long getExpireTimeInSecond() {
        return this.f39344e;
    }

    public String getOpenId() {
        return this.f39342c;
    }

    public boolean isSessionValid() {
        return this.f39341b != null && System.currentTimeMillis() < this.f39344e;
    }

    public JSONObject loadSession(String str) {
        try {
            return a(str);
        } catch (Exception e2) {
            f.c("QQToken", "login loadSession" + e2.toString());
            return null;
        }
    }

    public void saveSession(JSONObject jSONObject) {
        try {
            a(this.f39340a, jSONObject);
        } catch (Exception e2) {
            f.c("QQToken", "login saveSession" + e2.toString());
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.f39341b = str;
        this.f39344e = 0L;
        if (str2 != null) {
            this.f39344e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.f39340a = str;
    }

    public void setAuthSource(int i) {
        this.f39343d = i;
    }

    public void setOpenId(String str) {
        this.f39342c = str;
    }

    public static synchronized JSONObject a(String str) {
        synchronized (QQToken.class) {
            if (e.a() == null) {
                f.c("QQToken", "loadJsonPreference context null");
                return null;
            } else if (str == null) {
                return null;
            } else {
                String string = a().getString(Base64.encodeToString(j.i(str), 2), null);
                if (string == null) {
                    f.c("QQToken", "loadJsonPreference encoded value null");
                    return null;
                }
                try {
                    return new JSONObject(d.b(string, "asdfghjk"));
                } catch (Exception e2) {
                    f.c("QQToken", "loadJsonPreference decode" + e2.toString());
                    return null;
                }
            }
        }
    }

    public static synchronized void a(String str, JSONObject jSONObject) {
        synchronized (QQToken.class) {
            if (e.a() == null) {
                f.c("QQToken", "saveJsonPreference context null");
            } else if (str == null || jSONObject == null) {
            } else {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    jSONObject.put("expires_time", System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                    String encodeToString = Base64.encodeToString(j.i(str), 2);
                    String a2 = d.a(jSONObject.toString(), "asdfghjk");
                    if (encodeToString != null && a2 != null) {
                        a().edit().putString(encodeToString, a2).commit();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
