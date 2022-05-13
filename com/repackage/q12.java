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
import com.repackage.c12;
/* loaded from: classes6.dex */
public class q12 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final c12 a;
    public final l12 b;
    public final z02 c;

    /* loaded from: classes6.dex */
    public class a implements c12.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n12 a;
        public final /* synthetic */ b12 b;
        public final /* synthetic */ q12 c;

        public a(q12 q12Var, n12 n12Var, b12 b12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q12Var, n12Var, b12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q12Var;
            this.a = n12Var;
            this.b = b12Var;
        }

        @Override // com.repackage.c12.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                v02.e(SceneType.SCENE_INIT_DATA_ERROR.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                StringBuilder sb = new StringBuilder();
                sb.append(SceneType.SCENE_INIT_DATA_ERROR.getScene());
                sb.append(this.b.a());
                sb.append(this.a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.a.c());
                if (q12.d) {
                    Log.d("SceneInitDataTips", ">> " + sb.toString());
                }
                w02.g(sb.toString());
                this.c.d(networkStatus);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-121713759, "Lcom/repackage/q12$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-121713759, "Lcom/repackage/q12$b;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755433057, "Lcom/repackage/q12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755433057, "Lcom/repackage/q12;");
                return;
            }
        }
        d = eh1.a;
    }

    public q12() {
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
        this.c = z02.d();
        this.a = new c12();
        this.b = l12.d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (d) {
                Log.d("SceneInitDataTips", ">> trigger init data error event.");
            }
            l12.d().j();
            z02.d().j();
            b12 f = this.c.f();
            this.a.a(new a(this, this.b.f(), f));
        }
    }

    public final void d(NetworkStatus networkStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatus) == null) {
            int i = b.a[networkStatus.ordinal()];
            if (i != 1 && i != 2) {
                u02.f(R.string.obfuscated_res_0x7f0f130e);
            } else {
                u02.f(R.string.obfuscated_res_0x7f0f1304);
            }
        }
    }
}
