package org.conscrypt;

import java.math.BigInteger;
import java.security.PublicKey;
/* loaded from: classes7.dex */
public interface CertBlacklist {
    boolean isPublicKeyBlackListed(PublicKey publicKey);

    boolean isSerialNumberBlackListed(BigInteger bigInteger);
}
