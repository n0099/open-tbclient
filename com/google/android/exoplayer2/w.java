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
    private TextureView fEW;
    private final g maM;
    protected final s[] mao;
    private final a mbH = new a();
    private final CopyOnWriteArraySet<b> mbI = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.text.j> mbJ = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.d> mbK = new CopyOnWriteArraySet<>();
    private final int mbL;
    private final int mbM;
    private Format mbN;
    private Format mbO;
    private boolean mbP;
    private int mbQ;
    private com.google.android.exoplayer2.audio.d mbR;
    private com.google.android.exoplayer2.video.e mbS;
    private com.google.android.exoplayer2.a.d mbT;
    private com.google.android.exoplayer2.a.d mbU;
    private int mbV;
    private com.google.android.exoplayer2.audio.b mbW;
    private float mbX;
    private Surface surface;
    private SurfaceHolder surfaceHolder;

    /* loaded from: classes6.dex */
    public interface b {
        void b(int i, int i2, int i3, float f);

        void daP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(v vVar, com.google.android.exoplayer2.b.h hVar, n nVar) {
        this.mao = vVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.mbH, this.mbH, this.mbH, this.mbH);
        int i = 0;
        int i2 = 0;
        for (s sVar : this.mao) {
            switch (sVar.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
            }
        }
        this.mbL = i2;
        this.mbM = i;
        this.mbX = 1.0f;
        this.mbV = 0;
        this.mbW = com.google.android.exoplayer2.audio.b.mcv;
        this.mbQ = 1;
        this.maM = a(this.mao, hVar, nVar);
    }

    public void e(Surface surface) {
        dtY();
        a(surface, false);
    }

    public void d(SurfaceHolder surfaceHolder) {
        dtY();
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            a((Surface) null, false);
            return;
        }
        surfaceHolder.addCallback(this.mbH);
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
        dtY();
        this.fEW = textureView;
        if (textureView == null) {
            a((Surface) null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.mbH);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        a(surfaceTexture != null ? new Surface(surfaceTexture) : null, true);
    }

    public void c(TextureView textureView) {
        if (textureView != null && textureView == this.fEW) {
            b((TextureView) null);
        }
    }

    public void setVolume(float f) {
        int i;
        this.mbX = f;
        g.b[] bVarArr = new g.b[this.mbM];
        s[] sVarArr = this.mao;
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
        this.maM.a(bVarArr);
    }

    public void a(b bVar) {
        this.mbI.add(bVar);
    }

    public void b(b bVar) {
        this.mbI.remove(bVar);
    }

    @Deprecated
    public void c(b bVar) {
        this.mbI.clear();
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(com.google.android.exoplayer2.text.j jVar) {
        this.mbJ.add(jVar);
    }

    public void b(com.google.android.exoplayer2.text.j jVar) {
        this.mbJ.remove(jVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void a(r.b bVar) {
        this.maM.a(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(r.b bVar) {
        this.maM.b(bVar);
    }

    @Override // com.google.android.exoplayer2.r
    public int dan() {
        return this.maM.dan();
    }

    @Override // com.google.android.exoplayer2.g
    public void a(com.google.android.exoplayer2.source.l lVar) {
        this.maM.a(lVar);
    }

    @Override // com.google.android.exoplayer2.r
    public void vF(boolean z) {
        this.maM.vF(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dtr() {
        return this.maM.dtr();
    }

    @Override // com.google.android.exoplayer2.r
    public int getRepeatMode() {
        return this.maM.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.r
    public void setRepeatMode(int i) {
        this.maM.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.r
    public void vG(boolean z) {
        this.maM.vG(z);
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dts() {
        return this.maM.dts();
    }

    @Override // com.google.android.exoplayer2.r
    public void A(int i, long j) {
        this.maM.A(i, j);
    }

    @Override // com.google.android.exoplayer2.r
    public void b(q qVar) {
        this.maM.b(qVar);
    }

    @Override // com.google.android.exoplayer2.r
    public q dtt() {
        return this.maM.dtt();
    }

    @Override // com.google.android.exoplayer2.r
    public void stop() {
        this.maM.stop();
    }

    @Override // com.google.android.exoplayer2.r
    public void release() {
        this.maM.release();
        dtY();
        if (this.surface != null) {
            if (this.mbP) {
                this.surface.release();
            }
            this.surface = null;
        }
    }

    @Override // com.google.android.exoplayer2.g
    public void a(g.b... bVarArr) {
        this.maM.a(bVarArr);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(g.b... bVarArr) {
        this.maM.b(bVarArr);
    }

    @Override // com.google.android.exoplayer2.r
    public int IZ(int i) {
        return this.maM.IZ(i);
    }

    @Override // com.google.android.exoplayer2.r
    public com.google.android.exoplayer2.b.g dtB() {
        return this.maM.dtB();
    }

    @Override // com.google.android.exoplayer2.r
    public x dtC() {
        return this.maM.dtC();
    }

    @Override // com.google.android.exoplayer2.r
    public int dtv() {
        return this.maM.dtv();
    }

    @Override // com.google.android.exoplayer2.r
    public int dtw() {
        return this.maM.dtw();
    }

    @Override // com.google.android.exoplayer2.r
    public int dtx() {
        return this.maM.dtx();
    }

    @Override // com.google.android.exoplayer2.r
    public long getDuration() {
        return this.maM.getDuration();
    }

    @Override // com.google.android.exoplayer2.r
    public long getCurrentPosition() {
        return this.maM.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public long getBufferedPosition() {
        return this.maM.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.r
    public int dty() {
        return this.maM.dty();
    }

    @Override // com.google.android.exoplayer2.r
    public boolean dtz() {
        return this.maM.dtz();
    }

    @Override // com.google.android.exoplayer2.r
    public long dtA() {
        return this.maM.dtA();
    }

    protected g a(s[] sVarArr, com.google.android.exoplayer2.b.h hVar, n nVar) {
        return new j(sVarArr, hVar, nVar);
    }

    private void dtY() {
        if (this.fEW != null) {
            if (this.fEW.getSurfaceTextureListener() != this.mbH) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.fEW.setSurfaceTextureListener(null);
            }
            this.fEW = null;
        }
        if (this.surfaceHolder != null) {
            this.surfaceHolder.removeCallback(this.mbH);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        int i;
        g.b[] bVarArr = new g.b[this.mbL];
        s[] sVarArr = this.mao;
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
            this.maM.b(bVarArr);
            if (this.mbP) {
                this.surface.release();
            }
        } else {
            this.maM.a(bVarArr);
        }
        this.surface = surface;
        this.mbP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.audio.d, com.google.android.exoplayer2.metadata.d, com.google.android.exoplayer2.text.j, com.google.android.exoplayer2.video.e {
        private a() {
        }

        @Override // com.google.android.exoplayer2.video.e
        public void c(com.google.android.exoplayer2.a.d dVar) {
            w.this.mbT = dVar;
            if (w.this.mbS != null) {
                w.this.mbS.c(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void e(String str, long j, long j2) {
            if (w.this.mbS != null) {
                w.this.mbS.e(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(Format format) {
            w.this.mbN = format;
            if (w.this.mbS != null) {
                w.this.mbS.b(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void z(int i, long j) {
            if (w.this.mbS != null) {
                w.this.mbS.z(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void b(int i, int i2, int i3, float f) {
            Iterator it = w.this.mbI.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(i, i2, i3, f);
            }
            if (w.this.mbS != null) {
                w.this.mbS.b(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(Surface surface) {
            if (w.this.surface == surface) {
                Iterator it = w.this.mbI.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).daP();
                }
            }
            if (w.this.mbS != null) {
                w.this.mbS.d(surface);
            }
        }

        @Override // com.google.android.exoplayer2.video.e
        public void d(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.mbS != null) {
                w.this.mbS.d(dVar);
            }
            w.this.mbN = null;
            w.this.mbT = null;
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(com.google.android.exoplayer2.a.d dVar) {
            w.this.mbU = dVar;
            if (w.this.mbR != null) {
                w.this.mbR.a(dVar);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void Fb(int i) {
            w.this.mbV = i;
            if (w.this.mbR != null) {
                w.this.mbR.Fb(i);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void d(String str, long j, long j2) {
            if (w.this.mbR != null) {
                w.this.mbR.d(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void a(Format format) {
            w.this.mbO = format;
            if (w.this.mbR != null) {
                w.this.mbR.a(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void e(int i, long j, long j2) {
            if (w.this.mbR != null) {
                w.this.mbR.e(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d
        public void b(com.google.android.exoplayer2.a.d dVar) {
            if (w.this.mbR != null) {
                w.this.mbR.b(dVar);
            }
            w.this.mbO = null;
            w.this.mbU = null;
            w.this.mbV = 0;
        }

        @Override // com.google.android.exoplayer2.text.j
        public void eZ(List<com.google.android.exoplayer2.text.b> list) {
            Iterator it = w.this.mbJ.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.text.j) it.next()).eZ(list);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.d
        public void a(Metadata metadata) {
            Iterator it = w.this.mbK.iterator();
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
