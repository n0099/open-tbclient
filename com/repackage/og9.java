package com.repackage;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class og9 implements TTNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ FunAdInteractionListener c;
    public final /* synthetic */ String d;
    public final /* synthetic */ TTNativeAd e;
    public final /* synthetic */ mg9 f;

    public og9(mg9 mg9Var, FunAdInteractionListener funAdInteractionListener, String str, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mg9Var, funAdInteractionListener, str, tTNativeAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = mg9Var;
        this.c = funAdInteractionListener;
        this.d = str;
        this.e = tTNativeAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view2, TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, tTNativeAd) == null) {
            LogPrinter.d();
            this.f.onAdClicked(this.b, new String[0]);
            this.b = true;
            FunAdInteractionListener funAdInteractionListener = this.c;
            if (funAdInteractionListener != null) {
                String str = this.d;
                pid = this.f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view2, TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, tTNativeAd) == null) {
            LogPrinter.d();
            this.f.onAdClicked(this.b, new String[0]);
            this.b = true;
            FunAdInteractionListener funAdInteractionListener = this.c;
            if (funAdInteractionListener != null) {
                String str = this.d;
                pid = this.f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
            LogPrinter.d();
            this.f.onAdShow(this.e, this.a, new String[0]);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.c;
            if (funAdInteractionListener != null) {
                String str = this.d;
                pid = this.f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }
}
