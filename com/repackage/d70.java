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
/* loaded from: classes5.dex */
public class d70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d70() {
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

    public final u60 a(u60 u60Var, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, u60Var, bArr)) == null) {
            LcmPb$RpcData parseFrom = LcmPb$RpcData.parseFrom(bArr);
            if (parseFrom.hasLcmResponse()) {
                LcmPb$LcmResponse lcmResponse = parseFrom.getLcmResponse();
                o70.a("PbProcessor", "methodId ：" + u60Var.i + ", logId :" + lcmResponse.getLogId() + ", errMsg :" + lcmResponse.getErrorMsg() + ", errCode :" + lcmResponse.getErrorCode() + ", pingMS :" + lcmResponse.getNextIntervalMs());
                if (lcmResponse.getErrorCode() == 0) {
                    long j = u60Var.i;
                    if (j == 1) {
                        u60Var.j = 0;
                        u60Var.g = lcmResponse.getNextIntervalMs();
                    } else if (j == 2) {
                        u60Var.j = -1;
                    } else if (j == 3) {
                        u60Var.g = lcmResponse.getNextIntervalMs();
                    } else if (j == 4) {
                        o70.a("PbProcessor", "parseLcmResponse notify");
                    }
                } else {
                    u60Var.c = lcmResponse.getErrorCode();
                    u60Var.d = lcmResponse.getErrorMsg();
                    u60Var.j = -1;
                }
            } else if (parseFrom.hasLcmNotify()) {
                o70.a("PbProcessor", "lcmpb hasLcmNotify");
            } else if (parseFrom.hasLcmRequest()) {
                u60Var.n = parseFrom.getLcmRequest().getLogId();
            }
            return u60Var;
        }
        return (u60) invokeLL.objValue;
    }

    public u60 b(InputStream inputStream) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) {
            u60 u60Var = new u60();
            if (inputStream instanceof ByteArrayInputStream) {
                o70.a("PbProcessor", "parseResponse quic");
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
                    o70.e("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2 + ", payload :" + i);
                    c(u60Var, bArr, bArr2);
                    return u60Var;
                }
                o70.b("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2);
                throw new Exception(" Failed to allocate a larger byte allocation, data length = " + readInt);
            }
            return u60Var;
        }
        return (u60) invokeL.objValue;
    }

    public final u60 c(u60 u60Var, byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, u60Var, bArr, bArr2)) == null) {
            RpcMetaPb$RpcMeta parseFrom = RpcMetaPb$RpcMeta.parseFrom(bArr);
            if (parseFrom.getCompressType() == 1) {
                bArr2 = d(bArr2);
                o70.a("PbProcessor", "payload is gzip compressed，length : " + bArr2.length);
            }
            u60Var.f = bArr2;
            if (parseFrom.hasNotify()) {
                RpcMetaPb$RpcNotifyMeta notify = parseFrom.getNotify();
                u60Var.c = 0;
                u60Var.d = "notify";
                u60Var.h = notify.getServiceId();
                u60Var.i = notify.getMethodId();
                u60Var.n = notify.getLogId();
                u60Var.e = true;
            } else if (parseFrom.hasResponse()) {
                RpcMetaPb$RpcResponseMeta response = parseFrom.getResponse();
                u60Var.c = response.getErrorCode();
                u60Var.d = response.getErrorText();
                u60Var.h = response.getServiceId();
                u60Var.i = response.getMethodId();
                u60Var.n = response.getLogId();
                u60Var.e = false;
                if (u60Var.c == 0 && u60Var.h == 1) {
                    a(u60Var, bArr2);
                    return u60Var;
                }
            } else if (parseFrom.hasRequest()) {
                RpcMetaPb$RpcRequestMeta request = parseFrom.getRequest();
                u60Var.h = request.getServiceId();
                u60Var.i = request.getMethodId();
                o70.a("PbProcessor", "parseRpcMeta requestMeta");
                a(u60Var, bArr2);
            }
            return u60Var;
        }
        return (u60) invokeLLL.objValue;
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
                        o70.c("SocketTransceiver", "Exception ", e2);
                    }
                    return byteArray;
                } catch (IOException e3) {
                    e = e3;
                    o70.c("SocketTransceiver", "unzip exception :", e);
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception e4) {
                            o70.c("SocketTransceiver", "Exception ", e4);
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
                        o70.c("SocketTransceiver", "Exception ", e5);
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
