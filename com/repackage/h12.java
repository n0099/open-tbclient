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
import com.repackage.p02;
import java.util.Locale;
/* loaded from: classes6.dex */
public class h12 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final p02 a;
    public final y02 b;
    public final m02 c;
    public SceneType d;

    /* loaded from: classes6.dex */
    public class a implements p02.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a12 a;
        public final /* synthetic */ o02 b;
        public final /* synthetic */ h12 c;

        public a(h12 h12Var, a12 a12Var, o02 o02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h12Var, a12Var, o02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h12Var;
            this.a = a12Var;
            this.b = o02Var;
        }

        @Override // com.repackage.p02.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                i02.e(this.c.d.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                boolean m0 = b72.U().m0();
                long n = oj2.g0().n();
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
                if (h12.e) {
                    Log.d("SceneWhiteScreenTips", ">> " + sb.toString());
                }
                j02.g(sb.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755701176, "Lcom/repackage/h12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755701176, "Lcom/repackage/h12;");
                return;
            }
        }
        e = rg1.a;
    }

    public h12() {
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
        this.c = m02.d();
        this.a = new p02();
        this.b = y02.d();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (w02.b().c()) {
                if (e) {
                    Log.d("SceneWhiteScreenTips", ">> start to recheck white screen.");
                }
                w02.b().h(u02.b(str, 3000L));
                w02.b().f();
                return;
            }
            if (e) {
                Log.d("SceneWhiteScreenTips", ">> no need to recheck white screen.");
            }
            if (e) {
                Log.d("SceneWhiteScreenTips", ">> start handle white screen tips.");
            }
            y02.d().j();
            m02.d().j();
            w02.b().j(true);
            o02 f = this.c.f();
            this.a.a(new a(this, this.b.f(), f));
        }
    }

    public void e(SceneType sceneType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sceneType) == null) {
            this.d = sceneType;
        }
    }

    public final void f(@NonNull NetworkStatus networkStatus, @NonNull o02 o02Var, @NonNull a12 a12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, networkStatus, o02Var, a12Var) == null) {
            boolean b = o02Var.b();
            int i = R.string.obfuscated_res_0x7f0f131f;
            if (b) {
                i = R.string.obfuscated_res_0x7f0f1324;
            } else if (a12Var.e() == RequestStatus.STATUS_SERVER_FAILED) {
                i = R.string.obfuscated_res_0x7f0f1322;
            } else if (a12Var.e() != RequestStatus.STATUS_FAILED) {
                if (a12Var.e() == RequestStatus.STATUS_SLOW) {
                    i = (networkStatus == NetworkStatus.NETWORK_BAD || networkStatus == NetworkStatus.NETWORK_OFFLINE) ? R.string.obfuscated_res_0x7f0f1323 : R.string.obfuscated_res_0x7f0f1320;
                } else if (a12Var.e() != RequestStatus.STATUS_CORE_FAILED) {
                    i = R.string.obfuscated_res_0x7f0f1321;
                }
            }
            h02.f(i);
        }
    }
}
