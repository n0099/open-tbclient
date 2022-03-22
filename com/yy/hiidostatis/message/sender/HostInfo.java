package com.yy.hiidostatis.message.sender;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.HostManager;
import com.yy.hiidostatis.message.bean.Message;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Dns;
/* loaded from: classes7.dex */
public class HostInfo implements HostManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHANGE_DNS_MIN_ERR_COUNT = 30;
    public static final long CHANGE_DNS_MIN_INTERVAL = 5000;
    public static final String TEST_HOST = "datatest.bigda.com";
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger errorCount;
    public volatile List<InetAddress> ips;
    public AtomicLong preChangeTime;
    public volatile String testServer;
    public volatile boolean useIp;

    public HostInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.useIp = false;
        this.errorCount = new AtomicInteger(0);
        this.preChangeTime = new AtomicLong();
        this.testServer = TEST_HOST;
        this.ips = trans(HiidoSDK.getHiidoIps());
    }

    private boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? HiidoSDK.isDebugMode : invokeV.booleanValue;
    }

    private List<InetAddress> trans(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                try {
                    arrayList.add(InetAddress.getByName(str));
                } catch (UnknownHostException e2) {
                    e2.printStackTrace();
                }
            }
            Collections.shuffle(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.message.HostManager
    public String getHost(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) ? isDebug() ? this.testServer : HiidoSDK.getHiidoHost() : (String) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.message.HostManager
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.useIp && !isDebug()) {
                L.debug(this, "Host:%s", this.ips.get(0));
                return new ArrayList(this.ips);
            }
            L.debug(this, "Host:%s", str);
            return Dns.SYSTEM.lookup(str);
        }
        return (List) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.message.HostManager
    public synchronized void onFailure(Call call, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, call, iOException) == null) {
            synchronized (this) {
                if (this.errorCount.incrementAndGet() > 30 && System.currentTimeMillis() - this.preChangeTime.get() > 5000) {
                    if (this.useIp) {
                        if (this.ips.size() == 1) {
                            this.useIp = false;
                            this.ips = trans(HiidoSDK.getHiidoIps());
                        } else {
                            this.ips.remove(0);
                        }
                    } else {
                        this.useIp = true;
                    }
                }
            }
        }
    }

    @Override // com.yy.hiidostatis.message.HostManager
    public void onSuccess(Call call) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, call) == null) || this.errorCount.decrementAndGet() >= 0) {
            return;
        }
        this.errorCount.set(0);
    }
}
