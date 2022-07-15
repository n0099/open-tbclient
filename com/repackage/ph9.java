package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import com.fun.ad.sdk.internal.api.utils.PxUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.List;
/* loaded from: classes6.dex */
public class ph9 extends ReporterPidLoader<KsNativeAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FunNativeAdListenerHelper<KsNativeAd, KsNativeAd.AdInteractionListener> e;

    /* loaded from: classes6.dex */
    public class a implements KsLoadManager.NativeAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ph9 a;

        public a(ph9 ph9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ph9Var;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.e("onError code: " + i + ", message: " + str, new Object[0]);
                this.a.onError(i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d();
                if (list != null && !list.isEmpty()) {
                    this.a.onAdLoaded((List) list);
                    return;
                }
                LogPrinter.e("error: adList is null or empty", new Object[0]);
                this.a.onError(0, "NoFill");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends wh9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final KsNativeAd a;
        public final /* synthetic */ ph9 b;

        public b(ph9 ph9Var, KsNativeAd ksNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph9Var, ksNativeAd};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ph9Var;
            this.a = ksNativeAd;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onClickListener)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view2, KsNativeAd ksNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ksNativeAd) == null) {
                this.b.e.onAdClick(this.a);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksNativeAd) == null) {
                this.b.e.onAdShow(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ph9(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.NATIVE), pid, true, true);
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
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new FunNativeAdListenerHelper<>(this);
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new ci9(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        KsNativeAd ksNativeAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || (ksNativeAd = (KsNativeAd) obj) == null) {
            return;
        }
        this.e.destroy(ksNativeAd);
    }

    public final com.fun.module.ks.x e(Context context, KsNativeAd ksNativeAd) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, ksNativeAd)) == null) {
            int materialType = ksNativeAd.getMaterialType();
            int i = R.layout.obfuscated_res_0x7f0d0368;
            if (materialType == 1) {
                int interactionType = ksNativeAd.getInteractionType();
                if (interactionType == 1) {
                    i = R.layout.obfuscated_res_0x7f0d0369;
                } else if (interactionType == 2) {
                    i = R.layout.obfuscated_res_0x7f0d036a;
                }
            } else if (materialType != 2) {
                if (materialType == 3) {
                    int interactionType2 = ksNativeAd.getInteractionType();
                    if (interactionType2 == 1) {
                        i = R.layout.obfuscated_res_0x7f0d0365;
                    } else if (interactionType2 == 2) {
                        i = R.layout.obfuscated_res_0x7f0d0366;
                    }
                }
            } else if (ksNativeAd.getInteractionType() == 1) {
                i = R.layout.obfuscated_res_0x7f0d0367;
            }
            com.fun.module.ks.x xVar = (com.fun.module.ks.x) LayoutInflater.from(context).inflate(i, (ViewGroup) null, false);
            xVar.a(ksNativeAd);
            return xVar;
        }
        return (com.fun.module.ks.x) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public double getAdBiddingPrices(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? ((KsNativeAd) obj).getECPM() / 100.0d : invokeL.doubleValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd getNativeAdInternal(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, obj)) == null) ? new ai9(context, (KsNativeAd) obj, str, this.mPid, this) : (FunNativeAd) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, str, obj)) == null) {
            KsNativeAd ksNativeAd = (KsNativeAd) obj;
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, ksNativeAd, new ai9(context, ksNativeAd, str, this.mPid, this), new rh9(this, this, ksNativeAd, context));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/content/Context;Lcom/kwad/sdk/api/KsNativeAd;Ljava/lang/String;Landroid/view/ViewGroup;Ljava/util/List<Landroid/view/View;>;Lcom/repackage/ph9$b;Lcom/fun/ad/sdk/FunAdInteractionListener;)V */
    public void i(KsNativeAd ksNativeAd, String str, ViewGroup viewGroup, List list, b bVar, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{ksNativeAd, str, viewGroup, list, bVar, funAdInteractionListener}) == null) {
            this.e.startShow(ksNativeAd, str, this.mPid, bVar, funAdInteractionListener);
            if (viewGroup instanceof FunNativeView) {
                viewGroup = ((FunNativeView) viewGroup).getRoot();
            }
            ksNativeAd.registerViewForInteraction(viewGroup, list, bVar);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, funAdSlot) == null) {
            KsScene build = new KsScene.Builder(Long.parseLong(this.mPid.pid)).adNum(NumberUtils.adjustInt(funAdSlot.getAdCount(), 1, 5)).build();
            if (funAdSlot.getExpressWidth() != 0 && funAdSlot.getExpressHeight() != 0) {
                build.setWidth(PxUtils.dp2px(funAdSlot.getExpressWidth()));
                build.setHeight(PxUtils.dp2px(funAdSlot.getExpressHeight()));
            }
            onLoadStart(funAdSlot);
            KsAdSDK.getLoadManager().loadNativeAd(build, new a(this));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void setAdBiddingResult(Object obj, double d, double d2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{obj, Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            KsNativeAd ksNativeAd = (KsNativeAd) obj;
            if (z) {
                ksNativeAd.setBidEcpm((int) (d2 * 100.0d));
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, activity, viewGroup, str, obj)) == null) {
            KsNativeAd ksNativeAd = (KsNativeAd) obj;
            onShowStart(ksNativeAd);
            com.fun.module.ks.x e = e(activity, ksNativeAd);
            ksNativeAd.registerViewForInteraction(e, e.getClickViews(), new qh9(this, ksNativeAd));
            viewGroup.removeAllViews();
            viewGroup.addView(e);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
