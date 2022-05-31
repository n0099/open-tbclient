package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class xh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, yh5> a;
    public ArrayList<Integer> b;
    public zh5 c;

    public xh5(zh5 zh5Var, ArrayList<Integer> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zh5Var, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = arrayList;
        this.c = zh5Var;
        this.a = new HashMap<>();
    }

    public int a(String str, int i) {
        InterceptResult invokeLI;
        ArrayList<Integer> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (this.a == null || ki.isEmpty(str) || (arrayList = this.b) == null || !arrayList.contains(Integer.valueOf(i))) {
                return 0;
            }
            if (!this.a.containsKey(str)) {
                b(str);
            }
            yh5 yh5Var = this.a.get(str);
            if (yh5Var == null) {
                return 0;
            }
            return yh5Var.a(i);
        }
        return invokeLI.intValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.a == null || ki.isEmpty(str) || this.c == null) {
            return;
        }
        if (this.a.containsKey(str)) {
            yh5 yh5Var = this.a.get(str);
            this.c.b(this.b, yh5Var);
            this.a.put(str, yh5Var);
            return;
        }
        yh5 yh5Var2 = new yh5();
        this.c.b(this.b, yh5Var2);
        this.a.put(str, yh5Var2);
    }
}
