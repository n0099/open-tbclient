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
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static MessageSnapshot a(byte b, com.kwai.filedownloader.c.c cVar, d.a aVar) {
        InterceptResult invokeCommon;
        MessageSnapshot c0563d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b), cVar, aVar})) == null) {
            int a = cVar.a();
            if (b != -4) {
                if (b == -3) {
                    return cVar.p() ? new d.b(a, false, cVar.h()) : new h.b(a, false, (int) cVar.h());
                }
                if (b == -1) {
                    c0563d = cVar.p() ? new d.C0563d(a, cVar.g(), aVar.b()) : new h.d(a, (int) cVar.g(), aVar.b());
                } else if (b == 1) {
                    return cVar.p() ? new d.f(a, cVar.g(), cVar.h()) : new h.f(a, (int) cVar.g(), (int) cVar.h());
                } else if (b == 2) {
                    String l = cVar.k() ? cVar.l() : null;
                    return cVar.p() ? new d.c(a, aVar.a(), cVar.h(), cVar.j(), l) : new h.c(a, aVar.a(), (int) cVar.h(), cVar.j(), l);
                } else if (b == 3) {
                    return cVar.p() ? new d.g(a, cVar.g()) : new h.g(a, (int) cVar.g());
                } else if (b != 5) {
                    if (b != 6) {
                        String a2 = com.kwai.filedownloader.e.f.a("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                        com.kwai.filedownloader.e.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                        IllegalStateException illegalStateException = aVar.b() != null ? new IllegalStateException(a2, aVar.b()) : new IllegalStateException(a2);
                        return cVar.p() ? new d.C0563d(a, cVar.g(), illegalStateException) : new h.d(a, (int) cVar.g(), illegalStateException);
                    }
                    return new MessageSnapshot.b(a);
                } else {
                    c0563d = cVar.p() ? new d.h(a, cVar.g(), aVar.b(), aVar.c()) : new h.C0564h(a, (int) cVar.g(), aVar.b(), aVar.c());
                }
                return c0563d;
            }
            throw new IllegalStateException(com.kwai.filedownloader.e.f.a("please use #catchWarn instead %d", Integer.valueOf(a)));
        }
        return (MessageSnapshot) invokeCommon.objValue;
    }

    public static MessageSnapshot a(int i, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) ? j2 > 2147483647L ? z ? new d.i(i, j, j2) : new d.j(i, j, j2) : z ? new h.i(i, (int) j, (int) j2) : new h.j(i, (int) j, (int) j2) : (MessageSnapshot) invokeCommon.objValue;
    }

    public static MessageSnapshot a(int i, long j, Throwable th) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Long.valueOf(j), th})) == null) ? j > 2147483647L ? new d.C0563d(i, j, th) : new h.d(i, (int) j, th) : (MessageSnapshot) invokeCommon.objValue;
    }

    public static MessageSnapshot a(int i, File file, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), file, Boolean.valueOf(z)})) == null) {
            long length = file.length();
            return length > 2147483647L ? z ? new d.a(i, true, length) : new d.b(i, true, length) : z ? new h.a(i, true, (int) length) : new h.b(i, true, (int) length);
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
                return new a.C0562a(messageSnapshot);
            }
            throw new IllegalStateException(com.kwai.filedownloader.e.f.a("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b())));
        }
        return (MessageSnapshot) invokeL.objValue;
    }
}
