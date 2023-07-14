package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.id;
import java.util.Map;
/* loaded from: classes10.dex */
public class ag {
    public static a a;

    /* renamed from: a  reason: collision with other field name */
    public static b f887a;

    /* loaded from: classes10.dex */
    public interface a {
        Map<String, String> a(Context context, id idVar);

        /* renamed from: a  reason: collision with other method in class */
        void m755a(Context context, id idVar);

        boolean a(Context context, id idVar, boolean z);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(id idVar);

        void a(String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m756a(id idVar);
    }

    public static Map<String, String> a(Context context, id idVar) {
        a aVar = a;
        if (aVar == null || idVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m177a("pepa listener or container is null");
            return null;
        }
        return aVar.a(context, idVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m753a(Context context, id idVar) {
        a aVar = a;
        if (aVar == null || idVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m177a("handle msg wrong");
        } else {
            aVar.m755a(context, idVar);
        }
    }

    public static void a(id idVar) {
        b bVar = f887a;
        if (bVar == null || idVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m177a("pepa clearMessage is null");
        } else {
            bVar.a(idVar);
        }
    }

    public static void a(String str) {
        b bVar = f887a;
        if (bVar == null || str == null) {
            com.xiaomi.channel.commonutils.logger.b.m177a("pepa clearMessage is null");
        } else {
            bVar.a(str);
        }
    }

    public static boolean a(Context context, id idVar, boolean z) {
        a aVar = a;
        if (aVar == null || idVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m177a("pepa judement listener or container is null");
            return false;
        }
        return aVar.a(context, idVar, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m754a(id idVar) {
        b bVar = f887a;
        if (bVar == null || idVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m177a("pepa handleReceiveMessage is null");
            return false;
        }
        return bVar.m756a(idVar);
    }
}
