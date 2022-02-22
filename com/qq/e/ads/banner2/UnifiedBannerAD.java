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
/* loaded from: classes4.dex */
public class UnifiedBannerAD extends LiteAbstractAD<UBVI> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public UnifiedBannerADListener f59154g;

    /* renamed from: h  reason: collision with root package name */
    public DownAPPConfirmPolicy f59155h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicInteger f59156i;

    /* renamed from: j  reason: collision with root package name */
    public int f59157j;
    public LoadAdParams k;
    public UnifiedBannerView l;

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, unifiedBannerView, str, unifiedBannerADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59156i = new AtomicInteger(0);
        this.f59157j = 30;
        this.k = null;
        this.f59154g = unifiedBannerADListener;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59156i = new AtomicInteger(0);
        this.f59157j = 30;
        this.k = null;
        this.f59154g = unifiedBannerADListener;
        this.l = unifiedBannerView;
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, pOFactory, str, str2, str3)) == null) ? pOFactory.getUnifiedBannerViewDelegate(this.l, (Activity) context, str, str2, str3, this.f59154g) : invokeLLLLL.objValue;
    }

    public void a(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downAPPConfirmPolicy) == null) {
            this.f59155h = downAPPConfirmPolicy;
            if (downAPPConfirmPolicy == null || (t = this.a) == 0) {
                return;
            }
            ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        d();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        UnifiedBannerADListener unifiedBannerADListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (unifiedBannerADListener = this.f59154g) == null) {
            return;
        }
        unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f59157j = i2;
            T t = this.a;
            if (t != 0) {
                ((UBVI) t).setRefresh(i2);
            }
        }
    }

    public void d() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            DownAPPConfirmPolicy downAPPConfirmPolicy = this.f59155h;
            if (downAPPConfirmPolicy != null) {
                this.f59155h = downAPPConfirmPolicy;
                if (downAPPConfirmPolicy != null && (t = this.a) != 0) {
                    ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
                }
            }
            int i2 = this.f59157j;
            this.f59157j = i2;
            T t2 = this.a;
            if (t2 != 0) {
                ((UBVI) t2).setRefresh(i2);
            }
            LoadAdParams loadAdParams = this.k;
            this.k = loadAdParams;
            T t3 = this.a;
            if (t3 != 0) {
                ((UBVI) t3).setLoadAdParams(loadAdParams);
            }
            while (this.f59156i.getAndDecrement() > 0) {
                loadAD();
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((UBVI) t).getAdNetWorkName();
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
            T t = this.a;
            if (t != 0) {
                UBVI ubvi = (UBVI) t;
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
                this.f59156i.incrementAndGet();
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
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (t = this.a) == 0) {
            return;
        }
        ((UBVI) t).onWindowFocusChanged(z);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, loadAdParams) == null) {
            this.k = loadAdParams;
            T t = this.a;
            if (t != 0) {
                ((UBVI) t).setLoadAdParams(loadAdParams);
            }
        }
    }
}
