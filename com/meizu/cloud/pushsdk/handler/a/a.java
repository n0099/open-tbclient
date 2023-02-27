package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.sapi2.activity.BaseActivity;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.a.c.e;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class a<T> implements com.meizu.cloud.pushsdk.handler.c {
    public com.meizu.cloud.pushsdk.handler.a a;
    public Context b;
    public SparseArray<String> c;

    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.b = context.getApplicationContext();
        this.a = aVar;
        SparseArray<String> sparseArray = new SparseArray<>();
        this.c = sparseArray;
        sparseArray.put(2, "MESSAGE_TYPE_PUSH_SERVICE_V2");
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
        this.c.put(524288, "MESSAGE_TYPE_BRIGHT_NOTIFICATION");
        this.c.put(1048576, "MESSAGE_TYPE_NOTIFICATION_CLOSE");
    }

    private String a(int i) {
        return this.c.get(i);
    }

    private boolean a(String str, MessageV3 messageV3, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = "sa, public key not empty";
        } else if (!PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(str2)) {
            str3 = "sa, message not click method";
        } else if (com.meizu.cloud.pushsdk.util.b.l(d(), messageV3.getPackageName())) {
            com.meizu.cloud.pushsdk.util.b.c(d(), messageV3.getPackageName(), false);
            return true;
        } else {
            str3 = "sa, not first request";
        }
        DebugLogger.i("AbstractMessageHandler", str3);
        return false;
    }

    private boolean b(String str, MessageV3 messageV3, String str2) {
        if (TextUtils.isEmpty(str)) {
            DebugLogger.e("AbstractMessageHandler", "security check fail, public key is null");
            return false;
        }
        String a = com.meizu.cloud.pushsdk.util.c.a(str, str2);
        DebugLogger.i("AbstractMessageHandler", "decrypt sign: " + a);
        boolean a2 = com.meizu.cloud.pushsdk.handler.a.c.e.a(a, messageV3);
        DebugLogger.i("AbstractMessageHandler", "check public key result: " + a2);
        return a2;
    }

    private String e() {
        String str = null;
        for (int i = 0; i < 2; i++) {
            str = b();
            if (!TextUtils.isEmpty(str)) {
                break;
            }
        }
        return str;
    }

    public com.meizu.cloud.pushsdk.notification.c a(T t) {
        return null;
    }

    public void a(Context context, MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.handler.a.a.a b;
        com.meizu.cloud.pushsdk.notification.model.a a;
        if (messageV3.getAdvertisementOption() == null || TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage()) || (b = com.meizu.cloud.pushsdk.b.a(context).b()) == null || (a = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3)) == null) {
            return;
        }
        b.a(a.a());
    }

    public void a(MessageV3 messageV3) {
        if (messageV3 == null || messageV3.getAdvertisementOption() == null || TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) {
            if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                c().b(d(), MzPushMessage.fromMessageV3(messageV3));
            } else if (MzSystemUtils.isRunningProcess(d(), messageV3.getUploadDataPackageName())) {
                DebugLogger.i("AbstractMessageHandler", "send notification arrived message to " + messageV3.getUploadDataPackageName());
                Intent intent = new Intent();
                if (MinSdkChecker.isSupportTransmitMessageValue(this.b, messageV3.getUploadDataPackageName())) {
                    intent.putExtra(PushConstants.MZ_MESSAGE_VALUE, com.meizu.cloud.pushsdk.handler.d.a(messageV3));
                } else {
                    intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
                }
                intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_ARRIVED);
                MzSystemUtils.sendMessageFromBroadcast(d(), intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getUploadDataPackageName());
            }
        }
    }

    public abstract void a(T t, com.meizu.cloud.pushsdk.notification.c cVar);

    public boolean a(int i, String str) {
        boolean z = true;
        if (i == 0) {
            z = com.meizu.cloud.pushsdk.util.b.e(d(), str);
        } else if (i == 1) {
            z = com.meizu.cloud.pushsdk.util.b.h(d(), str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i == 0 ? " canNotificationMessage " : " canThroughMessage ");
        sb.append(z);
        DebugLogger.i("AbstractMessageHandler", sb.toString());
        return z;
    }

    public final boolean a(MessageV3 messageV3, String str) {
        String a = com.meizu.cloud.pushsdk.handler.a.c.e.a(messageV3);
        if (TextUtils.isEmpty(a)) {
            DebugLogger.i("AbstractMessageHandler", "message does not contain signature field");
            return false;
        }
        String k = com.meizu.cloud.pushsdk.util.b.k(d(), messageV3.getPackageName());
        DebugLogger.i("AbstractMessageHandler", "local public key is: " + k);
        if (a(k, messageV3, str)) {
            DebugLogger.i("AbstractMessageHandler", "message special approval no check");
            return true;
        } else if (b(k, messageV3, a)) {
            DebugLogger.i("AbstractMessageHandler", "security check passed");
            return true;
        } else {
            String e = e();
            DebugLogger.i("AbstractMessageHandler", "network request public key: " + e);
            if (!b(e, messageV3, a)) {
                DebugLogger.e("AbstractMessageHandler", "security check fail");
                return false;
            }
            com.meizu.cloud.pushsdk.util.b.k(d(), messageV3.getPackageName(), e);
            DebugLogger.i("AbstractMessageHandler", "security check passed");
            return true;
        }
    }

    public boolean a(T t, String str) {
        return true;
    }

    public boolean a(String str) {
        try {
            return d().getPackageName().equals(new JSONObject(str).getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
        } catch (Exception unused) {
            DebugLogger.e("AbstractMessageHandler", "parse notification error");
            return false;
        }
    }

    public String b() {
        return new e.a((String) com.meizu.cloud.pushsdk.c.a.a(PushConstants.GET_PUBLIC_KEY).a().a().a()).a();
    }

    public String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("launcher");
            return (!jSONObject.has("pkg") || TextUtils.isEmpty(jSONObject.getString("pkg"))) ? "" : jSONObject.getString("pkg");
        } catch (Exception unused) {
            DebugLogger.e("AbstractMessageHandler", "parse desk top json error");
            return "";
        }
    }

    public void b(MessageV3 messageV3) {
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            c(messageV3);
            return;
        }
        com.meizu.cloud.pushsdk.notification.model.a a = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a != null) {
            DebugLogger.e("AbstractMessageHandler", "delete notifyId " + a.a() + " notifyKey " + a.b());
            if (TextUtils.isEmpty(a.b())) {
                com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(messageV3.getUploadDataPackageName(), a.a());
            } else {
                com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(messageV3.getUploadDataPackageName(), a.b());
            }
        }
    }

    public void b(T t) {
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7 A[ADDED_TO_REGION] */
    @Override // com.meizu.cloud.pushsdk.handler.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(Intent intent) {
        String str;
        String str2;
        boolean z = false;
        if (a(intent)) {
            DebugLogger.i("AbstractMessageHandler", "current message Type " + a(a()));
            T c = c(intent);
            if (!a((a<T>) c, k(intent))) {
                DebugLogger.e("AbstractMessageHandler", "invalid push message");
                return false;
            }
            DebugLogger.i("AbstractMessageHandler", "current Handler message " + c);
            b((a<T>) c);
            int d = d((a<T>) c);
            boolean z2 = true;
            if (d != 0) {
                if (d != 1) {
                    if (d != 2) {
                        if (d == 3) {
                            DebugLogger.i("AbstractMessageHandler", "schedule notification");
                            e((a<T>) c);
                        } else if (d != 4) {
                            str2 = d == 5 ? "ad cannot show message" : "expire notification, don't show message";
                            z2 = false;
                            boolean g = g((a<T>) c);
                            DebugLogger.i("AbstractMessageHandler", "can send message " + g);
                            if (z && z2 && g) {
                                a((a<T>) c, a((a<T>) c));
                                c((a<T>) c);
                                DebugLogger.i("AbstractMessageHandler", "send message end ");
                            }
                            return z;
                        } else {
                            DebugLogger.i("AbstractMessageHandler", "bright notification");
                            f((a<T>) c);
                        }
                        z = true;
                        z2 = false;
                        boolean g2 = g((a<T>) c);
                        DebugLogger.i("AbstractMessageHandler", "can send message " + g2);
                        if (z) {
                            a((a<T>) c, a((a<T>) c));
                            c((a<T>) c);
                            DebugLogger.i("AbstractMessageHandler", "send message end ");
                        }
                        return z;
                    }
                    str = "notification on time ,show message";
                }
                DebugLogger.i("AbstractMessageHandler", str2);
                z2 = false;
                boolean g22 = g((a<T>) c);
                DebugLogger.i("AbstractMessageHandler", "can send message " + g22);
                if (z) {
                }
                return z;
            }
            str = "schedule send message off, send message directly";
            DebugLogger.i("AbstractMessageHandler", str);
            z = true;
            boolean g222 = g((a<T>) c);
            DebugLogger.i("AbstractMessageHandler", "can send message " + g222);
            if (z) {
            }
            return z;
        }
        return false;
    }

    public com.meizu.cloud.pushsdk.handler.a c() {
        return this.a;
    }

    public abstract T c(Intent intent);

    public void c(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.model.a a = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a != null) {
            DebugLogger.i("AbstractMessageHandler", "delete notifyKey " + a.b() + " notifyId " + a.a());
            if (TextUtils.isEmpty(a.b())) {
                com.meizu.cloud.pushsdk.notification.c.b.c(d(), messageV3.getUploadDataPackageName(), a.a());
            } else {
                com.meizu.cloud.pushsdk.notification.c.b.a(d(), messageV3.getUploadDataPackageName(), a.b());
            }
        }
    }

    public void c(T t) {
    }

    public int d(T t) {
        return 0;
    }

    public Context d() {
        return this.b;
    }

    public String d(Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY) : null;
        if (TextUtils.isEmpty(stringExtra)) {
            String a = com.meizu.cloud.pushsdk.b.c.a(d());
            DebugLogger.e("AbstractMessageHandler", "force get deviceId " + a);
            return a;
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

    public void f(T t) {
    }

    public String g(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME);
        return TextUtils.isEmpty(stringExtra) ? d().getPackageName() : stringExtra;
    }

    public boolean g(T t) {
        return true;
    }

    public String h(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP);
        DebugLogger.i("AbstractMessageHandler", "receive push timestamp from pushservice " + stringExtra);
        return TextUtils.isEmpty(stringExtra) ? String.valueOf(System.currentTimeMillis() / 1000) : stringExtra;
    }

    public boolean i(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(PushConstants.MZ_PUSH_WHITE_LIST, false);
        DebugLogger.i("AbstractMessageHandler", "receive push whiteList from pushservice " + booleanExtra);
        return booleanExtra;
    }

    public long j(Intent intent) {
        long longExtra = intent.getLongExtra(PushConstants.MZ_PUSH_DELAYED_REPORT_MILLIS, 0L);
        DebugLogger.i("AbstractMessageHandler", "receive push delayedReportMillis from pushservice " + longExtra);
        return longExtra;
    }

    public String k(Intent intent) {
        return intent.getStringExtra("method");
    }
}
