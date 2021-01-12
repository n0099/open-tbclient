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
    private static c pGr;
    private static b pGs;
    g pGo;
    private List<d> pGt = new LinkedList();
    i pGp = new i(Looper.getMainLooper().getThread(), pGs.provideDumpInterval());
    h pGq = new h(pGs.provideDumpInterval());

    public c() {
        a(new g(new g.a() { // from class: com.github.a.a.c.1
            @Override // com.github.a.a.g.a
            public void d(long j, long j2, long j3, long j4) {
                ArrayList<String> P = c.this.pGp.P(j, j2);
                if (!P.isEmpty()) {
                    com.github.a.a.a.a eyq = com.github.a.a.a.a.eyp().e(j, j2, j3, j4).YD(c.this.pGq.getCpuRateInfo()).bp(P).eyq();
                    if (c.eyh().displayNotification()) {
                        f.YC(eyq.toString());
                    }
                    if (c.this.pGt.size() != 0) {
                        for (d dVar : c.this.pGt) {
                            dVar.onBlock(c.eyh().provideContext(), eyq);
                        }
                    }
                }
            }
        }, eyh().provideBlockThreshold(), eyh().stopWhenDebugging()));
        f.eym();
    }

    public g eyd() {
        return this.pGo;
    }

    public i eye() {
        return this.pGp;
    }

    public h eyf() {
        return this.pGq;
    }

    public static c eyg() {
        if (pGr == null) {
            synchronized (c.class) {
                if (pGr == null) {
                    pGr = new c();
                }
            }
        }
        return pGr;
    }

    public static void a(b bVar) {
        pGs = bVar;
    }

    public static b eyh() {
        return pGs;
    }

    public void addBlockInterceptor(d dVar) {
        this.pGt.add(dVar);
    }

    private void a(g gVar) {
        this.pGo = gVar;
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
