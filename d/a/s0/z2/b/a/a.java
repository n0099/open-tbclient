package d.a.s0.z2.b.a;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f69762a;

    /* renamed from: b  reason: collision with root package name */
    public int f69763b;

    /* renamed from: c  reason: collision with root package name */
    public int f69764c;

    /* renamed from: d  reason: collision with root package name */
    public int f69765d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f69766e;

    /* renamed from: f  reason: collision with root package name */
    public int f69767f;

    /* renamed from: g  reason: collision with root package name */
    public int f69768g;

    /* renamed from: h  reason: collision with root package name */
    public int f69769h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleUser f69770i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69768g : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69769h : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69763b : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69764c : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f69765d : invokeV.intValue;
    }

    public SimpleUser f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f69770i : (SimpleUser) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f69767f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f69762a : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f69766e : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.f69762a = j.k("post" + currentAccount, 0);
            this.f69763b = j.k("like" + currentAccount, 0);
            this.f69764c = j.k("group" + currentAccount, 0);
            this.f69765d = j.k("live" + currentAccount, 0);
            this.f69767f = j.k("reply" + currentAccount, 1);
            this.k = j.k("reply_show_myself" + currentAccount, 0);
            this.f69768g = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            this.f69769h = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            this.f69766e = TbadkCoreApplication.getInst().getLocationShared();
            return (this.f69762a == 0 && this.f69763b == 0 && this.f69764c == 0 && this.f69765d == 0 && this.f69767f == 1 && this.k == 0 && this.f69768g == 0 && this.f69769h == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void l(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f69762a = aVar.f69762a;
        this.f69763b = aVar.f69763b;
        this.f69764c = aVar.f69764c;
        this.f69766e = aVar.f69766e;
        this.f69765d = aVar.f69765d;
        this.j = aVar.j;
        this.f69767f = aVar.f69767f;
        this.k = aVar.k;
        this.f69769h = aVar.f69769h;
        this.f69768g = aVar.f69768g;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
            j.v("post" + currentAccount, this.f69762a);
            j.v("like" + currentAccount, this.f69763b);
            j.v("group" + currentAccount, this.f69764c);
            j.v("live" + currentAccount, this.f69765d);
            j.v("reply" + currentAccount, this.f69767f);
            j.v("reply_show_myself" + currentAccount, this.k);
            j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f69768g);
            j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f69769h);
            TbadkCoreApplication.getInst().setLocationShared(this.f69766e);
        }
    }

    public void n(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i2) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
            j.v(str + currentAccount, i2);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f69768g = i2;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f69769h = i2;
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
        this.f69763b = i2;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f69764c = i2;
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f69765d = i2;
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 != 1) {
                this.f69766e = false;
            } else {
                this.f69766e = true;
            }
        }
    }

    public void v(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, simpleUser) == null) {
            this.f69770i = simpleUser;
            if (simpleUser != null) {
                x(simpleUser.show_onlyme.intValue());
            }
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (i2 == 0) {
                this.f69767f = 1;
            } else {
                this.f69767f = i2;
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
            this.f69762a = i2;
        }
    }
}
