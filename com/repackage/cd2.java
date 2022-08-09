package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class cd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, dd2> a;

    public cd2() {
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
        this.a = new HashMap<>();
    }

    public void a(dd2 dd2Var, String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, dd2Var, strArr) == null) || strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                this.a.put(str, dd2Var);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.clear();
        }
    }

    public ArrayList<dd2> c(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            ArrayList<dd2> arrayList = null;
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        for (String str2 : this.a.keySet()) {
                            if (str2.startsWith(str) || str.startsWith(str2)) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList<>();
                                }
                                arrayList.add(this.a.get(str2));
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void d(dd2 dd2Var, String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, dd2Var, strArr) == null) || strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && this.a.get(str) == dd2Var) {
                this.a.remove(str);
            }
        }
    }
}
