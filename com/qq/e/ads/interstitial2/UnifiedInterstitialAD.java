package com.qq.e.ads.interstitial2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.a;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class UnifiedInterstitialAD implements ApkDownloadComplianceInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public UIADI f37772a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37773b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37774c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37775d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicInteger f37776e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f37777f;

    /* renamed from: g  reason: collision with root package name */
    public volatile UnifiedInterstitialMediaListener f37778g;

    /* renamed from: h  reason: collision with root package name */
    public volatile VideoOption f37779h;

    /* renamed from: i  reason: collision with root package name */
    public volatile int f37780i;
    public volatile int j;

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
        this.f37773b = false;
        this.f37774c = false;
        this.f37775d = false;
        this.f37776e = new AtomicInteger(0);
        this.f37777f = new AtomicInteger(0);
        if (GDTADManager.getInstance().isInitialized()) {
            a(activity, GDTADManager.getInstance().getAppStatus().getAPPID(), str, unifiedInterstitialADListener, map);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(2003));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, str2, unifiedInterstitialADListener, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, unifiedInterstitialADListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (String) objArr2[1], (String) objArr2[2], (UnifiedInterstitialADListener) objArr2[3], (Map) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, unifiedInterstitialADListener, map};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f37773b = false;
        this.f37774c = false;
        this.f37775d = false;
        this.f37776e = new AtomicInteger(0);
        this.f37777f = new AtomicInteger(0);
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(activity, str, str2, unifiedInterstitialADListener, map);
    }

    private void a(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, this, activity, str, str2, unifiedInterstitialADListener, map) == null) {
            if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedInterstitialADListener == null) {
                GDTLogger.e(String.format("UnifiedInterstitialAD Constructor paras error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedInterstitialADListener));
                return;
            }
            this.f37773b = true;
            if (!a.a(activity)) {
                GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
                return;
            }
            this.f37774c = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, activity, str, str2, unifiedInterstitialADListener, map) { // from class: com.qq.e.ads.interstitial2.UnifiedInterstitialAD.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f37781a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f37782b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f37783c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ UnifiedInterstitialADListener f37784d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Map f37785e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ UnifiedInterstitialAD f37786f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, str, str2, unifiedInterstitialADListener, map};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37786f = this;
                    this.f37781a = activity;
                    this.f37782b = str;
                    this.f37783c = str2;
                    this.f37784d = unifiedInterstitialADListener;
                    this.f37785e = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!GDTADManager.getInstance().initWith(this.f37781a, this.f37782b)) {
                            GDTLogger.e("Fail to init ADManager");
                            return;
                        }
                        try {
                            new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.interstitial2.UnifiedInterstitialAD.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public /* synthetic */ POFactory f37787a;

                                /* renamed from: b  reason: collision with root package name */
                                public /* synthetic */ AnonymousClass1 f37788b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, r7};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f37788b = this;
                                    this.f37787a = r7;
                                }

                                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, IGET, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            if (this.f37787a != null) {
                                                this.f37788b.f37786f.f37772a = this.f37787a.getUnifiedInterstitialADDelegate(this.f37788b.f37781a, this.f37788b.f37782b, this.f37788b.f37783c, this.f37788b.f37784d);
                                                this.f37788b.f37786f.f37775d = true;
                                                UnifiedInterstitialAD.a(this.f37788b.f37786f, this.f37788b.f37785e, this.f37788b.f37783c);
                                                this.f37788b.f37786f.setVideoOption(this.f37788b.f37786f.f37779h);
                                                this.f37788b.f37786f.setMediaListener(this.f37788b.f37786f.f37778g);
                                                this.f37788b.f37786f.setMinVideoDuration(this.f37788b.f37786f.f37780i);
                                                this.f37788b.f37786f.setMaxVideoDuration(this.f37788b.f37786f.j);
                                                while (this.f37788b.f37786f.f37776e.getAndDecrement() > 0) {
                                                    this.f37788b.f37786f.loadAD();
                                                }
                                                while (this.f37788b.f37786f.f37777f.getAndDecrement() > 0) {
                                                    this.f37788b.f37786f.loadFullScreenAD();
                                                }
                                            }
                                        } finally {
                                            try {
                                            } finally {
                                            }
                                        }
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            GDTLogger.e("Exception while init UnifiedInterstitialAD plugin", th);
                        }
                    }
                }
            });
        }
    }

    public static /* synthetic */ void a(UnifiedInterstitialAD unifiedInterstitialAD, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e2) {
            GDTLogger.e("UnifiedInterstitialAD#setTag Exception");
            e2.printStackTrace();
        }
    }

    public void close() {
        UIADI uiadi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (uiadi = this.f37772a) == null) {
            return;
        }
        uiadi.close();
    }

    public void destroy() {
        UIADI uiadi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (uiadi = this.f37772a) == null) {
            return;
        }
        uiadi.destory();
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
            UIADI uiadi = this.f37772a;
            if (uiadi != null) {
                return uiadi.getAdNetWorkName();
            }
            GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdNetWorkName");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getAdPatternType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            UIADI uiadi = this.f37772a;
            if (uiadi != null) {
                return uiadi.getAdPatternType();
            }
            GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdPatternType");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            UIADI uiadi = this.f37772a;
            if (uiadi != null) {
                return uiadi.getApkInfoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            UIADI uiadi = this.f37772a;
            if (uiadi != null) {
                return uiadi.getECPM();
            }
            GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPM");
            return -1;
        }
        return invokeV.intValue;
    }

    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            UIADI uiadi = this.f37772a;
            if (uiadi != null) {
                return uiadi.getECPMLevel();
            }
            GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPMLevel");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public Map getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                if (this.f37772a != null) {
                    return UIADI.ext;
                }
                return null;
            } catch (Exception unused) {
                GDTLogger.e("interstitial2 can not get ext");
                return null;
            }
        }
        return (Map) invokeV.objValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            UIADI uiadi = this.f37772a;
            if (uiadi != null) {
                return uiadi.getVideoDuration();
            }
            GDTLogger.e("please invoke getVideoDuration method after callback \"onADLoad\" or the ad does not support \"getVideoDuration\" ");
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            UIADI uiadi = this.f37772a;
            if (uiadi != null) {
                return uiadi.isValid();
            }
            GDTLogger.e("InterstitialAD init failed or not inited, can't call isValid");
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!this.f37773b || !this.f37774c) {
                GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
            } else if (!this.f37775d) {
                this.f37776e.incrementAndGet();
            } else {
                UIADI uiadi = this.f37772a;
                if (uiadi != null) {
                    uiadi.loadAd();
                } else {
                    GDTLogger.e("InterstitialAD Init error,See More Logs");
                }
            }
        }
    }

    public void loadFullScreenAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!this.f37773b || !this.f37774c) {
                GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
            } else if (!this.f37775d) {
                this.f37777f.incrementAndGet();
            } else {
                UIADI uiadi = this.f37772a;
                if (uiadi != null) {
                    uiadi.loadFullScreenAD();
                } else {
                    GDTLogger.e("InterstitialAD Init error,See More Logs");
                }
            }
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        UIADI uiadi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, downloadConfirmListener) == null) || (uiadi = this.f37772a) == null) {
            return;
        }
        uiadi.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setMaxVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.j = i2;
            if (this.j > 0 && this.f37780i > this.j) {
                GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
            }
            UIADI uiadi = this.f37772a;
            if (uiadi != null) {
                uiadi.setMaxVideoDuration(i2);
            }
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, unifiedInterstitialMediaListener) == null) {
            this.f37778g = unifiedInterstitialMediaListener;
            UIADI uiadi = this.f37772a;
            if (uiadi != null) {
                uiadi.setMediaListener(unifiedInterstitialMediaListener);
            }
        }
    }

    public void setMinVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f37780i = i2;
            if (this.j > 0 && this.f37780i > this.j) {
                GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
            }
            UIADI uiadi = this.f37772a;
            if (uiadi != null) {
                uiadi.setMinVideoDuration(i2);
            }
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, videoOption) == null) {
            this.f37779h = videoOption;
            UIADI uiadi = this.f37772a;
            if (uiadi != null) {
                uiadi.setVideoOption(videoOption);
            }
        }
    }

    @Deprecated
    public void setVideoPlayPolicy(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    public void show() {
        UIADI uiadi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (uiadi = this.f37772a) == null) {
            return;
        }
        uiadi.show();
    }

    public void show(Activity activity) {
        UIADI uiadi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, activity) == null) || (uiadi = this.f37772a) == null) {
            return;
        }
        uiadi.show(activity);
    }

    public void showAsPopupWindow() {
        UIADI uiadi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (uiadi = this.f37772a) == null) {
            return;
        }
        uiadi.showAsPopupWindow();
    }

    public void showAsPopupWindow(Activity activity) {
        UIADI uiadi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, activity) == null) || (uiadi = this.f37772a) == null) {
            return;
        }
        uiadi.showAsPopupWindow(activity);
    }

    public void showFullScreenAD(Activity activity) {
        UIADI uiadi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, activity) == null) || (uiadi = this.f37772a) == null) {
            return;
        }
        uiadi.showFullScreenAD(activity);
    }
}
