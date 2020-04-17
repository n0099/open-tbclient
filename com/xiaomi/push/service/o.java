package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.push.fx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes8.dex */
public class o {

    /* renamed from: a  reason: collision with other field name */
    private static final Map<String, byte[]> f923a = new HashMap();
    private static ArrayList<Pair<String, byte[]>> a = new ArrayList<>();

    public static void a(Context context, int i, String str) {
        synchronized (f923a) {
            for (String str2 : f923a.keySet()) {
                a(context, str2, f923a.get(str2), i, str);
            }
            f923a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, w.a(str));
    }

    public static void a(XMPushService xMPushService) {
        try {
            synchronized (f923a) {
                for (String str : f923a.keySet()) {
                    w.a(xMPushService, str, f923a.get(str));
                }
                f923a.clear();
            }
        } catch (fx e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            xMPushService.a(10, e);
        }
    }

    public static void a(String str, byte[] bArr) {
        synchronized (f923a) {
            f923a.put(str, bArr);
        }
    }

    public static void b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (a) {
                arrayList = a;
                a = new ArrayList<>();
            }
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                w.a(xMPushService, (String) next.first, (byte[]) next.second);
            }
        } catch (fx e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            xMPushService.a(10, e);
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
