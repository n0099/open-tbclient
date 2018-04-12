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
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.push.service.ah;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.aq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends f.a {
    private Context g;
    private final int a = 30;
    private final int b = -1;
    private final int c = 3600;
    private final String d = MiPushClient.PREF_EXTRA;
    private final String e = "GeoFenceNetInfoUpdateJob";
    private final String f = "last_upload_lbs_data_timestamp";
    private Comparator<ScanResult> h = new e(this);

    public d(Context context) {
        this.g = context;
    }

    private Location a(Location location, Location location2) {
        return location == null ? location2 : (location2 == null || location.getTime() > location2.getTime()) ? location : location2;
    }

    private boolean a(long j) {
        return Math.abs((System.currentTimeMillis() / 1000) - this.g.getSharedPreferences(MiPushClient.PREF_EXTRA, 0).getLong("last_upload_lbs_data_timestamp", -1L)) / 1000 > j;
    }

    private boolean c() {
        if (com.xiaomi.channel.commonutils.network.d.f(this.g)) {
            return true;
        }
        int a = ah.a(this.g).a(com.xiaomi.xmpush.thrift.e.UploadNOWIFIGeoLocFrequency.a(), 3600);
        if (com.xiaomi.channel.commonutils.network.d.g(this.g) && a(a)) {
            return true;
        }
        if (com.xiaomi.channel.commonutils.network.d.h(this.g) && a(a)) {
            return true;
        }
        return com.xiaomi.channel.commonutils.network.d.i(this.g) && a((long) a);
    }

    private com.xiaomi.xmpush.thrift.m d() {
        com.xiaomi.xmpush.thrift.m mVar = new com.xiaomi.xmpush.thrift.m();
        mVar.a(e());
        mVar.b(f());
        mVar.a(g());
        return mVar;
    }

    private List<com.xiaomi.xmpush.thrift.v> e() {
        try {
            List<ScanResult> scanResults = ((WifiManager) this.g.getSystemService("wifi")).getScanResults();
            if (com.xiaomi.channel.commonutils.misc.b.a(scanResults)) {
                return null;
            }
            Collections.sort(scanResults, this.h);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < Math.min(30, scanResults.size()); i++) {
                ScanResult scanResult = scanResults.get(i);
                if (scanResult != null) {
                    com.xiaomi.xmpush.thrift.v vVar = new com.xiaomi.xmpush.thrift.v();
                    vVar.a(TextUtils.isEmpty(scanResult.BSSID) ? "" : scanResult.BSSID);
                    vVar.a(scanResult.level);
                    vVar.b(scanResult.SSID);
                    arrayList.add(vVar);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    private List<com.xiaomi.xmpush.thrift.b> f() {
        try {
            List neighboringCellInfo = ((TelephonyManager) this.g.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNeighboringCellInfo();
            int i = 0;
            ArrayList arrayList = null;
            while (i < neighboringCellInfo.size()) {
                NeighboringCellInfo neighboringCellInfo2 = (NeighboringCellInfo) neighboringCellInfo.get(i);
                ArrayList arrayList2 = new ArrayList();
                if (neighboringCellInfo2.getLac() > 0 || neighboringCellInfo2.getCid() > 0) {
                    com.xiaomi.xmpush.thrift.b bVar = new com.xiaomi.xmpush.thrift.b();
                    bVar.a(neighboringCellInfo2.getCid());
                    bVar.b((neighboringCellInfo2.getRssi() * 2) - 113);
                    arrayList2.add(bVar);
                }
                i++;
                arrayList = arrayList2;
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    private com.xiaomi.xmpush.thrift.i g() {
        Location h;
        if (b() && (h = h()) != null) {
            com.xiaomi.xmpush.thrift.l lVar = new com.xiaomi.xmpush.thrift.l();
            lVar.b(h.getLatitude());
            lVar.a(h.getLongitude());
            com.xiaomi.xmpush.thrift.i iVar = new com.xiaomi.xmpush.thrift.i();
            iVar.a(h.getAccuracy());
            iVar.a(lVar);
            iVar.a(h.getProvider());
            iVar.a(new Date().getTime() - h.getTime());
            return iVar;
        }
        return null;
    }

    private Location h() {
        Location location;
        Location location2;
        Location location3;
        LocationManager locationManager = (LocationManager) this.g.getSystemService(Headers.LOCATION);
        try {
            location = locationManager.getLastKnownLocation(LivenessRecogActivity.f.J);
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

    private void i() {
        SharedPreferences.Editor edit = this.g.getSharedPreferences(MiPushClient.PREF_EXTRA, 0).edit();
        edit.putLong("last_upload_lbs_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    @Override // com.xiaomi.channel.commonutils.misc.f.a
    public int a() {
        return 14;
    }

    protected boolean b() {
        PackageManager packageManager = this.g.getPackageManager();
        String packageName = this.g.getPackageName();
        return (packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", packageName) == 0) || (packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", packageName) == 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!com.xiaomi.channel.commonutils.network.d.e(this.g)) {
            com.xiaomi.channel.commonutils.logger.b.d("GeoFenceNetInfoUpdateJobNetwork.is not Connected");
        } else if (!c()) {
            com.xiaomi.channel.commonutils.logger.b.d("GeoFenceNetInfoUpdateJobverifyUploadData");
        } else {
            byte[] a = aq.a(d());
            ae aeVar = new ae(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, false);
            aeVar.c(com.xiaomi.xmpush.thrift.o.GeoUpdateLoc.N);
            aeVar.a(a);
            u.a(this.g).a(aeVar, com.xiaomi.xmpush.thrift.a.Notification, true, null);
            i();
            com.xiaomi.channel.commonutils.logger.b.a("GeoFenceNetInfoUpdateJob: update_loc_data");
        }
    }
}
