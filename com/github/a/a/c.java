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
    private static c pQx;
    private static b pQy;
    g pQu;
    private List<d> pQz = new LinkedList();
    i pQv = new i(Looper.getMainLooper().getThread(), pQy.provideDumpInterval());
    h pQw = new h(pQy.provideDumpInterval());

    public c() {
        a(new g(new g.a() { // from class: com.github.a.a.c.1
            @Override // com.github.a.a.g.a
            public void d(long j, long j2, long j3, long j4) {
                ArrayList<String> T = c.this.pQv.T(j, j2);
                if (!T.isEmpty()) {
                    com.github.a.a.a.a eAI = com.github.a.a.a.a.eAH().e(j, j2, j3, j4).ZF(c.this.pQw.getCpuRateInfo()).bo(T).eAI();
                    if (c.eAz().displayNotification()) {
                        f.ZE(eAI.toString());
                    }
                    if (c.this.pQz.size() != 0) {
                        for (d dVar : c.this.pQz) {
                            dVar.onBlock(c.eAz().provideContext(), eAI);
                        }
                    }
                }
            }
        }, eAz().provideBlockThreshold(), eAz().stopWhenDebugging()));
        f.eAE();
    }

    public g eAv() {
        return this.pQu;
    }

    public i eAw() {
        return this.pQv;
    }

    public h eAx() {
        return this.pQw;
    }

    public static c eAy() {
        if (pQx == null) {
            synchronized (c.class) {
                if (pQx == null) {
                    pQx = new c();
                }
            }
        }
        return pQx;
    }

    public static void a(b bVar) {
        pQy = bVar;
    }

    public static b eAz() {
        return pQy;
    }

    public void addBlockInterceptor(d dVar) {
        this.pQz.add(dVar);
    }

    private void a(g gVar) {
        this.pQu = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eAA() {
        return eAz().provideBlockThreshold() * 0.8f;
    }

    static String getPath() {
        String externalStorageState = Environment.getExternalStorageState();
        String providePath = eAz() == null ? "" : eAz().providePath();
        if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath() + providePath;
        }
        return eAz().provideContext().getFilesDir() + eAz().providePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File eAB() {
        File file = new File(getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File[] anh() {
        File eAB = eAB();
        if (eAB.exists() && eAB.isDirectory()) {
            return eAB.listFiles(new a());
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
