package com.repackage;

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
/* loaded from: classes5.dex */
public class d70 extends a70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Socket c;
    public InputStream d;
    public OutputStream e;
    public String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d70(Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = str;
    }

    @Override // com.repackage.a70
    public InputStream b() throws EOFException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new DataInputStream(this.d) : (InputStream) invokeV.objValue;
    }

    @Override // com.repackage.a70
    public void c(b70 b70Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b70Var) == null) {
            this.b = b70Var;
            if (b70Var != null) {
                this.d = b70Var.d;
                this.e = b70Var.e;
                return;
            }
            this.d = null;
            this.e = null;
        }
    }

    @Override // com.repackage.a70
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k(this.b) : invokeV.booleanValue;
    }

    @Override // com.repackage.a70
    public b70 e(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) ? g(str, i) : (b70) invokeLI.objValue;
    }

    @Override // com.repackage.a70
    public void f(z60 z60Var) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, z60Var) == null) || this.c == null || (outputStream = this.e) == null) {
            return;
        }
        outputStream.write(z60Var.a);
        this.e.flush();
    }

    public final b70 g(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            t70.d("TcpMessageHandler", "---------------ip:" + str + "  port:" + i + "-----------------");
            this.c = h(str, i);
            b70 b70Var = new b70();
            Socket socket = this.c;
            if (socket == null) {
                return b70Var;
            }
            b70Var.c = socket;
            b70Var.d = socket.getInputStream();
            b70Var.e = this.c.getOutputStream();
            Boolean bool = Boolean.TRUE;
            b70Var.a = bool;
            b70Var.b = bool;
            return b70Var;
        }
        return (b70) invokeLI.objValue;
    }

    public final Socket h(String str, int i) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i)) == null) {
            if (this.f.equals("tcp")) {
                return j(str, i);
            }
            return i(str, i);
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
    public final Socket i(String str, int i) throws UnknownHostException, IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, KeyManagementException, TimeoutException, SSLHandshakeException, AssertionError {
        InterceptResult invokeLI;
        SSLCertificateSocketFactory sSLCertificateSocketFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i)) == null) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.a);
            if (str.contains("baidu.com")) {
                t70.a("TcpMessageHandler", "localdns begin...,domain:" + str);
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    if (allByName != null && allByName.length > 0) {
                        int length = allByName.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            InetAddress inetAddress = allByName[i2];
                            if (inetAddress instanceof Inet4Address) {
                                break;
                            }
                            i2++;
                        }
                    }
                } catch (Exception e) {
                    t70.c("TcpMessageHandler", "createSocketOnLine", e);
                }
            }
            if (str.contains("baidu.com")) {
                sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, sSLSessionCache);
            } else {
                sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, sSLSessionCache);
            }
            if (sSLCertificateSocketFactory != null) {
                SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(str, i);
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

    public final Socket j(String str, int i) throws UnknownHostException, IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i)) == null) ? new Socket(str, i) : (Socket) invokeLI.objValue;
    }

    public boolean k(b70 b70Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, b70Var)) == null) {
            if (b70Var != null && b70Var.a.booleanValue()) {
                try {
                    if (b70Var.c != null) {
                        b70Var.c.close();
                        b70Var.c = null;
                    }
                    if (b70Var.d != null) {
                        b70Var.d.close();
                        b70Var.d = null;
                    }
                    if (b70Var.e != null) {
                        b70Var.e.close();
                        b70Var.e = null;
                        return true;
                    }
                    return true;
                } catch (IOException e) {
                    t70.c("TcpMessageHandler", "destroy:", e);
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
