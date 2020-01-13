package org.conscrypt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
/* loaded from: classes5.dex */
public final class DefaultSSLContextImpl extends OpenSSLContextImpl {
    private static KeyManager[] KEY_MANAGERS;
    private static TrustManager[] TRUST_MANAGERS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyManager[] getKeyManagers() throws GeneralSecurityException, IOException {
        BufferedInputStream bufferedInputStream = null;
        if (KEY_MANAGERS != null) {
            return KEY_MANAGERS;
        }
        String property = System.getProperty("javax.net.ssl.keyStore");
        if (property == null) {
            return null;
        }
        String property2 = System.getProperty("javax.net.ssl.keyStorePassword");
        char[] charArray = property2 == null ? null : property2.toCharArray();
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(property));
            try {
                keyStore.load(bufferedInputStream2, charArray);
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, charArray);
                KEY_MANAGERS = keyManagerFactory.getKeyManagers();
                return KEY_MANAGERS;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrustManager[] getTrustManagers() throws GeneralSecurityException, IOException {
        BufferedInputStream bufferedInputStream = null;
        if (TRUST_MANAGERS != null) {
            return TRUST_MANAGERS;
        }
        String property = System.getProperty("javax.net.ssl.trustStore");
        if (property == null) {
            return null;
        }
        String property2 = System.getProperty("javax.net.ssl.trustStorePassword");
        char[] charArray = property2 == null ? null : property2.toCharArray();
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(property));
            try {
                keyStore.load(bufferedInputStream2, charArray);
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                TRUST_MANAGERS = trustManagerFactory.getTrustManagers();
                return TRUST_MANAGERS;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // org.conscrypt.OpenSSLContextImpl, javax.net.ssl.SSLContextSpi
    public void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) throws KeyManagementException {
        throw new KeyManagementException("Do not init() the default SSLContext ");
    }
}
