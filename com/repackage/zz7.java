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
/* loaded from: classes8.dex */
public class zz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<d08> a;

    public zz7() {
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

    public ArrayList<d08> a() {
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
        g08 g08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        loop0: while (true) {
            g08Var = null;
            for (ExcContent excContent : list) {
                if (excContent != null && excContent.type != null) {
                    if (b(excContent)) {
                        c08 a = f08.a(tbPageContext, excContent);
                        if (a == null) {
                            continue;
                        } else if (a.a()) {
                            if (g08Var != null) {
                                this.a.add(g08Var);
                            }
                            this.a.add(a);
                        } else {
                            if (g08Var == null) {
                                g08Var = new g08();
                            }
                            g08Var.c(a.b());
                        }
                    } else {
                        if (g08Var != null) {
                            this.a.add(g08Var);
                        }
                        this.a.add(f08.b(excContent));
                    }
                }
            }
            break loop0;
        }
        if (g08Var != null) {
            this.a.add(g08Var);
        }
    }
}
