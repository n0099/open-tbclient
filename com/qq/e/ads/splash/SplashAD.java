package com.qq.e.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class SplashAD implements ApkDownloadComplianceInterface, DownloadConfirmListener {
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

    /* renamed from: a  reason: collision with root package name */
    public volatile NSPVI f38093a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ViewGroup f38094b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SplashADListener f38095c;

    /* renamed from: d  reason: collision with root package name */
    public volatile LoadAdParams f38096d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f38097e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f38098f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f38099g;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f38100h;

    /* renamed from: i  reason: collision with root package name */
    public volatile byte[] f38101i;
    public DownloadConfirmListener j;

    /* loaded from: classes6.dex */
    public class ADListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ SplashAD f38116a;

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
            this.f38116a = splashAD;
        }

        public /* synthetic */ ADListenerAdapter(SplashAD splashAD, byte b2) {
            this(splashAD);
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) {
                if (this.f38116a.f38095c == null) {
                    GDTLogger.e("SplashADListener == null");
                    return;
                }
                Object[] paras = aDEvent.getParas();
                switch (aDEvent.getType()) {
                    case 1:
                        this.f38116a.f38095c.onADDismissed();
                        return;
                    case 2:
                        if (paras.length <= 0 || !(paras[0] instanceof Integer)) {
                            GDTLogger.e("Splash onNoAD event get params error.");
                            return;
                        } else {
                            this.f38116a.f38095c.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) paras[0]).intValue()));
                            return;
                        }
                    case 3:
                        this.f38116a.f38095c.onADPresent();
                        return;
                    case 4:
                        this.f38116a.f38095c.onADClicked();
                        return;
                    case 5:
                        if (paras.length == 1 && (paras[0] instanceof Long)) {
                            this.f38116a.f38095c.onADTick(((Long) paras[0]).longValue());
                            return;
                        } else {
                            GDTLogger.e("Splash onADTick event get param error.");
                            return;
                        }
                    case 6:
                        this.f38116a.f38095c.onADExposure();
                        return;
                    case 7:
                        if (paras.length == 1 && (paras[0] instanceof Long)) {
                            this.f38116a.f38095c.onADLoaded(((Long) paras[0]).longValue());
                            return;
                        } else {
                            GDTLogger.e("Splash onADLoaded event get param error.");
                            return;
                        }
                    case 8:
                        if (this.f38116a.f38095c instanceof SplashADZoomOutListener) {
                            ((SplashADZoomOutListener) this.f38116a.f38095c).onZoomOut();
                            return;
                        }
                        return;
                    case 9:
                        if (this.f38116a.f38095c instanceof SplashADZoomOutListener) {
                            ((SplashADZoomOutListener) this.f38116a.f38095c).onZoomOutPlayFinish();
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
        this.f38097e = false;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, view, GDTADManager.getInstance().getAppStatus().getAPPID(), str, splashADListener, i2, map, view2);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(splashADListener, 2003);
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

    @Deprecated
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i2, Map map, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, str, str2, splashADListener, Integer.valueOf(i2), map, view2};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.f38097e = false;
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, view, str, str2, splashADListener, i2, map, view2);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SplashAD(Context context, String str, String str2, SplashADListener splashADListener) {
        this(context, str, str2, splashADListener, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, splashADListener};
            interceptable.invokeUnInit(65546, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (SplashADListener) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65546, newInitContext);
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
            interceptable.invokeUnInit(65547, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], (String) objArr2[2], (String) objArr2[3], (SplashADListener) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65547, newInitContext);
                return;
            }
        }
    }

    private void a(Context context, View view, String str, String str2, SplashADListener splashADListener, int i2, Map map, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{context, view, str, str2, splashADListener, Integer.valueOf(i2), map, view2}) == null) {
            this.f38095c = splashADListener;
            if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
                GDTLogger.e(String.format("SplashAD Constructor params error, appid=%s,posId=%s,context=%s", str, str2, context));
                a(splashADListener, 2001);
            } else if (a.a(context)) {
                GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, str, str2, map, i2, view, view2, splashADListener) { // from class: com.qq.e.ads.splash.SplashAD.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f38102a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f38103b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f38104c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ Map f38105d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ int f38106e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ View f38107f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ View f38108g;

                    /* renamed from: h  reason: collision with root package name */
                    public final /* synthetic */ SplashADListener f38109h;

                    /* renamed from: i  reason: collision with root package name */
                    public final /* synthetic */ SplashAD f38110i;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, str2, map, Integer.valueOf(i2), view, view2, splashADListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f38110i = this;
                        this.f38102a = context;
                        this.f38103b = str;
                        this.f38104c = str2;
                        this.f38105d = map;
                        this.f38106e = i2;
                        this.f38107f = view;
                        this.f38108g = view2;
                        this.f38109h = splashADListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && GDTADManager.getInstance().initWith(this.f38102a, this.f38103b)) {
                            try {
                                new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.splash.SplashAD.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public /* synthetic */ POFactory f38111a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public /* synthetic */ AnonymousClass1 f38112b;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, r7};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f38112b = this;
                                        this.f38111a = r7;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            try {
                                                if (this.f38111a == null) {
                                                    GDTLogger.e("factory return null");
                                                    this.f38112b.f38110i.a(this.f38112b.f38109h, (int) ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                                    return;
                                                }
                                                this.f38112b.f38110i.f38093a = this.f38111a.getNativeSplashAdView(this.f38112b.f38102a, this.f38112b.f38103b, this.f38112b.f38104c);
                                                if (this.f38112b.f38110i.f38093a == null) {
                                                    GDTLogger.e("SplashAdView created by factory return null");
                                                    this.f38112b.f38110i.a(this.f38112b.f38109h, (int) ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                                    return;
                                                }
                                                if (this.f38112b.f38110i.f38096d != null) {
                                                    this.f38112b.f38110i.f38093a.setLoadAdParams(this.f38112b.f38110i.f38096d);
                                                }
                                                if (this.f38112b.f38110i.f38100h != 0) {
                                                    this.f38112b.f38110i.f38093a.setDeveloperLogo(this.f38112b.f38110i.f38100h);
                                                }
                                                if (this.f38112b.f38110i.f38101i != null) {
                                                    this.f38112b.f38110i.f38093a.setDeveloperLogo(this.f38112b.f38110i.f38101i);
                                                }
                                                SplashAD.a(this.f38112b.f38110i, this.f38112b.f38105d, this.f38112b.f38104c);
                                                this.f38112b.f38110i.f38093a.setFetchDelay(this.f38112b.f38106e);
                                                this.f38112b.f38110i.f38093a.setAdListener(new ADListenerAdapter(this.f38112b.f38110i, (byte) 0));
                                                this.f38112b.f38110i.f38093a.setSkipView(this.f38112b.f38107f);
                                                this.f38112b.f38110i.f38093a.setFloatView(this.f38112b.f38108g);
                                                if ((this.f38112b.f38109h instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.f38112b.f38109h).isSupportZoomOut()) {
                                                    this.f38112b.f38110i.f38093a.setSupportZoomOut(true);
                                                }
                                                if (this.f38112b.f38110i.f38094b != null) {
                                                    if (this.f38112b.f38110i.f38099g) {
                                                        this.f38112b.f38110i.fetchFullScreenAndShowIn(this.f38112b.f38110i.f38094b);
                                                    } else {
                                                        this.f38112b.f38110i.fetchAndShowIn(this.f38112b.f38110i.f38094b);
                                                    }
                                                }
                                                if (this.f38112b.f38110i.f38097e) {
                                                    this.f38112b.f38110i.f38093a.preload();
                                                    this.f38112b.f38110i.f38097e = false;
                                                }
                                                if (this.f38112b.f38110i.f38098f) {
                                                    if (this.f38112b.f38110i.f38099g) {
                                                        this.f38112b.f38110i.f38093a.fetchFullScreenAdOnly();
                                                    } else {
                                                        this.f38112b.f38110i.f38093a.fetchAdOnly();
                                                    }
                                                    this.f38112b.f38110i.f38098f = false;
                                                }
                                            } catch (Throwable th) {
                                                GDTLogger.e("Unknown Exception", th);
                                                AnonymousClass1 anonymousClass1 = this.f38112b;
                                                anonymousClass1.f38110i.a(anonymousClass1.f38109h, 6000);
                                            }
                                        }
                                    }
                                });
                            } catch (c e2) {
                                GDTLogger.e("Fail to init splash plugin", e2);
                                this.f38110i.a(this.f38109h, 200102);
                            } catch (Throwable th) {
                                GDTLogger.e("Unknown Exception", th);
                                this.f38110i.a(this.f38109h, 6000);
                            }
                        }
                    }
                });
            } else {
                GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
                a(splashADListener, 4002);
            }
        }
    }

    private void a(ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65551, this, viewGroup, z) == null) {
            if (viewGroup == null) {
                GDTLogger.e("SplashAD fetchFullScreenAndShowIn params null ");
                a(this.f38095c, 2001);
            } else if (this.f38093a == null) {
                this.f38099g = z;
                this.f38094b = viewGroup;
            } else if (z) {
                this.f38093a.fetchFullScreenAndShowIn(viewGroup);
            } else {
                this.f38093a.fetchAndShowIn(viewGroup);
            }
        }
    }

    public static /* synthetic */ void a(SplashAD splashAD, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e2) {
            GDTLogger.e("SplashAD#setTag Exception");
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SplashADListener splashADListener, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65554, this, splashADListener, i2) == null) || splashADListener == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this, splashADListener, i2) { // from class: com.qq.e.ads.splash.SplashAD.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public /* synthetic */ SplashADListener f38113a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ int f38114b;

            /* renamed from: c  reason: collision with root package name */
            public /* synthetic */ SplashAD f38115c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, splashADListener, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38115c = this;
                this.f38113a = splashADListener;
                this.f38114b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f38113a.onNoAD(AdErrorConvertor.formatErrorCode(this.f38114b));
                }
            }
        });
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, this, z) == null) {
            if (this.f38093a == null) {
                this.f38099g = z;
                this.f38098f = true;
            } else if (z) {
                this.f38093a.fetchFullScreenAdOnly();
            } else {
                this.f38093a.fetchAdOnly();
            }
        }
    }

    private void b(ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65558, this, viewGroup, z) == null) {
            if (viewGroup == null) {
                GDTLogger.e("Splash Ad show container is null");
                a(this.f38095c, 2001);
            } else if (this.f38093a == null) {
                this.f38094b = viewGroup;
            } else if (z) {
                this.f38093a.showFullScreenAd(viewGroup);
            } else {
                this.f38093a.showAd(viewGroup);
            }
        }
    }

    public final void fetchAdOnly() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a(false);
        }
    }

    public final void fetchAndShowIn(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            a(viewGroup, false);
        }
    }

    public final void fetchFullScreenAdOnly() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(true);
        }
    }

    public final void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            a(viewGroup, true);
        }
    }

    public final String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f38093a != null) {
                return this.f38093a.getAdNetWorkName();
            }
            GDTLogger.e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onAdPresent\"");
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public final String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f38093a != null) {
                return this.f38093a.getApkInfoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f38093a != null) {
                return this.f38093a.getECPM();
            }
            GDTLogger.e("The ad does not support \"getECPM\" or you should call this method after \"onAdPresent\"");
            return -1;
        }
        return invokeV.intValue;
    }

    public final String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f38093a != null) {
                return this.f38093a.getECPMLevel();
            }
            GDTLogger.e("The ad does not support \"getECPMLevel\" or you should call this method after \"onAdPresent\"");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final Map getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                return NSPVI.ext;
            } catch (Exception e2) {
                GDTLogger.e("splash ad can not get extra");
                e2.printStackTrace();
                return null;
            }
        }
        return (Map) invokeV.objValue;
    }

    public final Bitmap getZoomOutBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f38093a != null) {
                return this.f38093a.getZoomOutBitmap();
            }
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public final void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048586, this, activity, i2, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.j) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
    }

    public final void preLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f38093a != null) {
                this.f38093a.preload();
            } else {
                this.f38097e = true;
            }
        }
    }

    @Deprecated
    public final void setAdLogoMargin(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
        }
    }

    public final void setDeveloperLogo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            if (this.f38093a == null) {
                this.f38100h = i2;
            } else {
                this.f38093a.setDeveloperLogo(i2);
            }
        }
    }

    public final void setDeveloperLogo(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bArr) == null) {
            if (this.f38093a == null) {
                this.f38101i = bArr;
            } else {
                this.f38093a.setDeveloperLogo(bArr);
            }
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public final void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, downloadConfirmListener) == null) {
            this.j = downloadConfirmListener;
            if (this.f38093a != null) {
                this.f38093a.setDownloadConfirmListener(this);
            }
        }
    }

    public final void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, loadAdParams) == null) {
            if (this.f38093a != null) {
                this.f38093a.setLoadAdParams(loadAdParams);
            } else {
                this.f38096d = loadAdParams;
            }
        }
    }

    @Deprecated
    public final void setPreloadView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
        }
    }

    public final void showAd(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, viewGroup) == null) {
            b(viewGroup, false);
        }
    }

    public final void showFullScreenAd(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, viewGroup) == null) {
            b(viewGroup, true);
        }
    }

    public final void zoomOutAnimationFinish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.f38093a == null) {
            return;
        }
        this.f38093a.zoomOutAnimationFinish();
    }
}
