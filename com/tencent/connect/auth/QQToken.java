package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;
    public static SharedPreferences g;
    public String a;
    public String b;
    public String c;
    public int d = 1;
    public long e = -1;
    public com.tencent.open.utils.a f;

    public QQToken(String str) {
        this.a = str;
    }

    public static String a(String str) {
        return Base64.encodeToString(l.i(str), 2) + "_aes_google";
    }

    @Deprecated
    public static String b(String str) {
        return Base64.encodeToString(l.i(str), 2);
    }

    @Deprecated
    public static String c(String str) {
        return Base64.encodeToString(l.i(str), 2) + "_spkey";
    }

    public void removeSession(String str) {
        SharedPreferences.Editor edit = a().edit();
        edit.remove(c(str));
        edit.remove(c(str));
        edit.remove(a(str));
        edit.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAuthSource(int i) {
        this.d = i;
    }

    public void setOpenId(String str) {
        this.c = str;
    }

    @TargetApi(11)
    public static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (g == null) {
                g = f.a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = g;
        }
        return sharedPreferences;
    }

    public String getAccessToken() {
        return this.b;
    }

    public String getAppId() {
        return this.a;
    }

    public int getAuthSource() {
        return this.d;
    }

    public long getExpireTimeInSecond() {
        return this.e;
    }

    public String getOpenId() {
        return this.c;
    }

    public boolean isSessionValid() {
        if (this.b != null && System.currentTimeMillis() < this.e) {
            return true;
        }
        return false;
    }

    public static synchronized JSONObject a(String str, com.tencent.open.utils.a aVar) {
        String b;
        synchronized (QQToken.class) {
            if (f.a() == null) {
                SLog.i("QQToken", "loadJsonPreference context null");
                return null;
            } else if (str == null) {
                SLog.i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            } else {
                String string = a().getString(a(str), "");
                if (TextUtils.isEmpty(string)) {
                    if (!JniInterface.isJniOk) {
                        i.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                        JniInterface.loadSo();
                    }
                    if (!JniInterface.isJniOk) {
                        SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                        return null;
                    }
                    String c = c(str);
                    String string2 = a().getString(c, "");
                    if (TextUtils.isEmpty(string2)) {
                        String b2 = b(str);
                        String string3 = a().getString(b2, "");
                        if (TextUtils.isEmpty(string3)) {
                            SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                            return null;
                        }
                        try {
                            b = JniInterface.d1(string3);
                            if (TextUtils.isEmpty(b)) {
                                SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                a().edit().remove(b2).apply();
                                return null;
                            }
                            a(str, new JSONObject(b), aVar);
                            a().edit().remove(b2).apply();
                        } catch (Exception e) {
                            SLog.e("QQToken", "Catch Exception", e);
                            a().edit().remove(b2).apply();
                            return null;
                        }
                    } else {
                        try {
                            b = JniInterface.d2(string2);
                            a(str, new JSONObject(b), aVar);
                            a().edit().remove(c).apply();
                        } catch (Exception e2) {
                            SLog.e("QQToken", "Catch Exception", e2);
                            a().edit().remove(c).apply();
                            return null;
                        }
                    }
                } else {
                    b = aVar.b(string);
                }
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    SLog.i("QQToken", "loadJsonPreference sucess");
                    return jSONObject;
                } catch (Exception e3) {
                    SLog.i("QQToken", "loadJsonPreference decode " + e3.toString());
                    return null;
                }
            }
        }
    }

    public static synchronized boolean a(String str, JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        synchronized (QQToken.class) {
            if (f.a() == null) {
                SLog.i("QQToken", "saveJsonPreference context null");
                return false;
            } else if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put("expires_time", System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String a = a(str);
                        String a2 = aVar.a(jSONObject.toString());
                        if (a.length() > 6 && a2 != null) {
                            a().edit().putString(a, a2).commit();
                            SLog.i("QQToken", "saveJsonPreference sucess");
                            return true;
                        }
                        SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return false;
                    }
                    SLog.i("QQToken", "expires is null");
                    return false;
                } catch (Exception e) {
                    SLog.e("QQToken", "saveJsonPreference exception:" + e.toString());
                    return false;
                }
            } else {
                SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
                return false;
            }
        }
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (TextUtils.isEmpty(openId)) {
                JSONObject loadSession = loadSession(this.a);
                if (loadSession != null) {
                    openId = loadSession.getString("openid");
                    if (!TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.a);
            } else {
                SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.a);
            }
        } catch (Exception e) {
            SLog.i("QQToken", "getLocalOpenIdByAppId " + e.toString());
        }
        return openId;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f == null) {
                this.f = new com.tencent.open.utils.a(f.a());
            }
            return a(str, this.f);
        } catch (Exception e) {
            SLog.i("QQToken", "login loadSession" + e.toString());
            return null;
        }
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f == null) {
                this.f = new com.tencent.open.utils.a(f.a());
            }
            return a(this.a, jSONObject, this.f);
        } catch (Exception e) {
            SLog.i("QQToken", "login saveSession" + e.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.b = str;
        this.e = 0L;
        if (str2 != null) {
            this.e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }
}
