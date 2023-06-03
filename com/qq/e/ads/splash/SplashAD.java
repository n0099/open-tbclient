package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ViewGroup g;
    public volatile SplashADListener h;
    public volatile ADRewardListener i;
    public volatile LoadAdParams j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile int n;
    public volatile byte[] o;
    public volatile ServerSideVerificationOptions p;
    public int q;

    /* renamed from: com.qq.e.ads.splash.SplashAD$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public class ADListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SplashAD a;

        public ADListenerAdapter(SplashAD splashAD) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAD};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = splashAD;
        }

        public /* synthetic */ ADListenerAdapter(SplashAD splashAD, AnonymousClass1 anonymousClass1) {
            this(splashAD);
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) {
                if (this.a.h == null) {
                    GDTLogger.d("SplashADListener == null");
                    return;
                }
                int type = aDEvent.getType();
                switch (type) {
                    case 100:
                        Long l = (Long) aDEvent.getParam(Long.class);
                        if (l != null) {
                            this.a.h.onADLoaded(l.longValue());
                            return;
                        }
                        return;
                    case 101:
                        Integer num = (Integer) aDEvent.getParam(Integer.class);
                        if (num != null) {
                            this.a.h.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                            return;
                        }
                        return;
                    case 102:
                        this.a.h.onADPresent();
                        return;
                    case 103:
                        this.a.h.onADExposure();
                        return;
                    case 104:
                        if (this.a.i == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("transId", str);
                        this.a.i.onReward(hashMap);
                        return;
                    case 105:
                        this.a.h.onADClicked();
                        return;
                    case 106:
                        this.a.h.onADDismissed();
                        return;
                    default:
                        switch (type) {
                            case 112:
                                Long l2 = (Long) aDEvent.getParam(Long.class);
                                if (l2 != null) {
                                    this.a.h.onADTick(l2.longValue());
                                    return;
                                }
                                return;
                            case 113:
                                if (this.a.h instanceof SplashADZoomOutListener) {
                                    ((SplashADZoomOutListener) this.a.h).onZoomOut();
                                    return;
                                }
                                return;
                            case 114:
                                if (this.a.h instanceof SplashADZoomOutListener) {
                                    ((SplashADZoomOutListener) this.a.h).onZoomOutPlayFinish();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (SplashADListener) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = false;
        this.h = splashADListener;
        this.q = i;
        a(context, str);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = false;
        this.h = splashADListener;
        this.q = i;
        a(context, str, str2);
    }

    private void a(ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, viewGroup, z) == null) {
            if (viewGroup == null) {
                GDTLogger.e("传入参数有误：传入container参数为空");
                a(4001);
                return;
            }
            T t = this.a;
            if (t == 0) {
                this.m = z;
                this.g = viewGroup;
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAndShowIn(viewGroup);
            } else {
                nspvi.fetchAndShowIn(viewGroup);
            }
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65541, this, z) == null) && a()) {
            if (!b()) {
                this.m = z;
                this.l = true;
                return;
            }
            T t = this.a;
            if (t == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void b(ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, this, viewGroup, z) == null) {
            if (viewGroup == null) {
                GDTLogger.e("传入参数错误，container参数为空");
                a(4001);
                return;
            }
            T t = this.a;
            if (t == 0) {
                this.g = viewGroup;
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.showFullScreenAd(viewGroup);
            } else {
                nspvi.showAd(viewGroup);
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.h == null) {
            return;
        }
        this.h.onNoAD(AdErrorConvertor.formatErrorCode(i));
    }

    public void fetchAdOnly() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a(false);
        }
    }

    public void fetchAndShowIn(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) {
            a(viewGroup, false);
        }
    }

    public void fetchFullScreenAdOnly() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a(true);
        }
    }

    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewGroup) == null) {
            a(viewGroup, true);
        }
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((NSPVI) t).getAdNetWorkName();
            }
            a("getAdNetWorkName");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public Bitmap getZoomOutBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((NSPVI) t).getZoomOutBitmap();
            }
            a("getZoomOutBitmap");
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public void preLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && a()) {
            if (!b()) {
                this.k = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((NSPVI) t).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
        }
    }

    public void setDeveloperLogo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            T t = this.a;
            if (t == 0) {
                this.n = i;
            } else {
                ((NSPVI) t).setDeveloperLogo(i);
            }
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bArr) == null) {
            T t = this.a;
            if (t == 0) {
                this.o = bArr;
            } else {
                ((NSPVI) t).setDeveloperLogo(bArr);
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, loadAdParams) == null) {
            T t = this.a;
            if (t != 0) {
                ((NSPVI) t).setLoadAdParams(loadAdParams);
            } else {
                this.j = loadAdParams;
            }
        }
    }

    @Deprecated
    public void setPreloadView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aDRewardListener) == null) {
            this.i = aDRewardListener;
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, serverSideVerificationOptions) == null) {
            this.p = serverSideVerificationOptions;
            T t = this.a;
            if (t != 0) {
                ((NSPVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
            }
        }
    }

    public void showAd(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, viewGroup) == null) {
            b(viewGroup, false);
        }
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, viewGroup) == null) {
            b(viewGroup, true);
        }
    }

    public void zoomOutAnimationFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            T t = this.a;
            if (t != 0) {
                ((NSPVI) t).zoomOutAnimationFinish();
            } else {
                a("zoomOutAnimationFinish");
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, pOFactory, str, str2, str3)) == null) {
            return pOFactory.getNativeSplashAdView(context, str, str2, str3);
        }
        return invokeLLLLL.objValue;
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            NSPVI nspvi = (NSPVI) obj;
            if (this.j != null) {
                nspvi.setLoadAdParams(this.j);
            }
            if (this.n != 0) {
                nspvi.setDeveloperLogo(this.n);
            }
            if (this.o != null) {
                nspvi.setDeveloperLogo(this.o);
            }
            nspvi.setFetchDelay(this.q);
            nspvi.setAdListener(new ADListenerAdapter(this, null));
            nspvi.setServerSideVerificationOptions(this.p);
            if ((this.h instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.h).isSupportZoomOut()) {
                nspvi.setSupportZoomOut(true);
            }
            if (this.g != null) {
                if (this.m) {
                    fetchFullScreenAndShowIn(this.g);
                } else {
                    fetchAndShowIn(this.g);
                }
            }
            if (this.k) {
                nspvi.preload();
                this.k = false;
            }
            if (this.l) {
                if (this.m) {
                    nspvi.fetchFullScreenAdOnly();
                } else {
                    nspvi.fetchAdOnly();
                }
                this.l = false;
            }
        }
    }
}
