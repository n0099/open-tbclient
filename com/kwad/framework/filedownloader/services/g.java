package com.kwad.framework.filedownloader.services;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import com.kwad.framework.filedownloader.y;
import java.util.List;
/* loaded from: classes10.dex */
public final class g implements y {
    public final h ahL = new h(com.kwad.framework.filedownloader.download.b.ve().vh());

    public static com.kwad.framework.filedownloader.b.a wt() {
        return com.kwad.framework.filedownloader.download.b.ve().vg();
    }

    public final boolean isIdle() {
        if (this.ahL.ww() <= 0) {
            return true;
        }
        return false;
    }

    public final void vL() {
        wt().clear();
    }

    private boolean bD(int i) {
        return a(wt().bf(i));
    }

    public final boolean aY(int i) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i));
        }
        com.kwad.framework.filedownloader.d.c bf = wt().bf(i);
        if (bf == null) {
            return false;
        }
        bf.d((byte) -2);
        this.ahL.cancel(i);
        return true;
    }

    public final byte aZ(int i) {
        com.kwad.framework.filedownloader.d.c bf = wt().bf(i);
        if (bf == null) {
            return (byte) 0;
        }
        return bf.tL();
    }

    public final long bE(int i) {
        com.kwad.framework.filedownloader.b.a wt = wt();
        com.kwad.framework.filedownloader.d.c bf = wt.bf(i);
        if (bf == null) {
            return 0L;
        }
        int we = bf.we();
        if (we <= 1) {
            return bf.wb();
        }
        List<com.kwad.framework.filedownloader.d.a> bg = wt.bg(i);
        if (bg == null || bg.size() != we) {
            return 0L;
        }
        return com.kwad.framework.filedownloader.d.a.q(bg);
    }

    public final boolean ba(int i) {
        if (i == 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
            return false;
        } else if (bD(i)) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
            return false;
        } else {
            com.kwad.framework.filedownloader.b.a wt = wt();
            wt.bi(i);
            wt.bh(i);
            return true;
        }
    }

    public final synchronized boolean bs(int i) {
        return this.ahL.bs(i);
    }

    public final long bu(int i) {
        com.kwad.framework.filedownloader.d.c bf = wt().bf(i);
        if (bf == null) {
            return 0L;
        }
        return bf.getTotal();
    }

    @Override // com.kwad.framework.filedownloader.y
    public final boolean a(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean bF = this.ahL.bF(cVar.getId());
        if (com.kwad.framework.filedownloader.d.d.bA(cVar.tL())) {
            if (!bF) {
                return false;
            }
        } else if (!bF) {
            com.kwad.framework.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.tL()));
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0177 A[Catch: all -> 0x01c0, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0033, B:12:0x0041, B:14:0x004b, B:16:0x004f, B:17:0x0062, B:21:0x0070, B:23:0x0076, B:25:0x007a, B:29:0x008b, B:31:0x0094, B:33:0x009d, B:35:0x00a1, B:40:0x00b4, B:43:0x00bd, B:45:0x00c6, B:47:0x00d5, B:49:0x00d9, B:51:0x00ea, B:55:0x00f4, B:57:0x00fb, B:59:0x0102, B:61:0x0108, B:63:0x010f, B:65:0x0115, B:67:0x011b, B:69:0x0131, B:70:0x0135, B:72:0x013b, B:81:0x0177, B:82:0x017a, B:73:0x0148, B:75:0x0152, B:77:0x0158, B:78:0x015d, B:44:0x00c2, B:30:0x0090), top: B:88:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        com.kwad.framework.filedownloader.d.c cVar;
        List<com.kwad.framework.filedownloader.d.a> list;
        String a;
        long j;
        String bm;
        boolean z4 = false;
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z));
        }
        int g = com.kwad.framework.filedownloader.f.f.g(str, str2, z);
        com.kwad.framework.filedownloader.b.a wt = wt();
        com.kwad.framework.filedownloader.d.c bf = wt.bf(g);
        if (!z && bf == null) {
            int g2 = com.kwad.framework.filedownloader.f.f.g(str, com.kwad.framework.filedownloader.f.f.bp(str2), true);
            com.kwad.framework.filedownloader.d.c bf2 = wt.bf(g2);
            if (bf2 != null && str2.equals(bf2.getTargetFilePath())) {
                if (com.kwad.framework.filedownloader.f.d.ahW) {
                    com.kwad.framework.filedownloader.f.d.c(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(g), Integer.valueOf(g2));
                }
                list = wt.bg(g2);
            } else {
                list = null;
            }
            cVar = bf2;
        } else {
            cVar = bf;
            list = null;
        }
        if (com.kwad.framework.filedownloader.f.c.a(g, cVar, (y) this, true)) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "has already started download %d", Integer.valueOf(g));
            }
            return;
        }
        if (cVar != null) {
            a = cVar.getTargetFilePath();
        } else {
            a = com.kwad.framework.filedownloader.f.f.a(str2, z, (String) null);
        }
        String str3 = a;
        if (com.kwad.framework.filedownloader.f.c.a(g, str3, z2, true)) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "has already completed downloading %d", Integer.valueOf(g));
            }
            return;
        }
        if (cVar != null) {
            j = cVar.wb();
        } else {
            j = 0;
        }
        if (cVar != null) {
            bm = cVar.vt();
        } else {
            bm = com.kwad.framework.filedownloader.f.f.bm(str3);
        }
        if (com.kwad.framework.filedownloader.f.c.a(g, j, bm, str3, this)) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(g), str3);
                if (cVar != null) {
                    wt.bi(g);
                    wt.bh(g);
                }
            }
            return;
        }
        if (cVar != null && (cVar.tL() == -2 || cVar.tL() == -1 || cVar.tL() == 1 || cVar.tL() == 6 || cVar.tL() == 2)) {
            if (cVar.getId() != g) {
                wt.bi(cVar.getId());
                wt.bh(cVar.getId());
                cVar.setId(g);
                cVar.d(str2, z);
                if (list != null) {
                    for (com.kwad.framework.filedownloader.d.a aVar : list) {
                        aVar.setId(g);
                        wt.a(aVar);
                    }
                }
            } else {
                if (!TextUtils.equals(str, cVar.getUrl())) {
                    cVar.setUrl(str);
                }
                if (z4) {
                    wt.b(cVar);
                }
                this.ahL.a(new DownloadLaunchRunnable.a().e(cVar).b(bVar).a(this).a(Integer.valueOf(i2)).b(Integer.valueOf(i)).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).c(Integer.valueOf(i3)).vu());
            }
        } else {
            if (cVar == null) {
                cVar = new com.kwad.framework.filedownloader.d.c();
            }
            cVar.setUrl(str);
            cVar.d(str2, z);
            cVar.setId(g);
            cVar.O(0L);
            cVar.Q(0L);
            cVar.d((byte) 1);
            cVar.by(1);
        }
        z4 = true;
        if (z4) {
        }
        this.ahL.a(new DownloadLaunchRunnable.a().e(cVar).b(bVar).a(this).a(Integer.valueOf(i2)).b(Integer.valueOf(i)).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).c(Integer.valueOf(i3)).vu());
    }

    @Override // com.kwad.framework.filedownloader.y
    public final int p(String str, int i) {
        return this.ahL.p(str, i);
    }

    public final boolean t(String str, String str2) {
        return bD(com.kwad.framework.filedownloader.f.f.x(str, str2));
    }

    public final void wu() {
        List<Integer> wx = this.ahL.wx();
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(wx.size()));
        }
        for (Integer num : wx) {
            aY(num.intValue());
        }
    }
}
