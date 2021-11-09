package com.meizu.cloud.pushsdk.b.c;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f67304a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f67305b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c  reason: collision with root package name */
    public final String f67306c;

    /* renamed from: d  reason: collision with root package name */
    public final String f67307d;

    /* renamed from: e  reason: collision with root package name */
    public final String f67308e;

    /* renamed from: f  reason: collision with root package name */
    public final String f67309f;

    public g(String str, String str2, String str3, String str4) {
        this.f67306c = str;
        this.f67307d = str2;
        this.f67308e = str3;
        this.f67309f = str4;
    }

    public static g a(String str) {
        Matcher matcher = f67304a.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            Matcher matcher2 = f67305b.matcher(str);
            String str2 = null;
            for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
                matcher2.region(end, str.length());
                if (!matcher2.lookingAt()) {
                    return null;
                }
                String group = matcher2.group(1);
                if (group != null && group.equalsIgnoreCase("charset")) {
                    String group2 = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                    if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                        throw new IllegalArgumentException("Multiple different charsets: " + str);
                    }
                    str2 = group2;
                }
            }
            return new g(str, lowerCase, lowerCase2, str2);
        }
        return null;
    }

    public String a() {
        return this.f67307d;
    }

    public Charset b() {
        String str = this.f67309f;
        if (str != null) {
            return Charset.forName(str);
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && ((g) obj).f67306c.equals(this.f67306c);
    }

    public int hashCode() {
        return this.f67306c.hashCode();
    }

    public String toString() {
        return this.f67306c;
    }
}
