package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class fv2 extends gv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements eg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv2 a;
        public final /* synthetic */ e12 b;
        public final /* synthetic */ fv2 c;

        public a(fv2 fv2Var, cv2 cv2Var, e12 e12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv2Var, cv2Var, e12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fv2Var;
            this.a = cv2Var;
            this.b = e12Var;
        }

        @Override // com.repackage.eg1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    dv2 dv2Var = new dv2(this.a.f);
                    dv2Var.a = this.a.e;
                    this.b.a(dv2Var);
                    return;
                }
                this.c.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements le3<e53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz2 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ cv2 c;
        public final /* synthetic */ e12 d;
        public final /* synthetic */ fv2 e;

        public b(fv2 fv2Var, sz2 sz2Var, SwanAppActivity swanAppActivity, cv2 cv2Var, e12 e12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv2Var, sz2Var, swanAppActivity, cv2Var, e12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fv2Var;
            this.a = sz2Var;
            this.b = swanAppActivity;
            this.c = cv2Var;
            this.d = e12Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(e53 e53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e53Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, e53Var, this.d);
            }
        }
    }

    public fv2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.gv2
    public bv2 f(cv2 cv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cv2Var)) == null) {
            return null;
        }
        return (bv2) invokeL.objValue;
    }

    @Override // com.repackage.gv2
    public sr1 j(String str, cv2 cv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cv2Var)) == null) ? new sr1(0) : (sr1) invokeLL.objValue;
    }

    @Override // com.repackage.gv2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.gv2
    public sr1 m(cv2 cv2Var, e12<dv2> e12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cv2Var, e12Var)) == null) {
            if (cv2Var == null || TextUtils.isEmpty(cv2Var.a)) {
                return new sr1(1001, "get fun page info, provider appKey is empty");
            }
            if (e12Var == null) {
                return new sr1(1001, "get fun page info, cb is null");
            }
            sz2 r = rz2.K().r();
            SwanAppActivity x = r.x();
            if (x != null && !x.isFinishing()) {
                if (!r.N().e(r)) {
                    r.N().f(x, null, new a(this, cv2Var, e12Var));
                    return new sr1(1001, "not login");
                }
                o(cv2Var, e12Var);
                return new sr1(0);
            }
            return new sr1(1001, "get fun page info, master has dead");
        }
        return (sr1) invokeLL.objValue;
    }

    public final void o(cv2 cv2Var, e12<dv2> e12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cv2Var, e12Var) == null) {
            kv2.b("start get open data");
            sz2 r = rz2.K().r();
            SwanAppActivity x = r.x();
            e53.B(x, g(), cv2Var.a, true, h(), new b(this, r, x, cv2Var, e12Var));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, cv2 cv2Var, e53 e53Var, e12<dv2> e12Var);
}
