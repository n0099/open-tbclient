package com;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
/* loaded from: classes.dex */
public class e implements HttpEntity {
    private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String c;
    private byte[] f;
    private ByteArrayOutputStream b = new ByteArrayOutputStream();
    private boolean d = false;
    private boolean e = false;

    public e() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            sb.append(a[random.nextInt(a.length)]);
        }
        this.c = sb.toString();
        this.f = ("\r\n--" + this.c + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes();
    }

    private void a() {
        if (this.d) {
            this.b.write(this.f);
            return;
        }
        this.d = true;
        this.b.write(("--" + this.c + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
    }

    private void b() {
        if (this.e) {
            return;
        }
        try {
            this.b.write(("\r\n--" + this.c + "--\r\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.e = true;
    }

    public void a(String str, String str2) {
        try {
            a();
            this.b.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            this.b.write(str2.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2, InputStream inputStream, String str3, boolean z) {
        try {
            try {
                a();
                this.b.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                if (str3 != null) {
                    this.b.write(("Content-Type: " + str3 + "\r\n\r\n").getBytes());
                } else {
                    this.b.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                }
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        this.b.flush();
                        try {
                            inputStream.close();
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    this.b.write(bArr, 0, read);
                }
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() {
        return new ByteArrayInputStream(this.b.toByteArray());
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        b();
        return this.b.toByteArray().length;
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.c);
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(this.b.toByteArray());
    }
}
