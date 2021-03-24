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
    public final int f36953a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectTask f36954b;

    /* renamed from: c  reason: collision with root package name */
    public final f f36955c;

    /* renamed from: d  reason: collision with root package name */
    public final String f36956d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f36957e;

    /* renamed from: f  reason: collision with root package name */
    public e f36958f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f36959g;

    /* renamed from: h  reason: collision with root package name */
    public final int f36960h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ConnectTask.a f36961a = new ConnectTask.a();

        /* renamed from: b  reason: collision with root package name */
        public f f36962b;

        /* renamed from: c  reason: collision with root package name */
        public String f36963c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f36964d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f36965e;

        public a a(int i) {
            this.f36961a.a(i);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f36961a.a(bVar);
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f36961a.a(aVar);
            return this;
        }

        public a a(f fVar) {
            this.f36962b = fVar;
            return this;
        }

        public a a(Integer num) {
            this.f36965e = num;
            return this;
        }

        public a a(String str) {
            this.f36961a.a(str);
            return this;
        }

        public a a(boolean z) {
            this.f36964d = Boolean.valueOf(z);
            return this;
        }

        public c a() {
            if (this.f36962b == null || this.f36963c == null || this.f36964d == null || this.f36965e == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("%s %s %B", this.f36962b, this.f36963c, this.f36964d));
            }
            ConnectTask a2 = this.f36961a.a();
            return new c(a2.f36914a, this.f36965e.intValue(), a2, this.f36962b, this.f36964d.booleanValue(), this.f36963c);
        }

        public a b(String str) {
            this.f36961a.b(str);
            return this;
        }

        public a c(String str) {
            this.f36963c = str;
            return this;
        }
    }

    public c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.f36960h = i;
        this.f36953a = i2;
        this.f36959g = false;
        this.f36955c = fVar;
        this.f36956d = str;
        this.f36954b = connectTask;
        this.f36957e = z;
    }

    public void a() {
        this.f36959g = true;
        e eVar = this.f36958f;
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
        long j = this.f36954b.e().f36943b;
        com.kwai.filedownloader.a.b bVar = null;
        boolean z2 = false;
        while (!this.f36959g) {
            try {
                try {
                    bVar = this.f36954b.a();
                    int e3 = bVar.e();
                    if (com.kwai.filedownloader.f.d.f37011a) {
                        com.kwai.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.f36953a), Integer.valueOf(this.f36960h), this.f36954b.e(), Integer.valueOf(e3));
                    }
                    if (e3 != 206 && e3 != 200) {
                        throw new SocketException(com.kwai.filedownloader.f.f.a("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f36954b.d(), bVar.c(), Integer.valueOf(e3), Integer.valueOf(this.f36960h), Integer.valueOf(this.f36953a)));
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
                    if (this.f36955c.a(e2)) {
                        if (!z) {
                            this.f36955c.a(e2, 0L);
                        } else if (this.f36958f != null) {
                            this.f36955c.a(e2, this.f36958f.f36977a - j);
                        } else {
                            com.kwai.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                            this.f36955c.b(e2);
                            if (bVar == null) {
                                return;
                            }
                        }
                        if (bVar != null) {
                            bVar.f();
                        }
                        z2 = z;
                    } else {
                        this.f36955c.b(e2);
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
            if (this.f36959g) {
                if (bVar != null) {
                    bVar.f();
                    return;
                }
                return;
            }
            e a2 = aVar.b(this.f36960h).a(this.f36953a).a(this.f36955c).a(this).a(this.f36957e).a(bVar).a(this.f36954b.e()).a(this.f36956d).a();
            this.f36958f = a2;
            a2.b();
            if (this.f36959g) {
                this.f36958f.a();
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
