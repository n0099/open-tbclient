package d.a.c.e.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f41144a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f41145b;

    /* renamed from: c  reason: collision with root package name */
    public int f41146c;

    /* renamed from: d  reason: collision with root package name */
    public String f41147d;

    /* renamed from: e  reason: collision with root package name */
    public a f41148e;

    /* renamed from: f  reason: collision with root package name */
    public int f41149f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f41150g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41151h;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, int i2, boolean z);
    }

    public b(String str, int i2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41144a = 0;
        this.f41145b = null;
        this.f41146c = 0;
        this.f41147d = null;
        this.f41148e = null;
        this.f41149f = 0;
        this.f41150g = null;
        this.f41151h = false;
        if (str != null) {
            this.f41147d = str;
            this.f41148e = aVar;
            this.f41149f = i2;
            return;
        }
        throw new InvalidParameterException("SwitchData name is null");
    }

    public void a(int i2, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (aVar = this.f41148e) == null) {
            return;
        }
        aVar.a(this.f41147d, i2, z);
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41149f : invokeV.intValue;
    }

    public String[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41145b : (String[]) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41144a : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41147d : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41146c : invokeV.intValue;
    }

    public String[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41150g : (String[]) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41151h : invokeV.booleanValue;
    }

    public void i(int i2, String[] strArr, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), strArr, Integer.valueOf(i3)}) == null) {
            this.f41144a = i2;
            this.f41145b = strArr;
            this.f41146c = i3;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f41151h = z;
        }
    }

    public void k(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, strArr) == null) {
            this.f41150g = strArr;
        }
    }
}
