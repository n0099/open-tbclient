package d.a.q0.i1.l.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.i1.l.c.a;
/* loaded from: classes8.dex */
public class b implements d.a.p0.i0.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59152e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1473a f59153f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.i1.h.o.a f59154g;

    /* renamed from: h  reason: collision with root package name */
    public long f59155h;

    /* renamed from: i  reason: collision with root package name */
    public int f59156i;

    public b() {
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

    public static b a(ChatMessage chatMessage, a.C1473a c1473a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, chatMessage, c1473a)) == null) {
            b bVar = new b();
            if (chatMessage == null) {
                return bVar;
            }
            c1473a.f59150h /= 100;
            bVar.o(chatMessage.getReadCountPv());
            bVar.m(c1473a);
            bVar.h(chatMessage.getTime());
            if (chatMessage.getObjContent() instanceof d.a.q0.i1.h.o.a) {
                bVar.k((d.a.q0.i1.h.o.a) chatMessage.getObjContent());
            }
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59155h : invokeV.longValue;
    }

    public d.a.q0.i1.h.o.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59154g : (d.a.q0.i1.h.o.a) invokeV.objValue;
    }

    public a.C1473a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59153f : (a.C1473a) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59156i : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59152e : invokeV.booleanValue;
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f59155h = j;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f59152e = z;
        }
    }

    public void k(d.a.q0.i1.h.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f59154g = aVar;
        }
    }

    public void m(a.C1473a c1473a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c1473a) == null) {
            this.f59153f = c1473a;
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f59156i = i2;
        }
    }
}
