package com.kwai.filedownloader.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
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

    public static MessageSnapshot a(byte b2, com.kwai.filedownloader.d.c cVar, d.a aVar) {
        InterceptResult invokeCommon;
        MessageSnapshot c0457d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), cVar, aVar})) == null) {
            int a2 = cVar.a();
            if (b2 != -4) {
                if (b2 == -3) {
                    return cVar.q() ? new d.b(a2, false, cVar.h()) : new h.b(a2, false, (int) cVar.h());
                }
                if (b2 == -1) {
                    c0457d = cVar.q() ? new d.C0457d(a2, cVar.g(), aVar.b()) : new h.d(a2, (int) cVar.g(), aVar.b());
                } else if (b2 == 1) {
                    return cVar.q() ? new d.f(a2, cVar.g(), cVar.h()) : new h.f(a2, (int) cVar.g(), (int) cVar.h());
                } else if (b2 == 2) {
                    String m = cVar.l() ? cVar.m() : null;
                    return cVar.q() ? new d.c(a2, aVar.a(), cVar.h(), cVar.j(), m) : new h.c(a2, aVar.a(), (int) cVar.h(), cVar.j(), m);
                } else if (b2 == 3) {
                    return cVar.q() ? new d.g(a2, cVar.g()) : new h.g(a2, (int) cVar.g());
                } else if (b2 != 5) {
                    if (b2 != 6) {
                        String a3 = com.kwai.filedownloader.f.f.a("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b2));
                        com.kwai.filedownloader.f.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b2));
                        IllegalStateException illegalStateException = aVar.b() != null ? new IllegalStateException(a3, aVar.b()) : new IllegalStateException(a3);
                        return cVar.q() ? new d.C0457d(a2, cVar.g(), illegalStateException) : new h.d(a2, (int) cVar.g(), illegalStateException);
                    }
                    return new MessageSnapshot.b(a2);
                } else {
                    c0457d = cVar.q() ? new d.h(a2, cVar.g(), aVar.b(), aVar.c()) : new h.C0458h(a2, (int) cVar.g(), aVar.b(), aVar.c());
                }
                return c0457d;
            }
            throw new IllegalStateException(com.kwai.filedownloader.f.f.a("please use #catchWarn instead %d", Integer.valueOf(a2)));
        }
        return (MessageSnapshot) invokeCommon.objValue;
    }

    public static MessageSnapshot a(int i2, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) ? j2 > 2147483647L ? z ? new d.i(i2, j, j2) : new d.j(i2, j, j2) : z ? new h.i(i2, (int) j, (int) j2) : new h.j(i2, (int) j, (int) j2) : (MessageSnapshot) invokeCommon.objValue;
    }

    public static MessageSnapshot a(int i2, long j, Throwable th) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j), th})) == null) ? j > 2147483647L ? new d.C0457d(i2, j, th) : new h.d(i2, (int) j, th) : (MessageSnapshot) invokeCommon.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar)) == null) ? aVar.D() ? new d.e(aVar.h(), aVar.r(), aVar.t()) : new h.e(aVar.h(), aVar.q(), aVar.s()) : (MessageSnapshot) invokeL.objValue;
    }

    public static MessageSnapshot a(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, messageSnapshot)) == null) {
            if (messageSnapshot.b() == -3) {
                return new a.C0456a(messageSnapshot);
            }
            throw new IllegalStateException(com.kwai.filedownloader.f.f.a("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b())));
        }
        return (MessageSnapshot) invokeL.objValue;
    }
}
