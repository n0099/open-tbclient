package com.repackage;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.dr;
import com.repackage.er;
import com.repackage.fr;
import com.repackage.gr;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes7.dex */
public class qr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static kr a(or orVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, orVar, bArr)) != null) {
            return (kr) invokeLL.objValue;
        }
        kr krVar = null;
        if (orVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            kr krVar2 = new kr();
            try {
                hr a = hr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (a == null) {
                    return null;
                }
                krVar2.a(a);
                List<fr> b = a.b();
                if (b == null) {
                    return null;
                }
                for (fr frVar : b) {
                    int a2 = frVar.a();
                    byte[] b2 = frVar.b();
                    if (a2 == 0) {
                        int a3 = wr.a(RSA.decrypt(b2));
                        orVar.e(DH.getDHSecretKey(a3, orVar.o().intValue(), orVar.p().intValue()));
                        orVar.l(Integer.valueOf(a3));
                    }
                }
                if (a.e() == null) {
                    return null;
                }
                dr.a d = dr.d();
                d.a(a.e());
                orVar.h(d.b().a());
                if (orVar.q() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("liftTime=" + a.c());
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("expireTime=" + currentTimeMillis);
                orVar.c(currentTimeMillis);
                if (a.d() != null) {
                    orVar.j(a.d());
                    return krVar2;
                }
                return krVar2;
            } catch (Exception e) {
                e = e;
                krVar = krVar2;
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("exception=" + e.getMessage());
                return krVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static byte[] b(or orVar, kr krVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, orVar, krVar)) == null) {
            if (krVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            gr.a a = gr.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(dt.a(bArr));
            gr c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            orVar.d(Integer.valueOf(dHGroupId));
            orVar.g(Integer.valueOf(dHSecret));
            orVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = wr.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = et.b(gt.b(zs.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            fr.a d2 = fr.d();
            d2.a(0);
            d2.b(dt.a(encrypt));
            linkedList.offer(d2.c());
            fr.a d3 = fr.d();
            d3.a(1);
            d3.b(dt.a(new byte[]{0}));
            linkedList.offer(d3.c());
            fr.a d4 = fr.d();
            d4.a(2);
            d4.b(dt.a(wr.d(dHGroupId)));
            linkedList.offer(d4.c());
            fr.a d5 = fr.d();
            d5.a(3);
            d5.b(dt.a(bytes));
            linkedList.offer(d5.c());
            if (br.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            er.a d6 = er.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((fr) it.next());
            }
            d6.b(c);
            d6.c(dt.a(pr.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
