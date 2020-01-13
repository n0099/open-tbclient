package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
/* loaded from: classes5.dex */
public interface e {
    void A(int i, long j);

    void b(int i, int i2, int i3, float f);

    void b(Format format);

    void c(com.google.android.exoplayer2.a.d dVar);

    void d(Surface surface);

    void d(com.google.android.exoplayer2.a.d dVar);

    void e(String str, long j, long j2);

    /* loaded from: classes5.dex */
    public static final class a {
        @Nullable
        private final Handler handler;
        @Nullable
        private final e mIr;

        public a(@Nullable Handler handler, @Nullable e eVar) {
            this.handler = eVar != null ? (Handler) com.google.android.exoplayer2.util.a.checkNotNull(handler) : null;
            this.mIr = eVar;
        }

        public void e(final com.google.android.exoplayer2.a.d dVar) {
            if (this.mIr != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.e.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mIr.c(dVar);
                    }
                });
            }
        }

        public void f(final String str, final long j, final long j2) {
            if (this.mIr != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.e.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mIr.e(str, j, j2);
                    }
                });
            }
        }

        public void f(final Format format) {
            if (this.mIr != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.e.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mIr.b(format);
                    }
                });
            }
        }

        public void K(final int i, final long j) {
            if (this.mIr != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.e.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mIr.A(i, j);
                    }
                });
            }
        }

        public void c(final int i, final int i2, final int i3, final float f) {
            if (this.mIr != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.e.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mIr.b(i, i2, i3, f);
                    }
                });
            }
        }

        public void f(final Surface surface) {
            if (this.mIr != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.e.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mIr.d(surface);
                    }
                });
            }
        }

        public void f(final com.google.android.exoplayer2.a.d dVar) {
            if (this.mIr != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.e.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.dtm();
                        a.this.mIr.d(dVar);
                    }
                });
            }
        }
    }
}
