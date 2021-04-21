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
    public final int f37299a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37300b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.filedownloader.d.b f37301c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.filedownloader.download.a f37302d;

    /* renamed from: e  reason: collision with root package name */
    public String f37303e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f37304f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f37305g;

    /* loaded from: classes6.dex */
    public class Reconnect extends Throwable {
        public Reconnect() {
        }
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Integer f37306a;

        /* renamed from: b  reason: collision with root package name */
        public String f37307b;

        /* renamed from: c  reason: collision with root package name */
        public String f37308c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwai.filedownloader.d.b f37309d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f37310e;

        public a a(int i) {
            this.f37306a = Integer.valueOf(i);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f37309d = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f37310e = aVar;
            return this;
        }

        public a a(String str) {
            this.f37307b = str;
            return this;
        }

        public ConnectTask a() {
            com.kwai.filedownloader.download.a aVar;
            Integer num = this.f37306a;
            if (num == null || (aVar = this.f37310e) == null || this.f37307b == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.f37307b, this.f37308c, this.f37309d);
        }

        public a b(String str) {
            this.f37308c = str;
            return this;
        }
    }

    public ConnectTask(com.kwai.filedownloader.download.a aVar, int i, String str, String str2, com.kwai.filedownloader.d.b bVar) {
        this.f37299a = i;
        this.f37300b = str;
        this.f37303e = str2;
        this.f37301c = bVar;
        this.f37302d = aVar;
    }

    private void a(com.kwai.filedownloader.a.b bVar) {
        HashMap<String, List<String>> a2;
        com.kwai.filedownloader.d.b bVar2 = this.f37301c;
        if (bVar2 == null || (a2 = bVar2.a()) == null) {
            return;
        }
        if (com.kwai.filedownloader.f.d.f37396a) {
            com.kwai.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.f37299a), a2);
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
        if (bVar.a(this.f37303e, this.f37302d.f37327a)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f37303e)) {
            bVar.a(Util.IF_MATCH, this.f37303e);
        }
        com.kwai.filedownloader.download.a aVar = this.f37302d;
        bVar.a("Range", aVar.f37329c == 0 ? com.kwai.filedownloader.f.f.a("bytes=%d-", Long.valueOf(aVar.f37328b)) : com.kwai.filedownloader.f.f.a("bytes=%d-%d", Long.valueOf(aVar.f37328b), Long.valueOf(this.f37302d.f37329c)));
    }

    private void c(com.kwai.filedownloader.a.b bVar) {
        com.kwai.filedownloader.d.b bVar2 = this.f37301c;
        if (bVar2 == null || bVar2.a().get("User-Agent") == null) {
            bVar.a("User-Agent", com.kwai.filedownloader.f.f.e());
        }
    }

    public com.kwai.filedownloader.a.b a() {
        com.kwai.filedownloader.a.b a2 = b.a().a(this.f37300b);
        a(a2);
        b(a2);
        c(a2);
        this.f37304f = a2.b();
        if (com.kwai.filedownloader.f.d.f37396a) {
            com.kwai.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.f37299a), this.f37304f);
        }
        a2.d();
        ArrayList arrayList = new ArrayList();
        this.f37305g = arrayList;
        return com.kwai.filedownloader.a.d.a(this.f37304f, a2, arrayList);
    }

    public boolean b() {
        return this.f37302d.f37328b > 0;
    }

    public String c() {
        List<String> list = this.f37305g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.f37305g;
        return list2.get(list2.size() - 1);
    }

    public Map<String, List<String>> d() {
        return this.f37304f;
    }

    public com.kwai.filedownloader.download.a e() {
        return this.f37302d;
    }
}
