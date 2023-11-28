package com.kwad.framework.filedownloader.download;

import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public final class ConnectTask {
    public final int afr;
    public final com.kwad.framework.filedownloader.d.b afs;
    public com.kwad.framework.filedownloader.download.a aft;
    public String afu;
    public Map<String, List<String>> afv;
    public List<String> afw;
    public final String url;

    /* loaded from: classes10.dex */
    public class Reconnect extends Throwable {
        public static final long serialVersionUID = 2940866805654257562L;

        public Reconnect() {
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public com.kwad.framework.filedownloader.d.b afs;
        public String afu;
        public Integer afx;
        public com.kwad.framework.filedownloader.download.a afy;
        public String url;

        public final ConnectTask vd() {
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num = this.afx;
            if (num != null && (aVar = this.afy) != null && this.url != null) {
                return new ConnectTask(aVar, num.intValue(), this.url, this.afu, this.afs, (byte) 0);
            }
            throw new IllegalArgumentException();
        }

        public final a a(com.kwad.framework.filedownloader.d.b bVar) {
            this.afs = bVar;
            return this;
        }

        public final a aY(String str) {
            this.url = str;
            return this;
        }

        public final a aZ(String str) {
            this.afu = str;
            return this;
        }

        public final a bn(int i) {
            this.afx = Integer.valueOf(i);
            return this;
        }

        public final a a(com.kwad.framework.filedownloader.download.a aVar) {
            this.afy = aVar;
            return this;
        }
    }

    public ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i, String str, String str2, com.kwad.framework.filedownloader.d.b bVar) {
        this.afr = i;
        this.url = str;
        this.afu = str2;
        this.afs = bVar;
        this.aft = aVar;
    }

    public /* synthetic */ ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i, String str, String str2, com.kwad.framework.filedownloader.d.b bVar, byte b) {
        this(aVar, i, str, str2, bVar);
    }

    private void a(com.kwad.framework.filedownloader.a.b bVar) {
        HashMap<String, List<String>> wa;
        com.kwad.framework.filedownloader.d.b bVar2 = this.afs;
        if (bVar2 != null && (wa = bVar2.wa()) != null) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.afr), wa);
            }
            for (Map.Entry<String, List<String>> entry : wa.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value != null) {
                    for (String str : value) {
                        bVar.addHeader(key, str);
                    }
                }
            }
        }
    }

    private void b(com.kwad.framework.filedownloader.a.b bVar) {
        String b;
        if (!TextUtils.isEmpty(this.afu)) {
            bVar.addHeader(Util.IF_MATCH, this.afu);
        }
        com.kwad.framework.filedownloader.download.a aVar = this.aft;
        if (aVar.afB == 0) {
            b = com.kwad.framework.filedownloader.f.f.b("bytes=%d-", Long.valueOf(aVar.afA));
        } else {
            b = com.kwad.framework.filedownloader.f.f.b("bytes=%d-%d", Long.valueOf(aVar.afA), Long.valueOf(this.aft.afB));
        }
        bVar.addHeader("Range", b);
    }

    private void c(com.kwad.framework.filedownloader.a.b bVar) {
        com.kwad.framework.filedownloader.d.b bVar2 = this.afs;
        if (bVar2 == null || bVar2.wa().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.kwad.framework.filedownloader.f.f.wJ());
        }
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.afv;
    }

    public final boolean va() {
        if (this.aft.afA > 0) {
            return true;
        }
        return false;
    }

    public final String vb() {
        List<String> list = this.afw;
        if (list != null && !list.isEmpty()) {
            List<String> list2 = this.afw;
            return list2.get(list2.size() - 1);
        }
        return null;
    }

    public final com.kwad.framework.filedownloader.download.a vc() {
        return this.aft;
    }

    public final com.kwad.framework.filedownloader.a.b uZ() {
        com.kwad.framework.filedownloader.a.b ba = b.ve().ba(this.url);
        a(ba);
        b(ba);
        c(ba);
        this.afv = ba.uS();
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.afr), this.afv);
        }
        ba.execute();
        ArrayList arrayList = new ArrayList();
        this.afw = arrayList;
        return com.kwad.framework.filedownloader.a.d.a(this.afv, ba, arrayList);
    }
}
