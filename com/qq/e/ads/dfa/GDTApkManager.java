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
    public DFA f37735a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37736b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37737c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f37738d;

    /* renamed from: e  reason: collision with root package name */
    public Context f37739e;

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
        this.f37736b = false;
        this.f37737c = false;
        this.f37738d = new AtomicInteger(0);
        if (GDTADManager.getInstance().isInitialized()) {
            String appid = GDTADManager.getInstance().getAppStatus().getAPPID();
            if (StringUtil.isEmpty(appid) || context == null || iGDTApkListener == null) {
                str = String.format("GDTApkManager Constructor params error, appid=%s,context=%s,listener=%s", appid, context, iGDTApkListener);
            } else if (a.a(context)) {
                this.f37736b = true;
                this.f37739e = context;
                GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, appid, iGDTApkListener) { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ IGDTApkListener f37740a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ GDTApkManager f37741b;

                    /* renamed from: c  reason: collision with root package name */
                    public /* synthetic */ Context f37742c;

                    /* renamed from: d  reason: collision with root package name */
                    public /* synthetic */ String f37743d;

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
                        this.f37741b = this;
                        this.f37742c = context;
                        this.f37743d = appid;
                        this.f37740a = iGDTApkListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!GDTADManager.getInstance().initWith(this.f37742c, this.f37743d)) {
                                GDTLogger.e("Fail to init ADManager");
                                return;
                            }
                            try {
                                new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public /* synthetic */ POFactory f37744a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public /* synthetic */ AnonymousClass1 f37745b;

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
                                        this.f37745b = this;
                                        this.f37744a = r7;
                                    }

                                    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, IGET, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            try {
                                                if (this.f37744a != null) {
                                                    this.f37745b.f37741b.f37735a = GDTADManager.getInstance().getPM().getPOFactory().getGDTApkDelegate(this.f37745b.f37740a);
                                                    this.f37745b.f37741b.f37737c = true;
                                                    while (this.f37745b.f37741b.f37738d.getAndDecrement() > 0) {
                                                        this.f37745b.f37741b.loadGDTApk();
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
            if (!this.f37736b) {
                GDTLogger.e("GDTApkManager init Context error,See More logs while new GDTApkManager");
            } else if (!this.f37737c) {
                this.f37738d.incrementAndGet();
            } else {
                DFA dfa = this.f37735a;
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gDTApk) == null) || (dfa = this.f37735a) == null) {
            return;
        }
        dfa.startInstall(this.f37739e, gDTApk);
    }
}
