package d.a.c.e.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import d.a.c.e.d.l;
/* loaded from: classes8.dex */
public abstract class d<T> implements k<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f44083a;

    /* renamed from: b  reason: collision with root package name */
    public final e f44084b;

    public d(e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44084b = eVar;
        this.f44083a = z;
    }

    @Override // d.a.c.e.d.k
    public e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f44084b : (e) invokeV.objValue;
    }

    @Override // d.a.c.e.d.k
    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            l(h(str, str2));
        }
    }

    @Override // d.a.c.e.d.k
    public l.b<T> d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            g<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            l.b<T> bVar = new l.b<>();
            bVar.f44106a = str2;
            bVar.f44107b = k.f44090b;
            long j = k.f44094f;
            bVar.f44108c = k.f44092d;
            return bVar;
        }
        return (l.b) invokeLL.objValue;
    }

    @Override // d.a.c.e.d.k
    public T e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            g<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            return k.f44090b;
        }
        return (T) invokeLL.objValue;
    }

    @Override // d.a.c.e.d.k
    public void f(String str, String str2, T t, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, t, Long.valueOf(j)}) == null) {
            g<T> gVar = new g<>();
            gVar.f44089a = h(str, str2);
            gVar.f44091c = str;
            gVar.f44094f = j;
            gVar.f44090b = t;
            gVar.f44093e = System.currentTimeMillis();
            gVar.f44092d = System.currentTimeMillis();
            j(gVar);
        }
    }

    public String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (this.f44083a) {
                return str + TNCManager.TNC_PROBE_HEADER_SECEPTOR + str2;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public abstract g<T> i(String str);

    public abstract void j(g<T> gVar);

    public g<T> k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String h2 = h(str, str2);
            g<T> i2 = i(h2);
            if (i2 == null) {
                BdLog.isDebugMode();
                return null;
            } else if (i2.f44094f < System.currentTimeMillis()) {
                m(h2);
                BdLog.isDebugMode();
                return null;
            } else {
                if (this.f44084b.a()) {
                    i2.f44093e = System.currentTimeMillis();
                    j(i2);
                }
                BdLog.isDebugMode();
                return i2;
            }
        }
        return (g) invokeLL.objValue;
    }

    public abstract void l(String str);

    public abstract void m(String str);
}
