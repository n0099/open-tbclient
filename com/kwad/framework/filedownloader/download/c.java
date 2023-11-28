package com.kwad.framework.filedownloader.download;

import android.os.Process;
import com.kwad.framework.filedownloader.download.ConnectTask;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;
/* loaded from: classes10.dex */
public final class c implements Runnable {
    public final String Vz;
    public final boolean afO;
    public final int afr;
    public final ConnectTask agn;
    public final f ago;
    public e agp;
    public final int agq;
    public volatile boolean kG;

    public c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.afr = i;
        this.agq = i2;
        this.kG = false;
        this.ago = fVar;
        this.Vz = str;
        this.agn = connectTask;
        this.afO = z;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public String Vz;
        public Boolean agl;
        public f ago;
        public final ConnectTask.a agr = new ConnectTask.a();
        public Integer ags;

        public final a a(f fVar) {
            this.ago = fVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.download.a aVar) {
            this.agr.a(aVar);
            return this;
        }

        public final a bb(String str) {
            this.agr.aY(str);
            return this;
        }

        public final a bc(String str) {
            this.agr.aZ(str);
            return this;
        }

        public final a bd(String str) {
            this.Vz = str;
            return this;
        }

        public final a bo(int i) {
            this.agr.bn(i);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.d.b bVar) {
            this.agr.a(bVar);
            return this;
        }

        public final a d(Integer num) {
            this.ags = num;
            return this;
        }

        public final a bc(boolean z) {
            this.agl = Boolean.valueOf(z);
            return this;
        }

        public final c vv() {
            if (this.ago != null && this.Vz != null && this.agl != null && this.ags != null) {
                ConnectTask vd = this.agr.vd();
                return new c(vd.afr, this.ags.intValue(), vd, this.ago, this.agl.booleanValue(), this.Vz, (byte) 0);
            }
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("%s %s %B", this.ago, this.Vz, this.agl));
        }
    }

    public /* synthetic */ c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str, byte b) {
        this(i, i2, connectTask, fVar, z, str);
    }

    public final void pause() {
        this.kG = true;
        e eVar = this.agp;
        if (eVar != null) {
            eVar.pause();
        }
    }

    public final void uA() {
        pause();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Exception e;
        Process.setThreadPriority(10);
        long j = this.agn.vc().afA;
        com.kwad.framework.filedownloader.a.b bVar = null;
        boolean z2 = false;
        while (!this.kG) {
            try {
                try {
                    bVar = this.agn.uZ();
                    int responseCode = bVar.getResponseCode();
                    if (com.kwad.framework.filedownloader.f.d.ahW) {
                        com.kwad.framework.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.agq), Integer.valueOf(this.afr), this.agn.vc(), Integer.valueOf(responseCode));
                    }
                    if (responseCode != 206 && responseCode != 200) {
                        throw new SocketException(com.kwad.framework.filedownloader.f.f.b("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.agn.getRequestHeader(), bVar.uT(), Integer.valueOf(responseCode), Integer.valueOf(this.afr), Integer.valueOf(this.agq)));
                        break;
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    e.a aVar = new e.a();
                    if (this.kG) {
                        if (bVar != null) {
                            bVar.uU();
                            return;
                        }
                        return;
                    }
                    e vI = aVar.br(this.afr).bq(this.agq).b(this.ago).a(this).be(this.afO).d(bVar).c(this.agn.vc()).be(this.Vz).vI();
                    this.agp = vI;
                    vI.run();
                    if (this.kG) {
                        this.agp.pause();
                    }
                    if (bVar != null) {
                        return;
                    }
                    return;
                } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e3) {
                    e = e3;
                    z = true;
                    try {
                        if (this.ago.a(e)) {
                            if (!z) {
                                this.ago.a(e, 0L);
                            } else if (this.agp != null) {
                                this.ago.a(e, this.agp.afA - j);
                            } else {
                                com.kwad.framework.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                this.ago.b(e);
                                if (bVar != null) {
                                    bVar.uU();
                                    return;
                                }
                                return;
                            }
                            if (bVar != null) {
                                bVar.uU();
                            }
                            z2 = z;
                        } else {
                            this.ago.b(e);
                            if (bVar != null) {
                                bVar.uU();
                                return;
                            }
                            return;
                        }
                    } finally {
                        if (bVar != null) {
                            bVar.uU();
                        }
                    }
                }
            } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e4) {
                z = z2;
                e = e4;
            }
        }
        if (bVar != null) {
            bVar.uU();
        }
    }
}
