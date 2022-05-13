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
/* loaded from: classes7.dex */
public class vs6 extends db5<ActivityPageResIdl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ab5 c;
    public List<ThreadData> d;
    public List<zn4> e;
    public no4 f;
    public lp4 g;

    public vs6() {
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
        this.c = new ab5();
    }

    @Override // com.repackage.gb5
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

    @Override // com.repackage.db5
    public List<zn4> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    @Override // com.repackage.db5
    public List<ThreadData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    @Override // com.repackage.db5, com.repackage.gb5
    public ab5 getPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (ab5) invokeV.objValue;
    }

    @Override // com.repackage.db5
    public List<ro> i(List<? extends ro> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) ? wb5.a(list) : (List) invokeL.objValue;
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
                pq4 pq4Var = new pq4();
                pq4Var.k(recommendForumList.forum_list);
                pq4Var.f = recommendForumList.class_name;
                pq4Var.floorPosition = recommendForumList.floor_position.intValue();
                pq4Var.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f65);
                pq4Var.e = R.color.CAM_X0108;
                arrayList.add(pq4Var);
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && ListUtils.getCount(recommendUserList.user_list) >= 4) {
                tq4 tq4Var = new tq4();
                tq4Var.g(recommendUserList.user_list);
                tq4Var.floorPosition = recommendUserList.floor_position.intValue();
                tq4Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7d);
                tq4Var.b = R.color.CAM_X0108;
                arrayList.add(tq4Var);
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && ListUtils.getCount(hotTopic.topic_list) >= 4) {
                r07 r07Var = new r07();
                r07Var.i(hotTopic);
                arrayList.add(r07Var);
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
                no4 no4Var = new no4();
                this.f = no4Var;
                no4Var.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (ListUtils.getCount(list2) >= 4) {
                lp4 lp4Var = new lp4();
                this.g = lp4Var;
                lp4Var.parserProtobuf(list2);
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
            this.d = wb5.c(dataRes.thread_list);
        }
    }
}
