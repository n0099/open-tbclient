package com.qq.e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class GDTApkManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DFA f67846a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67847b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67848c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f67849d;

    /* renamed from: e  reason: collision with root package name */
    public Context f67850e;

    public GDTApkManager(Context context, IGDTApkListener iGDTApkListener) {
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
        this.f67847b = false;
        this.f67848c = false;
        this.f67849d = new AtomicInteger(0);
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), iGDTApkListener);
        }
    }

    private void a(Context context, String str, IGDTApkListener iGDTApkListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, context, str, iGDTApkListener) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                GDTLogger.e("初始化错误：GDTApkManager 构造失败，Context和appID不能为空");
            } else if (!a.a(context)) {
                GDTLogger.e("初始化错误：必需的 Activity/Service/Permission 没有在AndroidManifest.xml中声明");
            } else {
                this.f67847b = true;
                this.f67850e = context;
                GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, iGDTApkListener) { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ IGDTApkListener f67851a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ GDTApkManager f67852b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iGDTApkListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67852b = this;
                        this.f67851a = iGDTApkListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ POFactory f67853a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass1 f67854b;

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
                                        this.f67854b = this;
                                        this.f67853a = r7;
                                    }

                                    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, IGET, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            try {
                                                if (this.f67853a != null) {
                                                    this.f67854b.f67852b.f67846a = GDTADManager.getInstance().getPM().getPOFactory().getGDTApkDelegate(this.f67854b.f67851a);
                                                    this.f67854b.f67852b.f67848c = true;
                                                    while (this.f67854b.f67852b.f67849d.getAndDecrement() > 0) {
                                                        this.f67854b.f67852b.loadGDTApk();
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
                                GDTLogger.e("初始化错误：初始化时发生异常", th);
                            }
                        }
                    }
                });
            }
        }
    }

    public final void loadGDTApk() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f67847b) {
            if (!this.f67848c) {
                this.f67849d.incrementAndGet();
                return;
            }
            DFA dfa = this.f67846a;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                GDTLogger.e("调用loadGDTApk失败，实例未被正常初始化");
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gDTApk) == null) || (dfa = this.f67846a) == null) {
            return;
        }
        dfa.startInstall(this.f67850e, gDTApk);
    }
}
