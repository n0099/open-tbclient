package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
import tbclient.FrsPage.Size;
/* loaded from: classes6.dex */
public class no4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<qo4> a;
    public String b;
    public rn4 c;

    public no4() {
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
    }

    public rn4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (rn4) invokeV.objValue;
    }

    public ArrayList<qo4> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void d(ActivityHead activityHead, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, activityHead, j) == null) || activityHead == null) {
            return;
        }
        activityHead.activity_type.intValue();
        String str = activityHead.activity_title;
        Size size = activityHead.top_size;
        if (size != null) {
            size.width.intValue();
        }
        Size size2 = activityHead.top_size;
        if (size2 != null) {
            size2.height.intValue();
        }
        this.b = activityHead.obj_id;
        f(activityHead.head_imgs);
        rn4 rn4Var = new rn4();
        rn4Var.a = activityHead.pull_down_pic_android;
        rn4Var.b = activityHead.pull_down_url;
        rn4Var.c = activityHead.pull_down_interval.intValue();
        rn4Var.d = activityHead.pull_down_exposure_url;
        rn4Var.e = activityHead.pull_down_click_url;
        rn4Var.f = activityHead.pull_down_schema;
        rn4Var.g = activityHead.pull_down_package_name;
        rn4Var.h = activityHead.is_ad.booleanValue();
        rn4Var.i = activityHead.obj_id;
        rn4Var.j = j;
        this.c = rn4Var;
    }

    public void e(HeadImgs headImgs) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, headImgs) == null) || headImgs == null) {
            return;
        }
        qo4 qo4Var = new qo4();
        qo4Var.q(headImgs);
        this.a.add(qo4Var);
    }

    public void f(List<HeadImgs> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (HeadImgs headImgs : list) {
            e(headImgs);
        }
    }

    public void g(ArrayList<qo4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.a = arrayList;
        }
    }
}
