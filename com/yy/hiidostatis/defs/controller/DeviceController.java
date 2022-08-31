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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class DeviceController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FILTER_PROC_NAMES = "|ps|sh|/sbin/adbd|/sbin/cbd|logcat|com.sec.android.app.FlashBarService|com.android.systemui|com.android.phone|com.sec.android.provider.logsprovider|com.android.nfc|com.android.smspush|android.process.acore|android.process.media|com.android.defcontainer|com.android.email|com.android.contacts|com.sec.phone|com.sec.pcw.device|com.osp.app.signin|com.sec.android.service.cm|com.sec.android.app.controlpanel|com.android.musicfx|com.sec.android.gallery3d|com.sec.android.app.music:service|com.sec.android.favoriteappwidget|com.android.connectionhandler|com.sec.android.fotaclient|com.sec.spp.push|com.sec.android.app.launcher|com.sec.android.widgetapp.alarmclock|com.sec.android.app.clockpackage|com.sec.android.provider.badge|com.sec.android.widgetapp.favoriteswidget|com.sec.android.widgetapp.digitalclock|com.sec.android.app.videoplayer|com.sec.pcw|com.nd.assistance.ServerService|screencap|com.sec.pcw:CameraAutoUpload|com.android.browser|com.android.mms|com.android.incallui|com.android.providers.calendar|com.android.calendar:birthday|com.android.calendar|com.android.dialer|com.android.browser:turbo|com.android.browser:webeye|";
    public static final String PREF_KEY_DEVICE_REPORT_DATE = "PREF_KEY_DEVICE_REPORT_DATE";
    public transient /* synthetic */ FieldHolder $fh;
    public int mSysvol;
    public IStatisAPI statisAPI;

    public DeviceController(IStatisAPI iStatisAPI, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iStatisAPI, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSysvol = -1;
        this.statisAPI = iStatisAPI;
        this.mSysvol = ArdUtil.getVolume(context, 1);
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
        }
        return (String) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f8 A[Catch: all -> 0x0182, TryCatch #0 {all -> 0x0182, blocks: (B:5:0x0006, B:7:0x0011, B:8:0x002c, B:12:0x004c, B:19:0x006c, B:32:0x0097, B:36:0x00a1, B:40:0x00d4, B:42:0x00f8, B:44:0x00fc, B:45:0x0111, B:49:0x0170), top: B:57:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doReport(Context context, long j) {
        boolean z;
        boolean z2;
        int i;
        String[] wifiInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65539, this, context, j) == null) {
            try {
                StatisContent statisContent = new StatisContent();
                WifiInfo wifiInfo2 = ArdUtil.getWifiInfo(context);
                if (wifiInfo2 != null) {
                    statisContent.put("bssid", wifiInfo2.getBSSID());
                    statisContent.put("ssid", wifiInfo2.getSSID());
                    statisContent.put("rssi", wifiInfo2.getRssi());
                }
                statisContent.put("sysuptm", SystemClock.elapsedRealtime() / 1000);
                statisContent.put("srbr", ArdUtil.getScreenBrightness(context));
                statisContent.put("debug", ArdUtil.isDebugEnable(context) ? 1 : 0);
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                int intExtra = registerReceiver.getIntExtra("status", -1);
                if (intExtra != 2 && intExtra != 5) {
                    z = false;
                    float intExtra2 = (registerReceiver.getIntExtra(PollingModel.LEVEL, -1) * 100) / registerReceiver.getIntExtra("scale", -1);
                    int intExtra3 = registerReceiver.getIntExtra("plugged", -1);
                    z2 = intExtra3 != 2;
                    boolean z3 = intExtra3 != 1;
                    if (!z2 && !z3) {
                        i = 0;
                        statisContent.put("plug", i);
                        statisContent.put("charging", !z ? 1 : 0);
                        statisContent.put(SensorController.KEY_BATLV, String.format("%.2f", Float.valueOf(intExtra2)));
                        statisContent.put("cpunuma", ArdUtil.getAvailableProcessors());
                        statisContent.put("cpuarc", ArdUtil.getCpuAbi());
                        statisContent.put("headph", !ArdUtil.isHeadphone(context) ? 1 : 0);
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
                        statisContent.put("emu", !FindEmulator.isEmulator(context) ? 1 : 0);
                        statisContent.put("emurs", FindEmulator.checkEmu(context));
                        this.statisAPI.reportDevice(j, statisContent);
                    }
                    i = 1;
                    statisContent.put("plug", i);
                    statisContent.put("charging", !z ? 1 : 0);
                    statisContent.put(SensorController.KEY_BATLV, String.format("%.2f", Float.valueOf(intExtra2)));
                    statisContent.put("cpunuma", ArdUtil.getAvailableProcessors());
                    statisContent.put("cpuarc", ArdUtil.getCpuAbi());
                    statisContent.put("headph", !ArdUtil.isHeadphone(context) ? 1 : 0);
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
                    statisContent.put("emu", !FindEmulator.isEmulator(context) ? 1 : 0);
                    statisContent.put("emurs", FindEmulator.checkEmu(context));
                    this.statisAPI.reportDevice(j, statisContent);
                }
                z = true;
                float intExtra22 = (registerReceiver.getIntExtra(PollingModel.LEVEL, -1) * 100) / registerReceiver.getIntExtra("scale", -1);
                int intExtra32 = registerReceiver.getIntExtra("plugged", -1);
                if (intExtra32 != 2) {
                }
                if (intExtra32 != 1) {
                }
                if (!z2) {
                    i = 0;
                    statisContent.put("plug", i);
                    statisContent.put("charging", !z ? 1 : 0);
                    statisContent.put(SensorController.KEY_BATLV, String.format("%.2f", Float.valueOf(intExtra22)));
                    statisContent.put("cpunuma", ArdUtil.getAvailableProcessors());
                    statisContent.put("cpuarc", ArdUtil.getCpuAbi());
                    statisContent.put("headph", !ArdUtil.isHeadphone(context) ? 1 : 0);
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
                    statisContent.put("emu", !FindEmulator.isEmulator(context) ? 1 : 0);
                    statisContent.put("emurs", FindEmulator.checkEmu(context));
                    this.statisAPI.reportDevice(j, statisContent);
                }
                i = 1;
                statisContent.put("plug", i);
                statisContent.put("charging", !z ? 1 : 0);
                statisContent.put(SensorController.KEY_BATLV, String.format("%.2f", Float.valueOf(intExtra22)));
                statisContent.put("cpunuma", ArdUtil.getAvailableProcessors());
                statisContent.put("cpuarc", ArdUtil.getCpuAbi());
                statisContent.put("headph", !ArdUtil.isHeadphone(context) ? 1 : 0);
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
                statisContent.put("emu", !FindEmulator.isEmulator(context) ? 1 : 0);
                statisContent.put("emurs", FindEmulator.checkEmu(context));
                this.statisAPI.reportDevice(j, statisContent);
            } catch (Throwable th) {
                L.warn(this, "reportDeviceOnLaunch exception =%s", th);
            }
        }
    }

    public static String getRunningProcess(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
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
            return stringBuffer.length() > 0 ? stringBuffer.toString().substring(0, stringBuffer.length() - 1) : stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String[] getWifiInfo(Context context) {
        InterceptResult invokeL;
        WifiInfo connectionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            String[] strArr = new String[3];
            try {
                if (ArdUtil.checkPermissions(context, h.d)) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager.isWifiEnabled() && wifiManager.getWifiState() == 3 && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                        int ipAddress = connectionInfo.getIpAddress();
                        connectionInfo.getMacAddress();
                        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                        strArr[0] = a(ipAddress);
                        strArr[1] = connectionInfo.getMacAddress();
                        strArr[2] = a(dhcpInfo.netmask);
                    }
                }
            } catch (Throwable th) {
                L.debug("DeviceController", "getWifiInfo exception = %s", th);
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    public static boolean isFilterName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str.startsWith("/system/")) {
                return true;
            }
            return FILTER_PROC_NAMES.contains("|" + str + "|");
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reportDevice(Context context, long j) {
        String str;
        Object th;
        boolean z;
        String prefString;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLJ(1048576, this, context, j) != null) {
            return;
        }
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
                if (z) {
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
                if (z) {
                    return;
                }
                this.statisAPI.reportDevice(j, null, new IStatisAPI.ReportResult(this, context, str) { // from class: com.yy.hiidostatis.defs.controller.DeviceController.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DeviceController this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$finalNowDate;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$finalNowDate = str;
                    }

                    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI.ReportResult
                    public void onReportResult(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) && z2) {
                            DefaultPreference.getPreference().setPrefString(this.val$context, DeviceController.PREF_KEY_DEVICE_REPORT_DATE, this.val$finalNowDate);
                        }
                    }
                });
                return;
            }
        }
        z = false;
        L.brief("reportDevice:isReport:%b", Boolean.valueOf(z));
        if (z) {
        }
    }

    public void reportDeviceOnLaunch(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, j) == null) {
            if (context == null) {
                L.debug("DeviceController", "Null context when reporting to hiido, cancelled.", new Object[0]);
            } else {
                ThreadPool.getPool().execute(new Runnable(this, context, j) { // from class: com.yy.hiidostatis.defs.controller.DeviceController.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DeviceController this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ long val$uid;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, Long.valueOf(j)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$uid = j;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.doReport(this.val$context, this.val$uid);
                        }
                    }
                }, 14000L);
            }
        }
    }
}
