package d.a.u.c.g;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
/* loaded from: classes2.dex */
public class a extends b {
    public long l = 0;

    @Override // d.a.u.c.g.b
    public void j() {
        if (this.f64775h == 0) {
            this.f64775h = this.f64772e.presentationTimeUs;
        }
        MediaCodec.BufferInfo bufferInfo = this.f64772e;
        long j = bufferInfo.presentationTimeUs - this.f64775h;
        bufferInfo.presentationTimeUs = j;
        long j2 = this.l;
        if (j < j2) {
            long j3 = j2 + 10000;
            this.l = j3;
            bufferInfo.presentationTimeUs = j3;
        }
        MediaCodec.BufferInfo bufferInfo2 = this.f64772e;
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
        if (b.j > this.f64772e.presentationTimeUs + 500000) {
            b.k = 1200;
        }
        this.l = this.f64772e.presentationTimeUs;
    }

    public void k(d dVar, e eVar) {
        boolean z = false;
        if (dVar != null && eVar != null) {
            this.f64770c = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", dVar.c());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.e());
            mediaFormat.setInteger("channel-count", dVar.b());
            mediaFormat.setInteger("bitrate", dVar.a());
            mediaFormat.setInteger("max-input-size", dVar.d());
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(dVar.c());
                this.f64771d = createEncoderByType;
                createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.p()) {
                    this.f64774g = true;
                } else {
                    this.f64774g = false;
                }
                z = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        c cVar = this.f64773f;
        if (cVar != null) {
            cVar.b(z);
        }
    }
}
