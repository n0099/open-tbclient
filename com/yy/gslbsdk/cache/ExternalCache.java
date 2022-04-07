package com.yy.gslbsdk.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SCENE_ASYNC_CACHE_OVERTIME = 8;
    public static final int SCENE_ASYNC_NO_RESULT = 4;
    public static final int SCENE_FIRST_INSTALL_START = 1;
    public static final int SCENE_SYNC_NO_RESULT = 2;
    public static final String TAG = "ExternalCache";
    public static ExternalCache sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Map<String, List<String>>> mDataAsset;
    public Map<String, Map<String, List<String>>> mDataExternal;
    public boolean mEnable;
    public boolean mFirstStart;
    public NetType mNetType;
    public int mScene;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class NetType {
        public static final /* synthetic */ NetType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetType GSLB_INNER;
        public static final NetType MOBILE_CMC;
        public static final NetType MOBILE_CNC;
        public static final NetType MOBILE_CTL;
        public static final NetType WIFI;
        public transient /* synthetic */ FieldHolder $fh;
        public String name;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-3841558, "Lcom/yy/gslbsdk/cache/ExternalCache$NetType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-3841558, "Lcom/yy/gslbsdk/cache/ExternalCache$NetType;");
                    return;
                }
            }
            WIFI = new NetType(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 0, CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 100);
            MOBILE_CTL = new NetType("MOBILE_CTL", 1, "CTL", 1);
            MOBILE_CNC = new NetType("MOBILE_CNC", 2, "CNC", 2);
            MOBILE_CMC = new NetType("MOBILE_CMC", 3, "CMC", 3);
            NetType netType = new NetType("GSLB_INNER", 4, "gslb", 0);
            GSLB_INNER = netType;
            $VALUES = new NetType[]{WIFI, MOBILE_CTL, MOBILE_CNC, MOBILE_CMC, netType};
        }

        public NetType(String str, int i, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.name = "gslb";
            this.value = 0;
            this.name = str2;
            this.value = i2;
        }

        public static NetType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetType) Enum.valueOf(NetType.class, str) : (NetType) invokeL.objValue;
        }

        public static NetType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetType[]) $VALUES.clone() : (NetType[]) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.name : (String) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1021070141, "Lcom/yy/gslbsdk/cache/ExternalCache;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1021070141, "Lcom/yy/gslbsdk/cache/ExternalCache;");
        }
    }

    public ExternalCache() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDataAsset = null;
        this.mDataExternal = null;
        this.mEnable = false;
        this.mNetType = NetType.GSLB_INNER;
        this.mScene = -1;
        this.mFirstStart = true;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(GlobalTools.APP_CONTEXT);
        boolean z = defaultSharedPreferences.getBoolean("gslb_first_install", true);
        this.mFirstStart = z;
        if (z) {
            defaultSharedPreferences.edit().putBoolean("gslb_first_install", false).apply();
        }
    }

    public static final ExternalCache getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                sInstance = new ExternalCache();
            }
            return sInstance;
        }
        return (ExternalCache) invokeV.objValue;
    }

    private List<String> getIp(Map<String, Map<String, List<String>>> map, String str) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, map, str)) == null) {
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
        return (List) invokeLL.objValue;
    }

    private List<String> getIpCNMobile(Map<String, List<String>> map, NetType netType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, map, netType)) == null) {
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
        return (List) invokeLL.objValue;
    }

    private List<String> getIpCNWifi(Map<String, List<String>> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, map)) == null) {
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
        return (List) invokeL.objValue;
    }

    private NetType getNetType() {
        InterceptResult invokeV;
        NetStatusInfo cachedNetStatusInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
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
        return (NetType) invokeV.objValue;
    }

    private boolean isWifi() {
        InterceptResult invokeV;
        NetStatusInfo cachedNetStatusInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            NetType netType = this.mNetType;
            if (netType == NetType.WIFI) {
                return true;
            }
            return netType == NetType.GSLB_INNER && (cachedNetStatusInfo = DataCacheMgr.INSTANCE.getCachedNetStatusInfo()) != null && cachedNetStatusInfo.getNetType() == 2;
        }
        return invokeV.booleanValue;
    }

    private boolean matchScene(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
            if (this.mFirstStart) {
                i |= 1;
            }
            return (i & this.mScene) > 0;
        }
        return invokeI.booleanValue;
    }

    private Map<String, Map<String, List<String>>> parseJson(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
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
        return (Map) invokeL.objValue;
    }

    public static String readAssets(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65546, null, context, str)) != null) {
            return (String) invokeLL.objValue;
        }
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

    private NetType transNum2NetType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
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
        return (NetType) invokeI.objValue;
    }

    public void getResult(String str, int i, DnsResultInfo dnsResultInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, dnsResultInfo) == null) {
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
    }

    public boolean isFirstStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFirstStart : invokeV.booleanValue;
    }

    public boolean loadFromAssets(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            this.mDataAsset = parseJson(readAssets(context, str));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setData(Map<String, Map<String, List<String>>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
            this.mDataExternal = map;
        }
    }

    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mEnable = z;
        }
    }

    public void setNetType(NetType netType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, netType) == null) {
            this.mNetType = netType;
        }
    }

    public void setScene(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mScene = i;
        }
    }

    public Map<String, Map<String, List<String>>> testLoadAssetsJson(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            Map<String, Map<String, List<String>>> parseJson = parseJson(str);
            this.mDataAsset = parseJson;
            this.mFirstStart = z;
            return parseJson;
        }
        return (Map) invokeLZ.objValue;
    }

    public Map<String, List<String>> getResult(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (this.mEnable) {
                if (!(this.mDataExternal == null && this.mDataAsset == null) && matchScene(i)) {
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
                return null;
            }
            return null;
        }
        return (Map) invokeLI.objValue;
    }
}
