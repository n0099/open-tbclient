package org.conscrypt;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class SSLParametersImpl implements Cloneable {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static volatile SSLParametersImpl defaultParameters;
    private static volatile X509KeyManager defaultX509KeyManager;
    private static volatile X509TrustManager defaultX509TrustManager;
    ApplicationProtocolSelectorAdapter applicationProtocolSelector;
    boolean channelIdEnabled;
    private final ClientSessionContext clientSessionContext;
    private boolean ctVerificationEnabled;
    String[] enabledCipherSuites;
    String[] enabledProtocols;
    private String endpointIdentificationAlgorithm;
    boolean isEnabledProtocolsFiltered;
    byte[] ocspResponse;
    private final PSKKeyManager pskKeyManager;
    byte[] sctExtension;
    private final ServerSessionContext serverSessionContext;
    private boolean useCipherSuitesOrder;
    boolean useSessionTickets;
    private Boolean useSni;
    private final X509KeyManager x509KeyManager;
    private final X509TrustManager x509TrustManager;
    private boolean client_mode = true;
    private boolean need_client_auth = false;
    private boolean want_client_auth = false;
    private boolean enable_session_creation = true;
    byte[] applicationProtocols = EmptyArray.BYTE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface AliasChooser {
        String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr);

        String chooseServerAlias(X509KeyManager x509KeyManager, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface PSKCallbacks {
        String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str);

        String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager);

        SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SSLParametersImpl(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom, ClientSessionContext clientSessionContext, ServerSessionContext serverSessionContext, String[] strArr) throws KeyManagementException {
        this.serverSessionContext = serverSessionContext;
        this.clientSessionContext = clientSessionContext;
        if (keyManagerArr == null) {
            this.x509KeyManager = getDefaultX509KeyManager();
            this.pskKeyManager = null;
        } else {
            this.x509KeyManager = findFirstX509KeyManager(keyManagerArr);
            this.pskKeyManager = findFirstPSKKeyManager(keyManagerArr);
        }
        if (trustManagerArr == null) {
            this.x509TrustManager = getDefaultX509TrustManager();
        } else {
            this.x509TrustManager = findFirstX509TrustManager(trustManagerArr);
        }
        this.enabledProtocols = (String[]) NativeCrypto.checkEnabledProtocols(strArr == null ? NativeCrypto.DEFAULT_PROTOCOLS : strArr).clone();
        this.enabledCipherSuites = getDefaultCipherSuites((this.x509KeyManager == null && this.x509TrustManager == null) ? false : true, this.pskKeyManager != null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SSLParametersImpl getDefault() throws KeyManagementException {
        SSLParametersImpl sSLParametersImpl = defaultParameters;
        if (sSLParametersImpl == null) {
            sSLParametersImpl = new SSLParametersImpl(null, null, null, new ClientSessionContext(), new ServerSessionContext(), null);
            defaultParameters = sSLParametersImpl;
        }
        return (SSLParametersImpl) sSLParametersImpl.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractSessionContext getSessionContext() {
        return this.client_mode ? this.clientSessionContext : this.serverSessionContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientSessionContext getClientSessionContext() {
        return this.clientSessionContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509KeyManager getX509KeyManager() {
        return this.x509KeyManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PSKKeyManager getPSKKeyManager() {
        return this.pskKeyManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getEnabledCipherSuites() {
        return (String[]) this.enabledCipherSuites.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnabledCipherSuites(String[] strArr) {
        this.enabledCipherSuites = (String[]) NativeCrypto.checkEnabledCipherSuites(strArr).clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getEnabledProtocols() {
        return (String[]) this.enabledProtocols.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnabledProtocols(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        String[] filterFromProtocols = filterFromProtocols(strArr, "SSLv3");
        this.isEnabledProtocolsFiltered = strArr.length != filterFromProtocols.length;
        this.enabledProtocols = (String[]) NativeCrypto.checkEnabledProtocols(filterFromProtocols).clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setApplicationProtocols(String[] strArr) {
        this.applicationProtocols = SSLUtils.encodeProtocols(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getApplicationProtocols() {
        return SSLUtils.decodeProtocols(this.applicationProtocols);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.applicationProtocolSelector = applicationProtocolSelectorAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUseClientMode(boolean z) {
        this.client_mode = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getUseClientMode() {
        return this.client_mode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNeedClientAuth(boolean z) {
        this.need_client_auth = z;
        this.want_client_auth = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getNeedClientAuth() {
        return this.need_client_auth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWantClientAuth(boolean z) {
        this.want_client_auth = z;
        this.need_client_auth = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getWantClientAuth() {
        return this.want_client_auth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnableSessionCreation(boolean z) {
        this.enable_session_creation = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getEnableSessionCreation() {
        return this.enable_session_creation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUseSessionTickets(boolean z) {
        this.useSessionTickets = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUseSni(boolean z) {
        this.useSni = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getUseSni() {
        return this.useSni != null ? this.useSni.booleanValue() : isSniEnabledByDefault();
    }

    void setCTVerificationEnabled(boolean z) {
        this.ctVerificationEnabled = z;
    }

    void setSCTExtension(byte[] bArr) {
        this.sctExtension = bArr;
    }

    void setOCSPResponse(byte[] bArr) {
        this.ocspResponse = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getOCSPResponse() {
        return this.ocspResponse;
    }

    private static String[] filterFromProtocols(String[] strArr, String str) {
        if (strArr.length == 1 && str.equals(strArr[0])) {
            return EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            if (!str.equals(str2)) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(EMPTY_STRING_ARRAY);
    }

    private boolean isSniEnabledByDefault() {
        try {
            String property = System.getProperty("jsse.enableSNIExtension", "true");
            if ("true".equalsIgnoreCase(property)) {
                return true;
            }
            if ("false".equalsIgnoreCase(property)) {
                return false;
            }
            throw new RuntimeException("Can only set \"jsse.enableSNIExtension\" to \"true\" or \"false\"");
        } catch (SecurityException e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    private static X509KeyManager getDefaultX509KeyManager() throws KeyManagementException {
        X509KeyManager x509KeyManager = defaultX509KeyManager;
        if (x509KeyManager == null) {
            X509KeyManager createDefaultX509KeyManager = createDefaultX509KeyManager();
            defaultX509KeyManager = createDefaultX509KeyManager;
            return createDefaultX509KeyManager;
        }
        return x509KeyManager;
    }

    private static X509KeyManager createDefaultX509KeyManager() throws KeyManagementException {
        try {
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(null, null);
            KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
            X509KeyManager findFirstX509KeyManager = findFirstX509KeyManager(keyManagers);
            if (findFirstX509KeyManager == null) {
                throw new KeyManagementException("No X509KeyManager among default KeyManagers: " + Arrays.toString(keyManagers));
            }
            return findFirstX509KeyManager;
        } catch (KeyStoreException e) {
            throw new KeyManagementException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new KeyManagementException(e2);
        } catch (UnrecoverableKeyException e3) {
            throw new KeyManagementException(e3);
        }
    }

    private static X509KeyManager findFirstX509KeyManager(KeyManager[] keyManagerArr) {
        for (KeyManager keyManager : keyManagerArr) {
            if (keyManager instanceof X509KeyManager) {
                return (X509KeyManager) keyManager;
            }
        }
        return null;
    }

    private static PSKKeyManager findFirstPSKKeyManager(KeyManager[] keyManagerArr) {
        for (KeyManager keyManager : keyManagerArr) {
            if (keyManager instanceof PSKKeyManager) {
                return (PSKKeyManager) keyManager;
            }
            if (keyManager != null) {
                try {
                    return DuckTypedPSKKeyManager.getInstance(keyManager);
                } catch (NoSuchMethodException e) {
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static X509TrustManager getDefaultX509TrustManager() throws KeyManagementException {
        X509TrustManager x509TrustManager = defaultX509TrustManager;
        if (x509TrustManager == null) {
            X509TrustManager createDefaultX509TrustManager = createDefaultX509TrustManager();
            defaultX509TrustManager = createDefaultX509TrustManager;
            return createDefaultX509TrustManager;
        }
        return x509TrustManager;
    }

    private static X509TrustManager createDefaultX509TrustManager() throws KeyManagementException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            X509TrustManager findFirstX509TrustManager = findFirstX509TrustManager(trustManagers);
            if (findFirstX509TrustManager == null) {
                throw new KeyManagementException("No X509TrustManager in among default TrustManagers: " + Arrays.toString(trustManagers));
            }
            return findFirstX509TrustManager;
        } catch (KeyStoreException e) {
            throw new KeyManagementException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new KeyManagementException(e2);
        }
    }

    private static X509TrustManager findFirstX509TrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getEndpointIdentificationAlgorithm() {
        return this.endpointIdentificationAlgorithm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEndpointIdentificationAlgorithm(String str) {
        this.endpointIdentificationAlgorithm = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getUseCipherSuitesOrder() {
        return this.useCipherSuitesOrder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUseCipherSuitesOrder(boolean z) {
        this.useCipherSuitesOrder = z;
    }

    private static String[] getDefaultCipherSuites(boolean z, boolean z2) {
        return z ? z2 ? concat(NativeCrypto.DEFAULT_PSK_CIPHER_SUITES, NativeCrypto.DEFAULT_X509_CIPHER_SUITES, new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"}) : concat(NativeCrypto.DEFAULT_X509_CIPHER_SUITES, new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"}) : z2 ? concat(NativeCrypto.DEFAULT_PSK_CIPHER_SUITES, new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"}) : new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};
    }

    private static String[] concat(String[]... strArr) {
        int i = 0;
        for (String[] strArr2 : strArr) {
            i += strArr2.length;
        }
        String[] strArr3 = new String[i];
        int i2 = 0;
        for (String[] strArr4 : strArr) {
            System.arraycopy(strArr4, 0, strArr3, i2, strArr4.length);
            i2 += strArr4.length;
        }
        return strArr3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCTVerificationEnabled(String str) {
        if (str == null) {
            return false;
        }
        if (this.ctVerificationEnabled) {
            return true;
        }
        return Platform.isCTVerificationRequired(str);
    }
}
