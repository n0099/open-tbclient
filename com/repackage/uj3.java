package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class uj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static qj3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            qj3 qj3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                qj3Var = new qj3();
                wrap.get();
                wrap.get();
                qj3Var.r(wrap.get());
                qj3Var.p(wrap.get());
                int i = wrap.getShort();
                qj3Var.q(i);
                int i2 = wrap.getInt();
                qj3Var.k(i2);
                qj3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                qj3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    qj3Var.j(bArr3);
                }
            }
            return qj3Var;
        }
        return (qj3) invokeL.objValue;
    }

    public static byte[] b(qj3 qj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qj3Var)) == null) {
            if (qj3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(qj3Var.h() + 20 + qj3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (qj3Var.e() != null && qj3Var.e().length == 2) {
                allocate.put(qj3Var.e()[0]);
                allocate.put(qj3Var.e()[1]);
                allocate.put(qj3Var.i());
                allocate.put(qj3Var.g());
                if (qj3Var.f() != null && qj3Var.f().length != 0) {
                    int length = qj3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (qj3Var.a() != null && qj3Var.a().length != 0) {
                        allocate.putInt(qj3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(qj3Var.c());
                    if (qj3Var.f() != null) {
                        allocate.put(qj3Var.f());
                    }
                    if (qj3Var.a() != null) {
                        allocate.put(qj3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
