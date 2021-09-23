package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes10.dex */
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

    /* renamed from: b  reason: collision with root package name */
    public volatile ViewGroup f75585b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SplashADListener f75586c;

    /* renamed from: d  reason: collision with root package name */
    public volatile LoadAdParams f75587d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f75588e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f75589f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f75590g;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f75591h;

    /* renamed from: i  reason: collision with root package name */
    public volatile byte[] f75592i;

    /* renamed from: j  reason: collision with root package name */
    public View f75593j;
    public int k;
    public View l;

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

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ SplashAD f75594a;

        public ADListenerAdapter(SplashAD splashAD) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAD};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75594a = splashAD;
        }

        public /* synthetic */ ADListenerAdapter(SplashAD splashAD, byte b2) {
            this(splashAD);
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) {
                if (this.f75594a.f75586c == null) {
                    GDTLogger.d("SplashADListener == null");
                    return;
                }
                Object[] paras = aDEvent.getParas();
                switch (aDEvent.getType()) {
                    case 1:
                        this.f75594a.f75586c.onADDismissed();
                        return;
                    case 2:
                        if (paras.length <= 0 || !(paras[0] instanceof Integer)) {
                            AbstractAD.a(SplashAD.class, aDEvent);
                            return;
                        } else {
                            this.f75594a.f75586c.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) paras[0]).intValue()));
                            return;
                        }
                    case 3:
                        this.f75594a.f75586c.onADPresent();
                        return;
                    case 4:
                        this.f75594a.f75586c.onADClicked();
                        return;
                    case 5:
                        if (paras.length == 1 && (paras[0] instanceof Long)) {
                            this.f75594a.f75586c.onADTick(((Long) paras[0]).longValue());
                            return;
                        } else {
                            AbstractAD.a(SplashAD.class, aDEvent);
                            return;
                        }
                    case 6:
                        this.f75594a.f75586c.onADExposure();
                        return;
                    case 7:
                        if (paras.length == 1 && (paras[0] instanceof Long)) {
                            this.f75594a.f75586c.onADLoaded(((Long) paras[0]).longValue());
                            return;
                        } else {
                            AbstractAD.a(SplashAD.class, aDEvent);
                            return;
                        }
                    case 8:
                        if (this.f75594a.f75586c instanceof SplashADZoomOutListener) {
                            ((SplashADZoomOutListener) this.f75594a.f75586c).onZoomOut();
                            return;
                        }
                        return;
                    case 9:
                        if (this.f75594a.f75586c instanceof SplashADZoomOutListener) {
                            ((SplashADZoomOutListener) this.f75594a.f75586c).onZoomOutPlayFinish();
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
    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i2) {
        this(context, view, str, splashADListener, i2, (View) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, str, splashADListener, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i2, View view2) {
        this(context, view, str, splashADListener, i2, (Map) null, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, str, splashADListener, Integer.valueOf(i2), view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue(), (Map) objArr2[5], (View) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i2, Map map, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, str, splashADListener, Integer.valueOf(i2), map, view2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f75588e = false;
        this.f75586c = splashADListener;
        this.f75593j = view;
        this.k = i2;
        this.l = view2;
        a(context, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i2) {
        this(context, view, str, str2, splashADListener, i2, (View) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, str, str2, splashADListener, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i2, View view2) {
        this(context, view, str, str2, splashADListener, i2, null, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, str, str2, splashADListener, Integer.valueOf(i2), view2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i2, Map map, View view2) {
        this(context, view, str2, splashADListener, i2, map, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, str, str2, splashADListener, Integer.valueOf(i2), map, view2};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue(), (Map) objArr2[5], (View) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
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
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (SplashADListener) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2) {
        this(context, (View) null, str, splashADListener, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2, View view) {
        this(context, (View) null, str, splashADListener, i2, (Map) null, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener, Integer.valueOf(i2), view};
            interceptable.invokeUnInit(65544, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue(), (Map) objArr2[5], (View) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65544, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2, Map map, View view) {
        this(context, (View) null, str, splashADListener, i2, map, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener, Integer.valueOf(i2), map, view};
            interceptable.invokeUnInit(65545, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue(), (Map) objArr2[5], (View) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65545, newInitContext);
                return;
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2, Map map, View view, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashADListener, Integer.valueOf(i2), map, view, str2};
            interceptable.invokeUnInit(65546, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65546, newInitContext);
                return;
            }
        }
        this.f75588e = false;
        this.f75586c = splashADListener;
        this.k = i2;
        this.l = view;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public SplashAD(Context context, String str, String str2, SplashADListener splashADListener, int i2) {
        this(context, (View) null, str, str2, splashADListener, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, splashADListener, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65548, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
            T t = this.f75411a;
            if (t == 0) {
                this.f75590g = z;
                this.f75585b = viewGroup;
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
        if ((interceptable == null || interceptable.invokeZ(65551, this, z) == null) && b()) {
            if (!a()) {
                this.f75590g = z;
                this.f75589f = true;
                return;
            }
            T t = this.f75411a;
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
            T t = this.f75411a;
            if (t == 0) {
                this.f75585b = viewGroup;
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
    public final /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.f75587d != null) {
            nspvi.setLoadAdParams(this.f75587d);
        }
        if (this.f75591h != 0) {
            nspvi.setDeveloperLogo(this.f75591h);
        }
        if (this.f75592i != null) {
            nspvi.setDeveloperLogo(this.f75592i);
        }
        nspvi.setFetchDelay(this.k);
        nspvi.setAdListener(new ADListenerAdapter(this, (byte) 0));
        nspvi.setSkipView(this.f75593j);
        nspvi.setFloatView(this.l);
        if ((this.f75586c instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.f75586c).isSupportZoomOut()) {
            nspvi.setSupportZoomOut(true);
        }
        if (this.f75585b != null) {
            if (this.f75590g) {
                fetchFullScreenAndShowIn(this.f75585b);
            } else {
                fetchAndShowIn(this.f75585b);
            }
        }
        if (this.f75588e) {
            nspvi.preload();
            this.f75588e = false;
        }
        if (this.f75589f) {
            if (this.f75590g) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.f75589f = false;
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f75586c == null) {
            return;
        }
        this.f75586c.onNoAD(AdErrorConvertor.formatErrorCode(i2));
    }

    public final void fetchAdOnly() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a(false);
        }
    }

    public final void fetchAndShowIn(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) {
            a(viewGroup, false);
        }
    }

    public final void fetchFullScreenAdOnly() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a(true);
        }
    }

    public final void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewGroup) == null) {
            a(viewGroup, true);
        }
    }

    public final String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.f75411a;
            if (t != 0) {
                return ((NSPVI) t).getAdNetWorkName();
            }
            a("getAdNetWorkName");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final Map getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f75411a != 0) {
                return NSPVI.ext;
            }
            a("getExt");
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public final Bitmap getZoomOutBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            T t = this.f75411a;
            if (t != 0) {
                return ((NSPVI) t).getZoomOutBitmap();
            }
            a("getZoomOutBitmap");
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void preLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && b()) {
            if (!a()) {
                this.f75588e = true;
                return;
            }
            T t = this.f75411a;
            if (t != 0) {
                ((NSPVI) t).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public final void setAdLogoMargin(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
        }
    }

    public final void setDeveloperLogo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            T t = this.f75411a;
            if (t == 0) {
                this.f75591h = i2;
            } else {
                ((NSPVI) t).setDeveloperLogo(i2);
            }
        }
    }

    public final void setDeveloperLogo(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            T t = this.f75411a;
            if (t == 0) {
                this.f75592i = bArr;
            } else {
                ((NSPVI) t).setDeveloperLogo(bArr);
            }
        }
    }

    public final void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, loadAdParams) == null) {
            T t = this.f75411a;
            if (t != 0) {
                ((NSPVI) t).setLoadAdParams(loadAdParams);
            } else {
                this.f75587d = loadAdParams;
            }
        }
    }

    @Deprecated
    public final void setPreloadView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
        }
    }

    public final void showAd(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, viewGroup) == null) {
            b(viewGroup, false);
        }
    }

    public final void showFullScreenAd(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, viewGroup) == null) {
            b(viewGroup, true);
        }
    }

    public final void zoomOutAnimationFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            T t = this.f75411a;
            if (t != 0) {
                ((NSPVI) t).zoomOutAnimationFinish();
            } else {
                a("zoomOutAnimationFinish");
            }
        }
    }
}
