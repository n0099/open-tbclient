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
    public final int f35018a;

    /* renamed from: b  reason: collision with root package name */
    public final String f35019b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.filedownloader.d.b f35020c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.filedownloader.download.a f35021d;

    /* renamed from: e  reason: collision with root package name */
    public String f35022e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f35023f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f35024g;

    /* loaded from: classes6.dex */
    public class Reconnect extends Throwable {
        public static final long serialVersionUID = 2940866805654257562L;

        public Reconnect() {
        }
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Integer f35025a;

        /* renamed from: b  reason: collision with root package name */
        public String f35026b;

        /* renamed from: c  reason: collision with root package name */
        public String f35027c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwai.filedownloader.d.b f35028d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f35029e;

        public a a(int i2) {
            this.f35025a = Integer.valueOf(i2);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f35028d = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f35029e = aVar;
            return this;
        }

        public a a(String str) {
            this.f35026b = str;
            return this;
        }

        public ConnectTask a() {
            com.kwai.filedownloader.download.a aVar;
            Integer num = this.f35025a;
            if (num == null || (aVar = this.f35029e) == null || this.f35026b == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.f35026b, this.f35027c, this.f35028d);
        }

        public a b(String str) {
            this.f35027c = str;
            return this;
        }
    }

    public ConnectTask(com.kwai.filedownloader.download.a aVar, int i2, String str, String str2, com.kwai.filedownloader.d.b bVar) {
        this.f35018a = i2;
        this.f35019b = str;
        this.f35022e = str2;
        this.f35020c = bVar;
        this.f35021d = aVar;
    }

    private void a(com.kwai.filedownloader.a.b bVar) {
        HashMap<String, List<String>> a2;
        com.kwai.filedownloader.d.b bVar2 = this.f35020c;
        if (bVar2 == null || (a2 = bVar2.a()) == null) {
            return;
        }
        if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.f35018a), a2);
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
        if (bVar.a(this.f35022e, this.f35021d.f35047a)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f35022e)) {
            bVar.a(Util.IF_MATCH, this.f35022e);
        }
        com.kwai.filedownloader.download.a aVar = this.f35021d;
        bVar.a("Range", aVar.f35049c == 0 ? com.kwai.filedownloader.f.f.a("bytes=%d-", Long.valueOf(aVar.f35048b)) : com.kwai.filedownloader.f.f.a("bytes=%d-%d", Long.valueOf(aVar.f35048b), Long.valueOf(this.f35021d.f35049c)));
    }

    private void c(com.kwai.filedownloader.a.b bVar) {
        com.kwai.filedownloader.d.b bVar2 = this.f35020c;
        if (bVar2 == null || bVar2.a().get("User-Agent") == null) {
            bVar.a("User-Agent", com.kwai.filedownloader.f.f.e());
        }
    }

    public com.kwai.filedownloader.a.b a() {
        com.kwai.filedownloader.a.b a2 = b.a().a(this.f35019b);
        a(a2);
        b(a2);
        c(a2);
        this.f35023f = a2.b();
        if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.f35018a), this.f35023f);
        }
        a2.d();
        ArrayList arrayList = new ArrayList();
        this.f35024g = arrayList;
        return com.kwai.filedownloader.a.d.a(this.f35023f, a2, arrayList);
    }

    public boolean b() {
        return this.f35021d.f35048b > 0;
    }

    public String c() {
        List<String> list = this.f35024g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.f35024g;
        return list2.get(list2.size() - 1);
    }

    public Map<String, List<String>> d() {
        return this.f35023f;
    }

    public com.kwai.filedownloader.download.a e() {
        return this.f35021d;
    }
}
