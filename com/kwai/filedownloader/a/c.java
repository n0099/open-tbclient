package com.kwai.filedownloader.a;

import com.kwai.filedownloader.f.c;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class c implements com.kwai.filedownloader.a.b {

    /* renamed from: a  reason: collision with root package name */
    public URLConnection f37606a;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Proxy f37607a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f37608b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f37609c;
    }

    /* loaded from: classes7.dex */
    public static class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final a f37610a;

        public b() {
            this(null);
        }

        public b(a aVar) {
            this.f37610a = aVar;
        }

        @Override // com.kwai.filedownloader.f.c.b
        public com.kwai.filedownloader.a.b a(String str) {
            return new c(str, this.f37610a);
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    public c(URL url, a aVar) {
        this.f37606a = (aVar == null || aVar.f37607a == null) ? url.openConnection() : url.openConnection(aVar.f37607a);
        if (aVar != null) {
            if (aVar.f37608b != null) {
                this.f37606a.setReadTimeout(aVar.f37608b.intValue());
            }
            if (aVar.f37609c != null) {
                this.f37606a.setConnectTimeout(aVar.f37609c.intValue());
            }
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public InputStream a() {
        return com.kwad.sdk.core.h.b.a().b(this.f37606a.getInputStream());
    }

    @Override // com.kwai.filedownloader.a.b
    public String a(String str) {
        return this.f37606a.getHeaderField(str);
    }

    @Override // com.kwai.filedownloader.a.b
    public void a(String str, String str2) {
        this.f37606a.addRequestProperty(str, str2);
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean a(String str, long j) {
        return false;
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> b() {
        return this.f37606a.getRequestProperties();
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> c() {
        return this.f37606a.getHeaderFields();
    }

    @Override // com.kwai.filedownloader.a.b
    public void d() {
        this.f37606a.connect();
    }

    @Override // com.kwai.filedownloader.a.b
    public int e() {
        URLConnection uRLConnection = this.f37606a;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.kwai.filedownloader.a.b
    public void f() {
    }
}
