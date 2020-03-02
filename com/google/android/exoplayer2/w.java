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
/* loaded from: classes6.dex */
public class w implements g {
    private TextureView fEb;
    private final g lYS;
    protected final s[] lYw;
    private final a lZN = new a();
    private final CopyOnWriteArraySet<b> lZO = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.text.j> lZP = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.d> lZQ = new CopyOnWriteArraySet<>();
    private final int lZR;
    private final int lZS;
    private Format lZT;
    private Format lZU;
    private boolean lZV;
    private int lZW;
    private com.google.android.exoplayer2.audio.d lZX;
    private com.google.android.exoplayer2.video.e lZY;
    private com.google.android.exoplayer2.a.d lZZ;
    private com.google.android.exoplayer2.a.d maa;
    private int mab;
    private com.google.android.exoplayer2.audio.b mad;
    private float mae;
    private Surface surface;
    private SurfaceHolder surfaceHolder;

    /* loaded from: classes6.dex */
    public interface b {
        void b(int i, int i2, int i3, float f);

        void dar();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(v vVar, com.google.android.exoplayer2.b.h hVar, n nVar) {
        this.lYw = vVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.lZN, this.lZN, this.lZN, this.lZN);
        int i = 0;
        int i2 = 0;
        for (s sVar : this.lYw) {
            switch (sVar.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
            }
        }
        this.lZR = i2;
        this.lZS = i;
        this.mae = 1.0f;
        this.mab = 0;
        this.mad = com.google.android.exoplayer2.audio.b.maE;
        this.lZW = 1;
        this.lYS = a(this.lYw, hVar, nVar);
    }

    public void e(Surface surface) {
        dtA();
        a(surface, false);
    }

    public void d(SurfaceHolder surfaceHolder) {
        dtA();
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            a((Surface) null, false);
            return;
        }
        surfaceHolder.addCallback(this.lZN);
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
        dtA();
        this.fEb = textureView;
        if (textureView == null) {
            a((Surface) null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.lZN);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        a(surfaceTexture != null ? new Surface(surfaceTexture) : null, true);
    }

    public void c(TextureView textureView) {
        if (textureView != null && textureView == this.fEb) {
            b((TextureView) null);
        }
    }

    public void setVolume(float f) {
        int i;
        this.mae = f;
        g.b[] bVarArr = new g.b[this.lZS];
        s[] sVarArr = this.lYw;
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
        this.lYS.a(bVarArr);
    }

    public void a(b bVar) {
        this.lZO.add(bVar);
    }

    public void b(b bVar) {
        this.lZO.remove(bVar);
    }

    @Deprecated
    public void c(b bVar) {
        this.lZO.clear();
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(com.google.android.exoplayer2.text.j jVar) {
        this.lZP.add(jVar);
    }

    public void b(com.google.android.exoplayer2.text.j jVar) {
        this.lZP.remove(jVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.lYS.a(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.lYS.b(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cZP() {
        return this.lYS.cZP();
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        this.lYS.a(lVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void vy(boolean z) {
        this.lYS.vy(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsT() {
        return this.lYS.dsT();
    }

    @Override // com.google.android.exoplayer2.r
    public int getRepeatMode() {
        return this.lYS.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        this.lYS.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.r
    public void vz(boolean z) {
        this.lYS.vz(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsU() {
        return this.lYS.dsU();
    }

    @Override // com.google.android.exoplayer2.r
    public void A(int i, long j) {
        this.lYS.A(i, j);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(q qVar) {
        this.lYS.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q dsV() {
        return this.lYS.dsV();
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lYS.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        this.lYS.release();
        dtA();
        if (this.surface != null) {
            if (this.lZV) {
                this.surface.release();
            }
            this.surface = null;
        }
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lYS.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lYS.b(bVarArr);
    }

    @Override // com.google.android.exoplayer2.r
    public int IT(int i) {
        return this.lYS.IT(i);
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g dtd() {
        return this.lYS.dtd();
    }

    @Override // com.google.android.exoplayer2.r
    public x dte() {
        return this.lYS.dte();
    }

    @Override // com.google.android.exoplayer2.r
    public int dsX() {
        return this.lYS.dsX();
    }

    @Override // com.google.android.exoplayer2.r
    public int dsY() {
        return this.lYS.dsY();
    }

    @Override // com.google.android.exoplayer2.r
    public int dsZ() {
        return this.lYS.dsZ();
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        return this.lYS.getDuration();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return this.lYS.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return this.lYS.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int dta() {
        return this.lYS.dta();
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dtb() {
        return this.lYS.dtb();
    }

    @Override // com.google.android.exoplayer2.r
    public long dtc() {
        return this.lYS.dtc();
    }

    protected g a(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        return new j(sVarArr, hVar, nVar);
    }

    private void dtA() {
        if (this.fEb != null) {
            if (this.fEb.getSurfaceTextureListener() != this.lZN) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.fEb.setSurfaceTextureListener(null);
            }
            this.fEb = null;
        }
        if (this.surfaceHolder != null) {
            this.surfaceHolder.removeCallback(this.lZN);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        int i;
        g.b[] bVarArr = new g.b[this.lZR];
        s[] sVarArr = this.lYw;
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
            this.lYS.b(bVarArr);
            if (this.lZV) {
                this.surface.release();
            }
        } else {
            this.lYS.a(bVarArr);
        }
        this.surface = surface;
        this.lZV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.audio.d, com.google.android.exoplayer2.metadata.d, com.google.android.exoplayer2.text.j, com.google.android.exoplayer2.video.e {
        private a() {
        }

        @Override // com.google.android.exoplayer2.video.e
        public void c(com.google.android.exoplayer2.a.d dVar) {
            w.this.lZZ = dVar;
            if (w.this.lZY != null) {
                w.this.lZY.c(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void e(String str, long j, long j2) {
            if (w.this.lZY != null) {
                w.this.lZY.e(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(Format format) {
            w.this.lZT = format;
            if (w.this.lZY != null) {
                w.this.lZY.b(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void z(int i, long j) {
            if (w.this.lZY != null) {
                w.this.lZY.z(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(int i, int i2, int i3, float f) {
            Iterator it = w.this.lZO.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(i, i2, i3, f);
            }
            if (w.this.lZY != null) {
                w.this.lZY.b(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(Surface surface) {
            if (w.this.surface == surface) {
                Iterator it = w.this.lZO.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).dar();
                }
            }
            if (w.this.lZY != null) {
                w.this.lZY.d(surface);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.lZY != null) {
                w.this.lZY.d(dVar);
            }
            w.this.lZT = null;
            w.this.lZZ = null;
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(com.google.android.exoplayer2.a.d dVar) {
            w.this.maa = dVar;
            if (w.this.lZX != null) {
                w.this.lZX.a(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void EU(int i) {
            w.this.mab = i;
            if (w.this.lZX != null) {
                w.this.lZX.EU(i);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void d(String str, long j, long j2) {
            if (w.this.lZX != null) {
                w.this.lZX.d(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(Format format) {
            w.this.lZU = format;
            if (w.this.lZX != null) {
                w.this.lZX.a(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void e(int i, long j, long j2) {
            if (w.this.lZX != null) {
                w.this.lZX.e(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void b(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.lZX != null) {
                w.this.lZX.b(dVar);
            }
            w.this.lZU = null;
            w.this.maa = null;
            w.this.mab = 0;
        }

        @Override // com.google.android.exoplayer2.text.j
        public void eZ(List<com.google.android.exoplayer2.text.b> list) {
            Iterator it = w.this.lZP.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.text.j) it.next()).eZ(list);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.d
        public void a(Metadata metadata) {
            Iterator it = w.this.lZQ.iterator();
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
