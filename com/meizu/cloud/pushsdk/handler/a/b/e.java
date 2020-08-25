package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class e {
    private int a;
    private String b = String.valueOf(-1);
    private String c = "";
    private String d = "";
    private int e = -1;
    private String f = "";

    /* loaded from: classes20.dex */
    public static class a {
        public String a;
        public String b;
        String c;

        public a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
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
                }
            } catch (JSONException e) {
                com.meizu.cloud.a.a.e("SecurityMessage", "covert json error " + e.getMessage());
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, MOVE_EXCEPTION, CONSTRUCTOR, CONST_STR, INVOKE, MOVE_EXCEPTION, IF] complete} */
    public static String a(MessageV3 messageV3) {
        String str = null;
        String notificationMessage = messageV3.getNotificationMessage();
        if (!TextUtils.isEmpty(notificationMessage)) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(notificationMessage).getJSONObject("data");
                    if (!jSONObject.isNull("extra")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                        if (!jSONObject2.isNull("se")) {
                            str = jSONObject2.getString("se");
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        try {
                            str = new JSONObject(notificationMessage).getString("se");
                        } catch (Exception e) {
                        }
                    }
                } catch (JSONException e2) {
                    com.meizu.cloud.a.a.e("SecurityMessage", "parse notification message error " + e2.getMessage());
                    if (TextUtils.isEmpty(null)) {
                        try {
                            str = new JSONObject(notificationMessage).getString("se");
                        } catch (Exception e3) {
                        }
                    }
                }
            } catch (Throwable th) {
                if (TextUtils.isEmpty(null)) {
                    try {
                        new JSONObject(notificationMessage).getString("se");
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        }
        com.meizu.cloud.a.a.i("SecurityMessage", "encrypt message " + str);
        return str;
    }

    public static boolean a(String str, MessageV3 messageV3) {
        e e = e(str);
        com.meizu.cloud.a.a.e("SecurityMessage", "securityMessage " + e);
        if (System.currentTimeMillis() / 1000 > e.a()) {
            com.meizu.cloud.a.a.e("SecurityMessage", "message expire");
            return false;
        } else if (!messageV3.getTitle().contains(e.c())) {
            com.meizu.cloud.a.a.e("SecurityMessage", "invalid title");
            return false;
        } else if (!messageV3.getContent().contains(e.d())) {
            com.meizu.cloud.a.a.e("SecurityMessage", "invalid content");
            return false;
        } else if (!String.valueOf(-1).equals(e.b()) && !e.b().equals(messageV3.getTaskId())) {
            com.meizu.cloud.a.a.e("SecurityMessage", "invalid taskId");
            return false;
        } else if (e.e() == -1) {
            com.meizu.cloud.a.a.e("SecurityMessage", "invalid click type");
            return false;
        } else {
            switch (e.e()) {
                case 1:
                    if (!messageV3.getActivity().contains(e.f())) {
                        com.meizu.cloud.a.a.e("SecurityMessage", "invalid click activity");
                        return false;
                    }
                    break;
                case 2:
                    if (!messageV3.getWebUrl().contains(e.f())) {
                        com.meizu.cloud.a.a.e("SecurityMessage", "invalid web url");
                        return false;
                    }
                    break;
                case 3:
                    if (!MzPushMessage.fromMessageV3(messageV3).getSelfDefineContentString().contains(e.f())) {
                        com.meizu.cloud.a.a.e("SecurityMessage", "invalid self define");
                        return false;
                    }
                    break;
            }
            return true;
        }
    }

    private static e e(String str) {
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP)) {
                eVar.a(jSONObject.getInt(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP));
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
            com.meizu.cloud.a.a.e("SecurityMessage", "parse decryptSign error " + e.getMessage());
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
