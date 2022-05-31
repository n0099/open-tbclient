package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class mr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static hr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            hr hrVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                hrVar = new hr();
                wrap.get();
                wrap.get();
                hrVar.a(wrap.get());
                hrVar.f(wrap.get());
                int i = wrap.getShort();
                hrVar.c(i);
                int i2 = wrap.getInt();
                hrVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                hrVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    hrVar.l(bArr3);
                }
            }
            return hrVar;
        }
        return (hr) invokeL.objValue;
    }

    public static byte[] b(hr hrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hrVar)) == null) {
            if (hrVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(hrVar.m() + 12 + hrVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (hrVar.e() != null && hrVar.e().length == 2) {
                allocate.put(hrVar.e()[0]);
                allocate.put(hrVar.e()[1]);
                allocate.put(hrVar.i());
                allocate.put(hrVar.k());
                if (hrVar.o() != null && hrVar.o().length != 0) {
                    int length = hrVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (hrVar.p() != null && hrVar.p().length != 0) {
                        allocate.putInt(hrVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (hrVar.o() != null) {
                        allocate.put(hrVar.o());
                    }
                    if (hrVar.p() != null) {
                        allocate.put(hrVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
