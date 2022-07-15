package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes6.dex */
public class if8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<nn> a;
    public List<RecommendForumInfo> b;
    public Page c;
    public boolean d;
    public int e;
    public int f;
    public int g;

    public if8() {
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
        this.a = new ArrayList();
        this.d = true;
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    public List<nn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public void b(g56 g56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g56Var) == null) {
            String str = g56Var.d;
            this.c = g56Var.c;
            List<RecommendForumInfo> list = g56Var.a;
            this.b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.b) {
                    hf8 hf8Var = new hf8();
                    hf8Var.o(recommendForumInfo);
                    this.a.add(hf8Var);
                }
            }
            Page page = this.c;
            if (page != null) {
                this.d = page.has_more.intValue() == 1;
                this.e = this.c.current_page.intValue();
            }
        }
    }
}
