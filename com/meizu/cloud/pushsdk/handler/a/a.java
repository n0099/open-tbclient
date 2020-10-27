package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.a.b.e;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a<T> implements com.meizu.cloud.pushsdk.handler.c {

    /* renamed from: a  reason: collision with root package name */
    private com.meizu.cloud.pushsdk.handler.a f4409a;
    private Context b;
    private Map<Integer, String> c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.b = context.getApplicationContext();
        this.f4409a = aVar;
        this.c = new HashMap();
        this.c.put(2, "MESSAGE_TYPE_PUSH_SERVICE_V2");
        this.c.put(4, "MESSAGE_TYPE_PUSH_SERVICE_V3");
        this.c.put(16, "MESSAGE_TYPE_REGISTER");
        this.c.put(32, "MESSAGE_TYPE_UNREGISTER");
        this.c.put(8, "MESSAGE_TYPE_THROUGH");
        this.c.put(64, "MESSAGE_TYPE_NOTIFICATION_CLICK");
        this.c.put(128, "MESSAGE_TYPE_NOTIFICATION_DELETE");
        this.c.put(256, "MESSAGE_TYPE_PUSH_SWITCH_STATUS");
        this.c.put(512, "MESSAGE_TYPE_PUSH_REGISTER_STATUS");
        this.c.put(2048, "MESSAGE_TYPE_PUSH_SUBTAGS_STATUS");
        this.c.put(1024, "MESSAGE_TYPE_PUSH_UNREGISTER_STATUS");
        this.c.put(4096, "MESSAGE_TYPE_PUSH_SUBALIAS_STATUS");
        this.c.put(8192, "MESSAGE_TYPE_SCHEDULE_NOTIFICATION");
        this.c.put(16384, "MESSAGE_TYPE_RECEIVE_NOTIFY_MESSAGE");
        this.c.put(32768, "MESSAGE_TYPE_NOTIFICATION_STATE");
        this.c.put(65536, "MESSAGE_TYPE_UPLOAD_FILE_LOG");
        this.c.put(131072, "MESSAGE_TYPE_NOTIFICATION_ARRIVED");
        this.c.put(262144, "MESSAGE_TYPE_NOTIFICATION_WITHDRAW");
    }

    private String a(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    protected com.meizu.cloud.pushsdk.notification.c a(T t) {
        return null;
    }

    protected abstract void a(T t, com.meizu.cloud.pushsdk.notification.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i, String str) {
        boolean z = true;
        if (i == 0) {
            z = com.meizu.cloud.pushsdk.util.b.e(c(), str);
        } else if (i == 1) {
            z = com.meizu.cloud.pushsdk.util.b.h(c(), str);
        }
        com.meizu.cloud.a.a.e("AbstractMessageHandler", str + (i == 0 ? " canNotificationMessage " : " canThroughMessage ") + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(MessageV3 messageV3) {
        String a2 = com.meizu.cloud.pushsdk.handler.a.b.e.a(messageV3);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        int i = 0;
        String k = com.meizu.cloud.pushsdk.util.b.k(c(), messageV3.getPackageName());
        boolean z = false;
        while (true) {
            if (z | TextUtils.isEmpty(k)) {
                e.a aVar = new e.a((String) com.meizu.cloud.pushsdk.b.a.a("https://api-push.meizu.com/garcia/api/server/getPublicKey").a().a().a());
                if (!TextUtils.isEmpty(aVar.a())) {
                    k = aVar.a();
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "down load public key: " + k);
                    com.meizu.cloud.pushsdk.util.b.k(c(), messageV3.getPackageName(), aVar.a());
                }
            }
            String a3 = com.meizu.cloud.pushsdk.util.c.a(k, a2);
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "decryptSign " + a3);
            if (!TextUtils.isEmpty(a3) && com.meizu.cloud.pushsdk.handler.a.b.e.a(a3, messageV3)) {
                return true;
            }
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "force update public key " + i + " time");
            int i2 = i + 1;
            if (i2 >= 2) {
                return false;
            }
            i = i2;
            z = true;
        }
    }

    public boolean a(String str) {
        try {
            return c().getPackageName().equals(new JSONObject(str).getString("appId"));
        } catch (Exception e) {
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "parse notification error");
            return false;
        }
    }

    public com.meizu.cloud.pushsdk.handler.a b() {
        return this.f4409a;
    }

    public String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("launcher");
            return (!jSONObject.has(Config.INPUT_DEF_PKG) || TextUtils.isEmpty(jSONObject.getString(Config.INPUT_DEF_PKG))) ? "" : jSONObject.getString(Config.INPUT_DEF_PKG);
        } catch (Exception e) {
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "parse desk top json error");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.model.a a2 = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a2 != null) {
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "delete notifyKey " + a2.b() + " notifyId " + a2.a());
            if (TextUtils.isEmpty(a2.b())) {
                com.meizu.cloud.pushsdk.notification.c.b.c(c(), messageV3.getUploadDataPackageName(), a2.a());
            } else {
                com.meizu.cloud.pushsdk.notification.c.b.a(c(), messageV3.getUploadDataPackageName(), a2.b());
            }
        }
    }

    protected void b(T t) {
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean b(Intent intent) {
        boolean z = false;
        boolean z2 = true;
        if (a(intent)) {
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "current message Type " + a(a()));
            T c = c(intent);
            if (g((a<T>) c)) {
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "current Handler message " + c);
                b((a<T>) c);
                switch (d((a<T>) c)) {
                    case 0:
                        com.meizu.cloud.a.a.e("AbstractMessageHandler", "schedule send message off, send message directly");
                        z = true;
                        break;
                    case 1:
                        com.meizu.cloud.a.a.e("AbstractMessageHandler", "expire notification, dont show message");
                        z2 = false;
                        break;
                    case 2:
                        com.meizu.cloud.a.a.e("AbstractMessageHandler", "notification on time ,show message");
                        z = true;
                        break;
                    case 3:
                        com.meizu.cloud.a.a.e("AbstractMessageHandler", "schedule notification");
                        e((a<T>) c);
                        z = true;
                        z2 = false;
                        break;
                    default:
                        z2 = false;
                        break;
                }
                boolean f = f((a<T>) c);
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "can send message " + f);
                if (z && z2 && f) {
                    a((a<T>) c, a((a<T>) c));
                    c((a<T>) c);
                    com.meizu.cloud.a.a.e("AbstractMessageHandler", "send message end ");
                }
            } else {
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "invalid push message");
            }
        }
        return z;
    }

    public Context c() {
        return this.b;
    }

    protected abstract T c(Intent intent);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(MessageV3 messageV3) {
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            b().b(c(), MzPushMessage.fromMessageV3(messageV3));
        } else if (MzSystemUtils.isRunningProcess(c(), messageV3.getUploadDataPackageName())) {
            com.meizu.cloud.a.a.i("AbstractMessageHandler", "send notification arrived message to " + messageV3.getUploadDataPackageName());
            Intent intent = new Intent();
            intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
            intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_ARRIVED);
            MzSystemUtils.sendMessageFromBroadcast(c(), intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getUploadDataPackageName());
        }
    }

    protected void c(T t) {
    }

    protected int d(T t) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d(Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY) : null;
        if (TextUtils.isEmpty(stringExtra)) {
            String deviceId = MzSystemUtils.getDeviceId(c());
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "force get deviceId " + deviceId);
            return deviceId;
        }
        return stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
    }

    protected void e(T t) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String f(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
    }

    protected boolean f(T t) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String g(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME);
        return TextUtils.isEmpty(stringExtra) ? c().getPackageName() : stringExtra;
    }

    protected boolean g(T t) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String h(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP);
        com.meizu.cloud.a.a.e("AbstractMessageHandler", "receive push timestamp from pushservice " + stringExtra);
        return TextUtils.isEmpty(stringExtra) ? String.valueOf(System.currentTimeMillis() / 1000) : stringExtra;
    }

    public String i(Intent intent) {
        return intent.getStringExtra("method");
    }
}
