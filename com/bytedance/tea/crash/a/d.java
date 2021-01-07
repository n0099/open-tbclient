package com.bytedance.tea.crash.a;

import java.io.File;
/* loaded from: classes4.dex */
public class d implements Runnable {
    private final c ppO;
    private volatile boolean c = false;
    private Runnable d = new Runnable() { // from class: com.bytedance.tea.crash.a.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.c = false;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private long f7913a = a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.ppO = cVar;
        com.bytedance.tea.crash.e.g.a(2L);
        com.bytedance.tea.crash.e.f.esB().a(4500L, this.d);
        com.bytedance.tea.crash.e.f.esB().a(5000L, this, 40, 5000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        if (!this.c) {
            String str = null;
            if (b()) {
                i = 200;
                str = "/data/anr/traces.txt";
            } else {
                i = 100;
            }
            if (this.ppO.a(i, str, 25)) {
                this.c = true;
            }
        }
    }

    private long a() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    private boolean b() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }
}
