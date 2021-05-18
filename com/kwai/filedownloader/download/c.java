package com.kwai.filedownloader.download;

import android.os.Process;
import com.kwai.filedownloader.download.ConnectTask;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;
/* loaded from: classes6.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final int f34303a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectTask f34304b;

    /* renamed from: c  reason: collision with root package name */
    public final f f34305c;

    /* renamed from: d  reason: collision with root package name */
    public final String f34306d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f34307e;

    /* renamed from: f  reason: collision with root package name */
    public e f34308f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f34309g;

    /* renamed from: h  reason: collision with root package name */
    public final int f34310h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ConnectTask.a f34311a = new ConnectTask.a();

        /* renamed from: b  reason: collision with root package name */
        public f f34312b;

        /* renamed from: c  reason: collision with root package name */
        public String f34313c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f34314d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f34315e;

        public a a(int i2) {
            this.f34311a.a(i2);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f34311a.a(bVar);
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f34311a.a(aVar);
            return this;
        }

        public a a(f fVar) {
            this.f34312b = fVar;
            return this;
        }

        public a a(Integer num) {
            this.f34315e = num;
            return this;
        }

        public a a(String str) {
            this.f34311a.a(str);
            return this;
        }

        public a a(boolean z) {
            this.f34314d = Boolean.valueOf(z);
            return this;
        }

        public c a() {
            if (this.f34312b == null || this.f34313c == null || this.f34314d == null || this.f34315e == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("%s %s %B", this.f34312b, this.f34313c, this.f34314d));
            }
            ConnectTask a2 = this.f34311a.a();
            return new c(a2.f34263a, this.f34315e.intValue(), a2, this.f34312b, this.f34314d.booleanValue(), this.f34313c);
        }

        public a b(String str) {
            this.f34311a.b(str);
            return this;
        }

        public a c(String str) {
            this.f34313c = str;
            return this;
        }
    }

    public c(int i2, int i3, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.f34310h = i2;
        this.f34303a = i3;
        this.f34309g = false;
        this.f34305c = fVar;
        this.f34306d = str;
        this.f34304b = connectTask;
        this.f34307e = z;
    }

    public void a() {
        this.f34309g = true;
        e eVar = this.f34308f;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void b() {
        a();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Exception e2;
        e.a aVar;
        Process.setThreadPriority(10);
        long j = this.f34304b.e().f34293b;
        com.kwai.filedownloader.a.b bVar = null;
        boolean z2 = false;
        while (!this.f34309g) {
            try {
                try {
                    bVar = this.f34304b.a();
                    int e3 = bVar.e();
                    if (com.kwai.filedownloader.f.d.f34363a) {
                        com.kwai.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.f34303a), Integer.valueOf(this.f34310h), this.f34304b.e(), Integer.valueOf(e3));
                    }
                    if (e3 != 206 && e3 != 200) {
                        throw new SocketException(com.kwai.filedownloader.f.f.a("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f34304b.d(), bVar.c(), Integer.valueOf(e3), Integer.valueOf(this.f34310h), Integer.valueOf(this.f34303a)));
                        break;
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e4) {
                    e2 = e4;
                    z = false;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e5) {
                z = z2;
                e2 = e5;
            }
            try {
                aVar = new e.a();
            } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e6) {
                e2 = e6;
                z = true;
                try {
                    if (this.f34305c.a(e2)) {
                        if (!z) {
                            this.f34305c.a(e2, 0L);
                        } else if (this.f34308f != null) {
                            this.f34305c.a(e2, this.f34308f.f34328a - j);
                        } else {
                            com.kwai.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                            this.f34305c.b(e2);
                            if (bVar == null) {
                                return;
                            }
                        }
                        if (bVar != null) {
                            bVar.f();
                        }
                        z2 = z;
                    } else {
                        this.f34305c.b(e2);
                        if (bVar == null) {
                            return;
                        }
                    }
                    return;
                } finally {
                    if (bVar != null) {
                        bVar.f();
                    }
                }
            }
            if (this.f34309g) {
                if (bVar != null) {
                    bVar.f();
                    return;
                }
                return;
            }
            e a2 = aVar.b(this.f34310h).a(this.f34303a).a(this.f34305c).a(this).a(this.f34307e).a(bVar).a(this.f34304b.e()).a(this.f34306d).a();
            this.f34308f = a2;
            a2.b();
            if (this.f34309g) {
                this.f34308f.a();
            }
            if (bVar == null) {
                return;
            }
            return;
        }
        if (bVar != null) {
            bVar.f();
        }
    }
}
