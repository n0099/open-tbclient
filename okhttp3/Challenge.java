package okhttp3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
/* loaded from: classes9.dex */
public final class Challenge {
    public final Map<String, String> authParams;
    public final String scheme;

    public Challenge(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                this.scheme = str;
                this.authParams = Collections.singletonMap("realm", str2);
                return;
            }
            throw new NullPointerException("realm == null");
        }
        throw new NullPointerException("scheme == null");
    }

    public Challenge(String str, Map<String, String> map) {
        String lowerCase;
        if (str != null) {
            if (map != null) {
                this.scheme = str;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey() == null) {
                        lowerCase = null;
                    } else {
                        lowerCase = entry.getKey().toLowerCase(Locale.US);
                    }
                    linkedHashMap.put(lowerCase, entry.getValue());
                }
                this.authParams = Collections.unmodifiableMap(linkedHashMap);
                return;
            }
            throw new NullPointerException("authParams == null");
        }
        throw new NullPointerException("scheme == null");
    }

    public Map<String, String> authParams() {
        return this.authParams;
    }

    public Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return Util.ISO_8859_1;
    }

    public int hashCode() {
        return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    public String realm() {
        return this.authParams.get("realm");
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (challenge.scheme.equals(this.scheme) && challenge.authParams.equals(this.authParams)) {
                return true;
            }
        }
        return false;
    }

    public Challenge withCharset(Charset charset) {
        if (charset != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.authParams);
            linkedHashMap.put("charset", charset.name());
            return new Challenge(this.scheme, linkedHashMap);
        }
        throw new NullPointerException("charset == null");
    }
}
