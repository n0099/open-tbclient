package d.b.s.a.d;

import com.baidu.lcp.sdk.pb.LcmPb$LcmResponse;
import com.baidu.lcp.sdk.pb.LcmPb$RpcData;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
/* loaded from: classes2.dex */
public class d {
    public final d.b.s.a.c.b a(d.b.s.a.c.b bVar, byte[] bArr) throws Exception {
        LcmPb$RpcData parseFrom = LcmPb$RpcData.parseFrom(bArr);
        if (parseFrom.hasLcmResponse()) {
            LcmPb$LcmResponse lcmResponse = parseFrom.getLcmResponse();
            d.b.s.a.g.d.a("PbProcessor", "methodId ：" + bVar.i + ", logId :" + lcmResponse.getLogId() + ", errMsg :" + lcmResponse.getErrorMsg() + ", errCode :" + lcmResponse.getErrorCode() + ", pingMS :" + lcmResponse.getNextIntervalMs());
            if (lcmResponse.getErrorCode() == 0) {
                long j = bVar.i;
                if (j == 1) {
                    bVar.j = 0;
                    bVar.f65563g = lcmResponse.getNextIntervalMs();
                } else if (j == 2) {
                    bVar.j = -1;
                } else if (j == 3) {
                    bVar.f65563g = lcmResponse.getNextIntervalMs();
                } else if (j == 4) {
                    d.b.s.a.g.d.a("PbProcessor", "parseLcmResponse notify");
                }
            } else {
                bVar.f65559c = lcmResponse.getErrorCode();
                bVar.f65560d = lcmResponse.getErrorMsg();
                bVar.j = -1;
            }
        } else if (parseFrom.hasLcmNotify()) {
            d.b.s.a.g.d.a("PbProcessor", "lcmpb hasLcmNotify");
        } else if (parseFrom.hasLcmRequest()) {
            bVar.n = parseFrom.getLcmRequest().getLogId();
        }
        return bVar;
    }

    public d.b.s.a.c.b b(InputStream inputStream) throws Exception {
        d.b.s.a.c.b bVar = new d.b.s.a.c.b();
        if (inputStream instanceof ByteArrayInputStream) {
            d.b.s.a.g.d.a("PbProcessor", "parseResponse quic");
        } else if (inputStream instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) inputStream;
            byte readByte = dataInputStream.readByte();
            byte readByte2 = dataInputStream.readByte();
            byte readByte3 = dataInputStream.readByte();
            byte readByte4 = dataInputStream.readByte();
            int readInt = dataInputStream.readInt();
            int readInt2 = dataInputStream.readInt();
            if (readInt <= 1048576 && readInt2 <= 1048576) {
                byte[] bArr = new byte[readInt2];
                dataInputStream.readFully(bArr);
                int i = readInt - readInt2;
                byte[] bArr2 = new byte[i];
                dataInputStream.readFully(bArr2);
                d.b.s.a.g.d.e("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2 + ", payload :" + i);
                c(bVar, bArr, bArr2);
                return bVar;
            }
            d.b.s.a.g.d.b("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2);
            throw new Exception(" Failed to allocate a larger byte allocation, data length = " + readInt);
        }
        return bVar;
    }

    public final d.b.s.a.c.b c(d.b.s.a.c.b bVar, byte[] bArr, byte[] bArr2) throws Exception {
        RpcMetaPb$RpcMeta parseFrom = RpcMetaPb$RpcMeta.parseFrom(bArr);
        if (parseFrom.getCompressType() == 1) {
            bArr2 = d(bArr2);
            d.b.s.a.g.d.a("PbProcessor", "payload is gzip compressed，length : " + bArr2.length);
        }
        bVar.f65562f = bArr2;
        if (parseFrom.hasNotify()) {
            RpcMetaPb$RpcNotifyMeta notify = parseFrom.getNotify();
            bVar.f65559c = 0;
            bVar.f65560d = "notify";
            bVar.f65564h = notify.getServiceId();
            bVar.i = notify.getMethodId();
            bVar.n = notify.getLogId();
            bVar.f65561e = true;
        } else if (parseFrom.hasResponse()) {
            RpcMetaPb$RpcResponseMeta response = parseFrom.getResponse();
            bVar.f65559c = response.getErrorCode();
            bVar.f65560d = response.getErrorText();
            bVar.f65564h = response.getServiceId();
            bVar.i = response.getMethodId();
            bVar.n = response.getLogId();
            bVar.f65561e = false;
            if (bVar.f65559c == 0 && bVar.f65564h == 1) {
                a(bVar, bArr2);
                return bVar;
            }
        } else if (parseFrom.hasRequest()) {
            RpcMetaPb$RpcRequestMeta request = parseFrom.getRequest();
            bVar.f65564h = request.getServiceId();
            bVar.i = request.getMethodId();
            d.b.s.a.g.d.a("PbProcessor", "parseRpcMeta requestMeta");
            a(bVar, bArr2);
        }
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] d(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        IOException e2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Exception e3) {
                        d.b.s.a.g.d.c("SocketTransceiver", "Exception ", e3);
                    }
                    return byteArray;
                } catch (IOException e4) {
                    e2 = e4;
                    d.b.s.a.g.d.c("SocketTransceiver", "unzip exception :", e2);
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception e5) {
                            d.b.s.a.g.d.c("SocketTransceiver", "Exception ", e5);
                            return bArr;
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return bArr;
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (Exception e6) {
                        d.b.s.a.g.d.c("SocketTransceiver", "Exception ", e6);
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            gZIPInputStream = null;
            e2 = e7;
        } catch (Throwable th2) {
            th = th2;
            if (gZIPInputStream2 != null) {
            }
            byteArrayInputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }
}
