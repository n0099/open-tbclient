package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes5.dex */
public class ci8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ai8> a;
    public ArrayList<bi8> b;

    public ci8() {
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
        this.b = new ArrayList<>();
    }

    public void a(ActPost actPost) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, actPost) == null) || actPost == null) {
            return;
        }
        String str = actPost.list_head;
        for (ActHot actHot : actPost.act_hot) {
            if (actHot != null) {
                ai8 ai8Var = new ai8();
                ai8Var.g(actHot);
                this.a.add(ai8Var);
            }
        }
        List<LinkInfo> list = actPost.link_info;
        for (LinkInfo linkInfo : list) {
            if (list != null) {
                bi8 bi8Var = new bi8();
                bi8Var.a(linkInfo);
                this.b.add(bi8Var);
            }
        }
    }
}
