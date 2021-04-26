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
    public URLConnection f34947a;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Proxy f34948a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f34949b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f34950c;
    }

    /* loaded from: classes6.dex */
    public static class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final a f34951a;

        public b() {
            this(null);
        }

        public b(a aVar) {
            this.f34951a = aVar;
        }

        @Override // com.kwai.filedownloader.f.c.b
        public com.kwai.filedownloader.a.b a(String str) {
            return new c(str, this.f34951a);
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    public c(URL url, a aVar) {
        this.f34947a = (aVar == null || aVar.f34948a == null) ? url.openConnection() : url.openConnection(aVar.f34948a);
        l.a(this.f34947a);
        if (aVar != null) {
            if (aVar.f34949b != null) {
                this.f34947a.setReadTimeout(aVar.f34949b.intValue());
            }
            if (aVar.f34950c != null) {
                this.f34947a.setConnectTimeout(aVar.f34950c.intValue());
            }
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public InputStream a() {
        return com.kwad.sdk.core.h.b.a().b(this.f34947a.getInputStream());
    }

    @Override // com.kwai.filedownloader.a.b
    public String a(String str) {
        return this.f34947a.getHeaderField(str);
    }

    @Override // com.kwai.filedownloader.a.b
    public void a(String str, String str2) {
        this.f34947a.addRequestProperty(str, str2);
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean a(String str, long j) {
        return false;
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> b() {
        return this.f34947a.getRequestProperties();
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> c() {
        return this.f34947a.getHeaderFields();
    }

    @Override // com.kwai.filedownloader.a.b
    public void d() {
        this.f34947a.connect();
    }

    @Override // com.kwai.filedownloader.a.b
    public int e() {
        URLConnection uRLConnection = this.f34947a;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.kwai.filedownloader.a.b
    public void f() {
    }
}
