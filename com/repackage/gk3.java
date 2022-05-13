package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class gk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static ck3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            ck3 ck3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                ck3Var = new ck3();
                wrap.get();
                wrap.get();
                ck3Var.r(wrap.get());
                ck3Var.p(wrap.get());
                int i = wrap.getShort();
                ck3Var.q(i);
                int i2 = wrap.getInt();
                ck3Var.k(i2);
                ck3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                ck3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    ck3Var.j(bArr3);
                }
            }
            return ck3Var;
        }
        return (ck3) invokeL.objValue;
    }

    public static byte[] b(ck3 ck3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ck3Var)) == null) {
            if (ck3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(ck3Var.h() + 20 + ck3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (ck3Var.e() != null && ck3Var.e().length == 2) {
                allocate.put(ck3Var.e()[0]);
                allocate.put(ck3Var.e()[1]);
                allocate.put(ck3Var.i());
                allocate.put(ck3Var.g());
                if (ck3Var.f() != null && ck3Var.f().length != 0) {
                    int length = ck3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (ck3Var.a() != null && ck3Var.a().length != 0) {
                        allocate.putInt(ck3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(ck3Var.c());
                    if (ck3Var.f() != null) {
                        allocate.put(ck3Var.f());
                    }
                    if (ck3Var.a() != null) {
                        allocate.put(ck3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
