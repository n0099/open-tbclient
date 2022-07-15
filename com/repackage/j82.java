package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m53;
/* loaded from: classes6.dex */
public class j82 implements PermissionProxy {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PermissionListener c;
        public final /* synthetic */ j82 d;

        public a(j82 j82Var, String str, String str2, PermissionListener permissionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j82Var, str, str2, permissionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = j82Var;
            this.a = str;
            this.b = str2;
            this.c = permissionListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.d.b(this.a, this.b, this.c);
                } else {
                    this.c.onPermissionResult(this.a, 2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements kv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PermissionListener a;
        public final /* synthetic */ String b;

        public b(j82 j82Var, PermissionListener permissionListener, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j82Var, permissionListener, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = permissionListener;
            this.b = str;
        }

        @Override // com.repackage.kv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.onPermissionResult(this.b, 0);
            }
        }

        @Override // com.repackage.kv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.onPermissionResult(this.b, 1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755634867, "Lcom/repackage/j82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755634867, "Lcom/repackage/j82;");
                return;
            }
        }
        a = rg1.a;
    }

    public j82() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void b(@NonNull String str, @NonNull String str2, @NonNull PermissionListener permissionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, permissionListener) == null) {
            b bVar = new b(this, permissionListener, str);
            jv2.e(str2, new String[]{str2}, 2, g03.K().w(), bVar);
        }
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null) {
                return null;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1785599184) {
                if (hashCode == -1352756132 && str.equals(PermissionProxy.SCOPE_ID_RECORD)) {
                    c = 1;
                }
            } else if (str.equals(PermissionProxy.SCOPE_ID_CAMERA)) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    return null;
                }
                return "android.permission.RECORD_AUDIO";
            }
            return "android.permission.CAMERA";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.smallgame.sdk.permission.PermissionProxy
    public void requestPermission(String str, PermissionListener permissionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, permissionListener) == null) {
            if (a) {
                Log.d("V8PermissionDelegate", "requestPermission : " + str);
            }
            if (permissionListener == null) {
                if (a) {
                    Log.e("V8PermissionDelegate", "PermissionListener can not be null.");
                    return;
                }
                return;
            }
            String c = c(str);
            h03 M = h03.M();
            if (!TextUtils.isEmpty(c) && M != null && M.w() != null) {
                M.e0().g(M.w(), str, new a(this, str, c, permissionListener));
            } else {
                permissionListener.onPermissionResult(str, 2);
            }
        }
    }
}
