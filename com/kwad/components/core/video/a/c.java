package com.kwad.components.core.video.a;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.core.video.a.a {
    public static final boolean UY = d.a(com.kwad.sdk.core.config.c.aqL);
    public long UO;
    public long UP;
    public long UQ;
    public String UR;
    public boolean US;
    public boolean UT;
    public volatile boolean UU;
    public long UV;
    public long UW;
    public long UX;
    public i tU;
    public String xK;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.commercial.d.a {
        public long RT;
        public String Vd;
        public int code;
        public long creativeId;
        public long llsid;
        public String msg;
        public String videoUrl;
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static class b extends com.kwad.sdk.commercial.d.a {
        public long RT;
        public int UM;
        public String Vd;
        public long Ve;
        public long Vf;
        public long creativeId;
        public long llsid;
        public long videoDuration;
        public String videoUrl;
    }

    private void rL() {
        if (!this.UU && this.UT) {
            this.tU.rF();
            this.UX = SystemClock.elapsedRealtime();
            a(true, 0, 0);
            reset();
        }
    }

    private void reset() {
        this.tU.reset();
        this.UV = 0L;
        this.UW = 0L;
        this.UX = 0L;
        this.US = false;
        this.UT = false;
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayCompleted() {
        super.onMediaPlayCompleted();
        rL();
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayPaused() {
        super.onMediaPlayPaused();
        this.tU.rF();
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayStart() {
        super.onMediaPlayStart();
        if (this.US && !this.UT) {
            this.UW = SystemClock.elapsedRealtime();
            this.UT = true;
        }
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlaying() {
        super.onMediaPlaying();
        this.tU.rF();
    }

    @Override // com.kwad.components.core.video.a.a
    public final void onRelease() {
        rL();
    }

    @Override // com.kwad.components.core.video.a.a
    public final void onStart() {
        if (!this.US) {
            this.UV = SystemClock.elapsedRealtime();
            this.US = true;
        }
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
    public final void onVideoPlayBufferingPaused() {
        super.onVideoPlayBufferingPaused();
        this.tU.rE();
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
    public final void onVideoPlayBufferingPlaying() {
        super.onVideoPlayBufferingPlaying();
        this.tU.rE();
    }

    public c(@NonNull AdTemplate adTemplate) {
        this.US = false;
        this.UT = false;
        this.UU = false;
        try {
            AdInfo dP = e.dP(adTemplate);
            this.xK = com.kwad.sdk.core.response.b.a.K(dP);
            this.UO = e.dM(adTemplate);
            this.UP = e.dZ(adTemplate);
            this.UQ = com.kwad.sdk.core.response.b.a.cg(dP);
            this.UR = com.kwad.sdk.core.response.b.a.cc(dP);
            this.tU = new i();
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    public c(String str) {
        this.US = false;
        this.UT = false;
        this.UU = false;
        this.xK = str;
        this.tU = new i();
    }

    public static com.kwad.components.core.video.a.a ax(String str) {
        if (UY) {
            return new c(str);
        }
        return new com.kwad.components.core.video.a.b();
    }

    public static com.kwad.components.core.video.a.a ay(@NonNull AdTemplate adTemplate) {
        if (UY) {
            return new c(adTemplate);
        }
        return new com.kwad.components.core.video.a.b();
    }

    private void a(final boolean z, final int i, final int i2) {
        g.execute(new ay() { // from class: com.kwad.components.core.video.a.c.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (z) {
                    com.kwad.sdk.commercial.a.s(c.this.rM());
                } else {
                    com.kwad.sdk.commercial.a.t(c.this.q(i, i2));
                }
                c.a(c.this, true);
            }
        });
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.UU = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a q(int i, int i2) {
        a aVar = new a();
        aVar.code = i;
        aVar.msg = String.valueOf(i2);
        aVar.videoUrl = this.xK;
        aVar.llsid = this.UO;
        aVar.creativeId = this.UP;
        aVar.RT = this.UQ;
        aVar.Vd = this.UR;
        return aVar;
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayError(int i, int i2) {
        super.onMediaPlayError(i, i2);
        this.tU.rF();
        a(false, i, i2);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b rM() {
        b bVar = new b();
        bVar.Ve = this.UW - this.UV;
        bVar.Vf = this.tU.rH().rK();
        bVar.videoDuration = this.UX - this.UW;
        bVar.UM = this.tU.rH().rJ();
        bVar.videoUrl = this.xK;
        bVar.llsid = this.UO;
        bVar.creativeId = this.UP;
        bVar.RT = this.UQ;
        bVar.Vd = this.UR;
        return bVar;
    }
}
