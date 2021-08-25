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
/* loaded from: classes10.dex */
public class UnifiedBannerAD extends LiteAbstractAD<UBVI> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public UnifiedBannerADListener f74929b;

    /* renamed from: c  reason: collision with root package name */
    public DownAPPConfirmPolicy f74930c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f74931d;

    /* renamed from: e  reason: collision with root package name */
    public int f74932e;

    /* renamed from: f  reason: collision with root package name */
    public LoadAdParams f74933f;

    /* renamed from: g  reason: collision with root package name */
    public UnifiedBannerView f74934g;

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
        this.f74931d = new AtomicInteger(0);
        this.f74932e = 30;
        this.f74933f = null;
        this.f74929b = unifiedBannerADListener;
        this.f74934g = unifiedBannerView;
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
        this.f74931d = new AtomicInteger(0);
        this.f74932e = 30;
        this.f74933f = null;
        this.f74929b = unifiedBannerADListener;
        this.f74934g = unifiedBannerView;
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.f74934g, (Activity) context, str, str2, str3, this.f74929b);
    }

    public final void a(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downAPPConfirmPolicy) == null) {
            this.f74930c = downAPPConfirmPolicy;
            if (downAPPConfirmPolicy == null || (t = this.f74912a) == 0) {
                return;
            }
            ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    public final void a(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, loadAdParams) == null) {
            this.f74933f = loadAdParams;
            T t = this.f74912a;
            if (t != 0) {
                ((UBVI) t).setLoadAdParams(loadAdParams);
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ void a(Object obj) {
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f74930c;
        if (downAPPConfirmPolicy != null) {
            a(downAPPConfirmPolicy);
        }
        c(this.f74932e);
        a(this.f74933f);
        while (this.f74931d.getAndDecrement() > 0) {
            d();
        }
    }

    public final void a(boolean z) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (t = this.f74912a) == 0) {
            return;
        }
        ((UBVI) t).onWindowFocusChanged(z);
    }

    @Override // com.qq.e.ads.AbstractAD
    public final void b(int i2) {
        UnifiedBannerADListener unifiedBannerADListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (unifiedBannerADListener = this.f74929b) == null) {
            return;
        }
        unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f74932e = i2;
            T t = this.f74912a;
            if (t != 0) {
                ((UBVI) t).setRefresh(i2);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && b()) {
            if (!a()) {
                this.f74931d.incrementAndGet();
                return;
            }
            T t = this.f74912a;
            if (t != 0) {
                ((UBVI) t).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    public final Map e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f74912a != 0) {
                return UBVI.ext;
            }
            a("getExt");
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            T t = this.f74912a;
            if (t != 0) {
                ((UBVI) t).destroy();
            } else {
                a("destroy");
            }
        }
    }
}
