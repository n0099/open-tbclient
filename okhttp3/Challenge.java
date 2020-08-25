package okhttp3;

import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
/* loaded from: classes9.dex */
public final class Challenge {
    private final Charset charset;
    private final String realm;
    private final String scheme;

    public Challenge(String str, String str2) {
        this(str, str2, Util.ISO_8859_1);
    }

    private Challenge(String str, String str2, Charset charset) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (str2 == null) {
            throw new NullPointerException("realm == null");
        }
        if (charset == null) {
            throw new NullPointerException("charset == null");
        }
        this.scheme = str;
        this.realm = str2;
        this.charset = charset;
    }

    public Challenge withCharset(Charset charset) {
        return new Challenge(this.scheme, this.realm, charset);
    }

    public String scheme() {
        return this.scheme;
    }

    public String realm() {
        return this.realm;
    }

    public Charset charset() {
        return this.charset;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Challenge) && ((Challenge) obj).scheme.equals(this.scheme) && ((Challenge) obj).realm.equals(this.realm) && ((Challenge) obj).charset.equals(this.charset);
    }

    public int hashCode() {
        return ((((this.realm.hashCode() + 899) * 31) + this.scheme.hashCode()) * 31) + this.charset.hashCode();
    }

    public String toString() {
        return this.scheme + " realm=\"" + this.realm + "\" charset=\"" + this.charset + "\"";
    }
}
