package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class rr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static mr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            mr mrVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                mrVar = new mr();
                wrap.get();
                wrap.get();
                mrVar.a(wrap.get());
                mrVar.f(wrap.get());
                int i = wrap.getShort();
                mrVar.c(i);
                int i2 = wrap.getInt();
                mrVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                mrVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    mrVar.l(bArr3);
                }
            }
            return mrVar;
        }
        return (mr) invokeL.objValue;
    }

    public static byte[] b(mr mrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mrVar)) == null) {
            if (mrVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(mrVar.m() + 12 + mrVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (mrVar.e() != null && mrVar.e().length == 2) {
                allocate.put(mrVar.e()[0]);
                allocate.put(mrVar.e()[1]);
                allocate.put(mrVar.i());
                allocate.put(mrVar.k());
                if (mrVar.o() != null && mrVar.o().length != 0) {
                    int length = mrVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (mrVar.p() != null && mrVar.p().length != 0) {
                        allocate.putInt(mrVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (mrVar.o() != null) {
                        allocate.put(mrVar.o());
                    }
                    if (mrVar.p() != null) {
                        allocate.put(mrVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
