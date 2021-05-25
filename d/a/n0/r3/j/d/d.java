package d.a.n0.r3.j.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.write.write.WriteActivity;
import d.a.c.e.p.k;
import d.a.n0.r3.j.d.b;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes5.dex */
public class d extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public String f60087e;

    /* renamed from: f  reason: collision with root package name */
    public Context f60088f;

    /* renamed from: g  reason: collision with root package name */
    public e f60089g;

    /* renamed from: h  reason: collision with root package name */
    public long f60090h;

    /* renamed from: i  reason: collision with root package name */
    public b.c f60091i;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.k();
        }
    }

    public d(Context context, String str, e eVar, b.c cVar) {
        super("FilterAudioThread");
        this.f60090h = -1L;
        this.f60088f = context;
        this.f60087e = str;
        this.f60089g = eVar;
        this.f60091i = cVar;
    }

    public static String g(MediaFormat mediaFormat) {
        return mediaFormat.getString("mime");
    }

    public static boolean h(MediaFormat mediaFormat) {
        return g(mediaFormat).startsWith("audio/");
    }

    public static void j(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        BdLog.i(str2);
    }

    public static MediaCodecInfo l(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static void m(MediaFormat mediaFormat, MediaFormat mediaFormat2, String str, int i2) {
        if (mediaFormat != null && mediaFormat.containsKey(str) && mediaFormat.getInteger(str) > 0) {
            i2 = mediaFormat.getInteger(str);
        }
        if (mediaFormat2 != null) {
            mediaFormat2.setInteger(str, i2);
        }
    }

    public final MediaCodec a(MediaFormat mediaFormat) throws IOException {
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(g(mediaFormat));
        createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        createDecoderByType.start();
        return createDecoderByType;
    }

    public final MediaCodec b(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) throws IOException {
        MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        createByCodecName.start();
        return createByCodecName;
    }

    public final MediaExtractor c() throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(this.f60087e);
        return mediaExtractor;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r32v0, resolved type: android.media.MediaCodec */
    /* JADX DEBUG: Multi-variable search result rejected for r33v0, resolved type: android.media.MediaCodec */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01f3 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2) {
        int i2;
        ByteBuffer[] byteBufferArr;
        MediaCodec.BufferInfo bufferInfo;
        ?? r11;
        int i3;
        boolean z;
        ByteBuffer[] byteBufferArr2;
        int i4;
        ByteBuffer[] byteBufferArr3;
        MediaCodec.BufferInfo bufferInfo2;
        MediaFormat mediaFormat;
        boolean z2;
        int dequeueInputBuffer;
        int dequeueOutputBuffer;
        int dequeueInputBuffer2;
        int i5;
        boolean z3;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        ByteBuffer[] inputBuffers2 = mediaCodec2.getInputBuffers();
        ByteBuffer[] outputBuffers2 = mediaCodec2.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo3 = new MediaCodec.BufferInfo();
        MediaCodec.BufferInfo bufferInfo4 = new MediaCodec.BufferInfo();
        int i6 = -1;
        int i7 = 0;
        ByteBuffer[] byteBufferArr4 = outputBuffers2;
        MediaFormat mediaFormat2 = null;
        boolean z4 = false;
        int i8 = -1;
        int i9 = -1;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        ByteBuffer[] byteBufferArr5 = inputBuffers2;
        while (!z5 && i()) {
            if (z4 || !((mediaFormat2 == null || this.f60089g.b()) && i() && (dequeueInputBuffer2 = mediaCodec.dequeueInputBuffer(10000L)) != i6)) {
                i2 = i9;
                byteBufferArr = inputBuffers;
                bufferInfo = bufferInfo4;
                r11 = 0;
                i3 = i8;
                z = z4;
            } else {
                int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer2], i7);
                long sampleTime = mediaExtractor.getSampleTime();
                if (readSampleData >= 0) {
                    i5 = dequeueInputBuffer2;
                    bufferInfo = bufferInfo4;
                    i3 = i8;
                    i2 = i9;
                    byteBufferArr = inputBuffers;
                    z3 = false;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer2, 0, readSampleData, sampleTime, mediaExtractor.getSampleFlags());
                } else {
                    i5 = dequeueInputBuffer2;
                    i2 = i9;
                    byteBufferArr = inputBuffers;
                    bufferInfo = bufferInfo4;
                    z3 = false;
                    i3 = i8;
                }
                z = !mediaExtractor.advance();
                r11 = z3;
                if (z) {
                    mediaCodec.queueInputBuffer(i5, 0, 0, 0L, 4);
                    r11 = z3;
                }
            }
            if (!z6 && i3 == -1 && ((mediaFormat2 == null || this.f60089g.b()) && i() && (dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo3, 10000L)) != -1)) {
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = mediaCodec.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    mediaCodec.getOutputFormat();
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if ((bufferInfo3.flags & 2) != 0) {
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, (boolean) r11);
                    } else {
                        byteBufferArr2 = outputBuffers;
                        i4 = dequeueOutputBuffer;
                        if (i4 == -1 && i() && (dequeueInputBuffer = mediaCodec2.dequeueInputBuffer(10000L)) != -1) {
                            ByteBuffer byteBuffer2 = byteBufferArr5[dequeueInputBuffer];
                            int i10 = bufferInfo3.size;
                            long j = bufferInfo3.presentationTimeUs;
                            if (i10 >= 0) {
                                ByteBuffer duplicate = byteBufferArr2[i4].duplicate();
                                duplicate.position(bufferInfo3.offset);
                                duplicate.limit(bufferInfo3.offset + i10);
                                byteBuffer2.position(r11);
                                byteBuffer2.put(duplicate);
                                mediaCodec2.queueInputBuffer(dequeueInputBuffer, 0, i10, j, bufferInfo3.flags);
                            }
                            mediaCodec.releaseOutputBuffer(i4, (boolean) r11);
                            i8 = -1;
                            if ((bufferInfo3.flags & 4) != 0) {
                                z6 = true;
                            }
                        } else {
                            i8 = i4;
                        }
                        if (z5 && ((mediaFormat2 == null || this.f60089g.b()) && i())) {
                            bufferInfo2 = bufferInfo;
                            int dequeueOutputBuffer2 = mediaCodec2.dequeueOutputBuffer(bufferInfo2, 10000L);
                            if (dequeueOutputBuffer2 != -1) {
                                if (dequeueOutputBuffer2 == -3) {
                                    byteBufferArr4 = mediaCodec2.getOutputBuffers();
                                    byteBufferArr3 = byteBufferArr5;
                                    mediaFormat = mediaFormat2;
                                } else if (dequeueOutputBuffer2 != -2) {
                                    ByteBuffer byteBuffer3 = byteBufferArr4[dequeueOutputBuffer2];
                                    if ((bufferInfo2.flags & 2) != 0) {
                                        mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, (boolean) r11);
                                    } else {
                                        if (bufferInfo2.size != 0) {
                                            byteBufferArr3 = byteBufferArr5;
                                            if (bufferInfo2.presentationTimeUs > this.f60090h) {
                                                this.f60089g.g(i2, byteBuffer3, bufferInfo2);
                                                this.f60090h = bufferInfo2.presentationTimeUs;
                                            }
                                        } else {
                                            byteBufferArr3 = byteBufferArr5;
                                        }
                                        if ((bufferInfo2.flags & 4) != 0) {
                                            z2 = false;
                                            z5 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, z2);
                                        mediaFormat = mediaFormat2;
                                        if (mediaFormat != null && !z7) {
                                            j("InnerAudioProcessor", "muxer: adding audio track.");
                                            i2 = this.f60089g.a(mediaFormat);
                                            z7 = true;
                                        }
                                        if (!this.f60089g.b() && z7) {
                                            this.f60089g.c();
                                            if (this.f60089g.e()) {
                                                synchronized (this.f60089g) {
                                                    while (!this.f60089g.b()) {
                                                        try {
                                                            this.f60089g.wait(100L);
                                                        } catch (InterruptedException e2) {
                                                            e2.printStackTrace();
                                                        }
                                                    }
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                        byteBufferArr5 = byteBufferArr3;
                                        mediaFormat2 = mediaFormat;
                                        outputBuffers = byteBufferArr2;
                                        i9 = i2;
                                        inputBuffers = byteBufferArr;
                                        i7 = 0;
                                        i6 = -1;
                                        bufferInfo4 = bufferInfo2;
                                        z4 = z;
                                    }
                                } else if (i2 >= 0) {
                                    return;
                                } else {
                                    mediaFormat = mediaCodec2.getOutputFormat();
                                    byteBufferArr3 = byteBufferArr5;
                                }
                                if (mediaFormat != null) {
                                    j("InnerAudioProcessor", "muxer: adding audio track.");
                                    i2 = this.f60089g.a(mediaFormat);
                                    z7 = true;
                                }
                                if (!this.f60089g.b()) {
                                    this.f60089g.c();
                                    if (this.f60089g.e()) {
                                    }
                                }
                                byteBufferArr5 = byteBufferArr3;
                                mediaFormat2 = mediaFormat;
                                outputBuffers = byteBufferArr2;
                                i9 = i2;
                                inputBuffers = byteBufferArr;
                                i7 = 0;
                                i6 = -1;
                                bufferInfo4 = bufferInfo2;
                                z4 = z;
                            }
                            byteBufferArr3 = byteBufferArr5;
                        } else {
                            byteBufferArr3 = byteBufferArr5;
                            bufferInfo2 = bufferInfo;
                        }
                        mediaFormat = mediaFormat2;
                        if (mediaFormat != null) {
                        }
                        if (!this.f60089g.b()) {
                        }
                        byteBufferArr5 = byteBufferArr3;
                        mediaFormat2 = mediaFormat;
                        outputBuffers = byteBufferArr2;
                        i9 = i2;
                        inputBuffers = byteBufferArr;
                        i7 = 0;
                        i6 = -1;
                        bufferInfo4 = bufferInfo2;
                        z4 = z;
                    }
                }
            }
            int i11 = i3;
            byteBufferArr2 = outputBuffers;
            i4 = i11;
            if (i4 == -1) {
            }
            i8 = i4;
            if (z5) {
            }
            byteBufferArr3 = byteBufferArr5;
            bufferInfo2 = bufferInfo;
            mediaFormat = mediaFormat2;
            if (mediaFormat != null) {
            }
            if (!this.f60089g.b()) {
            }
            byteBufferArr5 = byteBufferArr3;
            mediaFormat2 = mediaFormat;
            outputBuffers = byteBufferArr2;
            i9 = i2;
            inputBuffers = byteBufferArr;
            i7 = 0;
            i6 = -1;
            bufferInfo4 = bufferInfo2;
            z4 = z;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ac, code lost:
        if (r1 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ae, code lost:
        r1.a(com.baidu.tieba.write.write.WriteActivity.CONTENT_MAX_COUNT, d.a.n0.u1.a.a(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0155, code lost:
        if (r1 == null) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x015b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x018a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0172 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() throws Exception {
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        MediaExtractor mediaExtractor;
        b.c cVar;
        MediaExtractor c2;
        int f2;
        MediaCodec a2;
        MediaCodecInfo l = l("audio/mp4a-latm");
        if (l == null) {
            return;
        }
        Exception e2 = null;
        try {
            c2 = c();
            try {
                f2 = f(c2);
            } catch (Exception e3) {
                e = e3;
                mediaCodec = null;
                mediaExtractor = c2;
                mediaCodec2 = null;
            } catch (Throwable th) {
                th = th;
                mediaCodec = null;
                mediaExtractor = c2;
                mediaCodec2 = null;
            }
        } catch (Exception e4) {
            e = e4;
            mediaCodec = null;
            mediaCodec2 = null;
            mediaExtractor = null;
        } catch (Throwable th2) {
            th = th2;
            mediaCodec = null;
            mediaCodec2 = null;
            mediaExtractor = null;
        }
        if (f2 < 0 && this.f60089g != null) {
            this.f60089g.c();
            if (c2 != null) {
                try {
                    c2.release();
                    return;
                } catch (Exception e5) {
                    b.c cVar2 = this.f60091i;
                    if (cVar2 != null) {
                        cVar2.a(231, d.a.n0.u1.a.a(e5));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        MediaFormat trackFormat = c2.getTrackFormat(f2);
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", "audio/mp4a-latm");
        mediaFormat.setInteger("aac-profile", 5);
        mediaFormat.setInteger("max-input-size", 8192);
        m(trackFormat, mediaFormat, "sample-rate", 48000);
        m(trackFormat, mediaFormat, "channel-count", 1);
        m(trackFormat, mediaFormat, "bitrate", 128000);
        MediaCodec b2 = b(l, mediaFormat);
        try {
            a2 = a(trackFormat);
        } catch (Exception e6) {
            mediaExtractor = c2;
            mediaCodec2 = null;
            mediaCodec = b2;
            e = e6;
        } catch (Throwable th3) {
            mediaExtractor = c2;
            mediaCodec2 = null;
            mediaCodec = b2;
            th = th3;
        }
        try {
            d(c2, a2, b2);
            if (c2 != null) {
                try {
                    c2.release();
                } catch (Exception e7) {
                    e2 = e7;
                    b.c cVar3 = this.f60091i;
                    if (cVar3 != null) {
                        cVar3.a(231, d.a.n0.u1.a.a(e2));
                    }
                }
            }
            if (a2 != null) {
                try {
                    a2.stop();
                    a2.release();
                } catch (Exception e8) {
                    if (e2 == null) {
                        e2 = e8;
                    }
                    b.c cVar4 = this.f60091i;
                    if (cVar4 != null) {
                        cVar4.a(232, d.a.n0.u1.a.a(e8));
                    }
                }
            }
            if (b2 != null) {
                try {
                    b2.stop();
                    b2.release();
                } catch (Exception e9) {
                    e = e9;
                    if (e2 == null) {
                        e2 = e;
                    }
                    cVar = this.f60091i;
                }
            }
        } catch (Exception e10) {
            mediaCodec = b2;
            e = e10;
            mediaExtractor = c2;
            mediaCodec2 = a2;
            try {
                e.printStackTrace();
                if ((Build.VERSION.SDK_INT < 21 || !(e instanceof MediaCodec.CodecException) || k.isEmpty(e.getMessage()) || !e.getMessage().contains("0xfffffff3")) && this.f60091i != null) {
                    this.f60091i.a(230, d.a.n0.u1.a.a(e));
                }
                if (mediaExtractor != null) {
                    try {
                        mediaExtractor.release();
                    } catch (Exception e11) {
                        e2 = e11;
                        b.c cVar5 = this.f60091i;
                        if (cVar5 != null) {
                            cVar5.a(231, d.a.n0.u1.a.a(e2));
                        }
                    }
                }
                if (mediaCodec2 != null) {
                    try {
                        mediaCodec2.stop();
                        mediaCodec2.release();
                    } catch (Exception e12) {
                        if (e2 == null) {
                            e2 = e12;
                        }
                        b.c cVar6 = this.f60091i;
                        if (cVar6 != null) {
                            cVar6.a(232, d.a.n0.u1.a.a(e12));
                        }
                    }
                }
                if (mediaCodec != null) {
                    try {
                        mediaCodec.stop();
                        mediaCodec.release();
                    } catch (Exception e13) {
                        e = e13;
                        if (e2 == null) {
                            e2 = e;
                        }
                        cVar = this.f60091i;
                    }
                }
                if (e2 == null) {
                }
            } catch (Throwable th4) {
                th = th4;
                if (mediaExtractor != null) {
                    try {
                        mediaExtractor.release();
                    } catch (Exception e14) {
                        e2 = e14;
                        b.c cVar7 = this.f60091i;
                        if (cVar7 != null) {
                            cVar7.a(231, d.a.n0.u1.a.a(e2));
                        }
                    }
                }
                if (mediaCodec2 != null) {
                    try {
                        mediaCodec2.stop();
                        mediaCodec2.release();
                    } catch (Exception e15) {
                        if (e2 == null) {
                        }
                        b.c cVar8 = this.f60091i;
                        if (cVar8 != null) {
                            cVar8.a(232, d.a.n0.u1.a.a(e15));
                        }
                    }
                }
                if (mediaCodec != null) {
                    try {
                        mediaCodec.stop();
                        mediaCodec.release();
                    } catch (Exception e16) {
                        b.c cVar9 = this.f60091i;
                        if (cVar9 != null) {
                            cVar9.a(WriteActivity.CONTENT_MAX_COUNT, d.a.n0.u1.a.a(e16));
                        }
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            mediaCodec = b2;
            th = th5;
            mediaExtractor = c2;
            mediaCodec2 = a2;
            if (mediaExtractor != null) {
            }
            if (mediaCodec2 != null) {
            }
            if (mediaCodec != null) {
            }
            throw th;
        }
        if (e2 == null) {
            throw e2;
        }
    }

    public final int f(MediaExtractor mediaExtractor) {
        for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
            if (h(mediaExtractor.getTrackFormat(i2))) {
                mediaExtractor.selectTrack(i2);
                return i2;
            }
        }
        return -1;
    }

    public final boolean i() {
        return !Thread.currentThread().isInterrupted();
    }

    public abstract void k();

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            e();
            if (i()) {
                d.a.c.e.m.e.a().post(new a());
            }
        } catch (Exception unused) {
        }
    }
}
