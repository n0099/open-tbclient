package com.repackage;

import android.app.Activity;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.channel.model.gdt.GDTNativeUnifiedVideoView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.repackage.fi9;
/* loaded from: classes6.dex */
public class li9 implements FunNativeAd2Bridger<NativeUnifiedADData, com.fun.module.gdt.w> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fi9.c a;
    public final /* synthetic */ si9 b;
    public final /* synthetic */ fi9 c;

    public li9(fi9 fi9Var, NativeUnifiedADData nativeUnifiedADData, String str, si9 si9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fi9Var, nativeUnifiedADData, str, si9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = fi9Var;
        this.b = si9Var;
        this.a = new fi9.c(fi9Var, nativeUnifiedADData, str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.fun.module.gdt.w, android.view.View] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.gdt.w createExpressView(NativeUnifiedADData nativeUnifiedADData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nativeUnifiedADData)) == null) ? this.c.b(FunAdSdk.getAppContext(), nativeUnifiedADData) : (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, NativeUnifiedADData nativeUnifiedADData, BaseNativeAd2<NativeUnifiedADData, com.fun.module.gdt.w> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, nativeUnifiedADData, baseNativeAd2, funAdInteractionListener}) == null) {
            NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
            ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener = this.b.c.getGdtADStatusChangeListener();
            if (gdtADStatusChangeListener != null) {
                this.a.d = new ji9(this, gdtADStatusChangeListener, nativeUnifiedADData2);
            } else {
                this.a.d = null;
            }
            this.c.j(nativeUnifiedADData2, str, customInflater.getGdtNativeAdContainer(), this.b.d, customInflater.getClickViews(), this.a, funAdInteractionListener);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, NativeUnifiedADData nativeUnifiedADData, BaseNativeAd2<NativeUnifiedADData, com.fun.module.gdt.w> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, nativeUnifiedADData, baseNativeAd2, funAdInteractionListener}) == null) {
            NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
            com.fun.module.gdt.w wVar = (com.fun.module.gdt.w) expressInflater.getExpressView();
            fi9 fi9Var = this.c;
            FunNativeAdListenerHelper<NativeUnifiedADData, NativeADEventListener> funNativeAdListenerHelper = fi9Var.i;
            pid = fi9Var.mPid;
            funNativeAdListenerHelper.startShow(nativeUnifiedADData2, str, pid, this.a, funAdInteractionListener);
            fi9.c cVar = this.a;
            cVar.d = new ki9(this, wVar, nativeUnifiedADData2);
            fi9 fi9Var2 = this.c;
            fi9Var2.getClass();
            if (wVar instanceof GDTNativeUnifiedVideoView) {
                ((GDTNativeUnifiedVideoView) wVar).setVideoOnClickListener(new hi9(fi9Var2));
            }
            nativeUnifiedADData2.setNativeAdEventListener(cVar);
            wVar.a(nativeUnifiedADData2);
            expressInflater.inflate();
        }
    }
}
