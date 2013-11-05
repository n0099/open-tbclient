package javassist;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/* loaded from: classes.dex */
public class URLClassPath implements a {

    /* renamed from: a  reason: collision with root package name */
    protected String f2696a;
    protected int b;
    protected String c;
    protected String d;

    public String toString() {
        return this.f2696a + ":" + this.b + this.c;
    }

    @Override // javassist.a
    public InputStream a(String str) {
        try {
            URLConnection c = c(str);
            if (c != null) {
                return c.getInputStream();
            }
        } catch (IOException e) {
        }
        return null;
    }

    private URLConnection c(String str) {
        if (this.d == null || str.startsWith(this.d)) {
            return a(this.f2696a, this.b, this.c + str.replace('.', '/') + ".class");
        }
        return null;
    }

    @Override // javassist.a
    public URL b(String str) {
        try {
            URLConnection c = c(str);
            InputStream inputStream = c.getInputStream();
            if (inputStream != null) {
                inputStream.close();
                return c.getURL();
            }
        } catch (IOException e) {
        }
        return null;
    }

    @Override // javassist.a
    public void a() {
    }

    private static URLConnection a(String str, int i, String str2) {
        try {
            URLConnection openConnection = new URL("http", str, i, str2).openConnection();
            openConnection.connect();
            return openConnection;
        } catch (MalformedURLException e) {
            throw new IOException("invalid URL?");
        }
    }
}
