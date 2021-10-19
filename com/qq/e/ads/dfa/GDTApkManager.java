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
/* loaded from: classes10.dex */
public class GDTApkManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DFA f75496a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f75497b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f75498c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f75499d;

    /* renamed from: e  reason: collision with root package name */
    public Context f75500e;

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
        this.f75497b = false;
        this.f75498c = false;
        this.f75499d = new AtomicInteger(0);
        if (GDTADManager.getInstance().isInitialized()) {
            if (TextUtils.isEmpty(GDTADManager.getInstance().getAppStatus().getAPPID()) || context == null) {
                str = "初始化错误：GDTApkManager 构造失败，Context和appID不能为空";
            } else if (a.a(context)) {
                this.f75497b = true;
                this.f75500e = context;
                GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, iGDTApkListener) { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ IGDTApkListener f75501a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ GDTApkManager f75502b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                            newInitContext2.initArgs = r2;
                            Object[] objArr2 = {this, iGDTApkListener};
                            interceptable2.invokeUnInit(65536, newInitContext2);
                            int i4 = newInitContext2.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext2.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext2);
                                return;
                            }
                        }
                        this.f75502b = this;
                        this.f75501a = iGDTApkListener;
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
                                    public /* synthetic */ POFactory f75503a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public /* synthetic */ AnonymousClass1 f75504b;

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
                                        this.f75504b = this;
                                        this.f75503a = r7;
                                    }

                                    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, IGET, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            try {
                                                if (this.f75503a != null) {
                                                    this.f75504b.f75502b.f75496a = GDTADManager.getInstance().getPM().getPOFactory().getGDTApkDelegate(this.f75504b.f75501a);
                                                    this.f75504b.f75502b.f75498c = true;
                                                    while (this.f75504b.f75502b.f75499d.getAndDecrement() > 0) {
                                                        this.f75504b.f75502b.loadGDTApk();
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
                return;
            } else {
                str = "初始化错误：必需的 Activity/Service/Permission 没有在AndroidManifest.xml中声明";
            }
            GDTLogger.e(str);
        }
    }

    public final void loadGDTApk() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f75497b) {
            if (!this.f75498c) {
                this.f75499d.incrementAndGet();
                return;
            }
            DFA dfa = this.f75496a;
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gDTApk) == null) || (dfa = this.f75496a) == null) {
            return;
        }
        dfa.startInstall(this.f75500e, gDTApk);
    }
}
