package com.yy.gslbsdk.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.yy.gslbsdk.DnsResultInfo;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.device.NetStatusInfo;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ExternalCache {
    public static final int SCENE_ASYNC_CACHE_OVERTIME = 8;
    public static final int SCENE_ASYNC_NO_RESULT = 4;
    public static final int SCENE_FIRST_INSTALL_START = 1;
    public static final int SCENE_SYNC_NO_RESULT = 2;
    public static final String TAG = "ExternalCache";
    public static ExternalCache sInstance;
    public boolean mFirstStart;
    public Map<String, Map<String, List<String>>> mDataAsset = null;
    public Map<String, Map<String, List<String>>> mDataExternal = null;
    public boolean mEnable = false;
    public NetType mNetType = NetType.GSLB_INNER;
    public int mScene = -1;

    public ExternalCache() {
        this.mFirstStart = true;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(GlobalTools.APP_CONTEXT);
        boolean z = defaultSharedPreferences.getBoolean("gslb_first_install", true);
        this.mFirstStart = z;
        if (z) {
            defaultSharedPreferences.edit().putBoolean("gslb_first_install", false).apply();
        }
    }

    public static final ExternalCache getInstance() {
        if (sInstance == null) {
            sInstance = new ExternalCache();
        }
        return sInstance;
    }

    private NetType getNetType() {
        NetStatusInfo cachedNetStatusInfo;
        NetType netType = this.mNetType;
        NetType netType2 = NetType.WIFI;
        if (netType == netType2) {
            return netType2;
        }
        if (netType == NetType.GSLB_INNER && (cachedNetStatusInfo = DataCacheMgr.INSTANCE.getCachedNetStatusInfo()) != null) {
            return transNum2NetType(cachedNetStatusInfo.getIsp());
        }
        return this.mNetType;
    }

    private boolean isWifi() {
        NetStatusInfo cachedNetStatusInfo;
        NetType netType = this.mNetType;
        if (netType == NetType.WIFI) {
            return true;
        }
        if (netType == NetType.GSLB_INNER && (cachedNetStatusInfo = DataCacheMgr.INSTANCE.getCachedNetStatusInfo()) != null && cachedNetStatusInfo.getNetType() == 2) {
            return true;
        }
        return false;
    }

    public boolean isFirstStart() {
        return this.mFirstStart;
    }

    /* loaded from: classes8.dex */
    public enum NetType {
        WIFI("WIFI", 100),
        MOBILE_CTL("CTL", 1),
        MOBILE_CNC("CNC", 2),
        MOBILE_CMC("CMC", 3),
        GSLB_INNER("gslb", 0);
        
        public String name;
        public int value;

        NetType(String str, int i) {
            this.name = "gslb";
            this.value = 0;
            this.name = str;
            this.value = i;
        }

        public String getName() {
            return this.name;
        }

        public int getValue() {
            return this.value;
        }
    }

    private List<String> getIp(Map<String, Map<String, List<String>>> map, String str) {
        List<String> list;
        LinkedList linkedList = new LinkedList();
        Map<String, List<String>> map2 = map.get(str);
        if (map2 == null) {
            return linkedList;
        }
        if ("CN".equalsIgnoreCase(GlobalTools.APP_LOCALIZE_CODE)) {
            NetType netType = getNetType();
            if (netType == NetType.WIFI) {
                linkedList.addAll(getIpCNWifi(map2));
            } else {
                linkedList.addAll(getIpCNMobile(map2, netType));
            }
        }
        if (!TextUtils.isEmpty(GlobalTools.APP_LOCALIZE_CODE) && (list = map2.get(GlobalTools.APP_LOCALIZE_CODE.toUpperCase())) != null && !list.isEmpty()) {
            linkedList.addAll(list);
        }
        return linkedList;
    }

    public static String readAssets(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (IOException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            LogTools.printWarning(TAG, e);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return stringBuffer.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e2) {
                                    LogTools.printWarning(TAG, e2);
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (Exception e3) {
                    LogTools.printWarning(TAG, e3);
                }
            } catch (IOException e4) {
                e = e4;
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private List<String> getIpCNMobile(Map<String, List<String>> map, NetType netType) {
        LinkedList linkedList = new LinkedList();
        try {
            List<String> list = map.get(String.valueOf(netType.getValue()));
            if (list != null && !list.isEmpty()) {
                linkedList.addAll(list);
            } else {
                List<String> list2 = map.get(netType.getName());
                if (list2 != null && !list2.isEmpty()) {
                    linkedList.addAll(list2);
                }
            }
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
        }
        return linkedList;
    }

    private List<String> getIpCNWifi(Map<String, List<String>> map) {
        LinkedList linkedList = new LinkedList();
        List<String> ipCNMobile = getIpCNMobile(map, NetType.MOBILE_CTL);
        if (!ipCNMobile.isEmpty()) {
            linkedList.addAll(ipCNMobile);
        }
        List<String> ipCNMobile2 = getIpCNMobile(map, NetType.MOBILE_CNC);
        if (!ipCNMobile2.isEmpty()) {
            linkedList.addAll(ipCNMobile2);
        }
        List<String> ipCNMobile3 = getIpCNMobile(map, NetType.MOBILE_CMC);
        if (!ipCNMobile3.isEmpty()) {
            linkedList.addAll(ipCNMobile3);
        }
        return linkedList;
    }

    private boolean matchScene(int i) {
        if (this.mFirstStart) {
            i |= 1;
        }
        if ((i & this.mScene) > 0) {
            return true;
        }
        return false;
    }

    private NetType transNum2NetType(int i) {
        if (NetType.MOBILE_CTL.getValue() == i) {
            return NetType.MOBILE_CTL;
        }
        if (NetType.MOBILE_CNC.getValue() == i) {
            return NetType.MOBILE_CNC;
        }
        if (NetType.MOBILE_CMC.getValue() == i) {
            return NetType.MOBILE_CMC;
        }
        if (NetType.WIFI.getValue() == i) {
            return NetType.WIFI;
        }
        return NetType.GSLB_INNER;
    }

    public void setData(Map<String, Map<String, List<String>>> map) {
        this.mDataExternal = map;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void setNetType(NetType netType) {
        this.mNetType = netType;
    }

    public void setScene(int i) {
        this.mScene = i;
    }

    private Map<String, Map<String, List<String>>> parseJson(String str) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = jSONObject.optJSONObject(next)) != null) {
                    Iterator<String> keys2 = optJSONObject.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        if (!TextUtils.isEmpty(next2) && (optJSONArray = optJSONObject.optJSONArray(next2)) != null) {
                            ArrayList arrayList = new ArrayList(optJSONArray.length());
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                arrayList.add(optJSONArray.getString(i));
                            }
                            Map map = (Map) hashMap.get(next);
                            if (map == null) {
                                map = new HashMap();
                                hashMap.put(next, map);
                            }
                            Collections.shuffle(arrayList);
                            map.put(next2.toUpperCase(), arrayList);
                        }
                    }
                }
            }
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
        }
        return hashMap;
    }

    public Map<String, List<String>> getResult(String str, int i) {
        if (!this.mEnable) {
            return null;
        }
        if ((this.mDataExternal == null && this.mDataAsset == null) || !matchScene(i)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Map<String, Map<String, List<String>>> map = this.mDataExternal;
        if (map != null && map.containsKey(str) && !isWifi()) {
            linkedList.addAll(getIp(this.mDataExternal, str));
        }
        Map<String, Map<String, List<String>>> map2 = this.mDataAsset;
        if (map2 != null && map2.containsKey(str)) {
            linkedList.addAll(getIp(this.mDataAsset, str));
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            String str2 = (String) linkedList.get(i2);
            int tellIpVer = IpVersionController.tellIpVer(str2);
            if (tellIpVer == 4) {
                linkedList2.add(str2);
            } else if (tellIpVer == 6) {
                linkedList3.add(str2);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("all", linkedList);
        hashMap.put("4", linkedList2);
        hashMap.put("6", linkedList3);
        return hashMap;
    }

    public void getResult(String str, int i, DnsResultInfo dnsResultInfo) {
        try {
            Map<String, List<String>> result = getResult(str, i);
            if (result == null) {
                return;
            }
            dnsResultInfo.mErrorCode = 0;
            dnsResultInfo.mDataSource = 5;
            dnsResultInfo.mIps = (String[]) result.get("all").toArray(new String[0]);
            dnsResultInfo.mIpsV4 = (String[]) result.get("4").toArray(new String[0]);
            dnsResultInfo.mIpsV6 = (String[]) result.get("6").toArray(new String[0]);
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
        }
    }

    public boolean loadFromAssets(Context context, String str) {
        this.mDataAsset = parseJson(readAssets(context, str));
        return true;
    }

    public Map<String, Map<String, List<String>>> testLoadAssetsJson(String str, boolean z) {
        Map<String, Map<String, List<String>>> parseJson = parseJson(str);
        this.mDataAsset = parseJson;
        this.mFirstStart = z;
        return parseJson;
    }
}
