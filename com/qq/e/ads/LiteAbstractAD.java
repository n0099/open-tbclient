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
/* loaded from: classes7.dex */
public abstract class LiteAbstractAD<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public T f40672a;

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
                    public final /* synthetic */ Context f40673a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f40674b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f40675c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ LiteAbstractAD f40676d;

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
                        this.f40676d = this;
                        this.f40673a = context;
                        this.f40674b = str;
                        this.f40675c = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        LiteAbstractAD liteAbstractAD;
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (GDTADManager.getInstance().initWith(this.f40673a, this.f40674b)) {
                                try {
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.LiteAbstractAD.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public /* synthetic */ POFactory f40677a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public /* synthetic */ AnonymousClass1 f40678b;

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
                                            this.f40678b = this;
                                            this.f40677a = r7;
                                        }

                                        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.qq.e.ads.LiteAbstractAD */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                try {
                                                    if (this.f40677a == null) {
                                                        this.f40678b.f40676d.a(200102);
                                                        return;
                                                    }
                                                    this.f40678b.f40676d.f40672a = this.f40678b.f40676d.a(this.f40678b.f40673a, this.f40677a, this.f40678b.f40674b, this.f40678b.f40675c);
                                                    this.f40678b.f40676d.a((LiteAbstractAD) this.f40678b.f40676d.f40672a);
                                                } catch (Throwable th) {
                                                    GDTLogger.e("Exception while init Core", th);
                                                    this.f40678b.f40676d.a(2001);
                                                }
                                            }
                                        }
                                    });
                                    return;
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init plugin", th);
                                    liteAbstractAD = this.f40676d;
                                    i2 = 200102;
                                }
                            } else {
                                GDTLogger.e("Fail to init ADManager");
                                liteAbstractAD = this.f40676d;
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
