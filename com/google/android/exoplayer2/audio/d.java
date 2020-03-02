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
        private final d maK;

        public a(@Nullable Handler handler, @Nullable d dVar) {
            this.handler = dVar != null ? (Handler) com.google.android.exoplayer2.util.a.checkNotNull(handler) : null;
            this.maK = dVar;
        }

        public void e(final com.google.android.exoplayer2.a.d dVar) {
            if (this.maK != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.maK.a(dVar);
                    }
                });
            }
        }

        public void f(final String str, final long j, final long j2) {
            if (this.maK != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.maK.d(str, j, j2);
                    }
                });
            }
        }

        public void f(final Format format) {
            if (this.maK != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.maK.a(format);
                    }
                });
            }
        }

        public void h(final int i, final long j, final long j2) {
            if (this.maK != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.maK.e(i, j, j2);
                    }
                });
            }
        }

        public void f(final com.google.android.exoplayer2.a.d dVar) {
            if (this.maK != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.duB();
                        a.this.maK.b(dVar);
                    }
                });
            }
        }

        public void Je(final int i) {
            if (this.maK != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.maK.EU(i);
                    }
                });
            }
        }
    }
}
