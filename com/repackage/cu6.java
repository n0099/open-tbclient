package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.du6;
import com.repackage.yb8;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class cu6 extends nn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<nn> b;

    public cu6() {
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
        this.a = false;
    }

    public static cu6 c(yb8 yb8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yb8Var)) == null) {
            if (yb8Var == null || ListUtils.isEmpty(yb8Var.b)) {
                return null;
            }
            cu6 cu6Var = new cu6();
            ArrayList arrayList = new ArrayList();
            cu6Var.k(arrayList);
            for (yb8.b bVar : yb8Var.b) {
                if (!ListUtils.isEmpty(bVar.b)) {
                    du6 du6Var = new du6();
                    cu6Var.a = StringUtils.isNull(bVar.a) || cu6Var.a;
                    du6Var.a = bVar.a;
                    for (int i = 0; i < bVar.b.size() && i < 3; i++) {
                        du6Var.d[i] = new du6.a();
                        du6.a aVar = du6Var.d[i];
                        aVar.r(bVar.b.get(i).b);
                        aVar.p(bVar.b.get(i).e);
                        aVar.x(bVar.b.get(i).f);
                        aVar.o(bVar.b.get(i).c);
                        aVar.s(bVar.b.get(i).d);
                        aVar.t(Long.valueOf(bVar.b.get(i).a));
                    }
                    arrayList.add(du6Var);
                    if (arrayList.size() >= 6) {
                        break;
                    }
                }
            }
            return cu6Var;
        }
        return (cu6) invokeL.objValue;
    }

    public static boolean m(DiscoverHotForum discoverHotForum, int i) {
        InterceptResult invokeLI;
        Integer num;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, discoverHotForum, i)) == null) ? TbadkCoreApplication.isLogin() && UbsABTestHelper.needShowRecommendBarCard() && discoverHotForum != null && (num = discoverHotForum.floor) != null && (i < 0 || i == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list) : invokeLI.booleanValue;
    }

    public List<nn> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.booleanValue;
    }

    @Override // com.repackage.nn4
    public kp4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (kp4) invokeV.objValue;
    }

    @Override // com.repackage.nn4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? vy5.x0 : (BdUniqueId) invokeV.objValue;
    }

    public boolean i(List<DiscoverTabCard> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            List<nn> arrayList = new ArrayList<>();
            k(arrayList);
            for (int i = 0; i < list.size(); i++) {
                DiscoverTabCard discoverTabCard = list.get(i);
                List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
                if (list2 != null && list2.size() >= 3) {
                    du6 du6Var = new du6();
                    this.a = StringUtils.isNull(discoverTabCard.name) || this.a;
                    du6Var.a = discoverTabCard.name;
                    Boolean bool = discoverTabCard.is_show_order_number;
                    du6Var.b = bool == null ? false : bool.booleanValue();
                    du6Var.c = discoverTabCard.jump_name;
                    for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                        du6Var.d[i2] = new du6.a();
                        du6.a aVar = du6Var.d[i2];
                        aVar.r(discoverTabCard.forum_list.get(i2).forum_name);
                        aVar.p(discoverTabCard.forum_list.get(i2).avatar);
                        aVar.u(discoverTabCard.forum_list.get(i2).hot_text);
                        aVar.x(discoverTabCard.forum_list.get(i2).slogan);
                        aVar.o(discoverTabCard.forum_list.get(i2).member_count.intValue());
                        aVar.s(discoverTabCard.forum_list.get(i2).thread_count.intValue());
                        aVar.m(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1);
                        aVar.t(discoverTabCard.forum_list.get(i2).forum_id);
                        aVar.w(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
                    }
                    arrayList.add(du6Var);
                    if (arrayList.size() >= 6) {
                        break;
                    }
                }
            }
            return arrayList.size() > 0;
        }
        return invokeL.booleanValue;
    }

    public void k(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.b = list;
        }
    }
}
