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
    public final int f37204a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37205b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.filedownloader.d.b f37206c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.filedownloader.download.a f37207d;

    /* renamed from: e  reason: collision with root package name */
    public String f37208e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f37209f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f37210g;

    /* loaded from: classes6.dex */
    public class Reconnect extends Throwable {
        public Reconnect() {
        }
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Integer f37211a;

        /* renamed from: b  reason: collision with root package name */
        public String f37212b;

        /* renamed from: c  reason: collision with root package name */
        public String f37213c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwai.filedownloader.d.b f37214d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f37215e;

        public a a(int i) {
            this.f37211a = Integer.valueOf(i);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f37214d = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f37215e = aVar;
            return this;
        }

        public a a(String str) {
            this.f37212b = str;
            return this;
        }

        public ConnectTask a() {
            com.kwai.filedownloader.download.a aVar;
            Integer num = this.f37211a;
            if (num == null || (aVar = this.f37215e) == null || this.f37212b == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.f37212b, this.f37213c, this.f37214d);
        }

        public a b(String str) {
            this.f37213c = str;
            return this;
        }
    }

    public ConnectTask(com.kwai.filedownloader.download.a aVar, int i, String str, String str2, com.kwai.filedownloader.d.b bVar) {
        this.f37204a = i;
        this.f37205b = str;
        this.f37208e = str2;
        this.f37206c = bVar;
        this.f37207d = aVar;
    }

    private void a(com.kwai.filedownloader.a.b bVar) {
        HashMap<String, List<String>> a2;
        com.kwai.filedownloader.d.b bVar2 = this.f37206c;
        if (bVar2 == null || (a2 = bVar2.a()) == null) {
            return;
        }
        if (com.kwai.filedownloader.f.d.f37301a) {
            com.kwai.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.f37204a), a2);
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
        if (bVar.a(this.f37208e, this.f37207d.f37232a)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f37208e)) {
            bVar.a(Util.IF_MATCH, this.f37208e);
        }
        com.kwai.filedownloader.download.a aVar = this.f37207d;
        bVar.a("Range", aVar.f37234c == 0 ? com.kwai.filedownloader.f.f.a("bytes=%d-", Long.valueOf(aVar.f37233b)) : com.kwai.filedownloader.f.f.a("bytes=%d-%d", Long.valueOf(aVar.f37233b), Long.valueOf(this.f37207d.f37234c)));
    }

    private void c(com.kwai.filedownloader.a.b bVar) {
        com.kwai.filedownloader.d.b bVar2 = this.f37206c;
        if (bVar2 == null || bVar2.a().get("User-Agent") == null) {
            bVar.a("User-Agent", com.kwai.filedownloader.f.f.e());
        }
    }

    public com.kwai.filedownloader.a.b a() {
        com.kwai.filedownloader.a.b a2 = b.a().a(this.f37205b);
        a(a2);
        b(a2);
        c(a2);
        this.f37209f = a2.b();
        if (com.kwai.filedownloader.f.d.f37301a) {
            com.kwai.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.f37204a), this.f37209f);
        }
        a2.d();
        ArrayList arrayList = new ArrayList();
        this.f37210g = arrayList;
        return com.kwai.filedownloader.a.d.a(this.f37209f, a2, arrayList);
    }

    public boolean b() {
        return this.f37207d.f37233b > 0;
    }

    public String c() {
        List<String> list = this.f37210g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.f37210g;
        return list2.get(list2.size() - 1);
    }

    public Map<String, List<String>> d() {
        return this.f37209f;
    }

    public com.kwai.filedownloader.download.a e() {
        return this.f37207d;
    }
}
