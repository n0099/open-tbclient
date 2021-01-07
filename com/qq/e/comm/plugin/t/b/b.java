package com.qq.e.comm.plugin.t.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
/* loaded from: classes4.dex */
public abstract class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final HttpURLConnection f12828a;

    /* renamed from: b  reason: collision with root package name */
    private int f12829b;

    public b(HttpURLConnection httpURLConnection) {
        this.f12829b = 0;
        if (httpURLConnection == null) {
            throw new AssertionError("AbstractResponse parameter is null");
        }
        this.f12828a = httpURLConnection;
        try {
            this.f12829b = this.f12828a.getResponseCode();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.qq.e.comm.plugin.t.b.f
    public String a(String str) {
        return this.f12828a.getHeaderField(str);
    }

    public byte[] a() throws IllegalStateException, IOException {
        if (200 != e()) {
            return null;
        }
        InputStream b2 = b();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = b2.read(bArr);
            if (read <= 0) {
                b2.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public InputStream b() throws IllegalStateException, IOException {
        return this.f12828a.getInputStream();
    }

    @Override // com.qq.e.comm.plugin.t.b.f
    public void c() throws IllegalStateException, IOException {
        b().close();
        this.f12828a.disconnect();
    }

    @Override // com.qq.e.comm.plugin.t.b.f
    public String d() throws IOException {
        String str = null;
        byte[] a2 = a();
        if (a2 == null) {
            return null;
        }
        if (a2.length == 0) {
            return "";
        }
        try {
            str = this.f12828a.getContentEncoding();
        } catch (Throwable th) {
        }
        if (str == null) {
            str = "UTF-8";
        }
        return new String(a2, str);
    }

    @Override // com.qq.e.comm.plugin.t.b.f
    public int e() {
        return this.f12829b;
    }
}
