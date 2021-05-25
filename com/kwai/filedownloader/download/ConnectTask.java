package com.kwai.filedownloader.download;

import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class ConnectTask {

    /* renamed from: a  reason: collision with root package name */
    public final int f34192a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34193b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.filedownloader.d.b f34194c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.filedownloader.download.a f34195d;

    /* renamed from: e  reason: collision with root package name */
    public String f34196e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f34197f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f34198g;

    /* loaded from: classes6.dex */
    public class Reconnect extends Throwable {
        public static final long serialVersionUID = 2940866805654257562L;

        public Reconnect() {
        }
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Integer f34199a;

        /* renamed from: b  reason: collision with root package name */
        public String f34200b;

        /* renamed from: c  reason: collision with root package name */
        public String f34201c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwai.filedownloader.d.b f34202d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f34203e;

        public a a(int i2) {
            this.f34199a = Integer.valueOf(i2);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f34202d = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f34203e = aVar;
            return this;
        }

        public a a(String str) {
            this.f34200b = str;
            return this;
        }

        public ConnectTask a() {
            com.kwai.filedownloader.download.a aVar;
            Integer num = this.f34199a;
            if (num == null || (aVar = this.f34203e) == null || this.f34200b == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.f34200b, this.f34201c, this.f34202d);
        }

        public a b(String str) {
            this.f34201c = str;
            return this;
        }
    }

    public ConnectTask(com.kwai.filedownloader.download.a aVar, int i2, String str, String str2, com.kwai.filedownloader.d.b bVar) {
        this.f34192a = i2;
        this.f34193b = str;
        this.f34196e = str2;
        this.f34194c = bVar;
        this.f34195d = aVar;
    }

    private void a(com.kwai.filedownloader.a.b bVar) {
        HashMap<String, List<String>> a2;
        com.kwai.filedownloader.d.b bVar2 = this.f34194c;
        if (bVar2 == null || (a2 = bVar2.a()) == null) {
            return;
        }
        if (com.kwai.filedownloader.f.d.f34292a) {
            com.kwai.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.f34192a), a2);
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
        if (bVar.a(this.f34196e, this.f34195d.f34221a)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f34196e)) {
            bVar.a(Util.IF_MATCH, this.f34196e);
        }
        com.kwai.filedownloader.download.a aVar = this.f34195d;
        bVar.a("Range", aVar.f34223c == 0 ? com.kwai.filedownloader.f.f.a("bytes=%d-", Long.valueOf(aVar.f34222b)) : com.kwai.filedownloader.f.f.a("bytes=%d-%d", Long.valueOf(aVar.f34222b), Long.valueOf(this.f34195d.f34223c)));
    }

    private void c(com.kwai.filedownloader.a.b bVar) {
        com.kwai.filedownloader.d.b bVar2 = this.f34194c;
        if (bVar2 == null || bVar2.a().get("User-Agent") == null) {
            bVar.a("User-Agent", com.kwai.filedownloader.f.f.e());
        }
    }

    public com.kwai.filedownloader.a.b a() {
        com.kwai.filedownloader.a.b a2 = b.a().a(this.f34193b);
        a(a2);
        b(a2);
        c(a2);
        this.f34197f = a2.b();
        if (com.kwai.filedownloader.f.d.f34292a) {
            com.kwai.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.f34192a), this.f34197f);
        }
        a2.d();
        ArrayList arrayList = new ArrayList();
        this.f34198g = arrayList;
        return com.kwai.filedownloader.a.d.a(this.f34197f, a2, arrayList);
    }

    public boolean b() {
        return this.f34195d.f34222b > 0;
    }

    public String c() {
        List<String> list = this.f34198g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.f34198g;
        return list2.get(list2.size() - 1);
    }

    public Map<String, List<String>> d() {
        return this.f34197f;
    }

    public com.kwai.filedownloader.download.a e() {
        return this.f34195d;
    }
}
