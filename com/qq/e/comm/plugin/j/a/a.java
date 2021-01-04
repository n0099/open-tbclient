package com.qq.e.comm.plugin.j.a;

import com.qq.e.comm.plugin.j.e;
import com.qq.e.comm.plugin.j.f;
/* loaded from: classes3.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final e f12449a;

    /* renamed from: b  reason: collision with root package name */
    private final c f12450b;
    private int d;
    private long c = -1;
    private String e = "";

    public a(e eVar, c cVar) {
        this.f12449a = eVar;
        this.f12450b = cVar;
    }

    @Override // com.qq.e.comm.plugin.j.e
    public int a() {
        return this.f12449a.a() | this.d;
    }

    @Override // com.qq.e.comm.plugin.j.e
    public void a(f fVar) {
        if (this.f12449a != null) {
            this.f12449a.a(fVar);
        }
    }

    @Override // com.qq.e.comm.plugin.j.e
    public String b() {
        return this.f12449a.b() + "\t" + this.e;
    }

    @Override // com.qq.e.comm.plugin.j.e
    public boolean c() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = false;
        do {
            try {
                z2 = this.f12449a.c();
            } catch (Throwable th) {
                z = z2;
            }
            try {
                if (!this.f12450b.a(a())) {
                    this.c = System.currentTimeMillis() - currentTimeMillis;
                    return false;
                }
                try {
                    Thread.sleep(this.f12450b.a());
                } catch (InterruptedException e) {
                } catch (Throwable th2) {
                    this.c = System.currentTimeMillis() - currentTimeMillis;
                    throw th2;
                }
                if (this.f12450b.b()) {
                    this.d = 67108864;
                    this.e = "NetworkChangedAndPauseDownloadTask";
                    this.c = System.currentTimeMillis() - currentTimeMillis;
                    return false;
                }
            } catch (Throwable th3) {
                z = z2;
                this.c = System.currentTimeMillis() - currentTimeMillis;
                return z;
            }
        } while (!z2);
        this.c = System.currentTimeMillis() - currentTimeMillis;
        return z2;
    }
}
