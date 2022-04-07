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
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
/* loaded from: classes5.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EVENT_TYPE_AD_CLICKED = 4;
    public static final int EVENT_TYPE_AD_DISMISSED = 1;
    public static final int EVENT_TYPE_AD_EXPOSURE = 6;
    public static final int EVENT_TYPE_AD_LOADED = 7;
    public static final int EVENT_TYPE_AD_PRESENT = 3;
    public static final int EVENT_TYPE_AD_TICK = 5;
    public static final int EVENT_TYPE_AD_ZOOM_OUT = 8;
    public static final int EVENT_TYPE_AD_ZOOM_OUT_PLAY_FINISH = 9;
    public static final int EVENT_TYPE_NO_AD = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ViewGroup g;
    public volatile SplashADListener h;
    public volatile LoadAdParams i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile int m;
    public volatile byte[] n;
    public View o;
    public int p;
    public View q;

    /* renamed from: com.qq.e.ads.splash.SplashAD$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) {
                if (this.a.h == null) {
                    GDTLogger.d("SplashADListener == null");
                    return;
                }
                Object[] paras = aDEvent.getParas();
                switch (aDEvent.getType()) {
                    case 1:
                        this.a.h.onADDismissed();
                        return;
                    case 2:
                        if (paras.length <= 0 || !(paras[0] instanceof Integer)) {
                            AbstractAD.a(SplashAD.class, aDEvent);
                            return;
                        } else {
                            this.a.h.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) paras[0]).intValue()));
                            return;
                        }
                    case 3:
                        this.a.h.onADPresent();
                        return;
                    case 4:
                        this.a.h.onADClicked();
                        return;
                    case 5:
                        if (paras.length == 1 && (paras[0] instanceof Long)) {
                            this.a.h.onADTick(((Long) paras[0]).longValue());
                            return;
                        } else {
                            AbstractAD.a(SplashAD.class, aDEvent);
                            return;
                        }
                    case 6:
                        this.a.h.onADExposure();
                        return;
                    case 7:
                        if (paras.length == 1 && (paras[0] instanceof Long)) {
                            this.a.h.onADLoaded(((Long) paras[0]).longValue());
                            return;
                        } else {
                            AbstractAD.a(SplashAD.class, aDEvent);
                            return;
                        }
                    case 8:
                        if (this.a.h instanceof SplashADZoomOutListener) {
                            ((SplashADZoomOutListener) this.a.h).onZoomOut();
                            return;
                        }
                        return;
                    case 9:
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SplashAD(Context context, View view2, String str, SplashADListener splashADListener, int i) {
        this(context, view2, str, splashADListener, i, (View) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, str, splashADListener, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue(), (View) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SplashAD(Context context, View view2, String str, SplashADListener splashADListener, int i, View view3) {
        this(context, view2, str, splashADListener, i, (Map) null, view3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, str, splashADListener, Integer.valueOf(i), view3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue(), (Map) objArr2[5], (View) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Deprecated
    public SplashAD(Context context, View view2, String str, SplashADListener splashADListener, int i, Map map, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, str, splashADListener, Integer.valueOf(i), map, view3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.j = false;
        this.h = splashADListener;
        this.o = view2;
        this.p = i;
        this.q = view3;
        a(context, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SplashAD(Context context, View view2, String str, String str2, SplashADListener splashADListener, int i) {
        this(context, view2, str, str2, splashADListener, i, (View) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, str, str2, splashADListener, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (String) objArr2[3], (SplashADListener) objArr2[4], ((Integer) objArr2[5]).intValue(), (View) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SplashAD(Context context, View view2, String str, String str2, SplashADListener splashADListener, int i, View view3) {
        this(context, view2, str, str2, splashADListener, i, null, view3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, str, str2, splashADListener, Integer.valueOf(i), view3};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (String) objArr2[3], (SplashADListener) objArr2[4], ((Integer) objArr2[5]).intValue(), (Map) objArr2[6], (View) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SplashAD(Context context, View view2, String str, String str2, SplashADListener splashADListener, int i, Map map, View view3) {
        this(context, view2, str2, splashADListener, i, map, view3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, str, str2, splashADListener, Integer.valueOf(i), map, view3};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue(), (Map) objArr2[5], (View) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener};
            interceptable.invokeUnInit(65542, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (SplashADListener) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAD(Context context, String str, SplashADListener splashADListener, int i) {
        this(context, (View) null, str, splashADListener, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener, Integer.valueOf(i)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAD(Context context, String str, SplashADListener splashADListener, int i, View view2) {
        this(context, (View) null, str, splashADListener, i, (Map) null, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener, Integer.valueOf(i), view2};
            interceptable.invokeUnInit(65544, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue(), (Map) objArr2[5], (View) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65544, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAD(Context context, String str, SplashADListener splashADListener, int i, Map map, View view2) {
        this(context, (View) null, str, splashADListener, i, map, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener, Integer.valueOf(i), map, view2};
            interceptable.invokeUnInit(65545, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue(), (Map) objArr2[5], (View) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65545, newInitContext);
                return;
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i, Map map, View view2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener, Integer.valueOf(i), map, view2, str2};
            interceptable.invokeUnInit(65546, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65546, newInitContext);
                return;
            }
        }
        this.j = false;
        this.h = splashADListener;
        this.p = i;
        this.q = view2;
        a(context, str, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SplashAD(Context context, String str, String str2, SplashADListener splashADListener) {
        this(context, str, str2, splashADListener, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, splashADListener};
            interceptable.invokeUnInit(65547, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65547, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SplashAD(Context context, String str, String str2, SplashADListener splashADListener, int i) {
        this(context, (View) null, str, str2, splashADListener, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, splashADListener, Integer.valueOf(i)};
            interceptable.invokeUnInit(65548, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (String) objArr2[3], (SplashADListener) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65548, newInitContext);
                return;
            }
        }
    }

    private void a(ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, this, viewGroup, z) == null) {
            if (viewGroup == null) {
                GDTLogger.e("传入参数有误：传入container参数为空");
                a(4001);
                return;
            }
            T t = this.a;
            if (t == 0) {
                this.l = z;
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
        if ((interceptable == null || interceptable.invokeZ(65551, this, z) == null) && a()) {
            if (!b()) {
                this.l = z;
                this.k = true;
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
        if (interceptable == null || interceptable.invokeLZ(65552, this, viewGroup, z) == null) {
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
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, pOFactory, str, str2, str3)) == null) ? pOFactory.getNativeSplashAdView(context, str, str2, str3) : invokeLLLLL.objValue;
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

    public Map getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            T t = this.a;
            if (t != 0) {
                NSPVI nspvi = (NSPVI) t;
                return NSPVI.ext;
            }
            a("getExt");
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public Bitmap getZoomOutBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && a()) {
            if (!b()) {
                this.j = true;
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
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
        }
    }

    public void setDeveloperLogo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            T t = this.a;
            if (t == 0) {
                this.m = i;
            } else {
                ((NSPVI) t).setDeveloperLogo(i);
            }
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            T t = this.a;
            if (t == 0) {
                this.n = bArr;
            } else {
                ((NSPVI) t).setDeveloperLogo(bArr);
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, loadAdParams) == null) {
            T t = this.a;
            if (t != 0) {
                ((NSPVI) t).setLoadAdParams(loadAdParams);
            } else {
                this.i = loadAdParams;
            }
        }
    }

    @Deprecated
    public void setPreloadView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
        }
    }

    public void showAd(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, viewGroup) == null) {
            b(viewGroup, false);
        }
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, viewGroup) == null) {
            b(viewGroup, true);
        }
    }

    public void zoomOutAnimationFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            T t = this.a;
            if (t != 0) {
                ((NSPVI) t).zoomOutAnimationFinish();
            } else {
                a("zoomOutAnimationFinish");
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            NSPVI nspvi = (NSPVI) obj;
            if (this.i != null) {
                nspvi.setLoadAdParams(this.i);
            }
            if (this.m != 0) {
                nspvi.setDeveloperLogo(this.m);
            }
            if (this.n != null) {
                nspvi.setDeveloperLogo(this.n);
            }
            nspvi.setFetchDelay(this.p);
            nspvi.setAdListener(new ADListenerAdapter(this, null));
            nspvi.setSkipView(this.o);
            nspvi.setFloatView(this.q);
            if ((this.h instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.h).isSupportZoomOut()) {
                nspvi.setSupportZoomOut(true);
            }
            if (this.g != null) {
                if (this.l) {
                    fetchFullScreenAndShowIn(this.g);
                } else {
                    fetchAndShowIn(this.g);
                }
            }
            if (this.j) {
                nspvi.preload();
                this.j = false;
            }
            if (this.k) {
                if (this.l) {
                    nspvi.fetchFullScreenAdOnly();
                } else {
                    nspvi.fetchAdOnly();
                }
                this.k = false;
            }
        }
    }
}
