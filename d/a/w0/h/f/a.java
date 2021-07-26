package d.a.w0.h.f;

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
    public InterfaceC1931a f68540a;

    /* renamed from: b  reason: collision with root package name */
    public int f68541b;

    /* renamed from: c  reason: collision with root package name */
    public a f68542c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.w0.h.c f68543d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f68544e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f68545f;

    /* renamed from: g  reason: collision with root package name */
    public String f68546g;

    /* renamed from: d.a.w0.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1931a {
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
            if (TextUtils.isEmpty(this.f68546g)) {
                sb = new StringBuilder();
                fileNameWithOutExtention = FileUtils.removeExtention(str);
            } else {
                fileNameWithOutExtention = FileUtils.getFileNameWithOutExtention(str);
                sb = new StringBuilder();
                sb.append(this.f68546g);
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
            this.f68541b = i2;
        }
    }

    public abstract void d(d.a.w0.h.c cVar);

    public void e(InterfaceC1931a interfaceC1931a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC1931a) == null) {
            this.f68540a = interfaceC1931a;
        }
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f68542c = aVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.f68545f) {
            return;
        }
        this.f68544e = true;
        InterfaceC1931a interfaceC1931a = this.f68540a;
        if (interfaceC1931a != null) {
            interfaceC1931a.d(getClass().getName() + str, this);
        }
    }

    public abstract void h();

    public void i(int i2) {
        InterfaceC1931a interfaceC1931a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (interfaceC1931a = this.f68540a) == null) {
            return;
        }
        interfaceC1931a.c(this.f68541b, i2);
    }

    public boolean j(d.a.w0.h.c cVar) {
        InterceptResult invokeL;
        List<d.a.w0.h.a> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cVar)) == null) {
            if (cVar != null && cVar.c() != null && cVar.c().size() == 1 && cVar.c().get(0).a() != null && (a2 = cVar.c().get(0).a()) != null && a2.size() == 1) {
                d.a.w0.h.a aVar = a2.get(0);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f68541b : invokeV.intValue;
    }

    public void l(d.a.w0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f68543d = cVar;
            InterfaceC1931a interfaceC1931a = this.f68540a;
            if (interfaceC1931a != null) {
                interfaceC1931a.c(this.f68541b, 100);
                this.f68540a.b(this);
            }
            a aVar = this.f68542c;
            if (aVar != null) {
                aVar.d(cVar);
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f68542c == null : invokeV.booleanValue;
    }

    public d.a.w0.h.c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f68543d : (d.a.w0.h.c) invokeV.objValue;
    }

    public void o() {
        InterfaceC1931a interfaceC1931a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (interfaceC1931a = this.f68540a) == null) {
            return;
        }
        interfaceC1931a.a(this);
    }
}
