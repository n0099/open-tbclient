package com.thunder.livesdk.video;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import com.baidu.webkit.internal.ETAG;
import com.thunder.livesdk.log.ThunderLog;
import com.thunder.livesdk.video.serviceConfig.VideoConfigManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ThunderVideoHiidoUtil {
    private static final String TAG = "ThunderVideoHiidoUtil";
    private static ContentResolver contentResolver;
    private BatteryMonitor batteryMonitor;
    private IntentFilter filter;
    private Context mContext;
    private static int current = 0;
    private static LinkedHashMap<String, Object> mAudienceHashMap = new LinkedHashMap<>();
    private static LinkedHashMap<String, Object> mAnchorHashMap = new LinkedHashMap<>();
    private boolean mBatteryReceiverRegistered = false;
    private Object syncLock = new Object();

    /* loaded from: classes6.dex */
    private interface AnchorHiidoStatInfoKey {
        public static final String APP_CPU_RATE = "s7";
        public static final String BatteryState = "dr39";
        public static final String ScreenBrightness = "dr40";
    }

    /* loaded from: classes6.dex */
    private interface AudienceHiidoStatInfoKey {
        public static final String APP_CPU_RATE = "s7";
        public static final String BatteryState = "dr39";
        public static final String ScreenBrightness = "dr40";
    }

    public ThunderVideoHiidoUtil(Context context) {
        this.mContext = context;
        contentResolver = this.mContext.getContentResolver();
    }

    public void register() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        this.batteryMonitor = new BatteryMonitor();
        if (this.mContext != null) {
            synchronized (this.syncLock) {
                this.mContext.registerReceiver(this.batteryMonitor, intentFilter);
                this.mBatteryReceiverRegistered = true;
            }
        }
    }

    public void unRegister() {
        if (this.mContext != null) {
            synchronized (this.syncLock) {
                if (this.mBatteryReceiverRegistered) {
                    this.mContext.unregisterReceiver(this.batteryMonitor);
                    this.mBatteryReceiverRegistered = false;
                }
            }
        }
        this.batteryMonitor = null;
        contentResolver = null;
        this.filter = null;
    }

    public static String getAnchorStatInfo() {
        int appCpuSupportMode = VideoConfigManager.getAppCpuSupportMode();
        if (appCpuSupportMode > 0) {
            int hiidoAppCpuRate = CpuTool.getHiidoAppCpuRate();
            if (hiidoAppCpuRate == -1) {
                hiidoAppCpuRate = CpuTool.getAppCpuRate(appCpuSupportMode);
            }
            LinkedHashMap<String, Object> linkedHashMap = mAnchorHashMap;
            if (hiidoAppCpuRate == 0) {
                hiidoAppCpuRate = -1;
            }
            linkedHashMap.put("s7", Integer.valueOf(hiidoAppCpuRate));
        }
        return getParamsOrderByKey(mAnchorHashMap);
    }

    public static String getAudienceStatInfo() {
        int appCpuSupportMode = VideoConfigManager.getAppCpuSupportMode();
        if (appCpuSupportMode > 0) {
            int hiidoAppCpuRate = CpuTool.getHiidoAppCpuRate();
            if (CpuTool.getHiidoAppCpuRate() == -1) {
                hiidoAppCpuRate = CpuTool.getAppCpuRate(appCpuSupportMode);
            }
            LinkedHashMap<String, Object> linkedHashMap = mAudienceHashMap;
            if (hiidoAppCpuRate == 0) {
                hiidoAppCpuRate = -1;
            }
            linkedHashMap.put("s7", Integer.valueOf(hiidoAppCpuRate));
        }
        return getParamsOrderByKey(mAudienceHashMap);
    }

    private static String getParamsOrderByKey(Map<String, Object> map) {
        String str;
        String str2 = "";
        if (map == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (true) {
            String str3 = str2;
            if (it.hasNext()) {
                str2 = str3 + ETAG.ITEM_SEPARATOR + ((String) it.next()) + "=" + map.get(str);
            } else {
                return str3;
            }
        }
    }

    private static int getCurrentBatteryState() {
        if (current < 0) {
            return 0;
        }
        return current;
    }

    private static int getSystemBrightness() {
        try {
            if (contentResolver == null) {
                return 0;
            }
            return Settings.System.getInt(contentResolver, "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            ThunderLog.release(TAG, "get SCREEN_BRIGHTNESS:" + e.getMessage());
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    private class BatteryMonitor extends BroadcastReceiver {
        private BatteryMonitor() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int unused = ThunderVideoHiidoUtil.current = intent.getExtras().getInt("level");
        }
    }
}
