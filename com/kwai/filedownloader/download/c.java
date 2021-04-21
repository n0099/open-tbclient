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
    public final int f37338a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectTask f37339b;

    /* renamed from: c  reason: collision with root package name */
    public final f f37340c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37341d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f37342e;

    /* renamed from: f  reason: collision with root package name */
    public e f37343f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f37344g;

    /* renamed from: h  reason: collision with root package name */
    public final int f37345h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ConnectTask.a f37346a = new ConnectTask.a();

        /* renamed from: b  reason: collision with root package name */
        public f f37347b;

        /* renamed from: c  reason: collision with root package name */
        public String f37348c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f37349d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f37350e;

        public a a(int i) {
            this.f37346a.a(i);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f37346a.a(bVar);
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f37346a.a(aVar);
            return this;
        }

        public a a(f fVar) {
            this.f37347b = fVar;
            return this;
        }

        public a a(Integer num) {
            this.f37350e = num;
            return this;
        }

        public a a(String str) {
            this.f37346a.a(str);
            return this;
        }

        public a a(boolean z) {
            this.f37349d = Boolean.valueOf(z);
            return this;
        }

        public c a() {
            if (this.f37347b == null || this.f37348c == null || this.f37349d == null || this.f37350e == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("%s %s %B", this.f37347b, this.f37348c, this.f37349d));
            }
            ConnectTask a2 = this.f37346a.a();
            return new c(a2.f37299a, this.f37350e.intValue(), a2, this.f37347b, this.f37349d.booleanValue(), this.f37348c);
        }

        public a b(String str) {
            this.f37346a.b(str);
            return this;
        }

        public a c(String str) {
            this.f37348c = str;
            return this;
        }
    }

    public c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.f37345h = i;
        this.f37338a = i2;
        this.f37344g = false;
        this.f37340c = fVar;
        this.f37341d = str;
        this.f37339b = connectTask;
        this.f37342e = z;
    }

    public void a() {
        this.f37344g = true;
        e eVar = this.f37343f;
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
        long j = this.f37339b.e().f37328b;
        com.kwai.filedownloader.a.b bVar = null;
        boolean z2 = false;
        while (!this.f37344g) {
            try {
                try {
                    bVar = this.f37339b.a();
                    int e3 = bVar.e();
                    if (com.kwai.filedownloader.f.d.f37396a) {
                        com.kwai.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.f37338a), Integer.valueOf(this.f37345h), this.f37339b.e(), Integer.valueOf(e3));
                    }
                    if (e3 != 206 && e3 != 200) {
                        throw new SocketException(com.kwai.filedownloader.f.f.a("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f37339b.d(), bVar.c(), Integer.valueOf(e3), Integer.valueOf(this.f37345h), Integer.valueOf(this.f37338a)));
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
                    if (this.f37340c.a(e2)) {
                        if (!z) {
                            this.f37340c.a(e2, 0L);
                        } else if (this.f37343f != null) {
                            this.f37340c.a(e2, this.f37343f.f37362a - j);
                        } else {
                            com.kwai.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                            this.f37340c.b(e2);
                            if (bVar == null) {
                                return;
                            }
                        }
                        if (bVar != null) {
                            bVar.f();
                        }
                        z2 = z;
                    } else {
                        this.f37340c.b(e2);
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
            if (this.f37344g) {
                if (bVar != null) {
                    bVar.f();
                    return;
                }
                return;
            }
            e a2 = aVar.b(this.f37345h).a(this.f37338a).a(this.f37340c).a(this).a(this.f37342e).a(bVar).a(this.f37339b.e()).a(this.f37341d).a();
            this.f37343f = a2;
            a2.b();
            if (this.f37344g) {
                this.f37343f.a();
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
