package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.push.gg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes8.dex */
public class x {

    /* renamed from: a  reason: collision with other field name */
    public static final Map<String, byte[]> f1011a = new HashMap();
    public static ArrayList<Pair<String, byte[]>> a = new ArrayList<>();

    public static void a(Context context, int i, String str) {
        synchronized (f1011a) {
            for (String str2 : f1011a.keySet()) {
                com.xiaomi.channel.commonutils.logger.b.m99a("notify registration error. " + str2);
                a(context, str2, f1011a.get(str2), i, str);
            }
            f1011a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, ah.a(str));
    }

    public static void a(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (a) {
                arrayList = a;
                a = new ArrayList<>();
            }
            boolean a2 = com.xiaomi.push.t.a();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                ah.a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!a2) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error when process pending message. " + e);
            xMPushService.a(10, e);
        }
    }

    public static void a(XMPushService xMPushService, boolean z) {
        try {
            synchronized (f1011a) {
                for (String str : f1011a.keySet()) {
                    com.xiaomi.channel.commonutils.logger.b.m99a("processing pending registration request. " + str);
                    ah.a(xMPushService, str, f1011a.get(str));
                    if (z && !com.xiaomi.push.t.a()) {
                        try {
                            Thread.sleep(200L);
                        } catch (Exception unused) {
                        }
                    }
                }
                f1011a.clear();
            }
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to deal with pending register request. " + e);
            xMPushService.a(10, e);
        }
    }

    public static void a(String str, byte[] bArr) {
        synchronized (f1011a) {
            com.xiaomi.channel.commonutils.logger.b.m99a("pending registration request. " + str);
            f1011a.put(str, bArr);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (a) {
            a.add(new Pair<>(str, bArr));
            if (a.size() > 50) {
                a.remove(0);
            }
        }
    }
}
