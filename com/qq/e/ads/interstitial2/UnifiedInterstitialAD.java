package com.qq.e.ads.interstitial2;

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
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f74986b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicInteger f74987c;

    /* renamed from: d  reason: collision with root package name */
    public volatile UnifiedInterstitialMediaListener f74988d;

    /* renamed from: e  reason: collision with root package name */
    public volatile VideoOption f74989e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f74990f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f74991g;

    /* renamed from: h  reason: collision with root package name */
    public UnifiedInterstitialADListener f74992h;

    /* renamed from: i  reason: collision with root package name */
    public volatile ADRewardListener f74993i;

    /* renamed from: j  reason: collision with root package name */
    public ServerSideVerificationOptions f74994j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, (Map) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, unifiedInterstitialADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (String) objArr2[1], (UnifiedInterstitialADListener) objArr2[2], (Map) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, unifiedInterstitialADListener, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f74986b = new AtomicInteger(0);
        this.f74987c = new AtomicInteger(0);
        this.f74992h = unifiedInterstitialADListener;
        a(activity, str);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, unifiedInterstitialADListener, map, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f74986b = new AtomicInteger(0);
        this.f74987c = new AtomicInteger(0);
        this.f74992h = unifiedInterstitialADListener;
        a(activity, str, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, str2, unifiedInterstitialADListener, (Map) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, unifiedInterstitialADListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (String) objArr2[1], (String) objArr2[2], (UnifiedInterstitialADListener) objArr2[3], (Map) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this(activity, str2, unifiedInterstitialADListener, map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, unifiedInterstitialADListener, map};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (String) objArr2[1], (UnifiedInterstitialADListener) objArr2[2], (Map) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.f74992h);
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ void a(Object obj) {
        setVideoOption(this.f74989e);
        setMediaListener(this.f74988d);
        setMinVideoDuration(this.f74990f);
        setMaxVideoDuration(this.f74991g);
        setRewardListener(this.f74993i);
        setServerSideVerificationOptions(this.f74994j);
        while (this.f74986b.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.f74987c.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public final void b(int i2) {
        UnifiedInterstitialADListener unifiedInterstitialADListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (unifiedInterstitialADListener = this.f74992h) == null) {
            return;
        }
        unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
    }

    public void close() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (t = this.f74912a) == 0) {
            return;
        }
        ((UIADI) t).close();
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).destory();
            } else {
                a("destroy");
            }
        }
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.f74912a;
            if (t != 0) {
                return ((UIADI) t).getAdNetWorkName();
            }
            a("getAdNetWorkName");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getAdPatternType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.f74912a;
            if (t != 0) {
                return ((UIADI) t).getAdPatternType();
            }
            a("getAdPatternType");
            return 0;
        }
        return invokeV.intValue;
    }

    public Map getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f74912a != 0) {
                return UIADI.ext;
            }
            a("getExt");
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            T t = this.f74912a;
            if (t != 0) {
                return ((UIADI) t).getVideoDuration();
            }
            a("getVideoDuration");
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            T t = this.f74912a;
            if (t != 0) {
                return ((UIADI) t).isValid();
            }
            a("isValid");
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadAD() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && b()) {
            if (!a()) {
                this.f74986b.incrementAndGet();
                return;
            }
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && b()) {
            if (!a()) {
                this.f74987c.incrementAndGet();
                return;
            }
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setMaxVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f74991g = i2;
            if (this.f74991g > 0 && this.f74990f > this.f74991g) {
                GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
            }
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).setMaxVideoDuration(i2);
            }
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, unifiedInterstitialMediaListener) == null) {
            this.f74988d = unifiedInterstitialMediaListener;
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).setMediaListener(unifiedInterstitialMediaListener);
            }
        }
    }

    public void setMinVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f74990f = i2;
            if (this.f74991g > 0 && this.f74990f > this.f74991g) {
                GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
            }
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).setMinVideoDuration(i2);
            }
        }
    }

    public void setRewardListener(ADRewardListener aDRewardListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aDRewardListener) == null) {
            this.f74993i = aDRewardListener;
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).setRewardListener(aDRewardListener);
            }
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, serverSideVerificationOptions) == null) {
            this.f74994j = serverSideVerificationOptions;
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
            }
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, videoOption) == null) {
            this.f74989e = videoOption;
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).setVideoOption(videoOption);
            }
        }
    }

    @Deprecated
    public void setVideoPlayPolicy(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).show();
            } else {
                a("show");
            }
        }
    }

    public void show(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, activity) == null) {
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).show(activity);
            } else {
                a("show");
            }
        }
    }

    public void showAsPopupWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).showAsPopupWindow();
            } else {
                a("showAsPopupWindow");
            }
        }
    }

    public void showAsPopupWindow(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, activity) == null) {
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).showAsPopupWindow(activity);
            } else {
                a("showAsPopupWindow");
            }
        }
    }

    public void showFullScreenAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, activity) == null) {
            T t = this.f74912a;
            if (t != 0) {
                ((UIADI) t).showFullScreenAD(activity);
            } else {
                a("showFullScreenAD");
            }
        }
    }
}
