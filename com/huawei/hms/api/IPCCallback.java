package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
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
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes9.dex */
public class IPCCallback extends IAIDLCallback.Stub {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IPCCallback";
    public transient /* synthetic */ FieldHolder $fh;
    public final DatagramTransport.a mCallback;
    public final Class<? extends IMessageEntity> mResponseClass;

    public IPCCallback(Class<? extends IMessageEntity> cls, DatagramTransport.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mResponseClass = cls;
        this.mCallback = aVar;
    }

    @Override // com.huawei.hms.core.aidl.IAIDLCallback
    public void call(DataBuffer dataBuffer) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dataBuffer) == null) {
            if (dataBuffer != null && !TextUtils.isEmpty(dataBuffer.URI)) {
                MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
                IMessageEntity iMessageEntity = null;
                if (dataBuffer.getBodySize() > 0 && (iMessageEntity = newResponseInstance()) != null) {
                    find.decode(dataBuffer.getBody(), iMessageEntity);
                }
                if (dataBuffer.header != null) {
                    ResponseHeader responseHeader = new ResponseHeader();
                    find.decode(dataBuffer.header, responseHeader);
                    this.mCallback.a(responseHeader.getStatusCode(), iMessageEntity);
                    return;
                }
                this.mCallback.a(0, iMessageEntity);
                return;
            }
            HMSLog.e(TAG, "In call, URI cannot be empty.");
            throw new RemoteException();
        }
    }

    public IMessageEntity newResponseInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Class<? extends IMessageEntity> cls = this.mResponseClass;
            if (cls != null) {
                try {
                    return cls.newInstance();
                } catch (IllegalAccessException | InstantiationException e) {
                    HMSLog.e(TAG, "In newResponseInstance, instancing exception." + e.getMessage());
                    return null;
                }
            }
            return null;
        }
        return (IMessageEntity) invokeV.objValue;
    }
}
