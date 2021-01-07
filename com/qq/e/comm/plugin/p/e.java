package com.qq.e.comm.plugin.p;

import android.graphics.Bitmap;
import java.io.File;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private File f12649a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f12650b;
    private boolean c;

    /* loaded from: classes4.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private e f12651a = new e();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(Bitmap bitmap) {
            this.f12651a.f12650b = bitmap;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(File file) {
            this.f12651a.f12649a = file;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(boolean z) {
            this.f12651a.c = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e a() {
            return this.f12651a;
        }
    }

    private e() {
    }

    public Bitmap a() {
        return this.f12650b;
    }

    public File b() {
        return this.f12649a;
    }

    public boolean c() {
        return this.c;
    }
}
