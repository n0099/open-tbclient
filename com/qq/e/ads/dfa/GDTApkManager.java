package com.qq.e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class GDTApkManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DFA f37924a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37925b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37926c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f37927d;

    /* renamed from: e  reason: collision with root package name */
    public Context f37928e;

    public GDTApkManager(Context context, IGDTApkListener iGDTApkListener) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iGDTApkListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37925b = false;
        this.f37926c = false;
        this.f37927d = new AtomicInteger(0);
        if (GDTADManager.getInstance().isInitialized()) {
            String appid = GDTADManager.getInstance().getAppStatus().getAPPID();
            if (StringUtil.isEmpty(appid) || context == null || iGDTApkListener == null) {
                str = String.format("GDTApkManager Constructor params error, appid=%s,context=%s,listener=%s", appid, context, iGDTApkListener);
            } else if (a.a(context)) {
                this.f37925b = true;
                this.f37928e = context;
                GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, appid, iGDTApkListener) { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ IGDTApkListener f37929a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ GDTApkManager f37930b;

                    /* renamed from: c  reason: collision with root package name */
                    public /* synthetic */ Context f37931c;

                    /* renamed from: d  reason: collision with root package name */
                    public /* synthetic */ String f37932d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                            newInitContext2.initArgs = r2;
                            Object[] objArr2 = {this, context, appid, iGDTApkListener};
                            interceptable2.invokeUnInit(65536, newInitContext2);
                            int i4 = newInitContext2.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext2.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext2);
                                return;
                            }
                        }
                        this.f37930b = this;
                        this.f37931c = context;
                        this.f37932d = appid;
                        this.f37929a = iGDTApkListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!GDTADManager.getInstance().initWith(this.f37931c, this.f37932d)) {
                                GDTLogger.e("Fail to init ADManager");
                                return;
                            }
                            try {
                                new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public /* synthetic */ POFactory f37933a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public /* synthetic */ AnonymousClass1 f37934b;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                                            newInitContext2.initArgs = r2;
                                            Object[] objArr2 = {this, r7};
                                            interceptable3.invokeUnInit(65536, newInitContext2);
                                            int i4 = newInitContext2.flag;
                                            if ((i4 & 1) != 0) {
                                                int i5 = i4 & 2;
                                                newInitContext2.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext2);
                                                return;
                                            }
                                        }
                                        this.f37934b = this;
                                        this.f37933a = r7;
                                    }

                                    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, IGET, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            try {
                                                if (this.f37933a != null) {
                                                    this.f37934b.f37930b.f37924a = GDTADManager.getInstance().getPM().getPOFactory().getGDTApkDelegate(this.f37934b.f37929a);
                                                    this.f37934b.f37930b.f37926c = true;
                                                    while (this.f37934b.f37930b.f37927d.getAndDecrement() > 0) {
                                                        this.f37934b.f37930b.loadGDTApk();
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
                return;
            } else {
                str = "Required Activity/Service/Permission Not Declared in AndroidManifest.xml";
            }
        } else {
            str = "SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化";
        }
        GDTLogger.e(str);
    }

    public final void loadGDTApk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f37925b) {
                GDTLogger.e("GDTApkManager init Context error,See More logs while new GDTApkManager");
            } else if (!this.f37926c) {
                this.f37927d.incrementAndGet();
            } else {
                DFA dfa = this.f37924a;
                if (dfa != null) {
                    dfa.loadGDTApk();
                } else {
                    GDTLogger.e("InterstitialAD Init error,See More Logs");
                }
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gDTApk) == null) || (dfa = this.f37924a) == null) {
            return;
        }
        dfa.startInstall(this.f37928e, gDTApk);
    }
}
