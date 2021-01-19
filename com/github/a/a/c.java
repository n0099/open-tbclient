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
    private static c pGs;
    private static b pGt;
    g pGp;
    private List<d> pGu = new LinkedList();
    i pGq = new i(Looper.getMainLooper().getThread(), pGt.provideDumpInterval());
    h pGr = new h(pGt.provideDumpInterval());

    public c() {
        a(new g(new g.a() { // from class: com.github.a.a.c.1
            @Override // com.github.a.a.g.a
            public void d(long j, long j2, long j3, long j4) {
                ArrayList<String> P = c.this.pGq.P(j, j2);
                if (!P.isEmpty()) {
                    com.github.a.a.a.a eyq = com.github.a.a.a.a.eyp().e(j, j2, j3, j4).YE(c.this.pGr.getCpuRateInfo()).bp(P).eyq();
                    if (c.eyh().displayNotification()) {
                        f.YD(eyq.toString());
                    }
                    if (c.this.pGu.size() != 0) {
                        for (d dVar : c.this.pGu) {
                            dVar.onBlock(c.eyh().provideContext(), eyq);
                        }
                    }
                }
            }
        }, eyh().provideBlockThreshold(), eyh().stopWhenDebugging()));
        f.eym();
    }

    public g eyd() {
        return this.pGp;
    }

    public i eye() {
        return this.pGq;
    }

    public h eyf() {
        return this.pGr;
    }

    public static c eyg() {
        if (pGs == null) {
            synchronized (c.class) {
                if (pGs == null) {
                    pGs = new c();
                }
            }
        }
        return pGs;
    }

    public static void a(b bVar) {
        pGt = bVar;
    }

    public static b eyh() {
        return pGt;
    }

    public void addBlockInterceptor(d dVar) {
        this.pGu.add(dVar);
    }

    private void a(g gVar) {
        this.pGp = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eyi() {
        return eyh().provideBlockThreshold() * 0.8f;
    }

    static String getPath() {
        String externalStorageState = Environment.getExternalStorageState();
        String providePath = eyh() == null ? "" : eyh().providePath();
        if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath() + providePath;
        }
        return eyh().provideContext().getFilesDir() + eyh().providePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File eyj() {
        File file = new File(getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File[] amJ() {
        File eyj = eyj();
        if (eyj.exists() && eyj.isDirectory()) {
            return eyj.listFiles(new a());
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
