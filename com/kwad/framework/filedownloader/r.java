package com.kwad.framework.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;
import java.util.List;
/* loaded from: classes10.dex */
public class r {
    public static final Object aeM = new Object();
    public static final Object aeO = new Object();
    public w aeN;
    public volatile v aeP;

    /* loaded from: classes10.dex */
    public static final class a {
        public static final r aeQ = new r();
    }

    public static r uK() {
        return a.aeQ;
    }

    public static boolean uM() {
        return n.uC().isConnected();
    }

    public final void uL() {
        if (!uM()) {
            n.uC().ak(com.kwad.framework.filedownloader.f.c.wB());
        }
    }

    public final w uN() {
        if (this.aeN == null) {
            synchronized (aeM) {
                if (this.aeN == null) {
                    this.aeN = new ab();
                }
            }
        }
        return this.aeN;
    }

    public final v uO() {
        if (this.aeP == null) {
            synchronized (aeO) {
                if (this.aeP == null) {
                    this.aeP = new z();
                    a((e) this.aeP);
                }
            }
        }
        return this.aeP;
    }

    public static void a(Context context, c.b bVar) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(r.class, "init Downloader with params: %s %s", context, bVar);
        }
        if (context != null) {
            com.kwad.framework.filedownloader.f.c.am(context.getApplicationContext());
            com.kwad.framework.filedownloader.download.b.ve().a(bVar);
            return;
        }
        throw new IllegalArgumentException("the provided context must not be null!");
    }

    public static void a(e eVar) {
        f.up().a("event.service.connect.changed", eVar);
    }

    public static com.kwad.framework.filedownloader.a aV(String str) {
        return new c(str);
    }

    public static void al(Context context) {
        com.kwad.framework.filedownloader.f.c.am(context.getApplicationContext());
    }

    private int bb(int i) {
        List<a.InterfaceC0677a> aW = h.ur().aW(i);
        if (aW.isEmpty()) {
            com.kwad.framework.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i));
            return 0;
        }
        for (a.InterfaceC0677a interfaceC0677a : aW) {
            interfaceC0677a.tT().pause();
        }
        return aW.size();
    }

    public final boolean n(int i, String str) {
        bb(i);
        if (n.uC().ba(i)) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            File file = new File(com.kwad.framework.filedownloader.f.f.bm(str));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            }
            return true;
        }
        return false;
    }
}
