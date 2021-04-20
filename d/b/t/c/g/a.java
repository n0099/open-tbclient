package d.b.t.c.g;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.misc.IMediaFormat;
/* loaded from: classes2.dex */
public class a extends b {
    public long l = 0;

    @Override // d.b.t.c.g.b
    public void j() {
        if (this.f65471h == 0) {
            this.f65471h = this.f65468e.presentationTimeUs;
        }
        MediaCodec.BufferInfo bufferInfo = this.f65468e;
        long j = bufferInfo.presentationTimeUs - this.f65471h;
        bufferInfo.presentationTimeUs = j;
        long j2 = this.l;
        if (j < j2) {
            long j3 = j2 + 10000;
            this.l = j3;
            bufferInfo.presentationTimeUs = j3;
        }
        MediaCodec.BufferInfo bufferInfo2 = this.f65468e;
        long j4 = bufferInfo2.presentationTimeUs;
        long j5 = b.j;
        if (j4 > j5 + 500000) {
            long j6 = this.l;
            if (j5 > j6) {
                bufferInfo2.presentationTimeUs = j5 + 5000;
            } else {
                bufferInfo2.presentationTimeUs = j6 + 5000;
            }
        }
        if (b.j > this.f65468e.presentationTimeUs + 500000) {
            b.k = 1200;
        }
        this.l = this.f65468e.presentationTimeUs;
    }

    public void k(d dVar, e eVar) {
        boolean z = false;
        if (dVar != null && eVar != null) {
            this.f65466c = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.c());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.e());
            mediaFormat.setInteger("channel-count", dVar.b());
            mediaFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, dVar.a());
            mediaFormat.setInteger("max-input-size", dVar.d());
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(dVar.c());
                this.f65467d = createEncoderByType;
                createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.p()) {
                    this.f65470g = true;
                } else {
                    this.f65470g = false;
                }
                z = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        c cVar = this.f65469f;
        if (cVar != null) {
            cVar.c(z);
        }
    }
}
