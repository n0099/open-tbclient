package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.xiaomi.channel.commonutils.misc.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class u extends h.a {
    private final int a = -1;
    private final int b = 3600;
    private Context c;
    private int d;

    public u(Context context, int i) {
        this.c = context;
        this.d = i;
    }

    private static Location a(Location location, Location location2) {
        return location == null ? location2 : (location2 == null || location.getTime() > location2.getTime()) ? location : location2;
    }

    public static void a(Context context, boolean z) {
        com.xiaomi.xmpush.thrift.p b = b(context);
        byte[] a = com.xiaomi.xmpush.thrift.at.a(b);
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai(LivenessStat.TYPE_STRING_DEFAULT, false);
        aiVar.c(com.xiaomi.xmpush.thrift.r.GeoUpdateLoc.aa);
        aiVar.a(a);
        aiVar.a(new HashMap());
        aiVar.j().put(Constants.EXTRA_KEY_INITIAL_WIFI_UPLOAD, String.valueOf(z));
        boolean b2 = com.xiaomi.push.service.j.b(context);
        if (b2) {
            aiVar.j().put(Constants.EXTRA_KEY_XMSF_GEO_IS_WORK, String.valueOf(b2));
        }
        com.xiaomi.channel.commonutils.logger.b.c("reportLocInfo locInfo timestamp:" + System.currentTimeMillis() + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(b.c() != null ? b.c() : "null") + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(b.b != null ? b.b.toString() : null) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(b.a != null ? b.a.toString() : null));
        az.a(context).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, true, (com.xiaomi.xmpush.thrift.u) null);
        g(context);
    }

    private boolean a(long j) {
        return ((float) Math.abs((System.currentTimeMillis() / 1000) - this.c.getSharedPreferences("mipush_extra", 4).getLong("last_upload_lbs_data_timestamp", -1L))) > ((float) j) * 0.9f;
    }

    protected static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        return (packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", packageName) == 0) || (packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", packageName) == 0);
    }

    private static com.xiaomi.xmpush.thrift.p b(Context context) {
        com.xiaomi.xmpush.thrift.p pVar = new com.xiaomi.xmpush.thrift.p();
        if (!com.xiaomi.channel.commonutils.android.f.g()) {
            pVar.a(c(context));
            pVar.b(d(context));
            pVar.a(e(context));
        }
        return pVar;
    }

    private boolean b() {
        if (com.xiaomi.channel.commonutils.network.d.e(this.c)) {
            return true;
        }
        return com.xiaomi.channel.commonutils.network.d.f(this.c) && a((long) Math.max(60, com.xiaomi.push.service.an.a(this.c).a(com.xiaomi.xmpush.thrift.g.UploadNOWIFIGeoLocFrequency.a(), 3600)));
    }

    private static List<com.xiaomi.xmpush.thrift.y> c(Context context) {
        v vVar = new v();
        try {
            List<ScanResult> scanResults = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getScanResults();
            if (com.xiaomi.channel.commonutils.misc.c.a(scanResults)) {
                return null;
            }
            Collections.sort(scanResults, vVar);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < Math.min(30, scanResults.size()); i++) {
                ScanResult scanResult = scanResults.get(i);
                if (scanResult != null) {
                    com.xiaomi.xmpush.thrift.y yVar = new com.xiaomi.xmpush.thrift.y();
                    yVar.a(TextUtils.isEmpty(scanResult.BSSID) ? "" : scanResult.BSSID);
                    yVar.a(scanResult.level);
                    yVar.b(scanResult.SSID);
                    arrayList.add(yVar);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    private static List<com.xiaomi.xmpush.thrift.c> d(Context context) {
        try {
            List neighboringCellInfo = ((TelephonyManager) context.getSystemService("phone")).getNeighboringCellInfo();
            int i = 0;
            ArrayList arrayList = null;
            while (i < neighboringCellInfo.size()) {
                NeighboringCellInfo neighboringCellInfo2 = (NeighboringCellInfo) neighboringCellInfo.get(i);
                ArrayList arrayList2 = new ArrayList();
                if (neighboringCellInfo2.getLac() > 0 || neighboringCellInfo2.getCid() > 0) {
                    com.xiaomi.xmpush.thrift.c cVar = new com.xiaomi.xmpush.thrift.c();
                    cVar.a(neighboringCellInfo2.getCid());
                    cVar.b((neighboringCellInfo2.getRssi() * 2) - 113);
                    arrayList2.add(cVar);
                }
                i++;
                arrayList = arrayList2;
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    private static com.xiaomi.xmpush.thrift.l e(Context context) {
        Location f;
        if (a(context) && (f = f(context)) != null) {
            com.xiaomi.xmpush.thrift.o oVar = new com.xiaomi.xmpush.thrift.o();
            oVar.b(f.getLatitude());
            oVar.a(f.getLongitude());
            com.xiaomi.xmpush.thrift.l lVar = new com.xiaomi.xmpush.thrift.l();
            lVar.a(f.getAccuracy());
            lVar.a(oVar);
            lVar.a(f.getProvider());
            lVar.a(new Date().getTime() - f.getTime());
            return lVar;
        }
        return null;
    }

    private static Location f(Context context) {
        Location location;
        Location location2;
        Location location3;
        LocationManager locationManager = (LocationManager) context.getSystemService(Headers.LOCATION);
        try {
            location = locationManager.getLastKnownLocation("network");
        } catch (Exception e) {
            location = null;
        }
        try {
            location2 = locationManager.getLastKnownLocation("gps");
        } catch (Exception e2) {
            location2 = null;
        }
        try {
            location3 = locationManager.getLastKnownLocation("passive");
        } catch (Exception e3) {
            location3 = null;
        }
        return a(location3, a(location, location2));
    }

    private static void g(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_upload_lbs_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 11;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.xiaomi.push.service.j.e(this.c) && com.xiaomi.push.service.an.a(this.c).a(com.xiaomi.xmpush.thrift.g.UploadGeoAppLocSwitch.a(), true) && com.xiaomi.channel.commonutils.network.d.d(this.c) && b() && com.xiaomi.channel.commonutils.misc.f.a(this.c, String.valueOf(11), this.d)) {
            a(this.c, false);
        }
    }
}
