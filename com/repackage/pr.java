package com.repackage;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.cr;
import com.repackage.dr;
import com.repackage.er;
import com.repackage.fr;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes6.dex */
public class pr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static jr a(nr nrVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, nrVar, bArr)) != null) {
            return (jr) invokeLL.objValue;
        }
        jr jrVar = null;
        if (nrVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            jr jrVar2 = new jr();
            try {
                gr a = gr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (a == null) {
                    return null;
                }
                jrVar2.a(a);
                List<er> b = a.b();
                if (b == null) {
                    return null;
                }
                for (er erVar : b) {
                    int a2 = erVar.a();
                    byte[] b2 = erVar.b();
                    if (a2 == 0) {
                        int a3 = vr.a(RSA.decrypt(b2));
                        nrVar.e(DH.getDHSecretKey(a3, nrVar.o().intValue(), nrVar.p().intValue()));
                        nrVar.l(Integer.valueOf(a3));
                    }
                }
                if (a.e() == null) {
                    return null;
                }
                cr.a d = cr.d();
                d.a(a.e());
                nrVar.h(d.b().a());
                if (nrVar.q() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("liftTime=" + a.c());
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("expireTime=" + currentTimeMillis);
                nrVar.c(currentTimeMillis);
                if (a.d() != null) {
                    nrVar.j(a.d());
                    return jrVar2;
                }
                return jrVar2;
            } catch (Exception e) {
                e = e;
                jrVar = jrVar2;
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("exception=" + e.getMessage());
                return jrVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static byte[] b(nr nrVar, jr jrVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, nrVar, jrVar)) == null) {
            if (jrVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            fr.a a = fr.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(ct.a(bArr));
            fr c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            nrVar.d(Integer.valueOf(dHGroupId));
            nrVar.g(Integer.valueOf(dHSecret));
            nrVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = vr.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = dt.b(ft.b(ys.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            er.a d2 = er.d();
            d2.a(0);
            d2.b(ct.a(encrypt));
            linkedList.offer(d2.c());
            er.a d3 = er.d();
            d3.a(1);
            d3.b(ct.a(new byte[]{0}));
            linkedList.offer(d3.c());
            er.a d4 = er.d();
            d4.a(2);
            d4.b(ct.a(vr.d(dHGroupId)));
            linkedList.offer(d4.c());
            er.a d5 = er.d();
            d5.a(3);
            d5.b(ct.a(bytes));
            linkedList.offer(d5.c());
            if (ar.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            dr.a d6 = dr.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((er) it.next());
            }
            d6.b(c);
            d6.c(ct.a(or.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
