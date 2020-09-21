package org.conscrypt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509ExtendedTrustManager;
import org.conscrypt.ct.CTLogStore;
import org.conscrypt.ct.CTPolicy;
import org.conscrypt.ct.CTVerifier;
/* loaded from: classes8.dex */
public final class TrustManagerImpl extends X509ExtendedTrustManager {
    private static final TrustAnchorComparator TRUST_ANCHOR_COMPARATOR = new TrustAnchorComparator();
    private final X509Certificate[] acceptedIssuers;
    private final CertBlacklist blacklist;
    private boolean ctEnabledOverride;
    private CTPolicy ctPolicy;
    private CTVerifier ctVerifier;
    private final Exception err;
    private final CertificateFactory factory;
    private final TrustedCertificateIndex intermediateIndex;
    private CertPinManager pinManager;
    private final KeyStore rootKeyStore;
    private final TrustedCertificateIndex trustedCertificateIndex;
    private final ConscryptCertStore trustedCertificateStore;
    private final CertPathValidator validator;

    public TrustManagerImpl(KeyStore keyStore) {
        this(keyStore, null);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager) {
        this(keyStore, certPinManager, null);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager, ConscryptCertStore conscryptCertStore) {
        this(keyStore, certPinManager, conscryptCertStore, null);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager, ConscryptCertStore conscryptCertStore, CertBlacklist certBlacklist) {
        this(keyStore, certPinManager, conscryptCertStore, certBlacklist, null, null, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(3:2|3|(4:5|6|7|8))|(2:10|(9:(2:13|14)|28|29|30|(1:20)|(1:22)|(1:24)|25|26))|35|36|37|38|39|(0)|(0)|(0)|25|26|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:1|2|3|(4:5|6|7|8)|(2:10|(9:(2:13|14)|28|29|30|(1:20)|(1:22)|(1:24)|25|26))|35|36|37|38|39|(0)|(0)|(0)|25|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0095, code lost:
        r2 = null;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0099, code lost:
        r8 = null;
        r0 = r2;
        r2 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager, ConscryptCertStore conscryptCertStore, CertBlacklist certBlacklist, CTLogStore cTLogStore, CTVerifier cTVerifier, CTPolicy cTPolicy) {
        X509Certificate[] x509CertificateArr;
        CertificateFactory certificateFactory;
        CertPathValidator certPathValidator;
        TrustedCertificateIndex trustedCertificateIndex;
        X509Certificate[] x509CertificateArr2;
        Exception exc = null;
        try {
            certPathValidator = CertPathValidator.getInstance("PKIX");
            try {
                certificateFactory = CertificateFactory.getInstance("X509");
                try {
                } catch (Exception e) {
                    e = e;
                    x509CertificateArr = null;
                    conscryptCertStore = null;
                    keyStore = null;
                }
            } catch (Exception e2) {
                e = e2;
                x509CertificateArr = null;
                conscryptCertStore = null;
                keyStore = null;
                certificateFactory = null;
            }
        } catch (Exception e3) {
            e = e3;
            x509CertificateArr = null;
            conscryptCertStore = null;
            keyStore = null;
            certificateFactory = null;
            certPathValidator = null;
        }
        if ("AndroidCAStore".equals(keyStore.getType())) {
            if (Platform.supportsConscryptCertStore()) {
                if (conscryptCertStore == null) {
                    try {
                        conscryptCertStore = Platform.newDefaultCertStore();
                    } catch (Exception e4) {
                        e = e4;
                        x509CertificateArr = null;
                        conscryptCertStore = null;
                        Exception exc2 = e;
                        x509CertificateArr2 = x509CertificateArr;
                        trustedCertificateIndex = null;
                        exc = exc2;
                        if (certBlacklist == null) {
                        }
                        if (cTLogStore == null) {
                        }
                        if (cTPolicy == null) {
                        }
                        this.pinManager = certPinManager;
                        this.rootKeyStore = keyStore;
                        this.trustedCertificateStore = conscryptCertStore;
                        this.validator = certPathValidator;
                        this.factory = certificateFactory;
                        this.trustedCertificateIndex = trustedCertificateIndex;
                        this.intermediateIndex = new TrustedCertificateIndex();
                        this.acceptedIssuers = x509CertificateArr2;
                        this.err = exc;
                        this.blacklist = certBlacklist;
                        this.ctVerifier = new CTVerifier(cTLogStore);
                        this.ctPolicy = cTPolicy;
                    }
                }
                try {
                    trustedCertificateIndex = new TrustedCertificateIndex();
                    x509CertificateArr2 = null;
                } catch (Exception e5) {
                    e = e5;
                    x509CertificateArr = null;
                    Exception exc22 = e;
                    x509CertificateArr2 = x509CertificateArr;
                    trustedCertificateIndex = null;
                    exc = exc22;
                    if (certBlacklist == null) {
                    }
                    if (cTLogStore == null) {
                    }
                    if (cTPolicy == null) {
                    }
                    this.pinManager = certPinManager;
                    this.rootKeyStore = keyStore;
                    this.trustedCertificateStore = conscryptCertStore;
                    this.validator = certPathValidator;
                    this.factory = certificateFactory;
                    this.trustedCertificateIndex = trustedCertificateIndex;
                    this.intermediateIndex = new TrustedCertificateIndex();
                    this.acceptedIssuers = x509CertificateArr2;
                    this.err = exc;
                    this.blacklist = certBlacklist;
                    this.ctVerifier = new CTVerifier(cTLogStore);
                    this.ctPolicy = cTPolicy;
                }
                certBlacklist = certBlacklist == null ? Platform.newDefaultBlacklist() : certBlacklist;
                cTLogStore = cTLogStore == null ? Platform.newDefaultLogStore() : cTLogStore;
                cTPolicy = cTPolicy == null ? Platform.newDefaultPolicy(cTLogStore) : cTPolicy;
                this.pinManager = certPinManager;
                this.rootKeyStore = keyStore;
                this.trustedCertificateStore = conscryptCertStore;
                this.validator = certPathValidator;
                this.factory = certificateFactory;
                this.trustedCertificateIndex = trustedCertificateIndex;
                this.intermediateIndex = new TrustedCertificateIndex();
                this.acceptedIssuers = x509CertificateArr2;
                this.err = exc;
                this.blacklist = certBlacklist;
                this.ctVerifier = new CTVerifier(cTLogStore);
                this.ctPolicy = cTPolicy;
            }
        }
        x509CertificateArr2 = acceptedIssuers(keyStore);
        trustedCertificateIndex = new TrustedCertificateIndex(trustAnchors(x509CertificateArr2));
        keyStore = null;
        if (certBlacklist == null) {
        }
        if (cTLogStore == null) {
        }
        if (cTPolicy == null) {
        }
        this.pinManager = certPinManager;
        this.rootKeyStore = keyStore;
        this.trustedCertificateStore = conscryptCertStore;
        this.validator = certPathValidator;
        this.factory = certificateFactory;
        this.trustedCertificateIndex = trustedCertificateIndex;
        this.intermediateIndex = new TrustedCertificateIndex();
        this.acceptedIssuers = x509CertificateArr2;
        this.err = exc;
        this.blacklist = certBlacklist;
        this.ctVerifier = new CTVerifier(cTLogStore);
        this.ctPolicy = cTPolicy;
    }

    private static X509Certificate[] acceptedIssuers(KeyStore keyStore) {
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(aliases.nextElement());
                if (x509Certificate != null) {
                    arrayList.add(x509Certificate);
                }
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (KeyStoreException e) {
            return new X509Certificate[0];
        }
    }

    private static Set<TrustAnchor> trustAnchors(X509Certificate[] x509CertificateArr) {
        HashSet hashSet = new HashSet(x509CertificateArr.length);
        for (X509Certificate x509Certificate : x509CertificateArr) {
            hashSet.add(new TrustAnchor(x509Certificate, null));
        }
        return hashSet;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        checkTrusted(x509CertificateArr, str, null, null, true);
    }

    public List<X509Certificate> checkClientTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
        return checkTrusted(x509CertificateArr, null, null, str, str2, true);
    }

    private static SSLSession getHandshakeSessionOrThrow(SSLSocket sSLSocket) throws CertificateException {
        SSLSession handshakeSession = sSLSocket.getHandshakeSession();
        if (handshakeSession == null) {
            throw new CertificateException("Not in handshake; no session available");
        }
        return handshakeSession;
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        SSLSession sSLSession;
        SSLParameters sSLParameters = null;
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSession = getHandshakeSessionOrThrow(sSLSocket);
            sSLParameters = sSLSocket.getSSLParameters();
        } else {
            sSLSession = null;
        }
        checkTrusted(x509CertificateArr, str, sSLSession, sSLParameters, true);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        SSLSession handshakeSession = sSLEngine.getHandshakeSession();
        if (handshakeSession == null) {
            throw new CertificateException("Not in handshake; no session available");
        }
        checkTrusted(x509CertificateArr, str, handshakeSession, sSLEngine.getSSLParameters(), true);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        checkTrusted(x509CertificateArr, str, null, null, false);
    }

    public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
        return checkTrusted(x509CertificateArr, null, null, str, str2, false);
    }

    public List<X509Certificate> getTrustedChainForServer(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        SSLSession sSLSession;
        SSLParameters sSLParameters = null;
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSession = getHandshakeSessionOrThrow(sSLSocket);
            sSLParameters = sSLSocket.getSSLParameters();
        } else {
            sSLSession = null;
        }
        return checkTrusted(x509CertificateArr, str, sSLSession, sSLParameters, false);
    }

    public List<X509Certificate> getTrustedChainForServer(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        SSLSession handshakeSession = sSLEngine.getHandshakeSession();
        if (handshakeSession == null) {
            throw new CertificateException("Not in handshake; no session available");
        }
        return checkTrusted(x509CertificateArr, str, handshakeSession, sSLEngine.getSSLParameters(), false);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        getTrustedChainForServer(x509CertificateArr, str, socket);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        getTrustedChainForServer(x509CertificateArr, str, sSLEngine);
    }

    public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession) throws CertificateException {
        return checkTrusted(x509CertificateArr, str, sSLSession, null, false);
    }

    public void handleTrustStorageUpdate() {
        if (this.acceptedIssuers == null) {
            this.trustedCertificateIndex.reset();
        } else {
            this.trustedCertificateIndex.reset(trustAnchors(this.acceptedIssuers));
        }
    }

    private List<X509Certificate> checkTrusted(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession, SSLParameters sSLParameters, boolean z) throws CertificateException {
        byte[] bArr;
        byte[] bArr2;
        String endpointIdentificationAlgorithm;
        String str2 = null;
        if (sSLSession != null) {
            str2 = sSLSession.getPeerHost();
            bArr2 = getOcspDataFromSession(sSLSession);
            bArr = getTlsSctDataFromSession(sSLSession);
        } else {
            bArr = null;
            bArr2 = null;
        }
        if (sSLSession != null && sSLParameters != null && (endpointIdentificationAlgorithm = sSLParameters.getEndpointIdentificationAlgorithm()) != null && "HTTPS".equals(endpointIdentificationAlgorithm.toUpperCase(Locale.US)) && !HttpsURLConnection.getDefaultHostnameVerifier().verify(str2, sSLSession)) {
            throw new CertificateException("No subjectAltNames on the certificate match");
        }
        return checkTrusted(x509CertificateArr, bArr2, bArr, str, str2, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [432=4] */
    private byte[] getOcspDataFromSession(SSLSession sSLSession) {
        List<byte[]> list;
        if (sSLSession instanceof ConscryptSession) {
            list = ((ConscryptSession) sSLSession).getStatusResponses();
        } else {
            try {
                Method declaredMethod = sSLSession.getClass().getDeclaredMethod("getStatusResponses", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(sSLSession, new Object[0]);
                list = invoke instanceof List ? (List) invoke : null;
            } catch (IllegalAccessException e) {
                list = null;
            } catch (IllegalArgumentException e2) {
                list = null;
            } catch (NoSuchMethodException e3) {
                list = null;
            } catch (SecurityException e4) {
                list = null;
            } catch (InvocationTargetException e5) {
                throw new RuntimeException(e5.getCause());
            }
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private byte[] getTlsSctDataFromSession(SSLSession sSLSession) {
        byte[] bArr;
        if (sSLSession instanceof ConscryptSession) {
            return ((ConscryptSession) sSLSession).getPeerSignedCertificateTimestamp();
        }
        try {
            Method declaredMethod = sSLSession.getClass().getDeclaredMethod("getPeerSignedCertificateTimestamp", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(sSLSession, new Object[0]);
            if (!(invoke instanceof byte[])) {
                bArr = null;
            } else {
                bArr = (byte[]) invoke;
            }
            return bArr;
        } catch (IllegalAccessException e) {
            return null;
        } catch (IllegalArgumentException e2) {
            return null;
        } catch (NoSuchMethodException e3) {
            return null;
        } catch (SecurityException e4) {
            return null;
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5.getCause());
        }
    }

    private List<X509Certificate> checkTrusted(X509Certificate[] x509CertificateArr, byte[] bArr, byte[] bArr2, String str, String str2, boolean z) throws CertificateException {
        if (x509CertificateArr == null || x509CertificateArr.length == 0 || str == null || str.length() == 0) {
            throw new IllegalArgumentException("null or zero-length parameter");
        }
        if (this.err != null) {
            throw new CertificateException(this.err);
        }
        HashSet hashSet = new HashSet();
        ArrayList<X509Certificate> arrayList = new ArrayList<>();
        ArrayList<TrustAnchor> arrayList2 = new ArrayList<>();
        X509Certificate x509Certificate = x509CertificateArr[0];
        TrustAnchor findTrustAnchorBySubjectAndPublicKey = findTrustAnchorBySubjectAndPublicKey(x509Certificate);
        if (findTrustAnchorBySubjectAndPublicKey != null) {
            arrayList2.add(findTrustAnchorBySubjectAndPublicKey);
            hashSet.add(findTrustAnchorBySubjectAndPublicKey.getTrustedCert());
        } else {
            arrayList.add(x509Certificate);
        }
        hashSet.add(x509Certificate);
        return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str2, z, arrayList, arrayList2, hashSet);
    }

    private List<X509Certificate> checkTrustedRecursive(X509Certificate[] x509CertificateArr, byte[] bArr, byte[] bArr2, String str, boolean z, ArrayList<X509Certificate> arrayList, ArrayList<TrustAnchor> arrayList2, Set<X509Certificate> set) throws CertificateException {
        X509Certificate trustedCert;
        if (arrayList2.isEmpty()) {
            trustedCert = arrayList.get(arrayList.size() - 1);
        } else {
            trustedCert = arrayList2.get(arrayList2.size() - 1).getTrustedCert();
        }
        checkBlacklist(trustedCert);
        if (trustedCert.getIssuerDN().equals(trustedCert.getSubjectDN())) {
            return verifyChain(arrayList, arrayList2, str, z, bArr, bArr2);
        }
        CertificateException certificateException = null;
        boolean z2 = false;
        for (TrustAnchor trustAnchor : sortPotentialAnchors(findAllTrustAnchorsByIssuerAndSignature(trustedCert))) {
            X509Certificate trustedCert2 = trustAnchor.getTrustedCert();
            if (!set.contains(trustedCert2)) {
                z2 = true;
                set.add(trustedCert2);
                arrayList2.add(trustAnchor);
                try {
                    return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z, arrayList, arrayList2, set);
                } catch (CertificateException e) {
                    arrayList2.remove(arrayList2.size() - 1);
                    set.remove(trustedCert2);
                    certificateException = e;
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            if (!z2) {
                return verifyChain(arrayList, arrayList2, str, z, bArr, bArr2);
            }
            throw certificateException;
        }
        CertificateException e2 = certificateException;
        for (int i = 1; i < x509CertificateArr.length; i++) {
            X509Certificate x509Certificate = x509CertificateArr[i];
            if (!set.contains(x509Certificate) && trustedCert.getIssuerDN().equals(x509Certificate.getSubjectDN())) {
                try {
                    x509Certificate.checkValidity();
                    ChainStrengthAnalyzer.checkCert(x509Certificate);
                    set.add(x509Certificate);
                    arrayList.add(x509Certificate);
                    try {
                        return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z, arrayList, arrayList2, set);
                    } catch (CertificateException e3) {
                        e2 = e3;
                        set.remove(x509Certificate);
                        arrayList.remove(arrayList.size() - 1);
                    }
                } catch (CertificateException e4) {
                    e2 = new CertificateException("Unacceptable certificate: " + x509Certificate.getSubjectX500Principal(), e4);
                }
            }
        }
        CertificateException certificateException2 = e2;
        for (TrustAnchor trustAnchor2 : sortPotentialAnchors(this.intermediateIndex.findAllByIssuerAndSignature(trustedCert))) {
            X509Certificate trustedCert3 = trustAnchor2.getTrustedCert();
            if (!set.contains(trustedCert3)) {
                set.add(trustedCert3);
                arrayList.add(trustedCert3);
                try {
                    return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z, arrayList, arrayList2, set);
                } catch (CertificateException e5) {
                    arrayList.remove(arrayList.size() - 1);
                    set.remove(trustedCert3);
                    certificateException2 = e5;
                }
            }
        }
        if (certificateException2 != null) {
            throw certificateException2;
        }
        throw new CertificateException(new CertPathValidatorException("Trust anchor for certification path not found.", null, this.factory.generateCertPath(arrayList), -1));
    }

    private List<X509Certificate> verifyChain(List<X509Certificate> list, List<TrustAnchor> list2, String str, boolean z, byte[] bArr, byte[] bArr2) throws CertificateException {
        CertPath generateCertPath = this.factory.generateCertPath(list);
        if (list2.isEmpty()) {
            throw new CertificateException(new CertPathValidatorException("Trust anchor for certification path not found.", null, generateCertPath, -1));
        }
        ArrayList<X509Certificate> arrayList = new ArrayList();
        arrayList.addAll(list);
        for (TrustAnchor trustAnchor : list2) {
            arrayList.add(trustAnchor.getTrustedCert());
        }
        if (this.pinManager != null) {
            this.pinManager.checkChainPinning(str, arrayList);
        }
        for (X509Certificate x509Certificate : arrayList) {
            checkBlacklist(x509Certificate);
        }
        if (!z && (this.ctEnabledOverride || (str != null && Platform.isCTVerificationRequired(str)))) {
            checkCT(str, arrayList, bArr, bArr2);
        }
        if (list.isEmpty()) {
            return arrayList;
        }
        ChainStrengthAnalyzer.check(list);
        try {
            HashSet hashSet = new HashSet();
            hashSet.add(list2.get(0));
            PKIXParameters pKIXParameters = new PKIXParameters(hashSet);
            pKIXParameters.setRevocationEnabled(false);
            X509Certificate x509Certificate2 = list.get(0);
            setOcspResponses(pKIXParameters, x509Certificate2, bArr);
            pKIXParameters.addCertPathChecker(new ExtendedKeyUsagePKIXCertPathChecker(z, x509Certificate2));
            this.validator.validate(generateCertPath, pKIXParameters);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    return arrayList;
                }
                this.intermediateIndex.index(list.get(i2));
                i = i2 + 1;
            }
        } catch (InvalidAlgorithmParameterException e) {
            throw new CertificateException("Chain validation failed", e);
        } catch (CertPathValidatorException e2) {
            throw new CertificateException("Chain validation failed", e2);
        }
    }

    private void checkBlacklist(X509Certificate x509Certificate) throws CertificateException {
        if (this.blacklist != null && this.blacklist.isPublicKeyBlackListed(x509Certificate.getPublicKey())) {
            throw new CertificateException("Certificate blacklisted by public key: " + x509Certificate);
        }
    }

    private void checkCT(String str, List<X509Certificate> list, byte[] bArr, byte[] bArr2) throws CertificateException {
        if (!this.ctPolicy.doesResultConformToPolicy(this.ctVerifier.verifySignedCertificateTimestamps(list, bArr2, bArr), str, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]))) {
            throw new CertificateException("Certificate chain does not conform to required transparency policy.");
        }
    }

    private void setOcspResponses(PKIXParameters pKIXParameters, X509Certificate x509Certificate, byte[] bArr) {
        PKIXRevocationChecker pKIXRevocationChecker;
        if (bArr != null) {
            List<PKIXCertPathChecker> arrayList = new ArrayList<>(pKIXParameters.getCertPathCheckers());
            Iterator<PKIXCertPathChecker> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    pKIXRevocationChecker = null;
                    break;
                }
                PKIXCertPathChecker next = it.next();
                if (next instanceof PKIXRevocationChecker) {
                    pKIXRevocationChecker = (PKIXRevocationChecker) next;
                    break;
                }
            }
            if (pKIXRevocationChecker == null) {
                try {
                    pKIXRevocationChecker = (PKIXRevocationChecker) this.validator.getRevocationChecker();
                    arrayList.add(pKIXRevocationChecker);
                    pKIXRevocationChecker.setOptions(Collections.singleton(PKIXRevocationChecker.Option.ONLY_END_ENTITY));
                } catch (UnsupportedOperationException e) {
                    return;
                }
            }
            pKIXRevocationChecker.setOcspResponses(Collections.singletonMap(x509Certificate, bArr));
            pKIXParameters.setCertPathCheckers(arrayList);
        }
    }

    private static Collection<TrustAnchor> sortPotentialAnchors(Set<TrustAnchor> set) {
        if (set.size() > 1) {
            ArrayList arrayList = new ArrayList(set);
            Collections.sort(arrayList, TRUST_ANCHOR_COMPARATOR);
            return arrayList;
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class TrustAnchorComparator implements Comparator<TrustAnchor> {
        private static final CertificatePriorityComparator CERT_COMPARATOR = new CertificatePriorityComparator();

        private TrustAnchorComparator() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(TrustAnchor trustAnchor, TrustAnchor trustAnchor2) {
            return CERT_COMPARATOR.compare(trustAnchor.getTrustedCert(), trustAnchor2.getTrustedCert());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class ExtendedKeyUsagePKIXCertPathChecker extends PKIXCertPathChecker {
        private static final String EKU_anyExtendedKeyUsage = "2.5.29.37.0";
        private static final String EKU_clientAuth = "1.3.6.1.5.5.7.3.2";
        private static final String EKU_msSGC = "1.3.6.1.4.1.311.10.3.3";
        private static final String EKU_nsSGC = "2.16.840.1.113730.4.1";
        private static final String EKU_serverAuth = "1.3.6.1.5.5.7.3.1";
        private final boolean clientAuth;
        private final X509Certificate leaf;
        private static final String EKU_OID = "2.5.29.37";
        private static final Set<String> SUPPORTED_EXTENSIONS = Collections.unmodifiableSet(new HashSet(Arrays.asList(EKU_OID)));

        private ExtendedKeyUsagePKIXCertPathChecker(boolean z, X509Certificate x509Certificate) {
            this.clientAuth = z;
            this.leaf = x509Certificate;
        }

        @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
        public void init(boolean z) throws CertPathValidatorException {
        }

        @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
        public boolean isForwardCheckingSupported() {
            return true;
        }

        @Override // java.security.cert.PKIXCertPathChecker
        public Set<String> getSupportedExtensions() {
            return SUPPORTED_EXTENSIONS;
        }

        @Override // java.security.cert.PKIXCertPathChecker
        public void check(Certificate certificate, Collection<String> collection) throws CertPathValidatorException {
            boolean z;
            if (certificate == this.leaf) {
                try {
                    List<String> extendedKeyUsage = this.leaf.getExtendedKeyUsage();
                    if (extendedKeyUsage != null) {
                        Iterator<String> it = extendedKeyUsage.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            String next = it.next();
                            if (next.equals(EKU_anyExtendedKeyUsage)) {
                                z = true;
                                break;
                            } else if (this.clientAuth) {
                                if (next.equals(EKU_clientAuth)) {
                                    z = true;
                                    break;
                                }
                            } else if (next.equals(EKU_serverAuth)) {
                                z = true;
                                break;
                            } else if (next.equals(EKU_nsSGC)) {
                                z = true;
                                break;
                            } else if (next.equals(EKU_msSGC)) {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            collection.remove(EKU_OID);
                            return;
                        }
                        throw new CertPathValidatorException("End-entity certificate does not have a valid extendedKeyUsage.");
                    }
                } catch (CertificateParsingException e) {
                    throw new CertPathValidatorException(e);
                }
            }
        }
    }

    private Set<TrustAnchor> findAllTrustAnchorsByIssuerAndSignature(X509Certificate x509Certificate) {
        Set<TrustAnchor> findAllByIssuerAndSignature = this.trustedCertificateIndex.findAllByIssuerAndSignature(x509Certificate);
        if (findAllByIssuerAndSignature.isEmpty() && this.trustedCertificateStore != null) {
            Set<X509Certificate> findAllIssuers = this.trustedCertificateStore.findAllIssuers(x509Certificate);
            if (!findAllIssuers.isEmpty()) {
                HashSet hashSet = new HashSet(findAllIssuers.size());
                for (X509Certificate x509Certificate2 : findAllIssuers) {
                    hashSet.add(this.trustedCertificateIndex.index(x509Certificate2));
                }
                return hashSet;
            }
            return findAllByIssuerAndSignature;
        }
        return findAllByIssuerAndSignature;
    }

    private TrustAnchor findTrustAnchorBySubjectAndPublicKey(X509Certificate x509Certificate) {
        X509Certificate trustAnchor;
        TrustAnchor findBySubjectAndPublicKey = this.trustedCertificateIndex.findBySubjectAndPublicKey(x509Certificate);
        if (findBySubjectAndPublicKey == null) {
            if (this.trustedCertificateStore != null && (trustAnchor = this.trustedCertificateStore.getTrustAnchor(x509Certificate)) != null) {
                return new TrustAnchor(trustAnchor, null);
            }
            return null;
        }
        return findBySubjectAndPublicKey;
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.acceptedIssuers != null ? (X509Certificate[]) this.acceptedIssuers.clone() : acceptedIssuers(this.rootKeyStore);
    }

    public void setCTEnabledOverride(boolean z) {
        this.ctEnabledOverride = z;
    }

    public void setCTVerifier(CTVerifier cTVerifier) {
        this.ctVerifier = cTVerifier;
    }

    public void setCTPolicy(CTPolicy cTPolicy) {
        this.ctPolicy = cTPolicy;
    }
}
