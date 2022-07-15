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
/* loaded from: classes5.dex */
public class a56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e56 a;
    public dq4 b;
    public ForumCreateInfoData c;
    public PrivateForumPopInfoData d;
    public i56 e;
    public j56 f;
    public boolean g;
    public int h;
    public HotSearchInfoData i;
    public int j;

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
                return;
            }
        }
        this.g = true;
        this.h = 0;
        this.a = new e56();
        this.b = new dq4();
        this.c = new ForumCreateInfoData();
        this.d = new PrivateForumPopInfoData();
        this.e = new i56();
        this.f = new j56();
        this.g = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() / h05.a.longValue() == (((long) this.h) * 1000) / h05.a.longValue() : invokeV.booleanValue;
    }

    public ForumCreateInfoData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (ForumCreateInfoData) invokeV.objValue;
    }

    public j56 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (j56) invokeV.objValue;
    }

    public HotSearchInfoData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (HotSearchInfoData) invokeV.objValue;
    }

    public e56 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (e56) invokeV.objValue;
    }

    public dq4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (dq4) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public void i(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            if (dataRes.like_forum != null) {
                this.a.c(dataRes.like_forum);
            }
            if (dataRes.forum_create_info != null) {
                this.c.E(dataRes.forum_create_info);
            }
            if (ListUtils.isEmpty(dataRes.hot_search)) {
                return;
            }
            this.i = new HotSearchInfoData();
            this.i.C(dataRes.hot_search.get(0).search_title);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void j(tbclient.ForumRecommend.DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f.f(dataRes.forum_popup_info);
            }
            p(dataRes.time.intValue());
            this.j = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
            if (dataRes.like_forum != null) {
                this.a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.b.i(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.c.E(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.d.F(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.i = hotSearchInfoData;
                hotSearchInfoData.B(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void k(ForumCreateInfoData forumCreateInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, forumCreateInfoData) == null) {
            this.c = forumCreateInfoData;
        }
    }

    public void l(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hotSearchInfoData) == null) {
            this.i = hotSearchInfoData;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.g = z;
        }
    }

    public void n(e56 e56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, e56Var) == null) {
            this.a = e56Var;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.j = i;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.h = i;
        }
    }
}
