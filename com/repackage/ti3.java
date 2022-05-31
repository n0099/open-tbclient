package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class ti3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static pi3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            pi3 pi3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                pi3Var = new pi3();
                wrap.get();
                wrap.get();
                pi3Var.r(wrap.get());
                pi3Var.p(wrap.get());
                int i = wrap.getShort();
                pi3Var.q(i);
                int i2 = wrap.getInt();
                pi3Var.k(i2);
                pi3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                pi3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    pi3Var.j(bArr3);
                }
            }
            return pi3Var;
        }
        return (pi3) invokeL.objValue;
    }

    public static byte[] b(pi3 pi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pi3Var)) == null) {
            if (pi3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(pi3Var.h() + 20 + pi3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (pi3Var.e() != null && pi3Var.e().length == 2) {
                allocate.put(pi3Var.e()[0]);
                allocate.put(pi3Var.e()[1]);
                allocate.put(pi3Var.i());
                allocate.put(pi3Var.g());
                if (pi3Var.f() != null && pi3Var.f().length != 0) {
                    int length = pi3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (pi3Var.a() != null && pi3Var.a().length != 0) {
                        allocate.putInt(pi3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(pi3Var.c());
                    if (pi3Var.f() != null) {
                        allocate.put(pi3Var.f());
                    }
                    if (pi3Var.a() != null) {
                        allocate.put(pi3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
