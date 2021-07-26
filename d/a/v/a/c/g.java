package d.a.v.a.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
/* loaded from: classes8.dex */
public class g extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Socket f68414c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f68415d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f68416e;

    /* renamed from: f  reason: collision with root package name */
    public String f68417f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68417f = str;
    }

    @Override // d.a.v.a.c.d
    public InputStream b() throws EOFException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new DataInputStream(this.f68415d) : (InputStream) invokeV.objValue;
    }

    @Override // d.a.v.a.c.d
    public void c(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            this.f68372b = eVar;
            if (eVar != null) {
                this.f68415d = eVar.f68376d;
                this.f68416e = eVar.f68377e;
                return;
            }
            this.f68415d = null;
            this.f68416e = null;
        }
    }

    @Override // d.a.v.a.c.d
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k(this.f68372b) : invokeV.booleanValue;
    }

    @Override // d.a.v.a.c.d
    public e e(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) ? g(str, i2) : (e) invokeLI.objValue;
    }

    @Override // d.a.v.a.c.d
    public void f(b bVar) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this.f68414c == null || (outputStream = this.f68416e) == null) {
            return;
        }
        outputStream.write(bVar.f68362a);
        this.f68416e.flush();
    }

    public final e g(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            d.a.v.a.h.e.d("TcpMessageHandler", "---------------ip:" + str + "  port:" + i2 + "-----------------");
            this.f68414c = h(str, i2);
            e eVar = new e();
            Socket socket = this.f68414c;
            if (socket == null) {
                return eVar;
            }
            eVar.f68375c = socket;
            eVar.f68376d = socket.getInputStream();
            eVar.f68377e = this.f68414c.getOutputStream();
            Boolean bool = Boolean.TRUE;
            eVar.f68373a = bool;
            eVar.f68374b = bool;
            return eVar;
        }
        return (e) invokeLI.objValue;
    }

    public final Socket h(String str, int i2) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
            if (this.f68417f.equals("tcp")) {
                return j(str, i2);
            }
            return i(str, i2);
        }
        return (Socket) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        r9 = r6.getHostAddress();
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Socket i(String str, int i2) throws UnknownHostException, IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, KeyManagementException, TimeoutException, SSLHandshakeException, AssertionError {
        InterceptResult invokeLI;
        SSLCertificateSocketFactory sSLCertificateSocketFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f68371a);
            if (str.contains("baidu.com")) {
                d.a.v.a.h.e.a("TcpMessageHandler", "localdns begin...,domain:" + str);
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    if (allByName != null && allByName.length > 0) {
                        int length = allByName.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            InetAddress inetAddress = allByName[i3];
                            if (inetAddress instanceof Inet4Address) {
                                break;
                            }
                            i3++;
                        }
                    }
                } catch (Exception e2) {
                    d.a.v.a.h.e.c("TcpMessageHandler", "createSocketOnLine", e2);
                }
            }
            if (str.contains("baidu.com")) {
                sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, sSLSessionCache);
            } else {
                sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, sSLSessionCache);
            }
            if (sSLCertificateSocketFactory != null) {
                SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(str, i2);
                sSLSocket.setEnabledCipherSuites(sSLSocket.getEnabledCipherSuites());
                sSLSocket.setEnabledProtocols(sSLSocket.getEnabledProtocols());
                sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
                sSLSocket.startHandshake();
                return sSLSocket;
            }
            return null;
        }
        return (Socket) invokeLI.objValue;
    }

    public final Socket j(String str, int i2) throws UnknownHostException, IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) ? new Socket(str, i2) : (Socket) invokeLI.objValue;
    }

    public boolean k(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eVar)) == null) {
            if (eVar != null && eVar.f68373a.booleanValue()) {
                try {
                    if (eVar.f68375c != null) {
                        eVar.f68375c.close();
                        eVar.f68375c = null;
                    }
                    if (eVar.f68376d != null) {
                        eVar.f68376d.close();
                        eVar.f68376d = null;
                    }
                    if (eVar.f68377e != null) {
                        eVar.f68377e.close();
                        eVar.f68377e = null;
                        return true;
                    }
                    return true;
                } catch (IOException e2) {
                    d.a.v.a.h.e.c("TcpMessageHandler", "destroy:", e2);
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
