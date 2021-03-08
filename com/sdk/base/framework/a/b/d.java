package com.sdk.base.framework.a.b;

import com.sdk.base.framework.c.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Boolean f7605a = Boolean.valueOf(f.b);

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(HttpURLConnection httpURLConnection, c cVar, String str) {
        Exception e;
        StringBuilder sb;
        StringBuilder sb2;
        if (httpURLConnection != null) {
            try {
                long contentLength = httpURLConnection.getContentLength();
                if (cVar != null && !cVar.a(contentLength, 0L, true)) {
                    return null;
                }
                sb2 = new StringBuilder();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), str));
                    long j = 0;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine).append('\n');
                        j += com.sdk.base.framework.a.a.c.a(readLine, str);
                        if (cVar != null && !cVar.a(contentLength, j, false)) {
                            break;
                        }
                    }
                    if (cVar != null) {
                        cVar.a(contentLength, j, true);
                    }
                } catch (Exception e2) {
                    e = e2;
                    sb = sb2;
                    com.sdk.base.framework.a.a.c.b("StringDownloadHandler", e.getMessage(), f7605a);
                    if (sb == null) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                sb = null;
            }
        } else {
            sb2 = null;
        }
        sb = sb2;
        if (sb == null) {
            return sb.toString().trim();
        }
        return null;
    }
}
