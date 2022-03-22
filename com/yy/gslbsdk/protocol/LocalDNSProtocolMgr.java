package com.yy.gslbsdk.protocol;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.util.LogTools;
import java.net.InetAddress;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class LocalDNSProtocolMgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LocalDNSProtocolMgr";
    public transient /* synthetic */ FieldHolder $fh;

    public LocalDNSProtocolMgr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static DnsInfo requestProtocol(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            LinkedList<String> linkedList = new LinkedList<>();
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length > 0) {
                    for (InetAddress inetAddress : allByName) {
                        byte[] address = inetAddress.getAddress();
                        if (address != null && address.length == 4) {
                            linkedList.add(inetAddress.getHostAddress());
                        }
                    }
                }
            } catch (Exception e2) {
                LogTools.printError(TAG, "LocalDNSProtocolMgr.requestProtocol() exception:" + e2.getMessage());
            }
            if (linkedList.isEmpty()) {
                return null;
            }
            DnsInfo dnsInfo = new DnsInfo();
            dnsInfo.setHost(str);
            dnsInfo.setIps(linkedList);
            dnsInfo.setTtl(0);
            return dnsInfo;
        }
        return (DnsInfo) invokeL.objValue;
    }
}
