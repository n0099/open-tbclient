package com.qq.e.comm.plugin.j.b.a;

import android.text.TextUtils;
import com.baidubce.http.Headers;
import com.qq.e.comm.plugin.t.j;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f12161a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12162b;
    private final boolean c;

    public b(int i, int i2, boolean z) {
        this.f12161a = i;
        this.f12162b = i2;
        this.c = z;
    }

    private String a(long j, long j2) {
        if (j >= 0) {
            return j2 > 0 ? "bytes=" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((j + j2) - 1) : "bytes=" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        return null;
    }

    private HttpURLConnection b(String str, long j, long j2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestProperty("User-Agent", j.f12541a);
        httpURLConnection.setConnectTimeout(this.f12161a);
        httpURLConnection.setReadTimeout(this.f12162b);
        if (this.c) {
            String a2 = a(j, j2);
            if (!TextUtils.isEmpty(a2)) {
                httpURLConnection.setRequestProperty(Headers.RANGE, a2);
            }
        }
        return httpURLConnection;
    }

    public a a(String str, long j, long j2) throws IOException {
        return new a(b(str, j, j2), 0, null);
    }
}
