package com.kwai.filedownloader.download;

import android.os.Process;
import com.kwai.filedownloader.download.ConnectTask;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;
/* loaded from: classes7.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final int f37814a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectTask f37815b;

    /* renamed from: c  reason: collision with root package name */
    public final f f37816c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37817d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f37818e;

    /* renamed from: f  reason: collision with root package name */
    public e f37819f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f37820g;

    /* renamed from: h  reason: collision with root package name */
    public final int f37821h;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ConnectTask.a f37822a = new ConnectTask.a();

        /* renamed from: b  reason: collision with root package name */
        public f f37823b;

        /* renamed from: c  reason: collision with root package name */
        public String f37824c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f37825d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f37826e;

        public a a(int i2) {
            this.f37822a.a(i2);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f37822a.a(bVar);
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f37822a.a(aVar);
            return this;
        }

        public a a(f fVar) {
            this.f37823b = fVar;
            return this;
        }

        public a a(Integer num) {
            this.f37826e = num;
            return this;
        }

        public a a(String str) {
            this.f37822a.a(str);
            return this;
        }

        public a a(boolean z) {
            this.f37825d = Boolean.valueOf(z);
            return this;
        }

        public c a() {
            if (this.f37823b == null || this.f37824c == null || this.f37825d == null || this.f37826e == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("%s %s %B", this.f37823b, this.f37824c, this.f37825d));
            }
            ConnectTask a2 = this.f37822a.a();
            return new c(a2.f37774a, this.f37826e.intValue(), a2, this.f37823b, this.f37825d.booleanValue(), this.f37824c);
        }

        public a b(String str) {
            this.f37822a.b(str);
            return this;
        }

        public a c(String str) {
            this.f37824c = str;
            return this;
        }
    }

    public c(int i2, int i3, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.f37821h = i2;
        this.f37814a = i3;
        this.f37820g = false;
        this.f37816c = fVar;
        this.f37817d = str;
        this.f37815b = connectTask;
        this.f37818e = z;
    }

    public void a() {
        this.f37820g = true;
        e eVar = this.f37819f;
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
        long j = this.f37815b.e().f37804b;
        com.kwai.filedownloader.a.b bVar = null;
        boolean z2 = false;
        while (!this.f37820g) {
            try {
                try {
                    bVar = this.f37815b.a();
                    int e3 = bVar.e();
                    if (com.kwai.filedownloader.f.d.f37874a) {
                        com.kwai.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.f37814a), Integer.valueOf(this.f37821h), this.f37815b.e(), Integer.valueOf(e3));
                    }
                    if (e3 != 206 && e3 != 200) {
                        throw new SocketException(com.kwai.filedownloader.f.f.a("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f37815b.d(), bVar.c(), Integer.valueOf(e3), Integer.valueOf(this.f37821h), Integer.valueOf(this.f37814a)));
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
                    if (this.f37816c.a(e2)) {
                        if (!z) {
                            this.f37816c.a(e2, 0L);
                        } else if (this.f37819f != null) {
                            this.f37816c.a(e2, this.f37819f.f37839a - j);
                        } else {
                            com.kwai.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                            this.f37816c.b(e2);
                            if (bVar == null) {
                                return;
                            }
                        }
                        if (bVar != null) {
                            bVar.f();
                        }
                        z2 = z;
                    } else {
                        this.f37816c.b(e2);
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
            if (this.f37820g) {
                if (bVar != null) {
                    bVar.f();
                    return;
                }
                return;
            }
            e a2 = aVar.b(this.f37821h).a(this.f37814a).a(this.f37816c).a(this).a(this.f37818e).a(bVar).a(this.f37815b.e()).a(this.f37817d).a();
            this.f37819f = a2;
            a2.b();
            if (this.f37820g) {
                this.f37819f.a();
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
