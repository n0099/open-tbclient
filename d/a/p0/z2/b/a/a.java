package d.a.p0.z2.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SimpleUser;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f66565a;

    /* renamed from: b  reason: collision with root package name */
    public int f66566b;

    /* renamed from: c  reason: collision with root package name */
    public int f66567c;

    /* renamed from: d  reason: collision with root package name */
    public int f66568d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66569e;

    /* renamed from: f  reason: collision with root package name */
    public int f66570f;

    /* renamed from: g  reason: collision with root package name */
    public int f66571g;

    /* renamed from: h  reason: collision with root package name */
    public int f66572h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleUser f66573i;
    public int j;
    public int k;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66571g : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66572h : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66566b : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66567c : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66568d : invokeV.intValue;
    }

    public SimpleUser f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f66573i : (SimpleUser) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66570f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f66565a : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f66569e : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.f66565a = j.k("post" + currentAccount, 0);
            this.f66566b = j.k("like" + currentAccount, 0);
            this.f66567c = j.k("group" + currentAccount, 0);
            this.f66568d = j.k("live" + currentAccount, 0);
            this.f66570f = j.k("reply" + currentAccount, 1);
            this.k = j.k("reply_show_myself" + currentAccount, 0);
            this.f66571g = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            this.f66572h = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            this.f66569e = TbadkCoreApplication.getInst().getLocationShared();
            return (this.f66565a == 0 && this.f66566b == 0 && this.f66567c == 0 && this.f66568d == 0 && this.f66570f == 1 && this.k == 0 && this.f66571g == 0 && this.f66572h == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void l(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f66565a = aVar.f66565a;
        this.f66566b = aVar.f66566b;
        this.f66567c = aVar.f66567c;
        this.f66569e = aVar.f66569e;
        this.f66568d = aVar.f66568d;
        this.j = aVar.j;
        this.f66570f = aVar.f66570f;
        this.k = aVar.k;
        this.f66572h = aVar.f66572h;
        this.f66571g = aVar.f66571g;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
            j.v("post" + currentAccount, this.f66565a);
            j.v("like" + currentAccount, this.f66566b);
            j.v("group" + currentAccount, this.f66567c);
            j.v("live" + currentAccount, this.f66568d);
            j.v("reply" + currentAccount, this.f66570f);
            j.v("reply_show_myself" + currentAccount, this.k);
            j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f66571g);
            j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f66572h);
            TbadkCoreApplication.getInst().setLocationShared(this.f66569e);
        }
    }

    public void n(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i2) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
            j.v(str + currentAccount, i2);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f66571g = i2;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f66572h = i2;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.j = i2;
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f66566b = i2;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f66567c = i2;
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f66568d = i2;
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 != 1) {
                this.f66569e = false;
            } else {
                this.f66569e = true;
            }
        }
    }

    public void v(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, simpleUser) == null) {
            this.f66573i = simpleUser;
            if (simpleUser != null) {
                x(simpleUser.show_onlyme.intValue());
            }
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (i2 == 0) {
                this.f66570f = 1;
            } else {
                this.f66570f = i2;
            }
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.k = i2;
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f66565a = i2;
        }
    }
}
