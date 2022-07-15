package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes7.dex */
public class zr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public PostData b;
    public ArrayList<PostData> c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public AntiData i;
    public ThreadData j;
    public boolean k;
    public boolean l;
    public Error m;

    public zr7() {
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
        this.f = 20;
        this.h = -1;
        this.k = false;
        this.b = null;
        this.c = new ArrayList<>();
        this.d = 1;
    }

    public static zr7 w(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataRes)) == null) {
            if (dataRes == null) {
                return null;
            }
            try {
                zr7 zr7Var = new zr7();
                AntiData antiData = new AntiData();
                antiData.parserProtobuf(dataRes.anti);
                zr7Var.x(antiData);
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(dataRes.thread);
                zr7Var.E(threadData);
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(dataRes.forum);
                zr7Var.A(forumData);
                PostData postData = new PostData();
                postData.v0(forumData.isBrandForum);
                postData.n0(dataRes.post, threadData);
                zr7Var.C(postData);
                List<SubPostList> list = dataRes.subpost_list;
                int size = list.size();
                ArrayList<PostData> arrayList = new ArrayList<>();
                int B = postData.B();
                for (int i = 0; i < size; i++) {
                    PostData postData2 = new PostData();
                    postData2.v0(forumData.isBrandForum);
                    postData2.l0(list.get(i), false, threadData, B);
                    if (postData2.p() != null && postData2.p().baijiahaoData == null && threadData.getBaijiahaoData() != null) {
                        postData2.p().baijiahaoData = threadData.getBaijiahaoData();
                    }
                    arrayList.add(postData2);
                }
                zr7Var.D(arrayList);
                AntiData antiData2 = new AntiData();
                antiData2.parserProtobuf(dataRes.anti);
                zr7Var.x(antiData2);
                Page page = dataRes.page;
                if (page != null) {
                    int intValue = page.total_page.intValue();
                    int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                    int intValue3 = page.current_page.intValue();
                    int intValue4 = page.total_count.intValue();
                    zr7Var.z(intValue3);
                    zr7Var.B(intValue2);
                    zr7Var.F(intValue4);
                    zr7Var.G(intValue);
                }
                zr7Var.y(dataRes.is_black_white.intValue() == 1);
                return zr7Var;
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (zr7) invokeL.objValue;
    }

    public void A(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumData) == null) {
            this.a = forumData;
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || i == 0) {
            return;
        }
        this.f = i;
    }

    public void C(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) {
            this.b = postData;
        }
    }

    public void D(ArrayList<PostData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.c = arrayList;
        }
    }

    public void E(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            this.j = threadData;
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.e = i;
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.d = i;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.h;
            if (i < 0) {
                this.h = this.g;
                return;
            }
            int i2 = this.g;
            if (i > i2) {
                this.h = i2;
            }
        }
    }

    public AntiData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : (AntiData) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.g : invokeV.intValue;
    }

    public Error c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (Error) invokeV.objValue;
    }

    public ForumData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : (ForumData) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ThreadData threadData = this.j;
            return (threadData == null || this.b == null || threadData.getAuthor() == null || this.j.getAuthor().getUserId() == null || this.b.s() == null || this.b.s().getUserId() == null || !this.j.getAuthor().getUserId().equals(this.b.s().getUserId())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.h : invokeV.intValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.b : (PostData) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == -1) {
                this.h = this.g;
            }
            return this.h;
        }
        return invokeV.intValue;
    }

    public ArrayList<PostData> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.c : (ArrayList) invokeV.objValue;
    }

    public ThreadData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : (ThreadData) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.e : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.d : invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.g < this.d : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            ThreadData threadData = this.j;
            return threadData != null && threadData.isUgcThreadType();
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void r(zr7 zr7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, zr7Var, z) == null) || zr7Var == null) {
            return;
        }
        x(zr7Var.a());
        A(zr7Var.d());
        C(zr7Var.i());
        E(zr7Var.l());
        y(zr7Var.q());
        if (zr7Var.k() != null) {
            z(zr7Var.b());
            B(zr7Var.g());
            F(zr7Var.m());
            G(zr7Var.n());
        }
        int size = this.c.size();
        if (z && size % this.f != 0) {
            for (int i = 0; i < size % this.f; i++) {
                ArrayList<PostData> arrayList = this.c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.c.addAll(zr7Var.k());
    }

    public void s(zr7 zr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, zr7Var) == null) || zr7Var == null) {
            return;
        }
        x(zr7Var.a());
        A(zr7Var.d());
        C(zr7Var.i());
        E(zr7Var.l());
        y(zr7Var.q());
        if (zr7Var.k() != null && zr7Var.k().size() > 0) {
            z(zr7Var.b());
            B(zr7Var.g());
            F(zr7Var.m());
            G(zr7Var.n());
            int i = this.f;
            int size = (this.g - (((zr7Var.k().size() - 1) + i) / i)) + 1;
            this.h = size;
            if (size < 0) {
                this.h = 0;
            }
        }
        this.c.addAll(zr7Var.k());
    }

    public void t(zr7 zr7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048603, this, zr7Var, z) == null) || zr7Var == null) {
            return;
        }
        x(zr7Var.a());
        A(zr7Var.d());
        C(zr7Var.i());
        E(zr7Var.l());
        y(zr7Var.q());
        if (zr7Var.k() != null && zr7Var.k().size() > 0) {
            z(zr7Var.b());
            B(zr7Var.g());
            F(zr7Var.m());
            G(zr7Var.n());
        }
        int size = this.c.size();
        if (z && size % this.f != 0) {
            for (int i = 0; i < size % this.f; i++) {
                ArrayList<PostData> arrayList = this.c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.c.addAll(zr7Var.k());
        H();
    }

    public void u(zr7 zr7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, zr7Var, z) == null) {
            v(zr7Var, z);
        }
    }

    public void v(zr7 zr7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048605, this, zr7Var, z) == null) || zr7Var == null) {
            return;
        }
        x(zr7Var.a());
        this.h = zr7Var.b();
        A(zr7Var.d());
        B(zr7Var.g());
        E(zr7Var.l());
        F(zr7Var.m());
        G(zr7Var.n());
        y(zr7Var.q());
        this.c.addAll(0, zr7Var.k());
    }

    public void x(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, antiData) == null) {
            this.i = antiData;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.l = z;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.g = i;
        }
    }
}
