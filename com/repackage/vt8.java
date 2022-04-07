package com.repackage;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.au8;
import com.repackage.wt8;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class vt8 extends wt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vt8(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00f9 A[Catch: all -> 0x020d, TryCatch #0 {all -> 0x020d, blocks: (B:24:0x00ac, B:26:0x00b2, B:28:0x00ba, B:31:0x00f3, B:33:0x00f9, B:35:0x00ff, B:36:0x0109, B:38:0x010d, B:40:0x0125, B:42:0x012b, B:44:0x0139, B:46:0x013f, B:50:0x014c, B:57:0x015c, B:59:0x0163, B:60:0x016d, B:61:0x0189, B:63:0x0192, B:66:0x019d, B:69:0x01ac, B:29:0x00d8, B:71:0x01cb, B:73:0x01d1, B:74:0x01d9), top: B:86:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019a  */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public wt8.b a(String str, boolean z, au8.a aVar, au8.a aVar2) throws Exception {
        InterceptResult invokeCommon;
        MediaFormat mediaFormat;
        double d;
        int dequeueOutputBuffer;
        byte[] bArr;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), aVar, aVar2})) == null) {
            if (TextUtils.isEmpty(str) || aVar == null || aVar2 == null) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = this.a;
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str2);
            boolean z2 = false;
            int i = 0;
            while (true) {
                if (i >= mediaExtractor.getTrackCount()) {
                    mediaFormat = null;
                    break;
                }
                mediaFormat = mediaExtractor.getTrackFormat(i);
                if (mediaFormat.getString("mime").startsWith("audio/")) {
                    mediaExtractor.selectTrack(i);
                    break;
                }
                i++;
            }
            if (mediaFormat == null) {
                BdLog.e("not a valid file with audio track..");
                mediaExtractor.release();
                return null;
            }
            BdLog.e("mediaFormat " + mediaFormat);
            wt8.b bVar = new wt8.b();
            int i2 = aVar2.b;
            int i3 = aVar2.a;
            int i4 = aVar2.c;
            bVar.a = str;
            FileOutputStream fileOutputStream = new FileOutputStream(bVar.a);
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
            createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
            createDecoderByType.start();
            ByteBuffer[] inputBuffers = createDecoderByType.getInputBuffers();
            ByteBuffer[] outputBuffers = createDecoderByType.getOutputBuffers();
            double d2 = mediaFormat.getLong("durationUs");
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
                                d = d2;
                                createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                z4 = true;
                            } else {
                                d = d2;
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
                                            bArr2 = aVar2.a() ? au8.b(aVar2.c / 8, aVar.c / 8, bArr3) : null;
                                            if (aVar2.b()) {
                                                bArr = au8.c(aVar2.b, aVar.b, aVar.c / 8, bArr2 == null ? bArr3 : bArr2);
                                            } else {
                                                bArr = null;
                                            }
                                        }
                                        if (bArr == null) {
                                            bArr = bArr2 == null ? bArr3 : bArr2;
                                        }
                                        fileOutputStream.write(bArr);
                                        if (this.b != null) {
                                            this.b.a(bArr3, bufferInfo.presentationTimeUs / d);
                                        }
                                        BdLog.i(this.a + " presentationTimeUs : " + bufferInfo.presentationTimeUs);
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
                            d2 = d;
                        }
                    } finally {
                        fileOutputStream.close();
                        createDecoderByType.stop();
                        createDecoderByType.release();
                        mediaExtractor.release();
                    }
                }
                d = d2;
                dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 5000L);
                if (dequeueOutputBuffer < 0) {
                }
                currentTimeMillis = j;
                d2 = d;
            }
            long j2 = currentTimeMillis;
            if (this.b != null) {
                this.b.a(null, 1.0d);
            }
            BdLog.i("decode " + str + " cost " + (System.currentTimeMillis() - j2) + " milliseconds !");
            return bVar;
        }
        return (wt8.b) invokeCommon.objValue;
    }
}
