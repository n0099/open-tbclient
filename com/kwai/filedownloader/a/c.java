package com.kwai.filedownloader.a;

import com.kwad.sdk.core.network.l;
import com.kwai.filedownloader.f.c;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class c implements com.kwai.filedownloader.a.b {

    /* renamed from: a  reason: collision with root package name */
    public URLConnection f34192a;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Proxy f34193a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f34194b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f34195c;
    }

    /* loaded from: classes6.dex */
    public static class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final a f34196a;

        public b() {
            this(null);
        }

        public b(a aVar) {
            this.f34196a = aVar;
        }

        @Override // com.kwai.filedownloader.f.c.b
        public com.kwai.filedownloader.a.b a(String str) {
            return new c(str, this.f34196a);
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    public c(URL url, a aVar) {
        this.f34192a = (aVar == null || aVar.f34193a == null) ? url.openConnection() : url.openConnection(aVar.f34193a);
        l.a(this.f34192a);
        if (aVar != null) {
            if (aVar.f34194b != null) {
                this.f34192a.setReadTimeout(aVar.f34194b.intValue());
            }
            if (aVar.f34195c != null) {
                this.f34192a.setConnectTimeout(aVar.f34195c.intValue());
            }
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public InputStream a() {
        return com.kwad.sdk.core.h.b.a().b(this.f34192a.getInputStream());
    }

    @Override // com.kwai.filedownloader.a.b
    public String a(String str) {
        return this.f34192a.getHeaderField(str);
    }

    @Override // com.kwai.filedownloader.a.b
    public void a(String str, String str2) {
        this.f34192a.addRequestProperty(str, str2);
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean a(String str, long j) {
        return false;
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> b() {
        return this.f34192a.getRequestProperties();
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> c() {
        return this.f34192a.getHeaderFields();
    }

    @Override // com.kwai.filedownloader.a.b
    public void d() {
        this.f34192a.connect();
    }

    @Override // com.kwai.filedownloader.a.b
    public int e() {
        URLConnection uRLConnection = this.f34192a;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.kwai.filedownloader.a.b
    public void f() {
    }
}
