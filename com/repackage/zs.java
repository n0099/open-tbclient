package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class zs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static us a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            us usVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                usVar = new us();
                wrap.get();
                wrap.get();
                usVar.a(wrap.get());
                usVar.f(wrap.get());
                int i = wrap.getShort();
                usVar.c(i);
                int i2 = wrap.getInt();
                usVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                usVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    usVar.l(bArr3);
                }
            }
            return usVar;
        }
        return (us) invokeL.objValue;
    }

    public static byte[] b(us usVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, usVar)) == null) {
            if (usVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(usVar.m() + 12 + usVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (usVar.e() != null && usVar.e().length == 2) {
                allocate.put(usVar.e()[0]);
                allocate.put(usVar.e()[1]);
                allocate.put(usVar.i());
                allocate.put(usVar.k());
                if (usVar.o() != null && usVar.o().length != 0) {
                    int length = usVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (usVar.p() != null && usVar.p().length != 0) {
                        allocate.putInt(usVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (usVar.o() != null) {
                        allocate.put(usVar.o());
                    }
                    if (usVar.p() != null) {
                        allocate.put(usVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
