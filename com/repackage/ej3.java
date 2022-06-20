package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class ej3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static aj3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            aj3 aj3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                aj3Var = new aj3();
                wrap.get();
                wrap.get();
                aj3Var.r(wrap.get());
                aj3Var.p(wrap.get());
                int i = wrap.getShort();
                aj3Var.q(i);
                int i2 = wrap.getInt();
                aj3Var.k(i2);
                aj3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                aj3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    aj3Var.j(bArr3);
                }
            }
            return aj3Var;
        }
        return (aj3) invokeL.objValue;
    }

    public static byte[] b(aj3 aj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aj3Var)) == null) {
            if (aj3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(aj3Var.h() + 20 + aj3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (aj3Var.e() != null && aj3Var.e().length == 2) {
                allocate.put(aj3Var.e()[0]);
                allocate.put(aj3Var.e()[1]);
                allocate.put(aj3Var.i());
                allocate.put(aj3Var.g());
                if (aj3Var.f() != null && aj3Var.f().length != 0) {
                    int length = aj3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (aj3Var.a() != null && aj3Var.a().length != 0) {
                        allocate.putInt(aj3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(aj3Var.c());
                    if (aj3Var.f() != null) {
                        allocate.put(aj3Var.f());
                    }
                    if (aj3Var.a() != null) {
                        allocate.put(aj3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
