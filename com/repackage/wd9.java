package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
/* loaded from: classes7.dex */
public class wd9 implements AdEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ ExpressAdListenerWrapper c;
    public final /* synthetic */ String d;
    public final /* synthetic */ NativeExpressADData2 e;
    public final /* synthetic */ td9 f;

    public wd9(td9 td9Var, ExpressAdListenerWrapper expressAdListenerWrapper, String str, NativeExpressADData2 nativeExpressADData2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {td9Var, expressAdListenerWrapper, str, nativeExpressADData2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = td9Var;
        this.c = expressAdListenerWrapper;
        this.d = str;
        this.e = nativeExpressADData2;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            this.f.onAdClose();
            FunAdInteractionListener funAdInteractionListener = this.c.funListener;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(this.d);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            this.f.onAdClicked(this.b, new String[0]);
            this.b = true;
            FunAdInteractionListener funAdInteractionListener = this.c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.d;
                pid = this.f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.e();
            this.f.onAdShow(this.e, this.a, new String[0]);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.d;
                pid = this.f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LogPrinter.d();
            this.f.onError(0, "RenderFail");
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LogPrinter.d();
            this.f.i.put(this.e, this.c);
            this.f.onAdLoaded((td9) this.e);
        }
    }
}
