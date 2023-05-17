package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.am;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public final class d {
    public static final Pattern aem = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    public static final Pattern aen = Pattern.compile("GET /(.*) HTTP");
    public final long aeo;
    public final boolean aep;
    public final String uri;

    public d(String str) {
        am.dQ(str);
        long cy = cy(str);
        this.aeo = Math.max(0L, cy);
        this.aep = cy >= 0;
        this.uri = cz(str);
    }

    public static d c(InputStream inputStream) {
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

    public static long cy(String str) {
        Matcher matcher = aem.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    public static String cz(String str) {
        Matcher matcher = aen.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.aeo + ", partial=" + this.aep + ", uri='" + this.uri + "'}";
    }
}
