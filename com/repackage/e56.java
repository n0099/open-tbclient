package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumGuide.LikeForum;
/* loaded from: classes6.dex */
public class e56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c56> a;

    public e56() {
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
        this.a = new ArrayList<>();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<c56> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().L(0);
            }
        }
    }

    public ArrayList<c56> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public void c(List<?> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
            return;
        }
        d(list, null);
    }

    public void d(List<?> list, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, context) == null) || list == null) {
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!(list.get(i) instanceof LikeForum)) {
                    return;
                }
                c56 c56Var = new c56();
                c56Var.I((LikeForum) list.get(i));
                if (!TextUtils.isEmpty(c56Var.o())) {
                    this.a.add(c56Var);
                }
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
