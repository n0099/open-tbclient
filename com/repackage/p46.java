package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ForumGuide.DataRes;
/* loaded from: classes6.dex */
public class p46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t46 a;
    public eq4 b;
    public ForumCreateInfoData c;
    public PrivateForumPopInfoData d;
    public x46 e;
    public b56 f;
    public boolean g;
    public int h;
    public HotSearchInfoData i;
    public int j;

    public p46() {
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
        this.g = true;
        this.h = 0;
        this.a = new t46();
        this.b = new eq4();
        this.c = new ForumCreateInfoData();
        this.d = new PrivateForumPopInfoData();
        this.e = new x46();
        this.f = new b56();
        this.g = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() / kz4.a.longValue() == (((long) this.h) * 1000) / kz4.a.longValue() : invokeV.booleanValue;
    }

    public ForumCreateInfoData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (ForumCreateInfoData) invokeV.objValue;
    }

    public b56 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (b56) invokeV.objValue;
    }

    public HotSearchInfoData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (HotSearchInfoData) invokeV.objValue;
    }

    public t46 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (t46) invokeV.objValue;
    }

    public PrivateForumPopInfoData f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (PrivateForumPopInfoData) invokeV.objValue;
    }

    public eq4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (eq4) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public void j(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            if (dataRes.like_forum != null) {
                this.a.c(dataRes.like_forum);
            }
            if (dataRes.forum_create_info != null) {
                this.c.C(dataRes.forum_create_info);
            }
            if (ListUtils.isEmpty(dataRes.hot_search)) {
                return;
            }
            this.i = new HotSearchInfoData();
            this.i.A(dataRes.hot_search.get(0).search_title);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void k(tbclient.ForumRecommend.DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f.f(dataRes.forum_popup_info);
            }
            q(dataRes.time.intValue());
            this.j = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
            if (dataRes.like_forum != null) {
                this.a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.b.k(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.c.C(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.d.C(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.i = hotSearchInfoData;
                hotSearchInfoData.z(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void l(ForumCreateInfoData forumCreateInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, forumCreateInfoData) == null) {
            this.c = forumCreateInfoData;
        }
    }

    public void m(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hotSearchInfoData) == null) {
            this.i = hotSearchInfoData;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.g = z;
        }
    }

    public void o(t46 t46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, t46Var) == null) {
            this.a = t46Var;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.j = i;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.h = i;
        }
    }
}
