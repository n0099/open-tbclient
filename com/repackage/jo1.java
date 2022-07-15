package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class jo1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public ko1 b;

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ jo1 b;

        public a(jo1 jo1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jo1Var;
            this.a = str;
        }

        @Override // com.repackage.jo1.b
        public void a(hs1 hs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hs1Var) == null) {
                if (jo1.c) {
                    Log.d("SwanAutoSyncApiHandler", this.b.a + " async callback: " + hs1Var.toString());
                }
                this.b.b.d(this.a, hs1Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(hs1 hs1Var);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755582043, "Lcom/repackage/jo1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755582043, "Lcom/repackage/jo1;");
                return;
            }
        }
        c = rg1.a;
    }

    public jo1(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    @NonNull
    public abstract hs1 d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract hs1 e(@NonNull JSONObject jSONObject);

    public hs1 f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull ko1 ko1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, ko1Var)) == null) {
            this.b = ko1Var;
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str);
            }
            return i() ? h(jSONObject) : g(jSONObject, str);
        }
        return (hs1) invokeLLL.objValue;
    }

    public final hs1 g(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, str)) == null) {
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " start handle async");
            }
            hs1 d = d(jSONObject, new a(this, str));
            if (!d.h("isSync", Boolean.FALSE)) {
                if (c) {
                    Log.e("SwanAutoSyncApiHandler", this.a + " handleAsync encounter error, json exception");
                }
                return new hs1(1001, "make result json error");
            }
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " end handle async, processing in other thread, sync result: " + d.toString());
            }
            return d;
        }
        return (hs1) invokeLL.objValue;
    }

    public final hs1 h(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " start handle sync");
            }
            hs1 e = e(jSONObject);
            if (!e.h("isSync", Boolean.TRUE)) {
                if (c) {
                    Log.e("SwanAutoSyncApiHandler", this.a + " handleSync encounter error, json exception");
                }
                return new hs1(1001, "make result json error");
            }
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " end handle sync, result: " + e.toString());
            }
            return e;
        }
        return (hs1) invokeL.objValue;
    }

    public abstract boolean i();
}
