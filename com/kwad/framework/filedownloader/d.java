package com.kwad.framework.filedownloader;

import com.baidu.android.imsdk.internal.Constants;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.s;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class d implements a.c, x, x.a, x.b {
    public final Object adR;
    public t adV;
    public final a adW;
    public volatile long adY;
    public final s.b aea;
    public final s.a aeb;
    public long aec;
    public long aed;
    public int aee;
    public boolean aef;
    public boolean aeg;
    public String aeh;
    public volatile byte adX = 0;
    public Throwable adZ = null;
    public boolean aei = false;

    /* loaded from: classes10.dex */
    public interface a {
        void aU(String str);

        com.kwad.framework.filedownloader.d.b ug();

        a.InterfaceC0677a uh();

        ArrayList<Object> ui();
    }

    public d(a aVar, Object obj) {
        this.adR = obj;
        this.adW = aVar;
        b bVar = new b();
        this.aea = bVar;
        this.aeb = bVar;
        this.adV = new k(aVar.uh(), this);
    }

    private void b(byte b) {
        this.adX = b;
        this.adY = System.currentTimeMillis();
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.f(this.adW.uh().tT())) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        if (!this.adW.uh().tT().tH() || messageSnapshot.tL() != -4 || tL() != 2) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final MessageSnapshot h(Throwable th) {
        b((byte) -1);
        this.adZ = th;
        return com.kwad.framework.filedownloader.message.f.a(getId(), ul(), th);
    }

    private void e(MessageSnapshot messageSnapshot) {
        int i;
        com.kwad.framework.filedownloader.a tT = this.adW.uh().tT();
        byte tL = messageSnapshot.tL();
        b(tL);
        this.aef = messageSnapshot.tR();
        if (tL != -4) {
            if (tL != -3) {
                if (tL != -1) {
                    if (tL != 1) {
                        if (tL != 2) {
                            if (tL != 3) {
                                if (tL != 5) {
                                    if (tL == 6) {
                                        this.adV.g(messageSnapshot);
                                        return;
                                    }
                                    return;
                                }
                                this.aec = messageSnapshot.vS();
                                this.adZ = messageSnapshot.vT();
                                this.aee = messageSnapshot.tP();
                                this.aea.reset();
                                this.adV.k(messageSnapshot);
                                return;
                            }
                            this.aec = messageSnapshot.vS();
                            this.aea.J(messageSnapshot.vS());
                            this.adV.i(messageSnapshot);
                            return;
                        }
                        this.aed = messageSnapshot.vQ();
                        this.aeg = messageSnapshot.vG();
                        this.aeh = messageSnapshot.getEtag();
                        String fileName = messageSnapshot.getFileName();
                        if (fileName != null) {
                            if (tT.getFilename() != null) {
                                com.kwad.framework.filedownloader.f.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", tT.getFilename(), fileName);
                            }
                            this.adW.aU(fileName);
                        }
                        this.aea.start(this.aec);
                        this.adV.h(messageSnapshot);
                        return;
                    }
                    this.aec = messageSnapshot.vS();
                    this.aed = messageSnapshot.vQ();
                    this.adV.f(messageSnapshot);
                    return;
                }
                this.adZ = messageSnapshot.vT();
                this.aec = messageSnapshot.vS();
                h.ur().a(this.adW.uh(), messageSnapshot);
                return;
            }
            this.aei = messageSnapshot.vR();
            this.aec = messageSnapshot.vQ();
            this.aed = messageSnapshot.vQ();
            h.ur().a(this.adW.uh(), messageSnapshot);
            return;
        }
        this.aea.reset();
        int aU = h.ur().aU(tT.getId());
        if (aU <= 1 && tT.tH()) {
            i = h.ur().aU(com.kwad.framework.filedownloader.f.f.x(tT.getUrl(), tT.getTargetFilePath()));
        } else {
            i = 0;
        }
        if (aU + i <= 1) {
            byte aZ = n.uC().aZ(tT.getId());
            com.kwad.framework.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(tT.getId()), Integer.valueOf(aZ));
            if (com.kwad.framework.filedownloader.d.d.bB(aZ)) {
                b((byte) 1);
                this.aed = messageSnapshot.vQ();
                long vS = messageSnapshot.vS();
                this.aec = vS;
                this.aea.start(vS);
                this.adV.f(((MessageSnapshot.a) messageSnapshot).vU());
                return;
            }
        }
        h.ur().a(this.adW.uh(), messageSnapshot);
    }

    private int getId() {
        return this.adW.uh().tT().getId();
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void free() {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.adX));
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.aeb.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getStatusUpdateTime() {
        return this.adY;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getTotalBytes() {
        return this.aed;
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void onBegin() {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(tL()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final byte tL() {
        return this.adX;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final Throwable tN() {
        return this.adZ;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final int tP() {
        return this.aee;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean tR() {
        return this.aef;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final t uj() {
        return this.adV;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long ul() {
        return this.aec;
    }

    private void prepare() {
        File file;
        com.kwad.framework.filedownloader.a tT = this.adW.uh().tT();
        if (tT.getPath() == null) {
            tT.aS(com.kwad.framework.filedownloader.f.f.bk(tT.getUrl()));
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "save Path is null to %s", tT.getPath());
            }
        }
        if (tT.tH()) {
            file = new File(tT.getPath());
        } else {
            String bp = com.kwad.framework.filedownloader.f.f.bp(tT.getPath());
            if (bp != null) {
                file = new File(bp);
            } else {
                throw new InvalidParameterException(com.kwad.framework.filedownloader.f.f.b("the provided mPath[%s] is invalid, can't find its directory", tT.getPath()));
            }
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwad.framework.filedownloader.f.f.b("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void uk() {
        boolean z;
        synchronized (this.adR) {
            if (this.adX != 0) {
                com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.adX));
                return;
            }
            b((byte) 10);
            a.InterfaceC0677a uh = this.adW.uh();
            com.kwad.framework.filedownloader.a tT = uh.tT();
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", tT.getUrl(), tT.getPath(), tT.tI(), tT.getTag());
            }
            try {
                prepare();
                z = true;
            } catch (Throwable th) {
                h.ur().b(uh);
                h.ur().a(uh, h(th));
                z = false;
            }
            if (z) {
                q.uI().a(this);
            }
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.v(tL(), messageSnapshot.tL())) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.adX), Byte.valueOf(tL()), Integer.valueOf(getId()));
            }
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        byte tL = tL();
        byte tL2 = messageSnapshot.tL();
        if (-2 == tL && com.kwad.framework.filedownloader.d.d.bB(tL2)) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
            }
            return true;
        } else if (!com.kwad.framework.filedownloader.d.d.w(tL, tL2)) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.adX), Byte.valueOf(tL()), Integer.valueOf(getId()));
            }
            return false;
        } else {
            e(messageSnapshot);
            return true;
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean pause() {
        if (com.kwad.framework.filedownloader.d.d.bA(tL())) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(tL()), Integer.valueOf(this.adW.uh().tT().getId()));
            }
            return false;
        }
        b((byte) -2);
        a.InterfaceC0677a uh = this.adW.uh();
        com.kwad.framework.filedownloader.a tT = uh.tT();
        q.uI().b(this);
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
        }
        r.uK();
        if (!r.uM()) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(tT.getId()));
            }
        } else {
            n.uC().aY(tT.getId());
        }
        h.ur().b(uh);
        h.ur().a(uh, com.kwad.framework.filedownloader.message.f.e(tT));
        r.uK().uO().e(uh);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void reset() {
        this.adZ = null;
        this.aeh = null;
        this.aeg = false;
        this.aee = 0;
        this.aei = false;
        this.aef = false;
        this.aec = 0L;
        this.aed = 0L;
        this.aea.reset();
        if (com.kwad.framework.filedownloader.d.d.bA(this.adX)) {
            this.adV.uA();
            this.adV = new k(this.adW.uh(), this);
        } else {
            this.adV.b(this.adW.uh(), this);
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.x.b
    public final void start() {
        if (this.adX != 10) {
            com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.adX));
            return;
        }
        a.InterfaceC0677a uh = this.adW.uh();
        com.kwad.framework.filedownloader.a tT = uh.tT();
        v uO = r.uK().uO();
        try {
            if (uO.f(uh)) {
                return;
            }
            synchronized (this.adR) {
                if (this.adX != 10) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.adX));
                    return;
                }
                b(Constants.GZIP_CAST_TYPE);
                h.ur().b(uh);
                if (com.kwad.framework.filedownloader.f.c.a(tT.getId(), tT.getTargetFilePath(), tT.tM(), true)) {
                    return;
                }
                boolean a2 = n.uC().a(tT.getUrl(), tT.getPath(), tT.tH(), tT.tF(), tT.tG(), tT.tO(), tT.tM(), this.adW.ug(), tT.tS());
                if (this.adX == -2) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                    if (a2) {
                        n.uC().aY(getId());
                    }
                } else if (!a2) {
                    if (!uO.f(uh)) {
                        MessageSnapshot h = h(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                        if (h.ur().a(uh)) {
                            uO.e(uh);
                            h.ur().b(uh);
                        }
                        h.ur().a(uh, h);
                    }
                } else {
                    uO.e(uh);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.ur().a(uh, h(th));
        }
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void uc() {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(tL()));
        }
        this.aea.end(this.aec);
        if (this.adW.ui() != null) {
            ArrayList arrayList = (ArrayList) this.adW.ui().clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i);
            }
        }
        r.uK().uO().e(this.adW.uh());
    }
}
