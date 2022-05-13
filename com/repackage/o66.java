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
/* loaded from: classes6.dex */
public class o66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ro> a;
    public ArrayList<vq4> b;
    public pq4 c;
    public q66 d;
    public boolean e;

    public o66() {
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
    public o66 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o66 o66Var = new o66();
            o66Var.a = this.a;
            o66Var.b = this.b;
            o66Var.c = this.c;
            o66Var.d = this.d;
            o66Var.e = this.e;
            return o66Var;
        }
        return (o66) invokeV.objValue;
    }

    public q66 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (q66) invokeV.objValue;
    }

    public pq4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (pq4) invokeV.objValue;
    }

    public ArrayList<vq4> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<ro> e() {
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
                vq4 vq4Var = new vq4();
                vq4Var.e(generalResource);
                this.b.add(vq4Var);
            }
        }
        pq4 pq4Var = new pq4();
        this.c = pq4Var;
        pq4Var.k(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            q66 q66Var = new q66();
            this.d = q66Var;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            q66Var.a = hotUserRankEntry.hot_user;
            q66Var.b = hotUserRankEntry.module_name;
            q66Var.c = hotUserRankEntry.module_icon;
        }
        this.e = dataRes.is_new_url.intValue() == 1;
    }
}
