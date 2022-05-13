package com.repackage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.channel.model.csj.CSJDrawVideoNativeView;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class vf9 extends of9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements TTAdNative.DrawFeedAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf9 a;

        public a(vf9 vf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vf9Var;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
        public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                LogPrinter.d();
                if (list == null || list.isEmpty()) {
                    LogPrinter.e("onFeedAdLoad error: adList is null or empty", new Object[0]);
                    this.a.onError(0, "NoFill");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (TTDrawFeedAd tTDrawFeedAd : list) {
                    arrayList.add(tTDrawFeedAd);
                }
                this.a.onAdLoaded((List) arrayList);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                LogPrinter.e("CSJDrawNative onError code: " + i + ", message: " + str, new Object[0]);
                this.a.onError(i, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vf9(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.DRAW), pid);
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

    @Override // com.repackage.of9
    public void d(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, funAdSlot) == null) {
            this.i.loadDrawFeedAd(new AdSlot.Builder().setCodeId(this.mPid.pid).setDownloadType(FunAdSdk.getFunAdConfig().downLoadType).setAdCount(NumberUtils.adjustInt(funAdSlot.getAdCount(), 1, 3)).build(), new a(this));
        }
    }

    @Override // com.repackage.of9
    public boolean i(Activity activity, ViewGroup viewGroup, String str, TTNativeAd tTNativeAd) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, tTNativeAd)) == null) {
            onShowStart();
            CSJDrawVideoNativeView cSJDrawVideoNativeView = (CSJDrawVideoNativeView) LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d035f, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(cSJDrawVideoNativeView);
            cSJDrawVideoNativeView.a(tTNativeAd);
            wf9 wf9Var = new wf9(this, tTNativeAd);
            tTNativeAd.setActivityForDownloadApp(activity);
            tTNativeAd.registerViewForInteraction(viewGroup, cSJDrawVideoNativeView.getClickViews(), cSJDrawVideoNativeView.getCreativeViews(), wf9Var);
            tTNativeAd.setDownloadListener(cSJDrawVideoNativeView.getDownloadListener());
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.of9, com.fun.ad.sdk.internal.api.BasePidLoader
    public /* bridge */ /* synthetic */ boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        i(activity, viewGroup, str, (TTNativeAd) obj);
        return true;
    }
}
