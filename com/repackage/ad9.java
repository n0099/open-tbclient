package com.repackage;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.zc9;
/* loaded from: classes5.dex */
public class ad9 implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ ExpressAdListenerWrapper c;
    public final /* synthetic */ String d;
    public final /* synthetic */ TTNativeExpressAd e;
    public final /* synthetic */ zc9.b f;
    public final /* synthetic */ zc9 g;

    public ad9(zc9 zc9Var, ExpressAdListenerWrapper expressAdListenerWrapper, String str, TTNativeExpressAd tTNativeExpressAd, zc9.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc9Var, expressAdListenerWrapper, str, tTNativeExpressAd, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = zc9Var;
        this.c = expressAdListenerWrapper;
        this.d = str;
        this.e = tTNativeExpressAd;
        this.f = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view2, int i) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            LogPrinter.d();
            this.g.onAdClicked(this.b, new String[0]);
            this.b = true;
            FunAdInteractionListener funAdInteractionListener = this.c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.d;
                pid = this.g.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.g.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view2, int i) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            LogPrinter.d();
            this.g.onAdShow(this.e, this.a, new String[0]);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.d;
                pid = this.g.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.g.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view2, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view2, str, i) == null) {
            LogPrinter.d();
            zc9.b bVar = this.f;
            if (bVar.c) {
                return;
            }
            int i2 = bVar.a + 1;
            bVar.a = i2;
            if (i2 == bVar.b) {
                bVar.d.onAdError(i, str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            LogPrinter.d();
            this.e.setCanInterruptVideoPlay(true);
            this.g.j.put(this.e, this.c);
            zc9.b bVar = this.f;
            TTNativeExpressAd tTNativeExpressAd = this.e;
            if (bVar.c) {
                bVar.d.cacheOrDestroyAd(tTNativeExpressAd);
                return;
            }
            bVar.d.onAdLoaded((zc9) tTNativeExpressAd);
            bVar.c = true;
        }
    }
}
