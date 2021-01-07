package com.kwai.filedownloader.download;

import android.text.TextUtils;
import com.baidubce.http.Headers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ConnectTask {

    /* renamed from: a  reason: collision with root package name */
    final int f11190a;

    /* renamed from: b  reason: collision with root package name */
    final String f11191b;
    final com.kwai.filedownloader.d.b c;
    private com.kwai.filedownloader.download.a d;
    private String e;
    private Map<String, List<String>> f;
    private List<String> g;

    /* loaded from: classes5.dex */
    class Reconnect extends Throwable {
        Reconnect() {
        }
    }

    /* loaded from: classes5.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f11192a;

        /* renamed from: b  reason: collision with root package name */
        private String f11193b;
        private String c;
        private com.kwai.filedownloader.d.b d;
        private com.kwai.filedownloader.download.a e;

        public a a(int i) {
            this.f11192a = Integer.valueOf(i);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.d = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.e = aVar;
            return this;
        }

        public a a(String str) {
            this.f11193b = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConnectTask a() {
            if (this.f11192a == null || this.e == null || this.f11193b == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(this.e, this.f11192a.intValue(), this.f11193b, this.c, this.d);
        }

        public a b(String str) {
            this.c = str;
            return this;
        }
    }

    private ConnectTask(com.kwai.filedownloader.download.a aVar, int i, String str, String str2, com.kwai.filedownloader.d.b bVar) {
        this.f11190a = i;
        this.f11191b = str;
        this.e = str2;
        this.c = bVar;
        this.d = aVar;
    }

    private void a(com.kwai.filedownloader.a.b bVar) {
        HashMap<String, List<String>> a2;
        if (this.c == null || (a2 = this.c.a()) == null) {
            return;
        }
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.f11190a), a2);
        }
        for (Map.Entry<String, List<String>> entry : a2.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                for (String str : value) {
                    bVar.a(key, str);
                }
            }
        }
    }

    private void b(com.kwai.filedownloader.a.b bVar) {
        if (bVar.a(this.e, this.d.f11198a)) {
            return;
        }
        if (!TextUtils.isEmpty(this.e)) {
            bVar.a("If-Match", this.e);
        }
        bVar.a(Headers.RANGE, this.d.c == 0 ? com.kwai.filedownloader.f.f.a("bytes=%d-", Long.valueOf(this.d.f11199b)) : com.kwai.filedownloader.f.f.a("bytes=%d-%d", Long.valueOf(this.d.f11199b), Long.valueOf(this.d.c)));
    }

    private void c(com.kwai.filedownloader.a.b bVar) {
        if (this.c == null || this.c.a().get("User-Agent") == null) {
            bVar.a("User-Agent", com.kwai.filedownloader.f.f.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.kwai.filedownloader.a.b a() {
        com.kwai.filedownloader.a.b a2 = b.a().a(this.f11191b);
        a(a2);
        b(a2);
        c(a2);
        this.f = a2.b();
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.f11190a), this.f);
        }
        a2.d();
        this.g = new ArrayList();
        return com.kwai.filedownloader.a.d.a(this.f, a2, this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.d.f11199b > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        if (this.g == null || this.g.isEmpty()) {
            return null;
        }
        return this.g.get(this.g.size() - 1);
    }

    public Map<String, List<String>> d() {
        return this.f;
    }

    public com.kwai.filedownloader.download.a e() {
        return this.d;
    }
}
