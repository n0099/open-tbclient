package d.a.p0.i1.l.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.i1.l.c.a;
/* loaded from: classes8.dex */
public class b implements d.a.o0.g0.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58538e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1468a f58539f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.i1.h.o.a f58540g;

    /* renamed from: h  reason: collision with root package name */
    public long f58541h;

    /* renamed from: i  reason: collision with root package name */
    public int f58542i;

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

    public static b a(ChatMessage chatMessage, a.C1468a c1468a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, chatMessage, c1468a)) == null) {
            b bVar = new b();
            if (chatMessage == null) {
                return bVar;
            }
            c1468a.f58536h /= 100;
            bVar.o(chatMessage.getReadCountPv());
            bVar.m(c1468a);
            bVar.h(chatMessage.getTime());
            if (chatMessage.getObjContent() instanceof d.a.p0.i1.h.o.a) {
                bVar.k((d.a.p0.i1.h.o.a) chatMessage.getObjContent());
            }
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58541h : invokeV.longValue;
    }

    public d.a.p0.i1.h.o.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58540g : (d.a.p0.i1.h.o.a) invokeV.objValue;
    }

    public a.C1468a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58539f : (a.C1468a) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f58542i : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58538e : invokeV.booleanValue;
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f58541h = j;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f58538e = z;
        }
    }

    public void k(d.a.p0.i1.h.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f58540g = aVar;
        }
    }

    public void m(a.C1468a c1468a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c1468a) == null) {
            this.f58539f = c1468a;
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f58542i = i2;
        }
    }
}
