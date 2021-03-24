package com.xiaomi.push.service;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/* loaded from: classes7.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    public static Object f40940a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, Queue<String>> f881a = new HashMap();

    public static boolean a(XMPushService xMPushService, String str, String str2) {
        synchronized (f40940a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue<String> queue = f881a.get(str);
            if (queue == null) {
                String[] split = sharedPreferences.getString(str, "").split(",");
                LinkedList linkedList = new LinkedList();
                for (String str3 : split) {
                    linkedList.add(str3);
                }
                f881a.put(str, linkedList);
                queue = linkedList;
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 25) {
                queue.poll();
            }
            String a2 = com.xiaomi.push.bm.a(queue, ",");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, a2);
            edit.commit();
            return false;
        }
    }
}
