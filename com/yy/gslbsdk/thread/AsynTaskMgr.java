package com.yy.gslbsdk.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.db.DBAccessMgr;
import com.yy.gslbsdk.db.HostTB;
import com.yy.gslbsdk.device.NetStatusInfo;
import com.yy.gslbsdk.flow.DnsResolveFlow;
import com.yy.gslbsdk.flow.QualityDetectFlow;
import com.yy.gslbsdk.protocol.DnsInfo;
import com.yy.gslbsdk.protocol.LocalDNSProtocolMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class AsynTaskMgr {
    public static final /* synthetic */ AsynTaskMgr[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final AsynTaskMgr INSTANCE;
    public static int KTaskParseLocalDns = 0;
    public static int KTaskUpdateHost = 0;
    public static final String TAG = "AsynTaskMgr";
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public AtomicBoolean mMonitorStarted;

    /* loaded from: classes7.dex */
    public static class AsynTaskHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsynTaskHandler(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == AsynTaskMgr.KTaskUpdateHost) {
                    AsynTaskMgr.INSTANCE.doUpdateHost(message.getData());
                } else if (message.what == AsynTaskMgr.KTaskParseLocalDns) {
                    AsynTaskMgr.INSTANCE.doParseLocalDns(message.getData());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1617807976, "Lcom/yy/gslbsdk/thread/AsynTaskMgr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1617807976, "Lcom/yy/gslbsdk/thread/AsynTaskMgr;");
                return;
            }
        }
        AsynTaskMgr asynTaskMgr = new AsynTaskMgr("INSTANCE", 0);
        INSTANCE = asynTaskMgr;
        $VALUES = new AsynTaskMgr[]{asynTaskMgr};
        KTaskUpdateHost = 1;
        KTaskParseLocalDns = 2;
    }

    public AsynTaskMgr(String str, int i) {
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
        this.mHandlerThread = null;
        this.mHandler = null;
        this.mMonitorStarted = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doParseLocalDns(Bundle bundle) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, bundle) == null) || (string = bundle.getString("host")) == null || string.length() == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DnsInfo requestProtocol = LocalDNSProtocolMgr.requestProtocol(string);
        if (requestProtocol != null) {
            NetStatusInfo cachedNetStatusInfo = DataCacheMgr.INSTANCE.getCachedNetStatusInfo();
            requestProtocol.setNt(cachedNetStatusInfo.getNetType());
            DnsInfo dnsInfo = new DnsInfo();
            if (IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, cachedNetStatusInfo, string, dnsInfo) == 0) {
                requestProtocol.setUip(dnsInfo.getUip());
            }
            IpVersionController.getInstance().putLocalDNSIntoCache(requestProtocol);
        } else {
            LogTools.printError(TAG, "local parse error");
        }
        LogTools.printDebug(TAG, "parse local dns, timespent = " + (System.currentTimeMillis() - currentTimeMillis) + ", host = " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateHost(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, bundle) == null) || bundle == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("hostList");
        boolean z = bundle.getBoolean("isPre");
        if (stringArrayList == null || GlobalTools.APP_CONTEXT == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            List<HostTB> hostByHost = dBAccessMgr.getHostByHost(next);
            if (hostByHost.isEmpty()) {
                HostTB hostTB = new HostTB();
                hostTB.setHost(next);
                hostTB.setInsertTime(currentTimeMillis);
                hostTB.setIsPre(z ? 1 : 0);
                dBAccessMgr.addHost(hostTB);
            } else {
                HostTB hostTB2 = hostByHost.get(0);
                hostTB2.setInsertTime(currentTimeMillis);
                if (hostTB2.getIsPre() == 0) {
                    hostTB2.setIsPre(z ? 1 : 0);
                }
                dBAccessMgr.updateHost(hostTB2);
            }
        }
        List<HostTB> allHost = dBAccessMgr.getAllHost();
        int size = allHost.size();
        if (size > GlobalTools.KEEP_HOST_NUM) {
            for (int i = size - 1; i > 0; i--) {
                if (allHost.get(i).getIsPre() != 1) {
                    LogTools.printDebug(TAG, "remove host " + allHost.get(i).getHost());
                    dBAccessMgr.delHost(allHost.get(i));
                    size += -1;
                    if (size <= GlobalTools.KEEP_HOST_NUM) {
                        break;
                    }
                }
            }
        }
        allHost.clear();
    }

    public static AsynTaskMgr valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? (AsynTaskMgr) Enum.valueOf(AsynTaskMgr.class, str) : (AsynTaskMgr) invokeL.objValue;
    }

    public static AsynTaskMgr[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? (AsynTaskMgr[]) $VALUES.clone() : (AsynTaskMgr[]) invokeV.objValue;
    }

    public boolean isHandlerRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHandlerThread.isAlive() : invokeV.booleanValue;
    }

    public boolean isMonitorRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMonitorStarted.get() : invokeV.booleanValue;
    }

    public void parseLocalDns(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Message obtain = Message.obtain();
            obtain.what = KTaskParseLocalDns;
            Bundle bundle = new Bundle();
            bundle.putString("host", str);
            obtain.setData(bundle);
            this.mHandler.sendMessage(obtain);
        }
    }

    public void post(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
            this.mHandler.post(runnable);
        }
    }

    public void postDelayed(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, runnable, j) == null) {
            this.mHandler.removeCallbacks(runnable);
            this.mHandler.postDelayed(runnable, j);
        }
    }

    public synchronized void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                HandlerThread handlerThread = new HandlerThread("gslb_asyn_task");
                this.mHandlerThread = handlerThread;
                handlerThread.start();
                this.mHandler = new AsynTaskHandler(this.mHandlerThread.getLooper());
            }
        }
    }

    public void startMonitors() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mHandler.postDelayed(new Runnable(this) { // from class: com.yy.gslbsdk.thread.AsynTaskMgr.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AsynTaskMgr this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mMonitorStarted.compareAndSet(false, true)) {
                        DnsResolveFlow.getInstance().beginNetworkMonitor();
                        DnsResolveFlow.getInstance().beginTTLMonitor();
                    }
                }
            }, GlobalTools.MONITOR_DELAY);
        }
    }

    public synchronized void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.mHandlerThread.quit();
            }
        }
    }

    public void stopMonitors() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.mMonitorStarted.compareAndSet(true, false)) {
            DnsResolveFlow.getInstance().stopNetworkMonitor();
            QualityDetectFlow.getInstance().stopAllMonitor();
        }
    }

    public void updateHost(ArrayList<String> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, arrayList, z) == null) {
            Message obtain = Message.obtain();
            obtain.what = KTaskUpdateHost;
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("hostList", arrayList);
            bundle.putBoolean("isPre", z);
            obtain.setData(bundle);
            this.mHandler.sendMessage(obtain);
        }
    }
}
