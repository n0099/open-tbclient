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
public class na4 implements da4 {
    public static /* synthetic */ Interceptable $ic;
    public static final hd4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public Vector<da4> a;
    public Object b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755476240, "Lcom/repackage/na4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755476240, "Lcom/repackage/na4;");
                return;
            }
        }
        c = hd4.e();
    }

    public na4(da4 da4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {da4Var};
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
        c(da4Var);
    }

    @Override // com.repackage.da4
    public <T> void a(ha4<T> ha4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ha4Var) == null) {
            try {
                synchronized (this.b) {
                    Iterator<da4> it = this.a.iterator();
                    while (it.hasNext()) {
                        it.next().a(ha4Var);
                    }
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskRunning error", th);
            }
        }
    }

    @Override // com.repackage.da4
    public <T> void b(ha4<T> ha4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ha4Var) == null) {
            Vector vector = new Vector();
            try {
                synchronized (this.b) {
                    Iterator<da4> it = this.a.iterator();
                    while (it.hasNext()) {
                        vector.add(it.next());
                    }
                }
                Iterator it2 = vector.iterator();
                while (it2.hasNext()) {
                    ((da4) it2.next()).b(ha4Var);
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskEnd error", th);
            }
        }
    }

    public void c(da4 da4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, da4Var) == null) || da4Var == null) {
            return;
        }
        synchronized (this.b) {
            this.a.add(da4Var);
        }
    }

    public void d(da4 da4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, da4Var) == null) || da4Var == null) {
            return;
        }
        synchronized (this.b) {
            if (!this.a.remove(da4Var)) {
                this.a.remove(this.a.indexOf(da4Var));
            }
        }
    }
}
