package d.a.o0.r3.i.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.misc.IMediaFormat;
import com.sina.weibo.sdk.utils.FileUtils;
import d.a.c.e.p.k;
import d.a.o0.r3.i.d.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(18)
/* loaded from: classes5.dex */
public class f extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public Context f63912e;

    /* renamed from: f  reason: collision with root package name */
    public String f63913f;

    /* renamed from: g  reason: collision with root package name */
    public String f63914g;

    /* renamed from: h  reason: collision with root package name */
    public e f63915h;

    /* renamed from: i  reason: collision with root package name */
    public b.c f63916i;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.k();
        }
    }

    public f(Context context, String str, String str2, e eVar, b.c cVar) {
        super("FilterVideoThread");
        this.f63912e = context;
        this.f63913f = str;
        this.f63914g = str2;
        this.f63915h = eVar;
        this.f63916i = cVar;
    }

    public static String g(MediaFormat mediaFormat) {
        return mediaFormat.getString(IMediaFormat.KEY_MIME);
    }

    public static boolean i(MediaFormat mediaFormat) {
        return g(mediaFormat).startsWith(FileUtils.VIDEO_FILE_START);
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

    public final MediaExtractor a() throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(this.f63913f);
        return mediaExtractor;
    }

    public final MediaCodec b(MediaFormat mediaFormat, Surface surface) throws IOException {
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(g(mediaFormat));
        createDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
        createDecoderByType.start();
        return createDecoderByType;
    }

    public final MediaCodec c(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, AtomicReference<Surface> atomicReference) throws IOException {
        MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        atomicReference.set(createByCodecName.createInputSurface());
        createByCodecName.start();
        return createByCodecName;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0102 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0167 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0182 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0191  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2, g gVar, h hVar) {
        long j;
        int i2;
        ByteBuffer[] byteBufferArr;
        int i3;
        MediaFormat mediaFormat;
        MediaFormat mediaFormat2;
        MediaFormat mediaFormat3;
        boolean z;
        int dequeueOutputBuffer;
        int dequeueInputBuffer;
        int i4;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        ByteBuffer[] outputBuffers2 = mediaCodec2.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
        int i5 = -1;
        int i6 = 0;
        ByteBuffer[] byteBufferArr2 = outputBuffers2;
        MediaFormat mediaFormat4 = null;
        boolean z2 = false;
        int i7 = -1;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (!z3 && h()) {
            if (z2 || !((mediaFormat4 == null || this.f63915h.b()) && h() && (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) != i5)) {
                j = 10000;
                i2 = i7;
            } else {
                int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i6);
                long sampleTime = mediaExtractor.getSampleTime();
                if (readSampleData >= 0) {
                    i4 = dequeueInputBuffer;
                    j = 10000;
                    i2 = i7;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, mediaExtractor.getSampleFlags());
                } else {
                    i4 = dequeueInputBuffer;
                    j = 10000;
                    i2 = i7;
                }
                boolean z6 = !mediaExtractor.advance();
                if (z6) {
                    mediaCodec.queueInputBuffer(i4, 0, 0, 0L, 4);
                }
                z2 = z6;
            }
            if (!z4 && ((mediaFormat4 == null || this.f63915h.b()) && h() && (dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, j)) != -1)) {
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = mediaCodec.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    mediaCodec.getOutputFormat();
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if ((bufferInfo.flags & 2) != 0) {
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else {
                        boolean z7 = bufferInfo.size != 0;
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z7);
                        if (z7) {
                            hVar.a();
                            hVar.c();
                            gVar.e(bufferInfo.presentationTimeUs * 1000);
                            gVar.f();
                        }
                        if ((bufferInfo.flags & 4) != 0) {
                            mediaCodec2.signalEndOfInputStream();
                            byteBufferArr = outputBuffers;
                            z4 = true;
                            if (z3 && ((mediaFormat4 == null || this.f63915h.b()) && h())) {
                                int dequeueOutputBuffer2 = mediaCodec2.dequeueOutputBuffer(bufferInfo2, j);
                                if (dequeueOutputBuffer2 == -1) {
                                    i3 = i2;
                                } else {
                                    if (dequeueOutputBuffer2 == -3) {
                                        byteBufferArr2 = mediaCodec2.getOutputBuffers();
                                        mediaFormat = mediaFormat4;
                                        i3 = i2;
                                    } else if (dequeueOutputBuffer2 == -2) {
                                        i3 = i2;
                                        if (i3 >= 0) {
                                            return;
                                        }
                                        mediaFormat = mediaCodec2.getOutputFormat();
                                    } else {
                                        i3 = i2;
                                        ByteBuffer byteBuffer2 = byteBufferArr2[dequeueOutputBuffer2];
                                        if ((bufferInfo2.flags & 2) != 0) {
                                            mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, false);
                                        } else {
                                            if (bufferInfo2.size != 0) {
                                                this.f63915h.g(i3, byteBuffer2, bufferInfo2);
                                            }
                                            if ((bufferInfo2.flags & 4) != 0) {
                                                z = false;
                                                z3 = true;
                                            } else {
                                                z = false;
                                            }
                                            mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, z);
                                        }
                                    }
                                    if (mediaFormat != null || z5) {
                                        i7 = i3;
                                    } else {
                                        j("InnerVideoProcessor", "muxer: adding video track.");
                                        i7 = this.f63915h.a(mediaFormat);
                                        z5 = true;
                                    }
                                    if (!this.f63915h.b() && z5) {
                                        this.f63915h.d();
                                        if (!this.f63915h.e()) {
                                            synchronized (this.f63915h) {
                                                while (!this.f63915h.b()) {
                                                    try {
                                                        mediaFormat3 = mediaFormat;
                                                    } catch (InterruptedException e2) {
                                                        e = e2;
                                                        mediaFormat3 = mediaFormat;
                                                    }
                                                    try {
                                                        this.f63915h.wait(100L);
                                                    } catch (InterruptedException e3) {
                                                        e = e3;
                                                        e.printStackTrace();
                                                        mediaFormat = mediaFormat3;
                                                    }
                                                    mediaFormat = mediaFormat3;
                                                }
                                                mediaFormat2 = mediaFormat;
                                            }
                                            outputBuffers = byteBufferArr;
                                            mediaFormat4 = mediaFormat2;
                                            i5 = -1;
                                            i6 = 0;
                                        }
                                    }
                                    mediaFormat2 = mediaFormat;
                                    outputBuffers = byteBufferArr;
                                    mediaFormat4 = mediaFormat2;
                                    i5 = -1;
                                    i6 = 0;
                                }
                            } else {
                                i3 = i2;
                            }
                            mediaFormat = mediaFormat4;
                            if (mediaFormat != null) {
                            }
                            i7 = i3;
                            if (!this.f63915h.b()) {
                                this.f63915h.d();
                                if (!this.f63915h.e()) {
                                }
                            }
                            mediaFormat2 = mediaFormat;
                            outputBuffers = byteBufferArr;
                            mediaFormat4 = mediaFormat2;
                            i5 = -1;
                            i6 = 0;
                        }
                        byteBufferArr = outputBuffers;
                        if (z3) {
                        }
                        i3 = i2;
                        mediaFormat = mediaFormat4;
                        if (mediaFormat != null) {
                        }
                        i7 = i3;
                        if (!this.f63915h.b()) {
                        }
                        mediaFormat2 = mediaFormat;
                        outputBuffers = byteBufferArr;
                        mediaFormat4 = mediaFormat2;
                        i5 = -1;
                        i6 = 0;
                    }
                }
            }
            byteBufferArr = outputBuffers;
            if (z3) {
            }
            i3 = i2;
            mediaFormat = mediaFormat4;
            if (mediaFormat != null) {
            }
            i7 = i3;
            if (!this.f63915h.b()) {
            }
            mediaFormat2 = mediaFormat;
            outputBuffers = byteBufferArr;
            mediaFormat4 = mediaFormat2;
            i5 = -1;
            i6 = 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x0205, code lost:
        if (r0 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0106, code lost:
        if (r0 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0108, code lost:
        r0.a(229, d.a.o0.u1.a.a(r1));
     */
    /* JADX WARN: Removed duplicated region for block: B:142:0x020b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x026a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0252 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x01cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0211 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x023c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x01b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() throws Exception {
        Throwable th;
        h hVar;
        g gVar;
        MediaExtractor mediaExtractor;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        Exception exc;
        b.c cVar;
        MediaCodecInfo l = l("video/avc");
        if (l == null) {
            return;
        }
        Exception exc2 = null;
        try {
            mediaExtractor = a();
        } catch (Exception e2) {
            e = e2;
            hVar = null;
            gVar = null;
            mediaExtractor = null;
            mediaCodec = null;
        } catch (Throwable th2) {
            th = th2;
            hVar = null;
            gVar = null;
            mediaExtractor = null;
            mediaCodec = null;
        }
        try {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(f(mediaExtractor));
            int integer = trackFormat.getInteger("width");
            int integer2 = trackFormat.getInteger("height");
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f63913f);
            if (TextUtils.equals(mediaMetadataRetriever.extractMetadata(24), "90")) {
                integer2 = integer;
                integer = integer2;
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", integer, integer2);
            createVideoFormat.setInteger("color-format", 2130708361);
            m(trackFormat, createVideoFormat, KsMediaMeta.KSM_KEY_BITRATE, 2097152);
            m(trackFormat, createVideoFormat, "frame-rate", 20);
            m(trackFormat, createVideoFormat, "i-frame-interval", 1);
            AtomicReference<Surface> atomicReference = new AtomicReference<>();
            mediaCodec = c(l, createVideoFormat, atomicReference);
            try {
                gVar = new g(atomicReference.get());
                try {
                    gVar.c();
                    hVar = new h(this.f63912e, this.f63914g, integer, integer2);
                    try {
                        mediaCodec2 = b(trackFormat, hVar.d());
                    } catch (Exception e3) {
                        e = e3;
                        mediaCodec2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        mediaCodec2 = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    hVar = null;
                    mediaCodec2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    hVar = null;
                    mediaCodec2 = null;
                }
                try {
                    d(mediaExtractor, mediaCodec2, mediaCodec, gVar, hVar);
                    if (mediaExtractor != null) {
                        try {
                            mediaExtractor.release();
                        } catch (Exception e5) {
                            exc2 = e5;
                            b.c cVar2 = this.f63916i;
                            if (cVar2 != null) {
                                cVar2.a(225, d.a.o0.u1.a.a(exc2));
                            }
                        }
                    }
                    if (mediaCodec2 != null) {
                        try {
                            mediaCodec2.stop();
                            mediaCodec2.release();
                        } catch (Exception e6) {
                            if (exc2 == null) {
                                exc2 = e6;
                            }
                            b.c cVar3 = this.f63916i;
                            if (cVar3 != null) {
                                cVar3.a(Constants.METHOD_MEDIA_NOTIFY, d.a.o0.u1.a.a(e6));
                            }
                        }
                    }
                    try {
                        hVar.e();
                    } catch (Exception e7) {
                        if (exc2 == null) {
                            exc2 = e7;
                        }
                        b.c cVar4 = this.f63916i;
                        if (cVar4 != null) {
                            cVar4.a(227, d.a.o0.u1.a.a(e7));
                        }
                    }
                    if (mediaCodec != null) {
                        try {
                            mediaCodec.stop();
                            mediaCodec.release();
                        } catch (Exception e8) {
                            if (exc2 == null) {
                                exc2 = e8;
                            }
                            b.c cVar5 = this.f63916i;
                            if (cVar5 != null) {
                                cVar5.a(228, d.a.o0.u1.a.a(e8));
                            }
                        }
                    }
                    try {
                        gVar.d();
                    } catch (Exception e9) {
                        exc = e9;
                        if (exc2 == null) {
                            exc2 = exc;
                        }
                        cVar = this.f63916i;
                    }
                } catch (Exception e10) {
                    e = e10;
                    hVar = hVar;
                    gVar = gVar;
                    try {
                        e.printStackTrace();
                        if ((Build.VERSION.SDK_INT >= 21 || !(e instanceof MediaCodec.CodecException) || k.isEmpty(e.getMessage()) || !e.getMessage().contains("0xfffffff3")) && this.f63916i != null) {
                            this.f63916i.a(224, d.a.o0.u1.a.a(e));
                        }
                        if (mediaExtractor != null) {
                            try {
                                mediaExtractor.release();
                            } catch (Exception e11) {
                                exc2 = e11;
                                b.c cVar6 = this.f63916i;
                                if (cVar6 != null) {
                                    cVar6.a(225, d.a.o0.u1.a.a(exc2));
                                }
                            }
                        }
                        if (mediaCodec2 != null) {
                            try {
                                mediaCodec2.stop();
                                mediaCodec2.release();
                            } catch (Exception e12) {
                                if (exc2 == null) {
                                    exc2 = e12;
                                }
                                b.c cVar7 = this.f63916i;
                                if (cVar7 != null) {
                                    cVar7.a(Constants.METHOD_MEDIA_NOTIFY, d.a.o0.u1.a.a(e12));
                                }
                            }
                        }
                        if (hVar != null) {
                            try {
                                hVar.e();
                            } catch (Exception e13) {
                                if (exc2 == null) {
                                    exc2 = e13;
                                }
                                b.c cVar8 = this.f63916i;
                                if (cVar8 != null) {
                                    cVar8.a(227, d.a.o0.u1.a.a(e13));
                                }
                            }
                        }
                        if (mediaCodec != null) {
                            try {
                                mediaCodec.stop();
                                mediaCodec.release();
                            } catch (Exception e14) {
                                if (exc2 == null) {
                                    exc2 = e14;
                                }
                                b.c cVar9 = this.f63916i;
                                if (cVar9 != null) {
                                    cVar9.a(228, d.a.o0.u1.a.a(e14));
                                }
                            }
                        }
                        if (gVar != null) {
                            try {
                                gVar.d();
                            } catch (Exception e15) {
                                exc = e15;
                                if (exc2 == null) {
                                    exc2 = exc;
                                }
                                cVar = this.f63916i;
                            }
                        }
                        if (exc2 != null) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (mediaExtractor != null) {
                            try {
                                mediaExtractor.release();
                            } catch (Exception e16) {
                                exc2 = e16;
                                b.c cVar10 = this.f63916i;
                                if (cVar10 != null) {
                                    cVar10.a(225, d.a.o0.u1.a.a(exc2));
                                }
                            }
                        }
                        if (mediaCodec2 != null) {
                            try {
                                mediaCodec2.stop();
                                mediaCodec2.release();
                            } catch (Exception e17) {
                                if (exc2 == null) {
                                    exc2 = e17;
                                }
                                b.c cVar11 = this.f63916i;
                                if (cVar11 != null) {
                                    cVar11.a(Constants.METHOD_MEDIA_NOTIFY, d.a.o0.u1.a.a(e17));
                                }
                            }
                        }
                        if (hVar != null) {
                            try {
                                hVar.e();
                            } catch (Exception e18) {
                                if (exc2 == null) {
                                    exc2 = e18;
                                }
                                b.c cVar12 = this.f63916i;
                                if (cVar12 != null) {
                                    cVar12.a(227, d.a.o0.u1.a.a(e18));
                                }
                            }
                        }
                        if (mediaCodec != null) {
                            try {
                                mediaCodec.stop();
                                mediaCodec.release();
                            } catch (Exception e19) {
                                if (exc2 == null) {
                                }
                                b.c cVar13 = this.f63916i;
                                if (cVar13 != null) {
                                    cVar13.a(228, d.a.o0.u1.a.a(e19));
                                }
                            }
                        }
                        if (gVar != null) {
                            try {
                                gVar.d();
                            } catch (Exception e20) {
                                b.c cVar14 = this.f63916i;
                                if (cVar14 != null) {
                                    cVar14.a(229, d.a.o0.u1.a.a(e20));
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    hVar = hVar;
                    gVar = gVar;
                    if (mediaExtractor != null) {
                    }
                    if (mediaCodec2 != null) {
                    }
                    if (hVar != null) {
                    }
                    if (mediaCodec != null) {
                    }
                    if (gVar != null) {
                    }
                    throw th;
                }
            } catch (Exception e21) {
                e = e21;
                hVar = null;
                gVar = null;
                mediaCodec2 = null;
            } catch (Throwable th7) {
                th = th7;
                hVar = null;
                gVar = null;
                mediaCodec2 = null;
            }
        } catch (Exception e22) {
            e = e22;
            hVar = null;
            gVar = null;
            mediaCodec = null;
            mediaCodec2 = mediaCodec;
            e.printStackTrace();
            if (Build.VERSION.SDK_INT >= 21) {
            }
            this.f63916i.a(224, d.a.o0.u1.a.a(e));
            if (mediaExtractor != null) {
            }
            if (mediaCodec2 != null) {
            }
            if (hVar != null) {
            }
            if (mediaCodec != null) {
            }
            if (gVar != null) {
            }
            if (exc2 != null) {
            }
        } catch (Throwable th8) {
            th = th8;
            hVar = null;
            gVar = null;
            mediaCodec = null;
            mediaCodec2 = mediaCodec;
            if (mediaExtractor != null) {
            }
            if (mediaCodec2 != null) {
            }
            if (hVar != null) {
            }
            if (mediaCodec != null) {
            }
            if (gVar != null) {
            }
            throw th;
        }
        if (exc2 != null) {
            throw exc2;
        }
    }

    public final int f(MediaExtractor mediaExtractor) {
        for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
            if (i(mediaExtractor.getTrackFormat(i2))) {
                mediaExtractor.selectTrack(i2);
                return i2;
            }
        }
        return -1;
    }

    public final boolean h() {
        return !Thread.currentThread().isInterrupted();
    }

    public abstract void k();

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            e();
            if (h()) {
                d.a.c.e.m.e.a().post(new a());
            }
        } catch (Exception unused) {
        }
    }
}
