package com.huawei.hms.support.api.core;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CheckConnectResp;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeReq;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes10.dex */
public final class ConnectService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a extends PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public boolean checkApiClient(ApiClient apiClient) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, apiClient)) == null) ? apiClient != null : invokeL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apiClient, str, iMessageEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ApiClient) objArr2[0], (String) objArr2[1], (IMessageEntity) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a */
        public ResolveResult<ConnectResp> onComplete(ConnectResp connectResp) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, connectResp)) == null) {
                ResolveResult<ConnectResp> resolveResult = new ResolveResult<>(connectResp);
                resolveResult.setStatus(Status.SUCCESS);
                HMSLog.d("connectservice", "connect - onComplete: success");
                return resolveResult;
            }
            return (ResolveResult) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public boolean checkApiClient(ApiClient apiClient) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, apiClient)) == null) ? apiClient != null : invokeL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apiClient, str, iMessageEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ApiClient) objArr2[0], (String) objArr2[1], (IMessageEntity) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a */
        public ResolveResult<ConnectResp> onComplete(ConnectResp connectResp) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, connectResp)) == null) {
                ResolveResult<ConnectResp> resolveResult = new ResolveResult<>(connectResp);
                resolveResult.setStatus(Status.SUCCESS);
                HMSLog.d("connectservice", "forceConnect - onComplete: success");
                return resolveResult;
            }
            return (ResolveResult) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends PendingResultImpl<ResolveResult<JosGetNoticeResp>, JosGetNoticeResp> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apiClient, str, iMessageEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ApiClient) objArr2[0], (String) objArr2[1], (IMessageEntity) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a */
        public ResolveResult<JosGetNoticeResp> onComplete(JosGetNoticeResp josGetNoticeResp) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, josGetNoticeResp)) == null) {
                if (josGetNoticeResp == null) {
                    HMSLog.e("connectservice", "JosNoticeResp is null");
                    return null;
                }
                HMSLog.i("connectservice", "josNoticeResp status code :" + josGetNoticeResp.getStatusCode());
                ResolveResult<JosGetNoticeResp> resolveResult = new ResolveResult<>(josGetNoticeResp);
                resolveResult.setStatus(Status.SUCCESS);
                return resolveResult;
            }
            return (ResolveResult) invokeL.objValue;
        }
    }

    public ConnectService() {
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

    public static InnerPendingResult<ResolveResult<CheckConnectResp>> checkconnect(ApiClient apiClient, CheckConnectInfo checkConnectInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, apiClient, checkConnectInfo)) == null) {
            return ResolvePendingResult.build(apiClient, CoreNaming.CHECKCONNECT, checkConnectInfo, CheckConnectResp.class);
        }
        return (InnerPendingResult) invokeLL.objValue;
    }

    public static PendingResult<ResolveResult<ConnectResp>> connect(ApiClient apiClient, ConnectInfo connectInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, apiClient, connectInfo)) == null) {
            return new a(apiClient, CoreNaming.CONNECT, connectInfo);
        }
        return (PendingResult) invokeLL.objValue;
    }

    public static ResolvePendingResult<DisconnectResp> disconnect(ApiClient apiClient, DisconnectInfo disconnectInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, apiClient, disconnectInfo)) == null) {
            return ResolvePendingResult.build(apiClient, CoreNaming.DISCONNECT, disconnectInfo, DisconnectResp.class);
        }
        return (ResolvePendingResult) invokeLL.objValue;
    }

    public static PendingResult<ResolveResult<ConnectResp>> forceConnect(ApiClient apiClient, ConnectInfo connectInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, apiClient, connectInfo)) == null) {
            return new b(apiClient, CoreNaming.FORECONNECT, connectInfo);
        }
        return (PendingResult) invokeLL.objValue;
    }

    public static PendingResult<ResolveResult<JosGetNoticeResp>> getNotice(ApiClient apiClient, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, apiClient, i, str)) == null) {
            JosGetNoticeReq josGetNoticeReq = new JosGetNoticeReq();
            josGetNoticeReq.setNoticeType(i);
            josGetNoticeReq.setHmsSdkVersionName(str);
            if (!TextUtils.isEmpty(apiClient.getCpID())) {
                josGetNoticeReq.setCpID(apiClient.getCpID());
            }
            return new c(apiClient, CoreNaming.GETNOTICE, josGetNoticeReq);
        }
        return (PendingResult) invokeLIL.objValue;
    }
}
