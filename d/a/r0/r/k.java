package d.a.r0.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static k f55776f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f55777a;

    /* renamed from: b  reason: collision with root package name */
    public int f55778b;

    /* renamed from: c  reason: collision with root package name */
    public String f55779c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55780d;

    /* renamed from: e  reason: collision with root package name */
    public int f55781e;

    public k() {
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
        this.f55777a = 0;
        this.f55778b = 0;
        this.f55779c = null;
        this.f55780d = true;
        this.f55781e = 0;
    }

    public static k c() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            k kVar2 = f55776f;
            if (kVar2 == null) {
                synchronized (k.class) {
                    if (f55776f == null) {
                        f55776f = new k();
                    }
                    kVar = f55776f;
                }
                return kVar;
            }
            return kVar2;
        }
        return (k) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55779c : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
            int k = j.k(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
            this.f55778b = k;
            return k;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int k = d.a.r0.r.d0.b.j().k("image_quality", 0);
            this.f55777a = k;
            return k;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55781e : invokeV.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f55777a = d.a.r0.r.d0.b.j().k("image_quality", 0);
            d.a.r0.r.d0.b.j().k("new_abstract_state", 0);
            this.f55781e = d.a.r0.r.d0.b.j().k("view_image_quality", 0);
            boolean g2 = d.a.r0.r.d0.b.j().g("show_images", true);
            this.f55780d = g2;
            if (g2) {
                return;
            }
            this.f55780d = true;
            d.a.r0.r.d0.b.j().C("show_images");
            d.a.r0.r.d0.b.j().v("view_image_quality", 0);
            this.f55781e = 0;
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f55780d : invokeV.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f55779c = str;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f55778b == i2) {
            return;
        }
        this.f55778b = i2;
        d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
        j.v(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i2);
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f55781e == i2) {
            return;
        }
        this.f55781e = i2;
        d.a.r0.r.d0.b.j().v("view_image_quality", i2);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
