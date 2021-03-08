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
/* loaded from: classes5.dex */
public final class c {
    private static c pRM;
    private static b pRN;
    g pRJ;
    private List<d> pRO = new LinkedList();
    i pRK = new i(Looper.getMainLooper().getThread(), pRN.provideDumpInterval());
    h pRL = new h(pRN.provideDumpInterval());

    public c() {
        a(new g(new g.a() { // from class: com.github.a.a.c.1
            @Override // com.github.a.a.g.a
            public void d(long j, long j2, long j3, long j4) {
                ArrayList<String> T = c.this.pRK.T(j, j2);
                if (!T.isEmpty()) {
                    com.github.a.a.a.a eAW = com.github.a.a.a.a.eAV().e(j, j2, j3, j4).ZW(c.this.pRL.getCpuRateInfo()).bo(T).eAW();
                    if (c.eAN().displayNotification()) {
                        f.ZV(eAW.toString());
                    }
                    if (c.this.pRO.size() != 0) {
                        for (d dVar : c.this.pRO) {
                            dVar.onBlock(c.eAN().provideContext(), eAW);
                        }
                    }
                }
            }
        }, eAN().provideBlockThreshold(), eAN().stopWhenDebugging()));
        f.eAS();
    }

    public g eAJ() {
        return this.pRJ;
    }

    public i eAK() {
        return this.pRK;
    }

    public h eAL() {
        return this.pRL;
    }

    public static c eAM() {
        if (pRM == null) {
            synchronized (c.class) {
                if (pRM == null) {
                    pRM = new c();
                }
            }
        }
        return pRM;
    }

    public static void a(b bVar) {
        pRN = bVar;
    }

    public static b eAN() {
        return pRN;
    }

    public void addBlockInterceptor(d dVar) {
        this.pRO.add(dVar);
    }

    private void a(g gVar) {
        this.pRJ = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eAO() {
        return eAN().provideBlockThreshold() * 0.8f;
    }

    static String getPath() {
        String externalStorageState = Environment.getExternalStorageState();
        String providePath = eAN() == null ? "" : eAN().providePath();
        if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath() + providePath;
        }
        return eAN().provideContext().getFilesDir() + eAN().providePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File eAP() {
        File file = new File(getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File[] ank() {
        File eAP = eAP();
        if (eAP.exists() && eAP.isDirectory()) {
            return eAP.listFiles(new a());
        }
        return null;
    }

    /* loaded from: classes5.dex */
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
