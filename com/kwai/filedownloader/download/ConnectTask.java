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
    public final int f36915a;

    /* renamed from: b  reason: collision with root package name */
    public final String f36916b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.filedownloader.d.b f36917c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.filedownloader.download.a f36918d;

    /* renamed from: e  reason: collision with root package name */
    public String f36919e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f36920f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f36921g;

    /* loaded from: classes6.dex */
    public class Reconnect extends Throwable {
        public Reconnect() {
        }
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Integer f36922a;

        /* renamed from: b  reason: collision with root package name */
        public String f36923b;

        /* renamed from: c  reason: collision with root package name */
        public String f36924c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwai.filedownloader.d.b f36925d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f36926e;

        public a a(int i) {
            this.f36922a = Integer.valueOf(i);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f36925d = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f36926e = aVar;
            return this;
        }

        public a a(String str) {
            this.f36923b = str;
            return this;
        }

        public ConnectTask a() {
            com.kwai.filedownloader.download.a aVar;
            Integer num = this.f36922a;
            if (num == null || (aVar = this.f36926e) == null || this.f36923b == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.f36923b, this.f36924c, this.f36925d);
        }

        public a b(String str) {
            this.f36924c = str;
            return this;
        }
    }

    public ConnectTask(com.kwai.filedownloader.download.a aVar, int i, String str, String str2, com.kwai.filedownloader.d.b bVar) {
        this.f36915a = i;
        this.f36916b = str;
        this.f36919e = str2;
        this.f36917c = bVar;
        this.f36918d = aVar;
    }

    private void a(com.kwai.filedownloader.a.b bVar) {
        HashMap<String, List<String>> a2;
        com.kwai.filedownloader.d.b bVar2 = this.f36917c;
        if (bVar2 == null || (a2 = bVar2.a()) == null) {
            return;
        }
        if (com.kwai.filedownloader.f.d.f37012a) {
            com.kwai.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.f36915a), a2);
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
        if (bVar.a(this.f36919e, this.f36918d.f36943a)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f36919e)) {
            bVar.a(Util.IF_MATCH, this.f36919e);
        }
        com.kwai.filedownloader.download.a aVar = this.f36918d;
        bVar.a("Range", aVar.f36945c == 0 ? com.kwai.filedownloader.f.f.a("bytes=%d-", Long.valueOf(aVar.f36944b)) : com.kwai.filedownloader.f.f.a("bytes=%d-%d", Long.valueOf(aVar.f36944b), Long.valueOf(this.f36918d.f36945c)));
    }

    private void c(com.kwai.filedownloader.a.b bVar) {
        com.kwai.filedownloader.d.b bVar2 = this.f36917c;
        if (bVar2 == null || bVar2.a().get("User-Agent") == null) {
            bVar.a("User-Agent", com.kwai.filedownloader.f.f.e());
        }
    }

    public com.kwai.filedownloader.a.b a() {
        com.kwai.filedownloader.a.b a2 = b.a().a(this.f36916b);
        a(a2);
        b(a2);
        c(a2);
        this.f36920f = a2.b();
        if (com.kwai.filedownloader.f.d.f37012a) {
            com.kwai.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.f36915a), this.f36920f);
        }
        a2.d();
        ArrayList arrayList = new ArrayList();
        this.f36921g = arrayList;
        return com.kwai.filedownloader.a.d.a(this.f36920f, a2, arrayList);
    }

    public boolean b() {
        return this.f36918d.f36944b > 0;
    }

    public String c() {
        List<String> list = this.f36921g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.f36921g;
        return list2.get(list2.size() - 1);
    }

    public Map<String, List<String>> d() {
        return this.f36920f;
    }

    public com.kwai.filedownloader.download.a e() {
        return this.f36918d;
    }
}
