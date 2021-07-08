package d.a.v0.h.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1926a f67862a;

    /* renamed from: b  reason: collision with root package name */
    public int f67863b;

    /* renamed from: c  reason: collision with root package name */
    public a f67864c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.v0.h.c f67865d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f67866e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f67867f;

    /* renamed from: g  reason: collision with root package name */
    public String f67868g;

    /* renamed from: d.a.v0.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1926a {
        void a(a aVar);

        void b(a aVar);

        void c(int i2, int i3);

        void d(String str, a aVar);
    }

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

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        String fileNameWithOutExtention;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str2 == null) {
                str2 = "";
            }
            if (TextUtils.isEmpty(this.f67868g)) {
                sb = new StringBuilder();
                fileNameWithOutExtention = FileUtils.removeExtention(str);
            } else {
                fileNameWithOutExtention = FileUtils.getFileNameWithOutExtention(str);
                sb = new StringBuilder();
                sb.append(this.f67868g);
            }
            sb.append(fileNameWithOutExtention);
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public abstract void b();

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f67863b = i2;
        }
    }

    public abstract void d(d.a.v0.h.c cVar);

    public void e(InterfaceC1926a interfaceC1926a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC1926a) == null) {
            this.f67862a = interfaceC1926a;
        }
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f67864c = aVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.f67867f) {
            return;
        }
        this.f67866e = true;
        InterfaceC1926a interfaceC1926a = this.f67862a;
        if (interfaceC1926a != null) {
            interfaceC1926a.d(getClass().getName() + str, this);
        }
    }

    public abstract void h();

    public void i(int i2) {
        InterfaceC1926a interfaceC1926a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (interfaceC1926a = this.f67862a) == null) {
            return;
        }
        interfaceC1926a.c(this.f67863b, i2);
    }

    public boolean j(d.a.v0.h.c cVar) {
        InterceptResult invokeL;
        List<d.a.v0.h.a> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cVar)) == null) {
            if (cVar != null && cVar.c() != null && cVar.c().size() == 1 && cVar.c().get(0).a() != null && (a2 = cVar.c().get(0).a()) != null && a2.size() == 1) {
                d.a.v0.h.a aVar = a2.get(0);
                if (aVar.b() != null && !aVar.b().isNeedEdit()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f67863b : invokeV.intValue;
    }

    public void l(d.a.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f67865d = cVar;
            InterfaceC1926a interfaceC1926a = this.f67862a;
            if (interfaceC1926a != null) {
                interfaceC1926a.c(this.f67863b, 100);
                this.f67862a.b(this);
            }
            a aVar = this.f67864c;
            if (aVar != null) {
                aVar.d(cVar);
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f67864c == null : invokeV.booleanValue;
    }

    public d.a.v0.h.c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f67865d : (d.a.v0.h.c) invokeV.objValue;
    }

    public void o() {
        InterfaceC1926a interfaceC1926a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (interfaceC1926a = this.f67862a) == null) {
            return;
        }
        interfaceC1926a.a(this);
    }
}
