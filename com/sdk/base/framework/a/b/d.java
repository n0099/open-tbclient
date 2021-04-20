package com.sdk.base.framework.a.b;

import com.sdk.base.framework.c.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Boolean f38703a = Boolean.valueOf(f.f38809b);

    /* JADX WARN: Removed duplicated region for block: B:29:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(HttpURLConnection httpURLConnection, c cVar, String str) {
        StringBuilder sb;
        if (httpURLConnection != null) {
            long j = 0;
            try {
                long contentLength = httpURLConnection.getContentLength();
                if (cVar != null && !cVar.a(contentLength, 0L, true)) {
                    return null;
                }
                sb = new StringBuilder();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), str));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append('\n');
                        j += com.sdk.base.framework.a.a.c.a(readLine, str);
                        if (cVar != null && !cVar.a(contentLength, j, false)) {
                            break;
                        }
                    }
                    long j2 = j;
                    if (cVar != null) {
                        cVar.a(contentLength, j2, true);
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.sdk.base.framework.a.a.c.b("StringDownloadHandler", e.getMessage(), f38703a);
                    if (sb != null) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                sb = null;
            }
        } else {
            sb = null;
        }
        if (sb != null) {
            return null;
        }
        return sb.toString().trim();
    }
}
