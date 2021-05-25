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
    public final int f34232a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectTask f34233b;

    /* renamed from: c  reason: collision with root package name */
    public final f f34234c;

    /* renamed from: d  reason: collision with root package name */
    public final String f34235d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f34236e;

    /* renamed from: f  reason: collision with root package name */
    public e f34237f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f34238g;

    /* renamed from: h  reason: collision with root package name */
    public final int f34239h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ConnectTask.a f34240a = new ConnectTask.a();

        /* renamed from: b  reason: collision with root package name */
        public f f34241b;

        /* renamed from: c  reason: collision with root package name */
        public String f34242c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f34243d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f34244e;

        public a a(int i2) {
            this.f34240a.a(i2);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f34240a.a(bVar);
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f34240a.a(aVar);
            return this;
        }

        public a a(f fVar) {
            this.f34241b = fVar;
            return this;
        }

        public a a(Integer num) {
            this.f34244e = num;
            return this;
        }

        public a a(String str) {
            this.f34240a.a(str);
            return this;
        }

        public a a(boolean z) {
            this.f34243d = Boolean.valueOf(z);
            return this;
        }

        public c a() {
            if (this.f34241b == null || this.f34242c == null || this.f34243d == null || this.f34244e == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("%s %s %B", this.f34241b, this.f34242c, this.f34243d));
            }
            ConnectTask a2 = this.f34240a.a();
            return new c(a2.f34192a, this.f34244e.intValue(), a2, this.f34241b, this.f34243d.booleanValue(), this.f34242c);
        }

        public a b(String str) {
            this.f34240a.b(str);
            return this;
        }

        public a c(String str) {
            this.f34242c = str;
            return this;
        }
    }

    public c(int i2, int i3, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.f34239h = i2;
        this.f34232a = i3;
        this.f34238g = false;
        this.f34234c = fVar;
        this.f34235d = str;
        this.f34233b = connectTask;
        this.f34236e = z;
    }

    public void a() {
        this.f34238g = true;
        e eVar = this.f34237f;
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
        long j = this.f34233b.e().f34222b;
        com.kwai.filedownloader.a.b bVar = null;
        boolean z2 = false;
        while (!this.f34238g) {
            try {
                try {
                    bVar = this.f34233b.a();
                    int e3 = bVar.e();
                    if (com.kwai.filedownloader.f.d.f34292a) {
                        com.kwai.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.f34232a), Integer.valueOf(this.f34239h), this.f34233b.e(), Integer.valueOf(e3));
                    }
                    if (e3 != 206 && e3 != 200) {
                        throw new SocketException(com.kwai.filedownloader.f.f.a("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f34233b.d(), bVar.c(), Integer.valueOf(e3), Integer.valueOf(this.f34239h), Integer.valueOf(this.f34232a)));
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
                    if (this.f34234c.a(e2)) {
                        if (!z) {
                            this.f34234c.a(e2, 0L);
                        } else if (this.f34237f != null) {
                            this.f34234c.a(e2, this.f34237f.f34257a - j);
                        } else {
                            com.kwai.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                            this.f34234c.b(e2);
                            if (bVar == null) {
                                return;
                            }
                        }
                        if (bVar != null) {
                            bVar.f();
                        }
                        z2 = z;
                    } else {
                        this.f34234c.b(e2);
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
            if (this.f34238g) {
                if (bVar != null) {
                    bVar.f();
                    return;
                }
                return;
            }
            e a2 = aVar.b(this.f34239h).a(this.f34232a).a(this.f34234c).a(this).a(this.f34236e).a(bVar).a(this.f34233b.e()).a(this.f34235d).a();
            this.f34237f = a2;
            a2.b();
            if (this.f34238g) {
                this.f34237f.a();
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
