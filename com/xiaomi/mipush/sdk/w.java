package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes3.dex */
public class w {
    private static volatile w a;
    private final String b = "GeoFenceRegMessageProcessor.";
    private Context c;

    private w(Context context) {
        this.c = context;
    }

    public static w a(Context context) {
        if (a == null) {
            synchronized (w.class) {
                if (a == null) {
                    a = new w(context);
                }
            }
        }
        return a;
    }

    private com.xiaomi.xmpush.thrift.m a(com.xiaomi.xmpush.thrift.ai aiVar, boolean z) {
        if (!z || com.xiaomi.push.service.j.a(this.c)) {
            if (!z || com.xiaomi.push.service.j.c(this.c)) {
                try {
                    com.xiaomi.xmpush.thrift.m mVar = new com.xiaomi.xmpush.thrift.m();
                    com.xiaomi.xmpush.thrift.at.a(mVar, aiVar.q());
                    return mVar;
                } catch (org.apache.thrift.f e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    private com.xiaomi.xmpush.thrift.v a(boolean z) {
        com.xiaomi.xmpush.thrift.v vVar = new com.xiaomi.xmpush.thrift.v();
        TreeSet treeSet = new TreeSet();
        if (z) {
            Iterator<com.xiaomi.xmpush.thrift.m> it = com.xiaomi.push.service.g.a(this.c).a().iterator();
            while (it.hasNext()) {
                treeSet.add(it.next());
            }
        }
        vVar.a(treeSet);
        return vVar;
    }

    public static void a(Context context, boolean z) {
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai(com.xiaomi.push.service.aq.a(), false);
        aiVar.b(d.a(context).c());
        aiVar.c(com.xiaomi.xmpush.thrift.r.GeoAuthorized.aa);
        aiVar.h = new HashMap();
        aiVar.h.put("permission_to_location", String.valueOf(z));
        az.a(context).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, (com.xiaomi.xmpush.thrift.u) null);
    }

    private void a(com.xiaomi.xmpush.thrift.m mVar) {
        byte[] a2 = com.xiaomi.xmpush.thrift.at.a(mVar);
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai(com.xiaomi.push.service.aq.a(), false);
        aiVar.c(com.xiaomi.xmpush.thrift.r.GeoPackageUninstalled.aa);
        aiVar.a(a2);
        az.a(this.c).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, true, (com.xiaomi.xmpush.thrift.u) null);
        com.xiaomi.channel.commonutils.logger.b.c("GeoFenceRegMessageProcessor. report package not exist geo_fencing id:" + mVar.a());
    }

    private void a(com.xiaomi.xmpush.thrift.m mVar, boolean z, boolean z2) {
        byte[] a2 = com.xiaomi.xmpush.thrift.at.a(mVar);
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai(com.xiaomi.push.service.aq.a(), false);
        aiVar.c(z ? com.xiaomi.xmpush.thrift.r.GeoRegsiterResult.aa : com.xiaomi.xmpush.thrift.r.GeoUnregsiterResult.aa);
        aiVar.a(a2);
        if (z2) {
            aiVar.a("permission_to_location", com.xiaomi.push.service.ba.b);
        }
        az.a(this.c).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, true, (com.xiaomi.xmpush.thrift.u) null);
        com.xiaomi.channel.commonutils.logger.b.c("GeoFenceRegMessageProcessor. report geo_fencing id:" + mVar.a() + HanziToPinyin.Token.SEPARATOR + (z ? "geo_reg" : "geo_unreg") + "  isUnauthorized:" + z2);
    }

    public static boolean a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return TextUtils.equals("1", map.get("__geo_local_cache"));
    }

    private boolean d(com.xiaomi.xmpush.thrift.ai aiVar) {
        return a(aiVar.j()) && com.xiaomi.push.service.j.d(this.c);
    }

    public void a(com.xiaomi.xmpush.thrift.ai aiVar) {
        boolean d = d(aiVar);
        com.xiaomi.xmpush.thrift.m a2 = a(aiVar, d);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.c("GeoFenceRegMessageProcessor. registration convert geofence object failed notification_id:" + aiVar.c());
        } else if (!com.xiaomi.push.service.j.e(this.c)) {
            a(a2, true, true);
        } else if (!com.xiaomi.channel.commonutils.android.a.e(this.c, a2.g())) {
            if (d) {
                a(a2);
            }
        } else if (!d) {
            a(a2, true, false);
        } else {
            if (com.xiaomi.push.service.g.a(this.c).a(a2) == -1) {
                com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor. insert a new geofence failed about geo_id:" + a2.a());
            }
            new x(this.c).a(a2);
            a(a2, true, false);
            com.xiaomi.channel.commonutils.logger.b.c("GeoFenceRegMessageProcessor. receive geo reg notification");
        }
    }

    public void b(com.xiaomi.xmpush.thrift.ai aiVar) {
        boolean d = d(aiVar);
        com.xiaomi.xmpush.thrift.m a2 = a(aiVar, d);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.c("GeoFenceRegMessageProcessor. unregistration convert geofence object failed notification_id:" + aiVar.c());
        } else if (!com.xiaomi.push.service.j.e(this.c)) {
            a(a2, false, true);
        } else if (!com.xiaomi.channel.commonutils.android.a.e(this.c, a2.g())) {
            if (d) {
                a(a2);
            }
        } else if (!d) {
            a(a2, false, false);
        } else {
            if (com.xiaomi.push.service.g.a(this.c).d(a2.a()) == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor. delete a geofence about geo_id:" + a2.a() + " falied");
            }
            if (com.xiaomi.push.service.i.a(this.c).b(a2.a()) == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor. delete all geofence messages about geo_id:" + a2.a() + " failed");
            }
            new x(this.c).a(a2.a());
            a(a2, false, false);
            com.xiaomi.channel.commonutils.logger.b.c("GeoFenceRegMessageProcessor. receive geo unreg notification");
        }
    }

    public void c(com.xiaomi.xmpush.thrift.ai aiVar) {
        if (com.xiaomi.push.service.j.e(this.c)) {
            boolean d = d(aiVar);
            if (!d || com.xiaomi.push.service.j.a(this.c)) {
                if ((!d || com.xiaomi.push.service.j.c(this.c)) && com.xiaomi.channel.commonutils.android.a.e(this.c, aiVar.i)) {
                    com.xiaomi.xmpush.thrift.v a2 = a(d);
                    byte[] a3 = com.xiaomi.xmpush.thrift.at.a(a2);
                    com.xiaomi.xmpush.thrift.ai aiVar2 = new com.xiaomi.xmpush.thrift.ai(LivenessStat.TYPE_STRING_DEFAULT, false);
                    aiVar2.c(com.xiaomi.xmpush.thrift.r.GeoUpload.aa);
                    aiVar2.a(a3);
                    az.a(this.c).a((az) aiVar2, com.xiaomi.xmpush.thrift.a.Notification, true, (com.xiaomi.xmpush.thrift.u) null);
                    com.xiaomi.channel.commonutils.logger.b.c("GeoFenceRegMessageProcessor. sync_geo_data. geos size:" + a2.a().size());
                }
            }
        }
    }
}
