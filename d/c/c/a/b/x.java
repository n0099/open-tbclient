package d.c.c.a.b;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class x {

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f66402c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f66403d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a  reason: collision with root package name */
    public final String f66404a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66405b;

    public x(String str, String str2, String str3, String str4) {
        this.f66404a = str;
        this.f66405b = str4;
    }

    public static x a(String str) {
        Matcher matcher = f66402c.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            Matcher matcher2 = f66403d.matcher(str);
            String str2 = null;
            for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
                matcher2.region(end, str.length());
                if (!matcher2.lookingAt()) {
                    return null;
                }
                String group = matcher2.group(1);
                if (group != null && group.equalsIgnoreCase("charset")) {
                    String group2 = matcher2.group(2);
                    if (group2 != null) {
                        if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                            group2 = group2.substring(1, group2.length() - 1);
                        }
                    } else {
                        group2 = matcher2.group(3);
                    }
                    if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                        return null;
                    }
                    str2 = group2;
                }
            }
            return new x(str, lowerCase, lowerCase2, str2);
        }
        return null;
    }

    public Charset b() {
        return c(null);
    }

    public Charset c(Charset charset) {
        try {
            return this.f66405b != null ? Charset.forName(this.f66405b) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof x) && ((x) obj).f66404a.equals(this.f66404a);
    }

    public int hashCode() {
        return this.f66404a.hashCode();
    }

    public String toString() {
        return this.f66404a;
    }
}
