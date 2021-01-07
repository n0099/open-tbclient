package com.kwai.filedownloader.a;

import com.kwai.filedownloader.f.c;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class c implements com.kwai.filedownloader.a.b {

    /* renamed from: a  reason: collision with root package name */
    protected URLConnection f11159a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Proxy f11160a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f11161b;
        private Integer c;
    }

    /* loaded from: classes5.dex */
    public static class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        private final a f11162a;

        public b() {
            this(null);
        }

        public b(a aVar) {
            this.f11162a = aVar;
        }

        @Override // com.kwai.filedownloader.f.c.b
        public com.kwai.filedownloader.a.b a(String str) {
            return new c(str, this.f11162a);
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    public c(URL url, a aVar) {
        if (aVar == null || aVar.f11160a == null) {
            this.f11159a = url.openConnection();
        } else {
            this.f11159a = url.openConnection(aVar.f11160a);
        }
        if (aVar != null) {
            if (aVar.f11161b != null) {
                this.f11159a.setReadTimeout(aVar.f11161b.intValue());
            }
            if (aVar.c != null) {
                this.f11159a.setConnectTimeout(aVar.c.intValue());
            }
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public InputStream a() {
        return com.kwad.sdk.core.h.b.a().b(this.f11159a.getInputStream());
    }

    @Override // com.kwai.filedownloader.a.b
    public String a(String str) {
        return this.f11159a.getHeaderField(str);
    }

    @Override // com.kwai.filedownloader.a.b
    public void a(String str, String str2) {
        this.f11159a.addRequestProperty(str, str2);
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean a(String str, long j) {
        return false;
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> b() {
        return this.f11159a.getRequestProperties();
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> c() {
        return this.f11159a.getHeaderFields();
    }

    @Override // com.kwai.filedownloader.a.b
    public void d() {
        this.f11159a.connect();
    }

    @Override // com.kwai.filedownloader.a.b
    public int e() {
        if (this.f11159a instanceof HttpURLConnection) {
            return ((HttpURLConnection) this.f11159a).getResponseCode();
        }
        return 0;
    }

    @Override // com.kwai.filedownloader.a.b
    public void f() {
    }
}
