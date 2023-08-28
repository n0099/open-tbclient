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
/* loaded from: classes10.dex */
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
        MessageSnapshot c0707d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b), cVar, aVar})) == null) {
            int id = cVar.getId();
            if (b != -4) {
                if (b == -3) {
                    return cVar.Cg() ? new d.b(id, false, cVar.getTotal()) : new h.b(id, false, (int) cVar.getTotal());
                }
                if (b == -1) {
                    c0707d = cVar.Cg() ? new d.C0707d(id, cVar.Em(), aVar.getException()) : new h.d(id, (int) cVar.Em(), aVar.getException());
                } else if (b == 1) {
                    return cVar.Cg() ? new d.f(id, cVar.Em(), cVar.getTotal()) : new h.f(id, (int) cVar.Em(), (int) cVar.getTotal());
                } else if (b == 2) {
                    String filename = cVar.BW() ? cVar.getFilename() : null;
                    return cVar.Cg() ? new d.c(id, aVar.DR(), cVar.getTotal(), cVar.En(), filename) : new h.c(id, aVar.DR(), (int) cVar.getTotal(), cVar.En(), filename);
                } else if (b == 3) {
                    return cVar.Cg() ? new d.g(id, cVar.Em()) : new h.g(id, (int) cVar.Em());
                } else if (b != 5) {
                    if (b != 6) {
                        String h = com.kwai.filedownloader.e.f.h("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                        com.kwai.filedownloader.e.d.f(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                        IllegalStateException illegalStateException = aVar.getException() != null ? new IllegalStateException(h, aVar.getException()) : new IllegalStateException(h);
                        return cVar.Cg() ? new d.C0707d(id, cVar.Em(), illegalStateException) : new h.d(id, (int) cVar.Em(), illegalStateException);
                    }
                    return new MessageSnapshot.b(id);
                } else {
                    c0707d = cVar.Cg() ? new d.h(id, cVar.Em(), aVar.getException(), aVar.Ce()) : new h.C0708h(id, (int) cVar.Em(), aVar.getException(), aVar.Ce());
                }
                return c0707d;
            }
            throw new IllegalStateException(com.kwai.filedownloader.e.f.h("please use #catchWarn instead %d", Integer.valueOf(id)));
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Long.valueOf(j), th})) == null) ? j > 2147483647L ? new d.C0707d(i, j, th) : new h.d(i, (int) j, th) : (MessageSnapshot) invokeCommon.objValue;
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

    public static MessageSnapshot e(com.kwai.filedownloader.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aVar)) == null) ? aVar.Cg() ? new d.e(aVar.getId(), aVar.BY(), aVar.BZ()) : new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes()) : (MessageSnapshot) invokeL.objValue;
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, messageSnapshot)) == null) {
            if (messageSnapshot.Ca() == -3) {
                return new a.C0706a(messageSnapshot);
            }
            throw new IllegalStateException(com.kwai.filedownloader.e.f.h("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Ca())));
        }
        return (MessageSnapshot) invokeL.objValue;
    }
}
