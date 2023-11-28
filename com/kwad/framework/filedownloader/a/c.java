package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.c;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public final class c implements com.kwad.framework.filedownloader.a.b {
    public URLConnection aeT;

    @Override // com.kwad.framework.filedownloader.a.b
    public final void uU() {
    }

    /* loaded from: classes10.dex */
    public static class a {
        public Proxy aeU;
        public Integer aeV;
        public Integer aeW;
    }

    /* loaded from: classes10.dex */
    public static class b implements c.b {
        public final a aeX;

        public b() {
            this(null);
        }

        public b(a aVar) {
            this.aeX = null;
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b aX(String str) {
            return new c(str, this.aeX);
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.aeT.addRequestProperty(str, str2);
    }

    public c(URL url, a aVar) {
        if (aVar != null && aVar.aeU != null) {
            this.aeT = url.openConnection(aVar.aeU);
        } else {
            this.aeT = url.openConnection();
        }
        try {
            TLSConnectionUtils.wrapHttpURLConnection(this.aeT);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            if (aVar.aeV != null) {
                this.aeT.setReadTimeout(aVar.aeV.intValue());
            }
            if (aVar.aeW != null) {
                this.aeT.setConnectTimeout(aVar.aeW.intValue());
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String aW(String str) {
        return this.aeT.getHeaderField(str);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() {
        this.aeT.connect();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() {
        return ((j) ServiceProvider.get(j.class)).wrapInputStream(this.aeT.getInputStream());
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() {
        URLConnection uRLConnection = this.aeT;
        if (uRLConnection instanceof HttpURLConnection) {
            try {
                return ((HttpURLConnection) uRLConnection).getResponseCode();
            } catch (Throwable th) {
                throw new IOException(th);
            }
        }
        return 0;
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> uS() {
        return this.aeT.getRequestProperties();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> uT() {
        return this.aeT.getHeaderFields();
    }
}
