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
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class fe9 extends le9<se9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FunNativeAdListenerHelper<se9, TTNativeAd.AdInteractionListener> f;

    /* loaded from: classes6.dex */
    public class a implements TTAdNative.NativeAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fe9 a;

        public a(fe9 fe9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fe9Var;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.e("onError code: " + i + ", message: " + str, new Object[0]);
                this.a.onError(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d("onNativeAdLoad", new Object[0]);
                if (list == null || list.isEmpty()) {
                    LogPrinter.e("onNativeAdLoad error: list is null or empty", new Object[0]);
                    this.a.onError(0, "NoFill");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (TTNativeAd tTNativeAd : list) {
                    arrayList.add(new se9(tTNativeAd));
                }
                this.a.onAdLoaded((List) arrayList);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TTNativeAd.AdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final se9 a;
        public final /* synthetic */ fe9 b;

        public b(fe9 fe9Var, se9 se9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe9Var, se9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fe9Var;
            this.a = se9Var;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view2, TTNativeAd tTNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, tTNativeAd) == null) {
                LogPrinter.d();
                this.b.f.onAdClick(this.a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view2, TTNativeAd tTNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, tTNativeAd) == null) {
                LogPrinter.d();
                this.b.f.onAdClick(this.a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
                LogPrinter.d();
                this.b.f.onAdShow(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fe9(FunAdType funAdType, Ssp.Pid pid) {
        super(funAdType, pid, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new FunNativeAdListenerHelper<>(this);
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            this.f.destroy((se9) obj);
        }
    }

    public void f(Activity activity, se9 se9Var, ViewGroup viewGroup, com.fun.module.csj.g0 g0Var, TTNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, se9Var, viewGroup, g0Var, adInteractionListener) == null) {
            ((TTNativeAd) se9Var.a).setActivityForDownloadApp(activity);
            ((TTNativeAd) se9Var.a).registerViewForInteraction(viewGroup, g0Var.getClickViews(), g0Var.getCreativeViews(), adInteractionListener);
            ((TTNativeAd) se9Var.a).setDownloadListener(g0Var.getDownloadListener());
        }
    }

    public final void g(Context context, se9 se9Var, String str, ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, se9Var, str, viewGroup, list, list2, adInteractionListener, funAdInteractionListener}) == null) {
            if (viewGroup instanceof FunNativeView) {
                viewGroup = ((FunNativeView) viewGroup).getRoot();
            }
            this.f.startShow(se9Var, str, this.mPid, adInteractionListener, funAdInteractionListener);
            if (context instanceof Activity) {
                ((TTNativeAd) se9Var.a).setActivityForDownloadApp((Activity) context);
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            ((TTNativeAd) se9Var.a).registerViewForInteraction(viewGroup, list, list2, adInteractionListener);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd getNativeAdInternal(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, str, obj)) == null) ? new ie9((se9) obj, str, this.mPid, this) : (FunNativeAd) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, obj)) == null) {
            se9 se9Var = (se9) obj;
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, se9Var, new ie9(se9Var, str, this.mPid, this), new je9(this, this, se9Var));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    public void h(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, funAdSlot) == null) {
            AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.mPid.pid).setSupportDeepLink(true);
            Ssp.Pid pid = this.mPid;
            this.e.loadNativeAd(supportDeepLink.setImageAcceptedSize(pid.width, pid.height).setNativeAdType(1).setAdCount(NumberUtils.adjustInt(funAdSlot.getAdCount(), 1, 3)).build(), new a(this));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    /* renamed from: l */
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, se9 se9Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, activity, viewGroup, str, se9Var)) == null) {
            onShowStart(se9Var);
            com.fun.module.csj.g0 a2 = ge9.a((TTNativeAd) se9Var.a);
            if (a2 == null) {
                onAdError(se9Var, 0, "AdView present failed");
                return false;
            }
            viewGroup.removeAllViews();
            viewGroup.addView(a2);
            f(activity, se9Var, viewGroup, a2, new he9(this, se9Var, null, str));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, funAdSlot) == null) {
            if (this.e == null) {
                this.e = TTAdSdk.getAdManager().createAdNative(context.getApplicationContext());
            }
            onLoadStart(funAdSlot);
            h(funAdSlot);
        }
    }
}
