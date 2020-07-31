package org.conscrypt;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketImpl;
import java.nio.channels.SocketChannel;
import java.security.AccessController;
import java.security.AlgorithmParameters;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.crypto.spec.GCMParameterSpec;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.ct.CTLogStore;
import org.conscrypt.ct.CTPolicy;
import sun.security.x509.AlgorithmId;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class Platform {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Method GET_CURVE_NAME_METHOD;
    private static final int JAVA_VERSION;

    static {
        $assertionsDisabled = Platform.class.desiredAssertionStatus() ? false : true;
        JAVA_VERSION = javaVersion0();
        Method method = null;
        try {
            method = ECParameterSpec.class.getDeclaredMethod("getCurveName", new Class[0]);
            method.setAccessible(true);
        } catch (Exception e) {
        }
        GET_CURVE_NAME_METHOD = method;
    }

    private Platform() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setup() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File createTempFile(String str, String str2, File file) throws IOException {
        if (file == null) {
            throw new NullPointerException();
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = new File(str).getName();
        IOException e = null;
        for (int i = 0; i < 10000; i++) {
            String format = String.format(Locale.US, "%s%d%04d%s", name, Long.valueOf(currentTimeMillis), Integer.valueOf(i), str2);
            File file2 = new File(file, format);
            if (!format.equals(file2.getName())) {
                throw new IOException("Unable to create temporary file: " + file2);
            }
            try {
            } catch (IOException e2) {
                e = e2;
            }
            if (!file2.createNewFile()) {
                continue;
            } else {
                return file2.getCanonicalFile();
            }
        }
        if (e != null) {
            throw e;
        }
        throw new IOException("Unable to create temporary file");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getDefaultProviderName() {
        return "Conscrypt";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean canExecuteExecutable(File file) throws IOException {
        if (JAVA_VERSION >= 7) {
            return Java7PlatformUtil.canExecuteExecutable(file);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addSuppressed(Throwable th, Throwable th2) {
        if (JAVA_VERSION >= 7) {
            Java7PlatformUtil.addSuppressed(th, th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FileDescriptor getFileDescriptor(Socket socket) {
        try {
            SocketChannel channel = socket.getChannel();
            if (channel != null) {
                Field declaredField = channel.getClass().getDeclaredField("fd");
                declaredField.setAccessible(true);
                return (FileDescriptor) declaredField.get(channel);
            }
        } catch (Exception e) {
        }
        try {
            Field declaredField2 = Socket.class.getDeclaredField("impl");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(socket);
            Field declaredField3 = SocketImpl.class.getDeclaredField("fd");
            declaredField3.setAccessible(true);
            return (FileDescriptor) declaredField3.get(obj);
        } catch (Exception e2) {
            throw new RuntimeException("Can't get FileDescriptor from socket", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FileDescriptor getFileDescriptorFromSSLSocket(AbstractConscryptSocket abstractConscryptSocket) {
        return getFileDescriptor(abstractConscryptSocket);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCurveName(ECParameterSpec eCParameterSpec) {
        if (GET_CURVE_NAME_METHOD != null) {
            try {
                return (String) GET_CURVE_NAME_METHOD.invoke(eCParameterSpec, new Object[0]);
            } catch (Exception e) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCurveName(ECParameterSpec eCParameterSpec, String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSocketWriteTimeout(Socket socket, long j) throws SocketException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) {
        if (JAVA_VERSION >= 9) {
            Java9PlatformUtil.setSSLParameters(sSLParameters, sSLParametersImpl, abstractConscryptSocket);
        } else if (JAVA_VERSION >= 8) {
            Java8PlatformUtil.setSSLParameters(sSLParameters, sSLParametersImpl, abstractConscryptSocket);
        } else if (JAVA_VERSION >= 7) {
            Java7PlatformUtil.setSSLParameters(sSLParameters, sSLParametersImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) {
        if (JAVA_VERSION >= 9) {
            Java9PlatformUtil.getSSLParameters(sSLParameters, sSLParametersImpl, abstractConscryptSocket);
        } else if (JAVA_VERSION >= 8) {
            Java8PlatformUtil.getSSLParameters(sSLParameters, sSLParametersImpl, abstractConscryptSocket);
        } else if (JAVA_VERSION >= 7) {
            Java7PlatformUtil.getSSLParameters(sSLParameters, sSLParametersImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        if (JAVA_VERSION >= 9) {
            Java9PlatformUtil.setSSLParameters(sSLParameters, sSLParametersImpl, conscryptEngine);
        } else if (JAVA_VERSION >= 8) {
            Java8PlatformUtil.setSSLParameters(sSLParameters, sSLParametersImpl, conscryptEngine);
        } else if (JAVA_VERSION >= 7) {
            Java7PlatformUtil.setSSLParameters(sSLParameters, sSLParametersImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        if (JAVA_VERSION >= 9) {
            Java9PlatformUtil.getSSLParameters(sSLParameters, sSLParametersImpl, conscryptEngine);
        } else if (JAVA_VERSION >= 8) {
            Java8PlatformUtil.getSSLParameters(sSLParameters, sSLParametersImpl, conscryptEngine);
        } else if (JAVA_VERSION >= 7) {
            Java7PlatformUtil.getSSLParameters(sSLParameters, sSLParametersImpl);
        }
    }

    static void setEndpointIdentificationAlgorithm(SSLParameters sSLParameters, String str) {
        sSLParameters.setEndpointIdentificationAlgorithm(str);
    }

    static String getEndpointIdentificationAlgorithm(SSLParameters sSLParameters) {
        return sSLParameters.getEndpointIdentificationAlgorithm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkClientTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, AbstractConscryptSocket abstractConscryptSocket) throws CertificateException {
        if (JAVA_VERSION >= 7) {
            Java7PlatformUtil.checkClientTrusted(x509TrustManager, x509CertificateArr, str, abstractConscryptSocket);
        } else {
            x509TrustManager.checkClientTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkServerTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, AbstractConscryptSocket abstractConscryptSocket) throws CertificateException {
        if (JAVA_VERSION >= 7) {
            Java7PlatformUtil.checkServerTrusted(x509TrustManager, x509CertificateArr, str, abstractConscryptSocket);
        } else {
            x509TrustManager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkClientTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, ConscryptEngine conscryptEngine) throws CertificateException {
        if (JAVA_VERSION >= 7) {
            Java7PlatformUtil.checkClientTrusted(x509TrustManager, x509CertificateArr, str, conscryptEngine);
        } else {
            x509TrustManager.checkClientTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkServerTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, ConscryptEngine conscryptEngine) throws CertificateException {
        if (JAVA_VERSION >= 7) {
            Java7PlatformUtil.checkServerTrusted(x509TrustManager, x509CertificateArr, str, conscryptEngine);
        } else {
            x509TrustManager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSSLKey wrapRsaKey(PrivateKey privateKey) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void logEvent(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isLiteralIpAddress(String str) {
        return AddressUtils.isLiteralIpAddress(str);
    }

    static boolean isSniEnabledByDefault() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SSLEngine wrapEngine(ConscryptEngine conscryptEngine) {
        if (JAVA_VERSION >= 8) {
            return Java8PlatformUtil.wrapEngine(conscryptEngine);
        }
        return conscryptEngine;
    }

    static SSLEngine unwrapEngine(SSLEngine sSLEngine) {
        if (JAVA_VERSION >= 8) {
            return Java8PlatformUtil.unwrapEngine(sSLEngine);
        }
        return sSLEngine;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptEngineSocket createEngineSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8EngineSocket(sSLParametersImpl) : new ConscryptEngineSocket(sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptEngineSocket createEngineSocket(String str, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8EngineSocket(str, i, sSLParametersImpl) : new ConscryptEngineSocket(str, i, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptEngineSocket createEngineSocket(InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8EngineSocket(inetAddress, i, sSLParametersImpl) : new ConscryptEngineSocket(inetAddress, i, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptEngineSocket createEngineSocket(String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8EngineSocket(str, i, inetAddress, i2, sSLParametersImpl) : new ConscryptEngineSocket(str, i, inetAddress, i2, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptEngineSocket createEngineSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8EngineSocket(inetAddress, i, inetAddress2, i2, sSLParametersImpl) : new ConscryptEngineSocket(inetAddress, i, inetAddress2, i2, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptEngineSocket createEngineSocket(Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8EngineSocket(socket, str, i, z, sSLParametersImpl) : new ConscryptEngineSocket(socket, str, i, z, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8FileDescriptorSocket(sSLParametersImpl) : new ConscryptFileDescriptorSocket(sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(String str, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8FileDescriptorSocket(str, i, sSLParametersImpl) : new ConscryptFileDescriptorSocket(str, i, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8FileDescriptorSocket(inetAddress, i, sSLParametersImpl) : new ConscryptFileDescriptorSocket(inetAddress, i, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8FileDescriptorSocket(str, i, inetAddress, i2, sSLParametersImpl) : new ConscryptFileDescriptorSocket(str, i, inetAddress, i2, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8FileDescriptorSocket(inetAddress, i, inetAddress2, i2, sSLParametersImpl) : new ConscryptFileDescriptorSocket(inetAddress, i, inetAddress2, i2, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        return JAVA_VERSION >= 8 ? new Java8FileDescriptorSocket(socket, str, i, z, sSLParametersImpl) : new ConscryptFileDescriptorSocket(socket, str, i, z, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SSLSocketFactory wrapSocketFactoryIfNeeded(OpenSSLSocketFactoryImpl openSSLSocketFactoryImpl) {
        return openSSLSocketFactoryImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GCMParameters fromGCMParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof GCMParameterSpec) {
            GCMParameterSpec gCMParameterSpec = (GCMParameterSpec) algorithmParameterSpec;
            return new GCMParameters(gCMParameterSpec.getTLen(), gCMParameterSpec.getIV());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AlgorithmParameterSpec fromGCMParameters(AlgorithmParameters algorithmParameters) {
        try {
            return algorithmParameters.getParameterSpec(GCMParameterSpec.class);
        } catch (InvalidParameterSpecException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AlgorithmParameterSpec toGCMParameterSpec(int i, byte[] bArr) {
        return new GCMParameterSpec(i, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object closeGuardGet() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeGuardOpen(Object obj, String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeGuardClose(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeGuardWarnIfOpen(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void blockGuardOnNetwork() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String oidToAlgorithmName(String str) {
        try {
            return AlgorithmId.get(str).getName();
        } catch (NoSuchAlgorithmException e) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SSLSession wrapSSLSession(ConscryptSession conscryptSession) {
        if (JAVA_VERSION >= 8) {
            return Java8PlatformUtil.wrapSSLSession(conscryptSession);
        }
        if (JAVA_VERSION >= 7) {
            return Java7PlatformUtil.wrapSSLSession(conscryptSession);
        }
        return conscryptSession;
    }

    public static String getOriginalHostNameFromInetAddress(InetAddress inetAddress) {
        try {
            Method declaredMethod = InetAddress.class.getDeclaredMethod("holder", new Class[0]);
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = Class.forName("java.net.InetAddress$InetAddressHolder").getDeclaredMethod("getOriginalHostName", new Class[0]);
            declaredMethod2.setAccessible(true);
            String str = (String) declaredMethod2.invoke(declaredMethod.invoke(inetAddress, new Object[0]), new Object[0]);
            if (str == null) {
                return inetAddress.getHostAddress();
            }
            return str;
        } catch (ClassNotFoundException e) {
            return inetAddress.getHostAddress();
        } catch (IllegalAccessException e2) {
            return inetAddress.getHostAddress();
        } catch (NoSuchMethodException e3) {
            return inetAddress.getHostAddress();
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Failed to get originalHostName", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getHostStringFromInetSocketAddress(InetSocketAddress inetSocketAddress) {
        if (JAVA_VERSION >= 7) {
            return Java7PlatformUtil.getHostStringFromInetSocketAddress(inetSocketAddress);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isCTVerificationRequired(String str) {
        String property;
        if (str == null || (property = Security.getProperty("conscrypt.ct.enable")) == null || !Boolean.valueOf(property.toLowerCase()).booleanValue()) {
            return false;
        }
        List<String> asList = Arrays.asList(str.split("\\."));
        Collections.reverse(asList);
        StringBuilder sb = new StringBuilder("conscrypt.ct.enforce");
        boolean z = false;
        for (String str2 : asList) {
            String property2 = Security.getProperty(((Object) sb) + ".*");
            if (property2 != null) {
                z = Boolean.valueOf(property2.toLowerCase()).booleanValue();
            }
            sb.append(".").append(str2);
        }
        String property3 = Security.getProperty(sb.toString());
        if (property3 != null) {
            z = Boolean.valueOf(property3.toLowerCase()).booleanValue();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean supportsConscryptCertStore() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KeyStore getDefaultCertKeyStore() throws KeyStoreException {
        Provider[] providers;
        int i;
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try {
            keyStore.load(null, null);
        } catch (IOException e) {
        } catch (NoSuchAlgorithmException e2) {
        } catch (CertificateException e3) {
        }
        for (Provider provider : Security.getProviders("TrustManagerFactory.PKIX")) {
            if (!Conscrypt.isConscrypt(provider)) {
                try {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", provider);
                    trustManagerFactory.init((KeyStore) null);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    if (trustManagers.length > 0) {
                        int length = trustManagers.length;
                        int i2 = 0;
                        int i3 = 1;
                        while (i2 < length) {
                            TrustManager trustManager = trustManagers[i2];
                            if (trustManager instanceof X509TrustManager) {
                                X509Certificate[] acceptedIssuers = ((X509TrustManager) trustManager).getAcceptedIssuers();
                                int length2 = acceptedIssuers.length;
                                i = i3;
                                int i4 = 0;
                                while (i4 < length2) {
                                    int i5 = i + 1;
                                    keyStore.setCertificateEntry(Integer.toString(i), acceptedIssuers[i4]);
                                    i4++;
                                    i = i5;
                                }
                            } else {
                                i = i3;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 > 1) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NoSuchAlgorithmException e4) {
                }
            }
        }
        return keyStore;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptCertStore newDefaultCertStore() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CertBlacklist newDefaultBlacklist() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CTLogStore newDefaultLogStore() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CTPolicy newDefaultPolicy(CTLogStore cTLogStore) {
        return null;
    }

    private static boolean isAndroid() {
        try {
            Class.forName("android.app.Application", false, getSystemClassLoader());
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    static int javaVersion() {
        return JAVA_VERSION;
    }

    private static int javaVersion0() {
        if (isAndroid()) {
            return 6;
        }
        return majorVersionFromJavaSpecificationVersion();
    }

    private static int majorVersionFromJavaSpecificationVersion() {
        return majorVersion(System.getProperty("java.specification.version", "1.6"));
    }

    private static int majorVersion(String str) {
        String[] split = str.split("\\.", -1);
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = Integer.parseInt(split[i]);
        }
        if (iArr[0] == 1) {
            if ($assertionsDisabled || iArr[1] >= 6) {
                return iArr[1];
            }
            throw new AssertionError();
        }
        return iArr[0];
    }

    private static ClassLoader getSystemClassLoader() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: org.conscrypt.Platform.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
