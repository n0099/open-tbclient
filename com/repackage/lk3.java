package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class lk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static hk3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            hk3 hk3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                hk3Var = new hk3();
                wrap.get();
                wrap.get();
                hk3Var.r(wrap.get());
                hk3Var.p(wrap.get());
                int i = wrap.getShort();
                hk3Var.q(i);
                int i2 = wrap.getInt();
                hk3Var.k(i2);
                hk3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                hk3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    hk3Var.j(bArr3);
                }
            }
            return hk3Var;
        }
        return (hk3) invokeL.objValue;
    }

    public static byte[] b(hk3 hk3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hk3Var)) == null) {
            if (hk3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(hk3Var.h() + 20 + hk3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (hk3Var.e() != null && hk3Var.e().length == 2) {
                allocate.put(hk3Var.e()[0]);
                allocate.put(hk3Var.e()[1]);
                allocate.put(hk3Var.i());
                allocate.put(hk3Var.g());
                if (hk3Var.f() != null && hk3Var.f().length != 0) {
                    int length = hk3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (hk3Var.a() != null && hk3Var.a().length != 0) {
                        allocate.putInt(hk3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(hk3Var.c());
                    if (hk3Var.f() != null) {
                        allocate.put(hk3Var.f());
                    }
                    if (hk3Var.a() != null) {
                        allocate.put(hk3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
