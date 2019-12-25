package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
/* loaded from: classes4.dex */
public interface d {
    void EK(int i);

    void a(Format format);

    void a(com.google.android.exoplayer2.a.d dVar);

    void b(com.google.android.exoplayer2.a.d dVar);

    void d(String str, long j, long j2);

    void e(int i, long j, long j2);

    /* loaded from: classes4.dex */
    public static final class a {
        @Nullable
        private final Handler handler;
        @Nullable
        private final d lWf;

        public a(@Nullable Handler handler, @Nullable d dVar) {
            this.handler = dVar != null ? (Handler) com.google.android.exoplayer2.util.a.checkNotNull(handler) : null;
            this.lWf = dVar;
        }

        public void e(final com.google.android.exoplayer2.a.d dVar) {
            if (this.lWf != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.lWf.a(dVar);
                    }
                });
            }
        }

        public void f(final String str, final long j, final long j2) {
            if (this.lWf != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.lWf.d(str, j, j2);
                    }
                });
            }
        }

        public void f(final Format format) {
            if (this.lWf != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.lWf.a(format);
                    }
                });
            }
        }

        public void h(final int i, final long j, final long j2) {
            if (this.lWf != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.lWf.e(i, j, j2);
                    }
                });
            }
        }

        public void f(final com.google.android.exoplayer2.a.d dVar) {
            if (this.lWf != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.dsa();
                        a.this.lWf.b(dVar);
                    }
                });
            }
        }

        public void IQ(final int i) {
            if (this.lWf != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.lWf.EK(i);
                    }
                });
            }
        }
    }
}
