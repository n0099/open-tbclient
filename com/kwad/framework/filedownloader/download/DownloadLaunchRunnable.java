package com.kwad.framework.filedownloader.download;

import android.os.Process;
import com.kwad.framework.filedownloader.download.ConnectTask;
import com.kwad.framework.filedownloader.download.c;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadHttpException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.framework.filedownloader.y;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class DownloadLaunchRunnable implements f, Runnable {
    public static final ThreadPoolExecutor afW = com.kwad.framework.filedownloader.f.b.bj("ConnectionBlock");
    public final com.kwad.framework.filedownloader.b.a afG;
    public final d afJ;
    public final int afK;
    public final com.kwad.framework.filedownloader.d.c afL;
    public final com.kwad.framework.filedownloader.d.b afM;
    public final boolean afN;
    public final boolean afO;
    public final y afP;
    public boolean afQ;
    public int afR;
    public final boolean afS;
    public final ArrayList<c> afT;
    public e afU;
    public boolean afV;
    public boolean afX;
    public boolean afY;
    public boolean afZ;
    public final AtomicBoolean aga;
    public volatile boolean agb;
    public volatile Exception agc;
    public String agd;
    public long age;
    public long agf;
    public long agg;
    public long agh;
    public volatile boolean kG;

    /* loaded from: classes10.dex */
    public class DiscardSafely extends Throwable {
        public static final long serialVersionUID = 4243896780616180062L;

        public DiscardSafely() {
        }
    }

    /* loaded from: classes10.dex */
    public class RetryDirectly extends Throwable {
        public static final long serialVersionUID = -4127585119566978768L;

        public RetryDirectly() {
        }
    }

    private boolean vp() {
        if ((this.afX && this.afL.we() <= 1) || !this.afY || !this.afS || this.afZ) {
            return false;
        }
        return true;
    }

    public final int getId() {
        return this.afL.getId();
    }

    public final boolean isAlive() {
        if (!this.aga.get() && !this.afJ.isAlive()) {
            return false;
        }
        return true;
    }

    public final void pause() {
        this.kG = true;
        e eVar = this.afU;
        if (eVar != null) {
            eVar.pause();
        }
        Iterator it = ((ArrayList) this.afT.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.pause();
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void vq() {
        this.afG.c(this.afL.getId(), this.afL.wb());
    }

    public final String vt() {
        return this.afL.vt();
    }

    /* loaded from: classes10.dex */
    public static class a {
        public com.kwad.framework.filedownloader.d.c afL;
        public y afP;
        public com.kwad.framework.filedownloader.d.b afs;
        public Integer agi;
        public Integer agj;
        public Boolean agk;
        public Boolean agl;
        public Integer agm;

        public final a a(y yVar) {
            this.afP = yVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.d.b bVar) {
            this.afs = bVar;
            return this;
        }

        public final a c(Integer num) {
            this.agm = num;
            return this;
        }

        public final a e(com.kwad.framework.filedownloader.d.c cVar) {
            this.afL = cVar;
            return this;
        }

        public final a a(Boolean bool) {
            this.agk = bool;
            return this;
        }

        public final a b(Boolean bool) {
            this.agl = bool;
            return this;
        }

        public final a a(Integer num) {
            this.agi = num;
            return this;
        }

        public final a b(Integer num) {
            this.agj = num;
            return this;
        }

        public final DownloadLaunchRunnable vu() {
            if (this.afL != null && this.afP != null && this.agi != null && this.agj != null && this.agk != null && this.agl != null && this.agm != null) {
                return new DownloadLaunchRunnable(this.afL, this.afs, this.afP, this.agi.intValue(), this.agj.intValue(), this.agk.booleanValue(), this.agl.booleanValue(), this.agm.intValue(), (byte) 0);
            }
            throw new IllegalArgumentException();
        }
    }

    public DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3) {
        this.afK = 5;
        this.afT = new ArrayList<>(5);
        this.age = 0L;
        this.agf = 0L;
        this.agg = 0L;
        this.agh = 0L;
        this.aga = new AtomicBoolean(true);
        this.kG = false;
        this.afQ = false;
        this.afL = cVar;
        this.afM = bVar;
        this.afN = z;
        this.afO = z2;
        this.afG = b.ve().vg();
        this.afS = b.ve().vi();
        this.afP = yVar;
        this.afR = i3;
        this.afJ = new d(cVar, i3, i, i2);
    }

    public /* synthetic */ DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3, byte b) {
        this(cVar, bVar, yVar, i, i2, z, z2, i3);
    }

    private void a(int i, List<com.kwad.framework.filedownloader.d.a> list) {
        if (i > 1 && list.size() == i) {
            b(list, this.afL.getTotal());
            return;
        }
        throw new IllegalArgumentException();
    }

    private void a(long j, String str) {
        com.kwad.framework.filedownloader.e.a aVar = null;
        if (j != -1) {
            try {
                aVar = com.kwad.framework.filedownloader.f.f.bt(this.afL.vt());
                long length = new File(str).length();
                long j2 = j - length;
                long availableBytes = h.getAvailableBytes(str);
                if (availableBytes >= j2) {
                    if (!com.kwad.framework.filedownloader.f.e.wD().aic) {
                        aVar.setLength(j);
                    }
                } else {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j2, length);
                }
            } finally {
                if (0 != 0) {
                    aVar.close();
                }
            }
        }
    }

    private void a(com.kwad.framework.filedownloader.download.a aVar, com.kwad.framework.filedownloader.a.b bVar) {
        if (!this.afY) {
            this.afL.O(0L);
            aVar = new com.kwad.framework.filedownloader.download.a(0L, 0L, aVar.afB, aVar.contentLength);
        }
        e.a aVar2 = new e.a();
        aVar2.b(this).br(this.afL.getId()).bq(-1).be(this.afO).d(bVar).c(aVar).be(this.afL.vt());
        this.afL.by(1);
        this.afG.u(this.afL.getId(), 1);
        this.afU = aVar2.vI();
        if (this.kG) {
            this.afL.d((byte) -2);
            this.afU.pause();
            return;
        }
        this.afU.run();
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwad.framework.filedownloader.a.b bVar) {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        boolean z4;
        long j;
        boolean z5;
        int id = this.afL.getId();
        int responseCode = bVar.getResponseCode();
        if (responseCode != 206 && responseCode != 1) {
            z = false;
        } else {
            z = true;
        }
        this.afY = z;
        if (responseCode != 200 && responseCode != 201 && responseCode != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        String wc = this.afL.wc();
        String a2 = com.kwad.framework.filedownloader.f.f.a(id, bVar);
        if (responseCode == 412 || ((wc != null && !wc.equals(a2) && (z2 || this.afY)) || ((responseCode == 201 && connectTask.va()) || (responseCode == 416 && this.afL.wb() > 0)))) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (this.afX) {
                com.kwad.framework.filedownloader.f.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id), wc, a2, Integer.valueOf(responseCode));
            }
            this.afG.bh(this.afL.getId());
            com.kwad.framework.filedownloader.f.f.y(this.afL.getTargetFilePath(), this.afL.vt());
            this.afX = false;
            if (wc != 0 && wc.equals(a2)) {
                com.kwad.framework.filedownloader.f.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", wc, a2, Integer.valueOf(responseCode), Integer.valueOf(id));
                a2 = null;
            }
            this.afL.O(0L);
            this.afL.Q(0L);
            this.afL.bg(a2);
            this.afL.wf();
            this.afG.a(id, this.afL.wc(), this.afL.wb(), this.afL.getTotal(), this.afL.we());
            throw new RetryDirectly();
        }
        this.agd = connectTask.vb();
        if (!this.afY && !z2) {
            throw new FileDownloadHttpException(responseCode, map, bVar.uT());
        }
        long b = com.kwad.framework.filedownloader.f.f.b(id, bVar);
        if (this.afL.tH()) {
            str = com.kwad.framework.filedownloader.f.f.a(bVar, this.afL.getUrl());
        } else {
            str = null;
        }
        if (b == -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.afZ = z4;
        if (!z4) {
            j = this.afL.wb() + b;
        } else {
            j = b;
        }
        d dVar = this.afJ;
        if (this.afX && this.afY) {
            z5 = true;
        } else {
            z5 = false;
        }
        dVar.a(z5, j, a2, str);
    }

    private void b(long j, int i) {
        long j2;
        long j3 = j / i;
        int id = this.afL.getId();
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == i - 1) {
                j2 = 0;
            } else {
                j2 = (j4 + j3) - 1;
            }
            com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
            aVar.setId(id);
            aVar.setIndex(i2);
            aVar.setStartOffset(j4);
            aVar.M(j4);
            aVar.N(j2);
            arrayList.add(aVar);
            this.afG.a(aVar);
            j4 += j3;
        }
        this.afL.by(i);
        this.afG.u(id, i);
        b(arrayList, j);
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(Exception exc, long j) {
        if (this.kG) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.afL.getId()));
                return;
            }
            return;
        }
        int i = this.afR;
        int i2 = i - 1;
        this.afR = i2;
        if (i < 0) {
            com.kwad.framework.filedownloader.f.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i2), Integer.valueOf(this.afL.getId()));
        }
        this.afJ.a(exc, this.afR, j);
    }

    private void b(List<com.kwad.framework.filedownloader.d.a> list, long j) {
        long vY;
        String str;
        int id = this.afL.getId();
        String wc = this.afL.wc();
        String str2 = this.agd;
        if (str2 == null) {
            str2 = this.afL.getUrl();
        }
        String vt = this.afL.vt();
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j));
        }
        boolean z = this.afX;
        long j2 = 0;
        long j3 = 0;
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.vY() == j2) {
                vY = j - aVar.vX();
            } else {
                vY = (aVar.vY() - aVar.vX()) + 1;
            }
            long j4 = vY;
            j3 += aVar.vX() - aVar.getStartOffset();
            if (j4 == j2) {
                if (com.kwad.framework.filedownloader.f.d.ahW) {
                    com.kwad.framework.filedownloader.f.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
                }
            } else {
                c.a aVar2 = new c.a();
                com.kwad.framework.filedownloader.download.a aVar3 = new com.kwad.framework.filedownloader.download.a(aVar.getStartOffset(), aVar.vX(), aVar.vY(), j4);
                c.a bb = aVar2.bo(id).d(Integer.valueOf(aVar.getIndex())).a(this).bb(str2);
                if (z) {
                    str = wc;
                } else {
                    str = null;
                }
                c vv = bb.bc(str).c(this.afM).bc(this.afO).b(aVar3).bd(vt).vv();
                if (com.kwad.framework.filedownloader.f.d.ahW) {
                    com.kwad.framework.filedownloader.f.d.c(this, "enable multiple connection: %s", aVar);
                }
                this.afT.add(vv);
            }
            j2 = 0;
        }
        if (j3 != this.afL.wb()) {
            com.kwad.framework.filedownloader.f.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.afL.wb()), Long.valueOf(j3));
            this.afL.O(j3);
        }
        ArrayList arrayList = new ArrayList(this.afT.size());
        Iterator<c> it = this.afT.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (this.kG) {
                next.pause();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.kG) {
            this.afL.d((byte) -2);
            return;
        }
        List<Future> invokeAll = afW.invokeAll(arrayList);
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            for (Future future : invokeAll) {
                com.kwad.framework.filedownloader.f.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.kwad.framework.filedownloader.download.a p(List<com.kwad.framework.filedownloader.d.a> list) {
        boolean z;
        long wb;
        long j;
        int we = this.afL.we();
        String vt = this.afL.vt();
        String targetFilePath = this.afL.getTargetFilePath();
        boolean z2 = false;
        if (we > 1) {
            z = true;
        } else {
            z = false;
        }
        if ((!z || this.afS) && com.kwad.framework.filedownloader.f.f.b(this.afL.getId(), this.afL)) {
            if (!this.afS) {
                wb = new File(vt).length();
            } else if (z) {
                if (we == list.size()) {
                    wb = com.kwad.framework.filedownloader.d.a.q(list);
                }
            } else {
                wb = this.afL.wb();
            }
            j = wb;
            this.afL.O(j);
            if (j > 0) {
                z2 = true;
            }
            this.afX = z2;
            if (!z2) {
                this.afG.bh(this.afL.getId());
                com.kwad.framework.filedownloader.f.f.y(targetFilePath, vt);
            }
            return new com.kwad.framework.filedownloader.download.a(0L, j, 0L, this.afL.getTotal() - j);
        }
        j = 0;
        this.afL.O(j);
        if (j > 0) {
        }
        this.afX = z2;
        if (!z2) {
        }
        return new com.kwad.framework.filedownloader.download.a(0L, j, 0L, this.afL.getTotal() - j);
    }

    private void vr() {
        if (this.afO && !com.kwad.framework.filedownloader.f.f.br("android.permission.ACCESS_NETWORK_STATE")) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.afL.getId()), "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.afO && com.kwad.framework.filedownloader.f.f.wI()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    public final void vo() {
        if (this.afL.we() > 1) {
            List<com.kwad.framework.filedownloader.d.a> bg = this.afG.bg(this.afL.getId());
            if (this.afL.we() == bg.size()) {
                this.afL.O(com.kwad.framework.filedownloader.d.a.q(bg));
            } else {
                this.afL.O(0L);
                this.afG.bh(this.afL.getId());
            }
        }
        this.afJ.vx();
    }

    private void vs() {
        int id = this.afL.getId();
        if (this.afL.tH()) {
            String targetFilePath = this.afL.getTargetFilePath();
            int x = com.kwad.framework.filedownloader.f.f.x(this.afL.getUrl(), targetFilePath);
            if (!com.kwad.framework.filedownloader.f.c.a(id, targetFilePath, this.afN, false)) {
                com.kwad.framework.filedownloader.d.c bf = this.afG.bf(x);
                if (bf != null) {
                    if (!com.kwad.framework.filedownloader.f.c.a(id, bf, this.afP, false)) {
                        List<com.kwad.framework.filedownloader.d.a> bg = this.afG.bg(x);
                        this.afG.bi(x);
                        this.afG.bh(x);
                        com.kwad.framework.filedownloader.f.f.bv(this.afL.getTargetFilePath());
                        if (com.kwad.framework.filedownloader.f.f.b(x, bf)) {
                            this.afL.O(bf.wb());
                            this.afL.Q(bf.getTotal());
                            this.afL.bg(bf.wc());
                            this.afL.by(bf.we());
                            this.afG.b(this.afL);
                            if (bg != null) {
                                for (com.kwad.framework.filedownloader.d.a aVar : bg) {
                                    aVar.setId(id);
                                    this.afG.a(aVar);
                                }
                            }
                            throw new RetryDirectly();
                        }
                    } else {
                        this.afG.bi(id);
                        this.afG.bh(id);
                        throw new DiscardSafely();
                    }
                }
                if (com.kwad.framework.filedownloader.f.c.a(id, this.afL.wb(), this.afL.vt(), targetFilePath, this.afP)) {
                    this.afG.bi(id);
                    this.afG.bh(id);
                    throw new DiscardSafely();
                }
                return;
            }
            this.afG.bi(id);
            this.afG.bh(id);
            throw new DiscardSafely();
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(c cVar, long j, long j2) {
        int i;
        if (this.kG) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.afL.getId()));
                return;
            }
            return;
        }
        if (cVar == null) {
            i = -1;
        } else {
            i = cVar.agq;
        }
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.afL.getTotal()));
        }
        if (this.afV) {
            if (j != 0 && j2 != this.afL.getTotal()) {
                com.kwad.framework.filedownloader.f.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.afL.getTotal()), Integer.valueOf(this.afL.getId()));
                return;
            }
            return;
        }
        synchronized (this.afT) {
            this.afT.remove(cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final boolean a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.afV && code == 416 && !this.afQ) {
                com.kwad.framework.filedownloader.f.f.y(this.afL.getTargetFilePath(), this.afL.vt());
                this.afQ = true;
                return true;
            }
        }
        if (this.afR > 0 && !(exc instanceof FileDownloadGiveUpRetryException)) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void b(Exception exc) {
        this.agb = true;
        this.agc = exc;
        if (this.kG) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.afL.getId()));
                return;
            }
            return;
        }
        Iterator it = ((ArrayList) this.afT.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.uA();
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void onProgress(long j) {
        if (this.kG) {
            return;
        }
        this.afJ.onProgress(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e7, code lost:
        if (r9 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e9, code lost:
        r9.uU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ff, code lost:
        throw new java.lang.IllegalAccessException(com.kwad.framework.filedownloader.f.f.b("invalid connection count %d, the connection count must be larger than 0", r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
        if (com.kwad.framework.filedownloader.f.d.ahW == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        com.kwad.framework.filedownloader.f.d.c(r19, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r19.afL.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b2, code lost:
        r19.afJ.vw();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
        if (r19.kG == false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00be, code lost:
        if (r19.agb == false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
        r19.afJ.vB();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c8, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
        if (r19.kG == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0122, code lost:
        r19.afL.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0127, code lost:
        if (r9 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0129, code lost:
        r9.uU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012c, code lost:
        r19.afJ.vw();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0133, code lost:
        if (r19.kG == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0139, code lost:
        if (r19.agb == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013d, code lost:
        r19.afJ.vB();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0144, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0145, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0148, code lost:
        vs();
        r14 = r19.afL.getTotal();
        a(r14, r19.afL.vt());
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015e, code lost:
        if (vp() == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0162, code lost:
        if (r19.afX == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0164, code lost:
        r10 = r19.afL.we();
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016d, code lost:
        r17 = r14;
        r10 = com.kwad.framework.filedownloader.download.b.ve().a(r19.afL.getId(), r19.afL.getUrl(), r19.afL.getPath(), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018d, code lost:
        r17 = r14;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0190, code lost:
        if (r10 <= 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0194, code lost:
        if (r19.kG == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
        r19.afL.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019b, code lost:
        if (r9 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019d, code lost:
        r9.uU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a0, code lost:
        r19.afJ.vw();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a7, code lost:
        if (r19.kG == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ad, code lost:
        if (r19.agb == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b1, code lost:
        r19.afJ.vB();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b9, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01bc, code lost:
        if (r10 != 1) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01be, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c0, code lost:
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c1, code lost:
        r19.afV = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c3, code lost:
        if (r11 == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c5, code lost:
        a(r8.vc(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cd, code lost:
        if (r9 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cf, code lost:
        r9.uU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d3, code lost:
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d4, code lost:
        r19.afJ.vz();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01db, code lost:
        if (r19.afX == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01dd, code lost:
        a(r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e1, code lost:
        b(r17, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e6, code lost:
        r9 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x025e A[Catch: all -> 0x0219, TryCatch #27 {all -> 0x0219, blocks: (B:46:0x00cf, B:95:0x01d4, B:97:0x01dd, B:98:0x01e1, B:155:0x0258, B:157:0x025e, B:160:0x0266, B:126:0x021c), top: B:205:0x0258 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0271 A[Catch: all -> 0x0291, TryCatch #25 {all -> 0x0291, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:25:0x0090, B:27:0x0094, B:28:0x0099, B:30:0x009d, B:32:0x00a1, B:43:0x00ca, B:51:0x0129, B:74:0x019d, B:101:0x01e9, B:164:0x0271, B:165:0x0274, B:130:0x022b, B:128:0x0224, B:162:0x026b), top: B:204:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0266 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        IOException iOException;
        Exception exc;
        Throwable th;
        ConnectTask vd;
        com.kwad.framework.filedownloader.a.b uZ;
        try {
            Process.setThreadPriority(10);
            if (this.afL.tL() != 1) {
                if (this.afL.tL() == -2) {
                    if (com.kwad.framework.filedownloader.f.d.ahW) {
                        com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.afL.getId()));
                    }
                } else {
                    b(new RuntimeException(com.kwad.framework.filedownloader.f.f.b("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.afL.getId()), Byte.valueOf(this.afL.tL()), (byte) 1)));
                }
                this.afJ.vw();
                if (!this.kG) {
                    if (!this.agb) {
                        try {
                            this.afJ.vB();
                        } catch (IOException e) {
                            iOException = e;
                            this.afJ.c(iOException);
                            this.aga.set(false);
                        }
                    }
                    this.afJ.c(this.agc);
                }
                this.afJ.vA();
            } else {
                if (!this.kG) {
                    this.afJ.vy();
                }
                while (true) {
                    if (!this.kG) {
                        if (this.afG == null) {
                            break;
                        }
                        com.kwad.framework.filedownloader.a.b bVar = null;
                        try {
                            vr();
                            List<com.kwad.framework.filedownloader.d.a> bg = this.afG.bg(this.afL.getId());
                            vd = new ConnectTask.a().bn(this.afL.getId()).aY(this.afL.getUrl()).aZ(this.afL.wc()).a(this.afM).a(p(bg)).vd();
                            uZ = vd.uZ();
                        } catch (DiscardSafely unused) {
                        } catch (RetryDirectly unused2) {
                        } catch (FileDownloadGiveUpRetryException e2) {
                            e = e2;
                            exc = e;
                            try {
                                if (!a(exc)) {
                                    a(exc, 0L);
                                    if (bVar != null) {
                                        bVar.uU();
                                    }
                                } else {
                                    b(exc);
                                    if (bVar != null) {
                                        bVar.uU();
                                    }
                                    this.afJ.vw();
                                    if (!this.kG) {
                                    }
                                    this.afJ.vA();
                                    this.aga.set(false);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (bVar != null) {
                                    bVar.uU();
                                }
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            exc = e;
                            if (!a(exc)) {
                            }
                        } catch (ArrayIndexOutOfBoundsException e4) {
                            e = e4;
                            exc = e;
                            if (!a(exc)) {
                            }
                        } catch (IllegalAccessException e5) {
                            e = e5;
                            exc = e;
                            if (!a(exc)) {
                            }
                        } catch (IllegalArgumentException e6) {
                            e = e6;
                            exc = e;
                            if (!a(exc)) {
                            }
                        } catch (InterruptedException e7) {
                            e = e7;
                            exc = e;
                            if (!a(exc)) {
                            }
                        } catch (NullPointerException e8) {
                            e = e8;
                            exc = e;
                            if (!a(exc)) {
                            }
                        }
                        try {
                            a(vd.getRequestHeader(), vd, uZ);
                            break;
                        } catch (DiscardSafely unused3) {
                            bVar = uZ;
                            if (bVar != null) {
                                bVar.uU();
                            }
                            this.afJ.vw();
                            if (!this.kG) {
                                if (!this.agb) {
                                    try {
                                        this.afJ.vB();
                                    } catch (IOException e9) {
                                        iOException = e9;
                                        this.afJ.c(iOException);
                                        this.aga.set(false);
                                    }
                                    this.aga.set(false);
                                }
                                this.afJ.c(this.agc);
                                this.aga.set(false);
                            }
                            this.afJ.vA();
                            this.aga.set(false);
                        } catch (RetryDirectly unused4) {
                            bVar = uZ;
                            this.afL.d((byte) 5);
                            if (bVar != null) {
                                bVar.uU();
                            }
                        } catch (FileDownloadGiveUpRetryException e10) {
                            e = e10;
                            exc = e;
                            bVar = uZ;
                            if (!a(exc)) {
                            }
                        } catch (IOException e11) {
                            e = e11;
                            exc = e;
                            bVar = uZ;
                            if (!a(exc)) {
                            }
                        } catch (ArrayIndexOutOfBoundsException e12) {
                            e = e12;
                            exc = e;
                            bVar = uZ;
                            if (!a(exc)) {
                            }
                        } catch (IllegalAccessException e13) {
                            e = e13;
                            exc = e;
                            bVar = uZ;
                            if (!a(exc)) {
                            }
                        } catch (IllegalArgumentException e14) {
                            e = e14;
                            exc = e;
                            bVar = uZ;
                            if (!a(exc)) {
                            }
                        } catch (InterruptedException e15) {
                            e = e15;
                            exc = e;
                            bVar = uZ;
                            if (!a(exc)) {
                            }
                        } catch (NullPointerException e16) {
                            e = e16;
                            exc = e;
                            bVar = uZ;
                            if (!a(exc)) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bVar = uZ;
                            if (bVar != null) {
                            }
                            throw th;
                        }
                    } else {
                        break;
                    }
                }
                this.afJ.vw();
                if (!this.kG) {
                    if (!this.agb) {
                        try {
                            this.afJ.vB();
                        } catch (IOException e17) {
                            iOException = e17;
                            this.afJ.c(iOException);
                            this.aga.set(false);
                        }
                    }
                    this.afJ.c(this.agc);
                }
                this.afJ.vA();
            }
            this.aga.set(false);
        } catch (Throwable th4) {
            this.afJ.vw();
            if (!this.kG) {
                if (this.agb) {
                    this.afJ.c(this.agc);
                } else {
                    try {
                        this.afJ.vB();
                    } catch (IOException e18) {
                        this.afJ.c(e18);
                    }
                }
            } else {
                this.afJ.vA();
            }
            this.aga.set(false);
            throw th4;
        }
    }
}
