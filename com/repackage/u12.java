package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c12;
import java.util.Locale;
/* loaded from: classes7.dex */
public class u12 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final c12 a;
    public final l12 b;
    public final z02 c;
    public SceneType d;

    /* loaded from: classes7.dex */
    public class a implements c12.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n12 a;
        public final /* synthetic */ b12 b;
        public final /* synthetic */ u12 c;

        public a(u12 u12Var, n12 n12Var, b12 b12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u12Var, n12Var, b12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u12Var;
            this.a = n12Var;
            this.b = b12Var;
        }

        @Override // com.repackage.c12.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                v02.e(this.c.d.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                boolean m0 = o72.U().m0();
                long n = bk2.g0().n();
                if (n >= 6000 || m0) {
                    this.c.f(networkStatus, this.b, this.a);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.c.d.getScene());
                sb.append(String.format(Locale.getDefault(), "%d秒截屏；", Long.valueOf(n / 1000)));
                sb.append(m0 ? "框架预加载：已完成；" : "框架预加载：未完成；");
                sb.append(this.b.a());
                sb.append(this.a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.a.c());
                if (u12.e) {
                    Log.d("SceneWhiteScreenTips", ">> " + sb.toString());
                }
                w02.g(sb.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755313893, "Lcom/repackage/u12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755313893, "Lcom/repackage/u12;");
                return;
            }
        }
        e = eh1.a;
    }

    public u12() {
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
        this.d = SceneType.SCENE_WHITE_SCREEN_L1;
        this.c = z02.d();
        this.a = new c12();
        this.b = l12.d();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (j12.b().c()) {
                if (e) {
                    Log.d("SceneWhiteScreenTips", ">> start to recheck white screen.");
                }
                j12.b().h(h12.b(str, 3000L));
                j12.b().f();
                return;
            }
            if (e) {
                Log.d("SceneWhiteScreenTips", ">> no need to recheck white screen.");
            }
            if (e) {
                Log.d("SceneWhiteScreenTips", ">> start handle white screen tips.");
            }
            l12.d().j();
            z02.d().j();
            j12.b().j(true);
            b12 f = this.c.f();
            this.a.a(new a(this, this.b.f(), f));
        }
    }

    public void e(SceneType sceneType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sceneType) == null) {
            this.d = sceneType;
        }
    }

    public final void f(@NonNull NetworkStatus networkStatus, @NonNull b12 b12Var, @NonNull n12 n12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, networkStatus, b12Var, n12Var) == null) {
            boolean b = b12Var.b();
            int i = R.string.obfuscated_res_0x7f0f1307;
            if (b) {
                i = R.string.obfuscated_res_0x7f0f130c;
            } else if (n12Var.e() == RequestStatus.STATUS_SERVER_FAILED) {
                i = R.string.obfuscated_res_0x7f0f130a;
            } else if (n12Var.e() != RequestStatus.STATUS_FAILED) {
                if (n12Var.e() == RequestStatus.STATUS_SLOW) {
                    i = (networkStatus == NetworkStatus.NETWORK_BAD || networkStatus == NetworkStatus.NETWORK_OFFLINE) ? R.string.obfuscated_res_0x7f0f130b : R.string.obfuscated_res_0x7f0f1308;
                } else if (n12Var.e() != RequestStatus.STATUS_CORE_FAILED) {
                    i = R.string.obfuscated_res_0x7f0f1309;
                }
            }
            u02.f(i);
        }
    }
}
