package com.qq.e.comm.plugin.j.b;

import java.io.File;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements h {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.j.b.a.a f12463a;

    /* renamed from: b  reason: collision with root package name */
    private final File f12464b;
    private final long c;
    private String d;
    private int e;

    public e(com.qq.e.comm.plugin.j.b.a.a aVar, File file, long j) {
        this.f12463a = aVar;
        this.f12464b = file;
        this.c = j;
    }

    @Override // com.qq.e.comm.plugin.j.b.h
    public int a(c cVar) {
        long length;
        try {
            length = this.c - this.f12464b.length();
        } catch (IOException e) {
            this.e |= 4194304;
            this.d = "UnknownNetworkExceptionWhileDoMainPartitionDownloaderWork" + e.getMessage();
        } catch (IllegalStateException e2) {
            this.e |= 8388608;
            this.d = "IllegalStateExceptionWhileDoMainPartitionDownloaderWork";
        }
        if (length == 0 && this.c > 0) {
            cVar.a(this.f12464b.length());
            return 0;
        }
        a kVar = this.c <= 0 ? new k(this.f12463a.e(), this.f12464b, cVar) : new j(this.f12463a.e(), length, this.f12464b, cVar);
        this.e |= kVar.a();
        this.d = kVar.b();
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.j.b.h
    public String a() {
        return this.d;
    }

    @Override // com.qq.e.comm.plugin.j.b.h
    public int b() {
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.j.b.h
    public void c() {
        if (this.f12463a != null) {
            this.f12463a.f();
        }
    }
}
