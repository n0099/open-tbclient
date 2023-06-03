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
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger g;
    public AtomicInteger h;
    public volatile VideoOption i;
    public volatile int j;
    public volatile int k;
    public volatile LoadAdParams l;
    public UnifiedInterstitialADListener m;
    public ServerSideVerificationOptions n;
    public final ADListenerAdapter o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, unifiedInterstitialADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new AtomicInteger(0);
        this.h = new AtomicInteger(0);
        this.m = unifiedInterstitialADListener;
        this.o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, unifiedInterstitialADListener, map, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = new AtomicInteger(0);
        this.h = new AtomicInteger(0);
        this.m = unifiedInterstitialADListener;
        this.o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        UIADI uiadi = (UIADI) obj;
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        UnifiedInterstitialADListener unifiedInterstitialADListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (unifiedInterstitialADListener = this.m) == null) {
            return;
        }
        unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVideoOption(this.i);
            setMinVideoDuration(this.j);
            setMaxVideoDuration(this.k);
            setLoadAdParams(this.l);
            setServerSideVerificationOptions(this.n);
            while (this.g.getAndDecrement() > 0) {
                loadAD();
            }
            while (this.h.getAndDecrement() > 0) {
                loadFullScreenAD();
            }
        }
    }

    public void close() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (t = this.a) == 0) {
            return;
        }
        ((UIADI) t).close();
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).destroy();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((UIADI) t).getAdPatternType();
            }
            a("getAdPatternType");
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((UIADI) t).getVideoDuration();
            }
            a("getVideoDuration");
            return 0;
        }
        return invokeV.intValue;
    }

    public void loadAD() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && a()) {
            if (!b()) {
                this.g.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && a()) {
            if (!b()) {
                this.h.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, loadAdParams) == null) {
            this.l = loadAdParams;
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).setLoadAdParams(this.l);
            }
        }
    }

    public void setMaxVideoDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.k = i;
            if (this.k > 0 && this.j > this.k) {
                GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).setMaxVideoDuration(i);
            }
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, unifiedInterstitialMediaListener) == null) {
            this.o.setMediaListener(unifiedInterstitialMediaListener);
        }
    }

    public void setMinVideoDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.j = i;
            if (this.k > 0 && this.j > this.k) {
                GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).setMinVideoDuration(i);
            }
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, negativeFeedbackListener) == null) {
            this.o.setNegativeFeedbackListener(negativeFeedbackListener);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aDRewardListener) == null) {
            this.o.setAdRewardListener(aDRewardListener);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, serverSideVerificationOptions) == null) {
            this.n = serverSideVerificationOptions;
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
            }
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, videoOption) == null) {
            this.i = videoOption;
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).setVideoOption(videoOption);
            }
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            T t = this.a;
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
            T t = this.a;
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
            T t = this.a;
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
            T t = this.a;
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
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).showFullScreenAD(activity);
            } else {
                a("showFullScreenAD");
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, pOFactory, str, str2, str3)) == null) {
            return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.o);
        }
        return invokeLLLLL.objValue;
    }
}
