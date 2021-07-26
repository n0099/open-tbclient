package com.qq.e.ads.hybrid;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes6.dex */
public class HybridAD implements HADI {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f37935a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f37936b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f37937c;

    /* renamed from: d  reason: collision with root package name */
    public HADI f37938d;

    /* renamed from: e  reason: collision with root package name */
    public HybridADListener f37939e;

    /* renamed from: f  reason: collision with root package name */
    public CountDownLatch f37940f;

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
        this.f37940f = new CountDownLatch(1);
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
        this.f37940f = new CountDownLatch(1);
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, str, hybridADSetting, hybridADListener);
    }

    private void a(Context context, String str, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str, hybridADSetting, hybridADListener) == null) {
            if (context == null || TextUtils.isEmpty(str) || hybridADListener == null) {
                GDTLogger.e(String.format("HybridAD Constructor params error, context=%s, appID=%s,HybridADListener=%s", context, str, hybridADListener));
                return;
            }
            this.f37939e = hybridADListener;
            this.f37936b = true;
            if (!a.a(context)) {
                GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
                return;
            }
            this.f37937c = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, str, hybridADSetting, hybridADListener) { // from class: com.qq.e.ads.hybrid.HybridAD.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ HybridADSetting f37941a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ HybridADListener f37942b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ HybridAD f37943c;

                /* renamed from: d  reason: collision with root package name */
                public /* synthetic */ Context f37944d;

                /* renamed from: e  reason: collision with root package name */
                public /* synthetic */ String f37945e;

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
                    this.f37943c = this;
                    this.f37944d = context;
                    this.f37945e = str;
                    this.f37941a = hybridADSetting;
                    this.f37942b = hybridADListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (GDTADManager.getInstance().initWith(this.f37944d, this.f37945e)) {
                            try {
                                new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.hybrid.HybridAD.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public /* synthetic */ POFactory f37946a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public /* synthetic */ AnonymousClass1 f37947b;

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
                                        this.f37947b = this;
                                        this.f37946a = r7;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            POFactory pOFactory = this.f37946a;
                                            if (pOFactory != null) {
                                                AnonymousClass1 anonymousClass1 = this.f37947b;
                                                anonymousClass1.f37943c.f37938d = pOFactory.getHybridAD(anonymousClass1.f37941a, anonymousClass1.f37942b);
                                                this.f37947b.f37943c.f37935a = true;
                                            } else {
                                                GDTLogger.e("poFactory is null");
                                                HybridAD.a(this.f37947b.f37943c, 2001);
                                            }
                                            this.f37947b.f37943c.f37940f.countDown();
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
                        HybridAD.a(this.f37943c, 2001);
                        this.f37943c.f37940f.countDown();
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
            public /* synthetic */ int f37950a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ HybridAD f37951b;

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
                this.f37951b = hybridAD;
                this.f37950a = r7;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f37951b.f37939e == null) {
                    return;
                }
                this.f37951b.f37939e.onError(AdErrorConvertor.formatErrorCode(this.f37950a));
            }
        });
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f37936b && this.f37937c) {
                z = true;
            } else {
                GDTLogger.e("AD init Params OR Context error, details in logs produced while init HybridAD");
                z = false;
            }
            if (!z) {
                GDTLogger.e("HybridAD loadUrl error");
            } else if (this.f37935a) {
                this.f37938d.loadUrl(str);
            } else {
                new Thread(new Runnable(this, str) { // from class: com.qq.e.ads.hybrid.HybridAD.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public /* synthetic */ String f37948a;

                    /* renamed from: b  reason: collision with root package name */
                    public /* synthetic */ HybridAD f37949b;

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
                        this.f37949b = this;
                        this.f37948a = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f37949b.f37940f.await(30L, TimeUnit.SECONDS);
                                if (this.f37949b.f37935a) {
                                    this.f37949b.f37938d.loadUrl(this.f37948a);
                                    return;
                                }
                                GDTLogger.e("delegate init failed ");
                                HybridAD.a(this.f37949b, 2001);
                            } catch (InterruptedException unused) {
                                GDTLogger.e("buffered loadUrl action timeout");
                                HybridAD.a(this.f37949b, 2001);
                            }
                        }
                    }
                }).start();
            }
        }
    }
}
