package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes6.dex */
public class FTOSPushHelper {

    /* renamed from: a  reason: collision with root package name */
    private static long f13789a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f104a = false;

    private static void a(Context context) {
        AbstractPushManager a2 = e.a(context).a(d.ASSEMBLE_PUSH_FTOS);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.logger.b.m79a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            a2.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            if (f13789a <= 0 || f13789a + 300000 <= elapsedRealtime) {
                f13789a = elapsedRealtime;
                a(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f104a;
    }

    public static boolean hasNetwork(Context context) {
        return h.m139a(context);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        if (map == null || !map.containsKey("pushMsg")) {
            return;
        }
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (a2 = h.a(context)) == null) {
            return;
        }
        MiPushMessage a3 = h.a(str);
        if (a3.getExtra().containsKey("notify_effect")) {
            return;
        }
        a2.onNotificationMessageClicked(context, a3);
    }

    public static void setNeedRegister(boolean z) {
        f104a = z;
    }

    public static void uploadToken(Context context, String str) {
        h.a(context, d.ASSEMBLE_PUSH_FTOS, str);
    }
}
