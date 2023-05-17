package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
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
import com.google.protobuf.CodedInputStream;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.InnerBinderAdapter;
import com.huawei.hms.adapter.OuterBinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public abstract class BaseHmsClient implements AidlApiClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BINDING = 5;
    public static final int CONNECTED = 3;
    public static final AtomicInteger CONN_STATUS;
    public static final int DISCONNECTED = 1;
    public static final AtomicInteger INNER_CONN_STATUS;
    public static final Object LOCK_CONNECT_TIMEOUT_HANDLER;
    public static final int MSG_CONN_TIMEOUT = 2;
    public static final String TAG = "BaseHmsClient";
    public static final int TIMEOUT_DISCONNECTED = 6;
    public static BinderAdapter mInnerBinderAdapter;
    public static BinderAdapter mOuterBinderAdapter;
    public transient /* synthetic */ FieldHolder $fh;
    public HuaweiApi.RequestHandler internalRequest;
    public String mAppID;
    public final ClientSettings mClientSettings;
    public Handler mConnectTimeoutHandler;
    public final ConnectionCallbacks mConnectionCallbacks;
    public final OnConnectionFailedListener mConnectionFailedListener;
    public final Context mContext;
    public volatile IAIDLInvoke mService;
    public String sessionId;

    /* loaded from: classes9.dex */
    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i);
    }

    /* loaded from: classes9.dex */
    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    @Deprecated
    public int getMinApkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return 30000000;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes9.dex */
    public static final class ConnectionResultWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ConnectionResult connectionResult;
        public HuaweiApi.RequestHandler request;

        public ConnectionResultWrapper(HuaweiApi.RequestHandler requestHandler, ConnectionResult connectionResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {requestHandler, connectionResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.request = requestHandler;
            this.connectionResult = connectionResult;
        }

        public ConnectionResult getConnectionResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.connectionResult;
            }
            return (ConnectionResult) invokeV.objValue;
        }

        public HuaweiApi.RequestHandler getRequest() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.request;
            }
            return (HuaweiApi.RequestHandler) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-378055536, "Lcom/huawei/hms/common/internal/BaseHmsClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-378055536, "Lcom/huawei/hms/common/internal/BaseHmsClient;");
                return;
            }
        }
        LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
        CONN_STATUS = new AtomicInteger(1);
        INNER_CONN_STATUS = new AtomicInteger(1);
    }

    private void tryUnBind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            HMSLog.w(TAG, "Failed to get service as interface, trying to unbind.");
            if (this.mClientSettings.isUseInnerHms()) {
                BinderAdapter binderAdapter = mInnerBinderAdapter;
                if (binderAdapter == null) {
                    HMSLog.w(TAG, "mInnerBinderAdapter is null.");
                    return;
                }
                binderAdapter.unBind();
            } else {
                BinderAdapter binderAdapter2 = mOuterBinderAdapter;
                if (binderAdapter2 == null) {
                    HMSLog.w(TAG, "mOuterBinderAdapter is null.");
                    return;
                }
                binderAdapter2.unBind();
            }
            setConnectStatus(1);
            notifyFailed(10);
        }
    }

    public void bindCoreService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String innerHmsPkg = this.mClientSettings.getInnerHmsPkg();
            String serviceAction = getServiceAction();
            HMSLog.i(TAG, "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
            bindCoreInternal(innerHmsPkg, serviceAction);
        }
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, clientSettings, onConnectionFailedListener, connectionCallbacks};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mConnectTimeoutHandler = null;
        this.mContext = context;
        this.mClientSettings = clientSettings;
        this.mAppID = clientSettings.getAppID();
        this.mConnectionFailedListener = onConnectionFailedListener;
        this.mConnectionCallbacks = connectionCallbacks;
    }

    public void connect(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            checkAvailabilityAndConnect(i, z);
        }
    }

    public void connect(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            checkAvailabilityAndConnect(i, false);
        }
    }

    public void connectedInternal(IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iBinder) == null) {
            this.mService = IAIDLInvoke.Stub.asInterface(iBinder);
            if (this.mService == null) {
                HMSLog.e(TAG, "mService is null, try to unBind.");
                tryUnBind();
                return;
            }
            onConnecting();
        }
    }

    public void setConnectStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            if (this.mClientSettings.isUseInnerHms()) {
                INNER_CONN_STATUS.set(i);
            } else {
                CONN_STATUS.set(i);
            }
        }
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler requestHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, requestHandler) == null) {
            this.internalRequest = requestHandler;
        }
    }

    public void setService(IAIDLInvoke iAIDLInvoke) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, iAIDLInvoke) == null) {
            this.mService = iAIDLInvoke;
        }
    }

    private void bindCoreInternal(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
            if (this.mClientSettings.isUseInnerHms()) {
                mInnerBinderAdapter = InnerBinderAdapter.getInstance(this.mContext, str2, str);
                if (isConnected()) {
                    HMSLog.i(TAG, "The binder is already connected.");
                    getAdapter().updateDelayTask();
                    connectedInternal(getAdapter().getServiceBinder());
                    return;
                }
                setConnectStatus(5);
                mInnerBinderAdapter.binder(newBinderCallBack());
                return;
            }
            mOuterBinderAdapter = OuterBinderAdapter.getInstance(this.mContext, str2, str);
            if (isConnected()) {
                HMSLog.i(TAG, "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            }
            setConnectStatus(5);
            mOuterBinderAdapter.binder(newBinderCallBack());
        }
    }

    private void cancelConnDelayHandle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
                if (this.mConnectTimeoutHandler != null) {
                    this.mConnectTimeoutHandler.removeMessages(2);
                    this.mConnectTimeoutHandler = null;
                }
            }
        }
    }

    private BinderAdapter.BinderCallBack newBinderCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            return new BinderAdapter.BinderCallBack(this) { // from class: com.huawei.hms.common.internal.BaseHmsClient.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseHmsClient this$0;

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

                @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
                public void onBinderFailed(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        onBinderFailed(i, null);
                    }
                }

                @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
                public void onNullBinding(ComponentName componentName) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
                        this.this$0.setConnectStatus(1);
                        this.this$0.notifyFailed(10);
                    }
                }

                @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
                public void onBinderFailed(int i, Intent intent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, intent) == null) {
                        if (intent != null) {
                            Activity activeActivity = Util.getActiveActivity(this.this$0.getClientSettings().getCpActivity(), this.this$0.getContext());
                            if (activeActivity != null) {
                                HMSLog.i(BaseHmsClient.TAG, "onBinderFailed: SDK try to resolve and reConnect!");
                                long time = new Timestamp(System.currentTimeMillis()).getTime();
                                FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack(this) { // from class: com.huawei.hms.common.internal.BaseHmsClient.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                                    public void binderCallBack(int i2) {
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 != null && interceptable3.invokeI(1048576, this, i2) != null) || i2 == 0) {
                                            return;
                                        }
                                        this.this$1.this$0.notifyFailed(new ConnectionResult(10, (PendingIntent) null));
                                        this.this$1.this$0.mService = null;
                                    }
                                });
                                intent.putExtra(FailedBinderCallBack.CALLER_ID, time);
                                activeActivity.startActivity(intent);
                                return;
                            }
                            HMSLog.i(BaseHmsClient.TAG, "onBinderFailed: return pendingIntent to kit and cp");
                            this.this$0.notifyFailed(new ConnectionResult(10, PendingIntent.getActivity(this.this$0.mContext, 11, intent, CodedInputStream.DEFAULT_SIZE_LIMIT)));
                            this.this$0.mService = null;
                            return;
                        }
                        HMSLog.i(BaseHmsClient.TAG, "onBinderFailed: intent is null!");
                        this.this$0.notifyFailed(new ConnectionResult(10, (PendingIntent) null));
                        this.this$0.mService = null;
                    }
                }

                @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048579, this, componentName, iBinder) == null) {
                        HMSLog.i(BaseHmsClient.TAG, "Enter onServiceConnected.");
                        this.this$0.connectedInternal(iBinder);
                    }
                }

                @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
                public void onServiceDisconnected(ComponentName componentName) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, componentName) == null) {
                        HMSLog.i(BaseHmsClient.TAG, "Enter onServiceDisconnected.");
                        this.this$0.setConnectStatus(1);
                        RequestManager.getHandler().sendEmptyMessage(10013);
                        if (this.this$0.mConnectionCallbacks != null && !(this.this$0.mConnectionCallbacks instanceof HuaweiApi.RequestHandler)) {
                            this.this$0.mConnectionCallbacks.onConnectionSuspended(1);
                        }
                    }
                }

                @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
                public void onTimedDisconnected() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                        this.this$0.setConnectStatus(6);
                        if (this.this$0.mConnectionCallbacks != null && !(this.this$0.mConnectionCallbacks instanceof HuaweiApi.RequestHandler)) {
                            this.this$0.mConnectionCallbacks.onConnectionSuspended(1);
                        }
                    }
                }
            };
        }
        return (BinderAdapter.BinderCallBack) invokeV.objValue;
    }

    private void unBindAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (this.mClientSettings.isUseInnerHms()) {
                BinderAdapter binderAdapter = mInnerBinderAdapter;
                if (binderAdapter != null) {
                    binderAdapter.unBind();
                    return;
                }
                return;
            }
            BinderAdapter binderAdapter2 = mOuterBinderAdapter;
            if (binderAdapter2 != null) {
                binderAdapter2.unBind();
            }
        }
    }

    public final void checkConnected() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || isConnected()) {
            return;
        }
        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }

    public final void connectionConnected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setConnectStatus(3);
            RequestManager.getHandler().sendEmptyMessage(10011);
            ConnectionCallbacks connectionCallbacks = this.mConnectionCallbacks;
            if (connectionCallbacks != null && !(connectionCallbacks instanceof HuaweiApi.RequestHandler)) {
                connectionCallbacks.onConnected();
            }
        }
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mClientSettings.getApiName();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mAppID;
        }
        return (String) invokeV.objValue;
    }

    public ClientSettings getClientSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mClientSettings;
        }
        return (ClientSettings) invokeV.objValue;
    }

    public int getConnectionStatus() {
        InterceptResult invokeV;
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.mClientSettings.isUseInnerHms()) {
                atomicInteger = INNER_CONN_STATUS;
            } else {
                atomicInteger = CONN_STATUS;
            }
            return atomicInteger.get();
        }
        return invokeV.intValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mClientSettings.getCpID();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mClientSettings.getClientPackageName();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mService;
        }
        return (IAIDLInvoke) invokeV.objValue;
    }

    public String getServiceAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance(this.mContext);
            if (this.mClientSettings.isUseInnerHms()) {
                return hMSPackageManager.getInnerServiceAction();
            }
            return hMSPackageManager.getServiceAction();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.sessionId;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public SubAppInfo getSubAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mClientSettings.getSubAppID();
        }
        return (SubAppInfo) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return IPCTransport.class.getName();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (!this.mClientSettings.isUseInnerHms() ? CONN_STATUS.get() == 3 : INNER_CONN_STATUS.get() == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isConnecting() {
        InterceptResult invokeV;
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mClientSettings.isUseInnerHms()) {
                atomicInteger = INNER_CONN_STATUS;
            } else {
                atomicInteger = CONN_STATUS;
            }
            if (atomicInteger.get() == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            connectionConnected();
        }
    }

    private void checkAvailabilityAndConnect(int i, boolean z) {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            HMSLog.i(TAG, "====== HMSSDK version: 60500300 ======");
            if (this.mClientSettings.isUseInnerHms()) {
                atomicInteger = INNER_CONN_STATUS;
            } else {
                atomicInteger = CONN_STATUS;
            }
            int i2 = atomicInteger.get();
            HMSLog.i(TAG, "Enter connect, Connection Status: " + i2);
            if (!z && (i2 == 3 || i2 == 5)) {
                return;
            }
            if (getMinApkVersion() > i) {
                i = getMinApkVersion();
            }
            HMSLog.i(TAG, "connect minVersion:" + i + " packageName:" + this.mClientSettings.getInnerHmsPkg());
            if (this.mContext.getPackageName().equals(this.mClientSettings.getInnerHmsPkg())) {
                HMSLog.i(TAG, "service packageName is same, bind core service return");
                bindCoreService();
            } else if (Util.isAvailableLibExist(this.mContext)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i);
                int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.mContext);
                HMSLog.i(TAG, "check available result: " + isHuaweiMobileServicesAvailable);
                if (isHuaweiMobileServicesAvailable == 0) {
                    bindCoreService();
                } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.i(TAG, "bindCoreService3.0 fail, start resolution now.");
                    resolution(availableAdapter, isHuaweiMobileServicesAvailable);
                } else if (availableAdapter.isUserNoticeError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.i(TAG, "bindCoreService3.0 fail, start notice now.");
                    notice(availableAdapter, isHuaweiMobileServicesAvailable);
                } else {
                    HMSLog.i(TAG, "bindCoreService3.0 fail: " + isHuaweiMobileServicesAvailable + " is not resolvable.");
                    notifyFailed(isHuaweiMobileServicesAvailable);
                }
            } else {
                int isHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.mContext, i);
                HMSLog.i(TAG, "HuaweiApiAvailability check available result: " + isHuaweiMobileServicesAvailable2);
                if (isHuaweiMobileServicesAvailable2 == 0) {
                    bindCoreService();
                } else {
                    notifyFailed(isHuaweiMobileServicesAvailable2);
                }
            }
        }
    }

    private void notice(AvailableAdapter availableAdapter, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, this, availableAdapter, i) == null) {
            HMSLog.i(TAG, "enter notice");
            if (!getClientSettings().isHasActivity()) {
                if (i == 29) {
                    i = 9;
                }
                notifyFailed(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.mContext, i, 0)));
                return;
            }
            Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
            if (activeActivity != null) {
                availableAdapter.startNotice(activeActivity, new AvailableAdapter.AvailableCallBack(this) { // from class: com.huawei.hms.common.internal.BaseHmsClient.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BaseHmsClient this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                    public void onComplete(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeI(1048576, this, i2) != null) {
                            return;
                        }
                        this.this$0.notifyFailed(i2);
                    }
                });
            } else {
                notifyFailed(26);
            }
        }
    }

    private void resolution(AvailableAdapter availableAdapter, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, this, availableAdapter, i) == null) {
            HMSLog.i(TAG, "enter HmsCore resolution");
            if (!getClientSettings().isHasActivity()) {
                notifyFailed(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.mContext, i, 0)));
                return;
            }
            Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
            if (activeActivity != null) {
                availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack(this) { // from class: com.huawei.hms.common.internal.BaseHmsClient.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BaseHmsClient this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                    public void onComplete(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            if (i2 == 0) {
                                this.this$0.bindCoreService();
                            } else {
                                this.this$0.notifyFailed(i2);
                            }
                        }
                    }
                });
            } else {
                notifyFailed(26);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i) == null) {
            HMSLog.i(TAG, "notifyFailed result: " + i);
            Message message = new Message();
            message.what = 10012;
            message.obj = new ConnectionResultWrapper(this.internalRequest, new ConnectionResult(i));
            RequestManager.getHandler().sendMessage(message);
            OnConnectionFailedListener onConnectionFailedListener = this.mConnectionFailedListener;
            if (onConnectionFailedListener != null && !(onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
                onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailed(ConnectionResult connectionResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, connectionResult) == null) {
            HMSLog.i(TAG, "notifyFailed result: " + connectionResult.getErrorCode());
            Message message = new Message();
            message.what = 10012;
            HuaweiApi.RequestHandler requestHandler = this.internalRequest;
            this.internalRequest = null;
            message.obj = new ConnectionResultWrapper(requestHandler, connectionResult);
            RequestManager.getHandler().sendMessage(message);
            OnConnectionFailedListener onConnectionFailedListener = this.mConnectionFailedListener;
            if (onConnectionFailedListener != null && !(onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    public void disconnect() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.mClientSettings.isUseInnerHms()) {
                atomicInteger = INNER_CONN_STATUS;
            } else {
                atomicInteger = CONN_STATUS;
            }
            int i = atomicInteger.get();
            HMSLog.i(TAG, "Enter disconnect, Connection Status: " + i);
            if (i != 1) {
                if (i != 3) {
                    if (i == 5) {
                        cancelConnDelayHandle();
                        setConnectStatus(1);
                        return;
                    }
                    return;
                }
                unBindAdapter();
                setConnectStatus(1);
            }
        }
    }

    public BinderAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            HMSLog.i(TAG, "getAdapter:isInner:" + this.mClientSettings.isUseInnerHms() + ", mInnerBinderAdapter:" + mInnerBinderAdapter + ", mOuterBinderAdapter:" + mOuterBinderAdapter);
            if (this.mClientSettings.isUseInnerHms()) {
                return mInnerBinderAdapter;
            }
            return mOuterBinderAdapter;
        }
        return (BinderAdapter) invokeV.objValue;
    }
}
