package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes5.dex */
public interface b {
    void a(int i, Format format, int i2, Object obj, long j);

    void a(com.google.android.exoplayer2.upstream.g gVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3);

    void a(com.google.android.exoplayer2.upstream.g gVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void a(com.google.android.exoplayer2.upstream.g gVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void b(com.google.android.exoplayer2.upstream.g gVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    /* loaded from: classes5.dex */
    public static final class a {
        private final Handler handler;
        private final b mpW;
        private final long mpX;

        public a(Handler handler, b bVar) {
            this(handler, bVar, 0L);
        }

        public a(Handler handler, b bVar, long j) {
            this.handler = bVar != null ? (Handler) com.google.android.exoplayer2.util.a.checkNotNull(handler) : null;
            this.mpW = bVar;
            this.mpX = j;
        }

        public a gb(long j) {
            return new a(this.handler, this.mpW, j);
        }

        public void a(com.google.android.exoplayer2.upstream.g gVar, int i, long j) {
            b(gVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j);
        }

        public void b(final com.google.android.exoplayer2.upstream.g gVar, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3) {
            if (this.mpW != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mpW.a(gVar, i, i2, format, i3, obj, a.this.gc(j), a.this.gc(j2), j3);
                    }
                });
            }
        }

        public void a(com.google.android.exoplayer2.upstream.g gVar, int i, long j, long j2, long j3) {
            c(gVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public void c(final com.google.android.exoplayer2.upstream.g gVar, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3, final long j4, final long j5) {
            if (this.mpW != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.b.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mpW.b(gVar, i, i2, format, i3, obj, a.this.gc(j), a.this.gc(j2), j3, j4, j5);
                    }
                });
            }
        }

        public void b(com.google.android.exoplayer2.upstream.g gVar, int i, long j, long j2, long j3) {
            d(gVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public void d(final com.google.android.exoplayer2.upstream.g gVar, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3, final long j4, final long j5) {
            if (this.mpW != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.b.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mpW.a(gVar, i, i2, format, i3, obj, a.this.gc(j), a.this.gc(j2), j3, j4, j5);
                    }
                });
            }
        }

        public void a(com.google.android.exoplayer2.upstream.g gVar, int i, long j, long j2, long j3, IOException iOException, boolean z) {
            b(gVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
        }

        public void b(final com.google.android.exoplayer2.upstream.g gVar, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3, final long j4, final long j5, final IOException iOException, final boolean z) {
            if (this.mpW != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.b.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mpW.a(gVar, i, i2, format, i3, obj, a.this.gc(j), a.this.gc(j2), j3, j4, j5, iOException, z);
                    }
                });
            }
        }

        public void b(final int i, final Format format, final int i2, final Object obj, final long j) {
            if (this.mpW != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mpW.a(i, format, i2, obj, a.this.gc(j));
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long gc(long j) {
            long fp = com.google.android.exoplayer2.b.fp(j);
            if (fp == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.mpX + fp;
        }
    }
}
