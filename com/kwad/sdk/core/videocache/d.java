package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f34458d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f34459e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a  reason: collision with root package name */
    public final String f34460a;

    /* renamed from: b  reason: collision with root package name */
    public final long f34461b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f34462c;

    public d(String str) {
        j.a(str);
        long a2 = a(str);
        this.f34461b = Math.max(0L, a2);
        this.f34462c = a2 >= 0;
        this.f34460a = b(str);
    }

    private long a(String str) {
        Matcher matcher = f34458d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    public static d a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new d(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    private String b(String str) {
        Matcher matcher = f34459e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f34461b + ", partial=" + this.f34462c + ", uri='" + this.f34460a + "'}";
    }
}
