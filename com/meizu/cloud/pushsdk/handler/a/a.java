package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
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
    public com.meizu.cloud.pushsdk.handler.a f38592a;

    /* renamed from: b  reason: collision with root package name */
    public Context f38593b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Integer, String> f38594c;

    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.f38593b = context.getApplicationContext();
        this.f38592a = aVar;
        HashMap hashMap = new HashMap();
        this.f38594c = hashMap;
        hashMap.put(2, "MESSAGE_TYPE_PUSH_SERVICE_V2");
        this.f38594c.put(4, "MESSAGE_TYPE_PUSH_SERVICE_V3");
        this.f38594c.put(16, "MESSAGE_TYPE_REGISTER");
        this.f38594c.put(32, "MESSAGE_TYPE_UNREGISTER");
        this.f38594c.put(8, "MESSAGE_TYPE_THROUGH");
        this.f38594c.put(64, "MESSAGE_TYPE_NOTIFICATION_CLICK");
        this.f38594c.put(128, "MESSAGE_TYPE_NOTIFICATION_DELETE");
        this.f38594c.put(256, "MESSAGE_TYPE_PUSH_SWITCH_STATUS");
        this.f38594c.put(512, "MESSAGE_TYPE_PUSH_REGISTER_STATUS");
        this.f38594c.put(2048, "MESSAGE_TYPE_PUSH_SUBTAGS_STATUS");
        this.f38594c.put(1024, "MESSAGE_TYPE_PUSH_UNREGISTER_STATUS");
        this.f38594c.put(4096, "MESSAGE_TYPE_PUSH_SUBALIAS_STATUS");
        this.f38594c.put(8192, "MESSAGE_TYPE_SCHEDULE_NOTIFICATION");
        this.f38594c.put(16384, "MESSAGE_TYPE_RECEIVE_NOTIFY_MESSAGE");
        this.f38594c.put(32768, "MESSAGE_TYPE_NOTIFICATION_STATE");
        this.f38594c.put(65536, "MESSAGE_TYPE_UPLOAD_FILE_LOG");
        this.f38594c.put(131072, "MESSAGE_TYPE_NOTIFICATION_ARRIVED");
        this.f38594c.put(262144, "MESSAGE_TYPE_NOTIFICATION_WITHDRAW");
    }

    private String a(int i2) {
        return this.f38594c.get(Integer.valueOf(i2));
    }

    public com.meizu.cloud.pushsdk.notification.c a(T t) {
        return null;
    }

    public abstract void a(T t, com.meizu.cloud.pushsdk.notification.c cVar);

    public boolean a(int i2, String str) {
        boolean z = true;
        if (i2 == 0) {
            z = com.meizu.cloud.pushsdk.util.b.e(c(), str);
        } else if (i2 == 1) {
            z = com.meizu.cloud.pushsdk.util.b.h(c(), str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i2 == 0 ? " canNotificationMessage " : " canThroughMessage ");
        sb.append(z);
        d.j.a.a.a.b("AbstractMessageHandler", sb.toString());
        return z;
    }

    public final boolean a(MessageV3 messageV3) {
        String a2 = com.meizu.cloud.pushsdk.handler.a.b.e.a(messageV3);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String k = com.meizu.cloud.pushsdk.util.b.k(c(), messageV3.getPackageName());
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (z | TextUtils.isEmpty(k)) {
                e.a aVar = new e.a((String) com.meizu.cloud.pushsdk.b.a.a("https://api-push.meizu.com/garcia/api/server/getPublicKey").a().a().a());
                if (!TextUtils.isEmpty(aVar.a())) {
                    k = aVar.a();
                    d.j.a.a.a.d("AbstractMessageHandler", "down load public key: " + k);
                    com.meizu.cloud.pushsdk.util.b.k(c(), messageV3.getPackageName(), aVar.a());
                }
            }
            String a3 = com.meizu.cloud.pushsdk.util.c.a(k, a2);
            d.j.a.a.a.b("AbstractMessageHandler", "decryptSign " + a3);
            if (!TextUtils.isEmpty(a3) && com.meizu.cloud.pushsdk.handler.a.b.e.a(a3, messageV3)) {
                return true;
            }
            d.j.a.a.a.b("AbstractMessageHandler", "force update public key " + i2 + " time");
            i2++;
            if (i2 >= 2) {
                return false;
            }
            z = true;
        }
    }

    public boolean a(String str) {
        try {
            return c().getPackageName().equals(new JSONObject(str).getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
        } catch (Exception unused) {
            d.j.a.a.a.b("AbstractMessageHandler", "parse notification error");
            return false;
        }
    }

    public com.meizu.cloud.pushsdk.handler.a b() {
        return this.f38592a;
    }

    public String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("launcher");
            return (!jSONObject.has("pkg") || TextUtils.isEmpty(jSONObject.getString("pkg"))) ? "" : jSONObject.getString("pkg");
        } catch (Exception unused) {
            d.j.a.a.a.b("AbstractMessageHandler", "parse desk top json error");
            return "";
        }
    }

    public void b(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.model.a a2 = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a2 != null) {
            d.j.a.a.a.b("AbstractMessageHandler", "delete notifyKey " + a2.b() + " notifyId " + a2.a());
            if (TextUtils.isEmpty(a2.b())) {
                com.meizu.cloud.pushsdk.notification.c.b.c(c(), messageV3.getUploadDataPackageName(), a2.a());
            } else {
                com.meizu.cloud.pushsdk.notification.c.b.a(c(), messageV3.getUploadDataPackageName(), a2.b());
            }
        }
    }

    public void b(T t) {
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean b(Intent intent) {
        String str;
        boolean z = false;
        if (a(intent)) {
            d.j.a.a.a.b("AbstractMessageHandler", "current message Type " + a(a()));
            T c2 = c(intent);
            if (!g((a<T>) c2)) {
                d.j.a.a.a.b("AbstractMessageHandler", "invalid push message");
                return false;
            }
            d.j.a.a.a.b("AbstractMessageHandler", "current Handler message " + c2);
            b((a<T>) c2);
            int d2 = d((a<T>) c2);
            boolean z2 = true;
            if (d2 != 0) {
                if (d2 == 1) {
                    d.j.a.a.a.b("AbstractMessageHandler", "expire notification, dont show message");
                } else if (d2 == 2) {
                    str = "notification on time ,show message";
                } else if (d2 == 3) {
                    d.j.a.a.a.b("AbstractMessageHandler", "schedule notification");
                    e((a<T>) c2);
                    z = true;
                }
                z2 = false;
                boolean f2 = f((a<T>) c2);
                d.j.a.a.a.b("AbstractMessageHandler", "can send message " + f2);
                if (z && z2 && f2) {
                    a((a<T>) c2, a((a<T>) c2));
                    c((a<T>) c2);
                    d.j.a.a.a.b("AbstractMessageHandler", "send message end ");
                }
            } else {
                str = "schedule send message off, send message directly";
            }
            d.j.a.a.a.b("AbstractMessageHandler", str);
            z = true;
            boolean f22 = f((a<T>) c2);
            d.j.a.a.a.b("AbstractMessageHandler", "can send message " + f22);
            if (z) {
                a((a<T>) c2, a((a<T>) c2));
                c((a<T>) c2);
                d.j.a.a.a.b("AbstractMessageHandler", "send message end ");
            }
        }
        return z;
    }

    public Context c() {
        return this.f38593b;
    }

    public abstract T c(Intent intent);

    public void c(MessageV3 messageV3) {
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            b().b(c(), MzPushMessage.fromMessageV3(messageV3));
        } else if (MzSystemUtils.isRunningProcess(c(), messageV3.getUploadDataPackageName())) {
            d.j.a.a.a.d("AbstractMessageHandler", "send notification arrived message to " + messageV3.getUploadDataPackageName());
            Intent intent = new Intent();
            intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
            intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_ARRIVED);
            MzSystemUtils.sendMessageFromBroadcast(c(), intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getUploadDataPackageName());
        }
    }

    public void c(T t) {
    }

    public int d(T t) {
        return 0;
    }

    public String d(Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY) : null;
        if (TextUtils.isEmpty(stringExtra)) {
            String deviceId = MzSystemUtils.getDeviceId(c());
            d.j.a.a.a.b("AbstractMessageHandler", "force get deviceId " + deviceId);
            return deviceId;
        }
        return stringExtra;
    }

    public String e(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
    }

    public void e(T t) {
    }

    public String f(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
    }

    public boolean f(T t) {
        return true;
    }

    public String g(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME);
        return TextUtils.isEmpty(stringExtra) ? c().getPackageName() : stringExtra;
    }

    public boolean g(T t) {
        return true;
    }

    public String h(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP);
        d.j.a.a.a.b("AbstractMessageHandler", "receive push timestamp from pushservice " + stringExtra);
        return TextUtils.isEmpty(stringExtra) ? String.valueOf(System.currentTimeMillis() / 1000) : stringExtra;
    }

    public String i(Intent intent) {
        return intent.getStringExtra("method");
    }
}
