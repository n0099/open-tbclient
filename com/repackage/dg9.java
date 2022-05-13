package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.List;
/* loaded from: classes5.dex */
public class dg9 extends uf9<TTNativeExpressAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements TTAdNative.NativeExpressAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdSlot a;
        public final /* synthetic */ dg9 b;

        public a(dg9 dg9Var, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg9Var, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dg9Var;
            this.a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.e("onError code: " + i + ", message: " + str, new Object[0]);
                this.b.onError(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d();
                if (list != null && !list.isEmpty()) {
                    TTNativeExpressAd tTNativeExpressAd = list.get(0);
                    dg9 dg9Var = this.b;
                    this.a.getSid();
                    dg9Var.getClass();
                    tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) new eg9(dg9Var, tTNativeExpressAd));
                    tTNativeExpressAd.render();
                    return;
                }
                LogPrinter.e("onNativeExpressAdLoad error: adList is null or empty", new Object[0]);
                this.b.onError(0, "NoFill");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg9(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.INTERSTITIAL), pid);
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
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        TTNativeExpressAd tTNativeExpressAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || (tTNativeExpressAd = (TTNativeExpressAd) obj) == null) {
            return;
        }
        tTNativeExpressAd.destroy();
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            if (this.i == null) {
                this.i = TTAdSdk.getAdManager().createAdNative(context.getApplicationContext());
            }
            int expressWidth = funAdSlot.getExpressWidth();
            int expressHeight = funAdSlot.getExpressHeight();
            if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
                throw new RuntimeException("Invalid expressWidth and expressHeight.");
            }
            AdSlot build = new AdSlot.Builder().setCodeId(this.mPid.pid).setSupportDeepLink(true).setAdCount(1).setDownloadType(FunAdSdk.getFunAdConfig().downLoadType).setExpressViewAcceptedSize(expressWidth, expressHeight).build();
            onLoadStart(funAdSlot);
            this.i.loadInteractionExpressAd(build, new a(this, funAdSlot));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, str, obj)) == null) {
            TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
            onShowStart();
            tTNativeExpressAd.setDownloadListener(new mf9(null));
            tTNativeExpressAd.showInteractionExpressAd(activity);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
