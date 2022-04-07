package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class qt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static lt a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            lt ltVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                ltVar = new lt();
                wrap.get();
                wrap.get();
                ltVar.a(wrap.get());
                ltVar.f(wrap.get());
                int i = wrap.getShort();
                ltVar.c(i);
                int i2 = wrap.getInt();
                ltVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                ltVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    ltVar.l(bArr3);
                }
            }
            return ltVar;
        }
        return (lt) invokeL.objValue;
    }

    public static byte[] b(lt ltVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ltVar)) == null) {
            if (ltVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(ltVar.m() + 12 + ltVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (ltVar.e() != null && ltVar.e().length == 2) {
                allocate.put(ltVar.e()[0]);
                allocate.put(ltVar.e()[1]);
                allocate.put(ltVar.i());
                allocate.put(ltVar.k());
                if (ltVar.o() != null && ltVar.o().length != 0) {
                    int length = ltVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (ltVar.p() != null && ltVar.p().length != 0) {
                        allocate.putInt(ltVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (ltVar.o() != null) {
                        allocate.put(ltVar.o());
                    }
                    if (ltVar.p() != null) {
                        allocate.put(ltVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
