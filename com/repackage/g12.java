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
/* loaded from: classes6.dex */
public class g12 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final p02 a;
    public final y02 b;
    public final m02 c;
    public String d;

    /* loaded from: classes6.dex */
    public class a implements p02.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SceneType a;
        public final /* synthetic */ a12 b;
        public final /* synthetic */ o02 c;
        public final /* synthetic */ g12 d;

        public a(g12 g12Var, SceneType sceneType, a12 a12Var, o02 o02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g12Var, sceneType, a12Var, o02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = g12Var;
            this.a = sceneType;
            this.b = a12Var;
            this.c = o02Var;
        }

        @Override // com.repackage.p02.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                g02.b(this.d.d);
                j02.i(1);
                i02.e(this.a.getType(), networkStatus.getStatus(), this.b.e().getStatus(), this.b.g(), this.b.b(), this.b.f(), this.b.a());
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getScene());
                sb.append(this.c.a());
                sb.append(this.b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.b.c());
                j02.g(sb.toString());
                if (g12.e) {
                    Log.d("SceneSkeletonTips", ">> " + sb.toString());
                }
                this.d.h(networkStatus, this.c, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements p02.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(g12 g12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.p02.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                y02.d().j();
                m02.d().j();
                g02.c();
                j02.i(0);
                i02.c("exit_skeleton", networkStatus.getStatus());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755730967, "Lcom/repackage/g12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755730967, "Lcom/repackage/g12;");
                return;
            }
        }
        e = rg1.a;
    }

    public g12() {
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
        this.c = m02.d();
        this.a = new p02();
        this.b = y02.d();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (e) {
                Log.d("SceneSkeletonTips", ">> trigger skeleton error event.");
            }
            this.a.a(new b(this));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f(SceneType.SCENE_SKELETON_TIMEOUT);
        }
    }

    public void f(SceneType sceneType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sceneType) == null) {
            if (be3.I(this.d) && be3.H()) {
                if (e) {
                    Log.d("SceneSkeletonTips", ">> trigger skeleton remove event.");
                }
                y02.d().j();
                m02.d().j();
                o02 f = this.c.f();
                this.a.a(new a(this, sceneType, this.b.f(), f));
            } else if (e) {
                Log.d("SceneSkeletonTips", "path is not first page: " + this.d);
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    public final void h(@NonNull NetworkStatus networkStatus, @NonNull o02 o02Var, @NonNull a12 a12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, networkStatus, o02Var, a12Var) == null) {
            boolean b2 = o02Var.b();
            int i = R.string.obfuscated_res_0x7f0f131f;
            if (b2) {
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
