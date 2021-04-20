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
    public final int f37243a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectTask f37244b;

    /* renamed from: c  reason: collision with root package name */
    public final f f37245c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37246d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f37247e;

    /* renamed from: f  reason: collision with root package name */
    public e f37248f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f37249g;

    /* renamed from: h  reason: collision with root package name */
    public final int f37250h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ConnectTask.a f37251a = new ConnectTask.a();

        /* renamed from: b  reason: collision with root package name */
        public f f37252b;

        /* renamed from: c  reason: collision with root package name */
        public String f37253c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f37254d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f37255e;

        public a a(int i) {
            this.f37251a.a(i);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f37251a.a(bVar);
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f37251a.a(aVar);
            return this;
        }

        public a a(f fVar) {
            this.f37252b = fVar;
            return this;
        }

        public a a(Integer num) {
            this.f37255e = num;
            return this;
        }

        public a a(String str) {
            this.f37251a.a(str);
            return this;
        }

        public a a(boolean z) {
            this.f37254d = Boolean.valueOf(z);
            return this;
        }

        public c a() {
            if (this.f37252b == null || this.f37253c == null || this.f37254d == null || this.f37255e == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("%s %s %B", this.f37252b, this.f37253c, this.f37254d));
            }
            ConnectTask a2 = this.f37251a.a();
            return new c(a2.f37204a, this.f37255e.intValue(), a2, this.f37252b, this.f37254d.booleanValue(), this.f37253c);
        }

        public a b(String str) {
            this.f37251a.b(str);
            return this;
        }

        public a c(String str) {
            this.f37253c = str;
            return this;
        }
    }

    public c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.f37250h = i;
        this.f37243a = i2;
        this.f37249g = false;
        this.f37245c = fVar;
        this.f37246d = str;
        this.f37244b = connectTask;
        this.f37247e = z;
    }

    public void a() {
        this.f37249g = true;
        e eVar = this.f37248f;
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
        long j = this.f37244b.e().f37233b;
        com.kwai.filedownloader.a.b bVar = null;
        boolean z2 = false;
        while (!this.f37249g) {
            try {
                try {
                    bVar = this.f37244b.a();
                    int e3 = bVar.e();
                    if (com.kwai.filedownloader.f.d.f37301a) {
                        com.kwai.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.f37243a), Integer.valueOf(this.f37250h), this.f37244b.e(), Integer.valueOf(e3));
                    }
                    if (e3 != 206 && e3 != 200) {
                        throw new SocketException(com.kwai.filedownloader.f.f.a("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f37244b.d(), bVar.c(), Integer.valueOf(e3), Integer.valueOf(this.f37250h), Integer.valueOf(this.f37243a)));
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
                    if (this.f37245c.a(e2)) {
                        if (!z) {
                            this.f37245c.a(e2, 0L);
                        } else if (this.f37248f != null) {
                            this.f37245c.a(e2, this.f37248f.f37267a - j);
                        } else {
                            com.kwai.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                            this.f37245c.b(e2);
                            if (bVar == null) {
                                return;
                            }
                        }
                        if (bVar != null) {
                            bVar.f();
                        }
                        z2 = z;
                    } else {
                        this.f37245c.b(e2);
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
            if (this.f37249g) {
                if (bVar != null) {
                    bVar.f();
                    return;
                }
                return;
            }
            e a2 = aVar.b(this.f37250h).a(this.f37243a).a(this.f37245c).a(this).a(this.f37247e).a(bVar).a(this.f37244b.e()).a(this.f37246d).a();
            this.f37248f = a2;
            a2.b();
            if (this.f37249g) {
                this.f37248f.a();
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
