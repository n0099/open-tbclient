package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes2.dex */
public abstract class AbstractAD<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public T f68719a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f68720b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f68721c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f68722d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f68723e;

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
        this.f68721c = false;
        this.f68722d = false;
        this.f68720b = new Handler(Looper.getMainLooper());
    }

    public static final void a(Class cls, ADEvent aDEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cls, aDEvent) == null) {
            GDTLogger.e(cls.getSimpleName() + ":ADEvent参数错误(" + aDEvent + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    private void b(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str, str2) == null) {
            this.f68723e = true;
            if (GDTADManager.getInstance().isInitialized()) {
                String appid = GDTADManager.getInstance().getAppStatus().getAPPID();
                if (a.a(context)) {
                    this.f68722d = true;
                    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, appid, str, str2) { // from class: com.qq.e.ads.AbstractAD.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Context f68724a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f68725b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f68726c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ String f68727d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AbstractAD f68728e;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context, appid, str, str2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f68728e = this;
                            this.f68724a = context;
                            this.f68725b = appid;
                            this.f68726c = str;
                            this.f68727d = str2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    this.f68728e.f68720b.post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.AbstractAD.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ POFactory f68729a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass1 f68730b;

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
                                            this.f68730b = this;
                                            this.f68729a = r7;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                try {
                                                    if (this.f68729a != null) {
                                                        this.f68730b.f68728e.f68719a = (T) this.f68730b.f68728e.a(this.f68730b.f68724a, this.f68729a, this.f68730b.f68725b, this.f68730b.f68726c, this.f68730b.f68727d);
                                                        this.f68730b.f68728e.f68721c = true;
                                                        if (this.f68730b.f68728e.f68719a == null) {
                                                            this.f68730b.f68728e.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                                        } else {
                                                            this.f68730b.f68728e.a((AbstractAD) this.f68730b.f68728e.f68719a);
                                                        }
                                                    } else {
                                                        this.f68730b.f68728e.f68721c = true;
                                                        this.f68730b.f68728e.a(200102);
                                                    }
                                                } catch (Throwable th) {
                                                    GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                                    this.f68730b.f68728e.f68721c = true;
                                                    this.f68730b.f68728e.a(2001);
                                                }
                                            }
                                        }
                                    });
                                } catch (Throwable th) {
                                    GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                                    this.f68728e.f68721c = true;
                                    this.f68728e.a(200102);
                                }
                            }
                        }
                    });
                    return;
                }
                GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
                a(4002);
                return;
            }
            a(2003);
        }
    }

    public abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                b(i2);
            } else {
                this.f68720b.post(new Runnable(this, i2) { // from class: com.qq.e.ads.AbstractAD.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f68731a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AbstractAD f68732b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f68732b = this;
                        this.f68731a = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f68732b.b(this.f68731a);
                        }
                    }
                });
            }
        }
    }

    public final void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                b(context, str, "");
                return;
            }
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(2001);
        }
    }

    public final void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, str, str2) == null) {
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                b(context, str, str2);
                return;
            }
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(2001);
        }
    }

    public abstract void a(T t);

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f68723e && this.f68722d : invokeV.booleanValue;
    }

    public abstract void b(int i2);

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f68721c : invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            GDTLogger.e(getClass().getSimpleName() + ":此构造方法已废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo，构造函数中传入的appId将被忽略，实际使用的是GDTADManager.getInstance().initWith() 传入的appId");
        }
    }
}
