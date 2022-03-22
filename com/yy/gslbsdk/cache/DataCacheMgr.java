package com.yy.gslbsdk.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DBAccessMgr;
import com.yy.gslbsdk.db.DelayTB;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.gslbsdk.db.ResultTB;
import com.yy.gslbsdk.device.DeviceMgr;
import com.yy.gslbsdk.device.NetStatusInfo;
import com.yy.gslbsdk.protocol.DnsInfo;
import com.yy.gslbsdk.protocol.ResInfo;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class DataCacheMgr {
    public static final /* synthetic */ DataCacheMgr[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final DataCacheMgr INSTANCE;
    public static final String TAG = "DataCacheMgr";
    public transient /* synthetic */ FieldHolder $fh;
    public String mCacheIdentity;
    public NetStatusInfo mCacheNetStatusInfo;
    public int mCountFailedDns;
    public int mCountLocalDns;
    public HashMap<String, ArrayList<DelayTB>> mDelayCacheLower;
    public HashMap<String, ArrayList<DelayTB>> mDelayCacheUpper;
    public HashMap<String, Integer> mHitCacheNum;
    public ConcurrentHashMap<String, ResultTB> mHttpDNSCache;
    public HashMap<String, Integer> mInvokeApiNum;
    public List<Long> mListDnsCost;
    public ConcurrentHashMap<String, DnsInfo> mLocalDNSCache;
    public ArrayList<ProbeTB> mProbeCache;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-771872382, "Lcom/yy/gslbsdk/cache/DataCacheMgr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-771872382, "Lcom/yy/gslbsdk/cache/DataCacheMgr;");
                return;
            }
        }
        DataCacheMgr dataCacheMgr = new DataCacheMgr("INSTANCE", 0);
        INSTANCE = dataCacheMgr;
        $VALUES = new DataCacheMgr[]{dataCacheMgr};
    }

    public DataCacheMgr(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLocalDNSCache = new ConcurrentHashMap<>();
        this.mHttpDNSCache = new ConcurrentHashMap<>();
        this.mProbeCache = new ArrayList<>();
        this.mDelayCacheUpper = new HashMap<>();
        this.mDelayCacheLower = new HashMap<>();
        this.mInvokeApiNum = new HashMap<>();
        this.mHitCacheNum = new HashMap<>();
        this.mCacheNetStatusInfo = null;
        this.mCacheIdentity = null;
        this.mCountFailedDns = 0;
        this.mCountLocalDns = 0;
        this.mListDnsCost = new LinkedList();
    }

    public static DataCacheMgr valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DataCacheMgr) Enum.valueOf(DataCacheMgr.class, str) : (DataCacheMgr) invokeL.objValue;
    }

    public static DataCacheMgr[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DataCacheMgr[]) $VALUES.clone() : (DataCacheMgr[]) invokeV.objValue;
    }

    public void addDelay(DelayTB delayTB) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, delayTB) == null) || delayTB == null) {
            return;
        }
        if (delayTB.getDelay() >= 500) {
            synchronized (this.mDelayCacheUpper) {
                ArrayList<DelayTB> arrayList = this.mDelayCacheUpper.get(delayTB.getHost());
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.mDelayCacheUpper.put(delayTB.getHost(), arrayList);
                }
                arrayList.add(delayTB);
            }
            return;
        }
        synchronized (this.mDelayCacheLower) {
            ArrayList<DelayTB> arrayList2 = this.mDelayCacheLower.get(delayTB.getHost());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                this.mDelayCacheLower.put(delayTB.getHost(), arrayList2);
            }
            arrayList2.add(delayTB);
        }
    }

    public void addDnsCost(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            if (this.mListDnsCost == null) {
                this.mListDnsCost = new LinkedList();
            }
            synchronized (this.mListDnsCost) {
                this.mListDnsCost.add(Long.valueOf(j));
            }
        }
    }

    public void addFailedDnsCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mCountFailedDns++;
        }
    }

    public synchronized void addHitCacheNum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this) {
                this.mHitCacheNum.put(str, Integer.valueOf((this.mHitCacheNum.containsKey(str) ? this.mHitCacheNum.get(str).intValue() : 0) + 1));
            }
        }
    }

    public synchronized void addInvokeApiNum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            synchronized (this) {
                this.mInvokeApiNum.put(str, Integer.valueOf((this.mInvokeApiNum.containsKey(str) ? this.mInvokeApiNum.get(str).intValue() : 0) + 1));
            }
        }
    }

    public void addLocalDnsCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mCountLocalDns++;
        }
    }

    public void addProbe(ProbeTB probeTB) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, probeTB) == null) || probeTB == null) {
            return;
        }
        synchronized (this.mProbeCache) {
            if (!this.mProbeCache.contains(probeTB)) {
                this.mProbeCache.add(probeTB);
            }
        }
    }

    public synchronized void clearAllHitCacheNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.mHitCacheNum.clear();
            }
        }
    }

    public synchronized void clearAllInvokeApiNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                this.mInvokeApiNum.clear();
            }
        }
    }

    public synchronized void clearHitCacheNum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            synchronized (this) {
                this.mHitCacheNum.remove(str);
            }
        }
    }

    public synchronized void clearInvokeApiNum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            synchronized (this) {
                this.mInvokeApiNum.remove(str);
            }
        }
    }

    public void deleteAllDelay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this.mDelayCacheLower) {
                this.mDelayCacheLower.clear();
            }
            synchronized (this.mDelayCacheUpper) {
                this.mDelayCacheUpper.clear();
            }
        }
    }

    public void deleteDelayByHostFromLower(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || str == null) {
            return;
        }
        synchronized (this.mDelayCacheLower) {
            this.mDelayCacheLower.remove(str);
        }
    }

    public void deleteDelayByHostFromUpper(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || str == null) {
            return;
        }
        synchronized (this.mDelayCacheUpper) {
            this.mDelayCacheUpper.remove(str);
        }
    }

    public void deleteHttpDNSFromMemCache(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            try {
                this.mHttpDNSCache.remove(str);
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
            }
        }
    }

    public ArrayList<ProbeTB> getALlProbe() {
        InterceptResult invokeV;
        ArrayList<ProbeTB> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            synchronized (this.mProbeCache) {
                arrayList = (ArrayList) this.mProbeCache.clone();
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<DelayTB> getAllDelayLower() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ArrayList<DelayTB> arrayList = new ArrayList<>();
            synchronized (this.mDelayCacheLower) {
                for (Map.Entry<String, ArrayList<DelayTB>> entry : this.mDelayCacheLower.entrySet()) {
                    arrayList.addAll(entry.getValue());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<DelayTB> getAllDelayUpper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ArrayList<DelayTB> arrayList = new ArrayList<>();
            synchronized (this.mDelayCacheUpper) {
                for (Map.Entry<String, ArrayList<DelayTB>> entry : this.mDelayCacheUpper.entrySet()) {
                    arrayList.addAll(entry.getValue());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ConcurrentHashMap<String, DnsInfo> getAllLocalDNSFromCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mLocalDNSCache : (ConcurrentHashMap) invokeV.objValue;
    }

    public NetStatusInfo getCachedNetStatusInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.mCacheNetStatusInfo == null) {
                NetStatusInfo networkInfo = DeviceMgr.getNetworkInfo(GlobalTools.APP_CONTEXT);
                synchronized (this) {
                    this.mCacheNetStatusInfo = networkInfo;
                }
            }
            return this.mCacheNetStatusInfo;
        }
        return (NetStatusInfo) invokeV.objValue;
    }

    public int getFailedDnsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mCountFailedDns : invokeV.intValue;
    }

    public synchronized int getHitCacheNum(String str) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            synchronized (this) {
                intValue = this.mHitCacheNum.containsKey(str) ? this.mHitCacheNum.get(str).intValue() : 0;
            }
            return intValue;
        }
        return invokeL.intValue;
    }

    public int getHttpDNSFromCache(Context context, String str, String str2, DnsInfo dnsInfo) {
        InterceptResult invokeLLLL;
        List<ResultTB> resultByNetworkHost;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048598, this, context, str, str2, dnsInfo)) == null) {
            if (dnsInfo != null) {
                ResultTB httpDNSFromMemCache = getHttpDNSFromMemCache(str, str2);
                if (httpDNSFromMemCache == null && (resultByNetworkHost = DBAccessMgr.getInstance(context).getResultByNetworkHost(str, str2)) != null && !resultByNetworkHost.isEmpty()) {
                    httpDNSFromMemCache = resultByNetworkHost.get(0);
                }
                if (httpDNSFromMemCache != null) {
                    dnsInfo.setHost(httpDNSFromMemCache.getHost());
                    dnsInfo.setTtl(httpDNSFromMemCache.getTtl());
                    dnsInfo.setIPStr(httpDNSFromMemCache.getIp());
                    dnsInfo.setCmdStr(httpDNSFromMemCache.getCmd());
                    dnsInfo.setView(httpDNSFromMemCache.getView());
                    dnsInfo.setUip(httpDNSFromMemCache.getUip());
                    dnsInfo.setSource(httpDNSFromMemCache.getSource());
                    dnsInfo.setEndTime(httpDNSFromMemCache.getEndTime());
                    dnsInfo.setProbeTime(httpDNSFromMemCache.getUpdateTime() + ((int) (httpDNSFromMemCache.getTtl() * GlobalTools.TTL_PROBE_FACTOR * 1000.0f)));
                    return 0;
                }
                return 2;
            }
            return 5;
        }
        return invokeLLLL.intValue;
    }

    public ResultTB getHttpDNSFromMemCache(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, str2)) == null) {
            try {
                ResultTB resultTB = this.mHttpDNSCache.get(str2);
                if (resultTB != null) {
                    if (str.equals(resultTB.getNetwork())) {
                        return resultTB;
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return null;
            }
        }
        return (ResultTB) invokeLL.objValue;
    }

    public synchronized String getIdentity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, context)) == null) {
            synchronized (this) {
                if (this.mCacheIdentity != null) {
                    return this.mCacheIdentity;
                }
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                String string = defaultSharedPreferences.getString("gslb_identity", "");
                this.mCacheIdentity = string;
                if (string.length() == 0) {
                    this.mCacheIdentity = UUID.randomUUID().toString();
                    defaultSharedPreferences.edit().putString("gslb_identity", this.mCacheIdentity).commit();
                }
                return this.mCacheIdentity;
            }
        }
        return (String) invokeL.objValue;
    }

    public synchronized int getInvokeApiNum(String str) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            synchronized (this) {
                intValue = this.mInvokeApiNum.containsKey(str) ? this.mInvokeApiNum.get(str).intValue() : 0;
            }
            return intValue;
        }
        return invokeL.intValue;
    }

    public List<Long> getListDnsCost() {
        InterceptResult invokeV;
        List<Long> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.mListDnsCost == null) {
                this.mListDnsCost = new LinkedList();
            }
            synchronized (this.mListDnsCost) {
                list = (List) ((LinkedList) this.mListDnsCost).clone();
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public int getLocalDNSFromCache(String str, DnsInfo dnsInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, dnsInfo)) == null) {
            if (dnsInfo != null) {
                if (this.mLocalDNSCache.containsKey(str)) {
                    DnsInfo dnsInfo2 = this.mLocalDNSCache.get(str);
                    if (dnsInfo2.getEndTime() > System.currentTimeMillis()) {
                        dnsInfo.cloneDnsInfo(dnsInfo2);
                        return 0;
                    }
                }
                return 2;
            }
            return 5;
        }
        return invokeLL.intValue;
    }

    public int getLocalDnsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mCountLocalDns : invokeV.intValue;
    }

    public String getReportDate(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, context)) == null) ? context.getSharedPreferences("reportConfig", 0).getString("last_hijack", new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis() - GlobalTools.ONE_DAY_MILSEC))) : (String) invokeL.objValue;
    }

    public int putHttpDNSIntoCache(Context context, ResInfo resInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, context, resInfo)) == null) {
            if (resInfo.getNetInfo() != null) {
                DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(context);
                String netStatusID = resInfo.getNetInfo().getNetStatusID();
                if (resInfo.getDns() != null) {
                    for (DnsInfo dnsInfo : resInfo.getDns().values()) {
                        ResultTB resultTB = new ResultTB();
                        resultTB.setNetwork(netStatusID);
                        resultTB.setHost(dnsInfo.getHost());
                        resultTB.setTtl(dnsInfo.getTtl());
                        resultTB.setEndTime(dnsInfo.getEndTime());
                        resultTB.setCmd(dnsInfo.getCmdStr());
                        resultTB.setUpdateTime(System.currentTimeMillis());
                        resultTB.setView(dnsInfo.getView());
                        resultTB.setUip(dnsInfo.getUip());
                        resultTB.setSource(dnsInfo.getSource());
                        String iPStr = dnsInfo.getIPStr();
                        if (!TextUtils.isEmpty(iPStr)) {
                            resultTB.setIp(iPStr);
                            dBAccessMgr.addOrUpdate(resultTB, true);
                        }
                        putHttpDNSIntoMemCache(resultTB);
                    }
                    return 0;
                }
            }
            return 5;
        }
        return invokeLL.intValue;
    }

    public int putHttpDNSIntoMemCache(ResultTB resultTB) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, resultTB)) == null) {
            if (resultTB != null) {
                try {
                    this.mHttpDNSCache.put(resultTB.getHost(), resultTB);
                    return 0;
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void putLocalDNSIntoCache(DnsInfo dnsInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, dnsInfo) == null) || dnsInfo == null) {
            return;
        }
        this.mLocalDNSCache.put(dnsInfo.getHost(), dnsInfo);
    }

    public void resetFailedDnsCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.mCountFailedDns = 0;
        }
    }

    public void resetListDnsCost() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            List<Long> list = this.mListDnsCost;
            if (list == null) {
                this.mListDnsCost = new LinkedList();
                return;
            }
            synchronized (list) {
                this.mListDnsCost.clear();
            }
        }
    }

    public void resetLocalDnsCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.mCountLocalDns = 0;
        }
    }

    public void setCachedNetStateInfo(NetStatusInfo netStatusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, netStatusInfo) == null) {
            synchronized (this) {
                this.mCacheNetStatusInfo = netStatusInfo;
            }
        }
    }

    public void setReportDate(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, context, str) == null) {
            context.getSharedPreferences("reportConfig", 0).edit().putString("last_hijack", str).commit();
        }
    }
}
