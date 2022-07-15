package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class tj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static pj3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            pj3 pj3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                pj3Var = new pj3();
                wrap.get();
                wrap.get();
                pj3Var.r(wrap.get());
                pj3Var.p(wrap.get());
                int i = wrap.getShort();
                pj3Var.q(i);
                int i2 = wrap.getInt();
                pj3Var.k(i2);
                pj3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                pj3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    pj3Var.j(bArr3);
                }
            }
            return pj3Var;
        }
        return (pj3) invokeL.objValue;
    }

    public static byte[] b(pj3 pj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pj3Var)) == null) {
            if (pj3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(pj3Var.h() + 20 + pj3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (pj3Var.e() != null && pj3Var.e().length == 2) {
                allocate.put(pj3Var.e()[0]);
                allocate.put(pj3Var.e()[1]);
                allocate.put(pj3Var.i());
                allocate.put(pj3Var.g());
                if (pj3Var.f() != null && pj3Var.f().length != 0) {
                    int length = pj3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (pj3Var.a() != null && pj3Var.a().length != 0) {
                        allocate.putInt(pj3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(pj3Var.c());
                    if (pj3Var.f() != null) {
                        allocate.put(pj3Var.f());
                    }
                    if (pj3Var.a() != null) {
                        allocate.put(pj3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
