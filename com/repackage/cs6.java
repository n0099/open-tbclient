package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.ActivityPageResIdl;
import tbclient.ActivityPage.DataRes;
import tbclient.ActivityPage.HotTopic;
import tbclient.ActivityPage.RecommendForumList;
import tbclient.ActivityPage.RecommendUserList;
import tbclient.ActivityPage.SpecialColumnList;
import tbclient.BannerImage;
import tbclient.Error;
/* loaded from: classes5.dex */
public class cs6 extends ka5<ActivityPageResIdl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ha5 c;
    public List<ThreadData> d;
    public List<ym4> e;
    public mn4 f;
    public ko4 g;

    public cs6() {
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
        this.c = new ha5();
    }

    @Override // com.repackage.na5
    public final void a(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, bArr) == null) {
            ActivityPageResIdl activityPageResIdl = (ActivityPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ActivityPageResIdl.class);
            Error error = activityPageResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                b(num.intValue());
                c(activityPageResIdl.error.errmsg);
            }
            Error error2 = activityPageResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                b(activityPageResIdl.error.errorno.intValue());
                c(activityPageResIdl.error.errmsg);
            }
            if (getErrorCode() == 0 && (dataRes = activityPageResIdl.data) != null) {
                j(dataRes);
            }
        }
    }

    @Override // com.repackage.ka5
    public List<ym4> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    @Override // com.repackage.ka5
    public List<ThreadData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    @Override // com.repackage.ka5, com.repackage.na5
    public ha5 getPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (ha5) invokeV.objValue;
    }

    @Override // com.repackage.ka5
    public List<nn> i(List<? extends nn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) ? db5.a(list) : (List) invokeL.objValue;
    }

    public final void j(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) {
            m(dataRes);
            n(dataRes);
            l(dataRes);
            k(dataRes);
        }
    }

    public final void k(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dataRes) == null) {
            ArrayList arrayList = new ArrayList();
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && ListUtils.getCount(recommendForumList.forum_list) >= 5) {
                op4 op4Var = new op4();
                op4Var.j(recommendForumList.forum_list);
                op4Var.f = recommendForumList.class_name;
                op4Var.floorPosition = recommendForumList.floor_position.intValue();
                op4Var.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f81);
                op4Var.e = R.color.CAM_X0108;
                arrayList.add(op4Var);
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && ListUtils.getCount(recommendUserList.user_list) >= 4) {
                sp4 sp4Var = new sp4();
                sp4Var.f(recommendUserList.user_list);
                sp4Var.floorPosition = recommendUserList.floor_position.intValue();
                sp4Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f99);
                sp4Var.b = R.color.CAM_X0108;
                arrayList.add(sp4Var);
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && ListUtils.getCount(hotTopic.topic_list) >= 4) {
                e07 e07Var = new e07();
                e07Var.h(hotTopic);
                arrayList.add(e07Var);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && ListUtils.getCount(specialColumnList.item_list) >= 3) {
                SpecialColumnListData specialColumnListData = new SpecialColumnListData();
                specialColumnListData.parserProtobuf(specialColumnList);
                arrayList.add(specialColumnListData);
            }
            this.e = arrayList;
        }
    }

    public final void l(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            List<BannerImage> list = dataRes.banner_image;
            if (!ListUtils.isEmpty(list)) {
                mn4 mn4Var = new mn4();
                this.f = mn4Var;
                mn4Var.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (ListUtils.getCount(list2) >= 4) {
                ko4 ko4Var = new ko4();
                this.g = ko4Var;
                ko4Var.parserProtobuf(list2);
            }
        }
    }

    public final void m(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dataRes) == null) {
            this.c.a(dataRes.page_info);
        }
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dataRes) == null) {
            this.d = db5.c(dataRes.thread_list);
        }
    }
}
