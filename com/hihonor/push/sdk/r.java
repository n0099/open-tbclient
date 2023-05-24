package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.tieba.g0b;
import com.baidu.tieba.r0b;
import com.baidu.tieba.u0b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushCallback;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.ResponseHeader;
import com.hihonor.push.sdk.common.data.ApiException;
import com.huawei.hms.api.IPCCallback;
/* loaded from: classes9.dex */
public class r extends IPushCallback.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public final u0b b;

    public r(Object obj, u0b u0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, u0bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = obj;
        this.b = u0bVar;
    }

    @Override // com.hihonor.push.framework.aidl.IPushCallback
    public void onResult(DataBuffer dataBuffer) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dataBuffer) == null) {
            Log.i(IPCCallback.TAG, "onResult parse start.");
            Bundle header = dataBuffer.getHeader();
            Bundle body = dataBuffer.getBody();
            ResponseHeader responseHeader = new ResponseHeader();
            MessageCodec.parseMessageEntity(header, responseHeader);
            Object obj = this.a;
            if (obj instanceof IMessageEntity) {
                MessageCodec.parseMessageEntity(body, (IMessageEntity) obj);
            }
            u0b u0bVar = this.b;
            ApiException apiException = new ApiException(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
            Object obj2 = this.a;
            g0b.b bVar = (g0b.b) u0bVar;
            bVar.getClass();
            g0b g0bVar = g0b.c;
            r0b<?> r0bVar = bVar.a;
            g0bVar.getClass();
            Log.i("HonorApiManager", "sendResolveResult start");
            Handler handler = g0bVar.a;
            handler.sendMessage(handler.obtainMessage(2, r0bVar));
            bVar.a.b(apiException, obj2);
            Log.i(IPCCallback.TAG, "onResult parse end.");
        }
    }
}
