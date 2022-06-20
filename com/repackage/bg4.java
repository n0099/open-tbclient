package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class bg4<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<eg4<T>> a;

    public bg4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList(6);
    }

    public void a(eg4<T> eg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eg4Var) == null) || eg4Var == null || this.a.contains(eg4Var)) {
            return;
        }
        this.a.add(eg4Var);
    }

    public T b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<eg4> arrayList = new ArrayList();
            Iterator<eg4<T>> it = this.a.iterator();
            T t = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eg4<T> next = it.next();
                T t2 = next.get();
                if (c(t2)) {
                    t = t2;
                    break;
                }
                arrayList.add(next);
                t = t2;
            }
            if (arrayList.size() > 0) {
                for (eg4 eg4Var : arrayList) {
                    eg4Var.put(t);
                }
            }
            return t;
        }
        return (T) invokeV.objValue;
    }

    public final boolean c(T t) {
        InterceptResult invokeL;
        char[] charArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            if (t != null && (t instanceof String)) {
                String str = (String) t;
                if (str.length() != 32) {
                    return false;
                }
                for (char c : str.toCharArray()) {
                    if ((c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, t) == null) || c(t)) {
            return;
        }
        for (eg4<T> eg4Var : this.a) {
            if (eg4Var.a()) {
                eg4Var.put(t);
            }
        }
    }
}
