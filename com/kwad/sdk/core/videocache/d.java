package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f58474d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f58475e = Pattern.compile("GET /(.*) HTTP");
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f58476b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f58477c;

    public d(String str) {
        j.a(str);
        long a = a(str);
        this.f58476b = Math.max(0L, a);
        this.f58477c = a >= 0;
        this.a = b(str);
    }

    private long a(String str) {
        Matcher matcher = f58474d.matcher(str);
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
        Matcher matcher = f58475e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f58476b + ", partial=" + this.f58477c + ", uri='" + this.a + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
