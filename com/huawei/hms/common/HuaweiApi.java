package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.icc;
import com.baidu.tieba.jcc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.common.internal.ResolveClientBean;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class HuaweiApi<TOption extends Api.ApiOptions> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HuaweiApi";
    public transient /* synthetic */ FieldHolder $fh;
    public int apiLevel;
    public String innerHmsPkg;
    public boolean isFirstReqSent;
    public boolean isUseInnerHms;
    public WeakReference<Activity> mActivity;
    public String mAppID;
    public AbstractClientBuilder<?, TOption> mClientBuilder;
    public Context mContext;
    public String mHostAppid;
    public Context mHostContext;
    public int mKitSdkVersion;
    public TOption mOption;
    public SubAppInfo mSubAppInfo;
    public RequestManager requestManager;

    /* loaded from: classes10.dex */
    public static class RequestHandler<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<TaskApiCallbackWrapper> callbackRunQueue;
        public final Queue<TaskApiCallbackWrapper> callbackWaitQueue;
        public final HuaweiApi<OptionsT> mApi;
        public final AnyClient mClient;
        public ConnectionResult mConnectionResult;
        public ResolveClientBean mResolveClientBean;

        public RequestHandler(HuaweiApi<OptionsT> huaweiApi) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {huaweiApi};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.callbackWaitQueue = new LinkedList();
            this.callbackRunQueue = new LinkedList();
            this.mApi = huaweiApi;
            this.mClient = huaweiApi.getClient(RequestManager.getHandler().getLooper(), this);
            this.mConnectionResult = null;
        }

        private TaskApiCallbackWrapper wrapperRequest(TaskApiCallWrapper taskApiCallWrapper) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, taskApiCallWrapper)) == null) {
                return new TaskApiCallbackWrapper(taskApiCallWrapper, new AnyClient.CallBack(this, taskApiCallWrapper) { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public AtomicBoolean isFirstRsp;
                    public final /* synthetic */ RequestHandler this$0;
                    public final /* synthetic */ TaskApiCallWrapper val$req;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, taskApiCallWrapper};
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
                        this.val$req = taskApiCallWrapper;
                        this.isFirstRsp = new AtomicBoolean(true);
                    }

                    @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                    public void onCallback(IMessageEntity iMessageEntity, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, iMessageEntity, str) == null) {
                            if (!(iMessageEntity instanceof ResponseHeader)) {
                                HMSLog.e(HuaweiApi.TAG, "header is not instance of ResponseHeader");
                                return;
                            }
                            ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                            if (responseHeader.getErrorCode() == 11) {
                                this.this$0.disconnect();
                                HMSLog.i(HuaweiApi.TAG, "unbind service");
                            }
                            if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                                HMSLog.e(HuaweiApi.TAG, "Response has resolution: " + responseHeader.getResolution());
                            }
                            if (this.isFirstRsp.compareAndSet(true, false)) {
                                b.a(this.this$0.mApi.getContext(), responseHeader, String.valueOf(this.this$0.mApi.getKitSdkVersion()));
                            }
                            this.val$req.getTaskApiCall().onResponse(this.this$0.mClient, responseHeader, str, this.val$req.getTaskCompletionSource());
                        }
                    }
                });
            }
            return (TaskApiCallbackWrapper) invokeL.objValue;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, connectionResult) == null) {
                HMSLog.i(HuaweiApi.TAG, "onConnectionFailed");
                BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
                this.mResolveClientBean = null;
                RequestManager.getHandler().post(new Runnable(this, connectionResult) { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RequestHandler this$0;
                    public final /* synthetic */ ConnectionResult val$result;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, connectionResult};
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
                        this.val$result = connectionResult;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.this$0.innerConnectionFailed(this.val$result);
                    }
                });
            }
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                HMSLog.i(HuaweiApi.TAG, "onConnectionSuspended");
                BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
                this.mResolveClientBean = null;
                RequestManager.getHandler().post(new Runnable(this) { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RequestHandler this$0;

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

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.innerConnectionSuspended();
                        }
                    }
                });
            }
        }

        private String getTransactionId(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, str2)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return TransactionIdCreater.getId(this.mApi.getAppID(), str2);
                }
                return str;
            }
            return (String) invokeLL.objValue;
        }

        private String errorReason(ConnectionResult connectionResult) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, connectionResult)) == null) {
                if (Util.isAvailableLibExist(this.mApi.getContext())) {
                    int errorCode = connectionResult.getErrorCode();
                    if (errorCode != -1) {
                        if (errorCode != 3) {
                            if (errorCode != 8) {
                                if (errorCode != 10) {
                                    if (errorCode != 13) {
                                        if (errorCode != 21) {
                                            switch (errorCode) {
                                                case 25:
                                                    return "failed to get update result";
                                                case 26:
                                                    return "update failed, because no activity incoming, can't pop update page";
                                                case 27:
                                                    return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                                            }
                                            return "unknown errorReason";
                                        }
                                        return "device is too old to be support";
                                    }
                                    return "update cancelled";
                                }
                                return "application configuration error, please developer check configuration";
                            }
                            return "internal error";
                        }
                        return "HuaWei Mobile Service is disabled";
                    }
                    return "get update result, but has other error codes";
                }
                int errorCode2 = connectionResult.getErrorCode();
                if (errorCode2 != -1) {
                    if (errorCode2 != 8) {
                        if (errorCode2 != 10) {
                            return "unknown errorReason";
                        }
                        return "application configuration error, please developer check configuration";
                    }
                    return "internal error";
                }
                return "get update result, but has other error codes";
            }
            return (String) invokeL.objValue;
        }

        public void sendRequest(TaskApiCallWrapper taskApiCallWrapper) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, taskApiCallWrapper) == null) {
                HMSLog.i(HuaweiApi.TAG, "sendRequest");
                TaskApiCallbackWrapper wrapperRequest = wrapperRequest(taskApiCallWrapper);
                if (this.mClient.isConnected()) {
                    HMSLog.i(HuaweiApi.TAG, "isConnected:true.");
                    BinderAdapter adapter = ((BaseHmsClient) this.mClient).getAdapter();
                    adapter.updateDelayTask();
                    ((HmsClient) this.mClient).setService(IAIDLInvoke.Stub.asInterface(adapter.getServiceBinder()));
                    postMessage(wrapperRequest);
                    return;
                }
                HMSLog.i(HuaweiApi.TAG, "isConnected:false.");
                this.callbackWaitQueue.add(wrapperRequest);
                ConnectionResult connectionResult = this.mConnectionResult;
                if (connectionResult != null && connectionResult.getErrorCode() != 0) {
                    HMSLog.i(HuaweiApi.TAG, "onConnectionFailed, ErrorCode:" + this.mConnectionResult.getErrorCode());
                    onConnectionFailed(this.mConnectionResult);
                    return;
                }
                RequestManager.addRequestToQueue(this);
                AnyClient anyClient = this.mClient;
                if (anyClient instanceof BaseHmsClient) {
                    ((BaseHmsClient) anyClient).setInternalRequest(this);
                }
                connect(taskApiCallWrapper.getTaskApiCall().getMinApkVersion(), wrapperRequest);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void innerConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, this) == null) {
                this.mConnectionResult = null;
                this.callbackRunQueue.clear();
                for (TaskApiCallbackWrapper taskApiCallbackWrapper : this.callbackWaitQueue) {
                    postMessage(taskApiCallbackWrapper);
                }
                this.callbackWaitQueue.clear();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void innerConnectionFailed(ConnectionResult connectionResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65546, this, connectionResult) == null) {
                this.mConnectionResult = connectionResult;
                boolean z = true;
                for (TaskApiCallbackWrapper taskApiCallbackWrapper : this.callbackWaitQueue) {
                    TaskApiCallWrapper apiCallWrapper = taskApiCallbackWrapper.getApiCallWrapper();
                    ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Failed:" + errorReason(connectionResult) + "(" + connectionResult.getErrorCode() + SmallTailInfo.EMOTION_SUFFIX);
                    responseHeader.setTransactionId(apiCallWrapper.getTaskApiCall().getTransactionId());
                    b.a(this.mApi.getContext(), responseHeader, String.valueOf(this.mApi.getKitSdkVersion()));
                    if (this.mConnectionResult.getResolution() != null && z) {
                        responseHeader.setParcelable(this.mConnectionResult.getResolution());
                        z = false;
                        if (Util.isAvailableLibExist(this.mApi.getContext()) && this.mConnectionResult.getErrorCode() == 26) {
                            responseHeader.setResolution(CommonCode.Resolution.HAS_RESOLUTION);
                        }
                    }
                    int errorCode = this.mConnectionResult.getErrorCode();
                    if (errorCode == 30 || errorCode == 31) {
                        responseHeader.setErrorCode(errorCode);
                    }
                    apiCallWrapper.getTaskApiCall().onResponse(this.mClient, responseHeader, null, apiCallWrapper.getTaskCompletionSource());
                }
                this.callbackWaitQueue.clear();
                this.callbackRunQueue.clear();
                this.mConnectionResult = null;
                this.mClient.disconnect();
            }
        }

        public void postMessage(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, taskApiCallbackWrapper) == null) {
                RequestManager.addToConnectedReqMap(taskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall().getTransactionId(), this);
                this.callbackRunQueue.add(taskApiCallbackWrapper);
                String uri = taskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall().getUri();
                if (this.mApi.mHostContext == null) {
                    context = this.mApi.getContext();
                } else {
                    context = this.mApi.mHostContext;
                }
                String packageName = context.getPackageName();
                if (this.mApi.mHostContext != null) {
                    HuaweiApi<OptionsT> huaweiApi = this.mApi;
                    huaweiApi.setHostAppId(huaweiApi.mHostContext);
                }
                RequestHeader requestHeader = new RequestHeader();
                requestHeader.setSrvName(uri.split("\\.")[0]);
                requestHeader.setApiName(uri);
                requestHeader.setAppID(this.mApi.getAppID() + "|" + this.mApi.getSubAppID());
                requestHeader.setPkgName(packageName);
                requestHeader.setSessionId(this.mClient.getSessionId());
                TaskApiCall taskApiCall = taskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall();
                requestHeader.setTransactionId(getTransactionId(taskApiCall.getTransactionId(), uri));
                requestHeader.setParcelable(taskApiCall.getParcelable());
                requestHeader.setKitSdkVersion(this.mApi.getKitSdkVersion());
                requestHeader.setApiLevel(Math.max(this.mApi.getApiLevel(), taskApiCall.getApiLevel()));
                this.mClient.post(requestHeader, taskApiCall.getRequestJson(), new AnyClient.CallBack(this, taskApiCallbackWrapper, requestHeader) { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RequestHandler this$0;
                    public final /* synthetic */ TaskApiCallbackWrapper val$callbackWrapper;
                    public final /* synthetic */ RequestHeader val$requestHeader;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, taskApiCallbackWrapper, requestHeader};
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
                        this.val$callbackWrapper = taskApiCallbackWrapper;
                        this.val$requestHeader = requestHeader;
                    }

                    @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                    public void onCallback(IMessageEntity iMessageEntity, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, iMessageEntity, str) == null) {
                            AnyClient.CallBack callBack = this.val$callbackWrapper.getCallBack();
                            if (callBack != null) {
                                callBack.onCallback(iMessageEntity, str);
                            }
                            RequestManager.removeReqByTransId(this.val$requestHeader.getTransactionId());
                            RequestManager.getHandler().post(new Runnable(this) { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$1.this$0.callbackRunQueue.remove(this.this$1.val$callbackWrapper);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void innerConnectionSuspended() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65547, this) == null) {
                HMSLog.i(HuaweiApi.TAG, "wait queue size = " + this.callbackWaitQueue.size());
                HMSLog.i(HuaweiApi.TAG, "run queue size = " + this.callbackRunQueue.size());
                for (TaskApiCallbackWrapper taskApiCallbackWrapper : this.callbackWaitQueue) {
                    sendConnectionSuspended(taskApiCallbackWrapper);
                }
                for (TaskApiCallbackWrapper taskApiCallbackWrapper2 : this.callbackRunQueue) {
                    sendConnectionSuspended(taskApiCallbackWrapper2);
                }
                this.callbackWaitQueue.clear();
                this.callbackRunQueue.clear();
                this.mConnectionResult = null;
                this.mClient.disconnect();
            }
        }

        private void sendConnectionSuspended(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65548, this, taskApiCallbackWrapper) == null) {
                TaskApiCallWrapper apiCallWrapper = taskApiCallbackWrapper.getApiCallWrapper();
                ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
                responseHeader.setTransactionId(apiCallWrapper.getTaskApiCall().getTransactionId());
                apiCallWrapper.getTaskApiCall().onResponse(this.mClient, responseHeader, null, apiCallWrapper.getTaskCompletionSource());
            }
        }

        public synchronized void connect(int i, TaskApiCallbackWrapper taskApiCallbackWrapper) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, taskApiCallbackWrapper) == null) {
                synchronized (this) {
                    if (this.mClient.isConnected()) {
                        HMSLog.d(HuaweiApi.TAG, "client is connected");
                    } else if (this.mClient.isConnecting()) {
                        HMSLog.d(HuaweiApi.TAG, "client is isConnecting");
                    } else {
                        if (this.mApi.getActivity() != null) {
                            if (this.mResolveClientBean == null) {
                                this.mResolveClientBean = new ResolveClientBean(this.mClient, i);
                            }
                            if (BindResolveClients.getInstance().isClientRegistered(this.mResolveClientBean)) {
                                HMSLog.i(HuaweiApi.TAG, "mResolveClientBean has already register, return!");
                                return;
                            }
                            BindResolveClients.getInstance().register(this.mResolveClientBean);
                        }
                        this.mClient.connect(i);
                    }
                }
            }
        }

        public void disconnect() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mClient.disconnect();
            }
        }

        public AnyClient getClient() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mClient;
            }
            return (AnyClient) invokeV.objValue;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                HMSLog.i(HuaweiApi.TAG, "onConnected");
                BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
                this.mResolveClientBean = null;
                RequestManager.getHandler().post(new Runnable(this) { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RequestHandler this$0;

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
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.innerConnected();
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class RequestRunnable<OptionsT extends Api.ApiOptions> implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final HuaweiApi<OptionsT> mApi;
        public final TaskApiCallWrapper mTaskApiCallWrapper;

        public RequestRunnable(HuaweiApi<OptionsT> huaweiApi, TaskApiCallWrapper taskApiCallWrapper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {huaweiApi, taskApiCallWrapper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mApi = huaweiApi;
            this.mTaskApiCallWrapper = taskApiCallWrapper;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x005a A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x006a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void notifyCpException(RequestHandler requestHandler, Exception exc) {
            RuntimeException e;
            AnyClient anyClient;
            String str;
            ResponseHeader responseHeader;
            jcc jccVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, requestHandler, exc) == null) {
                boolean z = true;
                TaskApiCall taskApiCall = null;
                try {
                    anyClient = requestHandler.getClient();
                    try {
                        responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, exc.getMessage());
                        try {
                            str = new JSONObject().toString();
                            try {
                                jccVar = this.mTaskApiCallWrapper.getTaskCompletionSource();
                                try {
                                    taskApiCall = this.mTaskApiCallWrapper.getTaskApiCall();
                                } catch (RuntimeException e2) {
                                    e = e2;
                                    HMSLog.e(HuaweiApi.TAG, "<notifyCpException> " + e.getMessage());
                                    if ((anyClient != null || responseHeader == null || str == null || jccVar == null || taskApiCall == null) ? false : false) {
                                    }
                                }
                            } catch (RuntimeException e3) {
                                e = e3;
                                jccVar = null;
                            }
                        } catch (RuntimeException e4) {
                            e = e4;
                            str = null;
                            jccVar = null;
                        }
                    } catch (RuntimeException e5) {
                        e = e5;
                        str = null;
                        responseHeader = null;
                        jccVar = null;
                        HMSLog.e(HuaweiApi.TAG, "<notifyCpException> " + e.getMessage());
                        if ((anyClient != null || responseHeader == null || str == null || jccVar == null || taskApiCall == null) ? false : false) {
                        }
                    }
                } catch (RuntimeException e6) {
                    e = e6;
                    anyClient = null;
                }
                if ((anyClient != null || responseHeader == null || str == null || jccVar == null || taskApiCall == null) ? false : false) {
                    taskApiCall.onResponse(anyClient, responseHeader, str, jccVar);
                } else {
                    HMSLog.e(HuaweiApi.TAG, "<notifyCpException> isNotify is false, Can not notify CP.");
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RequestHandler requestHandler = new RequestHandler(this.mApi);
                try {
                    requestHandler.sendRequest(this.mTaskApiCallWrapper);
                } catch (RuntimeException e) {
                    notifyCpException(requestHandler, e);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class TaskApiCallbackWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TaskApiCallWrapper mApiCallWrapper;
        public final AnyClient.CallBack mCallBack;

        public TaskApiCallbackWrapper(TaskApiCallWrapper taskApiCallWrapper, AnyClient.CallBack callBack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskApiCallWrapper, callBack};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mApiCallWrapper = taskApiCallWrapper;
            this.mCallBack = callBack;
        }

        public TaskApiCallWrapper getApiCallWrapper() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mApiCallWrapper;
            }
            return (TaskApiCallWrapper) invokeV.objValue;
        }

        public AnyClient.CallBack getCallBack() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mCallBack;
            }
            return (AnyClient.CallBack) invokeV.objValue;
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, api, toption, abstractClientBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.apiLevel = 1;
        this.isFirstReqSent = false;
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, 0, null);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, api, toption, abstractClientBuilder, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.apiLevel = 1;
        this.isFirstReqSent = false;
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, i, null);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, api, toption, abstractClientBuilder, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.apiLevel = 1;
        this.isFirstReqSent = false;
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, i, str);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, api, toption, abstractClientBuilder};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.apiLevel = 1;
        this.isFirstReqSent = false;
        Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, 0, null);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, api, toption, abstractClientBuilder, Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.apiLevel = 1;
        this.isFirstReqSent = false;
        Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, i, null);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, api, toption, abstractClientBuilder, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.apiLevel = 1;
        this.isFirstReqSent = false;
        Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, i, str);
    }

    private void initBI(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, context) == null) {
            HMSBIInitializer.getInstance(context).initBI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHostAppId(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, context) == null) {
            String appId = Util.getAppId(context);
            this.mHostAppid = appId;
            this.mAppID = appId;
        }
    }

    public void setApiLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.apiLevel = i;
        }
    }

    public void setHostContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            this.mHostContext = context;
        }
    }

    public void setKitSdkVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mKitSdkVersion = i;
        }
    }

    public void setSubAppId(String str) throws ApiException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, str) != null) || setSubAppInfo(new SubAppInfo(str))) {
            return;
        }
        throw new ApiException(Status.FAILURE);
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.huawei.hms.common.internal.AnyClient] */
    public AnyClient getClient(Looper looper, RequestHandler requestHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, looper, requestHandler)) == null) {
            return this.mClientBuilder.buildClient(this.mContext, getClientSetting(), requestHandler, requestHandler);
        }
        return (AnyClient) invokeLL.objValue;
    }

    private void init(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{context, api, toption, abstractClientBuilder, Integer.valueOf(i), str}) == null) {
            this.mContext = context.getApplicationContext();
            this.mOption = toption;
            this.mClientBuilder = abstractClientBuilder;
            setHostAppId(context);
            this.mSubAppInfo = new SubAppInfo("");
            this.mKitSdkVersion = i;
            if (!TextUtils.isEmpty(str)) {
                if (str.equals(this.mHostAppid)) {
                    HMSLog.e(TAG, "subAppId is host appid");
                } else {
                    HMSLog.i(TAG, "subAppId is " + str);
                    this.mSubAppInfo = new SubAppInfo(str);
                }
            }
            initBI(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerDisconnect(HuaweiApi<?> huaweiApi, jcc<Boolean> jccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, huaweiApi, jccVar) == null) {
            HMSLog.i(TAG, "innerDisconnect.");
            try {
                huaweiApi.getClient(RequestManager.getHandler().getLooper(), null).disconnect();
                jccVar.d(Boolean.TRUE);
            } catch (Exception e) {
                HMSLog.w(TAG, "disconnect the binder failed for:" + e.getMessage());
            }
        }
    }

    private <TResult, TClient extends AnyClient> icc<TResult> sendRequest(TaskApiCall<TClient, TResult> taskApiCall) {
        InterceptResult invokeL;
        jcc jccVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, taskApiCall)) == null) {
            if (taskApiCall.getToken() == null) {
                jccVar = new jcc();
            } else {
                jccVar = new jcc(taskApiCall.getToken());
            }
            RequestManager.getHandler().post(new RequestRunnable(this, new TaskApiCallWrapper(taskApiCall, jccVar)));
            return jccVar.b();
        }
        return (icc) invokeL.objValue;
    }

    @Deprecated
    public icc<Boolean> disconnectService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            jcc jccVar = new jcc();
            RequestManager.getInstance();
            RequestManager.getHandler().post(new Runnable(this, this, jccVar) { // from class: com.huawei.hms.common.HuaweiApi.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HuaweiApi this$0;
                public final /* synthetic */ HuaweiApi val$api;
                public final /* synthetic */ jcc val$taskCompletionSource;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, this, jccVar};
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
                    this.val$api = this;
                    this.val$taskCompletionSource = jccVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.innerDisconnect(this.val$api, this.val$taskCompletionSource);
                }
            });
            return jccVar.b();
        }
        return (icc) invokeV.objValue;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WeakReference<Activity> weakReference = this.mActivity;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public int getApiLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.apiLevel;
        }
        return invokeV.intValue;
    }

    public String getAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mAppID;
        }
        return (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    public int getKitSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mKitSdkVersion;
        }
        return invokeV.intValue;
    }

    public TOption getOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mOption;
        }
        return (TOption) invokeV.objValue;
    }

    public List<Scope> getScopes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    public String getSubAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mSubAppInfo.getSubAppID();
        }
        return (String) invokeV.objValue;
    }

    public <TResult, TClient extends AnyClient> icc<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        InterceptResult invokeL;
        String subAppID;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskApiCall)) == null) {
            this.isFirstReqSent = true;
            if (taskApiCall == null) {
                HMSLog.e(TAG, "in doWrite:taskApiCall is null");
                jcc jccVar = new jcc();
                jccVar.c(new ApiException(Status.FAILURE));
                return jccVar.b();
            }
            if (TextUtils.isEmpty(this.mSubAppInfo.getSubAppID())) {
                subAppID = this.mAppID;
            } else {
                subAppID = this.mSubAppInfo.getSubAppID();
            }
            b.a(this.mContext, taskApiCall.getUri(), subAppID, taskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
            if (this.requestManager == null) {
                this.requestManager = RequestManager.getInstance();
            }
            return sendRequest(taskApiCall);
        }
        return (icc) invokeL.objValue;
    }

    @Deprecated
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, subAppInfo)) == null) {
            HMSLog.i(TAG, "Enter setSubAppInfo");
            SubAppInfo subAppInfo2 = this.mSubAppInfo;
            if (subAppInfo2 != null && !TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
                HMSLog.e(TAG, "subAppInfo is already set");
                return false;
            } else if (subAppInfo == null) {
                HMSLog.e(TAG, "subAppInfo is null");
                return false;
            } else {
                String subAppID = subAppInfo.getSubAppID();
                if (TextUtils.isEmpty(subAppID)) {
                    HMSLog.e(TAG, "subAppId is empty");
                    return false;
                } else if (subAppID.equals(this.mHostAppid)) {
                    HMSLog.e(TAG, "subAppId is host appid");
                    return false;
                } else if (this.isFirstReqSent) {
                    HMSLog.e(TAG, "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
                    return false;
                } else {
                    this.mSubAppInfo = new SubAppInfo(subAppInfo);
                    return true;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public ClientSettings getClientSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ClientSettings clientSettings = new ClientSettings(this.mContext.getPackageName(), this.mContext.getClass().getName(), getScopes(), this.mHostAppid, null, this.mSubAppInfo);
            if (!this.isUseInnerHms) {
                this.innerHmsPkg = HMSPackageManager.getInstance(this.mContext).getHMSPackageNameForMultiService();
                HMSLog.i(TAG, "No setInnerHms, hms pkg name is " + this.innerHmsPkg);
            }
            clientSettings.setInnerHmsPkg(this.innerHmsPkg);
            clientSettings.setUseInnerHms(this.isUseInnerHms);
            WeakReference<Activity> weakReference = this.mActivity;
            if (weakReference != null) {
                clientSettings.setCpActivity(weakReference.get());
            }
            return clientSettings;
        }
        return (ClientSettings) invokeV.objValue;
    }

    public void setInnerHms() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.innerHmsPkg = this.mContext.getPackageName();
            this.isUseInnerHms = true;
            HMSLog.i(TAG, "<setInnerHms> init inner hms pkg info:" + this.innerHmsPkg);
        }
    }
}
