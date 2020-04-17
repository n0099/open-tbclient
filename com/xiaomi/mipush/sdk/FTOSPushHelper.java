package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes8.dex */
public class FTOSPushHelper {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f20a = false;

    private static void a(Context context) {
        AbstractPushManager a2 = g.a(context).a(f.ASSEMBLE_PUSH_FTOS);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            a2.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            if (a <= 0 || a + 300000 <= elapsedRealtime) {
                a = elapsedRealtime;
                a(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f20a;
    }

    public static boolean hasNetwork(Context context) {
        return j.m108a(context);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        if (map == null || !map.containsKey("pushMsg")) {
            return;
        }
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (a2 = j.a(context)) == null) {
            return;
        }
        MiPushMessage a3 = j.a(str);
        if (a3.getExtra().containsKey("notify_effect")) {
            return;
        }
        a2.onNotificationMessageClicked(context, a3);
    }

    public static void setNeedRegister(boolean z) {
        f20a = z;
    }

    public static void uploadToken(Context context, String str) {
        j.a(context, f.ASSEMBLE_PUSH_FTOS, str);
    }
}
