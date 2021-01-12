package com.qq.e.comm.plugin.p;

import android.graphics.Bitmap;
import java.io.File;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private File f12349a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f12350b;
    private boolean c;

    /* loaded from: classes3.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private e f12351a = new e();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(Bitmap bitmap) {
            this.f12351a.f12350b = bitmap;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(File file) {
            this.f12351a.f12349a = file;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(boolean z) {
            this.f12351a.c = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e a() {
            return this.f12351a;
        }
    }

    private e() {
    }

    public Bitmap a() {
        return this.f12350b;
    }

    public File b() {
        return this.f12349a;
    }

    public boolean c() {
        return this.c;
    }
}
