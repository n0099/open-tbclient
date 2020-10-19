package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/* loaded from: classes12.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    private static Object f5044a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, Queue<String>> f837a = new HashMap();

    public static boolean a(XMPushService xMPushService, String str, String str2) {
        synchronized (f5044a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue<String> queue = f837a.get(str);
            if (queue == null) {
                String[] split = sharedPreferences.getString(str, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                queue = new LinkedList<>();
                for (String str3 : split) {
                    queue.add(str3);
                }
                f837a.put(str, queue);
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 25) {
                queue.poll();
            }
            String a2 = com.xiaomi.push.bf.a(queue, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, a2);
            edit.commit();
            return false;
        }
    }
}
