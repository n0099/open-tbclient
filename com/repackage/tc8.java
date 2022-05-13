package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes7.dex */
public class tc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rc8> a;
    public boolean b;

    public tc8() {
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
        this.b = true;
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        for (ForumList forumList : dataRes.forum_list) {
            rc8 rc8Var = new rc8();
            rc8Var.a = forumList.avatar;
            rc8Var.b = forumList.forum_name;
            rc8Var.c = String.valueOf(forumList.forum_id);
            this.a.add(rc8Var);
        }
        this.b = dataRes.has_more.intValue() == 1;
    }
}
