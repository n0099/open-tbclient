package d.a.o0.r3.k;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
import com.kwai.video.player.misc.IMediaFormat;
import d.a.o0.r3.k.c;
import d.a.o0.r3.k.g;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class b extends c {
    public b(String str) {
        super(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f5 A[Catch: all -> 0x0209, TryCatch #0 {all -> 0x0209, blocks: (B:22:0x00a8, B:24:0x00ae, B:26:0x00b6, B:29:0x00ef, B:31:0x00f5, B:33:0x00fb, B:34:0x0105, B:36:0x0109, B:38:0x0121, B:40:0x0127, B:42:0x0135, B:44:0x013b, B:48:0x0148, B:55:0x0158, B:57:0x015f, B:58:0x0169, B:59:0x0185, B:61:0x018e, B:64:0x0199, B:67:0x01a8, B:27:0x00d4, B:69:0x01c7, B:71:0x01cd, B:72:0x01d5), top: B:80:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0196  */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c.b a(String str, boolean z, g.a aVar, g.a aVar2) throws Exception {
        MediaFormat mediaFormat;
        double d2;
        int dequeueOutputBuffer;
        byte[] bArr;
        byte[] bArr2;
        if (TextUtils.isEmpty(str) || aVar == null || aVar2 == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = this.f64020a;
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str2);
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= mediaExtractor.getTrackCount()) {
                mediaFormat = null;
                break;
            }
            mediaFormat = mediaExtractor.getTrackFormat(i2);
            if (mediaFormat.getString(IMediaFormat.KEY_MIME).startsWith("audio/")) {
                mediaExtractor.selectTrack(i2);
                break;
            }
            i2++;
        }
        if (mediaFormat == null) {
            BdLog.e("not a valid file with audio track..");
            mediaExtractor.release();
            return null;
        }
        BdLog.e("mediaFormat " + mediaFormat);
        c.b bVar = new c.b();
        int i3 = aVar2.f64034b;
        int i4 = aVar2.f64033a;
        int i5 = aVar2.f64035c;
        bVar.f64022a = str;
        FileOutputStream fileOutputStream = new FileOutputStream(bVar.f64022a);
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString(IMediaFormat.KEY_MIME));
        createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        createDecoderByType.start();
        ByteBuffer[] inputBuffers = createDecoderByType.getInputBuffers();
        ByteBuffer[] outputBuffers = createDecoderByType.getOutputBuffers();
        double d3 = mediaFormat.getLong("durationUs");
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        ByteBuffer[] byteBufferArr = outputBuffers;
        boolean z3 = false;
        boolean z4 = false;
        while (!z3) {
            long j = currentTimeMillis;
            if (!z4) {
                try {
                    int dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(5000L);
                    if (dequeueInputBuffer >= 0) {
                        int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], z2 ? 1 : 0);
                        if (readSampleData < 0) {
                            BdLog.i("saw input EOS.");
                            d2 = d3;
                            createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                            z4 = true;
                        } else {
                            d2 = d3;
                            createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                            mediaExtractor.advance();
                        }
                        dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 5000L);
                        if (dequeueOutputBuffer < 0) {
                            if ((bufferInfo.flags & 2) != 0) {
                                BdLog.i("audio encoder: codec config buffer");
                                createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, z2);
                            } else {
                                if (bufferInfo.size != 0) {
                                    ByteBuffer byteBuffer = byteBufferArr[dequeueOutputBuffer];
                                    byteBuffer.position(bufferInfo.offset);
                                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                    byte[] bArr3 = new byte[bufferInfo.size];
                                    byteBuffer.get(bArr3);
                                    if (z) {
                                        bArr = null;
                                        bArr2 = null;
                                    } else {
                                        bArr2 = aVar2.a() ? g.b(aVar2.f64035c / 8, aVar.f64035c / 8, bArr3) : null;
                                        if (aVar2.b()) {
                                            bArr = g.c(aVar2.f64034b, aVar.f64034b, aVar.f64035c / 8, bArr2 == null ? bArr3 : bArr2);
                                        } else {
                                            bArr = null;
                                        }
                                    }
                                    if (bArr == null) {
                                        bArr = bArr2 == null ? bArr3 : bArr2;
                                    }
                                    fileOutputStream.write(bArr);
                                    if (this.f64021b != null) {
                                        this.f64021b.a(bArr3, bufferInfo.presentationTimeUs / d2);
                                    }
                                    BdLog.i(this.f64020a + " presentationTimeUs : " + bufferInfo.presentationTimeUs);
                                    z2 = false;
                                }
                                createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, z2);
                                if ((bufferInfo.flags & 4) != 0) {
                                    BdLog.i("saw output EOS.");
                                    z3 = true;
                                }
                            }
                        } else if (dequeueOutputBuffer == -3) {
                            ByteBuffer[] outputBuffers2 = createDecoderByType.getOutputBuffers();
                            BdLog.i("output buffers have changed.");
                            byteBufferArr = outputBuffers2;
                        } else if (dequeueOutputBuffer == -2) {
                            BdLog.e("output format has changed to " + createDecoderByType.getOutputFormat());
                        }
                        currentTimeMillis = j;
                        d3 = d2;
                    }
                } finally {
                    fileOutputStream.close();
                    createDecoderByType.stop();
                    createDecoderByType.release();
                    mediaExtractor.release();
                }
            }
            d2 = d3;
            dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 5000L);
            if (dequeueOutputBuffer < 0) {
            }
            currentTimeMillis = j;
            d3 = d2;
        }
        long j2 = currentTimeMillis;
        if (this.f64021b != null) {
            this.f64021b.a(null, 1.0d);
        }
        BdLog.i("decode " + str + " cost " + (System.currentTimeMillis() - j2) + " milliseconds !");
        return bVar;
    }
}
