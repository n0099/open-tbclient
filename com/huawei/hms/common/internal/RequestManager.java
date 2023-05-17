package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes9.dex */
public class RequestManager implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object LOCK_OBJECT;
    public static final int NOTIFY_CONNECT_FAILED = 10012;
    public static final int NOTIFY_CONNECT_SUCCESS = 10011;
    public static final int NOTIFY_CONNECT_SUSPENDED = 10013;
    public static final String TAG = "RequestManager";
    public static Map<String, HuaweiApi.RequestHandler> connectedReqMap;
    public static Handler mHandler;
    public static volatile RequestManager mInstance;
    public static Queue<HuaweiApi.RequestHandler> requestQueue;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(97409152, "Lcom/huawei/hms/common/internal/RequestManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(97409152, "Lcom/huawei/hms/common/internal/RequestManager;");
                return;
            }
        }
        LOCK_OBJECT = new Object();
        requestQueue = new ConcurrentLinkedQueue();
        connectedReqMap = new LinkedHashMap();
    }

    public static RequestManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            synchronized (LOCK_OBJECT) {
                if (mInstance == null) {
                    HandlerThread handlerThread = new HandlerThread(TAG);
                    handlerThread.start();
                    mInstance = new RequestManager(handlerThread.getLooper());
                }
            }
            return mInstance;
        }
        return (RequestManager) invokeV.objValue;
    }

    private void handleConnectSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            while (!requestQueue.isEmpty()) {
                HuaweiApi.RequestHandler poll = requestQueue.poll();
                if (poll != null) {
                    AnyClient client = poll.getClient();
                    if (client instanceof BaseHmsClient) {
                        BaseHmsClient baseHmsClient = (BaseHmsClient) client;
                        baseHmsClient.setService(IAIDLInvoke.Stub.asInterface(baseHmsClient.getAdapter().getServiceBinder()));
                        poll.onConnected();
                    }
                }
            }
        }
    }

    public RequestManager(Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        mHandler = new Handler(looper, this);
    }

    private void handleConnectFailed(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, message) == null) {
            HMSLog.i(TAG, "NOTIFY_CONNECT_FAILED.");
            try {
                BaseHmsClient.ConnectionResultWrapper connectionResultWrapper = (BaseHmsClient.ConnectionResultWrapper) message.obj;
                HuaweiApi.RequestHandler request = connectionResultWrapper.getRequest();
                requestQueue.remove(request);
                request.onConnectionFailed(connectionResultWrapper.getConnectionResult());
            } catch (RuntimeException e) {
                HMSLog.e(TAG, "<handleConnectFailed> handle Failed" + e.getMessage());
            }
        }
    }

    public static Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return mHandler;
        }
        return (Handler) invokeV.objValue;
    }

    private void handleConnectSuspend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            HMSLog.i(TAG, "NOTIFY_CONNECT_SUSPENDED.");
            while (!requestQueue.isEmpty()) {
                requestQueue.poll().onConnectionSuspended(1);
            }
            notifyRunningRequestConnectSuspend();
        }
    }

    public static void addRequestToQueue(HuaweiApi.RequestHandler requestHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, requestHandler) == null) {
            requestQueue.add(requestHandler);
        }
    }

    public static void removeReqByTransId(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, str) != null) || mHandler == null) {
            return;
        }
        HMSLog.i(TAG, "removeReqByTransId");
        mHandler.post(new Runnable(str) { // from class: com.huawei.hms.common.internal.RequestManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$transId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$transId = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    RequestManager.connectedReqMap.remove(this.val$transId);
                }
            }
        });
    }

    public static void addToConnectedReqMap(String str, HuaweiApi.RequestHandler requestHandler) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, requestHandler) != null) || mHandler == null) {
            return;
        }
        HMSLog.i(TAG, "addToConnectedReqMap");
        mHandler.post(new Runnable(str, requestHandler) { // from class: com.huawei.hms.common.internal.RequestManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HuaweiApi.RequestHandler val$requestHandler;
            public final /* synthetic */ String val$transId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, requestHandler};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$transId = str;
                this.val$requestHandler = requestHandler;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    RequestManager.connectedReqMap.put(this.val$transId, this.val$requestHandler);
                }
            }
        });
    }

    private void notifyRunningRequestConnectSuspend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            HMSLog.i(TAG, "notifyRunningRequestConnectSuspend, connectedReqMap.size(): " + connectedReqMap.size());
            Iterator<Map.Entry<String, HuaweiApi.RequestHandler>> it = connectedReqMap.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    it.next().getValue().onConnectionSuspended(1);
                } catch (RuntimeException e) {
                    HMSLog.e(TAG, "NOTIFY_CONNECT_SUSPENDED Exception: " + e.getMessage());
                }
                it.remove();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (message == null) {
                return false;
            }
            HMSLog.i(TAG, "RequestManager handleMessage.");
            switch (message.what) {
                case 10011:
                    handleConnectSuccess();
                    return true;
                case 10012:
                    handleConnectFailed(message);
                    return true;
                case 10013:
                    handleConnectSuspend();
                    return true;
                default:
                    HMSLog.i(TAG, "handleMessage unknown msg:" + message.what);
                    return false;
            }
        }
        return invokeL.booleanValue;
    }
}
