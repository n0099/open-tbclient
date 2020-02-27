package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public interface d {
    void EU(int i);

    void a(Format format);

    void a(com.google.android.exoplayer2.a.d dVar);

    void b(com.google.android.exoplayer2.a.d dVar);

    void d(String str, long j, long j2);

    void e(int i, long j, long j2);

    /* loaded from: classes6.dex */
    public static final class a {
        @Nullable
        private final Handler handler;
        @Nullable
        private final d maI;

        public a(@Nullable Handler handler, @Nullable d dVar) {
            this.handler = dVar != null ? (Handler) com.google.android.exoplayer2.util.a.checkNotNull(handler) : null;
            this.maI = dVar;
        }

        public void e(final com.google.android.exoplayer2.a.d dVar) {
            if (this.maI != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.maI.a(dVar);
                    }
                });
            }
        }

        public void f(final String str, final long j, final long j2) {
            if (this.maI != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.maI.d(str, j, j2);
                    }
                });
            }
        }

        public void f(final Format format) {
            if (this.maI != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.maI.a(format);
                    }
                });
            }
        }

        public void h(final int i, final long j, final long j2) {
            if (this.maI != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.maI.e(i, j, j2);
                    }
                });
            }
        }

        public void f(final com.google.android.exoplayer2.a.d dVar) {
            if (this.maI != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.duz();
                        a.this.maI.b(dVar);
                    }
                });
            }
        }

        public void Je(final int i) {
            if (this.maI != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.maI.EU(i);
                    }
                });
            }
        }
    }
}
