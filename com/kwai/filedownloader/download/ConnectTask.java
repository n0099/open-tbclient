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
    public final int f36914a;

    /* renamed from: b  reason: collision with root package name */
    public final String f36915b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.filedownloader.d.b f36916c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.filedownloader.download.a f36917d;

    /* renamed from: e  reason: collision with root package name */
    public String f36918e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f36919f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f36920g;

    /* loaded from: classes6.dex */
    public class Reconnect extends Throwable {
        public Reconnect() {
        }
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Integer f36921a;

        /* renamed from: b  reason: collision with root package name */
        public String f36922b;

        /* renamed from: c  reason: collision with root package name */
        public String f36923c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwai.filedownloader.d.b f36924d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f36925e;

        public a a(int i) {
            this.f36921a = Integer.valueOf(i);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f36924d = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f36925e = aVar;
            return this;
        }

        public a a(String str) {
            this.f36922b = str;
            return this;
        }

        public ConnectTask a() {
            com.kwai.filedownloader.download.a aVar;
            Integer num = this.f36921a;
            if (num == null || (aVar = this.f36925e) == null || this.f36922b == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.f36922b, this.f36923c, this.f36924d);
        }

        public a b(String str) {
            this.f36923c = str;
            return this;
        }
    }

    public ConnectTask(com.kwai.filedownloader.download.a aVar, int i, String str, String str2, com.kwai.filedownloader.d.b bVar) {
        this.f36914a = i;
        this.f36915b = str;
        this.f36918e = str2;
        this.f36916c = bVar;
        this.f36917d = aVar;
    }

    private void a(com.kwai.filedownloader.a.b bVar) {
        HashMap<String, List<String>> a2;
        com.kwai.filedownloader.d.b bVar2 = this.f36916c;
        if (bVar2 == null || (a2 = bVar2.a()) == null) {
            return;
        }
        if (com.kwai.filedownloader.f.d.f37011a) {
            com.kwai.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.f36914a), a2);
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
        if (bVar.a(this.f36918e, this.f36917d.f36942a)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f36918e)) {
            bVar.a(Util.IF_MATCH, this.f36918e);
        }
        com.kwai.filedownloader.download.a aVar = this.f36917d;
        bVar.a("Range", aVar.f36944c == 0 ? com.kwai.filedownloader.f.f.a("bytes=%d-", Long.valueOf(aVar.f36943b)) : com.kwai.filedownloader.f.f.a("bytes=%d-%d", Long.valueOf(aVar.f36943b), Long.valueOf(this.f36917d.f36944c)));
    }

    private void c(com.kwai.filedownloader.a.b bVar) {
        com.kwai.filedownloader.d.b bVar2 = this.f36916c;
        if (bVar2 == null || bVar2.a().get("User-Agent") == null) {
            bVar.a("User-Agent", com.kwai.filedownloader.f.f.e());
        }
    }

    public com.kwai.filedownloader.a.b a() {
        com.kwai.filedownloader.a.b a2 = b.a().a(this.f36915b);
        a(a2);
        b(a2);
        c(a2);
        this.f36919f = a2.b();
        if (com.kwai.filedownloader.f.d.f37011a) {
            com.kwai.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.f36914a), this.f36919f);
        }
        a2.d();
        ArrayList arrayList = new ArrayList();
        this.f36920g = arrayList;
        return com.kwai.filedownloader.a.d.a(this.f36919f, a2, arrayList);
    }

    public boolean b() {
        return this.f36917d.f36943b > 0;
    }

    public String c() {
        List<String> list = this.f36920g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.f36920g;
        return list2.get(list2.size() - 1);
    }

    public Map<String, List<String>> d() {
        return this.f36919f;
    }

    public com.kwai.filedownloader.download.a e() {
        return this.f36917d;
    }
}
