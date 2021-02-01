package com.qq.e.comm.plugin.p;

import android.graphics.Bitmap;
import java.io.File;
/* loaded from: classes15.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private File f12351a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f12352b;
    private boolean c;

    /* loaded from: classes15.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private e f12353a = new e();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(Bitmap bitmap) {
            this.f12353a.f12352b = bitmap;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(File file) {
            this.f12353a.f12351a = file;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(boolean z) {
            this.f12353a.c = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e a() {
            return this.f12353a;
        }
    }

    private e() {
    }

    public Bitmap a() {
        return this.f12352b;
    }

    public File b() {
        return this.f12351a;
    }

    public boolean c() {
        return this.c;
    }
}
