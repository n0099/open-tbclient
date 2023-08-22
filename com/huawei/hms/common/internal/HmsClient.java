package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class HmsClient extends BaseHmsClient implements AnyClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HmsClient";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class BaseAdapterCallBack implements BaseAdapter.BaseCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AnyClient.CallBack callback;
        public final WeakReference<HmsClient> hmsClient;

        public BaseAdapterCallBack(HmsClient hmsClient, AnyClient.CallBack callBack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hmsClient, callBack};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.callback = callBack;
            this.hmsClient = new WeakReference<>(hmsClient);
        }

        private void doCallback(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, str, str2) == null) {
                ResponseHeader responseHeader = new ResponseHeader();
                if (responseHeader.fromJson(str)) {
                    HMSLog.i(HmsClient.TAG, "receive msg " + responseHeader);
                    updateSessionId(responseHeader.getSessionId());
                    this.callback.onCallback(responseHeader, str2);
                    return;
                }
                this.callback.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
            }
        }

        private void doCallback(String str, String str2, Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, this, str, str2, parcelable) == null) {
                ResponseHeader responseHeader = new ResponseHeader();
                if (responseHeader.fromJson(str)) {
                    responseHeader.setParcelable(parcelable);
                    HMSLog.i(HmsClient.TAG, "receive msg " + responseHeader);
                    updateSessionId(responseHeader.getSessionId());
                    this.callback.onCallback(responseHeader, str2);
                    return;
                }
                this.callback.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
            }
        }

        private void updateSessionId(String str) {
            HmsClient hmsClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65539, this, str) == null) && (hmsClient = this.hmsClient.get()) != null) {
                hmsClient.updateSessionId(str);
            }
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onComplete(String str, String str2, Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, parcelable) == null) {
                if (parcelable == null) {
                    doCallback(str, str2);
                } else {
                    doCallback(str, str2, parcelable);
                }
            }
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                ResponseWrap responseWrap = new ResponseWrap(new ResponseHeader());
                if (responseWrap.fromJson(str)) {
                    HMSLog.i(HmsClient.TAG, "receive msg " + responseWrap);
                    ResponseHeader responseHeader = responseWrap.getResponseHeader();
                    updateSessionId(responseHeader.getSessionId());
                    this.callback.onCallback(responseHeader, responseWrap.getBody());
                    return;
                }
                this.callback.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HmsClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, clientSettings, onConnectionFailedListener, connectionCallbacks};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ClientSettings) objArr2[1], (BaseHmsClient.OnConnectionFailedListener) objArr2[2], (BaseHmsClient.ConnectionCallbacks) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.huawei.hms.common.internal.AnyClient
    public void post(IMessageEntity iMessageEntity, String str, AnyClient.CallBack callBack) {
        BaseAdapter baseAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, iMessageEntity, str, callBack) == null) {
            if (callBack == null) {
                HMSLog.e(TAG, "callback is invalid, discard.");
                return;
            }
            boolean z = true;
            if ((iMessageEntity instanceof RequestHeader) && str != null) {
                if (!isConnected()) {
                    HMSLog.i(TAG, "No connection now, the connection status:" + getConnectionStatus());
                    if (getConnectionStatus() != 6) {
                        HMSLog.e(TAG, "post failed for not connected.");
                        callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, "Not Connected"), new JSONObject().toString());
                        return;
                    }
                    HMSLog.i(TAG, "in timeout-disconnect status, need to bind again.");
                    bindCoreService();
                }
                RequestHeader requestHeader = (RequestHeader) iMessageEntity;
                HMSLog.i(TAG, "post msg " + requestHeader);
                Activity cpActivity = getClientSettings().getCpActivity();
                if (cpActivity != null) {
                    z = false;
                }
                if (z) {
                    HMSLog.i(TAG, "Activity is null for " + getClientSettings().getAppID());
                }
                if (z) {
                    baseAdapter = new BaseAdapter(this);
                } else {
                    baseAdapter = new BaseAdapter(this, cpActivity);
                }
                baseAdapter.baseRequest(requestHeader.toJson(), str, requestHeader.getParcelable(), new BaseAdapterCallBack(this, callBack));
                return;
            }
            HMSLog.e(TAG, "arguments is invalid.");
            callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "Args is invalid"), new JSONObject().toString());
        }
    }

    public void updateSessionId(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && TextUtils.isEmpty(this.sessionId)) {
            this.sessionId = str;
        }
    }
}
