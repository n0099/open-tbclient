package org.conscrypt;

import com.baidu.android.common.security.RSAUtil;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes11.dex */
final class CryptoUpcalls {
    private static final Logger logger = Logger.getLogger(CryptoUpcalls.class.getName());

    private CryptoUpcalls() {
    }

    private static ArrayList<Provider> getExternalProviders(String str) {
        Provider[] providers;
        ArrayList<Provider> arrayList = new ArrayList<>(1);
        for (Provider provider : Security.getProviders(str)) {
            if (!Conscrypt.isConscrypt(provider)) {
                arrayList.add(provider);
            }
        }
        if (arrayList.isEmpty()) {
            logger.warning("Could not find external provider for algorithm: " + str);
        }
        return arrayList;
    }

    static byte[] rawSignDigestWithPrivateKey(PrivateKey privateKey, byte[] bArr) {
        String str;
        Signature signature;
        String algorithm = privateKey.getAlgorithm();
        if (RSAUtil.ALGORITHM_RSA.equals(algorithm)) {
            str = "NONEwithRSA";
        } else if ("EC".equals(algorithm)) {
            str = "NONEwithECDSA";
        } else {
            throw new RuntimeException("Unexpected key type: " + privateKey.toString());
        }
        try {
            signature = Signature.getInstance(str);
            signature.initSign(privateKey);
            if (Conscrypt.isConscrypt(signature.getProvider())) {
                signature = null;
            }
        } catch (InvalidKeyException e) {
            logger.warning("Preferred provider doesn't support key:");
            e.printStackTrace();
            signature = null;
        } catch (NoSuchAlgorithmException e2) {
            logger.warning("Unsupported signature algorithm: " + str);
            return null;
        }
        if (signature == null) {
            Iterator<Provider> it = getExternalProviders("Signature." + str).iterator();
            while (it.hasNext()) {
                try {
                    signature = Signature.getInstance(str, it.next());
                    signature.initSign(privateKey);
                    break;
                } catch (InvalidKeyException | NoSuchAlgorithmException e3) {
                    signature = null;
                }
            }
            if (signature == null) {
                logger.warning("Could not find provider for algorithm: " + str);
                return null;
            }
        }
        try {
            signature.update(bArr);
            return signature.sign();
        } catch (Exception e4) {
            logger.log(Level.WARNING, "Exception while signing message with " + privateKey.getAlgorithm() + " private key:", (Throwable) e4);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static byte[] rsaDecryptWithPrivateKey(PrivateKey privateKey, int i, byte[] bArr) {
        String str;
        Cipher cipher;
        String algorithm = privateKey.getAlgorithm();
        if (!RSAUtil.ALGORITHM_RSA.equals(algorithm)) {
            logger.warning("Unexpected key type: " + algorithm);
            return null;
        }
        switch (i) {
            case 1:
                str = "PKCS1Padding";
                break;
            case 2:
            default:
                logger.warning("Unsupported OpenSSL/BoringSSL padding: " + i);
                return null;
            case 3:
                str = "NoPadding";
                break;
            case 4:
                str = "OAEPPadding";
                break;
        }
        String str2 = "RSA/ECB/" + str;
        try {
            cipher = Cipher.getInstance(str2);
            cipher.init(2, privateKey);
            if (Conscrypt.isConscrypt(cipher.getProvider())) {
                cipher = null;
            }
        } catch (InvalidKeyException e) {
            logger.log(Level.WARNING, "Preferred provider doesn't support key:", (Throwable) e);
            cipher = null;
        } catch (NoSuchAlgorithmException e2) {
            logger.warning("Unsupported cipher algorithm: " + str2);
            return null;
        } catch (NoSuchPaddingException e3) {
            logger.warning("Unsupported cipher algorithm: " + str2);
            return null;
        }
        if (cipher == null) {
            Iterator<Provider> it = getExternalProviders("Cipher." + str2).iterator();
            while (it.hasNext()) {
                try {
                    cipher = Cipher.getInstance(str2, it.next());
                    cipher.init(2, privateKey);
                    if (cipher == null) {
                        logger.warning("Could not find provider for algorithm: " + str2);
                        return null;
                    }
                } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e4) {
                    cipher = null;
                }
            }
            if (cipher == null) {
            }
        }
        try {
            return cipher.doFinal(bArr);
        } catch (Exception e5) {
            logger.log(Level.WARNING, "Exception while decrypting message with " + privateKey.getAlgorithm() + " private key using " + str2 + ":", (Throwable) e5);
            return null;
        }
    }
}
