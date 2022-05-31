package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$Common;
import com.baidu.lcp.sdk.pb.LcmPb$LcmNotify;
import com.baidu.lcp.sdk.pb.LcmPb$LcmRequest;
import com.baidu.lcp.sdk.pb.LcmPb$RpcData;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes5.dex */
public class c70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c70() {
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

    public final byte[] a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) ? i == 1 ? g(bArr) : bArr : (byte[]) invokeLI.objValue;
    }

    public u60 b(u60 u60Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u60Var, z)) == null) {
            u60Var.o = z;
            h(u60Var, f(u60Var.h, u60Var.i, u60Var.n, d(false)), a(u60Var.a, d(false)));
            return u60Var;
        }
        return (u60) invokeLZ.objValue;
    }

    public u60 c(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, context, j)) == null) {
            long random = (long) ((Math.random() * 1000000.0d) + 10000.0d);
            u60 u60Var = new u60();
            u60Var.n = random;
            u60Var.o = true;
            u60Var.h = 1L;
            u60Var.i = j;
            u60Var.l = j == 1;
            u60Var.k = j == 3;
            h(u60Var, f(1L, j, random, d(false)), a(e(context, random, j), d(false)));
            return u60Var;
        }
        return (u60) invokeLJ.objValue;
    }

    public final int d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? z ? 1 : 0 : invokeZ.intValue;
    }

    public final byte[] e(Context context, long j, long j2) {
        InterceptResult invokeCommon;
        LcmPb$LcmRequest build;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)})) == null) {
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
                    LcmPb$Common lcmPb$Common = (LcmPb$Common) l70.c(context, false);
                    LcmPb$LcmRequest.b newBuilder3 = LcmPb$LcmRequest.newBuilder();
                    newBuilder3.z(j);
                    newBuilder3.x(lcmPb$Common);
                    newBuilder3.C(p70.j(context));
                    newBuilder3.B(System.currentTimeMillis());
                    newBuilder3.A(m60.c(context));
                    newBuilder3.y(p70.d(context));
                    build = newBuilder3.build();
                    o70.a("PbProcessor", "cuid :" + lcmPb$Common.getCuid() + ", device :" + lcmPb$Common.getDeviceType() + ", os:" + lcmPb$Common.getOsVersion() + ", man :" + lcmPb$Common.getManufacture() + ", model :" + lcmPb$Common.getModelType() + ", appId :" + lcmPb$Common.getAppId() + ", app :" + lcmPb$Common.getAppVersion() + ", sdk :" + lcmPb$Common.getSdkVersion() + ", token :" + build.getToken() + ", net :" + lcmPb$Common.getNetwork() + ", rom :" + lcmPb$Common.getRomVersion() + ", start :" + build.getStartType() + "，connType :" + build.getConnType());
                } catch (Exception unused) {
                    LcmPb$LcmRequest.b newBuilder4 = LcmPb$LcmRequest.newBuilder();
                    newBuilder4.z(j);
                    newBuilder4.C(p70.j(context));
                    newBuilder4.B(System.currentTimeMillis());
                    newBuilder4.A(m60.c(context));
                    newBuilder4.y(p70.d(context));
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
            o70.f("PbProcessor", "logId :" + j + ", requestTime :" + build.getTimestamp() + "，methodId :" + j2);
            LcmPb$RpcData.b newBuilder7 = LcmPb$RpcData.newBuilder();
            newBuilder7.E(build);
            return newBuilder7.build().toByteArray();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public final byte[] f(long j, long j2, long j3, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)})) == null) {
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
        return (byte[]) invokeCommon.objValue;
    }

    public final byte[] g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public final u60 h(u60 u60Var, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, u60Var, bArr, bArr2)) == null) {
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
                u60Var.a = allocate.array();
            } catch (Exception unused) {
            }
            return u60Var;
        }
        return (u60) invokeLLL.objValue;
    }
}
