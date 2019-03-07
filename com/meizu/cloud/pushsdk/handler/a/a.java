package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a<T> implements com.meizu.cloud.pushsdk.handler.c {
    private com.meizu.cloud.pushsdk.handler.a a;
    private Context b;
    private Map<Integer, String> c;

    protected abstract void a(T t, com.meizu.cloud.pushsdk.notification.e eVar);

    protected abstract T c(Intent intent);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.b = context.getApplicationContext();
        this.a = aVar;
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
    }

    protected com.meizu.cloud.pushsdk.notification.e a(T t) {
        return null;
    }

    protected void b(T t) {
    }

    protected void c(T t) {
    }

    protected int d(T t) {
        return 0;
    }

    protected void e(T t) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY);
        if (TextUtils.isEmpty(stringExtra)) {
            String c = com.meizu.cloud.pushsdk.util.b.c(c());
            if (TextUtils.isEmpty(c)) {
                String deviceId = MzSystemUtils.getDeviceId(c());
                com.meizu.cloud.pushsdk.util.b.b(c(), deviceId);
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "force get deviceId " + deviceId);
                return deviceId;
            }
            return c;
        }
        return stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String f(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String g(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME);
        if (TextUtils.isEmpty(stringExtra)) {
            return c().getPackageName();
        }
        return stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String h(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP);
        com.meizu.cloud.a.a.e("AbstractMessageHandler", "receive push timestamp from pushservice " + stringExtra);
        if (TextUtils.isEmpty(stringExtra)) {
            return String.valueOf(System.currentTimeMillis() / 1000);
        }
        return stringExtra;
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean b(Intent intent) {
        boolean z = false;
        boolean z2 = true;
        if (a(intent)) {
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "current message Type " + a(a()));
            T c = c(intent);
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
            if (z && z2) {
                a((a<T>) c, a((a<T>) c));
                c((a<T>) c);
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "send message end ");
            }
        }
        return z;
    }

    public com.meizu.cloud.pushsdk.handler.a b() {
        return this.a;
    }

    public Context c() {
        return this.b;
    }

    public String i(Intent intent) {
        return intent.getStringExtra("method");
    }

    public boolean a(String str) {
        try {
            return c().getPackageName().equals(new JSONObject(str).getString("appId"));
        } catch (Exception e) {
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "parse notification error");
            return false;
        }
    }

    public String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            if (map == null) {
                str = null;
            } else {
                String str2 = map.get("sk");
                str = TextUtils.isEmpty(str2) ? com.meizu.cloud.pushsdk.pushtracer.utils.d.a((Map) map).toString() : str2;
            }
        }
        com.meizu.cloud.a.a.e("AbstractMessageHandler", "self json " + str);
        return str;
    }

    private String a(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i, String str) {
        boolean z = true;
        if (i == 0) {
            z = com.meizu.cloud.pushsdk.util.b.e(c(), str);
        } else if (i == 1) {
            z = com.meizu.cloud.pushsdk.util.b.f(c(), str);
        }
        com.meizu.cloud.a.a.e("AbstractMessageHandler", str + (i == 0 ? " canNotificationMessage " : " canThroughMessage ") + z);
        return z;
    }
}
