package com.kwai.filedownloader.a;

import com.kwai.filedownloader.f.c;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class c implements com.kwai.filedownloader.a.b {

    /* renamed from: a  reason: collision with root package name */
    protected URLConnection f10861a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Proxy f10862a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f10863b;
        private Integer c;
    }

    /* loaded from: classes3.dex */
    public static class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        private final a f10864a;

        public b() {
            this(null);
        }

        public b(a aVar) {
            this.f10864a = aVar;
        }

        @Override // com.kwai.filedownloader.f.c.b
        public com.kwai.filedownloader.a.b a(String str) {
            return new c(str, this.f10864a);
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    public c(URL url, a aVar) {
        if (aVar == null || aVar.f10862a == null) {
            this.f10861a = url.openConnection();
        } else {
            this.f10861a = url.openConnection(aVar.f10862a);
        }
        if (aVar != null) {
            if (aVar.f10863b != null) {
                this.f10861a.setReadTimeout(aVar.f10863b.intValue());
            }
            if (aVar.c != null) {
                this.f10861a.setConnectTimeout(aVar.c.intValue());
            }
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public InputStream a() {
        return com.kwad.sdk.core.h.b.a().b(this.f10861a.getInputStream());
    }

    @Override // com.kwai.filedownloader.a.b
    public String a(String str) {
        return this.f10861a.getHeaderField(str);
    }

    @Override // com.kwai.filedownloader.a.b
    public void a(String str, String str2) {
        this.f10861a.addRequestProperty(str, str2);
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean a(String str, long j) {
        return false;
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> b() {
        return this.f10861a.getRequestProperties();
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> c() {
        return this.f10861a.getHeaderFields();
    }

    @Override // com.kwai.filedownloader.a.b
    public void d() {
        this.f10861a.connect();
    }

    @Override // com.kwai.filedownloader.a.b
    public int e() {
        if (this.f10861a instanceof HttpURLConnection) {
            return ((HttpURLConnection) this.f10861a).getResponseCode();
        }
        return 0;
    }

    @Override // com.kwai.filedownloader.a.b
    public void f() {
    }
}
