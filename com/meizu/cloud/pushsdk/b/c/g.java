package com.meizu.cloud.pushsdk.b.c;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f74905a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f74906b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c  reason: collision with root package name */
    public final String f74907c;

    /* renamed from: d  reason: collision with root package name */
    public final String f74908d;

    /* renamed from: e  reason: collision with root package name */
    public final String f74909e;

    /* renamed from: f  reason: collision with root package name */
    public final String f74910f;

    public g(String str, String str2, String str3, String str4) {
        this.f74907c = str;
        this.f74908d = str2;
        this.f74909e = str3;
        this.f74910f = str4;
    }

    public static g a(String str) {
        Matcher matcher = f74905a.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            Matcher matcher2 = f74906b.matcher(str);
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
        return this.f74908d;
    }

    public Charset b() {
        String str = this.f74910f;
        if (str != null) {
            return Charset.forName(str);
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && ((g) obj).f74907c.equals(this.f74907c);
    }

    public int hashCode() {
        return this.f74907c.hashCode();
    }

    public String toString() {
        return this.f74907c;
    }
}
