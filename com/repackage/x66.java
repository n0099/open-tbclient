package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.HotUserRankEntry;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class x66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<nn> a;
    public ArrayList<jq4> b;
    public dq4 c;
    public z66 d;
    public boolean e;

    public x66() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public x66 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            x66 x66Var = new x66();
            x66Var.a = this.a;
            x66Var.b = this.b;
            x66Var.c = this.c;
            x66Var.d = this.d;
            x66Var.e = this.e;
            return x66Var;
        }
        return (x66) invokeV.objValue;
    }

    public z66 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (z66) invokeV.objValue;
    }

    public dq4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (dq4) invokeV.objValue;
    }

    public ArrayList<jq4> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<nn> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public void g(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            ThreadData threadData = new ThreadData();
            threadData.parserProtobuf(threadInfo);
            threadData.insertItemToTitleOrAbstractText();
            this.a.add(threadData);
        }
        this.b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                jq4 jq4Var = new jq4();
                jq4Var.c(generalResource);
                this.b.add(jq4Var);
            }
        }
        dq4 dq4Var = new dq4();
        this.c = dq4Var;
        dq4Var.i(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            z66 z66Var = new z66();
            this.d = z66Var;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            z66Var.a = hotUserRankEntry.hot_user;
            z66Var.b = hotUserRankEntry.module_name;
            z66Var.c = hotUserRankEntry.module_icon;
        }
        this.e = dataRes.is_new_url.intValue() == 1;
    }
}
