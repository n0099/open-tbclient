package com.kwai.filedownloader.download;

import android.os.Process;
import com.kwai.filedownloader.download.ConnectTask;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;
/* loaded from: classes5.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final int f11202a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectTask f11203b;
    private final f c;
    private final String d;
    private final boolean e;
    private e f;
    private volatile boolean g;
    private final int h;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ConnectTask.a f11204a = new ConnectTask.a();

        /* renamed from: b  reason: collision with root package name */
        private f f11205b;
        private String c;
        private Boolean d;
        private Integer e;

        public a a(int i) {
            this.f11204a.a(i);
            return this;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f11204a.a(bVar);
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f11204a.a(aVar);
            return this;
        }

        public a a(f fVar) {
            this.f11205b = fVar;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
            return this;
        }

        public a a(String str) {
            this.f11204a.a(str);
            return this;
        }

        public a a(boolean z) {
            this.d = Boolean.valueOf(z);
            return this;
        }

        public c a() {
            if (this.f11205b == null || this.c == null || this.d == null || this.e == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("%s %s %B", this.f11205b, this.c, this.d));
            }
            ConnectTask a2 = this.f11204a.a();
            return new c(a2.f11189a, this.e.intValue(), a2, this.f11205b, this.d.booleanValue(), this.c);
        }

        public a b(String str) {
            this.f11204a.b(str);
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }
    }

    private c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.h = i;
        this.f11202a = i2;
        this.g = false;
        this.c = fVar;
        this.d = str;
        this.f11203b = connectTask;
        this.e = z;
    }

    public void a() {
        this.g = true;
        if (this.f != null) {
            this.f.a();
        }
    }

    public void b() {
        a();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0138 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        com.kwai.filedownloader.a.b bVar = null;
        long j = this.f11203b.e().f11198b;
        boolean z = false;
        while (!this.g) {
            try {
                try {
                    try {
                        bVar = this.f11203b.a();
                        int e = bVar.e();
                        if (com.kwai.filedownloader.f.d.f11227a) {
                            com.kwai.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.f11202a), Integer.valueOf(this.h), this.f11203b.e(), Integer.valueOf(e));
                        }
                        if (e != 206 && e != 200) {
                            throw new SocketException(com.kwai.filedownloader.f.f.a("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f11203b.d(), bVar.c(), Integer.valueOf(e), Integer.valueOf(this.h), Integer.valueOf(this.f11202a)));
                            break;
                        }
                        try {
                            e.a aVar = new e.a();
                            if (this.g) {
                                if (bVar != null) {
                                    bVar.f();
                                    return;
                                }
                                return;
                            }
                            this.f = aVar.b(this.h).a(this.f11202a).a(this.c).a(this).a(this.e).a(bVar).a(this.f11203b.e()).a(this.d).a();
                            this.f.b();
                            if (this.g) {
                                this.f.a();
                            }
                            if (bVar != null) {
                                bVar.f();
                                return;
                            }
                            return;
                        } catch (FileDownloadGiveUpRetryException e2) {
                            e = e2;
                            z = true;
                            if (this.c.a(e)) {
                                this.c.b(e);
                                if (bVar != null) {
                                    bVar.f();
                                    return;
                                }
                                return;
                            }
                            if (!z) {
                                this.c.a(e, 0L);
                            } else if (this.f == null) {
                                com.kwai.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                this.c.b(e);
                                if (bVar != null) {
                                    bVar.f();
                                    return;
                                }
                                return;
                            } else {
                                this.c.a(e, this.f.f11210a - j);
                            }
                            if (bVar != null) {
                                bVar.f();
                            }
                        } catch (IOException e3) {
                            e = e3;
                            z = true;
                            if (this.c.a(e)) {
                            }
                        } catch (IllegalAccessException e4) {
                            e = e4;
                            z = true;
                            if (this.c.a(e)) {
                            }
                        } catch (IllegalArgumentException e5) {
                            e = e5;
                            z = true;
                            if (this.c.a(e)) {
                            }
                        }
                    } catch (FileDownloadGiveUpRetryException e6) {
                        e = e6;
                        z = false;
                    } catch (IOException e7) {
                        e = e7;
                        z = false;
                    } catch (IllegalAccessException e8) {
                        e = e8;
                        z = false;
                    } catch (IllegalArgumentException e9) {
                        e = e9;
                        z = false;
                    }
                } finally {
                    if (bVar != null) {
                        bVar.f();
                    }
                }
            } catch (FileDownloadGiveUpRetryException e10) {
                e = e10;
            } catch (IOException e11) {
                e = e11;
            } catch (IllegalAccessException e12) {
                e = e12;
            } catch (IllegalArgumentException e13) {
                e = e13;
            }
        }
    }
}
