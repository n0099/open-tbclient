package com.repackage;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ls;
import com.repackage.ms;
import com.repackage.ns;
import com.repackage.os;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes7.dex */
public class ys {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ss a(ws wsVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, wsVar, bArr)) != null) {
            return (ss) invokeLL.objValue;
        }
        ss ssVar = null;
        if (wsVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            ss ssVar2 = new ss();
            try {
                ps a = ps.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (a == null) {
                    return null;
                }
                ssVar2.a(a);
                List<ns> b = a.b();
                if (b == null) {
                    return null;
                }
                for (ns nsVar : b) {
                    int a2 = nsVar.a();
                    byte[] b2 = nsVar.b();
                    if (a2 == 0) {
                        int a3 = et.a(RSA.decrypt(b2));
                        wsVar.e(DH.getDHSecretKey(a3, wsVar.o().intValue(), wsVar.p().intValue()));
                        wsVar.l(Integer.valueOf(a3));
                    }
                }
                if (a.e() == null) {
                    return null;
                }
                ls.a d = ls.d();
                d.a(a.e());
                wsVar.h(d.b().a());
                if (wsVar.q() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("liftTime=" + a.c());
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("expireTime=" + currentTimeMillis);
                wsVar.c(currentTimeMillis);
                if (a.d() != null) {
                    wsVar.j(a.d());
                    return ssVar2;
                }
                return ssVar2;
            } catch (Exception e) {
                e = e;
                ssVar = ssVar2;
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("exception=" + e.getMessage());
                return ssVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static byte[] b(ws wsVar, ss ssVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, wsVar, ssVar)) == null) {
            if (ssVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            os.a a = os.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(lu.a(bArr));
            os c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            wsVar.d(Integer.valueOf(dHGroupId));
            wsVar.g(Integer.valueOf(dHSecret));
            wsVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = et.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = mu.b(ou.b(hu.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            ns.a d2 = ns.d();
            d2.a(0);
            d2.b(lu.a(encrypt));
            linkedList.offer(d2.c());
            ns.a d3 = ns.d();
            d3.a(1);
            d3.b(lu.a(new byte[]{0}));
            linkedList.offer(d3.c());
            ns.a d4 = ns.d();
            d4.a(2);
            d4.b(lu.a(et.d(dHGroupId)));
            linkedList.offer(d4.c());
            ns.a d5 = ns.d();
            d5.a(3);
            d5.b(lu.a(bytes));
            linkedList.offer(d5.c());
            if (js.c.h().d()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            ms.a d6 = ms.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((ns) it.next());
            }
            d6.b(c);
            d6.c(lu.a(xs.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
