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
    public final int f37716a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectTask f37717b;

    /* renamed from: c  reason: collision with root package name */
    public final f f37718c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37719d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f37720e;

    /* renamed from: f  reason: collision with root package name */
    public e f37721f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f37722g;

    /* renamed from: h  reason: collision with root package name */
    public final int f37723h;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ConnectTask.a f37724a = new ConnectTask.a();

        /* renamed from: b  reason: collision with root package name */
        public f f37725b;

        /* renamed from: c  reason: collision with root package name */
        public String f37726c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f37727d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f37728e;

        public a a(int i2) {
            this.f37724a.a(i2);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f37724a.a(bVar);
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f37724a.a(aVar);
            return this;
        }

        public a a(f fVar) {
            this.f37725b = fVar;
            return this;
        }

        public a a(Integer num) {
            this.f37728e = num;
            return this;
        }

        public a a(String str) {
            this.f37724a.a(str);
            return this;
        }

        public a a(boolean z) {
            this.f37727d = Boolean.valueOf(z);
            return this;
        }

        public c a() {
            if (this.f37725b == null || this.f37726c == null || this.f37727d == null || this.f37728e == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("%s %s %B", this.f37725b, this.f37726c, this.f37727d));
            }
            ConnectTask a2 = this.f37724a.a();
            return new c(a2.f37676a, this.f37728e.intValue(), a2, this.f37725b, this.f37727d.booleanValue(), this.f37726c);
        }

        public a b(String str) {
            this.f37724a.b(str);
            return this;
        }

        public a c(String str) {
            this.f37726c = str;
            return this;
        }
    }

    public c(int i2, int i3, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.f37723h = i2;
        this.f37716a = i3;
        this.f37722g = false;
        this.f37718c = fVar;
        this.f37719d = str;
        this.f37717b = connectTask;
        this.f37720e = z;
    }

    public void a() {
        this.f37722g = true;
        e eVar = this.f37721f;
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
        long j = this.f37717b.e().f37706b;
        com.kwai.filedownloader.a.b bVar = null;
        boolean z2 = false;
        while (!this.f37722g) {
            try {
                try {
                    bVar = this.f37717b.a();
                    int e3 = bVar.e();
                    if (com.kwai.filedownloader.f.d.f37776a) {
                        com.kwai.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.f37716a), Integer.valueOf(this.f37723h), this.f37717b.e(), Integer.valueOf(e3));
                    }
                    if (e3 != 206 && e3 != 200) {
                        throw new SocketException(com.kwai.filedownloader.f.f.a("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f37717b.d(), bVar.c(), Integer.valueOf(e3), Integer.valueOf(this.f37723h), Integer.valueOf(this.f37716a)));
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
                    if (this.f37718c.a(e2)) {
                        if (!z) {
                            this.f37718c.a(e2, 0L);
                        } else if (this.f37721f != null) {
                            this.f37718c.a(e2, this.f37721f.f37741a - j);
                        } else {
                            com.kwai.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                            this.f37718c.b(e2);
                            if (bVar == null) {
                                return;
                            }
                        }
                        if (bVar != null) {
                            bVar.f();
                        }
                        z2 = z;
                    } else {
                        this.f37718c.b(e2);
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
            if (this.f37722g) {
                if (bVar != null) {
                    bVar.f();
                    return;
                }
                return;
            }
            e a2 = aVar.b(this.f37723h).a(this.f37716a).a(this.f37718c).a(this).a(this.f37720e).a(bVar).a(this.f37717b.e()).a(this.f37719d).a();
            this.f37721f = a2;
            a2.b();
            if (this.f37722g) {
                this.f37721f.a();
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
