package com.qq.e.ads.hybrid;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class HybridAD implements HADI {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f40732a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f40733b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f40734c;

    /* renamed from: d  reason: collision with root package name */
    public HADI f40735d;

    /* renamed from: e  reason: collision with root package name */
    public HybridADListener f40736e;

    /* renamed from: f  reason: collision with root package name */
    public CountDownLatch f40737f;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, hybridADSetting, hybridADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40737f = new CountDownLatch(1);
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), hybridADSetting, hybridADListener);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        hybridADListener.onError(AdErrorConvertor.formatErrorCode(2003));
    }

    @Deprecated
    public HybridAD(Context context, String str, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, hybridADSetting, hybridADListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40737f = new CountDownLatch(1);
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, str, hybridADSetting, hybridADListener);
    }

    private void a(Context context, String str, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65540, this, context, str, hybridADSetting, hybridADListener) == null) {
            if (context == null || TextUtils.isEmpty(str) || hybridADListener == null) {
                GDTLogger.e(String.format("HybridAD Constructor params error, context=%s, appID=%s,HybridADListener=%s", context, str, hybridADListener));
                return;
            }
            this.f40736e = hybridADListener;
            this.f40733b = true;
            if (!a.a(context)) {
                GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
                return;
            }
            this.f40734c = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, str, hybridADSetting, hybridADListener) { // from class: com.qq.e.ads.hybrid.HybridAD.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ HybridADSetting f40738a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ HybridADListener f40739b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ HybridAD f40740c;

                /* renamed from: d  reason: collision with root package name */
                public /* synthetic */ Context f40741d;

                /* renamed from: e  reason: collision with root package name */
                public /* synthetic */ String f40742e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, hybridADSetting, hybridADListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f40740c = this;
                    this.f40741d = context;
                    this.f40742e = str;
                    this.f40738a = hybridADSetting;
                    this.f40739b = hybridADListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (GDTADManager.getInstance().initWith(this.f40741d, this.f40742e)) {
                            try {
                                new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.hybrid.HybridAD.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public /* synthetic */ POFactory f40743a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public /* synthetic */ AnonymousClass1 f40744b;

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
                                        this.f40744b = this;
                                        this.f40743a = r7;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            POFactory pOFactory = this.f40743a;
                                            if (pOFactory != null) {
                                                AnonymousClass1 anonymousClass1 = this.f40744b;
                                                anonymousClass1.f40740c.f40735d = pOFactory.getHybridAD(anonymousClass1.f40738a, anonymousClass1.f40739b);
                                                this.f40744b.f40740c.f40732a = true;
                                            } else {
                                                GDTLogger.e("poFactory is null");
                                                HybridAD.a(this.f40744b.f40740c, 2001);
                                            }
                                            this.f40744b.f40740c.f40737f.countDown();
                                        }
                                    }
                                });
                                return;
                            } catch (Throwable th) {
                                GDTLogger.e("Exception while init HybridAD plugin", th);
                            }
                        } else {
                            GDTLogger.e("Fail to init ADManager");
                        }
                        HybridAD.a(this.f40740c, 2001);
                        this.f40740c.f40737f.countDown();
                    }
                }
            });
        }
    }

    public static /* synthetic */ void a(HybridAD hybridAD, int i2) {
        new Handler(Looper.getMainLooper()).post(new Runnable(hybridAD, 2001) { // from class: com.qq.e.ads.hybrid.HybridAD.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public /* synthetic */ int f40747a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ HybridAD f40748b;

            {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hybridAD, Integer.valueOf(r7)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f40748b = hybridAD;
                this.f40747a = r7;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f40748b.f40736e == null) {
                    return;
                }
                this.f40748b.f40736e.onError(AdErrorConvertor.formatErrorCode(this.f40747a));
            }
        });
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f40733b && this.f40734c) {
                z = true;
            } else {
                GDTLogger.e("AD init Params OR Context error, details in logs produced while init HybridAD");
                z = false;
            }
            if (!z) {
                GDTLogger.e("HybridAD loadUrl error");
            } else if (this.f40732a) {
                this.f40735d.loadUrl(str);
            } else {
                new Thread(new Runnable(this, str) { // from class: com.qq.e.ads.hybrid.HybridAD.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public /* synthetic */ String f40745a;

                    /* renamed from: b  reason: collision with root package name */
                    public /* synthetic */ HybridAD f40746b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f40746b = this;
                        this.f40745a = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f40746b.f40737f.await(30L, TimeUnit.SECONDS);
                                if (this.f40746b.f40732a) {
                                    this.f40746b.f40735d.loadUrl(this.f40745a);
                                    return;
                                }
                                GDTLogger.e("delegate init failed ");
                                HybridAD.a(this.f40746b, 2001);
                            } catch (InterruptedException unused) {
                                GDTLogger.e("buffered loadUrl action timeout");
                                HybridAD.a(this.f40746b, 2001);
                            }
                        }
                    }
                }).start();
            }
        }
    }
}
