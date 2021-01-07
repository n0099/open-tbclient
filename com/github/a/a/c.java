package com.github.a.a;

import android.os.Environment;
import android.os.Looper;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.github.a.a.g;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public final class c {
    private static c pKS;
    private static b pKT;
    g pKP;
    private List<d> pKU = new LinkedList();
    i pKQ = new i(Looper.getMainLooper().getThread(), pKT.provideDumpInterval());
    h pKR = new h(pKT.provideDumpInterval());

    public c() {
        a(new g(new g.a() { // from class: com.github.a.a.c.1
            @Override // com.github.a.a.g.a
            public void d(long j, long j2, long j3, long j4) {
                ArrayList<String> P = c.this.pKQ.P(j, j2);
                if (!P.isEmpty()) {
                    com.github.a.a.a.a eCi = com.github.a.a.a.a.eCh().e(j, j2, j3, j4).ZL(c.this.pKR.getCpuRateInfo()).bu(P).eCi();
                    if (c.eBZ().displayNotification()) {
                        f.ZK(eCi.toString());
                    }
                    if (c.this.pKU.size() != 0) {
                        for (d dVar : c.this.pKU) {
                            dVar.onBlock(c.eBZ().provideContext(), eCi);
                        }
                    }
                }
            }
        }, eBZ().provideBlockThreshold(), eBZ().stopWhenDebugging()));
        f.eCe();
    }

    public g eBV() {
        return this.pKP;
    }

    public i eBW() {
        return this.pKQ;
    }

    public h eBX() {
        return this.pKR;
    }

    public static c eBY() {
        if (pKS == null) {
            synchronized (c.class) {
                if (pKS == null) {
                    pKS = new c();
                }
            }
        }
        return pKS;
    }

    public static void a(b bVar) {
        pKT = bVar;
    }

    public static b eBZ() {
        return pKT;
    }

    public void addBlockInterceptor(d dVar) {
        this.pKU.add(dVar);
    }

    private void a(g gVar) {
        this.pKP = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eCa() {
        return eBZ().provideBlockThreshold() * 0.8f;
    }

    static String getPath() {
        String externalStorageState = Environment.getExternalStorageState();
        String providePath = eBZ() == null ? "" : eBZ().providePath();
        if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath() + providePath;
        }
        return eBZ().provideContext().getFilesDir() + eBZ().providePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File eCb() {
        File file = new File(getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File[] aqE() {
        File eCb = eCb();
        if (eCb.exists() && eCb.isDirectory()) {
            return eCb.listFiles(new a());
        }
        return null;
    }

    /* loaded from: classes6.dex */
    private static class a implements FilenameFilter {
        private String TYPE = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;

        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(this.TYPE);
        }
    }
}
