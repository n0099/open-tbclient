package com.yy.gslbsdk.cache;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DBAccessMgr;
import com.yy.gslbsdk.db.ResultTB;
import com.yy.gslbsdk.protocol.DnsInfo;
import com.yy.gslbsdk.protocol.ResInfo;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class DataV6CacheMgr {
    public static final /* synthetic */ DataV6CacheMgr[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final DataV6CacheMgr INSTANCE;
    public static final String TAG = "DataV6CacheMgr";
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, ResultTB> mHttpDNSCache;
    public ConcurrentHashMap<String, DnsInfo> mLocalDNSCache;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1272901726, "Lcom/yy/gslbsdk/cache/DataV6CacheMgr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1272901726, "Lcom/yy/gslbsdk/cache/DataV6CacheMgr;");
                return;
            }
        }
        DataV6CacheMgr dataV6CacheMgr = new DataV6CacheMgr("INSTANCE", 0);
        INSTANCE = dataV6CacheMgr;
        $VALUES = new DataV6CacheMgr[]{dataV6CacheMgr};
    }

    public DataV6CacheMgr(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
    }

    public static DataV6CacheMgr valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DataV6CacheMgr) Enum.valueOf(DataV6CacheMgr.class, str) : (DataV6CacheMgr) invokeL.objValue;
    }

    public static DataV6CacheMgr[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DataV6CacheMgr[]) $VALUES.clone() : (DataV6CacheMgr[]) invokeV.objValue;
    }

    public void deleteHttpDNSFromMemCache(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                this.mHttpDNSCache.remove(str);
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
            }
        }
    }

    public ConcurrentHashMap<String, DnsInfo> getAllLocalDNSFromCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLocalDNSCache : (ConcurrentHashMap) invokeV.objValue;
    }

    public int getHttpDNSFromCache(Context context, String str, String str2, DnsInfo dnsInfo) {
        InterceptResult invokeLLLL;
        List<ResultTB> resultV6ByNetworkHost;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2, dnsInfo)) == null) {
            if (dnsInfo != null) {
                ResultTB httpDNSFromMemCache = getHttpDNSFromMemCache(str, str2);
                if (httpDNSFromMemCache == null && (resultV6ByNetworkHost = DBAccessMgr.getInstance(context).getResultV6ByNetworkHost(str, str2)) != null && !resultV6ByNetworkHost.isEmpty()) {
                    httpDNSFromMemCache = resultV6ByNetworkHost.get(0);
                }
                if (httpDNSFromMemCache != null) {
                    dnsInfo.setHost(httpDNSFromMemCache.getHost());
                    dnsInfo.setTtl(httpDNSFromMemCache.getTtl());
                    dnsInfo.setIPStr(httpDNSFromMemCache.getIp());
                    dnsInfo.setCmdStr(httpDNSFromMemCache.getCmd());
                    dnsInfo.setView(httpDNSFromMemCache.getView());
                    dnsInfo.setUip(httpDNSFromMemCache.getUip());
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
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

    public int getLocalDNSFromCache(String str, DnsInfo dnsInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, dnsInfo)) == null) {
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

    public int putHttpDNSIntoCache(Context context, ResInfo resInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, resInfo)) == null) {
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
                            dBAccessMgr.addOrUpdateV6(resultTB, true);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, resultTB)) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dnsInfo) == null) || dnsInfo == null) {
            return;
        }
        this.mLocalDNSCache.put(dnsInfo.getHost(), dnsInfo);
    }
}
