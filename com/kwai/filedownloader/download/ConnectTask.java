package com.kwai.filedownloader.download;

import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class ConnectTask {

    /* renamed from: a  reason: collision with root package name */
    public final int f37774a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37775b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.filedownloader.d.b f37776c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.filedownloader.download.a f37777d;

    /* renamed from: e  reason: collision with root package name */
    public String f37778e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f37779f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f37780g;

    /* loaded from: classes7.dex */
    public class Reconnect extends Throwable {
        public Reconnect() {
        }
    }

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Integer f37781a;

        /* renamed from: b  reason: collision with root package name */
        public String f37782b;

        /* renamed from: c  reason: collision with root package name */
        public String f37783c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwai.filedownloader.d.b f37784d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f37785e;

        public a a(int i2) {
            this.f37781a = Integer.valueOf(i2);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f37784d = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f37785e = aVar;
            return this;
        }

        public a a(String str) {
            this.f37782b = str;
            return this;
        }

        public ConnectTask a() {
            com.kwai.filedownloader.download.a aVar;
            Integer num = this.f37781a;
            if (num == null || (aVar = this.f37785e) == null || this.f37782b == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.f37782b, this.f37783c, this.f37784d);
        }

        public a b(String str) {
            this.f37783c = str;
            return this;
        }
    }

    public ConnectTask(com.kwai.filedownloader.download.a aVar, int i2, String str, String str2, com.kwai.filedownloader.d.b bVar) {
        this.f37774a = i2;
        this.f37775b = str;
        this.f37778e = str2;
        this.f37776c = bVar;
        this.f37777d = aVar;
    }

    private void a(com.kwai.filedownloader.a.b bVar) {
        HashMap<String, List<String>> a2;
        com.kwai.filedownloader.d.b bVar2 = this.f37776c;
        if (bVar2 == null || (a2 = bVar2.a()) == null) {
            return;
        }
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.f37774a), a2);
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
        if (bVar.a(this.f37778e, this.f37777d.f37803a)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f37778e)) {
            bVar.a(Util.IF_MATCH, this.f37778e);
        }
        com.kwai.filedownloader.download.a aVar = this.f37777d;
        bVar.a("Range", aVar.f37805c == 0 ? com.kwai.filedownloader.f.f.a("bytes=%d-", Long.valueOf(aVar.f37804b)) : com.kwai.filedownloader.f.f.a("bytes=%d-%d", Long.valueOf(aVar.f37804b), Long.valueOf(this.f37777d.f37805c)));
    }

    private void c(com.kwai.filedownloader.a.b bVar) {
        com.kwai.filedownloader.d.b bVar2 = this.f37776c;
        if (bVar2 == null || bVar2.a().get("User-Agent") == null) {
            bVar.a("User-Agent", com.kwai.filedownloader.f.f.e());
        }
    }

    public com.kwai.filedownloader.a.b a() {
        com.kwai.filedownloader.a.b a2 = b.a().a(this.f37775b);
        a(a2);
        b(a2);
        c(a2);
        this.f37779f = a2.b();
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.f37774a), this.f37779f);
        }
        a2.d();
        ArrayList arrayList = new ArrayList();
        this.f37780g = arrayList;
        return com.kwai.filedownloader.a.d.a(this.f37779f, a2, arrayList);
    }

    public boolean b() {
        return this.f37777d.f37804b > 0;
    }

    public String c() {
        List<String> list = this.f37780g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.f37780g;
        return list2.get(list2.size() - 1);
    }

    public Map<String, List<String>> d() {
        return this.f37779f;
    }

    public com.kwai.filedownloader.download.a e() {
        return this.f37777d;
    }
}
