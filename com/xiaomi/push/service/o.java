package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.push.gd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with other field name */
    private static final Map<String, byte[]> f1000a = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<Pair<String, byte[]>> f14315a = new ArrayList<>();

    public static void a(Context context, int i, String str) {
        synchronized (f1000a) {
            for (String str2 : f1000a.keySet()) {
                a(context, str2, f1000a.get(str2), i, str);
            }
            f1000a.clear();
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
            synchronized (f1000a) {
                for (String str : f1000a.keySet()) {
                    w.a(xMPushService, str, f1000a.get(str));
                }
                f1000a.clear();
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            xMPushService.a(10, e);
        }
    }

    public static void a(String str, byte[] bArr) {
        synchronized (f1000a) {
            f1000a.put(str, bArr);
        }
    }

    public static void b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f14315a) {
                arrayList = f14315a;
                f14315a = new ArrayList<>();
            }
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                w.a(xMPushService, (String) next.first, (byte[]) next.second);
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            xMPushService.a(10, e);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (f14315a) {
            f14315a.add(new Pair<>(str, bArr));
            if (f14315a.size() > 50) {
                f14315a.remove(0);
            }
        }
    }
}
