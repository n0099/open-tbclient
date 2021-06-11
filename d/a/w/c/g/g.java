package d.a.w.c.g;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.kwai.video.player.KsMediaMeta;
/* loaded from: classes2.dex */
public class g extends b {
    public Surface l;

    @Override // d.a.w.c.g.b
    public void j() {
        if (this.f68546h == 0) {
            this.f68546h = this.f68543e.presentationTimeUs;
            b.j = 0L;
        }
        MediaCodec.BufferInfo bufferInfo = this.f68543e;
        long j = bufferInfo.presentationTimeUs - this.f68546h;
        bufferInfo.presentationTimeUs = j;
        b.j = j;
        d.a.w.c.d.x().V(b.j / 1000);
    }

    public Surface k() {
        return this.l;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(d dVar, e eVar) {
        c cVar;
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.f68541c = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.j(), dVar.n(), dVar.l());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, dVar.i());
            createVideoFormat.setInteger("frame-rate", dVar.k());
            createVideoFormat.setInteger("i-frame-interval", dVar.m());
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(dVar.j());
                this.f68542d = createEncoderByType;
                createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.l = this.f68542d.createInputSurface();
                this.f68545g = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            cVar = this.f68544f;
            if (cVar == null) {
                cVar.b(z);
                return;
            }
            return;
        }
        z = false;
        cVar = this.f68544f;
        if (cVar == null) {
        }
    }
}
