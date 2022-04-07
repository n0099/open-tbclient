package com.repackage;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ct;
import com.repackage.dt;
import com.repackage.et;
import com.repackage.ft;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes6.dex */
public class pt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static jt a(nt ntVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, ntVar, bArr)) != null) {
            return (jt) invokeLL.objValue;
        }
        jt jtVar = null;
        if (ntVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            jt jtVar2 = new jt();
            try {
                gt a = gt.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (a == null) {
                    return null;
                }
                jtVar2.a(a);
                List<et> b = a.b();
                if (b == null) {
                    return null;
                }
                for (et etVar : b) {
                    int a2 = etVar.a();
                    byte[] b2 = etVar.b();
                    if (a2 == 0) {
                        int a3 = vt.a(RSA.decrypt(b2));
                        ntVar.e(DH.getDHSecretKey(a3, ntVar.o().intValue(), ntVar.p().intValue()));
                        ntVar.l(Integer.valueOf(a3));
                    }
                }
                if (a.e() == null) {
                    return null;
                }
                ct.a d = ct.d();
                d.a(a.e());
                ntVar.h(d.b().a());
                if (ntVar.q() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("liftTime=" + a.c());
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("expireTime=" + currentTimeMillis);
                ntVar.c(currentTimeMillis);
                if (a.d() != null) {
                    ntVar.j(a.d());
                    return jtVar2;
                }
                return jtVar2;
            } catch (Exception e) {
                e = e;
                jtVar = jtVar2;
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("exception=" + e.getMessage());
                return jtVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static byte[] b(nt ntVar, jt jtVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ntVar, jtVar)) == null) {
            if (jtVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            ft.a a = ft.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(cv.a(bArr));
            ft c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            ntVar.d(Integer.valueOf(dHGroupId));
            ntVar.g(Integer.valueOf(dHSecret));
            ntVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = vt.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = dv.b(fv.b(yu.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            et.a d2 = et.d();
            d2.a(0);
            d2.b(cv.a(encrypt));
            linkedList.offer(d2.c());
            et.a d3 = et.d();
            d3.a(1);
            d3.b(cv.a(new byte[]{0}));
            linkedList.offer(d3.c());
            et.a d4 = et.d();
            d4.a(2);
            d4.b(cv.a(vt.d(dHGroupId)));
            linkedList.offer(d4.c());
            et.a d5 = et.d();
            d5.a(3);
            d5.b(cv.a(bytes));
            linkedList.offer(d5.c());
            if (at.c.h().d()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            dt.a d6 = dt.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((et) it.next());
            }
            d6.b(c);
            d6.c(cv.a(ot.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
