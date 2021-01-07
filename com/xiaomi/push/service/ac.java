package com.xiaomi.push.service;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/* loaded from: classes6.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    private static Object f14525a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, Queue<String>> f916a = new HashMap();

    public static boolean a(XMPushService xMPushService, String str, String str2) {
        synchronized (f14525a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue<String> queue = f916a.get(str);
            if (queue == null) {
                String[] split = sharedPreferences.getString(str, "").split(",");
                queue = new LinkedList<>();
                for (String str3 : split) {
                    queue.add(str3);
                }
                f916a.put(str, queue);
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 25) {
                queue.poll();
            }
            String a2 = com.xiaomi.push.bf.a(queue, ",");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, a2);
            edit.commit();
            return false;
        }
    }
}
