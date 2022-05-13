package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes6.dex */
public class ny7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ry7> a;

    public ny7() {
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

    public ArrayList<ry7> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public final boolean b(ExcContent excContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, excContent)) == null) {
            long longValue = excContent.type.longValue();
            return longValue == 2 || longValue == 0 || longValue == 1;
        }
        return invokeL.booleanValue;
    }

    public void c(TbPageContext<?> tbPageContext, List<ExcContent> list) {
        uy7 uy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        loop0: while (true) {
            uy7Var = null;
            for (ExcContent excContent : list) {
                if (excContent != null && excContent.type != null) {
                    if (b(excContent)) {
                        qy7 a = ty7.a(tbPageContext, excContent);
                        if (a == null) {
                            continue;
                        } else if (a.a()) {
                            if (uy7Var != null) {
                                this.a.add(uy7Var);
                            }
                            this.a.add(a);
                        } else {
                            if (uy7Var == null) {
                                uy7Var = new uy7();
                            }
                            uy7Var.c(a.b());
                        }
                    } else {
                        if (uy7Var != null) {
                            this.a.add(uy7Var);
                        }
                        this.a.add(ty7.b(excContent));
                    }
                }
            }
            break loop0;
        }
        if (uy7Var != null) {
            this.a.add(uy7Var);
        }
    }
}
