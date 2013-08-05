package com.tencent.mm.sdk.platformtools;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.baidu.zeus.Headers;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.PhoneUtil;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class LBSManager extends BroadcastReceiver {
    public static final String FILTER_GPS = "filter_gps";
    public static final int INVALID_ACC = -1000;
    public static final float INVALID_LAT = -1000.0f;
    public static final float INVALID_LNG = -1000.0f;
    public static final int MM_SOURCE_HARDWARE = 0;
    public static final int MM_SOURCE_NET = 1;
    public static final int MM_SOURCE_REPORT_HARWARE = 3;
    public static final int MM_SOURCE_REPORT_NETWORK = 4;
    private static LocationCache ab;
    private Context R;
    private OnLocationGotListener ac;
    private LocationManager ad;
    private PendingIntent ae;
    private boolean af = false;
    boolean ah = false;
    boolean ai = false;
    private MTimerHandler ak = new MTimerHandler(new MTimerHandler.CallBack() { // from class: com.tencent.mm.sdk.platformtools.LBSManager.1
        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public boolean onTimerExpired() {
            Log.v("MicroMsg.LBSManager", "get location by GPS failed.");
            LBSManager.this.ag = true;
            LBSManager.this.start();
            LBSManager.this.af = false;
            return false;
        }
    }, false);
    boolean ag = false;
    int aj = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class LocationCache {
        long time;
        float am = -1000.0f;
        float an = -1000.0f;
        int ao = LBSManager.INVALID_ACC;
        int I = 1;

        LocationCache() {
        }
    }

    /* loaded from: classes.dex */
    public interface OnLocationGotListener {
        void onLocationGot(float f, float f2, int i, int i2, String str, String str2, boolean z);
    }

    public LBSManager(Context context, OnLocationGotListener onLocationGotListener) {
        this.ac = onLocationGotListener;
        this.R = context;
        PhoneUtil.getSignalStrength(context);
        this.ad = (LocationManager) context.getSystemService(Headers.LOCATION);
        b();
        this.ae = PendingIntent.getBroadcast(context, 0, new Intent(FILTER_GPS), 134217728);
    }

    private boolean b() {
        if (this.ad != null) {
            try {
                this.ad.sendExtraCommand("gps", "force_xtra_injection", null);
                this.ad.sendExtraCommand("gps", "force_time_injection", null);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private void c() {
        this.ak.stopTimer();
        this.ag = true;
    }

    public static void setLocationCache(float f, float f2, int i, int i2) {
        if (i == 0) {
            return;
        }
        Log.v("MicroMsg.LBSManager", "setLocationCache [" + f + "," + f2 + "] acc:" + i + " source:" + i2);
        if (ab == null) {
            ab = new LocationCache();
        }
        ab.am = f;
        ab.an = f2;
        ab.ao = i;
        ab.time = System.currentTimeMillis();
        ab.I = i2;
    }

    public String getTelLocation() {
        return PhoneUtil.getCellXml(PhoneUtil.getCellInfoList(this.R));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x004e: IGET  (r0v11 int A[REMOVE]) = 
      (wrap: android.net.wifi.ScanResult : 0x0048: INVOKE  (r0v9 android.net.wifi.ScanResult A[REMOVE]) = (r3v0 java.util.List<android.net.wifi.ScanResult>), (r1v2 int) type: INTERFACE call: java.util.List.get(int):java.lang.Object)
     android.net.wifi.ScanResult.level int)] */
    public String getWIFILocation() {
        WifiManager wifiManager = (WifiManager) this.R.getSystemService("wifi");
        if (wifiManager == null) {
            Log.e("MicroMsg.LBSManager", "no wifi service");
            return "";
        } else if (wifiManager.getConnectionInfo() == null) {
            Log.e("MicroMsg.LBSManager", "WIFILocation wifi info null");
            return "";
        } else {
            LinkedList linkedList = new LinkedList();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= scanResults.size()) {
                        break;
                    }
                    linkedList.add(new PhoneUtil.MacInfo(scanResults.get(i2).BSSID, new StringBuilder().append(scanResults.get(i2).level).toString()));
                    i = i2 + 1;
                }
            }
            return PhoneUtil.getMacXml(linkedList);
        }
    }

    public boolean isGpsEnable() {
        try {
            return this.ad.isProviderEnabled("gps");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isNetworkPrividerEnable() {
        try {
            return this.ad.isProviderEnabled("network");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Location location = (Location) intent.getExtras().get(Headers.LOCATION);
        this.aj++;
        if (location != null) {
            boolean equals = "gps".equals(location.getProvider());
            if (((!equals || location.getAccuracy() > 200.0f) && (equals || location.getAccuracy() > 1000.0f)) || location.getAccuracy() <= 0.0f) {
                return;
            }
            int i = equals ? 0 : 1;
            setLocationCache((float) location.getLatitude(), (float) location.getLongitude(), (int) location.getAccuracy(), i);
            if (this.ac != null) {
                if (this.ag && this.ah && this.ai) {
                    return;
                }
                String nullAsNil = Util.nullAsNil(getWIFILocation());
                String nullAsNil2 = Util.nullAsNil(getTelLocation());
                if (!this.ag) {
                    c();
                    this.ag = true;
                    Log.v("MicroMsg.LBSManager", "location by provider ok:[" + location.getLatitude() + " , " + location.getLongitude() + "]  accuracy:" + location.getAccuracy() + "  retry count:" + this.aj + " isGpsProvider:" + equals);
                    this.ac.onLocationGot((float) location.getLatitude(), (float) location.getLongitude(), (int) location.getAccuracy(), i, nullAsNil, nullAsNil2, true);
                } else if (!this.ah && i == 0) {
                    this.ah = true;
                    Log.v("MicroMsg.LBSManager", "report location by GPS ok:[" + location.getLatitude() + " , " + location.getLongitude() + "]  accuracy:" + location.getAccuracy() + "  retry count:" + this.aj + " isGpsProvider:" + equals);
                    this.ac.onLocationGot((float) location.getLatitude(), (float) location.getLongitude(), (int) location.getAccuracy(), 3, nullAsNil, nullAsNil2, true);
                } else if (this.ai || i != 1) {
                } else {
                    this.ai = true;
                    Log.v("MicroMsg.LBSManager", "report location by Network ok:[" + location.getLatitude() + " , " + location.getLongitude() + "]  accuracy:" + location.getAccuracy() + "  retry count:" + this.aj + " isGpsProvider:" + equals);
                    this.ac.onLocationGot((float) location.getLatitude(), (float) location.getLongitude(), (int) location.getAccuracy(), 4, nullAsNil, nullAsNil2, true);
                }
            }
        }
    }

    public void removeGpsUpdate() {
        Log.v("MicroMsg.LBSManager", "removed gps update");
        if (this.ad != null) {
            this.ad.removeUpdates(this.ae);
        }
        try {
            this.R.unregisterReceiver(this);
        } catch (Exception e) {
            Log.v("MicroMsg.LBSManager", "location receiver has already unregistered");
        }
    }

    public void removeListener() {
        Log.v("MicroMsg.LBSManager", "removed gps update on destroy");
        removeGpsUpdate();
        if (this.ak != null) {
            c();
        }
        this.ac = null;
        this.R = null;
        this.ak = null;
        this.ad = null;
    }

    public void requestGpsUpdate() {
        if (isGpsEnable() || isNetworkPrividerEnable()) {
            Log.v("MicroMsg.LBSManager", "requested gps update");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(FILTER_GPS);
            this.R.registerReceiver(this, intentFilter);
            if (isGpsEnable()) {
                this.ad.requestLocationUpdates("gps", 500L, 0.0f, this.ae);
            }
            if (isNetworkPrividerEnable()) {
                this.ad.requestLocationUpdates("network", 500L, 0.0f, this.ae);
            }
        }
    }

    public void start() {
        String nullAsNil = Util.nullAsNil(getWIFILocation());
        String nullAsNil2 = Util.nullAsNil(getTelLocation());
        if ((isGpsEnable() || isNetworkPrividerEnable()) && !this.af) {
            this.af = true;
            this.aj = 0;
            requestGpsUpdate();
            this.ak.startTimer(3000L);
            return;
        }
        if (ab == null ? false : System.currentTimeMillis() - ab.time <= 180000 && ab.ao > 0) {
            if (this.ac != null) {
                this.ag = true;
                Log.v("MicroMsg.LBSManager", "location by GPS cache ok:[" + ab.am + " , " + ab.an + "]  accuracy:" + ab.ao + " source:" + ab.I);
                this.ac.onLocationGot(ab.am, ab.an, ab.ao, ab.I, nullAsNil, nullAsNil2, true);
                return;
            }
            return;
        }
        this.ag = true;
        if (nullAsNil.equals("") && nullAsNil2.equals("")) {
            Log.v("MicroMsg.LBSManager", "get location by network failed");
            if (this.ac != null) {
                this.ac.onLocationGot(-1000.0f, -1000.0f, INVALID_ACC, 0, "", "", false);
                return;
            }
            return;
        }
        Log.v("MicroMsg.LBSManager", "get location by network ok, macs : " + nullAsNil + " cell ids :" + nullAsNil2);
        if (this.ac != null) {
            this.ac.onLocationGot(-1000.0f, -1000.0f, INVALID_ACC, 0, nullAsNil, nullAsNil2, true);
        }
    }
}
