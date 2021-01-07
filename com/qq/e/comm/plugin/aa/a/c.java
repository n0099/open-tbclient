package com.qq.e.comm.plugin.aa.a;

import android.text.TextUtils;
import com.qq.e.comm.plugin.j.b.f;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
/* loaded from: classes4.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final b f11957a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.j.a f11958b;
    private volatile boolean c;
    private a d;
    private final String e;
    private volatile f f;
    private final com.qq.e.comm.plugin.j.b g;

    /* loaded from: classes4.dex */
    interface a {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, b bVar, com.qq.e.comm.plugin.j.a aVar, com.qq.e.comm.plugin.j.b bVar2) {
        this.f11957a = bVar;
        this.f11958b = aVar;
        this.e = str;
        this.g = bVar2;
    }

    private void b() {
        File file = null;
        if (this.f11957a.a() != null && !TextUtils.isEmpty(this.f11957a.b())) {
            file = new File(this.f11957a.a(), this.f11957a.b());
        }
        this.f = new f(this.f11957a.c(), file, this.f11957a.d() ? 3 : 1, this.g);
        this.f.a(this.f11958b);
        this.f.c();
        GDTLogger.d("download result" + this.f.a() + " " + this.f.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.d = aVar;
    }

    public void a(com.qq.e.comm.plugin.j.a aVar) {
        if (aVar != null) {
            this.f11958b = aVar;
            if (this.f != null) {
                this.f.a(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.c;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c = true;
        b();
        if (this.d != null) {
            this.d.a(this.e);
        }
        this.c = false;
    }
}
