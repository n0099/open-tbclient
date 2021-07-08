package com.qq.e.ads;

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
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes6.dex */
public abstract class LiteAbstractAD<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public T f37686a;

    public LiteAbstractAD() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract T a(Context context, POFactory pOFactory, String str, String str2);

    public abstract void a(int i2);

    public final void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2) == null) {
            if (a.a(context)) {
                GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, str, str2) { // from class: com.qq.e.ads.LiteAbstractAD.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f37687a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f37688b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f37689c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ LiteAbstractAD f37690d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37690d = this;
                        this.f37687a = context;
                        this.f37688b = str;
                        this.f37689c = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        LiteAbstractAD liteAbstractAD;
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (GDTADManager.getInstance().initWith(this.f37687a, this.f37688b)) {
                                try {
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.LiteAbstractAD.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public /* synthetic */ POFactory f37691a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public /* synthetic */ AnonymousClass1 f37692b;

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
                                            this.f37692b = this;
                                            this.f37691a = r7;
                                        }

                                        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.qq.e.ads.LiteAbstractAD */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                try {
                                                    if (this.f37691a == null) {
                                                        this.f37692b.f37690d.a(200102);
                                                        return;
                                                    }
                                                    this.f37692b.f37690d.f37686a = this.f37692b.f37690d.a(this.f37692b.f37687a, this.f37691a, this.f37692b.f37688b, this.f37692b.f37689c);
                                                    this.f37692b.f37690d.a((LiteAbstractAD) this.f37692b.f37690d.f37686a);
                                                } catch (Throwable th) {
                                                    GDTLogger.e("Exception while init Core", th);
                                                    this.f37692b.f37690d.a(2001);
                                                }
                                            }
                                        }
                                    });
                                    return;
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init plugin", th);
                                    liteAbstractAD = this.f37690d;
                                    i2 = 200102;
                                }
                            } else {
                                GDTLogger.e("Fail to init ADManager");
                                liteAbstractAD = this.f37690d;
                                i2 = 200101;
                            }
                            liteAbstractAD.a(i2);
                        }
                    }
                });
                return;
            }
            GDTLogger.e("Required Activity/Service/Permission not declared in AndroidManifest.xml");
            a(4002);
        }
    }

    public abstract void a(T t);
}
