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
    private static c pQX;
    private static b pQY;
    g pQU;
    private List<d> pQZ = new LinkedList();
    i pQV = new i(Looper.getMainLooper().getThread(), pQY.provideDumpInterval());
    h pQW = new h(pQY.provideDumpInterval());

    public c() {
        a(new g(new g.a() { // from class: com.github.a.a.c.1
            @Override // com.github.a.a.g.a
            public void d(long j, long j2, long j3, long j4) {
                ArrayList<String> T = c.this.pQV.T(j, j2);
                if (!T.isEmpty()) {
                    com.github.a.a.a.a eAQ = com.github.a.a.a.a.eAP().e(j, j2, j3, j4).ZR(c.this.pQW.getCpuRateInfo()).bo(T).eAQ();
                    if (c.eAH().displayNotification()) {
                        f.ZQ(eAQ.toString());
                    }
                    if (c.this.pQZ.size() != 0) {
                        for (d dVar : c.this.pQZ) {
                            dVar.onBlock(c.eAH().provideContext(), eAQ);
                        }
                    }
                }
            }
        }, eAH().provideBlockThreshold(), eAH().stopWhenDebugging()));
        f.eAM();
    }

    public g eAD() {
        return this.pQU;
    }

    public i eAE() {
        return this.pQV;
    }

    public h eAF() {
        return this.pQW;
    }

    public static c eAG() {
        if (pQX == null) {
            synchronized (c.class) {
                if (pQX == null) {
                    pQX = new c();
                }
            }
        }
        return pQX;
    }

    public static void a(b bVar) {
        pQY = bVar;
    }

    public static b eAH() {
        return pQY;
    }

    public void addBlockInterceptor(d dVar) {
        this.pQZ.add(dVar);
    }

    private void a(g gVar) {
        this.pQU = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eAI() {
        return eAH().provideBlockThreshold() * 0.8f;
    }

    static String getPath() {
        String externalStorageState = Environment.getExternalStorageState();
        String providePath = eAH() == null ? "" : eAH().providePath();
        if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath() + providePath;
        }
        return eAH().provideContext().getFilesDir() + eAH().providePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File eAJ() {
        File file = new File(getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File[] anh() {
        File eAJ = eAJ();
        if (eAJ.exists() && eAJ.isDirectory()) {
            return eAJ.listFiles(new a());
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
