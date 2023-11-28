package com.kwad.framework.filedownloader;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.d;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class c implements com.kwad.framework.filedownloader.a, a.InterfaceC0677a, d.a {
    public final x.a adA;
    public int adB;
    public ArrayList<Object> adC;
    public String adD;
    public String adE;
    public boolean adF;
    public com.kwad.framework.filedownloader.d.b adG;
    public i adH;
    public Object adI;
    public final Object adR;
    public final x adz;
    public final String mUrl;
    public int adJ = 0;
    public boolean adK = false;
    public boolean adL = false;
    public int adM = 100;
    public int adN = 10;
    public boolean adO = false;
    public volatile int adP = 0;
    public boolean adQ = false;
    public final Object adS = new Object();
    public volatile boolean adT = false;

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0677a
    public final com.kwad.framework.filedownloader.a tT() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final a.InterfaceC0677a uh() {
        return this;
    }

    /* loaded from: classes10.dex */
    public static final class a implements a.b {
        public final c adU;

        public a(c cVar) {
            this.adU = cVar;
            c.a(cVar, true);
        }

        public /* synthetic */ a(c cVar, byte b) {
            this(cVar);
        }

        @Override // com.kwad.framework.filedownloader.a.b
        public final int ub() {
            int id = this.adU.getId();
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            h.ur().c(this.adU);
            return id;
        }
    }

    public c(String str) {
        this.mUrl = str;
        Object obj = new Object();
        this.adR = obj;
        d dVar = new d(this, obj);
        this.adz = dVar;
        this.adA = dVar;
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.adQ = true;
        return true;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a c(String str, boolean z) {
        this.adD = str;
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "setPath %s", str);
        }
        this.adF = z;
        if (z) {
            this.adE = null;
        } else {
            this.adE = new File(str).getName();
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a q(String str, String str2) {
        uf();
        this.adG.s(str, str2);
        return this;
    }

    private boolean ud() {
        if (this.adz.tL() != 0) {
            return true;
        }
        return false;
    }

    private void uf() {
        if (this.adG == null) {
            synchronized (this.adS) {
                if (this.adG == null) {
                    this.adG = new com.kwad.framework.filedownloader.d.b();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean cancel() {
        return pause();
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0677a
    public final void free() {
        this.adz.free();
        if (h.ur().a(this)) {
            this.adT = false;
        }
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getFilename() {
        return this.adE;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getId() {
        int i = this.adB;
        if (i != 0) {
            return i;
        }
        if (!TextUtils.isEmpty(this.adD) && !TextUtils.isEmpty(this.mUrl)) {
            int g = com.kwad.framework.filedownloader.f.f.g(this.mUrl, this.adD, this.adF);
            this.adB = g;
            return g;
        }
        return 0;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getPath() {
        return this.adD;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileSoFarBytes() {
        if (this.adz.ul() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.adz.ul();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileTotalBytes() {
        if (this.adz.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.adz.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSpeed() {
        return this.adz.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long getStatusUpdateTime() {
        return this.adz.getStatusUpdateTime();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Object getTag() {
        return this.adI;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getTargetFilePath() {
        return com.kwad.framework.filedownloader.f.f.a(getPath(), tH(), getFilename());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getUrl() {
        return this.mUrl;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0677a
    public final boolean isOver() {
        return com.kwad.framework.filedownloader.d.d.bA(tL());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean isRunning() {
        if (r.uK().uO().d(this)) {
            return true;
        }
        return com.kwad.framework.filedownloader.d.d.bB(tL());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean pause() {
        boolean pause;
        synchronized (this.adR) {
            pause = this.adz.pause();
        }
        return pause;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int start() {
        if (!this.adQ) {
            return ue();
        }
        throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
    }

    @Override // com.kwad.framework.filedownloader.a
    public final a.b tC() {
        return new a(this, (byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean tD() {
        if (isRunning()) {
            com.kwad.framework.filedownloader.f.d.d(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
            return false;
        }
        this.adP = 0;
        this.adQ = false;
        this.adT = false;
        this.adz.reset();
        return true;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean tE() {
        if (this.adP != 0) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int tF() {
        return this.adM;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int tG() {
        return this.adN;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean tH() {
        return this.adF;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final i tI() {
        return this.adH;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long tJ() {
        return this.adz.ul();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long tK() {
        return this.adz.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final byte tL() {
        return this.adz.tL();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean tM() {
        return this.adO;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Throwable tN() {
        return this.adz.tN();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int tO() {
        return this.adJ;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int tP() {
        return this.adz.tP();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean tQ() {
        return this.adK;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean tR() {
        return this.adz.tR();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean tS() {
        return this.adL;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0677a
    public final x.a tU() {
        return this.adA;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0677a
    public final int tV() {
        return this.adP;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0677a
    public final void tW() {
        int hashCode;
        if (tI() != null) {
            hashCode = tI().hashCode();
        } else {
            hashCode = hashCode();
        }
        this.adP = hashCode;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0677a
    public final boolean tX() {
        return this.adT;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0677a
    public final void tY() {
        this.adT = true;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0677a
    public final void tZ() {
        ue();
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.b("%d@%s", Integer.valueOf(getId()), super.toString());
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0677a
    public final boolean ua() {
        ArrayList<Object> arrayList = this.adC;
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final com.kwad.framework.filedownloader.d.b ug() {
        return this.adG;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final ArrayList<Object> ui() {
        return this.adC;
    }

    private int ue() {
        if (ud()) {
            if (isRunning()) {
                throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
            }
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.adz.toString());
        }
        if (!tE()) {
            tW();
        }
        this.adz.uk();
        return getId();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a a(i iVar) {
        this.adH = iVar;
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "setListener %s", iVar);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a aS(int i) {
        this.adJ = 3;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a aT(String str) {
        if (this.adG == null) {
            synchronized (this.adS) {
                if (this.adG == null) {
                    return this;
                }
            }
        }
        this.adG.bf(str);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final void aU(String str) {
        this.adE = str;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a aZ(boolean z) {
        this.adO = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a ba(boolean z) {
        this.adK = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bb(boolean z) {
        this.adL = z;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a e(Object obj) {
        this.adI = obj;
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a aS(String str) {
        return c(str, false);
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0677a
    public final boolean aT(int i) {
        if (getId() == i) {
            return true;
        }
        return false;
    }
}
