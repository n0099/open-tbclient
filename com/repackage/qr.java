package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class qr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static lr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            lr lrVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                lrVar = new lr();
                wrap.get();
                wrap.get();
                lrVar.a(wrap.get());
                lrVar.f(wrap.get());
                int i = wrap.getShort();
                lrVar.c(i);
                int i2 = wrap.getInt();
                lrVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                lrVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    lrVar.l(bArr3);
                }
            }
            return lrVar;
        }
        return (lr) invokeL.objValue;
    }

    public static byte[] b(lr lrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lrVar)) == null) {
            if (lrVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(lrVar.m() + 12 + lrVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (lrVar.e() != null && lrVar.e().length == 2) {
                allocate.put(lrVar.e()[0]);
                allocate.put(lrVar.e()[1]);
                allocate.put(lrVar.i());
                allocate.put(lrVar.k());
                if (lrVar.o() != null && lrVar.o().length != 0) {
                    int length = lrVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (lrVar.p() != null && lrVar.p().length != 0) {
                        allocate.putInt(lrVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (lrVar.o() != null) {
                        allocate.put(lrVar.o());
                    }
                    if (lrVar.p() != null) {
                        allocate.put(lrVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
