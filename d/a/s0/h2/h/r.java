package d.a.s0.h2.h;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes9.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ForumData f60185a;

    /* renamed from: b  reason: collision with root package name */
    public PostData f60186b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<PostData> f60187c;

    /* renamed from: d  reason: collision with root package name */
    public int f60188d;

    /* renamed from: e  reason: collision with root package name */
    public int f60189e;

    /* renamed from: f  reason: collision with root package name */
    public int f60190f;

    /* renamed from: g  reason: collision with root package name */
    public int f60191g;

    /* renamed from: h  reason: collision with root package name */
    public int f60192h;

    /* renamed from: i  reason: collision with root package name */
    public AntiData f60193i;
    public b2 j;
    public boolean k;
    public boolean l;
    public Error m;

    public r() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60190f = 20;
        this.f60192h = -1;
        this.k = false;
        this.f60186b = null;
        this.f60187c = new ArrayList<>();
        this.f60188d = 1;
    }

    public static r w(DataRes dataRes, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, dataRes, context)) == null) {
            if (dataRes == null) {
                return null;
            }
            try {
                r rVar = new r();
                AntiData antiData = new AntiData();
                antiData.parserProtobuf(dataRes.anti);
                rVar.x(antiData);
                b2 b2Var = new b2();
                b2Var.I2(dataRes.thread);
                rVar.E(b2Var);
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(dataRes.forum);
                rVar.A(forumData);
                PostData postData = new PostData();
                postData.j0(forumData.isBrandForum);
                postData.b0(dataRes.post, context);
                rVar.C(postData);
                List<SubPostList> list = dataRes.subpost_list;
                int size = list.size();
                ArrayList<PostData> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData2 = new PostData();
                    postData2.j0(forumData.isBrandForum);
                    postData2.c0(list.get(i2), context);
                    if (postData2.q() != null && postData2.q().baijiahaoData == null && b2Var.J() != null) {
                        postData2.q().baijiahaoData = b2Var.J();
                    }
                    arrayList.add(postData2);
                }
                rVar.D(arrayList);
                AntiData antiData2 = new AntiData();
                antiData2.parserProtobuf(dataRes.anti);
                rVar.x(antiData2);
                Page page = dataRes.page;
                if (page != null) {
                    int intValue = page.total_page.intValue();
                    int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                    int intValue3 = page.current_page.intValue();
                    int intValue4 = page.total_count.intValue();
                    rVar.z(intValue3);
                    rVar.B(intValue2);
                    rVar.F(intValue4);
                    rVar.G(intValue);
                }
                rVar.y(dataRes.is_black_white.intValue() == 1);
                return rVar;
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (r) invokeLL.objValue;
    }

    public void A(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumData) == null) {
            this.f60185a = forumData;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f60190f = i2;
    }

    public void C(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) {
            this.f60186b = postData;
        }
    }

    public void D(ArrayList<PostData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f60187c = arrayList;
        }
    }

    public void E(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b2Var) == null) {
            this.j = b2Var;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f60189e = i2;
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f60188d = i2;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = this.f60192h;
            if (i2 < 0) {
                this.f60192h = this.f60191g;
                return;
            }
            int i3 = this.f60191g;
            if (i2 > i3) {
                this.f60192h = i3;
            }
        }
    }

    public AntiData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f60193i : (AntiData) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f60191g : invokeV.intValue;
    }

    public Error c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (Error) invokeV.objValue;
    }

    public ForumData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f60185a : (ForumData) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            b2 b2Var = this.j;
            return (b2Var == null || this.f60186b == null || b2Var.H() == null || this.j.H().getUserId() == null || this.f60186b.t() == null || this.f60186b.t().getUserId() == null || !this.j.H().getUserId().equals(this.f60186b.t().getUserId())) ? false : true;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f60190f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f60192h : invokeV.intValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f60186b : (PostData) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f60192h == -1) {
                this.f60192h = this.f60191g;
            }
            return this.f60192h;
        }
        return invokeV.intValue;
    }

    public ArrayList<PostData> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f60187c : (ArrayList) invokeV.objValue;
    }

    public b2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : (b2) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f60189e : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f60188d : invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f60191g < this.f60188d : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b2 b2Var = this.j;
            return b2Var != null && b2Var.p2();
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void r(r rVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, rVar, z) == null) || rVar == null) {
            return;
        }
        x(rVar.a());
        A(rVar.d());
        C(rVar.i());
        E(rVar.l());
        y(rVar.q());
        if (rVar.k() != null) {
            z(rVar.b());
            B(rVar.g());
            F(rVar.m());
            G(rVar.n());
        }
        int size = this.f60187c.size();
        if (z && size % this.f60190f != 0) {
            for (int i2 = 0; i2 < size % this.f60190f; i2++) {
                ArrayList<PostData> arrayList = this.f60187c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f60187c.addAll(rVar.k());
    }

    public void s(r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, rVar) == null) || rVar == null) {
            return;
        }
        x(rVar.a());
        A(rVar.d());
        C(rVar.i());
        E(rVar.l());
        y(rVar.q());
        if (rVar.k() != null && rVar.k().size() > 0) {
            z(rVar.b());
            B(rVar.g());
            F(rVar.m());
            G(rVar.n());
            int i2 = this.f60190f;
            int size = (this.f60191g - (((rVar.k().size() - 1) + i2) / i2)) + 1;
            this.f60192h = size;
            if (size < 0) {
                this.f60192h = 0;
            }
        }
        this.f60187c.addAll(rVar.k());
    }

    public void t(r rVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048603, this, rVar, z) == null) || rVar == null) {
            return;
        }
        x(rVar.a());
        A(rVar.d());
        C(rVar.i());
        E(rVar.l());
        y(rVar.q());
        if (rVar.k() != null && rVar.k().size() > 0) {
            z(rVar.b());
            B(rVar.g());
            F(rVar.m());
            G(rVar.n());
        }
        int size = this.f60187c.size();
        if (z && size % this.f60190f != 0) {
            for (int i2 = 0; i2 < size % this.f60190f; i2++) {
                ArrayList<PostData> arrayList = this.f60187c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f60187c.addAll(rVar.k());
        H();
    }

    public void u(r rVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, rVar, z) == null) {
            v(rVar, z);
        }
    }

    public void v(r rVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048605, this, rVar, z) == null) || rVar == null) {
            return;
        }
        x(rVar.a());
        this.f60192h = rVar.b();
        A(rVar.d());
        B(rVar.g());
        E(rVar.l());
        F(rVar.m());
        G(rVar.n());
        y(rVar.q());
        this.f60187c.addAll(0, rVar.k());
    }

    public void x(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, antiData) == null) {
            this.f60193i = antiData;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.l = z;
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.f60191g = i2;
        }
    }
}
