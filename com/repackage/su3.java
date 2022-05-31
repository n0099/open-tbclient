package com.repackage;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class su3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements ae3<h43> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or1 a;

        public a(or1 or1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = or1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(h43 h43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h43Var) == null) {
                if (h43Var == null || h43Var.d || h43Var.j != 1) {
                    su3.c(this.a, false, "system deny");
                } else {
                    su3.c(this.a, true, "authorize:ok");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755308096, "Lcom/repackage/su3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755308096, "Lcom/repackage/su3;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void b(JsObject jsObject) {
        or1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, jsObject) == null) || (F = or1.F(jsObject)) == null) {
            return;
        }
        hz2 a0 = hz2.a0();
        if (a0 == null) {
            c(F, false, "authorize:fail internal error");
        } else {
            a0.d0().e("mapp_enable_eval", new a(F));
        }
    }

    public static void c(or1 or1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{or1Var, Boolean.valueOf(z), str}) == null) {
            if (a) {
                Log.i("AuthorizeEvalApi", "callAsyncCallback: " + str);
            }
            pt3 pt3Var = new pt3();
            pt3Var.errMsg = str;
            s14.call(or1Var, z, pt3Var);
        }
    }
}
