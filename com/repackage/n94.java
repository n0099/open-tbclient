package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Vector;
/* loaded from: classes6.dex */
public class n94 implements d94 {
    public static /* synthetic */ Interceptable $ic;
    public static final hc4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public Vector<d94> a;
    public Object b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755514680, "Lcom/repackage/n94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755514680, "Lcom/repackage/n94;");
                return;
            }
        }
        c = hc4.e();
    }

    public n94(d94 d94Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d94Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new Object();
        this.a = new Vector<>();
        c(d94Var);
    }

    @Override // com.repackage.d94
    public <T> void a(h94<T> h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h94Var) == null) {
            try {
                synchronized (this.b) {
                    Iterator<d94> it = this.a.iterator();
                    while (it.hasNext()) {
                        it.next().a(h94Var);
                    }
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskRunning error", th);
            }
        }
    }

    @Override // com.repackage.d94
    public <T> void b(h94<T> h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h94Var) == null) {
            Vector vector = new Vector();
            try {
                synchronized (this.b) {
                    Iterator<d94> it = this.a.iterator();
                    while (it.hasNext()) {
                        vector.add(it.next());
                    }
                }
                Iterator it2 = vector.iterator();
                while (it2.hasNext()) {
                    ((d94) it2.next()).b(h94Var);
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskEnd error", th);
            }
        }
    }

    public void c(d94 d94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d94Var) == null) || d94Var == null) {
            return;
        }
        synchronized (this.b) {
            this.a.add(d94Var);
        }
    }

    public void d(d94 d94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, d94Var) == null) || d94Var == null) {
            return;
        }
        synchronized (this.b) {
            if (!this.a.remove(d94Var)) {
                this.a.remove(this.a.indexOf(d94Var));
            }
        }
    }
}
