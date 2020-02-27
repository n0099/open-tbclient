package org.conscrypt;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.PosixFilePermission;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class Java7PlatformUtil {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getHostStringFromInetSocketAddress(InetSocketAddress inetSocketAddress) {
        return inetSocketAddress.getHostString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkClientTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, AbstractConscryptSocket abstractConscryptSocket) throws CertificateException {
        if (x509TrustManager instanceof X509ExtendedTrustManager) {
            ((X509ExtendedTrustManager) x509TrustManager).checkClientTrusted(x509CertificateArr, str, abstractConscryptSocket);
        } else {
            x509TrustManager.checkClientTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkServerTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, AbstractConscryptSocket abstractConscryptSocket) throws CertificateException {
        if (x509TrustManager instanceof X509ExtendedTrustManager) {
            ((X509ExtendedTrustManager) x509TrustManager).checkServerTrusted(x509CertificateArr, str, abstractConscryptSocket);
        } else {
            x509TrustManager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkClientTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, ConscryptEngine conscryptEngine) throws CertificateException {
        if (x509TrustManager instanceof X509ExtendedTrustManager) {
            ((X509ExtendedTrustManager) x509TrustManager).checkClientTrusted(x509CertificateArr, str, conscryptEngine);
        } else {
            x509TrustManager.checkClientTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkServerTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, ConscryptEngine conscryptEngine) throws CertificateException {
        if (x509TrustManager instanceof X509ExtendedTrustManager) {
            ((X509ExtendedTrustManager) x509TrustManager).checkServerTrusted(x509CertificateArr, str, conscryptEngine);
        } else {
            x509TrustManager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl) {
        sSLParametersImpl.setEndpointIdentificationAlgorithm(sSLParameters.getEndpointIdentificationAlgorithm());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl) {
        sSLParameters.setEndpointIdentificationAlgorithm(sSLParametersImpl.getEndpointIdentificationAlgorithm());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addSuppressed(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean canExecuteExecutable(File file) throws IOException {
        if (file.canExecute()) {
            return true;
        }
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(file.toPath(), new LinkOption[0]);
        EnumSet of = EnumSet.of(PosixFilePermission.OWNER_EXECUTE, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_EXECUTE);
        if (posixFilePermissions.containsAll(of)) {
            return false;
        }
        EnumSet copyOf = EnumSet.copyOf((Collection) posixFilePermissions);
        copyOf.addAll(of);
        Files.setPosixFilePermissions(file.toPath(), copyOf);
        return file.canExecute();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SSLSession wrapSSLSession(ConscryptSession conscryptSession) {
        return new Java7ExtendedSSLSession(conscryptSession);
    }

    private Java7PlatformUtil() {
    }
}
