package d.a.d.e.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static d.a.d.e.r.b f42015a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        int a();

        String b();

        long c();

        void close() throws IOException;

        String d();

        String getLocalDns();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* loaded from: classes7.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SocketChannel f42016a;

        /* renamed from: b  reason: collision with root package name */
        public long f42017b;

        /* renamed from: c  reason: collision with root package name */
        public String f42018c;

        /* renamed from: d  reason: collision with root package name */
        public String f42019d;

        /* renamed from: e  reason: collision with root package name */
        public String f42020e;

        public b(String str, int i2, d0 d0Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), d0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42016a = null;
            this.f42017b = 0L;
            this.f42018c = null;
            this.f42019d = null;
            this.f42020e = null;
            this.f42016a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f42018c = inetSocketAddress.getAddress().getHostAddress();
                this.f42017b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42016a.socket().connect(inetSocketAddress, d0Var.e());
            this.f42016a.socket().setSoTimeout(d0Var.f());
            this.f42016a.socket().setTcpNoDelay(d0Var.g());
            this.f42019d = d.a.d.e.p.l.m();
            this.f42020e = d.a.d.e.p.l.n();
        }

        @Override // d.a.d.e.r.e.a
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.r.e.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42020e : (String) invokeV.objValue;
        }

        @Override // d.a.d.e.r.e.a
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f42017b : invokeV.longValue;
        }

        @Override // d.a.d.e.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (socketChannel = this.f42016a) == null) {
                return;
            }
            socketChannel.close();
        }

        @Override // d.a.d.e.r.e.a
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f42018c : (String) invokeV.objValue;
        }

        @Override // d.a.d.e.r.e.a
        public String getLocalDns() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42019d : (String) invokeV.objValue;
        }

        @Override // d.a.d.e.r.e.a
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                SocketChannel socketChannel = this.f42016a;
                if (socketChannel != null) {
                    return socketChannel.isConnected();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.d.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) ? this.f42016a.read(byteBuffer) : invokeL.intValue;
        }

        @Override // d.a.d.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) ? this.f42016a.write(byteBuffer) : invokeL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Socket f42021a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f42022b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f42023c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f42024d;

        /* renamed from: e  reason: collision with root package name */
        public long f42025e;

        /* renamed from: f  reason: collision with root package name */
        public String f42026f;

        /* renamed from: g  reason: collision with root package name */
        public String f42027g;

        /* renamed from: h  reason: collision with root package name */
        public String f42028h;

        public c(String str, int i2, d0 d0Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), d0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42021a = null;
            this.f42022b = null;
            this.f42023c = null;
            this.f42024d = null;
            this.f42025e = 0L;
            this.f42026f = null;
            this.f42027g = null;
            this.f42028h = null;
            this.f42021a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f42026f = inetSocketAddress.getAddress().getHostAddress();
                this.f42025e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42021a.connect(inetSocketAddress, d0Var.e());
            this.f42021a.setSoTimeout(d0Var.f());
            this.f42021a.setTcpNoDelay(d0Var.g());
            this.f42022b = this.f42021a.getInputStream();
            this.f42023c = this.f42021a.getOutputStream();
            this.f42024d = new byte[1024];
            this.f42027g = d.a.d.e.p.l.m();
            this.f42028h = d.a.d.e.p.l.n();
        }

        @Override // d.a.d.e.r.e.a
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.r.e.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42028h : (String) invokeV.objValue;
        }

        @Override // d.a.d.e.r.e.a
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f42025e : invokeV.longValue;
        }

        @Override // d.a.d.e.r.e.a
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                try {
                    this.f42022b.close();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                try {
                    this.f42023c.close();
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
                Socket socket = this.f42021a;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e4) {
                        throw e4;
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        @Override // d.a.d.e.r.e.a
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f42026f : (String) invokeV.objValue;
        }

        @Override // d.a.d.e.r.e.a
        public String getLocalDns() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42027g : (String) invokeV.objValue;
        }

        @Override // d.a.d.e.r.e.a
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Socket socket = this.f42021a;
                if (socket != null) {
                    return socket.isConnected();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.d.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
                int read = this.f42022b.read(this.f42024d);
                if (read > 0) {
                    byteBuffer.put(this.f42024d, 0, read);
                }
                return read;
            }
            return invokeL.intValue;
        }

        @Override // d.a.d.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
                int remaining = byteBuffer.remaining();
                if (remaining > 0) {
                    byte[] bArr = new byte[remaining];
                    byteBuffer.get(bArr);
                    this.f42023c.write(bArr);
                }
                return remaining;
            }
            return invokeL.intValue;
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public a a(String str, int i2, d0 d0Var, boolean z) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), d0Var, Boolean.valueOf(z)})) == null) {
            d.a.d.e.r.b bVar = f42015a;
            if (bVar != null) {
                return bVar.a(str, i2, d0Var);
            }
            if (z) {
                return new b(str, i2, d0Var);
            }
            return new c(str, i2, d0Var);
        }
        return (a) invokeCommon.objValue;
    }
}
