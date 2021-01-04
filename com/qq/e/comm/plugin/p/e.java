package com.qq.e.comm.plugin.p;

import android.graphics.Bitmap;
import java.io.File;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private File f12648a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f12649b;
    private boolean c;

    /* loaded from: classes3.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private e f12650a = new e();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(Bitmap bitmap) {
            this.f12650a.f12649b = bitmap;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(File file) {
            this.f12650a.f12648a = file;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(boolean z) {
            this.f12650a.c = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e a() {
            return this.f12650a;
        }
    }

    private e() {
    }

    public Bitmap a() {
        return this.f12649b;
    }

    public File b() {
        return this.f12648a;
    }

    public boolean c() {
        return this.c;
    }
}
