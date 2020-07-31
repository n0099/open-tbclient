package org.conscrypt;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes5.dex */
public final class CertificatePriorityComparator implements Comparator<X509Certificate> {
    private static final Integer PRIORITY_MD5 = 6;
    private static final Integer PRIORITY_SHA1 = 5;
    private static final Integer PRIORITY_SHA224 = 4;
    private static final Integer PRIORITY_SHA256 = 3;
    private static final Integer PRIORITY_SHA384 = 2;
    private static final Integer PRIORITY_SHA512 = 1;
    private static final Integer PRIORITY_UNKNOWN = -1;
    private static final Map<String, Integer> ALGORITHM_OID_PRIORITY_MAP = new HashMap();

    static {
        ALGORITHM_OID_PRIORITY_MAP.put("1.2.840.113549.1.1.13", PRIORITY_SHA512);
        ALGORITHM_OID_PRIORITY_MAP.put("1.2.840.113549.1.1.12", PRIORITY_SHA384);
        ALGORITHM_OID_PRIORITY_MAP.put("1.2.840.113549.1.1.11", PRIORITY_SHA256);
        ALGORITHM_OID_PRIORITY_MAP.put("1.2.840.113549.1.1.14", PRIORITY_SHA224);
        ALGORITHM_OID_PRIORITY_MAP.put("1.2.840.113549.1.1.5", PRIORITY_SHA1);
        ALGORITHM_OID_PRIORITY_MAP.put("1.2.840.113549.1.1.4", PRIORITY_MD5);
        ALGORITHM_OID_PRIORITY_MAP.put("1.2.840.10045.4.3.4", PRIORITY_SHA512);
        ALGORITHM_OID_PRIORITY_MAP.put("1.2.840.10045.4.3.3", PRIORITY_SHA384);
        ALGORITHM_OID_PRIORITY_MAP.put("1.2.840.10045.4.3.2", PRIORITY_SHA256);
        ALGORITHM_OID_PRIORITY_MAP.put("1.2.840.10045.4.3.1", PRIORITY_SHA224);
        ALGORITHM_OID_PRIORITY_MAP.put("1.2.840.10045.4.1", PRIORITY_SHA1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        boolean equals = x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
        boolean equals2 = x509Certificate2.getSubjectDN().equals(x509Certificate2.getIssuerDN());
        if (equals != equals2) {
            return equals2 ? 1 : -1;
        }
        int compareStrength = compareStrength(x509Certificate2, x509Certificate);
        if (compareStrength == 0) {
            int compareTo = x509Certificate2.getNotAfter().compareTo(x509Certificate.getNotAfter());
            if (compareTo == 0) {
                return x509Certificate2.getNotBefore().compareTo(x509Certificate.getNotBefore());
            }
            return compareTo;
        }
        return compareStrength;
    }

    private int compareStrength(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        PublicKey publicKey = x509Certificate.getPublicKey();
        PublicKey publicKey2 = x509Certificate2.getPublicKey();
        int compareKeyAlgorithm = compareKeyAlgorithm(publicKey, publicKey2);
        if (compareKeyAlgorithm == 0) {
            int compareKeySize = compareKeySize(publicKey, publicKey2);
            return compareKeySize == 0 ? compareSignatureAlgorithm(x509Certificate, x509Certificate2) : compareKeySize;
        }
        return compareKeyAlgorithm;
    }

    private int compareKeyAlgorithm(PublicKey publicKey, PublicKey publicKey2) {
        String upperCase = publicKey.getAlgorithm().toUpperCase(Locale.US);
        if (upperCase.equals(publicKey2.getAlgorithm().toUpperCase(Locale.US))) {
            return 0;
        }
        if ("EC".equals(upperCase)) {
            return 1;
        }
        return -1;
    }

    private int compareKeySize(PublicKey publicKey, PublicKey publicKey2) {
        if (!publicKey.getAlgorithm().toUpperCase(Locale.US).equals(publicKey2.getAlgorithm().toUpperCase(Locale.US))) {
            throw new IllegalArgumentException("Keys are not of the same type");
        }
        return getKeySize(publicKey) - getKeySize(publicKey2);
    }

    private int getKeySize(PublicKey publicKey) {
        if (publicKey instanceof ECPublicKey) {
            return ((ECPublicKey) publicKey).getParams().getCurve().getField().getFieldSize();
        }
        if (publicKey instanceof RSAPublicKey) {
            return ((RSAPublicKey) publicKey).getModulus().bitLength();
        }
        throw new IllegalArgumentException("Unsupported public key type: " + publicKey.getClass().getName());
    }

    private int compareSignatureAlgorithm(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        Integer num = ALGORITHM_OID_PRIORITY_MAP.get(x509Certificate.getSigAlgOID());
        Integer num2 = ALGORITHM_OID_PRIORITY_MAP.get(x509Certificate2.getSigAlgOID());
        if (num == null) {
            num = PRIORITY_UNKNOWN;
        }
        if (num2 == null) {
            num2 = PRIORITY_UNKNOWN;
        }
        return num2.intValue() - num.intValue();
    }
}
