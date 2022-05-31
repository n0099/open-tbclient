package com.repackage;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ar;
import com.repackage.br;
import com.repackage.yq;
import com.repackage.zq;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes6.dex */
public class lr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fr a(jr jrVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, jrVar, bArr)) != null) {
            return (fr) invokeLL.objValue;
        }
        fr frVar = null;
        if (jrVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            fr frVar2 = new fr();
            try {
                cr a = cr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (a == null) {
                    return null;
                }
                frVar2.a(a);
                List<ar> b = a.b();
                if (b == null) {
                    return null;
                }
                for (ar arVar : b) {
                    int a2 = arVar.a();
                    byte[] b2 = arVar.b();
                    if (a2 == 0) {
                        int a3 = rr.a(RSA.decrypt(b2));
                        jrVar.e(DH.getDHSecretKey(a3, jrVar.o().intValue(), jrVar.p().intValue()));
                        jrVar.l(Integer.valueOf(a3));
                    }
                }
                if (a.e() == null) {
                    return null;
                }
                yq.a d = yq.d();
                d.a(a.e());
                jrVar.h(d.b().a());
                if (jrVar.q() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("liftTime=" + a.c());
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("expireTime=" + currentTimeMillis);
                jrVar.c(currentTimeMillis);
                if (a.d() != null) {
                    jrVar.j(a.d());
                    return frVar2;
                }
                return frVar2;
            } catch (Exception e) {
                e = e;
                frVar = frVar2;
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("exception=" + e.getMessage());
                return frVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static byte[] b(jr jrVar, fr frVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jrVar, frVar)) == null) {
            if (frVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            br.a a = br.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(ys.a(bArr));
            br c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            jrVar.d(Integer.valueOf(dHGroupId));
            jrVar.g(Integer.valueOf(dHSecret));
            jrVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = rr.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = zs.b(bt.b(us.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            ar.a d2 = ar.d();
            d2.a(0);
            d2.b(ys.a(encrypt));
            linkedList.offer(d2.c());
            ar.a d3 = ar.d();
            d3.a(1);
            d3.b(ys.a(new byte[]{0}));
            linkedList.offer(d3.c());
            ar.a d4 = ar.d();
            d4.a(2);
            d4.b(ys.a(rr.d(dHGroupId)));
            linkedList.offer(d4.c());
            ar.a d5 = ar.d();
            d5.a(3);
            d5.b(ys.a(bytes));
            linkedList.offer(d5.c());
            if (wq.c.h().d()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            zq.a d6 = zq.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((ar) it.next());
            }
            d6.b(c);
            d6.c(ys.a(kr.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
