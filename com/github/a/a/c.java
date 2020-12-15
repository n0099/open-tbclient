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
    private static c psi;
    private static b psj;
    g psf;
    private List<d> psk = new LinkedList();
    i psg = new i(Looper.getMainLooper().getThread(), psj.provideDumpInterval());
    h psh = new h(psj.provideDumpInterval());

    public c() {
        a(new g(new g.a() { // from class: com.github.a.a.c.1
            @Override // com.github.a.a.g.a
            public void d(long j, long j2, long j3, long j4) {
                ArrayList<String> L = c.this.psg.L(j, j2);
                if (!L.isEmpty()) {
                    com.github.a.a.a.a exT = com.github.a.a.a.a.exS().e(j, j2, j3, j4).ZA(c.this.psh.getCpuRateInfo()).bu(L).exT();
                    if (c.exK().displayNotification()) {
                        f.Zz(exT.toString());
                    }
                    if (c.this.psk.size() != 0) {
                        for (d dVar : c.this.psk) {
                            dVar.onBlock(c.exK().provideContext(), exT);
                        }
                    }
                }
            }
        }, exK().provideBlockThreshold(), exK().stopWhenDebugging()));
        f.exP();
    }

    public g exG() {
        return this.psf;
    }

    public i exH() {
        return this.psg;
    }

    public h exI() {
        return this.psh;
    }

    public static c exJ() {
        if (psi == null) {
            synchronized (c.class) {
                if (psi == null) {
                    psi = new c();
                }
            }
        }
        return psi;
    }

    public static void a(b bVar) {
        psj = bVar;
    }

    public static b exK() {
        return psj;
    }

    public void addBlockInterceptor(d dVar) {
        this.psk.add(dVar);
    }

    private void a(g gVar) {
        this.psf = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long exL() {
        return exK().provideBlockThreshold() * 0.8f;
    }

    static String getPath() {
        String externalStorageState = Environment.getExternalStorageState();
        String providePath = exK() == null ? "" : exK().providePath();
        if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath() + providePath;
        }
        return exK().provideContext().getFilesDir() + exK().providePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File exM() {
        File file = new File(getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File[] apr() {
        File exM = exM();
        if (exM.exists() && exM.isDirectory()) {
            return exM.listFiles(new a());
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
