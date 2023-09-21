package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.tieba.bzb;
import com.baidu.tieba.nyb;
import com.baidu.tieba.yyb;
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
    public final bzb b;

    public r(Object obj, bzb bzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, bzbVar};
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
        this.b = bzbVar;
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
            bzb bzbVar = this.b;
            ApiException apiException = new ApiException(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
            Object obj2 = this.a;
            nyb.b bVar = (nyb.b) bzbVar;
            bVar.getClass();
            nyb nybVar = nyb.c;
            yyb<?> yybVar = bVar.a;
            nybVar.getClass();
            Log.i("HonorApiManager", "sendResolveResult start");
            Handler handler = nybVar.a;
            handler.sendMessage(handler.obtainMessage(2, yybVar));
            bVar.a.b(apiException, obj2);
            Log.i(IPCCallback.TAG, "onResult parse end.");
        }
    }
}
