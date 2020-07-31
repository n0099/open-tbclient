package kascend.core.utils;

import android.support.media.ExifInterface;
import java.security.Provider;
/* loaded from: classes12.dex */
public final class CryptoProvider extends Provider {
    public CryptoProvider() {
        super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
        put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
        put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
    }
}
