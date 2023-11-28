package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.ap;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class d {
    public static final Pattern aAK = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    public static final Pattern aAL = Pattern.compile("GET /(.*) HTTP");
    public final long aAM;
    public final boolean aAN;
    public final String uri;

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.aAM + ", partial=" + this.aAN + ", uri='" + this.uri + "'}";
    }

    public d(String str) {
        boolean z;
        ap.fZ(str);
        long ed = ed(str);
        this.aAM = Math.max(0L, ed);
        if (ed >= 0) {
            z = true;
        } else {
            z = false;
        }
        this.aAN = z;
        this.uri = ee(str);
    }

    public static d b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb.append(readLine);
                sb.append('\n');
            } else {
                return new d(sb.toString());
            }
        }
    }

    public static long ed(String str) {
        Matcher matcher = aAK.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    public static String ee(String str) {
        Matcher matcher = aAL.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }
}
