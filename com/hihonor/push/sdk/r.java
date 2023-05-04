package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.tieba.hya;
import com.baidu.tieba.sya;
import com.baidu.tieba.vya;
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
/* loaded from: classes8.dex */
public class r extends IPushCallback.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public final vya b;

    public r(Object obj, vya vyaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, vyaVar};
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
        this.b = vyaVar;
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
            vya vyaVar = this.b;
            ApiException apiException = new ApiException(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
            Object obj2 = this.a;
            hya.b bVar = (hya.b) vyaVar;
            bVar.getClass();
            hya hyaVar = hya.c;
            sya<?> syaVar = bVar.a;
            hyaVar.getClass();
            Log.i("HonorApiManager", "sendResolveResult start");
            Handler handler = hyaVar.a;
            handler.sendMessage(handler.obtainMessage(2, syaVar));
            bVar.a.b(apiException, obj2);
            Log.i(IPCCallback.TAG, "onResult parse end.");
        }
    }
}
