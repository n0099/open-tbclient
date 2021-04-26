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
    public final int f35058a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectTask f35059b;

    /* renamed from: c  reason: collision with root package name */
    public final f f35060c;

    /* renamed from: d  reason: collision with root package name */
    public final String f35061d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f35062e;

    /* renamed from: f  reason: collision with root package name */
    public e f35063f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f35064g;

    /* renamed from: h  reason: collision with root package name */
    public final int f35065h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ConnectTask.a f35066a = new ConnectTask.a();

        /* renamed from: b  reason: collision with root package name */
        public f f35067b;

        /* renamed from: c  reason: collision with root package name */
        public String f35068c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f35069d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f35070e;

        public a a(int i2) {
            this.f35066a.a(i2);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f35066a.a(bVar);
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f35066a.a(aVar);
            return this;
        }

        public a a(f fVar) {
            this.f35067b = fVar;
            return this;
        }

        public a a(Integer num) {
            this.f35070e = num;
            return this;
        }

        public a a(String str) {
            this.f35066a.a(str);
            return this;
        }

        public a a(boolean z) {
            this.f35069d = Boolean.valueOf(z);
            return this;
        }

        public c a() {
            if (this.f35067b == null || this.f35068c == null || this.f35069d == null || this.f35070e == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("%s %s %B", this.f35067b, this.f35068c, this.f35069d));
            }
            ConnectTask a2 = this.f35066a.a();
            return new c(a2.f35018a, this.f35070e.intValue(), a2, this.f35067b, this.f35069d.booleanValue(), this.f35068c);
        }

        public a b(String str) {
            this.f35066a.b(str);
            return this;
        }

        public a c(String str) {
            this.f35068c = str;
            return this;
        }
    }

    public c(int i2, int i3, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.f35065h = i2;
        this.f35058a = i3;
        this.f35064g = false;
        this.f35060c = fVar;
        this.f35061d = str;
        this.f35059b = connectTask;
        this.f35062e = z;
    }

    public void a() {
        this.f35064g = true;
        e eVar = this.f35063f;
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
        long j = this.f35059b.e().f35048b;
        com.kwai.filedownloader.a.b bVar = null;
        boolean z2 = false;
        while (!this.f35064g) {
            try {
                try {
                    bVar = this.f35059b.a();
                    int e3 = bVar.e();
                    if (com.kwai.filedownloader.f.d.f35118a) {
                        com.kwai.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.f35058a), Integer.valueOf(this.f35065h), this.f35059b.e(), Integer.valueOf(e3));
                    }
                    if (e3 != 206 && e3 != 200) {
                        throw new SocketException(com.kwai.filedownloader.f.f.a("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f35059b.d(), bVar.c(), Integer.valueOf(e3), Integer.valueOf(this.f35065h), Integer.valueOf(this.f35058a)));
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
                    if (this.f35060c.a(e2)) {
                        if (!z) {
                            this.f35060c.a(e2, 0L);
                        } else if (this.f35063f != null) {
                            this.f35060c.a(e2, this.f35063f.f35083a - j);
                        } else {
                            com.kwai.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                            this.f35060c.b(e2);
                            if (bVar == null) {
                                return;
                            }
                        }
                        if (bVar != null) {
                            bVar.f();
                        }
                        z2 = z;
                    } else {
                        this.f35060c.b(e2);
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
            if (this.f35064g) {
                if (bVar != null) {
                    bVar.f();
                    return;
                }
                return;
            }
            e a2 = aVar.b(this.f35065h).a(this.f35058a).a(this.f35060c).a(this).a(this.f35062e).a(bVar).a(this.f35059b.e()).a(this.f35061d).a();
            this.f35063f = a2;
            a2.b();
            if (this.f35064g) {
                this.f35063f.a();
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
