package d.b.g0.g.d.h;

import android.util.Log;
import com.baidu.swan.bdtls.Certificate;
import com.baidu.swan.bdtls.DH;
import com.baidu.swan.bdtls.RSA;
import com.baidu.swan.games.bdtls.model.Bdtls$ApplicationData;
import com.baidu.swan.games.bdtls.model.Bdtls$ClientHello;
import com.baidu.swan.games.bdtls.model.Bdtls$Extension;
import com.baidu.swan.games.bdtls.model.Bdtls$Random;
import com.baidu.swan.games.bdtls.model.Bdtls$ServerHello;
import com.google.protobuf.ByteString;
import d.b.g0.g.d.g.d;
import d.b.g0.g.d.g.g;
import d.b.g0.p.e;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    public static d a(g gVar, byte[] bArr) {
        d dVar = null;
        if (gVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            d dVar2 = new d();
            try {
                Bdtls$ServerHello parseFrom = Bdtls$ServerHello.parseFrom(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (parseFrom == null) {
                    return null;
                }
                dVar2.a(parseFrom);
                List<Bdtls$Extension> extensionsList = parseFrom.getExtensionsList();
                if (extensionsList == null) {
                    return null;
                }
                for (Bdtls$Extension bdtls$Extension : extensionsList) {
                    int type = bdtls$Extension.getType();
                    byte[] byteArray = bdtls$Extension.getData().toByteArray();
                    if (type == 0) {
                        byte[] decrypt = RSA.decrypt(byteArray);
                        int a2 = d.b.g0.g.d.d.a(decrypt);
                        byte[] d2 = DH.d(a2, gVar.d().intValue(), gVar.f().intValue());
                        gVar.l(d2);
                        gVar.p(Integer.valueOf(a2));
                        if (d.b.g0.g.d.a.f48027a) {
                            Log.d("BDTLS", "GroupId=" + gVar.d());
                            Log.d("BDTLS", "client dh pubkey secret=" + gVar.f());
                            Log.d("BDTLS", "client dh pubkey=" + gVar.e());
                            Log.d("BDTLS", "server dh pubkey=" + a2);
                            Log.d("BDTLS", "server dh raw pubkey=" + d.b.g0.g.d.d.d(decrypt));
                            Log.d("BDTLS", "aeskey=" + d.b.g0.g.d.d.d(d2));
                        }
                    }
                }
                if (parseFrom.getSKR() == null) {
                    return null;
                }
                Bdtls$ApplicationData.b newBuilder = Bdtls$ApplicationData.newBuilder();
                newBuilder.v(parseFrom.getSKR());
                gVar.t(newBuilder.build().toByteArray());
                if (gVar.c() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + parseFrom.getLifeTime();
                if (d.b.g0.g.d.a.f48027a) {
                    Log.d("BDTLS", "liftTime=" + parseFrom.getLifeTime());
                    Log.d("BDTLS", "expireTime=" + currentTimeMillis);
                }
                gVar.r(currentTimeMillis);
                if (parseFrom.getCipherSuite() != null) {
                    gVar.q(parseFrom.getCipherSuite().toByteArray());
                    return dVar2;
                }
                return dVar2;
            } catch (Exception e2) {
                e = e2;
                dVar = dVar2;
                if (d.b.g0.g.d.a.f48027a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                }
                return dVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static byte[] b(g gVar, d dVar) {
        byte[] encrypt;
        if (dVar == null) {
            return null;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        byte[] bArr = new byte[32];
        new Random().nextBytes(bArr);
        Bdtls$Random.b newBuilder = Bdtls$Random.newBuilder();
        newBuilder.w(currentTimeMillis);
        newBuilder.x(ByteString.copyFrom(bArr));
        Bdtls$Random build = newBuilder.build();
        int a2 = DH.a();
        int c2 = DH.c();
        int b2 = DH.b(a2, c2);
        gVar.m(Integer.valueOf(a2));
        gVar.o(Integer.valueOf(c2));
        gVar.n(Integer.valueOf(b2));
        byte[] g2 = d.b.g0.g.d.d.g(b2);
        if (g2 == null || (encrypt = RSA.encrypt(g2)) == null) {
            return null;
        }
        byte[] bytes = e.a(Certificate.a(d.b.g0.a.w0.a.c()), "", false).getBytes(StandardCharsets.UTF_8);
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
        newBuilder4.v(ByteString.copyFrom(d.b.g0.g.d.d.g(a2)));
        linkedList.offer(newBuilder4.build());
        Bdtls$Extension.b newBuilder5 = Bdtls$Extension.newBuilder();
        newBuilder5.w(3);
        newBuilder5.v(ByteString.copyFrom(bytes));
        linkedList.offer(newBuilder5.build());
        if (d.b.g0.g.d.a.f48027a) {
            Log.d("BDTLS", "groupId encode=" + a2);
            Log.d("BDTLS", "secretC encode=" + c2);
            Log.d("BDTLS", "pubKey encode=" + b2);
            Log.d("BDTLS", "signature encode=" + new String(bytes));
        }
        Bdtls$ClientHello.b newBuilder6 = Bdtls$ClientHello.newBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            newBuilder6.n((Bdtls$Extension) it.next());
        }
        newBuilder6.C(build);
        newBuilder6.m(ByteString.copyFrom(d.b.g0.g.d.b.f48028a));
        byte[] byteArray = newBuilder6.build().toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 1);
        allocate.put((byte) 1);
        allocate.put(byteArray);
        return allocate.array();
    }
}
