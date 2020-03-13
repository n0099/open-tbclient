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
    private TextureView fEo;
    protected final s[] lYH;
    private final g lZd;
    private final int mad;
    private final int mae;
    private Format maf;
    private Format mag;
    private boolean mah;
    private int mai;
    private com.google.android.exoplayer2.audio.d maj;
    private com.google.android.exoplayer2.video.e mak;
    private com.google.android.exoplayer2.a.d mal;
    private com.google.android.exoplayer2.a.d mam;
    private int man;
    private com.google.android.exoplayer2.audio.b mao;
    private float maq;
    private Surface surface;
    private SurfaceHolder surfaceHolder;
    private final a lZY = new a();
    private final CopyOnWriteArraySet<b> lZZ = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.text.j> maa = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.d> mab = new CopyOnWriteArraySet<>();

    /* loaded from: classes6.dex */
    public interface b {
        void b(int i, int i2, int i3, float f);

        void das();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(v vVar, com.google.android.exoplayer2.b.h hVar, n nVar) {
        this.lYH = vVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.lZY, this.lZY, this.lZY, this.lZY);
        int i = 0;
        int i2 = 0;
        for (s sVar : this.lYH) {
            switch (sVar.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
            }
        }
        this.mad = i2;
        this.mae = i;
        this.maq = 1.0f;
        this.man = 0;
        this.mao = com.google.android.exoplayer2.audio.b.maP;
        this.mai = 1;
        this.lZd = a(this.lYH, hVar, nVar);
    }

    public void e(Surface surface) {
        dtB();
        a(surface, false);
    }

    public void d(SurfaceHolder surfaceHolder) {
        dtB();
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            a((Surface) null, false);
            return;
        }
        surfaceHolder.addCallback(this.lZY);
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
        dtB();
        this.fEo = textureView;
        if (textureView == null) {
            a((Surface) null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.lZY);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        a(surfaceTexture != null ? new Surface(surfaceTexture) : null, true);
    }

    public void c(TextureView textureView) {
        if (textureView != null && textureView == this.fEo) {
            b((TextureView) null);
        }
    }

    public void setVolume(float f) {
        int i;
        this.maq = f;
        g.b[] bVarArr = new g.b[this.mae];
        s[] sVarArr = this.lYH;
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
        this.lZd.a(bVarArr);
    }

    public void a(b bVar) {
        this.lZZ.add(bVar);
    }

    public void b(b bVar) {
        this.lZZ.remove(bVar);
    }

    @Deprecated
    public void c(b bVar) {
        this.lZZ.clear();
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(com.google.android.exoplayer2.text.j jVar) {
        this.maa.add(jVar);
    }

    public void b(com.google.android.exoplayer2.text.j jVar) {
        this.maa.remove(jVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.lZd.a(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.lZd.b(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int cZQ() {
        return this.lZd.cZQ();
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        this.lZd.a(lVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void vy(boolean z) {
        this.lZd.vy(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsU() {
        return this.lZd.dsU();
    }

    @Override // com.google.android.exoplayer2.r
    public int getRepeatMode() {
        return this.lZd.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        this.lZd.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.r
    public void vz(boolean z) {
        this.lZd.vz(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dsV() {
        return this.lZd.dsV();
    }

    @Override // com.google.android.exoplayer2.r
    public void A(int i, long j) {
        this.lZd.A(i, j);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(q qVar) {
        this.lZd.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q dsW() {
        return this.lZd.dsW();
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.lZd.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        this.lZd.release();
        dtB();
        if (this.surface != null) {
            if (this.mah) {
                this.surface.release();
            }
            this.surface = null;
        }
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.lZd.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.lZd.b(bVarArr);
    }

    @Override // com.google.android.exoplayer2.r
    public int IT(int i) {
        return this.lZd.IT(i);
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g dte() {
        return this.lZd.dte();
    }

    @Override // com.google.android.exoplayer2.r
    public x dtf() {
        return this.lZd.dtf();
    }

    @Override // com.google.android.exoplayer2.r
    public int dsY() {
        return this.lZd.dsY();
    }

    @Override // com.google.android.exoplayer2.r
    public int dsZ() {
        return this.lZd.dsZ();
    }

    @Override // com.google.android.exoplayer2.r
    public int dta() {
        return this.lZd.dta();
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        return this.lZd.getDuration();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return this.lZd.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return this.lZd.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int dtb() {
        return this.lZd.dtb();
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dtc() {
        return this.lZd.dtc();
    }

    @Override // com.google.android.exoplayer2.r
    public long dtd() {
        return this.lZd.dtd();
    }

    protected g a(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        return new j(sVarArr, hVar, nVar);
    }

    private void dtB() {
        if (this.fEo != null) {
            if (this.fEo.getSurfaceTextureListener() != this.lZY) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.fEo.setSurfaceTextureListener(null);
            }
            this.fEo = null;
        }
        if (this.surfaceHolder != null) {
            this.surfaceHolder.removeCallback(this.lZY);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        int i;
        g.b[] bVarArr = new g.b[this.mad];
        s[] sVarArr = this.lYH;
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
            this.lZd.b(bVarArr);
            if (this.mah) {
                this.surface.release();
            }
        } else {
            this.lZd.a(bVarArr);
        }
        this.surface = surface;
        this.mah = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.audio.d, com.google.android.exoplayer2.metadata.d, com.google.android.exoplayer2.text.j, com.google.android.exoplayer2.video.e {
        private a() {
        }

        @Override // com.google.android.exoplayer2.video.e
        public void c(com.google.android.exoplayer2.a.d dVar) {
            w.this.mal = dVar;
            if (w.this.mak != null) {
                w.this.mak.c(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void e(String str, long j, long j2) {
            if (w.this.mak != null) {
                w.this.mak.e(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(Format format) {
            w.this.maf = format;
            if (w.this.mak != null) {
                w.this.mak.b(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void z(int i, long j) {
            if (w.this.mak != null) {
                w.this.mak.z(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(int i, int i2, int i3, float f) {
            Iterator it = w.this.lZZ.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(i, i2, i3, f);
            }
            if (w.this.mak != null) {
                w.this.mak.b(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(Surface surface) {
            if (w.this.surface == surface) {
                Iterator it = w.this.lZZ.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).das();
                }
            }
            if (w.this.mak != null) {
                w.this.mak.d(surface);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.mak != null) {
                w.this.mak.d(dVar);
            }
            w.this.maf = null;
            w.this.mal = null;
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(com.google.android.exoplayer2.a.d dVar) {
            w.this.mam = dVar;
            if (w.this.maj != null) {
                w.this.maj.a(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void EU(int i) {
            w.this.man = i;
            if (w.this.maj != null) {
                w.this.maj.EU(i);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void d(String str, long j, long j2) {
            if (w.this.maj != null) {
                w.this.maj.d(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(Format format) {
            w.this.mag = format;
            if (w.this.maj != null) {
                w.this.maj.a(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void e(int i, long j, long j2) {
            if (w.this.maj != null) {
                w.this.maj.e(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void b(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.maj != null) {
                w.this.maj.b(dVar);
            }
            w.this.mag = null;
            w.this.mam = null;
            w.this.man = 0;
        }

        @Override // com.google.android.exoplayer2.text.j
        public void eZ(List<com.google.android.exoplayer2.text.b> list) {
            Iterator it = w.this.maa.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.text.j) it.next()).eZ(list);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.d
        public void a(Metadata metadata) {
            Iterator it = w.this.mab.iterator();
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
