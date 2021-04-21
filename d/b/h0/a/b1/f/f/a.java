package d.b.h0.a.b1.f.f;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.kwai.video.player.KsMediaMeta;
import d.b.h0.a.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class a {
    public static final boolean j = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public MediaCodec f44228a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer[] f44229b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer[] f44230c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f44231d;

    /* renamed from: g  reason: collision with root package name */
    public int f44234g;

    /* renamed from: h  reason: collision with root package name */
    public int f44235h;
    public String i;

    /* renamed from: f  reason: collision with root package name */
    public long f44233f = 0;

    /* renamed from: e  reason: collision with root package name */
    public ByteArrayOutputStream f44232e = new ByteArrayOutputStream();

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060 A[Catch: IOException -> 0x00b2, TryCatch #0 {IOException -> 0x00b2, blocks: (B:6:0x0028, B:25:0x0060, B:27:0x0064, B:28:0x006b, B:30:0x0087, B:13:0x0041, B:16:0x004b, B:19:0x0055), top: B:35:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(String str, int i, int i2, int i3) {
        char c2 = 0;
        this.f44234g = 0;
        this.f44235h = 0;
        this.i = "aac";
        this.f44234g = i2;
        this.f44235h = i;
        if (TextUtils.isEmpty(str)) {
            this.i = "aac";
        } else {
            this.i = str;
        }
        try {
            String str2 = this.i;
            int hashCode = str2.hashCode();
            if (hashCode == 96323) {
                if (str2.equals("aac")) {
                    if (c2 == 0) {
                    }
                }
                c2 = 65535;
                if (c2 == 0) {
                }
            } else if (hashCode != 108272) {
                if (hashCode == 110810 && str2.equals("pcm")) {
                    c2 = 2;
                    if (c2 == 0) {
                        return;
                    }
                    if (j) {
                        Log.d("AudioRecorderManager", "aac format init");
                    }
                    MediaCodecInfo d2 = d("audio/mp4a-latm");
                    MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i2, i);
                    createAudioFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, i3);
                    createAudioFormat.setInteger("aac-profile", 2);
                    createAudioFormat.setInteger("max-input-size", 102400);
                    if (d2 != null) {
                        MediaCodec createByCodecName = MediaCodec.createByCodecName(d2.getName());
                        this.f44228a = createByCodecName;
                        createByCodecName.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
                        this.f44228a.start();
                        this.f44229b = this.f44228a.getInputBuffers();
                        this.f44230c = this.f44228a.getOutputBuffers();
                        this.f44231d = new MediaCodec.BufferInfo();
                        return;
                    }
                    return;
                }
                c2 = 65535;
                if (c2 == 0) {
                }
            } else {
                if (str2.equals("mp3")) {
                    c2 = 1;
                    if (c2 == 0) {
                    }
                }
                c2 = 65535;
                if (c2 == 0) {
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        e2.printStackTrace();
    }

    public final int a(int i) {
        switch (i) {
            case 7350:
                return 12;
            case 11025:
                return 10;
            case 12000:
                return 9;
            case 16000:
                return 8;
            case 22050:
                return 7;
            case 24000:
                return 6;
            case 32000:
                return 5;
            case SwanAudioPlayer.DEFAULT_SAMPLE_RATE /* 44100 */:
                return 4;
            case 48000:
                return 3;
            case 64000:
                return 2;
            case 88200:
                return 1;
            case 96000:
                return 0;
            default:
                return 11;
        }
    }

    public final long b(long j2) {
        int i = this.f44234g;
        if (i == 0) {
            return 0L;
        }
        return (((j2 * 1000) * 90) * 1024) / i;
    }

    public final byte[] c(int i, int i2, int i3, int i4) {
        int i5 = i + 7;
        byte[] bArr = new byte[i5];
        int a2 = a(i3);
        bArr[0] = -1;
        bArr[1] = -15;
        bArr[2] = (byte) (((i2 - 1) << 6) + (a2 << 2) + (i4 >> 2));
        bArr[3] = (byte) (((i4 & 3) << 6) + (i5 >> 11));
        bArr[4] = (byte) ((i5 & 2047) >> 3);
        bArr[5] = (byte) (((i5 & 7) << 5) + 31);
        bArr[6] = -4;
        return bArr;
    }

    public final MediaCodecInfo d(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
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

    public final byte[] e(byte[] bArr) {
        if (this.f44228a != null && bArr != null) {
            if (j) {
                Log.d("AudioRecorderManager", "start AAC encode");
            }
            int dequeueInputBuffer = this.f44228a.dequeueInputBuffer(-1L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = this.f44229b[dequeueInputBuffer];
                byteBuffer.clear();
                try {
                    byteBuffer.put(bArr);
                    byteBuffer.limit(bArr.length);
                    this.f44228a.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, b(this.f44233f), 0);
                    this.f44233f++;
                } catch (IllegalArgumentException | BufferOverflowException e2) {
                    if (j) {
                        e2.printStackTrace();
                    }
                    return bArr;
                }
            }
            int dequeueOutputBuffer = this.f44228a.dequeueOutputBuffer(this.f44231d, 0L);
            while (dequeueOutputBuffer >= 0) {
                MediaCodec.BufferInfo bufferInfo = this.f44231d;
                int i = bufferInfo.size;
                ByteBuffer byteBuffer2 = this.f44230c[dequeueOutputBuffer];
                try {
                    byteBuffer2.position(bufferInfo.offset);
                    byteBuffer2.limit(this.f44231d.offset + i);
                    byte[] c2 = c(i, 2, this.f44234g, this.f44235h);
                    try {
                        byteBuffer2.get(c2, 7, i);
                        byteBuffer2.position(this.f44231d.offset);
                        this.f44232e.write(c2);
                        this.f44228a.releaseOutputBuffer(dequeueOutputBuffer, false);
                        dequeueOutputBuffer = this.f44228a.dequeueOutputBuffer(this.f44231d, 0L);
                    } catch (IOException | IllegalArgumentException | BufferUnderflowException e3) {
                        if (j) {
                            e3.printStackTrace();
                        }
                        return bArr;
                    }
                } catch (IllegalArgumentException e4) {
                    if (j) {
                        e4.printStackTrace();
                    }
                    return bArr;
                }
            }
            bArr = this.f44232e.toByteArray();
            try {
                this.f44232e.flush();
            } catch (IOException e5) {
                if (j) {
                    e5.printStackTrace();
                }
            }
            this.f44232e.reset();
        }
        return bArr;
    }

    public byte[] f(byte[] bArr) {
        if (this.f44228a != null && bArr != null) {
            String str = this.i;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 96323) {
                if (hashCode != 108272) {
                    if (hashCode == 110810 && str.equals("pcm")) {
                        c2 = 2;
                    }
                } else if (str.equals("mp3")) {
                    c2 = 1;
                }
            } else if (str.equals("aac")) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return bArr;
                }
                g(bArr);
                return bArr;
            }
            return e(bArr);
        }
        if (j) {
            Log.d("AudioRecorderManager", "wrong input or mediaCodec");
        }
        return bArr;
    }

    public final byte[] g(byte[] bArr) {
        return bArr;
    }
}
