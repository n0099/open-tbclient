package d.a.o0.h.k0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DatagramPacket f50551a;

    /* renamed from: b  reason: collision with root package name */
    public g f50552b;

    public b(DatagramPacket datagramPacket, g udpsocket) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {datagramPacket, udpsocket};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(udpsocket, "udpsocket");
        this.f50551a = datagramPacket;
        this.f50552b = udpsocket;
    }

    public final void a() {
        DatagramSocket D;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                g gVar = this.f50552b;
                if (gVar == null || (D = gVar.D()) == null) {
                    return;
                }
                D.send(this.f50551a);
            } catch (Throwable unused) {
                g gVar2 = this.f50552b;
                if (gVar2 != null) {
                    gVar2.E("send", "send failed");
                }
            }
        }
    }
}
