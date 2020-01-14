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
    protected final s[] lXO;
    private final g lYk;
    private final a lZf = new a();
    private final CopyOnWriteArraySet<b> lZg = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.text.j> lZh = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.d> lZi = new CopyOnWriteArraySet<>();
    private final int lZj;
    private final int lZk;
    private Format lZl;
    private Format lZm;
    private boolean lZn;
    private int lZo;
    private com.google.android.exoplayer2.audio.d lZp;
    private com.google.android.exoplayer2.video.e lZq;
    private com.google.android.exoplayer2.a.d lZr;
    private com.google.android.exoplayer2.a.d lZs;
    private int lZt;
    private com.google.android.exoplayer2.audio.b lZu;
    private float lZv;
    private Surface surface;
    private SurfaceHolder surfaceHolder;

    /* loaded from: classes5.dex */
    public interface b {
        void b(int i, int i2, int i3, float f);

        void cZb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(v vVar, com.google.android.exoplayer2.b.h hVar, n nVar) {
        this.lXO = vVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.lZf, this.lZf, this.lZf, this.lZf);
        int i = 0;
        int i2 = 0;
        for (s sVar : this.lXO) {
            switch (sVar.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
            }
        }
        this.lZj = i2;
        this.lZk = i;
        this.lZv = 1.0f;
        this.lZt = 0;
        this.lZu = com.google.android.exoplayer2.audio.b.lZT;
        this.lZo = 1;
        this.lYk = a(this.lXO, hVar, nVar);
    }

    public void e(Surface surface) {
        dsm();
        a(surface, false);
    }

    public void d(SurfaceHolder surfaceHolder) {
        dsm();
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            a((Surface) null, false);
            return;
        }
        surfaceHolder.addCallback(this.lZf);
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
        dsm();
        this.fBC = textureView;
        if (textureView == null) {
            a((Surface) null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.lZf);
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
        this.lZv = f;
        g.b[] bVarArr = new g.b[this.lZk];
        s[] sVarArr = this.lXO;
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
        this.lYk.a(bVarArr);
    }

    public void a(b bVar) {
        this.lZg.add(bVar);
    }

    public void b(b bVar) {
        this.lZg.remove(bVar);
    }

    @Deprecated
    public void c(b bVar) {
        this.lZg.clear();
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(com.google.android.exoplayer2.text.j jVar) {
        this.lZh.add(jVar);
    }

    public void b(com.google.android.exoplayer2.text.j jVar) {
        this.lZh.remove(jVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.lYk.a(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.lYk.b(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cYz() {
        return this.lYk.cYz();
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        this.lYk.a(lVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void vu(boolean z) {
        this.lYk.vu(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean drF() {
        return this.lYk.drF();
    }

    @Override // com.google.android.exoplayer2.r
    public int getRepeatMode() {
        return this.lYk.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        this.lYk.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.r
    public void vv(boolean z) {
        this.lYk.vv(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean drG() {
        return this.lYk.drG();
    }

    @Override // com.google.android.exoplayer2.r
    public void B(int i, long j) {
        this.lYk.B(i, j);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(q qVar) {
        this.lYk.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q drH() {
        return this.lYk.drH();
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lYk.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        this.lYk.release();
        dsm();
        if (this.surface != null) {
            if (this.lZn) {
                this.surface.release();
            }
            this.surface = null;
        }
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lYk.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lYk.b(bVarArr);
    }

    @Override // com.google.android.exoplayer2.r
    public int IO(int i) {
        return this.lYk.IO(i);
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g drP() {
        return this.lYk.drP();
    }

    @Override // com.google.android.exoplayer2.r
    public x drQ() {
        return this.lYk.drQ();
    }

    @Override // com.google.android.exoplayer2.r
    public int drJ() {
        return this.lYk.drJ();
    }

    @Override // com.google.android.exoplayer2.r
    public int drK() {
        return this.lYk.drK();
    }

    @Override // com.google.android.exoplayer2.r
    public int drL() {
        return this.lYk.drL();
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        return this.lYk.getDuration();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return this.lYk.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return this.lYk.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int drM() {
        return this.lYk.drM();
    }

    @Override // com.google.android.exoplayer2.r
    public boolean drN() {
        return this.lYk.drN();
    }

    @Override // com.google.android.exoplayer2.r
    public long drO() {
        return this.lYk.drO();
    }

    protected g a(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        return new j(sVarArr, hVar, nVar);
    }

    private void dsm() {
        if (this.fBC != null) {
            if (this.fBC.getSurfaceTextureListener() != this.lZf) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.fBC.setSurfaceTextureListener(null);
            }
            this.fBC = null;
        }
        if (this.surfaceHolder != null) {
            this.surfaceHolder.removeCallback(this.lZf);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        int i;
        g.b[] bVarArr = new g.b[this.lZj];
        s[] sVarArr = this.lXO;
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
            this.lYk.b(bVarArr);
            if (this.lZn) {
                this.surface.release();
            }
        } else {
            this.lYk.a(bVarArr);
        }
        this.surface = surface;
        this.lZn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.audio.d, com.google.android.exoplayer2.metadata.d, com.google.android.exoplayer2.text.j, com.google.android.exoplayer2.video.e {
        private a() {
        }

        @Override // com.google.android.exoplayer2.video.e
        public void c(com.google.android.exoplayer2.a.d dVar) {
            w.this.lZr = dVar;
            if (w.this.lZq != null) {
                w.this.lZq.c(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void e(String str, long j, long j2) {
            if (w.this.lZq != null) {
                w.this.lZq.e(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(Format format) {
            w.this.lZl = format;
            if (w.this.lZq != null) {
                w.this.lZq.b(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void A(int i, long j) {
            if (w.this.lZq != null) {
                w.this.lZq.A(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(int i, int i2, int i3, float f) {
            Iterator it = w.this.lZg.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(i, i2, i3, f);
            }
            if (w.this.lZq != null) {
                w.this.lZq.b(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(Surface surface) {
            if (w.this.surface == surface) {
                Iterator it = w.this.lZg.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).cZb();
                }
            }
            if (w.this.lZq != null) {
                w.this.lZq.d(surface);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.lZq != null) {
                w.this.lZq.d(dVar);
            }
            w.this.lZl = null;
            w.this.lZr = null;
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(com.google.android.exoplayer2.a.d dVar) {
            w.this.lZs = dVar;
            if (w.this.lZp != null) {
                w.this.lZp.a(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void EP(int i) {
            w.this.lZt = i;
            if (w.this.lZp != null) {
                w.this.lZp.EP(i);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void d(String str, long j, long j2) {
            if (w.this.lZp != null) {
                w.this.lZp.d(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(Format format) {
            w.this.lZm = format;
            if (w.this.lZp != null) {
                w.this.lZp.a(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void e(int i, long j, long j2) {
            if (w.this.lZp != null) {
                w.this.lZp.e(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void b(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.lZp != null) {
                w.this.lZp.b(dVar);
            }
            w.this.lZm = null;
            w.this.lZs = null;
            w.this.lZt = 0;
        }

        @Override // com.google.android.exoplayer2.text.j
        public void fe(List<com.google.android.exoplayer2.text.b> list) {
            Iterator it = w.this.lZh.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.text.j) it.next()).fe(list);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.d
        public void a(Metadata metadata) {
            Iterator it = w.this.lZi.iterator();
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
