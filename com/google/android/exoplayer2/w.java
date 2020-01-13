package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.r;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
@TargetApi(16)
/* loaded from: classes5.dex */
public class w implements g {
    private TextureView fBC;
    protected final s[] lXJ;
    private final g lYf;
    private final a lZa = new a();
    private final CopyOnWriteArraySet<b> lZb = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.text.j> lZc = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.d> lZd = new CopyOnWriteArraySet<>();
    private final int lZe;
    private final int lZf;
    private Format lZg;
    private Format lZh;
    private boolean lZi;
    private int lZj;
    private com.google.android.exoplayer2.audio.d lZk;
    private com.google.android.exoplayer2.video.e lZl;
    private com.google.android.exoplayer2.a.d lZm;
    private com.google.android.exoplayer2.a.d lZn;
    private int lZo;
    private com.google.android.exoplayer2.audio.b lZp;
    private float lZq;
    private Surface surface;
    private SurfaceHolder surfaceHolder;

    /* loaded from: classes5.dex */
    public interface b {
        void b(int i, int i2, int i3, float f);

        void cYZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(v vVar, com.google.android.exoplayer2.b.h hVar, n nVar) {
        this.lXJ = vVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.lZa, this.lZa, this.lZa, this.lZa);
        int i = 0;
        int i2 = 0;
        for (s sVar : this.lXJ) {
            switch (sVar.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
            }
        }
        this.lZe = i2;
        this.lZf = i;
        this.lZq = 1.0f;
        this.lZo = 0;
        this.lZp = com.google.android.exoplayer2.audio.b.lZO;
        this.lZj = 1;
        this.lYf = a(this.lXJ, hVar, nVar);
    }

    public void e(Surface surface) {
        dsk();
        a(surface, false);
    }

    public void d(SurfaceHolder surfaceHolder) {
        dsk();
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            a((Surface) null, false);
            return;
        }
        surfaceHolder.addCallback(this.lZa);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            surface = null;
        }
        a(surface, false);
    }

    public void e(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null && surfaceHolder == this.surfaceHolder) {
            d((SurfaceHolder) null);
        }
    }

    public void a(SurfaceView surfaceView) {
        d(surfaceView == null ? null : surfaceView.getHolder());
    }

    public void b(SurfaceView surfaceView) {
        e(surfaceView == null ? null : surfaceView.getHolder());
    }

    public void b(TextureView textureView) {
        dsk();
        this.fBC = textureView;
        if (textureView == null) {
            a((Surface) null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.lZa);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        a(surfaceTexture != null ? new Surface(surfaceTexture) : null, true);
    }

    public void c(TextureView textureView) {
        if (textureView != null && textureView == this.fBC) {
            b((TextureView) null);
        }
    }

    public void setVolume(float f) {
        int i;
        this.lZq = f;
        g.b[] bVarArr = new g.b[this.lZf];
        s[] sVarArr = this.lXJ;
        int length = sVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            s sVar = sVarArr[i2];
            if (sVar.getTrackType() == 1) {
                i = i3 + 1;
                bVarArr[i3] = new g.b(sVar, 2, Float.valueOf(f));
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        this.lYf.a(bVarArr);
    }

    public void a(b bVar) {
        this.lZb.add(bVar);
    }

    public void b(b bVar) {
        this.lZb.remove(bVar);
    }

    @Deprecated
    public void c(b bVar) {
        this.lZb.clear();
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(com.google.android.exoplayer2.text.j jVar) {
        this.lZc.add(jVar);
    }

    public void b(com.google.android.exoplayer2.text.j jVar) {
        this.lZc.remove(jVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.lYf.a(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.lYf.b(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cYx() {
        return this.lYf.cYx();
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        this.lYf.a(lVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void vu(boolean z) {
        this.lYf.vu(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean drD() {
        return this.lYf.drD();
    }

    @Override // com.google.android.exoplayer2.r
    public int getRepeatMode() {
        return this.lYf.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        this.lYf.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.r
    public void vv(boolean z) {
        this.lYf.vv(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean drE() {
        return this.lYf.drE();
    }

    @Override // com.google.android.exoplayer2.r
    public void B(int i, long j) {
        this.lYf.B(i, j);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(q qVar) {
        this.lYf.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q drF() {
        return this.lYf.drF();
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lYf.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        this.lYf.release();
        dsk();
        if (this.surface != null) {
            if (this.lZi) {
                this.surface.release();
            }
            this.surface = null;
        }
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lYf.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lYf.b(bVarArr);
    }

    @Override // com.google.android.exoplayer2.r
    public int IO(int i) {
        return this.lYf.IO(i);
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g drN() {
        return this.lYf.drN();
    }

    @Override // com.google.android.exoplayer2.r
    public x drO() {
        return this.lYf.drO();
    }

    @Override // com.google.android.exoplayer2.r
    public int drH() {
        return this.lYf.drH();
    }

    @Override // com.google.android.exoplayer2.r
    public int drI() {
        return this.lYf.drI();
    }

    @Override // com.google.android.exoplayer2.r
    public int drJ() {
        return this.lYf.drJ();
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        return this.lYf.getDuration();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return this.lYf.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return this.lYf.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int drK() {
        return this.lYf.drK();
    }

    @Override // com.google.android.exoplayer2.r
    public boolean drL() {
        return this.lYf.drL();
    }

    @Override // com.google.android.exoplayer2.r
    public long drM() {
        return this.lYf.drM();
    }

    protected g a(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        return new j(sVarArr, hVar, nVar);
    }

    private void dsk() {
        if (this.fBC != null) {
            if (this.fBC.getSurfaceTextureListener() != this.lZa) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.fBC.setSurfaceTextureListener(null);
            }
            this.fBC = null;
        }
        if (this.surfaceHolder != null) {
            this.surfaceHolder.removeCallback(this.lZa);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        int i;
        g.b[] bVarArr = new g.b[this.lZe];
        s[] sVarArr = this.lXJ;
        int length = sVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            s sVar = sVarArr[i2];
            if (sVar.getTrackType() == 2) {
                i = i3 + 1;
                bVarArr[i3] = new g.b(sVar, 1, surface);
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        if (this.surface != null && this.surface != surface) {
            this.lYf.b(bVarArr);
            if (this.lZi) {
                this.surface.release();
            }
        } else {
            this.lYf.a(bVarArr);
        }
        this.surface = surface;
        this.lZi = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.audio.d, com.google.android.exoplayer2.metadata.d, com.google.android.exoplayer2.text.j, com.google.android.exoplayer2.video.e {
        private a() {
        }

        @Override // com.google.android.exoplayer2.video.e
        public void c(com.google.android.exoplayer2.a.d dVar) {
            w.this.lZm = dVar;
            if (w.this.lZl != null) {
                w.this.lZl.c(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void e(String str, long j, long j2) {
            if (w.this.lZl != null) {
                w.this.lZl.e(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(Format format) {
            w.this.lZg = format;
            if (w.this.lZl != null) {
                w.this.lZl.b(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void A(int i, long j) {
            if (w.this.lZl != null) {
                w.this.lZl.A(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(int i, int i2, int i3, float f) {
            Iterator it = w.this.lZb.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(i, i2, i3, f);
            }
            if (w.this.lZl != null) {
                w.this.lZl.b(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(Surface surface) {
            if (w.this.surface == surface) {
                Iterator it = w.this.lZb.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).cYZ();
                }
            }
            if (w.this.lZl != null) {
                w.this.lZl.d(surface);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.lZl != null) {
                w.this.lZl.d(dVar);
            }
            w.this.lZg = null;
            w.this.lZm = null;
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(com.google.android.exoplayer2.a.d dVar) {
            w.this.lZn = dVar;
            if (w.this.lZk != null) {
                w.this.lZk.a(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void EP(int i) {
            w.this.lZo = i;
            if (w.this.lZk != null) {
                w.this.lZk.EP(i);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void d(String str, long j, long j2) {
            if (w.this.lZk != null) {
                w.this.lZk.d(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(Format format) {
            w.this.lZh = format;
            if (w.this.lZk != null) {
                w.this.lZk.a(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void e(int i, long j, long j2) {
            if (w.this.lZk != null) {
                w.this.lZk.e(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void b(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.lZk != null) {
                w.this.lZk.b(dVar);
            }
            w.this.lZh = null;
            w.this.lZn = null;
            w.this.lZo = 0;
        }

        @Override // com.google.android.exoplayer2.text.j
        public void fe(List<com.google.android.exoplayer2.text.b> list) {
            Iterator it = w.this.lZc.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.text.j) it.next()).fe(list);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.d
        public void a(Metadata metadata) {
            Iterator it = w.this.lZd.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.metadata.d) it.next()).a(metadata);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            w.this.a(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            w.this.a((Surface) null, false);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            w.this.a(new Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            w.this.a((Surface) null, true);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
