package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hh;
import com.xiaomi.push.hr;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class s {
    public static volatile s a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f88a;

    public s(Context context) {
        this.f88a = context.getApplicationContext();
    }

    public static s a(Context context) {
        if (a == null) {
            synchronized (s.class) {
                if (a == null) {
                    a = new s(context);
                }
            }
        }
        return a;
    }

    public static void a(Context context, id idVar) {
        a(context).a(idVar, 0, true);
    }

    public static void a(Context context, id idVar, boolean z) {
        a(context).a(idVar, 1, z);
    }

    private void a(id idVar, int i, boolean z) {
        if (com.xiaomi.push.j.m711a(this.f88a) || !com.xiaomi.push.j.m710a() || idVar == null || idVar.f632a != hh.SendMessage || idVar.m624a() == null || !z) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m180a("click to start activity result:" + String.valueOf(i));
        ig igVar = new ig(idVar.m624a().m584a(), false);
        igVar.c(hr.SDK_START_ACTIVITY.f509a);
        igVar.b(idVar.m625a());
        igVar.d(idVar.f639b);
        HashMap hashMap = new HashMap();
        igVar.f651a = hashMap;
        hashMap.put("result", String.valueOf(i));
        ao.a(this.f88a).a(igVar, hh.Notification, false, false, null, true, idVar.f639b, idVar.f635a, true, false);
    }

    public static void b(Context context, id idVar, boolean z) {
        a(context).a(idVar, 2, z);
    }

    public static void c(Context context, id idVar, boolean z) {
        a(context).a(idVar, 3, z);
    }

    public static void d(Context context, id idVar, boolean z) {
        a(context).a(idVar, 4, z);
    }

    public static void e(Context context, id idVar, boolean z) {
        s a2;
        int i;
        b m224a = b.m224a(context);
        if (TextUtils.isEmpty(m224a.m232c()) || TextUtils.isEmpty(m224a.d())) {
            a2 = a(context);
            i = 6;
        } else {
            boolean m236f = m224a.m236f();
            a2 = a(context);
            i = m236f ? 7 : 5;
        }
        a2.a(idVar, i, z);
    }
}
