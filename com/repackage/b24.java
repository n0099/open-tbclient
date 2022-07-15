package com.repackage;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/* loaded from: classes5.dex */
public final class b24 extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h24 a;
    public volatile boolean b;

    @SuppressLint({"MobilebdThread"})
    public b24() {
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

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.b = z;
        }
    }

    public final void c(h24 h24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h24Var) == null) {
            this.a = h24Var;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        DatagramSocket D;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            while (this.b) {
                try {
                    DatagramPacket datagramPacket = new DatagramPacket(new byte[4096], 4096);
                    h24 h24Var = this.a;
                    if (h24Var != null && (D = h24Var.D()) != null) {
                        D.receive(datagramPacket);
                    }
                    h24 h24Var2 = this.a;
                    if (h24Var2 != null) {
                        h24Var2.A(datagramPacket);
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Throwable unused2) {
                    h24 h24Var3 = this.a;
                    if (h24Var3 != null) {
                        h24Var3.E(StatConstants.VALUE_TYPE_RECEIVE, "receive failed");
                    }
                }
            }
        }
    }
}
