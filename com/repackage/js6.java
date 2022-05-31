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
import com.repackage.ks6;
import com.repackage.w98;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes6.dex */
public class js6 extends om4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<jn> b;

    public js6() {
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

    public static js6 e(w98 w98Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, w98Var)) == null) {
            if (w98Var == null || ListUtils.isEmpty(w98Var.b)) {
                return null;
            }
            js6 js6Var = new js6();
            ArrayList arrayList = new ArrayList();
            js6Var.m(arrayList);
            for (w98.b bVar : w98Var.b) {
                if (!ListUtils.isEmpty(bVar.b)) {
                    ks6 ks6Var = new ks6();
                    js6Var.a = StringUtils.isNull(bVar.a) || js6Var.a;
                    ks6Var.a = bVar.a;
                    for (int i = 0; i < bVar.b.size() && i < 3; i++) {
                        ks6Var.d[i] = new ks6.a();
                        ks6.a aVar = ks6Var.d[i];
                        aVar.r(bVar.b.get(i).b);
                        aVar.q(bVar.b.get(i).e);
                        aVar.x(bVar.b.get(i).f);
                        aVar.p(bVar.b.get(i).c);
                        aVar.s(bVar.b.get(i).d);
                        aVar.u(Long.valueOf(bVar.b.get(i).a));
                    }
                    arrayList.add(ks6Var);
                    if (arrayList.size() >= 6) {
                        break;
                    }
                }
            }
            return js6Var;
        }
        return (js6) invokeL.objValue;
    }

    public static boolean q(DiscoverHotForum discoverHotForum, int i) {
        InterceptResult invokeLI;
        Integer num;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, discoverHotForum, i)) == null) ? TbadkCoreApplication.isLogin() && UbsABTestHelper.needShowRecommendBarCard() && discoverHotForum != null && (num = discoverHotForum.floor) != null && (i < 0 || i == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list) : invokeLI.booleanValue;
    }

    public List<jn> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    @Override // com.repackage.om4
    public lo4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (lo4) invokeV.objValue;
    }

    @Override // com.repackage.om4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.jn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? zw5.x0 : (BdUniqueId) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public boolean k(List<DiscoverTabCard> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            List<jn> arrayList = new ArrayList<>();
            m(arrayList);
            for (int i = 0; i < list.size(); i++) {
                DiscoverTabCard discoverTabCard = list.get(i);
                List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
                if (list2 != null && list2.size() >= 3) {
                    ks6 ks6Var = new ks6();
                    this.a = StringUtils.isNull(discoverTabCard.name) || this.a;
                    ks6Var.a = discoverTabCard.name;
                    Boolean bool = discoverTabCard.is_show_order_number;
                    ks6Var.b = bool == null ? false : bool.booleanValue();
                    ks6Var.c = discoverTabCard.jump_name;
                    for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                        ks6Var.d[i2] = new ks6.a();
                        ks6.a aVar = ks6Var.d[i2];
                        aVar.r(discoverTabCard.forum_list.get(i2).forum_name);
                        aVar.q(discoverTabCard.forum_list.get(i2).avatar);
                        aVar.v(discoverTabCard.forum_list.get(i2).hot_text);
                        aVar.x(discoverTabCard.forum_list.get(i2).slogan);
                        aVar.p(discoverTabCard.forum_list.get(i2).member_count.intValue());
                        aVar.s(discoverTabCard.forum_list.get(i2).thread_count.intValue());
                        aVar.n(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1);
                        aVar.u(discoverTabCard.forum_list.get(i2).forum_id);
                        aVar.w(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
                    }
                    arrayList.add(ks6Var);
                    if (arrayList.size() >= 6) {
                        break;
                    }
                }
            }
            return arrayList.size() > 0;
        }
        return invokeL.booleanValue;
    }

    public void m(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.b = list;
        }
    }
}
