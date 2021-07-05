package com.qq.e.ads.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class UnifiedBannerView extends FrameLayout implements ApkDownloadComplianceInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public UBVI f40679a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40680b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40681c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40682d;

    /* renamed from: e  reason: collision with root package name */
    public DownAPPConfirmPolicy f40683e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f40684f;

    /* renamed from: g  reason: collision with root package name */
    public int f40685g;

    /* renamed from: h  reason: collision with root package name */
    public LoadAdParams f40686h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, (Map) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, unifiedBannerADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (String) objArr2[1], (UnifiedBannerADListener) objArr2[2], (Map) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, unifiedBannerADListener, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40680b = false;
        this.f40681c = false;
        this.f40682d = false;
        this.f40684f = new AtomicInteger(0);
        this.f40685g = 30;
        this.f40686h = null;
        if (GDTADManager.getInstance().isInitialized()) {
            a(activity, GDTADManager.getInstance().getAppStatus().getAPPID(), str, unifiedBannerADListener, map);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(2003));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, str2, unifiedBannerADListener, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, unifiedBannerADListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (String) objArr2[1], (String) objArr2[2], (UnifiedBannerADListener) objArr2[3], (Map) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, unifiedBannerADListener, map};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f40680b = false;
        this.f40681c = false;
        this.f40682d = false;
        this.f40684f = new AtomicInteger(0);
        this.f40685g = 30;
        this.f40686h = null;
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(activity, str, str2, unifiedBannerADListener, map);
    }

    private void a(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, this, activity, str, str2, unifiedBannerADListener, map) == null) {
            if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedBannerADListener == null) {
                GDTLogger.e(String.format("UnifiedBannerView Constructor params error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedBannerADListener));
                return;
            }
            this.f40680b = true;
            if (!a.a(activity)) {
                GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
                return;
            }
            this.f40681c = true;
            setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, activity, str, str2, unifiedBannerADListener, map) { // from class: com.qq.e.ads.banner2.UnifiedBannerView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f40687a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f40688b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f40689c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ UnifiedBannerADListener f40690d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Map f40691e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ UnifiedBannerView f40692f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, str, str2, unifiedBannerADListener, map};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f40692f = this;
                    this.f40687a = activity;
                    this.f40688b = str;
                    this.f40689c = str2;
                    this.f40690d = unifiedBannerADListener;
                    this.f40691e = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!GDTADManager.getInstance().initWith(this.f40687a, this.f40688b)) {
                            GDTLogger.e("Fail to init ADManager");
                            return;
                        }
                        try {
                            new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.banner2.UnifiedBannerView.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public /* synthetic */ POFactory f40693a;

                                /* renamed from: b  reason: collision with root package name */
                                public /* synthetic */ AnonymousClass1 f40694b;

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
                                    this.f40694b = this;
                                    this.f40693a = r7;
                                }

                                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, IGET, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            if (this.f40693a != null) {
                                                this.f40694b.f40692f.f40679a = this.f40693a.getUnifiedBannerViewDelegate(this.f40694b.f40692f, this.f40694b.f40687a, this.f40694b.f40688b, this.f40694b.f40689c, this.f40694b.f40690d);
                                                this.f40694b.f40692f.f40682d = true;
                                                UnifiedBannerView.a(this.f40694b.f40692f, this.f40694b.f40691e, this.f40694b.f40689c);
                                                if (this.f40694b.f40692f.f40683e != null) {
                                                    this.f40694b.f40692f.setDownConfirmPolicy(this.f40694b.f40692f.f40683e);
                                                }
                                                this.f40694b.f40692f.setRefresh(this.f40694b.f40692f.f40685g);
                                                this.f40694b.f40692f.setLoadAdParams(this.f40694b.f40692f.f40686h);
                                                while (this.f40694b.f40692f.f40684f.getAndDecrement() > 0) {
                                                    this.f40694b.f40692f.loadAD();
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
                            GDTLogger.e("Exception while init UnifiedBannerView plugin", th);
                        }
                    }
                }
            });
        }
    }

    public static /* synthetic */ void a(UnifiedBannerView unifiedBannerView, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e2) {
            GDTLogger.e("UnifiedBanner#setTag Exception");
            e2.printStackTrace();
        }
    }

    public void destroy() {
        UBVI ubvi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ubvi = this.f40679a) == null) {
            return;
        }
        ubvi.destroy();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            UBVI ubvi = this.f40679a;
            if (ubvi != null) {
                return ubvi.getApkInfoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public Map getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (this.f40679a != null) {
                    return UBVI.ext;
                }
                return null;
            } catch (Exception unused) {
                GDTLogger.e("banner2 can not get ext");
                return null;
            }
        }
        return (Map) invokeV.objValue;
    }

    public void loadAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!this.f40680b || !this.f40681c) {
                GDTLogger.e("UnifiedBannerView init Paras OR Context error,See More logs while new BannerView");
            } else if (!this.f40682d) {
                this.f40684f.incrementAndGet();
            } else {
                UBVI ubvi = this.f40679a;
                if (ubvi != null) {
                    ubvi.fetchAd();
                } else {
                    GDTLogger.e("UnifiedBannerView Init error,See More Logs");
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.onWindowFocusChanged(z);
            UBVI ubvi = this.f40679a;
            if (ubvi != null) {
                ubvi.onWindowFocusChanged(z);
            }
        }
    }

    public void setDownConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        UBVI ubvi;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, downAPPConfirmPolicy) == null) {
            this.f40683e = downAPPConfirmPolicy;
            if (downAPPConfirmPolicy == null || (ubvi = this.f40679a) == null) {
                return;
            }
            ubvi.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        UBVI ubvi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, downloadConfirmListener) == null) || (ubvi = this.f40679a) == null) {
            return;
        }
        ubvi.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, loadAdParams) == null) {
            this.f40686h = loadAdParams;
            UBVI ubvi = this.f40679a;
            if (ubvi != null) {
                ubvi.setLoadAdParams(loadAdParams);
            }
        }
    }

    public void setRefresh(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f40685g = i2;
            UBVI ubvi = this.f40679a;
            if (ubvi != null) {
                ubvi.setRefresh(i2);
            }
        }
    }
}
