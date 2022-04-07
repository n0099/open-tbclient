package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.repackage.rm9;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {
    public int a;
    public String b = String.valueOf(-1);
    public String c = "";
    public String d = "";
    public int e = -1;
    public String f = "";

    /* loaded from: classes5.dex */
    public static class a {
        public String a;
        public String b;
        public String c;

        public a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("code")) {
                    a(jSONObject.getString("code"));
                }
                if (!jSONObject.isNull("message")) {
                    b(jSONObject.getString("message"));
                }
                if (jSONObject.isNull("value")) {
                    return;
                }
                c(jSONObject.getString("value"));
            } catch (JSONException e) {
                rm9.b("SecurityMessage", "covert json error " + e.getMessage());
            }
        }

        public String a() {
            return this.c;
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public String toString() {
            return "PublicKeyStatus{code='" + this.a + "', message='" + this.b + "', publicKey='" + this.c + "'}";
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, IF] complete} */
    public static String a(MessageV3 messageV3) {
        JSONObject jSONObject;
        String notificationMessage = messageV3.getNotificationMessage();
        String str = null;
        try {
            try {
                if (!TextUtils.isEmpty(notificationMessage)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(notificationMessage).getJSONObject("data");
                        if (!jSONObject2.isNull("extra")) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("extra");
                            if (!jSONObject3.isNull("se")) {
                                str = jSONObject3.getString("se");
                            }
                        }
                    } catch (JSONException e) {
                        rm9.b("SecurityMessage", "parse notification message error " + e.getMessage());
                        if (TextUtils.isEmpty(null)) {
                            jSONObject = new JSONObject(notificationMessage);
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        jSONObject = new JSONObject(notificationMessage);
                        jSONObject.getString("se");
                    }
                }
            } catch (Throwable th) {
                if (TextUtils.isEmpty(null)) {
                    try {
                        new JSONObject(notificationMessage).getString("se");
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
        rm9.d("SecurityMessage", "encrypt message " + str);
        return str;
    }

    public static boolean a(String str, MessageV3 messageV3) {
        String str2;
        e e = e(str);
        rm9.b("SecurityMessage", "securityMessage " + e);
        if (System.currentTimeMillis() / 1000 > e.a()) {
            str2 = "message expire";
        } else if (!messageV3.getTitle().contains(e.c())) {
            str2 = "invalid title";
        } else if (!messageV3.getContent().contains(e.d())) {
            str2 = "invalid content";
        } else if (!String.valueOf(-1).equals(e.b()) && !e.b().equals(messageV3.getTaskId())) {
            str2 = "invalid taskId";
        } else if (e.e() != -1) {
            int e2 = e.e();
            if (e2 == 1) {
                if (!messageV3.getActivity().contains(e.f())) {
                    str2 = "invalid click activity";
                }
                return true;
            } else if (e2 == 2) {
                if (!messageV3.getWebUrl().contains(e.f())) {
                    str2 = "invalid web url";
                }
                return true;
            } else {
                if (e2 == 3 && !MzPushMessage.fromMessageV3(messageV3).getSelfDefineContentString().contains(e.f())) {
                    str2 = "invalid self define";
                }
                return true;
            }
        } else {
            str2 = "invalid click type";
        }
        rm9.b("SecurityMessage", str2);
        return false;
    }

    public static e e(String str) {
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("tt")) {
                eVar.a(jSONObject.getInt("tt"));
            }
            if (!jSONObject.isNull(Config.FEED_LIST_PART)) {
                eVar.a(jSONObject.getString(Config.FEED_LIST_PART));
            }
            if (!jSONObject.isNull("tl")) {
                eVar.b(jSONObject.getString("tl"));
            }
            if (!jSONObject.isNull("cont")) {
                eVar.c(jSONObject.getString("cont"));
            }
            if (!jSONObject.isNull(Config.EXCEPTION_CRASH_TYPE)) {
                eVar.b(jSONObject.getInt(Config.EXCEPTION_CRASH_TYPE));
            }
            if (!jSONObject.isNull("pm")) {
                eVar.d(jSONObject.getString("pm"));
            }
        } catch (Exception e) {
            rm9.b("SecurityMessage", "parse decryptSign error " + e.getMessage());
        }
        return eVar;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.f = str;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String toString() {
        return "SecurityMessage{timestamp=" + this.a + ", taskId='" + this.b + "', title='" + this.c + "', content='" + this.d + "', clickType=" + this.e + ", params='" + this.f + "'}";
    }
}
