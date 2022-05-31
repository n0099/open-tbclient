package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i05;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class r26 extends i05 {
    public static /* synthetic */ Interceptable $ic;
    public static r26 b;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<l05> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755402181, "Lcom/repackage/r26;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755402181, "Lcom/repackage/r26;");
                return;
            }
        }
        b = new r26();
    }

    public r26() {
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

    public static synchronized r26 e() {
        InterceptResult invokeV;
        r26 r26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (r26.class) {
                r26Var = b;
            }
            return r26Var;
        }
        return (r26) invokeV.objValue;
    }

    @Override // com.repackage.i05
    public void b(i05.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            LinkedList<l05> linkedList = this.a;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<l05> it = this.a.iterator();
                while (it.hasNext()) {
                    l05 next = it.next();
                    if (aVar != null) {
                        aVar.a(next);
                    }
                }
            } else if (TbFaceManager.i().m() > 0) {
                this.a = new LinkedList<>();
                q26 q26Var = new q26();
                this.a.add(q26Var);
                if (aVar != null) {
                    aVar.a(q26Var);
                }
            }
        }
    }

    @Override // com.repackage.i05
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.i05
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            LinkedList<l05> linkedList = this.a;
            if (linkedList != null) {
                Iterator<l05> it = linkedList.iterator();
                while (it.hasNext()) {
                    if (it.next().m(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LinkedList<l05> linkedList = this.a;
            return linkedList == null || linkedList.size() == 0;
        }
        return invokeV.booleanValue;
    }
}
