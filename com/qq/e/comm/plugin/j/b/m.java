package com.qq.e.comm.plugin.j.b;

import com.qq.e.comm.plugin.util.ai;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class m implements h {

    /* renamed from: a  reason: collision with root package name */
    private final String f12474a;

    /* renamed from: b  reason: collision with root package name */
    private final File f12475b;
    private final long c;
    private final long d;
    private final com.qq.e.comm.plugin.j.b.a.b e;
    private int f;
    private String g;
    private com.qq.e.comm.plugin.j.b.a.a h;
    private AtomicBoolean i = new AtomicBoolean(false);

    public m(String str, File file, long j, long j2, com.qq.e.comm.plugin.j.b.a.b bVar) {
        this.f12474a = str;
        this.f12475b = file;
        this.c = j;
        this.d = j2;
        this.e = bVar;
    }

    @Override // com.qq.e.comm.plugin.j.b.h
    public int a(c cVar) {
        long length = this.c + this.f12475b.length();
        long length2 = this.d - this.f12475b.length();
        if (length2 == 0) {
            cVar.a(this.f12475b.length());
            return 0;
        }
        try {
        } catch (Throwable th) {
            try {
                this.f |= 1;
                this.g = "UnknownExceptionWhileSubpartitionDoWork" + th.getMessage();
                ai.a("sub exception: %s", th.toString());
                this.h.f();
            } finally {
                this.h.f();
            }
        }
        if (this.i.get()) {
            return 0;
        }
        this.h = this.e.a(this.f12474a, length, length2);
        if (!this.h.h()) {
            this.f |= this.h.b();
            this.g = this.h.g();
            ai.a("sub fail, [%d - %d], code = %d, msg = %s", Long.valueOf(length), Long.valueOf(length2), Integer.valueOf(this.f), this.g);
        } else if (this.h.c()) {
            e eVar = new e(this.h, this.f12475b, this.d);
            this.f |= eVar.a(cVar);
            this.g = eVar.a();
        } else {
            this.f |= 33554432;
            this.g = "RangeNotSupportForURL-" + this.f12474a;
        }
        return this.f;
    }

    @Override // com.qq.e.comm.plugin.j.b.h
    public String a() {
        return this.g;
    }

    @Override // com.qq.e.comm.plugin.j.b.h
    public int b() {
        return this.f;
    }

    @Override // com.qq.e.comm.plugin.j.b.h
    public void c() {
        this.i.compareAndSet(false, true);
        if (this.h != null) {
            this.h.f();
        }
    }
}
