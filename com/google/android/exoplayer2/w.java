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
/* loaded from: classes4.dex */
public class w implements g {
    private TextureView fyr;
    protected final s[] lTS;
    private final g lUo;
    private com.google.android.exoplayer2.audio.b lVA;
    private float lVB;
    private final a lVj = new a();
    private final CopyOnWriteArraySet<b> lVk = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.text.j> lVl = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.d> lVm = new CopyOnWriteArraySet<>();
    private final int lVn;
    private final int lVo;
    private Format lVp;
    private Format lVq;
    private Surface lVr;
    private boolean lVs;
    private int lVt;
    private SurfaceHolder lVu;
    private com.google.android.exoplayer2.audio.d lVv;
    private com.google.android.exoplayer2.video.e lVw;
    private com.google.android.exoplayer2.a.d lVx;
    private com.google.android.exoplayer2.a.d lVy;
    private int lVz;

    /* loaded from: classes4.dex */
    public interface b {
        void b(int i, int i2, int i3, float f);

        void cXW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(v vVar, com.google.android.exoplayer2.b.h hVar, n nVar) {
        this.lTS = vVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.lVj, this.lVj, this.lVj, this.lVj);
        int i = 0;
        int i2 = 0;
        for (s sVar : this.lTS) {
            switch (sVar.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
            }
        }
        this.lVn = i2;
        this.lVo = i;
        this.lVB = 1.0f;
        this.lVz = 0;
        this.lVA = com.google.android.exoplayer2.audio.b.lVZ;
        this.lVt = 1;
        this.lUo = a(this.lTS, hVar, nVar);
    }

    public void e(Surface surface) {
        dqY();
        a(surface, false);
    }

    public void d(SurfaceHolder surfaceHolder) {
        dqY();
        this.lVu = surfaceHolder;
        if (surfaceHolder == null) {
            a((Surface) null, false);
            return;
        }
        surfaceHolder.addCallback(this.lVj);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            surface = null;
        }
        a(surface, false);
    }

    public void e(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null && surfaceHolder == this.lVu) {
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
        dqY();
        this.fyr = textureView;
        if (textureView == null) {
            a((Surface) null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.lVj);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        a(surfaceTexture != null ? new Surface(surfaceTexture) : null, true);
    }

    public void c(TextureView textureView) {
        if (textureView != null && textureView == this.fyr) {
            b((TextureView) null);
        }
    }

    public void setVolume(float f) {
        int i;
        this.lVB = f;
        g.b[] bVarArr = new g.b[this.lVo];
        s[] sVarArr = this.lTS;
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
        this.lUo.a(bVarArr);
    }

    public void a(b bVar) {
        this.lVk.add(bVar);
    }

    public void b(b bVar) {
        this.lVk.remove(bVar);
    }

    @Deprecated
    public void c(b bVar) {
        this.lVk.clear();
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(com.google.android.exoplayer2.text.j jVar) {
        this.lVl.add(jVar);
    }

    public void b(com.google.android.exoplayer2.text.j jVar) {
        this.lVl.remove(jVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.lUo.a(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.lUo.b(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cXu() {
        return this.lUo.cXu();
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        this.lUo.a(lVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void vi(boolean z) {
        this.lUo.vi(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dqr() {
        return this.lUo.dqr();
    }

    @Override // com.google.android.exoplayer2.r
    public int getRepeatMode() {
        return this.lUo.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        this.lUo.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.r
    public void vj(boolean z) {
        this.lUo.vj(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dqs() {
        return this.lUo.dqs();
    }

    @Override // com.google.android.exoplayer2.r
    public void B(int i, long j) {
        this.lUo.B(i, j);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(q qVar) {
        this.lUo.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q dqt() {
        return this.lUo.dqt();
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lUo.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        this.lUo.release();
        dqY();
        if (this.lVr != null) {
            if (this.lVs) {
                this.lVr.release();
            }
            this.lVr = null;
        }
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lUo.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lUo.b(bVarArr);
    }

    @Override // com.google.android.exoplayer2.r
    public int IF(int i) {
        return this.lUo.IF(i);
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g dqB() {
        return this.lUo.dqB();
    }

    @Override // com.google.android.exoplayer2.r
    public x dqC() {
        return this.lUo.dqC();
    }

    @Override // com.google.android.exoplayer2.r
    public int dqv() {
        return this.lUo.dqv();
    }

    @Override // com.google.android.exoplayer2.r
    public int dqw() {
        return this.lUo.dqw();
    }

    @Override // com.google.android.exoplayer2.r
    public int dqx() {
        return this.lUo.dqx();
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        return this.lUo.getDuration();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return this.lUo.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return this.lUo.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int dqy() {
        return this.lUo.dqy();
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dqz() {
        return this.lUo.dqz();
    }

    @Override // com.google.android.exoplayer2.r
    public long dqA() {
        return this.lUo.dqA();
    }

    protected g a(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        return new j(sVarArr, hVar, nVar);
    }

    private void dqY() {
        if (this.fyr != null) {
            if (this.fyr.getSurfaceTextureListener() != this.lVj) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.fyr.setSurfaceTextureListener(null);
            }
            this.fyr = null;
        }
        if (this.lVu != null) {
            this.lVu.removeCallback(this.lVj);
            this.lVu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        int i;
        g.b[] bVarArr = new g.b[this.lVn];
        s[] sVarArr = this.lTS;
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
        if (this.lVr != null && this.lVr != surface) {
            this.lUo.b(bVarArr);
            if (this.lVs) {
                this.lVr.release();
            }
        } else {
            this.lUo.a(bVarArr);
        }
        this.lVr = surface;
        this.lVs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.audio.d, com.google.android.exoplayer2.metadata.d, com.google.android.exoplayer2.text.j, com.google.android.exoplayer2.video.e {
        private a() {
        }

        @Override // com.google.android.exoplayer2.video.e
        public void c(com.google.android.exoplayer2.a.d dVar) {
            w.this.lVx = dVar;
            if (w.this.lVw != null) {
                w.this.lVw.c(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void e(String str, long j, long j2) {
            if (w.this.lVw != null) {
                w.this.lVw.e(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(Format format) {
            w.this.lVp = format;
            if (w.this.lVw != null) {
                w.this.lVw.b(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void A(int i, long j) {
            if (w.this.lVw != null) {
                w.this.lVw.A(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(int i, int i2, int i3, float f) {
            Iterator it = w.this.lVk.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(i, i2, i3, f);
            }
            if (w.this.lVw != null) {
                w.this.lVw.b(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(Surface surface) {
            if (w.this.lVr == surface) {
                Iterator it = w.this.lVk.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).cXW();
                }
            }
            if (w.this.lVw != null) {
                w.this.lVw.d(surface);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.lVw != null) {
                w.this.lVw.d(dVar);
            }
            w.this.lVp = null;
            w.this.lVx = null;
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(com.google.android.exoplayer2.a.d dVar) {
            w.this.lVy = dVar;
            if (w.this.lVv != null) {
                w.this.lVv.a(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void EK(int i) {
            w.this.lVz = i;
            if (w.this.lVv != null) {
                w.this.lVv.EK(i);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void d(String str, long j, long j2) {
            if (w.this.lVv != null) {
                w.this.lVv.d(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(Format format) {
            w.this.lVq = format;
            if (w.this.lVv != null) {
                w.this.lVv.a(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void e(int i, long j, long j2) {
            if (w.this.lVv != null) {
                w.this.lVv.e(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void b(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.lVv != null) {
                w.this.lVv.b(dVar);
            }
            w.this.lVq = null;
            w.this.lVy = null;
            w.this.lVz = 0;
        }

        @Override // com.google.android.exoplayer2.text.j
        public void fe(List<com.google.android.exoplayer2.text.b> list) {
            Iterator it = w.this.lVl.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.text.j) it.next()).fe(list);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.d
        public void a(Metadata metadata) {
            Iterator it = w.this.lVm.iterator();
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
