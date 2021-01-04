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
/* loaded from: classes15.dex */
public final class c {
    private static c pJk;
    private static b pJl;
    g pJh;
    private List<d> pJm = new LinkedList();
    i pJi = new i(Looper.getMainLooper().getThread(), pJl.provideDumpInterval());
    h pJj = new h(pJl.provideDumpInterval());

    public c() {
        a(new g(new g.a() { // from class: com.github.a.a.c.1
            @Override // com.github.a.a.g.a
            public void d(long j, long j2, long j3, long j4) {
                ArrayList<String> O = c.this.pJi.O(j, j2);
                if (!O.isEmpty()) {
                    com.github.a.a.a.a eBE = com.github.a.a.a.a.eBD().e(j, j2, j3, j4).ZK(c.this.pJj.getCpuRateInfo()).bu(O).eBE();
                    if (c.eBv().displayNotification()) {
                        f.ZJ(eBE.toString());
                    }
                    if (c.this.pJm.size() != 0) {
                        for (d dVar : c.this.pJm) {
                            dVar.onBlock(c.eBv().provideContext(), eBE);
                        }
                    }
                }
            }
        }, eBv().provideBlockThreshold(), eBv().stopWhenDebugging()));
        f.eBA();
    }

    public g eBr() {
        return this.pJh;
    }

    public i eBs() {
        return this.pJi;
    }

    public h eBt() {
        return this.pJj;
    }

    public static c eBu() {
        if (pJk == null) {
            synchronized (c.class) {
                if (pJk == null) {
                    pJk = new c();
                }
            }
        }
        return pJk;
    }

    public static void a(b bVar) {
        pJl = bVar;
    }

    public static b eBv() {
        return pJl;
    }

    public void addBlockInterceptor(d dVar) {
        this.pJm.add(dVar);
    }

    private void a(g gVar) {
        this.pJh = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eBw() {
        return eBv().provideBlockThreshold() * 0.8f;
    }

    static String getPath() {
        String externalStorageState = Environment.getExternalStorageState();
        String providePath = eBv() == null ? "" : eBv().providePath();
        if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath() + providePath;
        }
        return eBv().provideContext().getFilesDir() + eBv().providePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File eBx() {
        File file = new File(getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File[] aqD() {
        File eBx = eBx();
        if (eBx.exists() && eBx.isDirectory()) {
            return eBx.listFiles(new a());
        }
        return null;
    }

    /* loaded from: classes15.dex */
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
