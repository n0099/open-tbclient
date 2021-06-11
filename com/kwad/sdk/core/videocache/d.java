package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f34809d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f34810e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a  reason: collision with root package name */
    public final String f34811a;

    /* renamed from: b  reason: collision with root package name */
    public final long f34812b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f34813c;

    public d(String str) {
        j.a(str);
        long a2 = a(str);
        this.f34812b = Math.max(0L, a2);
        this.f34813c = a2 >= 0;
        this.f34811a = b(str);
    }

    private long a(String str) {
        Matcher matcher = f34809d.matcher(str);
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
        Matcher matcher = f34810e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f34812b + ", partial=" + this.f34813c + ", uri='" + this.f34811a + "'}";
    }
}
