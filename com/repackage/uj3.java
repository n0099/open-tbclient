package com.repackage;

import android.util.Log;
import com.baidu.swan.bdtls.Certificate;
import com.baidu.swan.bdtls.DH;
import com.baidu.swan.bdtls.RSA;
import com.baidu.swan.bdtls.impl.model.Bdtls$ApplicationData;
import com.baidu.swan.bdtls.impl.model.Bdtls$ClientHello;
import com.baidu.swan.bdtls.impl.model.Bdtls$Extension;
import com.baidu.swan.bdtls.impl.model.Bdtls$Random;
import com.baidu.swan.bdtls.impl.model.Bdtls$ServerHello;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes7.dex */
public class uj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static qj3 a(tj3 tj3Var, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, tj3Var, bArr)) != null) {
            return (qj3) invokeLL.objValue;
        }
        qj3 qj3Var = null;
        if (tj3Var == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            qj3 qj3Var2 = new qj3();
            try {
                Bdtls$ServerHello parseFrom = Bdtls$ServerHello.parseFrom(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (parseFrom == null) {
                    return null;
                }
                qj3Var2.a(parseFrom);
                List<Bdtls$Extension> extensionsList = parseFrom.getExtensionsList();
                if (extensionsList == null) {
                    return null;
                }
                for (Bdtls$Extension bdtls$Extension : extensionsList) {
                    int type = bdtls$Extension.getType();
                    byte[] byteArray = bdtls$Extension.getData().toByteArray();
                    if (type == 0) {
                        byte[] decrypt = RSA.decrypt(byteArray);
                        int a = ij3.a(decrypt);
                        byte[] dHSecretKey = DH.getDHSecretKey(a, tj3Var.d().intValue(), tj3Var.f().intValue());
                        tj3Var.l(dHSecretKey);
                        tj3Var.p(Integer.valueOf(a));
                        if (ej3.a) {
                            Log.d("BDTLS", "GroupId=" + tj3Var.d());
                            Log.d("BDTLS", "client dh pubkey secret=" + tj3Var.f());
                            Log.d("BDTLS", "client dh pubkey=" + tj3Var.e());
                            Log.d("BDTLS", "server dh pubkey=" + a);
                            Log.d("BDTLS", "server dh raw pubkey=" + ij3.d(decrypt));
                            Log.d("BDTLS", "aeskey=" + ij3.d(dHSecretKey));
                        }
                    }
                }
                if (parseFrom.getSKR() == null) {
                    return null;
                }
                Bdtls$ApplicationData.b newBuilder = Bdtls$ApplicationData.newBuilder();
                newBuilder.v(parseFrom.getSKR());
                Bdtls$ApplicationData build = newBuilder.build();
                tj3Var.t(build.toByteArray());
                if (tj3Var.c() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + parseFrom.getLifeTime();
                if (ej3.a) {
                    Log.d("BDTLS", "liftTime=" + parseFrom.getLifeTime());
                    Log.d("BDTLS", "expireTime=" + currentTimeMillis);
                }
                tj3Var.r(currentTimeMillis);
                if (parseFrom.getCipherSuite() != null) {
                    tj3Var.q(parseFrom.getCipherSuite().toByteArray());
                }
                if (hu2.c()) {
                    new pj3().edit().putString("secretKey", Arrays.toString(tj3Var.c())).putString("sessionTicket", String.valueOf(build)).putLong("expireTime", currentTimeMillis).apply();
                    return qj3Var2;
                }
                return qj3Var2;
            } catch (Exception e) {
                e = e;
                qj3Var = qj3Var2;
                if (ej3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                }
                return qj3Var;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static byte[] b(tj3 tj3Var, qj3 qj3Var) {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tj3Var, qj3Var)) == null) {
            if (qj3Var == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            Bdtls$Random.b newBuilder = Bdtls$Random.newBuilder();
            newBuilder.w(currentTimeMillis);
            newBuilder.x(ByteString.copyFrom(bArr));
            Bdtls$Random build = newBuilder.build();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            tj3Var.m(Integer.valueOf(dHGroupId));
            tj3Var.o(Integer.valueOf(dHSecret));
            tj3Var.n(Integer.valueOf(dHPublicKey));
            byte[] g = ij3.g(dHPublicKey);
            if (g == null || (encrypt = RSA.encrypt(g)) == null) {
                return null;
            }
            byte[] bytes = pg4.a(Certificate.getSignature(qj2.c()), "", false).getBytes(StandardCharsets.UTF_8);
            LinkedList linkedList = new LinkedList();
            Bdtls$Extension.b newBuilder2 = Bdtls$Extension.newBuilder();
            newBuilder2.w(0);
            newBuilder2.v(ByteString.copyFrom(encrypt));
            linkedList.offer(newBuilder2.build());
            Bdtls$Extension.b newBuilder3 = Bdtls$Extension.newBuilder();
            newBuilder3.w(1);
            newBuilder3.v(ByteString.copyFrom(new byte[]{0}));
            linkedList.offer(newBuilder3.build());
            Bdtls$Extension.b newBuilder4 = Bdtls$Extension.newBuilder();
            newBuilder4.w(2);
            newBuilder4.v(ByteString.copyFrom(ij3.g(dHGroupId)));
            linkedList.offer(newBuilder4.build());
            Bdtls$Extension.b newBuilder5 = Bdtls$Extension.newBuilder();
            newBuilder5.w(3);
            newBuilder5.v(ByteString.copyFrom(bytes));
            linkedList.offer(newBuilder5.build());
            if (hu2.c()) {
                if (dk3.getContext() != null) {
                    Bdtls$Extension.b newBuilder6 = Bdtls$Extension.newBuilder();
                    newBuilder6.w(4);
                    newBuilder6.v(ByteString.copyFrom(dk3.getContext().b().getBytes()));
                    linkedList.offer(newBuilder6.build());
                }
                if (dk3.getContext() != null) {
                    Bdtls$Extension.b newBuilder7 = Bdtls$Extension.newBuilder();
                    newBuilder7.w(5);
                    newBuilder7.v(ByteString.copyFrom(kg4.f().getBytes()));
                    linkedList.offer(newBuilder7.build());
                }
            }
            if (ej3.a) {
                Log.d("BDTLS", "groupId encode=" + dHGroupId);
                Log.d("BDTLS", "secretC encode=" + dHSecret);
                Log.d("BDTLS", "pubKey encode=" + dHPublicKey);
                Log.d("BDTLS", "signature encode=" + new String(bytes));
            }
            Bdtls$ClientHello.b newBuilder8 = Bdtls$ClientHello.newBuilder();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                newBuilder8.n((Bdtls$Extension) it.next());
            }
            newBuilder8.C(build);
            newBuilder8.m(ByteString.copyFrom(fj3.c));
            byte[] byteArray = newBuilder8.build().toByteArray();
            ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 1);
            allocate.put((byte) 1);
            allocate.put(byteArray);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
