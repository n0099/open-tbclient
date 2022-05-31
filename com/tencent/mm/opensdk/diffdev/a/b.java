package com.tencent.mm.opensdk.diffdev.a;

import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class b implements OAuthListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ a f;

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = aVar;
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, oAuthErrCode, str) == null) {
            Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
            this.f.d = null;
            ArrayList<OAuthListener> arrayList = new ArrayList();
            list = this.f.c;
            arrayList.addAll(list);
            for (OAuthListener oAuthListener : arrayList) {
                oAuthListener.onAuthFinish(oAuthErrCode, str);
            }
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthGotQrcode(String str, byte[] bArr) {
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr) == null) {
            Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
            ArrayList<OAuthListener> arrayList = new ArrayList();
            list = this.f.c;
            arrayList.addAll(list);
            for (OAuthListener oAuthListener : arrayList) {
                oAuthListener.onAuthGotQrcode(str, bArr);
            }
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onQrcodeScanned() {
        Handler handler;
        Handler handler2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
            handler = this.f.handler;
            if (handler != null) {
                handler2 = this.f.handler;
                handler2.post(new c(this));
            }
        }
    }
}
