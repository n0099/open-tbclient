package com.qq.e.comm.plugin.rewardvideo;

import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ba;
import java.io.File;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m implements com.qq.e.comm.plugin.j.a {

    /* renamed from: a  reason: collision with root package name */
    private volatile WeakReference<j> f12740a;

    /* renamed from: b  reason: collision with root package name */
    private volatile WeakReference<l> f12741b;
    private volatile String c;
    private volatile int d = -1;
    private com.qq.e.comm.plugin.y.c e;

    @Override // com.qq.e.comm.plugin.j.a
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void a(long j, long j2, int i) {
        l lVar;
        ai.b("gdt_tag_reward_video", "onProgress(%d,%d,%d)", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        if (this.f12741b == null || (lVar = this.f12741b.get()) == null) {
            return;
        }
        lVar.a(j, j2, i, this.c);
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void a(long j, boolean z) {
        this.d = (int) (j >> 10);
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void a(com.qq.e.comm.plugin.j.c cVar) {
        j jVar;
        l lVar;
        ai.b("gdt_tag_reward_video", "onFailed(%s)", cVar);
        if (this.f12741b != null && (lVar = this.f12741b.get()) != null) {
            lVar.f();
        }
        if (this.f12740a == null || (jVar = this.f12740a.get()) == null) {
            return;
        }
        jVar.a(this.c, cVar);
    }

    public void a(j jVar) {
        this.f12740a = new WeakReference<>(jVar);
    }

    public void a(l lVar) {
        this.f12741b = new WeakReference<>(lVar);
    }

    public void a(com.qq.e.comm.plugin.y.c cVar) {
        this.e = cVar;
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void a(File file, long j) {
        j jVar;
        l lVar;
        ai.a("gdt_tag_reward_video", "onCompleted");
        if (this.f12741b != null && (lVar = this.f12741b.get()) != null) {
            lVar.d();
        }
        if (this.f12740a != null && (jVar = this.f12740a.get()) != null) {
            jVar.c();
        }
        ba.a(j, this.d, this.c, this.e);
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void b() {
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void c() {
        j jVar;
        l lVar;
        ai.a("gdt_tag_reward_video", "onCanceled");
        if (this.f12741b != null && (lVar = this.f12741b.get()) != null) {
            lVar.e();
        }
        if (this.f12740a == null || (jVar = this.f12740a.get()) == null) {
            return;
        }
        jVar.a(this.c);
    }
}
