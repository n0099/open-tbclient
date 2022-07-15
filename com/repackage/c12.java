package com.repackage;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.p02;
/* loaded from: classes5.dex */
public class c12 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public boolean b;
    public final p02 c;

    /* loaded from: classes5.dex */
    public class a implements p02.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c12 a;

        public a(c12 c12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c12Var;
        }

        @Override // com.repackage.p02.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                j02.g(SceneType.SCENE_DOWNLOAD_PKG_TIMEOUT.getScene() + networkStatus.getDesc());
                i02.c(SceneType.SCENE_DOWNLOAD_PKG_TIMEOUT.getType(), networkStatus.getStatus());
                this.a.e(networkStatus);
                if (c12.d) {
                    Log.d("SceneDownloadPkgTips", ">> " + SceneType.SCENE_DOWNLOAD_PKG_TIMEOUT.getScene() + networkStatus.getDesc());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-522521873, "Lcom/repackage/c12$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-522521873, "Lcom/repackage/c12$b;");
                    return;
                }
            }
            int[] iArr = new int[NetworkStatus.values().length];
            a = iArr;
            try {
                iArr[NetworkStatus.NETWORK_BAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NetworkStatus.NETWORK_OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755850131, "Lcom/repackage/c12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755850131, "Lcom/repackage/c12;");
                return;
            }
        }
        d = rg1.a;
    }

    public c12() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new p02();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.a(new a(this));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b) {
            if (this.a == 0) {
                if (d) {
                    Log.d("SceneDownloadPkgTips", ">> start to check download progress.");
                }
                this.a = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.a > 2000) {
                if (d) {
                    Log.d("SceneDownloadPkgTips", ">> download progress over 2s.");
                }
                c();
                g();
            }
            this.a = currentTimeMillis;
        }
    }

    public final void e(NetworkStatus networkStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, networkStatus) == null) {
            int i = b.a[networkStatus.ordinal()];
            if (i != 1 && i != 2) {
                h02.f(R.string.obfuscated_res_0x7f0f1326);
            } else {
                h02.f(R.string.obfuscated_res_0x7f0f131c);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = g03.K().k() != 1;
            this.a = 0L;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = false;
            if (d) {
                Log.d("SceneDownloadPkgTips", ">> stop collecting network status.");
            }
        }
    }
}
