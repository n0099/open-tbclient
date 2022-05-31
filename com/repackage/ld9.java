package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressAD2;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class ld9 extends ReporterPidLoader<NativeExpressADData2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<NativeExpressADData2, ExpressAdListenerWrapper<AdEventListener>> i;

    /* loaded from: classes6.dex */
    public class a implements NativeExpressAD2.AdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdSlot a;
        public final /* synthetic */ ld9 b;

        public a(ld9 ld9Var, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ld9Var, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ld9Var;
            this.a = funAdSlot;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: com.qq.e.ads.nativ.express2.NativeExpressADData2 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [A, com.qq.e.ads.nativ.express2.AdEventListener, com.repackage.od9] */
        @Override // com.qq.e.ads.nativ.express2.NativeExpressAD2.AdLoadListener
        public void onLoadSuccess(List<NativeExpressADData2> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                LogPrinter.d();
                if (list != null && !list.isEmpty()) {
                    NativeExpressADData2 nativeExpressADData2 = list.get(0);
                    ld9 ld9Var = this.b;
                    String sid = this.a.getSid();
                    ld9Var.getClass();
                    ExpressAdListenerWrapper expressAdListenerWrapper = new ExpressAdListenerWrapper();
                    ?? od9Var = new od9(ld9Var, expressAdListenerWrapper, sid, nativeExpressADData2);
                    expressAdListenerWrapper.listener = od9Var;
                    nativeExpressADData2.setAdEventListener(od9Var);
                    nativeExpressADData2.render();
                    return;
                }
                this.b.onError(0, "NoFill");
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adError) == null) {
                LogPrinter.e("onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
                this.b.onError(adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ld9(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.NATIVE), pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new HashMap<>();
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new je9(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            NativeExpressADData2 nativeExpressADData2 = (NativeExpressADData2) obj;
            this.i.remove(nativeExpressADData2);
            if (nativeExpressADData2 != null) {
                nativeExpressADData2.destroy();
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, obj)) == null) ? new BaseNativeAd2(FunNativeAd2.NativeType.EXPRESS, (NativeExpressADData2) obj, new qd9(this)) : (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            int expressWidth = funAdSlot.getExpressWidth();
            int expressHeight = funAdSlot.getExpressHeight();
            if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
                throw new RuntimeException("Invalid expressWidth and expressHeight.");
            }
            NativeExpressAD2 nativeExpressAD2 = new NativeExpressAD2(context.getApplicationContext(), this.mPid.pid, new a(this, funAdSlot));
            onLoadStart(funAdSlot);
            nativeExpressAD2.setAdSize(expressWidth, expressHeight);
            VideoOption2.Builder builder = new VideoOption2.Builder();
            builder.setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? VideoOption2.AutoPlayPolicy.ALWAYS : VideoOption2.AutoPlayPolicy.WIFI).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setMaxVideoDuration(0).setMinVideoDuration(0);
            nativeExpressAD2.setVideoOption2(builder.build());
            nativeExpressAD2.loadAd(1);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, viewGroup, str, obj)) == null) {
            onShowStart();
            View adView = ((NativeExpressADData2) obj).getAdView();
            if (adView.getParent() != null) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(adView);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
