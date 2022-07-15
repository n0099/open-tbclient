package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$LcmResponse;
import com.baidu.lcp.sdk.pb.LcmPb$RpcData;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
/* loaded from: classes6.dex */
public class i70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i70() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final z60 a(z60 z60Var, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, z60Var, bArr)) == null) {
            LcmPb$RpcData parseFrom = LcmPb$RpcData.parseFrom(bArr);
            if (parseFrom.hasLcmResponse()) {
                LcmPb$LcmResponse lcmResponse = parseFrom.getLcmResponse();
                t70.a("PbProcessor", "methodId ：" + z60Var.i + ", logId :" + lcmResponse.getLogId() + ", errMsg :" + lcmResponse.getErrorMsg() + ", errCode :" + lcmResponse.getErrorCode() + ", pingMS :" + lcmResponse.getNextIntervalMs());
                if (lcmResponse.getErrorCode() == 0) {
                    long j = z60Var.i;
                    if (j == 1) {
                        z60Var.j = 0;
                        z60Var.g = lcmResponse.getNextIntervalMs();
                    } else if (j == 2) {
                        z60Var.j = -1;
                    } else if (j == 3) {
                        z60Var.g = lcmResponse.getNextIntervalMs();
                    } else if (j == 4) {
                        t70.a("PbProcessor", "parseLcmResponse notify");
                    }
                } else {
                    z60Var.c = lcmResponse.getErrorCode();
                    z60Var.d = lcmResponse.getErrorMsg();
                    z60Var.j = -1;
                }
            } else if (parseFrom.hasLcmNotify()) {
                t70.a("PbProcessor", "lcmpb hasLcmNotify");
            } else if (parseFrom.hasLcmRequest()) {
                z60Var.n = parseFrom.getLcmRequest().getLogId();
            }
            return z60Var;
        }
        return (z60) invokeLL.objValue;
    }

    public z60 b(InputStream inputStream) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) {
            z60 z60Var = new z60();
            if (inputStream instanceof ByteArrayInputStream) {
                t70.a("PbProcessor", "parseResponse quic");
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
                    t70.e("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2 + ", payload :" + i);
                    c(z60Var, bArr, bArr2);
                    return z60Var;
                }
                t70.b("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2);
                throw new Exception(" Failed to allocate a larger byte allocation, data length = " + readInt);
            }
            return z60Var;
        }
        return (z60) invokeL.objValue;
    }

    public final z60 c(z60 z60Var, byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, z60Var, bArr, bArr2)) == null) {
            RpcMetaPb$RpcMeta parseFrom = RpcMetaPb$RpcMeta.parseFrom(bArr);
            if (parseFrom.getCompressType() == 1) {
                bArr2 = d(bArr2);
                t70.a("PbProcessor", "payload is gzip compressed，length : " + bArr2.length);
            }
            z60Var.f = bArr2;
            if (parseFrom.hasNotify()) {
                RpcMetaPb$RpcNotifyMeta notify = parseFrom.getNotify();
                z60Var.c = 0;
                z60Var.d = "notify";
                z60Var.h = notify.getServiceId();
                z60Var.i = notify.getMethodId();
                z60Var.n = notify.getLogId();
                z60Var.e = true;
            } else if (parseFrom.hasResponse()) {
                RpcMetaPb$RpcResponseMeta response = parseFrom.getResponse();
                z60Var.c = response.getErrorCode();
                z60Var.d = response.getErrorText();
                z60Var.h = response.getServiceId();
                z60Var.i = response.getMethodId();
                z60Var.n = response.getLogId();
                z60Var.e = false;
                if (z60Var.c == 0 && z60Var.h == 1) {
                    a(z60Var, bArr2);
                    return z60Var;
                }
            } else if (parseFrom.hasRequest()) {
                RpcMetaPb$RpcRequestMeta request = parseFrom.getRequest();
                z60Var.h = request.getServiceId();
                z60Var.i = request.getMethodId();
                t70.a("PbProcessor", "parseRpcMeta requestMeta");
                a(z60Var, bArr2);
            }
            return z60Var;
        }
        return (z60) invokeLLL.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x003b: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:18:0x003b */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        GZIPInputStream gZIPInputStream;
        IOException e;
        GZIPInputStream gZIPInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream3 = null;
        try {
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
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
                    } catch (Exception e2) {
                        t70.c("SocketTransceiver", "Exception ", e2);
                    }
                    return byteArray;
                } catch (IOException e3) {
                    e = e3;
                    t70.c("SocketTransceiver", "unzip exception :", e);
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception e4) {
                            t70.c("SocketTransceiver", "Exception ", e4);
                            return bArr;
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return bArr;
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream3 = gZIPInputStream2;
                if (gZIPInputStream3 != null) {
                    try {
                        gZIPInputStream3.close();
                    } catch (Exception e5) {
                        t70.c("SocketTransceiver", "Exception ", e5);
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e6) {
            gZIPInputStream = null;
            e = e6;
        } catch (Throwable th2) {
            th = th2;
            if (gZIPInputStream3 != null) {
            }
            byteArrayInputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }
}
