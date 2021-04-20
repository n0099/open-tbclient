package d.b.r.a.d;

import android.content.Context;
import com.baidu.lcp.sdk.pb.LcmPb$Common;
import com.baidu.lcp.sdk.pb.LcmPb$LcmNotify;
import com.baidu.lcp.sdk.pb.LcmPb$LcmRequest;
import com.baidu.lcp.sdk.pb.LcmPb$RpcData;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes2.dex */
public class c {
    public final byte[] a(byte[] bArr, int i) {
        return i == 1 ? g(bArr) : bArr;
    }

    public d.b.r.a.c.b b(d.b.r.a.c.b bVar, boolean z) {
        bVar.o = z;
        h(bVar, f(bVar.f65300h, bVar.i, bVar.n, d(false)), a(bVar.f65293a, d(false)));
        return bVar;
    }

    public d.b.r.a.c.b c(Context context, long j) {
        long random = (long) ((Math.random() * 1000000.0d) + 10000.0d);
        d.b.r.a.c.b bVar = new d.b.r.a.c.b();
        bVar.n = random;
        bVar.o = true;
        bVar.f65300h = 1L;
        bVar.i = j;
        bVar.l = j == 1;
        bVar.k = j == 3;
        h(bVar, f(1L, j, random, d(false)), a(e(context, random, j), d(false)));
        return bVar;
    }

    public final int d(boolean z) {
        return z ? 1 : 0;
    }

    public final byte[] e(Context context, long j, long j2) {
        LcmPb$LcmRequest build;
        if (j2 == 4) {
            LcmPb$LcmNotify.b newBuilder = LcmPb$LcmNotify.newBuilder();
            newBuilder.w(j);
            newBuilder.v(2);
            LcmPb$LcmNotify build2 = newBuilder.build();
            LcmPb$RpcData.b newBuilder2 = LcmPb$RpcData.newBuilder();
            newBuilder2.D(build2);
            return newBuilder2.build().toByteArray();
        }
        if (j2 == 1) {
            try {
                LcmPb$Common lcmPb$Common = (LcmPb$Common) d.b.r.a.g.a.c(context, false);
                LcmPb$LcmRequest.b newBuilder3 = LcmPb$LcmRequest.newBuilder();
                newBuilder3.z(j);
                newBuilder3.x(lcmPb$Common);
                newBuilder3.C(d.b.r.a.g.e.j(context));
                newBuilder3.B(System.currentTimeMillis());
                newBuilder3.A(d.b.r.a.a.d.f(context));
                newBuilder3.y(d.b.r.a.g.e.d(context));
                build = newBuilder3.build();
                d.b.r.a.g.d.a("PbProcessor", "cuid :" + lcmPb$Common.getCuid() + ", device :" + lcmPb$Common.getDeviceType() + ", os:" + lcmPb$Common.getOsVersion() + ", man :" + lcmPb$Common.getManufacture() + ", model :" + lcmPb$Common.getModelType() + ", appId :" + lcmPb$Common.getAppId() + ", app :" + lcmPb$Common.getAppVersion() + ", sdk :" + lcmPb$Common.getSdkVersion() + ", token :" + build.getToken() + ", net :" + lcmPb$Common.getNetwork() + ", rom :" + lcmPb$Common.getRomVersion() + ", start :" + build.getStartType() + "，connType :" + build.getConnType());
            } catch (Exception unused) {
                LcmPb$LcmRequest.b newBuilder4 = LcmPb$LcmRequest.newBuilder();
                newBuilder4.z(j);
                newBuilder4.C(d.b.r.a.g.e.j(context));
                newBuilder4.B(System.currentTimeMillis());
                newBuilder4.A(d.b.r.a.a.d.f(context));
                newBuilder4.y(d.b.r.a.g.e.d(context));
                build = newBuilder4.build();
            }
        } else if (j2 == 2) {
            LcmPb$LcmRequest.b newBuilder5 = LcmPb$LcmRequest.newBuilder();
            newBuilder5.z(j);
            newBuilder5.B(System.currentTimeMillis());
            build = newBuilder5.build();
        } else {
            LcmPb$LcmRequest.b newBuilder6 = LcmPb$LcmRequest.newBuilder();
            newBuilder6.z(j);
            newBuilder6.B(System.currentTimeMillis());
            build = newBuilder6.build();
        }
        d.b.r.a.g.d.f("PbProcessor", "logId :" + j + ", requestTime :" + build.getTimestamp() + "，methodId :" + j2);
        LcmPb$RpcData.b newBuilder7 = LcmPb$RpcData.newBuilder();
        newBuilder7.E(build);
        return newBuilder7.build().toByteArray();
    }

    public final byte[] f(long j, long j2, long j3, int i) {
        RpcMetaPb$RpcRequestMeta.b newBuilder = RpcMetaPb$RpcRequestMeta.newBuilder();
        newBuilder.u(j3);
        newBuilder.x(j);
        newBuilder.v(j2);
        newBuilder.w(1);
        RpcMetaPb$RpcRequestMeta build = newBuilder.build();
        RpcMetaPb$RpcMeta.b newBuilder2 = RpcMetaPb$RpcMeta.newBuilder();
        newBuilder2.F(build);
        newBuilder2.E(j3);
        newBuilder2.D(i);
        newBuilder2.A(1);
        return newBuilder2.build().toByteArray();
    }

    public final byte[] g(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final d.b.r.a.c.b h(d.b.r.a.c.b bVar, byte[] bArr, byte[] bArr2) {
        try {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 12 + bArr2.length);
            allocate.put((byte) 108);
            allocate.put((byte) 99);
            allocate.put((byte) 112);
            allocate.put((byte) 1);
            allocate.putInt(bArr.length + bArr2.length);
            allocate.putInt(bArr.length);
            allocate.put(bArr);
            allocate.put(bArr2);
            bVar.f65293a = allocate.array();
        } catch (Exception unused) {
        }
        return bVar;
    }
}
