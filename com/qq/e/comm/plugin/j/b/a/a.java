package com.qq.e.comm.plugin.j.b.a;

import android.text.TextUtils;
import com.baidubce.http.Headers;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ai;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f12161a = Pattern.compile("bytes\\W+(\\d+)-(\\d+)/(\\d+)");

    /* renamed from: b  reason: collision with root package name */
    private HttpURLConnection f12162b;
    private int c;
    private String d;
    private AtomicBoolean e = new AtomicBoolean(false);

    public a(HttpURLConnection httpURLConnection, int i, String str) {
        this.f12162b = httpURLConnection;
        this.c = i;
        this.d = str;
    }

    public boolean a() {
        return this.c == 0;
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        String headerField = this.f12162b.getHeaderField(Headers.CONTENT_RANGE);
        return !TextUtils.isEmpty(headerField) && f12161a.matcher(headerField).matches() && d() >= 0;
    }

    public long d() {
        if (this.f12162b != null) {
            return this.f12162b.getContentLength();
        }
        return -1L;
    }

    public InputStream e() throws IllegalStateException, IOException {
        if (this.f12162b != null) {
            return this.f12162b.getInputStream();
        }
        return null;
    }

    public void f() {
        if (this.f12162b != null) {
            try {
                this.f12162b.disconnect();
            } catch (Throwable th) {
            }
        }
    }

    public String g() {
        return this.d;
    }

    public boolean h() {
        int i = 0;
        if (this.e.compareAndSet(false, true)) {
            try {
                this.f12162b = ab.a(this.f12162b);
                i = this.f12162b.getResponseCode();
                ai.a("status code = %d", Integer.valueOf(i));
            } catch (SocketTimeoutException e) {
                this.c |= 131072;
            } catch (UnknownHostException e2) {
                this.c |= 65536;
            } catch (IOException e3) {
                this.c |= 4194304;
                this.d = "ExceptionWhileMakeupPartitionConnection:" + e3.getClass();
            }
            if (i != 200 && i != 206) {
                this.c |= 2097152;
                this.d = "HttpStatusErrWhileMakeupPartitionConnection:" + i;
            }
        }
        return a();
    }
}
