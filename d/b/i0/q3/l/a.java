package d.b.i0.q3.l;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.misc.IMediaFormat;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: d  reason: collision with root package name */
    public long f60760d;

    public a(String str) {
        super(str);
        this.f60760d = 88200L;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x016c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d7 A[Catch: all -> 0x01a3, Exception -> 0x01a6, TryCatch #8 {Exception -> 0x01a6, all -> 0x01a3, blocks: (B:11:0x002a, B:15:0x0057, B:17:0x005d, B:19:0x0069, B:22:0x006e, B:27:0x007e, B:31:0x00d1, B:33:0x00d7, B:35:0x00dd, B:36:0x00e9, B:38:0x00ed, B:40:0x011f, B:41:0x0154, B:42:0x0159, B:47:0x0170, B:50:0x0178, B:28:0x009c, B:52:0x0197), top: B:96:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d8 A[Catch: Exception -> 0x01d4, TRY_LEAVE, TryCatch #8 {Exception -> 0x01d4, blocks: (B:82:0x01d0, B:86:0x01d8), top: B:93:0x01d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // d.b.i0.q3.l.d
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        ByteBuffer[] byteBufferArr;
        long j;
        int dequeueOutputBuffer;
        int dequeueInputBuffer;
        boolean z;
        int i;
        a aVar = this;
        FileInputStream fileInputStream = null;
        try {
            try {
                if (aVar.f60765b == 0) {
                    aVar.f60765b = 48000;
                }
                if (aVar.f60766c == 0) {
                    aVar.f60766c = 1;
                }
                aVar.f60760d = (aVar.f60765b * 16) / 8;
                FileInputStream fileInputStream2 = new FileInputStream(aVar.f60764a);
                try {
                    fileOutputStream = new FileOutputStream(str);
                    try {
                        MediaCodec f2 = f();
                        f2.start();
                        ByteBuffer[] inputBuffers = f2.getInputBuffers();
                        ByteBuffer[] outputBuffers = f2.getOutputBuffers();
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        byte[] bArr = new byte[4096];
                        ByteBuffer[] byteBufferArr2 = outputBuffers;
                        long j2 = 0;
                        long j3 = 0;
                        boolean z2 = false;
                        int i2 = 0;
                        boolean z3 = false;
                        boolean z4 = false;
                        int i3 = 0;
                        while (!z3) {
                            if (z4 || (dequeueInputBuffer = f2.dequeueInputBuffer(10000L)) < 0) {
                                byteBufferArr = inputBuffers;
                            } else {
                                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                                byteBuffer.clear();
                                int remaining = byteBuffer.remaining();
                                if (remaining != bArr.length) {
                                    bArr = new byte[remaining];
                                }
                                byte[] bArr2 = bArr;
                                if (z2 || (i2 = fileInputStream2.read(bArr2)) != -1) {
                                    z = z2;
                                    i = i2;
                                } else {
                                    i = i2;
                                    z = true;
                                }
                                if (z) {
                                    f2.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                    byteBufferArr = inputBuffers;
                                    i2 = i;
                                    bArr = bArr2;
                                    z2 = z;
                                    j = 10000;
                                    z4 = true;
                                    dequeueOutputBuffer = f2.dequeueOutputBuffer(bufferInfo, j);
                                    if (dequeueOutputBuffer < 0) {
                                        if ((bufferInfo.flags & 2) != 0) {
                                            BdLog.i("audio encoder: codec config buffer");
                                            f2.releaseOutputBuffer(dequeueOutputBuffer, false);
                                        } else {
                                            if (bufferInfo.size != 0) {
                                                ByteBuffer byteBuffer2 = byteBufferArr2[dequeueOutputBuffer];
                                                byteBuffer2.position(bufferInfo.offset);
                                                byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                                                BdLog.i(String.format(" writing audio sample : size=%s , presentationTimeUs=%s", Integer.valueOf(bufferInfo.size), Long.valueOf(bufferInfo.presentationTimeUs)));
                                                if (j2 < bufferInfo.presentationTimeUs) {
                                                    long j4 = bufferInfo.presentationTimeUs;
                                                    int i4 = bufferInfo.size;
                                                    int i5 = i4 + 7;
                                                    byteBuffer2.position(bufferInfo.offset);
                                                    byteBuffer2.limit(bufferInfo.offset + i4);
                                                    byte[] bArr3 = new byte[i5];
                                                    aVar.e(bArr3, i5);
                                                    byteBuffer2.get(bArr3, 7, i4);
                                                    fileOutputStream.write(bArr3, 0, i5);
                                                    BdLog.i(i5 + " bytes written.");
                                                    j2 = j4;
                                                } else {
                                                    BdLog.i("error sample! its presentationTimeUs should not lower than before.");
                                                }
                                            }
                                            f2.releaseOutputBuffer(dequeueOutputBuffer, false);
                                            if ((bufferInfo.flags & 4) != 0) {
                                                aVar = this;
                                                inputBuffers = byteBufferArr;
                                                z3 = true;
                                            }
                                        }
                                    } else if (dequeueOutputBuffer == -3) {
                                        byteBufferArr2 = f2.getOutputBuffers();
                                    } else if (dequeueOutputBuffer == -2) {
                                        BdLog.i("format change : " + f2.getOutputFormat());
                                    }
                                    aVar = this;
                                    inputBuffers = byteBufferArr;
                                } else {
                                    int i6 = i;
                                    byteBuffer.put(bArr2, 0, i6);
                                    int i7 = i3 + i6;
                                    byteBufferArr = inputBuffers;
                                    f2.queueInputBuffer(dequeueInputBuffer, 0, i6, j3, 0);
                                    i3 = i7;
                                    i2 = i6;
                                    j3 = (long) (((i7 / 2.0d) * 1000000.0d) / aVar.f60760d);
                                    bArr = bArr2;
                                    z2 = z;
                                }
                            }
                            j = 10000;
                            dequeueOutputBuffer = f2.dequeueOutputBuffer(bufferInfo, j);
                            if (dequeueOutputBuffer < 0) {
                            }
                            aVar = this;
                            inputBuffers = byteBufferArr;
                        }
                        BdLog.i("acc encode done");
                        fileInputStream2.close();
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
    }

    public final void e(byte[] bArr, int i) {
        int[] iArr = {96000, 88200, 64000, 48000, SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
        int i2 = 0;
        while (true) {
            if (i2 >= 13) {
                i2 = 4;
                break;
            } else if (iArr[i2] == this.f60765b) {
                break;
            } else {
                i2++;
            }
        }
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) (64 + (i2 << 2) + 0);
        bArr[3] = (byte) (128 + (i >> 11));
        bArr[4] = (byte) ((i & 2047) >> 3);
        bArr[5] = (byte) (((i & 7) << 5) + 31);
        bArr[6] = -4;
    }

    @TargetApi(16)
    public final MediaCodec f() throws IOException {
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, "audio/mp4a-latm");
        mediaFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, 128000);
        mediaFormat.setInteger("channel-count", this.f60766c);
        mediaFormat.setInteger("sample-rate", this.f60765b);
        mediaFormat.setInteger("aac-profile", 2);
        createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        return createEncoderByType;
    }
}
