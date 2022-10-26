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
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class UnifiedBannerAD extends LiteAbstractAD {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UnifiedBannerADListener g;
    public DownAPPConfirmPolicy h;
    public AtomicInteger i;
    public int j;
    public LoadAdParams k;
    public UnifiedBannerView l;

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, unifiedBannerView, str, unifiedBannerADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new AtomicInteger(0);
        this.j = 30;
        this.k = null;
        this.g = unifiedBannerADListener;
        this.l = unifiedBannerView;
        a(activity, str);
    }

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, unifiedBannerView, str, str2, unifiedBannerADListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new AtomicInteger(0);
        this.j = 30;
        this.k = null;
        this.g = unifiedBannerADListener;
        this.l = unifiedBannerView;
        a(activity, str, str2);
    }

    public void a(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downAPPConfirmPolicy) == null) {
            this.h = downAPPConfirmPolicy;
            if (downAPPConfirmPolicy == null || (obj = this.a) == null) {
                return;
            }
            ((UBVI) obj).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        d();
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
            Object obj = this.a;
            if (obj != null) {
                ((UBVI) obj).setRefresh(i);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Object obj = this.a;
            if (obj != null) {
                ((UBVI) obj).destroy();
            } else {
                a("destroy");
            }
        }
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Object obj = this.a;
            if (obj != null) {
                return ((UBVI) obj).getAdNetWorkName();
            }
            a("getAdNetWorkName");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public Map getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Object obj = this.a;
            if (obj != null) {
                UBVI ubvi = (UBVI) obj;
                return UBVI.ext;
            }
            a("getExt");
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public void loadAD() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && a()) {
            if (!b()) {
                this.i.incrementAndGet();
                return;
            }
            Object obj = this.a;
            if (obj != null) {
                ((UBVI) obj).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (obj = this.a) == null) {
            return;
        }
        ((UBVI) obj).onWindowFocusChanged(z);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, loadAdParams) == null) {
            this.k = loadAdParams;
            Object obj = this.a;
            if (obj != null) {
                ((UBVI) obj).setLoadAdParams(loadAdParams);
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, pOFactory, str, str2, str3)) == null) {
            return pOFactory.getUnifiedBannerViewDelegate(this.l, (Activity) context, str, str2, str3, this.g);
        }
        return invokeLLLLL.objValue;
    }

    public void d() {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            DownAPPConfirmPolicy downAPPConfirmPolicy = this.h;
            if (downAPPConfirmPolicy != null) {
                this.h = downAPPConfirmPolicy;
                if (downAPPConfirmPolicy != null && (obj = this.a) != null) {
                    ((UBVI) obj).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
                }
            }
            int i = this.j;
            this.j = i;
            Object obj2 = this.a;
            if (obj2 != null) {
                ((UBVI) obj2).setRefresh(i);
            }
            LoadAdParams loadAdParams = this.k;
            this.k = loadAdParams;
            Object obj3 = this.a;
            if (obj3 != null) {
                ((UBVI) obj3).setLoadAdParams(loadAdParams);
            }
            while (this.i.getAndDecrement() > 0) {
                loadAD();
            }
        }
    }
}
