package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UnifiedBannerADListener g;
    public DownAPPConfirmPolicy h;
    public AtomicInteger i;
    public int j;
    public LoadAdParams k;
    public UnifiedBannerView l;
    public final ADListenerAdapter m;
    public volatile ServerSideVerificationOptions n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, unifiedBannerView, str, unifiedBannerADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((UnifiedBannerView) objArr2[0], (UnifiedBannerADListener) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(activity, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, unifiedBannerView, str, str2, unifiedBannerADListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((UnifiedBannerView) objArr2[0], (UnifiedBannerADListener) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(activity, str, str2);
    }

    public UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {unifiedBannerView, unifiedBannerADListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = new AtomicInteger(0);
        this.j = 30;
        this.k = null;
        this.g = unifiedBannerADListener;
        this.l = unifiedBannerView;
        this.m = new ADListenerAdapter(unifiedBannerADListener);
    }

    public void a(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downAPPConfirmPolicy) == null) {
            this.h = downAPPConfirmPolicy;
            if (downAPPConfirmPolicy == null || (t = this.a) == 0) {
                return;
            }
            ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        UnifiedBannerADListener unifiedBannerADListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (unifiedBannerADListener = this.g) == null) {
            return;
        }
        unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.j = i;
            T t = this.a;
            if (t != 0) {
                ((UBVI) t).setRefresh(i);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            T t = this.a;
            if (t != 0) {
                ((UBVI) t).destroy();
            } else {
                a("destroy");
            }
        }
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((UBVI) t).getAdNetWorkName();
            }
            a("getAdNetWorkName");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void loadAD() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && a()) {
            if (!b()) {
                this.i.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UBVI) t).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (t = this.a) == 0) {
            return;
        }
        ((UBVI) t).onWindowFocusChanged(z);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, loadAdParams) == null) {
            this.k = loadAdParams;
            T t = this.a;
            if (t != 0) {
                ((UBVI) t).setLoadAdParams(loadAdParams);
            }
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, negativeFeedbackListener) == null) {
            this.m.setNegativeFeedbackListener(negativeFeedbackListener);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aDRewardListener) == null) {
            this.m.setAdRewardListener(aDRewardListener);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, serverSideVerificationOptions) == null) {
            this.n = serverSideVerificationOptions;
            T t = this.a;
            if (t != 0) {
                ((UBVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, pOFactory, str, str2, str3)) == null) {
            return pOFactory.getUnifiedBannerViewDelegate(this.l, (Activity) context, str, str2, str3, this.m);
        }
        return invokeLLLLL.objValue;
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            UBVI ubvi = (UBVI) obj;
            DownAPPConfirmPolicy downAPPConfirmPolicy = this.h;
            if (downAPPConfirmPolicy != null) {
                this.h = downAPPConfirmPolicy;
                T t = this.a;
                if (t != 0) {
                    ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
                }
            }
            int i = this.j;
            this.j = i;
            T t2 = this.a;
            if (t2 != 0) {
                ((UBVI) t2).setRefresh(i);
            }
            LoadAdParams loadAdParams = this.k;
            this.k = loadAdParams;
            T t3 = this.a;
            if (t3 != 0) {
                ((UBVI) t3).setLoadAdParams(loadAdParams);
            }
            ubvi.setServerSideVerificationOptions(this.n);
            while (this.i.getAndDecrement() > 0) {
                loadAD();
            }
        }
    }
}
