package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.aj;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class d {
    public static final Pattern d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    public static final Pattern e = Pattern.compile("GET /(.*) HTTP");
    public final String a;
    public final long b;
    public final boolean c;

    public d(String str) {
        aj.a(str);
        long a = a(str);
        this.b = Math.max(0L, a);
        this.c = a >= 0;
        this.a = b(str);
    }

    public static long a(String str) {
        Matcher matcher = d.matcher(str);
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

    public static String b(String str) {
        Matcher matcher = e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.b + ", partial=" + this.c + ", uri='" + this.a + "'}";
    }
}
