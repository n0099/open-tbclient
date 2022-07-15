package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class c24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DatagramPacket a;
    public h24 b;

    public c24(DatagramPacket datagramPacket, h24 udpsocket) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {datagramPacket, udpsocket};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(udpsocket, "udpsocket");
        this.a = datagramPacket;
        this.b = udpsocket;
    }

    public final void a() {
        DatagramSocket D;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                h24 h24Var = this.b;
                if (h24Var == null || (D = h24Var.D()) == null) {
                    return;
                }
                D.send(this.a);
            } catch (Throwable unused) {
                h24 h24Var2 = this.b;
                if (h24Var2 != null) {
                    h24Var2.E("send", "send failed");
                }
            }
        }
    }
}
