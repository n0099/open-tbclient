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
    private TextureView fDZ;
    private final g lYQ;
    protected final s[] lYu;
    private final a lZL = new a();
    private final CopyOnWriteArraySet<b> lZM = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.text.j> lZN = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.d> lZO = new CopyOnWriteArraySet<>();
    private final int lZP;
    private final int lZQ;
    private Format lZR;
    private Format lZS;
    private boolean lZT;
    private int lZU;
    private com.google.android.exoplayer2.audio.d lZV;
    private com.google.android.exoplayer2.video.e lZW;
    private com.google.android.exoplayer2.a.d lZX;
    private com.google.android.exoplayer2.a.d lZY;
    private int lZZ;
    private com.google.android.exoplayer2.audio.b maa;
    private float mab;
    private Surface surface;
    private SurfaceHolder surfaceHolder;

    /* loaded from: classes6.dex */
    public interface b {
        void b(int i, int i2, int i3, float f);

        void dap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(v vVar, com.google.android.exoplayer2.b.h hVar, n nVar) {
        this.lYu = vVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.lZL, this.lZL, this.lZL, this.lZL);
        int i = 0;
        int i2 = 0;
        for (s sVar : this.lYu) {
            switch (sVar.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
            }
        }
        this.lZP = i2;
        this.lZQ = i;
        this.mab = 1.0f;
        this.lZZ = 0;
        this.maa = com.google.android.exoplayer2.audio.b.maC;
        this.lZU = 1;
        this.lYQ = a(this.lYu, hVar, nVar);
    }

    public void e(Surface surface) {
        dty();
        a(surface, false);
    }

    public void d(SurfaceHolder surfaceHolder) {
        dty();
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            a((Surface) null, false);
            return;
        }
        surfaceHolder.addCallback(this.lZL);
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
        dty();
        this.fDZ = textureView;
        if (textureView == null) {
            a((Surface) null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.lZL);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        a(surfaceTexture != null ? new Surface(surfaceTexture) : null, true);
    }

    public void c(TextureView textureView) {
        if (textureView != null && textureView == this.fDZ) {
            b((TextureView) null);
        }
    }

    public void setVolume(float f) {
        int i;
        this.mab = f;
        g.b[] bVarArr = new g.b[this.lZQ];
        s[] sVarArr = this.lYu;
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
        this.lYQ.a(bVarArr);
    }

    public void a(b bVar) {
        this.lZM.add(bVar);
    }

    public void b(b bVar) {
        this.lZM.remove(bVar);
    }

    @Deprecated
    public void c(b bVar) {
        this.lZM.clear();
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(com.google.android.exoplayer2.text.j jVar) {
        this.lZN.add(jVar);
    }

    public void b(com.google.android.exoplayer2.text.j jVar) {
        this.lZN.remove(jVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.lYQ.a(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.lYQ.b(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cZN() {
        return this.lYQ.cZN();
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        this.lYQ.a(lVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void vy(boolean z) {
        this.lYQ.vy(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsR() {
        return this.lYQ.dsR();
    }

    @Override // com.google.android.exoplayer2.r
    public int getRepeatMode() {
        return this.lYQ.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        this.lYQ.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.r
    public void vz(boolean z) {
        this.lYQ.vz(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsS() {
        return this.lYQ.dsS();
    }

    @Override // com.google.android.exoplayer2.r
    public void A(int i, long j) {
        this.lYQ.A(i, j);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(q qVar) {
        this.lYQ.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q dsT() {
        return this.lYQ.dsT();
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lYQ.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        this.lYQ.release();
        dty();
        if (this.surface != null) {
            if (this.lZT) {
                this.surface.release();
            }
            this.surface = null;
        }
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lYQ.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lYQ.b(bVarArr);
    }

    @Override // com.google.android.exoplayer2.r
    public int IT(int i) {
        return this.lYQ.IT(i);
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g dtb() {
        return this.lYQ.dtb();
    }

    @Override // com.google.android.exoplayer2.r
    public x dtc() {
        return this.lYQ.dtc();
    }

    @Override // com.google.android.exoplayer2.r
    public int dsV() {
        return this.lYQ.dsV();
    }

    @Override // com.google.android.exoplayer2.r
    public int dsW() {
        return this.lYQ.dsW();
    }

    @Override // com.google.android.exoplayer2.r
    public int dsX() {
        return this.lYQ.dsX();
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        return this.lYQ.getDuration();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return this.lYQ.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return this.lYQ.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int dsY() {
        return this.lYQ.dsY();
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsZ() {
        return this.lYQ.dsZ();
    }

    @Override // com.google.android.exoplayer2.r
    public long dta() {
        return this.lYQ.dta();
    }

    protected g a(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        return new j(sVarArr, hVar, nVar);
    }

    private void dty() {
        if (this.fDZ != null) {
            if (this.fDZ.getSurfaceTextureListener() != this.lZL) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.fDZ.setSurfaceTextureListener(null);
            }
            this.fDZ = null;
        }
        if (this.surfaceHolder != null) {
            this.surfaceHolder.removeCallback(this.lZL);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        int i;
        g.b[] bVarArr = new g.b[this.lZP];
        s[] sVarArr = this.lYu;
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
            this.lYQ.b(bVarArr);
            if (this.lZT) {
                this.surface.release();
            }
        } else {
            this.lYQ.a(bVarArr);
        }
        this.surface = surface;
        this.lZT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.audio.d, com.google.android.exoplayer2.metadata.d, com.google.android.exoplayer2.text.j, com.google.android.exoplayer2.video.e {
        private a() {
        }

        @Override // com.google.android.exoplayer2.video.e
        public void c(com.google.android.exoplayer2.a.d dVar) {
            w.this.lZX = dVar;
            if (w.this.lZW != null) {
                w.this.lZW.c(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void e(String str, long j, long j2) {
            if (w.this.lZW != null) {
                w.this.lZW.e(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(Format format) {
            w.this.lZR = format;
            if (w.this.lZW != null) {
                w.this.lZW.b(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void z(int i, long j) {
            if (w.this.lZW != null) {
                w.this.lZW.z(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(int i, int i2, int i3, float f) {
            Iterator it = w.this.lZM.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(i, i2, i3, f);
            }
            if (w.this.lZW != null) {
                w.this.lZW.b(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(Surface surface) {
            if (w.this.surface == surface) {
                Iterator it = w.this.lZM.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).dap();
                }
            }
            if (w.this.lZW != null) {
                w.this.lZW.d(surface);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.lZW != null) {
                w.this.lZW.d(dVar);
            }
            w.this.lZR = null;
            w.this.lZX = null;
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(com.google.android.exoplayer2.a.d dVar) {
            w.this.lZY = dVar;
            if (w.this.lZV != null) {
                w.this.lZV.a(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void EU(int i) {
            w.this.lZZ = i;
            if (w.this.lZV != null) {
                w.this.lZV.EU(i);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void d(String str, long j, long j2) {
            if (w.this.lZV != null) {
                w.this.lZV.d(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(Format format) {
            w.this.lZS = format;
            if (w.this.lZV != null) {
                w.this.lZV.a(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void e(int i, long j, long j2) {
            if (w.this.lZV != null) {
                w.this.lZV.e(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void b(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.lZV != null) {
                w.this.lZV.b(dVar);
            }
            w.this.lZS = null;
            w.this.lZY = null;
            w.this.lZZ = 0;
        }

        @Override // com.google.android.exoplayer2.text.j
        public void eZ(List<com.google.android.exoplayer2.text.b> list) {
            Iterator it = w.this.lZN.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.text.j) it.next()).eZ(list);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.d
        public void a(Metadata metadata) {
            Iterator it = w.this.lZO.iterator();
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
