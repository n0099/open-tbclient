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
public class d12 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final p02 a;
    public final y02 b;
    public final m02 c;

    /* loaded from: classes5.dex */
    public class a implements p02.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a12 a;
        public final /* synthetic */ o02 b;
        public final /* synthetic */ d12 c;

        public a(d12 d12Var, a12 a12Var, o02 o02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d12Var, a12Var, o02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d12Var;
            this.a = a12Var;
            this.b = o02Var;
        }

        @Override // com.repackage.p02.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                i02.e(SceneType.SCENE_INIT_DATA_ERROR.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                StringBuilder sb = new StringBuilder();
                sb.append(SceneType.SCENE_INIT_DATA_ERROR.getScene());
                sb.append(this.b.a());
                sb.append(this.a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.a.c());
                if (d12.d) {
                    Log.d("SceneInitDataTips", ">> " + sb.toString());
                }
                j02.g(sb.toString());
                this.c.d(networkStatus);
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-493892722, "Lcom/repackage/d12$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-493892722, "Lcom/repackage/d12$b;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755820340, "Lcom/repackage/d12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755820340, "Lcom/repackage/d12;");
                return;
            }
        }
        d = rg1.a;
    }

    public d12() {
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

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (d) {
                Log.d("SceneInitDataTips", ">> trigger init data error event.");
            }
            y02.d().j();
            m02.d().j();
            o02 f = this.c.f();
            this.a.a(new a(this, this.b.f(), f));
        }
    }

    public final void d(NetworkStatus networkStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatus) == null) {
            int i = b.a[networkStatus.ordinal()];
            if (i != 1 && i != 2) {
                h02.f(R.string.obfuscated_res_0x7f0f1326);
            } else {
                h02.f(R.string.obfuscated_res_0x7f0f131c);
            }
        }
    }
}
