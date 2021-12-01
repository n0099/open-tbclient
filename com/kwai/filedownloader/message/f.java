package com.kwai.filedownloader.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.download.d;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.a;
import com.kwai.filedownloader.message.d;
import com.kwai.filedownloader.message.h;
import java.io.File;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    public static MessageSnapshot a(byte b2, com.kwai.filedownloader.c.c cVar, d.a aVar) {
        InterceptResult invokeCommon;
        MessageSnapshot c2077d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), cVar, aVar})) == null) {
            int a = cVar.a();
            if (b2 != -4) {
                if (b2 == -3) {
                    return cVar.q() ? new d.b(a, false, cVar.h()) : new h.b(a, false, (int) cVar.h());
                }
                if (b2 == -1) {
                    c2077d = cVar.q() ? new d.C2077d(a, cVar.g(), aVar.b()) : new h.d(a, (int) cVar.g(), aVar.b());
                } else if (b2 == 1) {
                    return cVar.q() ? new d.f(a, cVar.g(), cVar.h()) : new h.f(a, (int) cVar.g(), (int) cVar.h());
                } else if (b2 == 2) {
                    String m = cVar.l() ? cVar.m() : null;
                    return cVar.q() ? new d.c(a, aVar.a(), cVar.h(), cVar.j(), m) : new h.c(a, aVar.a(), (int) cVar.h(), cVar.j(), m);
                } else if (b2 == 3) {
                    return cVar.q() ? new d.g(a, cVar.g()) : new h.g(a, (int) cVar.g());
                } else if (b2 != 5) {
                    if (b2 != 6) {
                        String a2 = com.kwai.filedownloader.e.f.a("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b2));
                        com.kwai.filedownloader.e.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b2));
                        IllegalStateException illegalStateException = aVar.b() != null ? new IllegalStateException(a2, aVar.b()) : new IllegalStateException(a2);
                        return cVar.q() ? new d.C2077d(a, cVar.g(), illegalStateException) : new h.d(a, (int) cVar.g(), illegalStateException);
                    }
                    return new MessageSnapshot.b(a);
                } else {
                    c2077d = cVar.q() ? new d.h(a, cVar.g(), aVar.b(), aVar.c()) : new h.C2078h(a, (int) cVar.g(), aVar.b(), aVar.c());
                }
                return c2077d;
            }
            throw new IllegalStateException(com.kwai.filedownloader.e.f.a("please use #catchWarn instead %d", Integer.valueOf(a)));
        }
        return (MessageSnapshot) invokeCommon.objValue;
    }

    public static MessageSnapshot a(int i2, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) ? j3 > 2147483647L ? z ? new d.i(i2, j2, j3) : new d.j(i2, j2, j3) : z ? new h.i(i2, (int) j2, (int) j3) : new h.j(i2, (int) j2, (int) j3) : (MessageSnapshot) invokeCommon.objValue;
    }

    public static MessageSnapshot a(int i2, long j2, Throwable th) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), th})) == null) ? j2 > 2147483647L ? new d.C2077d(i2, j2, th) : new h.d(i2, (int) j2, th) : (MessageSnapshot) invokeCommon.objValue;
    }

    public static MessageSnapshot a(int i2, File file, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), file, Boolean.valueOf(z)})) == null) {
            long length = file.length();
            return length > 2147483647L ? z ? new d.a(i2, true, length) : new d.b(i2, true, length) : z ? new h.a(i2, true, (int) length) : new h.b(i2, true, (int) length);
        }
        return (MessageSnapshot) invokeCommon.objValue;
    }

    public static MessageSnapshot a(com.kwai.filedownloader.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aVar)) == null) ? aVar.D() ? new d.e(aVar.h(), aVar.r(), aVar.t()) : new h.e(aVar.h(), aVar.q(), aVar.s()) : (MessageSnapshot) invokeL.objValue;
    }

    public static MessageSnapshot a(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, messageSnapshot)) == null) {
            if (messageSnapshot.b() == -3) {
                return new a.C2076a(messageSnapshot);
            }
            throw new IllegalStateException(com.kwai.filedownloader.e.f.a("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b())));
        }
        return (MessageSnapshot) invokeL.objValue;
    }
}
