package com.repackage;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class nc0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "nc0";
    public transient /* synthetic */ FieldHolder $fh;
    public pc0 a;
    public List<oc0> b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755474442, "Lcom/repackage/nc0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755474442, "Lcom/repackage/nc0;");
        }
    }

    public nc0(Object obj, List<bd0> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        b(obj, list);
    }

    public void a(long j) {
        List<oc0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.a == null || (list = this.b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (oc0 oc0Var : this.b) {
                this.a.b(oc0Var.c());
                oc0Var.b(j);
            }
            notifyAll();
        }
        this.a.d(j);
        this.a.e();
    }

    public final void b(Object obj, List<bd0> list) {
        oc0 oc0Var;
        pc0 pc0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) || list == null || list.size() == 0) {
            return;
        }
        List<oc0> list2 = this.b;
        if (list2 == null) {
            this.b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                this.b.add(new oc0(list.get(i)));
                if (list.get(i).k()) {
                    this.c = i;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int size = this.b.size();
        int i2 = this.c;
        if (size > i2) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.a = new pc0(this.b.get(this.c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.a = new pc0(this.b.get(this.c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.a = new pc0(this.b.get(this.c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<oc0> list3 = this.b;
                if (list3 != null && list3 != null && (oc0Var = list3.get(i2)) != null && (pc0Var = this.a) != null) {
                    pc0Var.f(oc0Var.c());
                }
            }
        }
        for (oc0 oc0Var2 : this.b) {
            pc0 pc0Var2 = this.a;
            if (pc0Var2 != null) {
                pc0Var2.b(oc0Var2.c());
                oc0Var2.f();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            pc0 pc0Var = this.a;
            if (pc0Var != null) {
                pc0Var.g();
                this.a = null;
            }
            List<oc0> list = this.b;
            if (list != null) {
                for (oc0 oc0Var : list) {
                    oc0Var.e();
                }
                this.b.clear();
                this.b = null;
            }
        }
    }

    public void d(uc0 uc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uc0Var) == null) {
            for (oc0 oc0Var : this.b) {
                pc0 pc0Var = this.a;
                if (pc0Var != null) {
                    pc0Var.b(oc0Var.c());
                    oc0Var.g(uc0Var);
                }
            }
        }
    }

    public void e(List<bd0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Log.d(d, "updateSurfaceDrawer !!!");
            this.a.c();
            for (oc0 oc0Var : this.b) {
                oc0Var.e();
            }
            this.b.clear();
            b(null, list);
        }
    }
}
