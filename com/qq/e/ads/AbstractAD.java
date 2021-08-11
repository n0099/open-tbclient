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
/* loaded from: classes10.dex */
public abstract class AbstractAD<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public T f74712a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f74713b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f74714c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f74715d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f74716e;

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
        this.f74714c = false;
        this.f74715d = false;
        this.f74713b = new Handler(Looper.getMainLooper());
    }

    public static final void a(Class cls, ADEvent aDEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cls, aDEvent) == null) {
            GDTLogger.e(cls.getSimpleName() + ":ADEvent参数错误(" + aDEvent + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public abstract T a(Context context, POFactory pOFactory, String str, String str2);

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                b(i2);
            } else {
                this.f74713b.post(new Runnable(this, i2) { // from class: com.qq.e.ads.AbstractAD.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public /* synthetic */ int f74723a;

                    /* renamed from: b  reason: collision with root package name */
                    public /* synthetic */ AbstractAD f74724b;

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
                        this.f74724b = this;
                        this.f74723a = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f74724b.b(this.f74723a);
                        }
                    }
                });
            }
        }
    }

    public final void a(Context context, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                GDTLogger.e("初始化错误：参数错误context或posId为空");
                a(2001);
                return;
            }
            this.f74716e = true;
            if (GDTADManager.getInstance().isInitialized()) {
                String appid = GDTADManager.getInstance().getAppStatus().getAPPID();
                if (a.a(context)) {
                    this.f74715d = true;
                    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, appid, str) { // from class: com.qq.e.ads.AbstractAD.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Context f74717a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f74718b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f74719c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ AbstractAD f74720d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context, appid, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f74720d = this;
                            this.f74717a = context;
                            this.f74718b = appid;
                            this.f74719c = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    this.f74720d.f74713b.post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.AbstractAD.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public /* synthetic */ POFactory f74721a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public /* synthetic */ AnonymousClass1 f74722b;

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
                                            this.f74722b = this;
                                            this.f74721a = r7;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                try {
                                                    if (this.f74721a == null) {
                                                        this.f74722b.f74720d.f74714c = true;
                                                        this.f74722b.f74720d.a(200102);
                                                        return;
                                                    }
                                                    this.f74722b.f74720d.f74712a = (T) this.f74722b.f74720d.a(this.f74722b.f74717a, this.f74721a, this.f74722b.f74718b, this.f74722b.f74719c);
                                                    this.f74722b.f74720d.f74714c = true;
                                                    if (this.f74722b.f74720d.f74712a == null) {
                                                        this.f74722b.f74720d.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                                    } else {
                                                        this.f74722b.f74720d.a((AbstractAD) this.f74722b.f74720d.f74712a);
                                                    }
                                                } catch (Throwable th) {
                                                    GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                                    this.f74722b.f74720d.f74714c = true;
                                                    this.f74722b.f74720d.a(2001);
                                                }
                                            }
                                        }
                                    });
                                } catch (Throwable th) {
                                    GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                                    this.f74720d.f74714c = true;
                                    this.f74720d.a(200102);
                                }
                            }
                        }
                    });
                    return;
                }
                GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
                i2 = 4002;
            } else {
                i2 = 2003;
            }
            a(i2);
        }
    }

    public abstract void a(T t);

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f74714c : invokeV.booleanValue;
    }

    public abstract void b(int i2);

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f74716e && this.f74715d : invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            GDTLogger.e(getClass().getSimpleName() + ":此构造方法已废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo，构造函数中传入的appId将被忽略，实际使用的是GDTADManager.getInstance().initWith() 传入的appId");
        }
    }
}
