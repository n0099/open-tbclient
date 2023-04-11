package com.yy.hiidostatis.defs.controller;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.kuaishou.weapon.p0.h;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.FindEmulator;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
/* loaded from: classes9.dex */
public class DeviceController {
    public static final String FILTER_PROC_NAMES = "|ps|sh|/sbin/adbd|/sbin/cbd|logcat|com.sec.android.app.FlashBarService|com.android.systemui|com.android.phone|com.sec.android.provider.logsprovider|com.android.nfc|com.android.smspush|android.process.acore|android.process.media|com.android.defcontainer|com.android.email|com.android.contacts|com.sec.phone|com.sec.pcw.device|com.osp.app.signin|com.sec.android.service.cm|com.sec.android.app.controlpanel|com.android.musicfx|com.sec.android.gallery3d|com.sec.android.app.music:service|com.sec.android.favoriteappwidget|com.android.connectionhandler|com.sec.android.fotaclient|com.sec.spp.push|com.sec.android.app.launcher|com.sec.android.widgetapp.alarmclock|com.sec.android.app.clockpackage|com.sec.android.provider.badge|com.sec.android.widgetapp.favoriteswidget|com.sec.android.widgetapp.digitalclock|com.sec.android.app.videoplayer|com.sec.pcw|com.nd.assistance.ServerService|screencap|com.sec.pcw:CameraAutoUpload|com.android.browser|com.android.mms|com.android.incallui|com.android.providers.calendar|com.android.calendar:birthday|com.android.calendar|com.android.dialer|com.android.browser:turbo|com.android.browser:webeye|";
    public static final String PREF_KEY_DEVICE_REPORT_DATE = "PREF_KEY_DEVICE_REPORT_DATE";
    public int mSysvol;
    public IStatisAPI statisAPI;

    public DeviceController(IStatisAPI iStatisAPI, Context context) {
        this.mSysvol = -1;
        this.statisAPI = iStatisAPI;
        this.mSysvol = ArdUtil.getVolume(context, 1);
    }

    public void reportDeviceOnLaunch(final Context context, final long j) {
        if (context == null) {
            L.debug("DeviceController", "Null context when reporting to hiido, cancelled.", new Object[0]);
        } else {
            ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.DeviceController.2
                @Override // java.lang.Runnable
                public void run() {
                    DeviceController.this.doReport(context, j);
                }
            }, 14000L);
        }
    }

    public static String a(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static boolean isFilterName(String str) {
        if (str.startsWith("/system/")) {
            return true;
        }
        return FILTER_PROC_NAMES.contains("|" + str + "|");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f4 A[Catch: all -> 0x017e, TryCatch #0 {all -> 0x017e, blocks: (B:3:0x0002, B:5:0x000d, B:6:0x0028, B:10:0x0048, B:17:0x0068, B:30:0x0093, B:34:0x009d, B:38:0x00d0, B:40:0x00f4, B:42:0x00f8, B:43:0x010d, B:47:0x016c), top: B:52:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doReport(Context context, long j) {
        int i;
        boolean z;
        int intExtra;
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        int i4;
        String[] wifiInfo;
        int i5;
        try {
            StatisContent statisContent = new StatisContent();
            WifiInfo wifiInfo2 = ArdUtil.getWifiInfo(context);
            if (wifiInfo2 != null) {
                statisContent.put("bssid", wifiInfo2.getBSSID());
                statisContent.put(YyLiveRoomConfig.KEY_SSID, wifiInfo2.getSSID());
                statisContent.put("rssi", wifiInfo2.getRssi());
            }
            statisContent.put("sysuptm", SystemClock.elapsedRealtime() / 1000);
            statisContent.put("srbr", ArdUtil.getScreenBrightness(context));
            if (ArdUtil.isDebugEnable(context)) {
                i = 1;
            } else {
                i = 0;
            }
            statisContent.put("debug", i);
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra2 = registerReceiver.getIntExtra("status", -1);
            if (intExtra2 != 2 && intExtra2 != 5) {
                z = false;
                float intExtra3 = (registerReceiver.getIntExtra("level", -1) * 100) / registerReceiver.getIntExtra("scale", -1);
                intExtra = registerReceiver.getIntExtra("plugged", -1);
                if (intExtra != 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (intExtra != 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z2 && !z3) {
                    i2 = 0;
                    statisContent.put("plug", i2);
                    if (!z) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    statisContent.put("charging", i3);
                    statisContent.put(SensorController.KEY_BATLV, String.format("%.2f", Float.valueOf(intExtra3)));
                    statisContent.put("cpunuma", ArdUtil.getAvailableProcessors());
                    statisContent.put("cpuarc", ArdUtil.getCpuAbi());
                    if (!ArdUtil.isHeadphone(context)) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    statisContent.put("headph", i4);
                    statisContent.put("devori", ArdUtil.getDeviceOrientation(context));
                    statisContent.put("tz", ArdUtil.getTimeZone());
                    statisContent.put("cip", ArdUtil.getCellIp());
                    wifiInfo = getWifiInfo(context);
                    if (wifiInfo != null && wifiInfo.length == 3) {
                        statisContent.put("wip", wifiInfo[0]);
                        statisContent.put("wmac", wifiInfo[1]);
                        statisContent.put("wmask", wifiInfo[2]);
                    }
                    statisContent.put("fmem", ArdUtil.getAvailMemory(context));
                    statisContent.put("tdisk", ArdUtil.getTotalInternalStorgeSize());
                    statisContent.put("fdisk", ArdUtil.getAvailInternalStorgeSize());
                    statisContent.put("sysvol", this.mSysvol);
                    statisContent.put(BaseHiidoContent.BUNDLEID, ArdUtil.getPackageName(context));
                    statisContent.put("proclist", getRunningProcess(context));
                    statisContent.put("bluemac", ArdUtil.getBluetoothMac(context));
                    statisContent.put("scene", ArdUtil.getSceneMode(context));
                    statisContent.put("manutime", Build.TIME);
                    statisContent.put("manuid", Build.ID);
                    if (!FindEmulator.isEmulator(context)) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    statisContent.put("emu", i5);
                    statisContent.put("emurs", FindEmulator.checkEmu(context));
                    this.statisAPI.reportDevice(j, statisContent);
                }
                i2 = 1;
                statisContent.put("plug", i2);
                if (!z) {
                }
                statisContent.put("charging", i3);
                statisContent.put(SensorController.KEY_BATLV, String.format("%.2f", Float.valueOf(intExtra3)));
                statisContent.put("cpunuma", ArdUtil.getAvailableProcessors());
                statisContent.put("cpuarc", ArdUtil.getCpuAbi());
                if (!ArdUtil.isHeadphone(context)) {
                }
                statisContent.put("headph", i4);
                statisContent.put("devori", ArdUtil.getDeviceOrientation(context));
                statisContent.put("tz", ArdUtil.getTimeZone());
                statisContent.put("cip", ArdUtil.getCellIp());
                wifiInfo = getWifiInfo(context);
                if (wifiInfo != null) {
                    statisContent.put("wip", wifiInfo[0]);
                    statisContent.put("wmac", wifiInfo[1]);
                    statisContent.put("wmask", wifiInfo[2]);
                }
                statisContent.put("fmem", ArdUtil.getAvailMemory(context));
                statisContent.put("tdisk", ArdUtil.getTotalInternalStorgeSize());
                statisContent.put("fdisk", ArdUtil.getAvailInternalStorgeSize());
                statisContent.put("sysvol", this.mSysvol);
                statisContent.put(BaseHiidoContent.BUNDLEID, ArdUtil.getPackageName(context));
                statisContent.put("proclist", getRunningProcess(context));
                statisContent.put("bluemac", ArdUtil.getBluetoothMac(context));
                statisContent.put("scene", ArdUtil.getSceneMode(context));
                statisContent.put("manutime", Build.TIME);
                statisContent.put("manuid", Build.ID);
                if (!FindEmulator.isEmulator(context)) {
                }
                statisContent.put("emu", i5);
                statisContent.put("emurs", FindEmulator.checkEmu(context));
                this.statisAPI.reportDevice(j, statisContent);
            }
            z = true;
            float intExtra32 = (registerReceiver.getIntExtra("level", -1) * 100) / registerReceiver.getIntExtra("scale", -1);
            intExtra = registerReceiver.getIntExtra("plugged", -1);
            if (intExtra != 2) {
            }
            if (intExtra != 1) {
            }
            if (!z2) {
                i2 = 0;
                statisContent.put("plug", i2);
                if (!z) {
                }
                statisContent.put("charging", i3);
                statisContent.put(SensorController.KEY_BATLV, String.format("%.2f", Float.valueOf(intExtra32)));
                statisContent.put("cpunuma", ArdUtil.getAvailableProcessors());
                statisContent.put("cpuarc", ArdUtil.getCpuAbi());
                if (!ArdUtil.isHeadphone(context)) {
                }
                statisContent.put("headph", i4);
                statisContent.put("devori", ArdUtil.getDeviceOrientation(context));
                statisContent.put("tz", ArdUtil.getTimeZone());
                statisContent.put("cip", ArdUtil.getCellIp());
                wifiInfo = getWifiInfo(context);
                if (wifiInfo != null) {
                }
                statisContent.put("fmem", ArdUtil.getAvailMemory(context));
                statisContent.put("tdisk", ArdUtil.getTotalInternalStorgeSize());
                statisContent.put("fdisk", ArdUtil.getAvailInternalStorgeSize());
                statisContent.put("sysvol", this.mSysvol);
                statisContent.put(BaseHiidoContent.BUNDLEID, ArdUtil.getPackageName(context));
                statisContent.put("proclist", getRunningProcess(context));
                statisContent.put("bluemac", ArdUtil.getBluetoothMac(context));
                statisContent.put("scene", ArdUtil.getSceneMode(context));
                statisContent.put("manutime", Build.TIME);
                statisContent.put("manuid", Build.ID);
                if (!FindEmulator.isEmulator(context)) {
                }
                statisContent.put("emu", i5);
                statisContent.put("emurs", FindEmulator.checkEmu(context));
                this.statisAPI.reportDevice(j, statisContent);
            }
            i2 = 1;
            statisContent.put("plug", i2);
            if (!z) {
            }
            statisContent.put("charging", i3);
            statisContent.put(SensorController.KEY_BATLV, String.format("%.2f", Float.valueOf(intExtra32)));
            statisContent.put("cpunuma", ArdUtil.getAvailableProcessors());
            statisContent.put("cpuarc", ArdUtil.getCpuAbi());
            if (!ArdUtil.isHeadphone(context)) {
            }
            statisContent.put("headph", i4);
            statisContent.put("devori", ArdUtil.getDeviceOrientation(context));
            statisContent.put("tz", ArdUtil.getTimeZone());
            statisContent.put("cip", ArdUtil.getCellIp());
            wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
            }
            statisContent.put("fmem", ArdUtil.getAvailMemory(context));
            statisContent.put("tdisk", ArdUtil.getTotalInternalStorgeSize());
            statisContent.put("fdisk", ArdUtil.getAvailInternalStorgeSize());
            statisContent.put("sysvol", this.mSysvol);
            statisContent.put(BaseHiidoContent.BUNDLEID, ArdUtil.getPackageName(context));
            statisContent.put("proclist", getRunningProcess(context));
            statisContent.put("bluemac", ArdUtil.getBluetoothMac(context));
            statisContent.put("scene", ArdUtil.getSceneMode(context));
            statisContent.put("manutime", Build.TIME);
            statisContent.put("manuid", Build.ID);
            if (!FindEmulator.isEmulator(context)) {
            }
            statisContent.put("emu", i5);
            statisContent.put("emurs", FindEmulator.checkEmu(context));
            this.statisAPI.reportDevice(j, statisContent);
        } catch (Throwable th) {
            L.warn(this, "reportDeviceOnLaunch exception =%s", th);
        }
    }

    public static String getRunningProcess(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            CacheManager cacheManager = new CacheManager(context, "PREF_KEY_CACHE_PROC_KEY", "PREF_KEY_CACHE_PROCS");
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (!isFilterName(runningAppProcessInfo.processName) && !cacheManager.isContains(runningAppProcessInfo.processName)) {
                    stringBuffer.append(runningAppProcessInfo.processName);
                    stringBuffer.append("|");
                    cacheManager.add(runningAppProcessInfo.processName);
                }
            }
            for (ActivityManager.RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(500)) {
                if (!isFilterName(runningServiceInfo.process) && !cacheManager.isContains(runningServiceInfo.process)) {
                    stringBuffer.append(runningServiceInfo.process);
                    stringBuffer.append("|");
                    cacheManager.add(runningServiceInfo.process);
                }
            }
            cacheManager.finish();
        } catch (Throwable th) {
            L.debug("DeviceController", "getRunningProcess exception = %s", th);
        }
        if (stringBuffer.length() > 0) {
            return stringBuffer.toString().substring(0, stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static String[] getWifiInfo(Context context) {
        WifiInfo connectionInfo;
        String[] strArr = new String[3];
        try {
            if (ArdUtil.checkPermissions(context, h.d)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled() && wifiManager.getWifiState() == 3 && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    int ipAddress = connectionInfo.getIpAddress();
                    ApiReplaceUtil.getMacAddress(connectionInfo);
                    DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                    strArr[0] = a(ipAddress);
                    strArr[1] = ApiReplaceUtil.getMacAddress(connectionInfo);
                    strArr[2] = a(dhcpInfo.netmask);
                }
            }
        } catch (Throwable th) {
            L.debug("DeviceController", "getWifiInfo exception = %s", th);
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reportDevice(final Context context, long j) {
        final String str;
        Object th;
        boolean z;
        String prefString;
        if (context == null) {
            L.debug("DeviceController", "Null context when reporting to hiido, cancelled.", new Object[0]);
            return;
        }
        try {
            str = Util.formatDate("yyyyMMdd", System.currentTimeMillis());
            try {
                prefString = DefaultPreference.getPreference().getPrefString(context, PREF_KEY_DEVICE_REPORT_DATE, "");
            } catch (Throwable th2) {
                th = th2;
                L.debug(this, "reportDevice exception=%s", th);
                z = false;
                L.brief("reportDevice:isReport:%b", Boolean.valueOf(z));
                if (!z) {
                }
            }
        } catch (Throwable th3) {
            str = "";
            th = th3;
        }
        if (!Util.empty(prefString)) {
            if (prefString.equals(str)) {
                z = true;
                L.brief("reportDevice:isReport:%b", Boolean.valueOf(z));
                if (!z) {
                    this.statisAPI.reportDevice(j, null, new IStatisAPI.ReportResult() { // from class: com.yy.hiidostatis.defs.controller.DeviceController.1
                        @Override // com.yy.hiidostatis.defs.interf.IStatisAPI.ReportResult
                        public void onReportResult(boolean z2) {
                            if (z2) {
                                DefaultPreference.getPreference().setPrefString(context, DeviceController.PREF_KEY_DEVICE_REPORT_DATE, str);
                            }
                        }
                    });
                    return;
                }
                return;
            }
        }
        z = false;
        L.brief("reportDevice:isReport:%b", Boolean.valueOf(z));
        if (!z) {
        }
    }
}
