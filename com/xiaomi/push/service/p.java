package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import com.xiaomi.push.fw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes7.dex */
public class p {

    /* renamed from: a  reason: collision with other field name */
    public static final Map<String, byte[]> f965a = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Pair<String, byte[]>> f41441a = new ArrayList<>();

    public static void a(Context context, int i, String str) {
        synchronized (f965a) {
            for (String str2 : f965a.keySet()) {
                a(context, str2, f965a.get(str2), i, str);
            }
            f965a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, y.a(str));
    }

    public static void a(XMPushService xMPushService) {
        try {
            synchronized (f965a) {
                for (String str : f965a.keySet()) {
                    y.a(xMPushService, str, f965a.get(str));
                }
                f965a.clear();
            }
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to deal with pending register request. " + e2);
            xMPushService.a(10, e2);
        }
    }

    public static void a(String str, byte[] bArr) {
        synchronized (f965a) {
            f965a.put(str, bArr);
        }
    }

    public static void b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f41441a) {
                arrayList = f41441a;
                f41441a = new ArrayList<>();
            }
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                y.a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error when process pending message. " + e2);
            xMPushService.a(10, e2);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (f41441a) {
            f41441a.add(new Pair<>(str, bArr));
            if (f41441a.size() > 50) {
                f41441a.remove(0);
            }
        }
    }
}
