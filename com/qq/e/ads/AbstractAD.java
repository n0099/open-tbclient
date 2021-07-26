package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes6.dex */
public abstract class AbstractAD<T extends ADI> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f37859a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f37860b;

    /* renamed from: c  reason: collision with root package name */
    public T f37861c;

    /* renamed from: d  reason: collision with root package name */
    public BrowserType f37862d;

    /* renamed from: e  reason: collision with root package name */
    public DownAPPConfirmPolicy f37863e;

    /* loaded from: classes6.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    public AbstractAD() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37859a = false;
        this.f37860b = false;
    }

    public final T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37861c : (T) invokeV.objValue;
    }

    public abstract T a(Context context, POFactory pOFactory, String str, String str2);

    public final void a(Context context, String str, String str2, BasicADListener basicADListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2, basicADListener) == null) {
            if (a.a(context)) {
                this.f37860b = true;
                GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, str, str2, basicADListener) { // from class: com.qq.e.ads.AbstractAD.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f37864a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f37865b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f37866c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ BasicADListener f37867d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ AbstractAD f37868e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, str2, basicADListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37868e = this;
                        this.f37864a = context;
                        this.f37865b = str;
                        this.f37866c = str2;
                        this.f37867d = basicADListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractAD abstractAD;
                        BasicADListener basicADListener2;
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (GDTADManager.getInstance().initWith(this.f37864a, this.f37865b)) {
                                try {
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.AbstractAD.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public /* synthetic */ POFactory f37869a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public /* synthetic */ AnonymousClass1 f37870b;

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
                                            this.f37870b = this;
                                            this.f37869a = r7;
                                        }

                                        /* JADX DEBUG: Multi-variable search result rejected for r1v20, resolved type: com.qq.e.ads.AbstractAD */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                try {
                                                    if (this.f37869a == null) {
                                                        this.f37870b.f37868e.f37859a = true;
                                                        this.f37870b.f37868e.a(this.f37870b.f37867d, 200102);
                                                        return;
                                                    }
                                                    this.f37870b.f37868e.f37861c = this.f37870b.f37868e.a(this.f37870b.f37864a, this.f37869a, this.f37870b.f37865b, this.f37870b.f37866c);
                                                    this.f37870b.f37868e.f37859a = true;
                                                    if (this.f37870b.f37868e.f37862d != null) {
                                                        this.f37870b.f37868e.setBrowserType(this.f37870b.f37868e.f37862d);
                                                    }
                                                    if (this.f37870b.f37868e.f37863e != null) {
                                                        this.f37870b.f37868e.setDownAPPConfirmPolicy(this.f37870b.f37868e.f37863e);
                                                    }
                                                    this.f37870b.f37868e.a((AbstractAD) this.f37870b.f37868e.f37861c);
                                                } catch (Throwable th) {
                                                    GDTLogger.e("Exception while init Core", th);
                                                    this.f37870b.f37868e.f37859a = true;
                                                    AnonymousClass1 anonymousClass1 = this.f37870b;
                                                    anonymousClass1.f37868e.a(anonymousClass1.f37867d, 2001);
                                                }
                                            }
                                        }
                                    });
                                    return;
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init plugin", th);
                                    abstractAD = this.f37868e;
                                    basicADListener2 = this.f37867d;
                                    i2 = 200102;
                                }
                            } else {
                                GDTLogger.e("Fail to init ADManager");
                                abstractAD = this.f37868e;
                                basicADListener2 = this.f37867d;
                                i2 = 200101;
                            }
                            abstractAD.a(basicADListener2, i2);
                        }
                    }
                });
                return;
            }
            GDTLogger.e("Required Activity/Service/Permission not declared in AndroidManifest.xml");
            a(basicADListener, 4002);
        }
    }

    public void a(BasicADListener basicADListener, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, basicADListener, i2) == null) || basicADListener == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            basicADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, basicADListener, i2) { // from class: com.qq.e.ads.AbstractAD.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ BasicADListener f37871a;

                /* renamed from: b  reason: collision with root package name */
                public /* synthetic */ int f37872b;

                /* renamed from: c  reason: collision with root package name */
                public /* synthetic */ AbstractAD f37873c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, basicADListener, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37873c = this;
                    this.f37871a = basicADListener;
                    this.f37872b = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    BasicADListener basicADListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (basicADListener2 = this.f37871a) == null) {
                        return;
                    }
                    basicADListener2.onNoAD(AdErrorConvertor.formatErrorCode(this.f37872b));
                }
            });
        }
    }

    public abstract void a(T t);

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37859a : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37860b : invokeV.booleanValue;
    }

    public void setBrowserType(BrowserType browserType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, browserType) == null) {
            this.f37862d = browserType;
            T t = this.f37861c;
            if (t == null || browserType == null) {
                return;
            }
            t.setBrowserType(browserType.value());
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downAPPConfirmPolicy) == null) {
            this.f37863e = downAPPConfirmPolicy;
            T t = this.f37861c;
            if (t == null || downAPPConfirmPolicy == null) {
                return;
            }
            t.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
