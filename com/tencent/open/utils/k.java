package com.tencent.open.utils;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.params.HttpParams;
@TargetApi(17)
/* loaded from: classes4.dex */
public class k implements LayeredSocketFactory {
    public static /* synthetic */ Interceptable $ic;
    public static final HostnameVerifier a;

    /* renamed from: b  reason: collision with root package name */
    public static final SSLCertificateSocketFactory f60818b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2036590769, "Lcom/tencent/open/utils/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2036590769, "Lcom/tencent/open/utils/k;");
                return;
            }
        }
        a = new StrictHostnameVerifier();
        f60818b = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0, null);
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i2, InetAddress inetAddress, int i3, HttpParams httpParams) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{socket, str, Integer.valueOf(i2), inetAddress, Integer.valueOf(i3), httpParams})) == null) {
            socket.connect(new InetSocketAddress(str, i2));
            return socket;
        }
        return (Socket) invokeCommon.objValue;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new Socket() : (Socket) invokeV.objValue;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, socket)) == null) {
            if (socket instanceof SSLSocket) {
                return ((SSLSocket) socket).isConnected();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{socket, str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SLog.v("openSDK_LOG.SNISocketFactory", "createSocket " + socket.toString() + " host:" + str + " port:" + i2 + " autoClose:" + z);
            InetAddress inetAddress = socket.getInetAddress();
            if (z) {
                socket.close();
            }
            SSLSocket sSLSocket = (SSLSocket) f60818b.createSocket(inetAddress, i2);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            if (Build.VERSION.SDK_INT >= 17) {
                SLog.v("openSDK_LOG.SNISocketFactory", "Setting SNI hostname");
                f60818b.setHostname(sSLSocket, str);
            } else {
                SLog.v("openSDK_LOG.SNISocketFactory", "No documented SNI support on Android <4.2, trying with reflection");
                try {
                    sSLSocket.getClass().getMethod("setHostname", String.class).invoke(sSLSocket, str);
                } catch (Exception unused) {
                    SLog.v("openSDK_LOG.SNISocketFactory", "SNI not useable");
                }
            }
            if (a.verify(str, sSLSocket.getSession())) {
                return sSLSocket;
            }
            throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
        }
        return (Socket) invokeCommon.objValue;
    }
}
