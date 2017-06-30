package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
/* loaded from: classes2.dex */
public class f {
    private static volatile f a;
    private final String b = "GeoFenceRegMessageProcessor.";
    private Context c;

    private f(Context context) {
        this.c = context;
    }

    public static f a(Context context) {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f(context);
                }
            }
        }
        return a;
    }

    private com.xiaomi.xmpush.thrift.s a() {
        ArrayList<com.xiaomi.xmpush.thrift.j> a2 = com.xiaomi.push.service.e.a(this.c).a();
        com.xiaomi.xmpush.thrift.s sVar = new com.xiaomi.xmpush.thrift.s();
        TreeSet treeSet = new TreeSet();
        Iterator<com.xiaomi.xmpush.thrift.j> it = a2.iterator();
        while (it.hasNext()) {
            treeSet.add(it.next());
        }
        sVar.a(treeSet);
        return sVar;
    }

    private void a(com.xiaomi.xmpush.thrift.j jVar) {
        byte[] a2 = aq.a(jVar);
        ae aeVar = new ae("-1", false);
        aeVar.c(com.xiaomi.xmpush.thrift.o.GeoPackageUninstalled.N);
        aeVar.a(a2);
        u.a(this.c).a(aeVar, com.xiaomi.xmpush.thrift.a.Notification, true, null);
        com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor.report package not exist geo_fencing id:" + jVar.a());
    }

    private void a(com.xiaomi.xmpush.thrift.j jVar, boolean z) {
        byte[] a2 = aq.a(jVar);
        ae aeVar = new ae("-1", false);
        aeVar.c(z ? com.xiaomi.xmpush.thrift.o.GeoRegsiterResult.N : com.xiaomi.xmpush.thrift.o.GeoUnregsiterResult.N);
        aeVar.a(a2);
        u.a(this.c).a(aeVar, com.xiaomi.xmpush.thrift.a.Notification, true, null);
        com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor.report geo_fencing id:" + jVar.a() + " " + (z ? "geo_reg" : "geo_unreg"));
    }

    private com.xiaomi.xmpush.thrift.j d(ae aeVar) {
        if (com.xiaomi.push.service.h.a(this.c) && com.xiaomi.push.service.h.b(this.c)) {
            try {
                com.xiaomi.xmpush.thrift.j jVar = new com.xiaomi.xmpush.thrift.j();
                aq.a(jVar, aeVar.m());
                return jVar;
            } catch (org.apache.thrift.f e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void a(ae aeVar) {
        com.xiaomi.xmpush.thrift.j d = d(aeVar);
        if (d == null) {
            com.xiaomi.channel.commonutils.logger.b.d("registration convert geofence object failed notification_id:" + aeVar.c());
        } else if (!com.xiaomi.channel.commonutils.android.b.f(this.c, d.g())) {
            a(d);
        } else {
            if (com.xiaomi.push.service.e.a(this.c).a(d) == -1) {
                com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor. insert a new geofence failed about geo_id:" + d.a());
            }
            new g(this.c).a(d);
            a(d, true);
            com.xiaomi.channel.commonutils.logger.b.a("receive geo reg notification");
        }
    }

    public void b(ae aeVar) {
        com.xiaomi.xmpush.thrift.j d = d(aeVar);
        if (d == null) {
            com.xiaomi.channel.commonutils.logger.b.d("unregistration convert geofence object failed notification_id:" + aeVar.c());
        } else if (!com.xiaomi.channel.commonutils.android.b.f(this.c, d.g())) {
            a(d);
        } else {
            if (com.xiaomi.push.service.e.a(this.c).d(d.a()) == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor. delete a geofence about geo_id:" + d.a() + " falied");
            }
            if (com.xiaomi.push.service.g.a(this.c).b(d.a()) == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor. delete all geofence messages about geo_id:" + d.a() + " failed");
            }
            new g(this.c).a(d.a());
            a(d, false);
            com.xiaomi.channel.commonutils.logger.b.a("receive geo unreg notification");
        }
    }

    public void c(ae aeVar) {
        if (com.xiaomi.push.service.h.a(this.c) && com.xiaomi.push.service.h.b(this.c) && com.xiaomi.channel.commonutils.android.b.f(this.c, aeVar.i)) {
            com.xiaomi.xmpush.thrift.s a2 = a();
            byte[] a3 = aq.a(a2);
            ae aeVar2 = new ae("-1", false);
            aeVar2.c(com.xiaomi.xmpush.thrift.o.GeoUpload.N);
            aeVar2.a(a3);
            u.a(this.c).a(aeVar2, com.xiaomi.xmpush.thrift.a.Notification, true, null);
            com.xiaomi.channel.commonutils.logger.b.c("GeoFenceRegMessageProcessor.sync_geo_data. geos size:" + a2.a().size());
        }
    }
}
