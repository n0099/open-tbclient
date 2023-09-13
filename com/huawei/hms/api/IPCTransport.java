package com.huawei.hms.api;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes10.dex */
public class IPCTransport implements DatagramTransport {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IPCTransport";
    public transient /* synthetic */ FieldHolder $fh;
    public int apiLevel;
    public final IMessageEntity mEntity;
    public final Class<? extends IMessageEntity> mResponseClass;
    public final String mURI;

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iMessageEntity, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mURI = str;
        this.mEntity = iMessageEntity;
        this.mResponseClass = cls;
    }

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iMessageEntity, cls, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mURI = str;
        this.mEntity = iMessageEntity;
        this.mResponseClass = cls;
        this.apiLevel = i;
    }

    private int syncCall(ApiClient apiClient, IAIDLCallback iAIDLCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, apiClient, iAIDLCallback)) == null) {
            if (apiClient instanceof InnerApiClient) {
                DataBuffer dataBuffer = new DataBuffer(this.mURI, ProtocolNegotiate.getInstance().getVersion());
                MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
                dataBuffer.addBody(find.encode(this.mEntity, new Bundle()));
                RequestHeader requestHeader = new RequestHeader();
                requestHeader.setAppID(apiClient.getAppID());
                requestHeader.setPackageName(apiClient.getPackageName());
                requestHeader.setSdkVersion(60500300);
                requestHeader.setApiNameList(((AidlApiClient) apiClient).getApiNameList());
                requestHeader.setSessionId(apiClient.getSessionId());
                requestHeader.setApiLevel(this.apiLevel);
                dataBuffer.header = find.encode(requestHeader, new Bundle());
                try {
                    AidlApiClient aidlApiClient = (AidlApiClient) apiClient;
                    if (aidlApiClient.getService() == null) {
                        HMSLog.e(TAG, "HuaweiApiClient is not binded to service yet.");
                        return CommonCode.ErrorCode.INTERNAL_ERROR;
                    }
                    aidlApiClient.getService().asyncCall(dataBuffer, iAIDLCallback);
                    return 0;
                } catch (Exception e) {
                    HMSLog.e(TAG, "sync call ex:" + e);
                    return CommonCode.ErrorCode.INTERNAL_ERROR;
                }
            }
            if (apiClient instanceof AidlApiClient) {
                AidlApiClient aidlApiClient2 = (AidlApiClient) apiClient;
                DataBuffer dataBuffer2 = new DataBuffer(this.mURI, ProtocolNegotiate.getInstance().getVersion());
                dataBuffer2.addBody(CodecLookup.find(dataBuffer2.getProtocol()).encode(this.mEntity, new Bundle()));
                try {
                    aidlApiClient2.getService().asyncCall(dataBuffer2, iAIDLCallback);
                    return 0;
                } catch (Exception e2) {
                    HMSLog.e(TAG, "sync call ex:" + e2);
                }
            }
            return CommonCode.ErrorCode.INTERNAL_ERROR;
        }
        return invokeLL.intValue;
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void post(ApiClient apiClient, DatagramTransport.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, apiClient, aVar) == null) {
            send(apiClient, aVar);
        }
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void send(ApiClient apiClient, DatagramTransport.a aVar) {
        int syncCall;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, apiClient, aVar) == null) && (syncCall = syncCall(apiClient, new IPCCallback(this.mResponseClass, aVar))) != 0) {
            aVar.a(syncCall, null);
        }
    }
}
