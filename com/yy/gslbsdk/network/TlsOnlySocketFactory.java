package com.yy.gslbsdk.network;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.util.LogTools;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes8.dex */
public class TlsOnlySocketFactory extends SSLSocketFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TlsOnlySocketFactory";
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean compatible;
    public final SSLSocketFactory delegate;

    /* renamed from: com.yy.gslbsdk.network.TlsOnlySocketFactory$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class DelegateSSLSocket extends SSLSocket {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SSLSocket delegate;
        public final /* synthetic */ TlsOnlySocketFactory this$0;

        public DelegateSSLSocket(TlsOnlySocketFactory tlsOnlySocketFactory, SSLSocket sSLSocket) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tlsOnlySocketFactory, sSLSocket};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tlsOnlySocketFactory;
            this.delegate = sSLSocket;
        }

        @Override // javax.net.ssl.SSLSocket
        public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, handshakeCompletedListener) == null) {
                this.delegate.addHandshakeCompletedListener(handshakeCompletedListener);
            }
        }

        @Override // java.net.Socket
        public void bind(SocketAddress socketAddress) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketAddress) == null) {
                this.delegate.bind(socketAddress);
            }
        }

        @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    this.delegate.close();
                }
            }
        }

        @Override // java.net.Socket
        public void connect(SocketAddress socketAddress) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, socketAddress) == null) {
                this.delegate.connect(socketAddress);
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? this.delegate.equals(obj) : invokeL.booleanValue;
        }

        @Override // java.net.Socket
        public SocketChannel getChannel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.delegate.getChannel() : (SocketChannel) invokeV.objValue;
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getEnableSessionCreation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.delegate.getEnableSessionCreation() : invokeV.booleanValue;
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledCipherSuites() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.delegate.getEnabledCipherSuites() : (String[]) invokeV.objValue;
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledProtocols() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.delegate.getEnabledProtocols() : (String[]) invokeV.objValue;
        }

        @Override // java.net.Socket
        public InetAddress getInetAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.delegate.getInetAddress() : (InetAddress) invokeV.objValue;
        }

        @Override // java.net.Socket
        public InputStream getInputStream() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.delegate.getInputStream() : (InputStream) invokeV.objValue;
        }

        @Override // java.net.Socket
        public boolean getKeepAlive() throws SocketException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.delegate.getKeepAlive() : invokeV.booleanValue;
        }

        @Override // java.net.Socket
        public InetAddress getLocalAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.delegate.getLocalAddress() : (InetAddress) invokeV.objValue;
        }

        @Override // java.net.Socket
        public int getLocalPort() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.delegate.getLocalPort() : invokeV.intValue;
        }

        @Override // java.net.Socket
        public SocketAddress getLocalSocketAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.delegate.getLocalSocketAddress() : (SocketAddress) invokeV.objValue;
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getNeedClientAuth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.delegate.getNeedClientAuth() : invokeV.booleanValue;
        }

        @Override // java.net.Socket
        public boolean getOOBInline() throws SocketException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.delegate.getOOBInline() : invokeV.booleanValue;
        }

        @Override // java.net.Socket
        public OutputStream getOutputStream() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.delegate.getOutputStream() : (OutputStream) invokeV.objValue;
        }

        @Override // java.net.Socket
        public int getPort() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.delegate.getPort() : invokeV.intValue;
        }

        @Override // java.net.Socket
        public synchronized int getReceiveBufferSize() throws SocketException {
            InterceptResult invokeV;
            int receiveBufferSize;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                synchronized (this) {
                    receiveBufferSize = this.delegate.getReceiveBufferSize();
                }
                return receiveBufferSize;
            }
            return invokeV.intValue;
        }

        @Override // java.net.Socket
        public SocketAddress getRemoteSocketAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.delegate.getRemoteSocketAddress() : (SocketAddress) invokeV.objValue;
        }

        @Override // java.net.Socket
        public boolean getReuseAddress() throws SocketException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.delegate.getReuseAddress() : invokeV.booleanValue;
        }

        @Override // java.net.Socket
        public synchronized int getSendBufferSize() throws SocketException {
            InterceptResult invokeV;
            int sendBufferSize;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                synchronized (this) {
                    sendBufferSize = this.delegate.getSendBufferSize();
                }
                return sendBufferSize;
            }
            return invokeV.intValue;
        }

        @Override // javax.net.ssl.SSLSocket
        public SSLSession getSession() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.delegate.getSession() : (SSLSession) invokeV.objValue;
        }

        @Override // java.net.Socket
        public int getSoLinger() throws SocketException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.delegate.getSoLinger() : invokeV.intValue;
        }

        @Override // java.net.Socket
        public synchronized int getSoTimeout() throws SocketException {
            InterceptResult invokeV;
            int soTimeout;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                synchronized (this) {
                    soTimeout = this.delegate.getSoTimeout();
                }
                return soTimeout;
            }
            return invokeV.intValue;
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedCipherSuites() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.delegate.getSupportedCipherSuites() : (String[]) invokeV.objValue;
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedProtocols() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.delegate.getSupportedProtocols() : (String[]) invokeV.objValue;
        }

        @Override // java.net.Socket
        public boolean getTcpNoDelay() throws SocketException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.delegate.getTcpNoDelay() : invokeV.booleanValue;
        }

        @Override // java.net.Socket
        public int getTrafficClass() throws SocketException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.delegate.getTrafficClass() : invokeV.intValue;
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getUseClientMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.delegate.getUseClientMode() : invokeV.booleanValue;
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getWantClientAuth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.delegate.getWantClientAuth() : invokeV.booleanValue;
        }

        @Override // java.net.Socket
        public boolean isBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.delegate.isBound() : invokeV.booleanValue;
        }

        @Override // java.net.Socket
        public boolean isClosed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.delegate.isClosed() : invokeV.booleanValue;
        }

        @Override // java.net.Socket
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.delegate.isConnected() : invokeV.booleanValue;
        }

        @Override // java.net.Socket
        public boolean isInputShutdown() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.delegate.isInputShutdown() : invokeV.booleanValue;
        }

        @Override // java.net.Socket
        public boolean isOutputShutdown() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.delegate.isOutputShutdown() : invokeV.booleanValue;
        }

        @Override // javax.net.ssl.SSLSocket
        public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048614, this, handshakeCompletedListener) == null) {
                this.delegate.removeHandshakeCompletedListener(handshakeCompletedListener);
            }
        }

        @Override // java.net.Socket
        public void sendUrgentData(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
                this.delegate.sendUrgentData(i2);
            }
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnableSessionCreation(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
                this.delegate.setEnableSessionCreation(z);
            }
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnabledCipherSuites(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048617, this, strArr) == null) {
                this.delegate.setEnabledCipherSuites(strArr);
            }
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnabledProtocols(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048618, this, strArr) == null) {
                this.delegate.setEnabledProtocols(strArr);
            }
        }

        @Override // java.net.Socket
        public void setKeepAlive(boolean z) throws SocketException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
                this.delegate.setKeepAlive(z);
            }
        }

        @Override // javax.net.ssl.SSLSocket
        public void setNeedClientAuth(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
                this.delegate.setNeedClientAuth(z);
            }
        }

        @Override // java.net.Socket
        public void setOOBInline(boolean z) throws SocketException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
                this.delegate.setOOBInline(z);
            }
        }

        @Override // java.net.Socket
        public void setPerformancePreferences(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048622, this, i2, i3, i4) == null) {
                this.delegate.setPerformancePreferences(i2, i3, i4);
            }
        }

        @Override // java.net.Socket
        public synchronized void setReceiveBufferSize(int i2) throws SocketException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
                synchronized (this) {
                    this.delegate.setReceiveBufferSize(i2);
                }
            }
        }

        @Override // java.net.Socket
        public void setReuseAddress(boolean z) throws SocketException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
                this.delegate.setReuseAddress(z);
            }
        }

        @Override // java.net.Socket
        public synchronized void setSendBufferSize(int i2) throws SocketException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
                synchronized (this) {
                    this.delegate.setSendBufferSize(i2);
                }
            }
        }

        @Override // java.net.Socket
        public void setSoLinger(boolean z, int i2) throws SocketException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.delegate.setSoLinger(z, i2);
            }
        }

        @Override // java.net.Socket
        public synchronized void setSoTimeout(int i2) throws SocketException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
                synchronized (this) {
                    this.delegate.setSoTimeout(i2);
                }
            }
        }

        @Override // java.net.Socket
        public void setTcpNoDelay(boolean z) throws SocketException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
                this.delegate.setTcpNoDelay(z);
            }
        }

        @Override // java.net.Socket
        public void setTrafficClass(int i2) throws SocketException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
                this.delegate.setTrafficClass(i2);
            }
        }

        @Override // javax.net.ssl.SSLSocket
        public void setUseClientMode(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
                this.delegate.setUseClientMode(z);
            }
        }

        @Override // javax.net.ssl.SSLSocket
        public void setWantClientAuth(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
                this.delegate.setWantClientAuth(z);
            }
        }

        @Override // java.net.Socket
        public void shutdownInput() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
                this.delegate.shutdownInput();
            }
        }

        @Override // java.net.Socket
        public void shutdownOutput() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
                this.delegate.shutdownOutput();
            }
        }

        @Override // javax.net.ssl.SSLSocket
        public void startHandshake() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
                this.delegate.startHandshake();
            }
        }

        @Override // javax.net.ssl.SSLSocket, java.net.Socket
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.delegate.toString() : (String) invokeV.objValue;
        }

        @Override // java.net.Socket
        public void connect(SocketAddress socketAddress, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, socketAddress, i2) == null) {
                this.delegate.connect(socketAddress, i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class TlsOnlySSLSocket extends DelegateSSLSocket {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean compatible;
        public final /* synthetic */ TlsOnlySocketFactory this$0;

        public /* synthetic */ TlsOnlySSLSocket(TlsOnlySocketFactory tlsOnlySocketFactory, SSLSocket sSLSocket, boolean z, AnonymousClass1 anonymousClass1) {
            this(tlsOnlySocketFactory, sSLSocket, z);
        }

        @Override // com.yy.gslbsdk.network.TlsOnlySocketFactory.DelegateSSLSocket, javax.net.ssl.SSLSocket
        public void setEnabledProtocols(String[] strArr) {
            List asList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, strArr) == null) {
                if (strArr != null && strArr.length == 1 && "SSLv3".equals(strArr[0])) {
                    if (this.compatible) {
                        asList = Arrays.asList(this.delegate.getEnabledProtocols());
                    } else {
                        asList = Arrays.asList(this.delegate.getSupportedProtocols());
                    }
                    ArrayList arrayList = new ArrayList(asList);
                    if (arrayList.size() > 1) {
                        arrayList.remove("SSLv2");
                        arrayList.remove("SSLv3");
                    } else {
                        LogTools.printWarning(TlsOnlySocketFactory.TAG, String.format(Locale.US, "SSL stuck with protocol available for %s", arrayList.toString()));
                    }
                    strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                }
                super.setEnabledProtocols(strArr);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TlsOnlySSLSocket(TlsOnlySocketFactory tlsOnlySocketFactory, SSLSocket sSLSocket, boolean z) {
            super(tlsOnlySocketFactory, sSLSocket);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tlsOnlySocketFactory, sSLSocket, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TlsOnlySocketFactory) objArr2[0], (SSLSocket) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tlsOnlySocketFactory;
            this.compatible = z;
            int i4 = 0;
            if (z) {
                ArrayList arrayList = new ArrayList(Arrays.asList(sSLSocket.getEnabledProtocols()));
                arrayList.remove("SSLv2");
                arrayList.remove("SSLv3");
                super.setEnabledProtocols((String[]) arrayList.toArray(new String[arrayList.size()]));
                ArrayList arrayList2 = new ArrayList(10);
                Pattern compile = Pattern.compile(".*(EXPORT|NULL|TLS_FALLBACK_SCSV).*");
                String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
                int length = enabledCipherSuites.length;
                while (i4 < length) {
                    String str = enabledCipherSuites[i4];
                    if (!compile.matcher(str).matches()) {
                        arrayList2.add(str);
                    }
                    i4++;
                }
                super.setEnabledCipherSuites((String[]) arrayList2.toArray(new String[arrayList2.size()]));
                return;
            }
            ArrayList arrayList3 = new ArrayList(Arrays.asList(sSLSocket.getSupportedProtocols()));
            arrayList3.remove("SSLv2");
            arrayList3.remove("SSLv3");
            super.setEnabledProtocols((String[]) arrayList3.toArray(new String[arrayList3.size()]));
            ArrayList arrayList4 = new ArrayList(10);
            Pattern compile2 = Pattern.compile(".*(_DES|DH_|DSS|EXPORT|MD5|NULL|RC4|TLS_FALLBACK_SCSV).*");
            String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
            int length2 = supportedCipherSuites.length;
            while (i4 < length2) {
                String str2 = supportedCipherSuites[i4];
                if (!compile2.matcher(str2).matches()) {
                    arrayList4.add(str2);
                }
                i4++;
            }
            super.setEnabledCipherSuites((String[]) arrayList4.toArray(new String[arrayList4.size()]));
        }
    }

    public TlsOnlySocketFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLSv1");
            sSLContext.init(null, null, null);
            this.delegate = sSLContext.getSocketFactory();
            this.compatible = false;
        } catch (KeyManagementException e2) {
            throw new IllegalArgumentException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    private Socket makeSocketSafe(Socket socket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, socket)) == null) ? socket instanceof SSLSocket ? new TlsOnlySSLSocket(this, (SSLSocket) socket, this.compatible, null) : socket : (Socket) invokeL.objValue;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{socket, str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? makeSocketSafe(this.delegate.createSocket(socket, str, i2, z)) : (Socket) invokeCommon.objValue;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.delegate.getDefaultCipherSuites() : (String[]) invokeV.objValue;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.delegate.getSupportedCipherSuites() : (String[]) invokeV.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) ? makeSocketSafe(this.delegate.createSocket(str, i2)) : (Socket) invokeLI.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i2), inetAddress, Integer.valueOf(i3)})) == null) ? makeSocketSafe(this.delegate.createSocket(str, i2, inetAddress, i3)) : (Socket) invokeCommon.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, inetAddress, i2)) == null) ? makeSocketSafe(this.delegate.createSocket(inetAddress, i2)) : (Socket) invokeLI.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{inetAddress, Integer.valueOf(i2), inetAddress2, Integer.valueOf(i3)})) == null) ? makeSocketSafe(this.delegate.createSocket(inetAddress, i2, inetAddress2, i3)) : (Socket) invokeCommon.objValue;
    }

    public TlsOnlySocketFactory(SSLSocketFactory sSLSocketFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sSLSocketFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.delegate = sSLSocketFactory;
        this.compatible = false;
    }

    public TlsOnlySocketFactory(SSLSocketFactory sSLSocketFactory, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sSLSocketFactory, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.delegate = sSLSocketFactory;
        this.compatible = z;
    }
}
