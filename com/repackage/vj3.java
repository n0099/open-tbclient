package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class vj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static rj3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            rj3 rj3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                rj3Var = new rj3();
                wrap.get();
                wrap.get();
                rj3Var.r(wrap.get());
                rj3Var.p(wrap.get());
                int i = wrap.getShort();
                rj3Var.q(i);
                int i2 = wrap.getInt();
                rj3Var.k(i2);
                rj3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                rj3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    rj3Var.j(bArr3);
                }
            }
            return rj3Var;
        }
        return (rj3) invokeL.objValue;
    }

    public static byte[] b(rj3 rj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rj3Var)) == null) {
            if (rj3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(rj3Var.h() + 20 + rj3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (rj3Var.e() != null && rj3Var.e().length == 2) {
                allocate.put(rj3Var.e()[0]);
                allocate.put(rj3Var.e()[1]);
                allocate.put(rj3Var.i());
                allocate.put(rj3Var.g());
                if (rj3Var.f() != null && rj3Var.f().length != 0) {
                    int length = rj3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (rj3Var.a() != null && rj3Var.a().length != 0) {
                        allocate.putInt(rj3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(rj3Var.c());
                    if (rj3Var.f() != null) {
                        allocate.put(rj3Var.f());
                    }
                    if (rj3Var.a() != null) {
                        allocate.put(rj3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
