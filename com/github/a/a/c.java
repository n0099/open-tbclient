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
/* loaded from: classes7.dex */
public final class c {
    private static c psg;
    private static b psh;
    g psd;
    private List<d> psi = new LinkedList();
    i pse = new i(Looper.getMainLooper().getThread(), psh.provideDumpInterval());
    h psf = new h(psh.provideDumpInterval());

    public c() {
        a(new g(new g.a() { // from class: com.github.a.a.c.1
            @Override // com.github.a.a.g.a
            public void d(long j, long j2, long j3, long j4) {
                ArrayList<String> L = c.this.pse.L(j, j2);
                if (!L.isEmpty()) {
                    com.github.a.a.a.a exS = com.github.a.a.a.a.exR().e(j, j2, j3, j4).ZA(c.this.psf.getCpuRateInfo()).bu(L).exS();
                    if (c.exJ().displayNotification()) {
                        f.Zz(exS.toString());
                    }
                    if (c.this.psi.size() != 0) {
                        for (d dVar : c.this.psi) {
                            dVar.onBlock(c.exJ().provideContext(), exS);
                        }
                    }
                }
            }
        }, exJ().provideBlockThreshold(), exJ().stopWhenDebugging()));
        f.exO();
    }

    public g exF() {
        return this.psd;
    }

    public i exG() {
        return this.pse;
    }

    public h exH() {
        return this.psf;
    }

    public static c exI() {
        if (psg == null) {
            synchronized (c.class) {
                if (psg == null) {
                    psg = new c();
                }
            }
        }
        return psg;
    }

    public static void a(b bVar) {
        psh = bVar;
    }

    public static b exJ() {
        return psh;
    }

    public void addBlockInterceptor(d dVar) {
        this.psi.add(dVar);
    }

    private void a(g gVar) {
        this.psd = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long exK() {
        return exJ().provideBlockThreshold() * 0.8f;
    }

    static String getPath() {
        String externalStorageState = Environment.getExternalStorageState();
        String providePath = exJ() == null ? "" : exJ().providePath();
        if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath() + providePath;
        }
        return exJ().provideContext().getFilesDir() + exJ().providePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File exL() {
        File file = new File(getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File[] apr() {
        File exL = exL();
        if (exL.exists() && exL.isDirectory()) {
            return exL.listFiles(new a());
        }
        return null;
    }

    /* loaded from: classes7.dex */
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
