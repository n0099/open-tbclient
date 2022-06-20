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
import com.repackage.db8;
import com.repackage.pt6;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes6.dex */
public class ot6 extends ym4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<nn> b;

    public ot6() {
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

    public static ot6 c(db8 db8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, db8Var)) == null) {
            if (db8Var == null || ListUtils.isEmpty(db8Var.b)) {
                return null;
            }
            ot6 ot6Var = new ot6();
            ArrayList arrayList = new ArrayList();
            ot6Var.l(arrayList);
            for (db8.b bVar : db8Var.b) {
                if (!ListUtils.isEmpty(bVar.b)) {
                    pt6 pt6Var = new pt6();
                    ot6Var.a = StringUtils.isNull(bVar.a) || ot6Var.a;
                    pt6Var.a = bVar.a;
                    for (int i = 0; i < bVar.b.size() && i < 3; i++) {
                        pt6Var.d[i] = new pt6.a();
                        pt6.a aVar = pt6Var.d[i];
                        aVar.r(bVar.b.get(i).b);
                        aVar.q(bVar.b.get(i).e);
                        aVar.x(bVar.b.get(i).f);
                        aVar.o(bVar.b.get(i).c);
                        aVar.s(bVar.b.get(i).d);
                        aVar.t(Long.valueOf(bVar.b.get(i).a));
                    }
                    arrayList.add(pt6Var);
                    if (arrayList.size() >= 6) {
                        break;
                    }
                }
            }
            return ot6Var;
        }
        return (ot6) invokeL.objValue;
    }

    public static boolean n(DiscoverHotForum discoverHotForum, int i) {
        InterceptResult invokeLI;
        Integer num;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, discoverHotForum, i)) == null) ? TbadkCoreApplication.isLogin() && UbsABTestHelper.needShowRecommendBarCard() && discoverHotForum != null && (num = discoverHotForum.floor) != null && (i < 0 || i == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list) : invokeLI.booleanValue;
    }

    public List<nn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    @Override // com.repackage.ym4
    public vo4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (vo4) invokeV.objValue;
    }

    @Override // com.repackage.ym4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? yx5.x0 : (BdUniqueId) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public boolean j(List<DiscoverTabCard> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            List<nn> arrayList = new ArrayList<>();
            l(arrayList);
            for (int i = 0; i < list.size(); i++) {
                DiscoverTabCard discoverTabCard = list.get(i);
                List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
                if (list2 != null && list2.size() >= 3) {
                    pt6 pt6Var = new pt6();
                    this.a = StringUtils.isNull(discoverTabCard.name) || this.a;
                    pt6Var.a = discoverTabCard.name;
                    Boolean bool = discoverTabCard.is_show_order_number;
                    pt6Var.b = bool == null ? false : bool.booleanValue();
                    pt6Var.c = discoverTabCard.jump_name;
                    for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                        pt6Var.d[i2] = new pt6.a();
                        pt6.a aVar = pt6Var.d[i2];
                        aVar.r(discoverTabCard.forum_list.get(i2).forum_name);
                        aVar.q(discoverTabCard.forum_list.get(i2).avatar);
                        aVar.v(discoverTabCard.forum_list.get(i2).hot_text);
                        aVar.x(discoverTabCard.forum_list.get(i2).slogan);
                        aVar.o(discoverTabCard.forum_list.get(i2).member_count.intValue());
                        aVar.s(discoverTabCard.forum_list.get(i2).thread_count.intValue());
                        aVar.n(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1);
                        aVar.t(discoverTabCard.forum_list.get(i2).forum_id);
                        aVar.w(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
                    }
                    arrayList.add(pt6Var);
                    if (arrayList.size() >= 6) {
                        break;
                    }
                }
            }
            return arrayList.size() > 0;
        }
        return invokeL.booleanValue;
    }

    public void l(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.b = list;
        }
    }
}
