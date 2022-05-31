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
/* loaded from: classes5.dex */
public class a56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<jn> a;
    public ArrayList<kp4> b;
    public ep4 c;
    public c56 d;
    public boolean e;

    public a56() {
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
    public a56 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a56 a56Var = new a56();
            a56Var.a = this.a;
            a56Var.b = this.b;
            a56Var.c = this.c;
            a56Var.d = this.d;
            a56Var.e = this.e;
            return a56Var;
        }
        return (a56) invokeV.objValue;
    }

    public c56 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (c56) invokeV.objValue;
    }

    public ep4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (ep4) invokeV.objValue;
    }

    public ArrayList<kp4> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<jn> e() {
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
                kp4 kp4Var = new kp4();
                kp4Var.e(generalResource);
                this.b.add(kp4Var);
            }
        }
        ep4 ep4Var = new ep4();
        this.c = ep4Var;
        ep4Var.k(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c56 c56Var = new c56();
            this.d = c56Var;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            c56Var.a = hotUserRankEntry.hot_user;
            c56Var.b = hotUserRankEntry.module_name;
            c56Var.c = hotUserRankEntry.module_icon;
        }
        this.e = dataRes.is_new_url.intValue() == 1;
    }
}
