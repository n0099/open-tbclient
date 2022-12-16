package okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
/* loaded from: classes9.dex */
public class AndroidPlatform extends Platform {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_LOG_LENGTH = 4000;
    public transient /* synthetic */ FieldHolder $fh;
    public final CloseGuard closeGuard;
    public final OptionalMethod<Socket> getAlpnSelectedProtocol;
    public final OptionalMethod<Socket> setAlpnProtocols;
    public final OptionalMethod<Socket> setHostname;
    public final OptionalMethod<Socket> setUseSessionTickets;
    public final Class<?> sslParametersClass;

    /* loaded from: classes9.dex */
    public static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Method checkServerTrusted;
        public final Object x509TrustManagerExtensions;

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public AndroidCertificateChainCleaner(Object obj, Method method) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, method};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.x509TrustManagerExtensions = obj;
            this.checkServerTrusted = method;
        }

        @Override // okhttp3.internal.tls.CertificateChainCleaner
        public List<Certificate> clean(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, str)) == null) {
                try {
                    return (List) this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                } catch (InvocationTargetException e2) {
                    SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                    sSLPeerUnverifiedException.initCause(e2);
                    throw sSLPeerUnverifiedException;
                }
            }
            return (List) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return obj instanceof AndroidCertificateChainCleaner;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class AndroidTrustRootIndex implements TrustRootIndex {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Method findByIssuerAndSignatureMethod;
        public final X509TrustManager trustManager;

        public AndroidTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509TrustManager, method};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.findByIssuerAndSignatureMethod = method;
            this.trustManager = x509TrustManager;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof AndroidTrustRootIndex)) {
                    return false;
                }
                AndroidTrustRootIndex androidTrustRootIndex = (AndroidTrustRootIndex) obj;
                if (this.trustManager.equals(androidTrustRootIndex.trustManager) && this.findByIssuerAndSignatureMethod.equals(androidTrustRootIndex.findByIssuerAndSignatureMethod)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509Certificate)) == null) {
                try {
                    TrustAnchor trustAnchor = (TrustAnchor) this.findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate);
                    if (trustAnchor == null) {
                        return null;
                    }
                    return trustAnchor.getTrustedCert();
                } catch (IllegalAccessException e) {
                    throw Util.assertionError("unable to get issues and signature", e);
                } catch (InvocationTargetException unused) {
                    return null;
                }
            }
            return (X509Certificate) invokeL.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.trustManager.hashCode() + (this.findByIssuerAndSignatureMethod.hashCode() * 31);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class CloseGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Method getMethod;
        public final Method openMethod;
        public final Method warnIfOpenMethod;

        public CloseGuard(Method method, Method method2, Method method3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {method, method2, method3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.getMethod = method;
            this.openMethod = method2;
            this.warnIfOpenMethod = method3;
        }

        public static CloseGuard get() {
            InterceptResult invokeV;
            Method method;
            Method method2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                Method method3 = null;
                try {
                    Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                    Method method4 = cls.getMethod("get", new Class[0]);
                    method2 = cls.getMethod("open", String.class);
                    method = cls.getMethod("warnIfOpen", new Class[0]);
                    method3 = method4;
                } catch (Exception unused) {
                    method = null;
                    method2 = null;
                }
                return new CloseGuard(method3, method2, method);
            }
            return (CloseGuard) invokeV.objValue;
        }

        public Object createAndOpen(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                Method method = this.getMethod;
                if (method != null) {
                    try {
                        Object invoke = method.invoke(null, new Object[0]);
                        this.openMethod.invoke(invoke, str);
                        return invoke;
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return invokeL.objValue;
        }

        public boolean warnIfOpen(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == null) {
                    return false;
                }
                try {
                    this.warnIfOpenMethod.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    public AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, optionalMethod, optionalMethod2, optionalMethod3, optionalMethod4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.closeGuard = CloseGuard.get();
        this.sslParametersClass = cls;
        this.setUseSessionTickets = optionalMethod;
        this.setHostname = optionalMethod2;
        this.getAlpnSelectedProtocol = optionalMethod3;
        this.setAlpnProtocols = optionalMethod4;
    }

    private boolean api23IsCleartextTrafficPermitted(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, cls, obj)) == null) {
            try {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
            } catch (NoSuchMethodException unused) {
                return super.isCleartextTrafficPermitted(str);
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean api24IsCleartextTrafficPermitted(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, str, cls, obj)) == null) {
            try {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
            } catch (NoSuchMethodException unused) {
                return api23IsCleartextTrafficPermitted(str, cls, obj);
            }
        }
        return invokeLLL.booleanValue;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket, str, list) == null) {
            if (str != null) {
                this.setUseSessionTickets.invokeOptionalWithoutCheckedException(sSLSocket, Boolean.TRUE);
                this.setHostname.invokeOptionalWithoutCheckedException(sSLSocket, str);
            }
            OptionalMethod<Socket> optionalMethod = this.setAlpnProtocols;
            if (optionalMethod != null && optionalMethod.isSupported(sSLSocket)) {
                this.setAlpnProtocols.invokeWithoutCheckedException(sSLSocket, Platform.concatLengthPrefixed(list));
            }
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, socket, inetSocketAddress, i) == null) {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (AssertionError e) {
                if (Util.isAndroidGetsocknameError(e)) {
                    throw new IOException(e);
                }
                throw e;
            } catch (ClassCastException e2) {
                if (Build.VERSION.SDK_INT == 26) {
                    IOException iOException = new IOException("Exception in connect");
                    iOException.initCause(e2);
                    throw iOException;
                }
                throw e2;
            } catch (SecurityException e3) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e3);
                throw iOException2;
            }
        }
    }

    public static Platform buildIfSupported() {
        InterceptResult invokeV;
        Class<?> cls;
        OptionalMethod optionalMethod;
        OptionalMethod optionalMethod2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!Platform.isAndroid()) {
                return null;
            }
            try {
                try {
                    cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
                }
                Class<?> cls2 = cls;
                OptionalMethod optionalMethod3 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
                OptionalMethod optionalMethod4 = new OptionalMethod(null, "setHostname", String.class);
                if (supportsAlpn()) {
                    OptionalMethod optionalMethod5 = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    optionalMethod2 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
                    optionalMethod = optionalMethod5;
                } else {
                    optionalMethod = null;
                    optionalMethod2 = null;
                }
                return new AndroidPlatform(cls2, optionalMethod3, optionalMethod4, optionalMethod, optionalMethod2);
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        return (Platform) invokeV.objValue;
    }

    public static int getSdkInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                return Build.VERSION.SDK_INT;
            } catch (NoClassDefFoundError unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static boolean supportsAlpn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (Security.getProvider("GMSCore_OpenSSL") != null) {
                return true;
            }
            try {
                Class.forName("android.net.Network");
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // okhttp3.internal.platform.Platform
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x509TrustManager)) == null) {
            try {
                Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
                return new AndroidCertificateChainCleaner(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
            } catch (Exception unused) {
                return super.buildCertificateChainCleaner(x509TrustManager);
            }
        }
        return (CertificateChainCleaner) invokeL.objValue;
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return super.isCleartextTrafficPermitted(str);
            }
            try {
                Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
                return api24IsCleartextTrafficPermitted(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                return super.isCleartextTrafficPermitted(str);
            } catch (IllegalAccessException e) {
                e = e;
                throw Util.assertionError("unable to determine cleartext support", e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw Util.assertionError("unable to determine cleartext support", e);
            } catch (InvocationTargetException e3) {
                e = e3;
                throw Util.assertionError("unable to determine cleartext support", e);
            }
        }
        return invokeL.booleanValue;
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, sSLSocketFactory)) == null) {
            Object readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, this.sslParametersClass, "sslParameters");
            if (readFieldOrNull == null) {
                try {
                    readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
                } catch (ClassNotFoundException unused) {
                    return super.trustManager(sSLSocketFactory);
                }
            }
            X509TrustManager x509TrustManager = (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
            if (x509TrustManager != null) {
                return x509TrustManager;
            }
            return (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
        }
        return (X509TrustManager) invokeL.objValue;
    }

    @Override // okhttp3.internal.platform.Platform
    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509TrustManager)) == null) {
            try {
                Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
                declaredMethod.setAccessible(true);
                return new AndroidTrustRootIndex(x509TrustManager, declaredMethod);
            } catch (NoSuchMethodException unused) {
                return super.buildTrustRootIndex(x509TrustManager);
            }
        }
        return (TrustRootIndex) invokeL.objValue;
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sSLSocket)) == null) {
            OptionalMethod<Socket> optionalMethod = this.getAlpnSelectedProtocol;
            if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket) || (bArr = (byte[]) this.getAlpnSelectedProtocol.invokeWithoutCheckedException(sSLSocket, new Object[0])) == null) {
                return null;
            }
            return new String(bArr, Util.UTF_8);
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
        if (android.os.Build.VERSION.SDK_INT < 22) goto L10;
     */
    @Override // okhttp3.internal.platform.Platform
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SSLContext getSSLContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            boolean z = true;
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                }
                z = false;
            } catch (NoClassDefFoundError unused) {
            }
            if (z) {
                try {
                    return SSLContext.getInstance("TLSv1.2");
                } catch (NoSuchAlgorithmException unused2) {
                }
            }
            try {
                return SSLContext.getInstance("TLS");
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException("No TLS provider", e);
            }
        }
        return (SSLContext) invokeV.objValue;
    }

    @Override // okhttp3.internal.platform.Platform
    public Object getStackTraceForCloseable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return this.closeGuard.createAndOpen(str);
        }
        return invokeL.objValue;
    }

    @Override // okhttp3.internal.platform.Platform
    public void log(int i, String str, @Nullable Throwable th) {
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str, th) == null) {
            int i2 = 5;
            if (i != 5) {
                i2 = 3;
            }
            if (th != null) {
                str = str + '\n' + Log.getStackTraceString(th);
            }
            int i3 = 0;
            int length = str.length();
            while (i3 < length) {
                int indexOf = str.indexOf(10, i3);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i3 + 4000);
                    Log.println(i2, "OkHttp", str.substring(i3, min));
                    if (min >= indexOf) {
                        break;
                    }
                    i3 = min;
                }
                i3 = min + 1;
            }
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, obj) == null) && !this.closeGuard.warnIfOpen(obj)) {
            log(5, str, null);
        }
    }
}
